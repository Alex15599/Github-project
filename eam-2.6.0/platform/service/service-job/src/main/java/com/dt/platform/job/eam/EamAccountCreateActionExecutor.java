package com.dt.platform.job.eam;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.common.AutoModuleIDEnum;
import com.dt.platform.constants.enums.common.AutoModuleRoleTypeEnum;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.Insert;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecutor;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.UserVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import javax.annotation.Resource;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class EamAccountCreateActionExecutor implements JobExecutor {

    @Override
    public String getName() {
        return "EamAccountCreateExecutor";
    }
    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;


    @Override
    public Result execute(Object context, Job job, JSONObject jsonObject) {

        Logger.info("用户新建后,相关赋权操作");
        JobExecutionContext ctx=(JobExecutionContext) context;

        Long pid=Instant.now().toEpochMilli();
        Logger.info("####### 检查功能角色 #######");
        autoGrantUserRole(AutoModuleIDEnum.EAM_ROLE.code());

        Logger.info("####### 检查数据权限 #######");
        autoGrantUserRole(AutoModuleIDEnum.EAM_DATA_ROLE.code());

        Logger.info("新用户数据权限检查操作完毕");

        return ErrorDesc.success();

    }



    public Result autoGrantUserRole(String id){

        Rcd moduleRs=dao.queryRecord("select * from sys_auto_module_role where deleted=0 and id=?",id);
        if(moduleRs==null){
            Logger.info("未找到配置ID:"+id);
            return ErrorDesc.failureMessage("未找到配置ID:"+id);
        }
        String status=moduleRs.getString("status");
        String module=moduleRs.getString("module");
        String type=moduleRs.getString("type");
        if(!StatusEnableEnum.ENABLE.code().equals(status)){
            Logger.info("配置ID:"+id+",状态:"+status);
            return ErrorDesc.failureMessage("配置ID:"+id+",状态:"+status);
        }
        RcdSet roleRs=dao.query("select * from sys_auto_module_role_item where deleted=0 and module_role_id=?",id);
        if(roleRs==null||roleRs.size()==0){
            Logger.info("配置ID:"+id+",角色数量为0");
            return ErrorDesc.failureMessage("配置ID:"+id+",角色数量为0");
        }
        Logger.info("module:"+module+",type:"+type);
        String sql="select c.id user_id,c.real_name, a.id employee_id,c.create_time \n" +
                "from hrm_employee a,sys_user_tenant b,sys_user c \n" +
                "where a.id=b.employee_id and c.id=b.user_id\n" +
                "and c.account not in (select account from sys_auto_user_predefined where deleted=0) \n"+
                "and a.deleted=0\n" +
                "and b.deleted=0\n" +
                "and c.deleted=0";
        //sys_auto_role_grant_rcd 只要判断上次处理的时间进行比较即可
        String userSql=sql+" and c.create_time>(select ifnull(max(create_time),str_to_date('19700101','%Y%m%d')) from sys_auto_role_grant_rcd where deleted=0 and module_role_id=?) ";
        RcdSet userRs=dao.query(userSql,id);
        if(userRs==null&&userRs.size()==0) {
            return ErrorDesc.failureMessage("没有匹配的用户");
        }
        if(AutoModuleRoleTypeEnum.ROLE.code().equals(type)){
            //需要插入功能角色的用户
            for(int i=0;i<userRs.size();i++) {
                String userId = userRs.getRcd(i).getString("user_id");
                List<String> roleIds=new ArrayList<String>();
                for (int j = 0; j < roleRs.size(); j++) {
                    String roleId = roleRs.getRcd(j).getString("role_id");
                    Logger.info("process user role,userId:" + userId + ",roleId;" + roleId);
                    if (dao.queryRecord("select 1 from sys_role_user where deleted=0 and user_id=? and role_id=?", userId, roleId) == null) {
                        Insert insRcd = new Insert("sys_auto_role_grant_rcd");
                        insRcd.set("id", IDGenerator.getSnowflakeIdString());
                        insRcd.set("module_role_id", id);
                        insRcd.set("user_id", userId);
                        insRcd.set("role_id", roleId);
                        insRcd.set("create_time", new Date());
                        dao.execute(insRcd.getSQL());
                        roleIds.add(roleId);
                        Logger.info("process user role,userId:" + userId + ",roleId;" + roleId + " pre insert");
                    } else {
                        Logger.info("process user role,userId:" + userId + ",roleId;" + roleId + " already exist");
                    }
                }
                //开始插入权限
                RcdSet existRoleRs=dao.query("select role_id from sys_role_user where deleted=0 and user_id=?",userId);
                if(existRoleRs!=null&&existRoleRs.size()>0){
                    for(Rcd rcd:existRoleRs){
                        roleIds.add(rcd.getString("role_id"));
                    }
                }
                if(roleIds.size()>0){
                    User user= UserServiceProxy.api().getById(userId).data();
                    UserVO vo= EntityContext.create(UserVO.class,user);
                    Object[] ids=roleIds.toArray();
                    String[] idsStr=new String[ids.length];
                    for(int m=0;m<ids.length;m++){
                        idsStr[m]=ids[m].toString();
                    }
                    vo.addRoleId(idsStr);
                    UserServiceProxy.api().update(vo);
                }
            }
                    //用户处理结束
        }else if(AutoModuleRoleTypeEnum.BUSI_ROLE.code().equals(type)) {
            for(int i=0;i<userRs.size();i++) {
                String employeeId = userRs.getRcd(i).getString("employee_id");
                for (int j = 0; j < roleRs.size(); j++) {
                    String roleId = roleRs.getRcd(j).getString("role_id");
                    Logger.info("process user role,employeeId:" + employeeId + ",roleId;" + roleId);
                    if (dao.queryRecord("select 1 from sys_busi_role_member where member_type='employee' and  member_id=? and role_id=?", employeeId, roleId) == null) {
                        //插入用户
                        Insert ins = new Insert("sys_busi_role_member");
                        ins.set("id", IDGenerator.getSnowflakeIdString());
                        ins.set("member_id", employeeId);
                        ins.set("role_id", roleId);
                        ins.set("member_type", "employee");
                        ins.set("create_time", new Date());
                        dao.execute(ins.getSQL());
                        Insert insRcd = new Insert("sys_auto_role_grant_rcd");
                        insRcd.set("id", IDGenerator.getSnowflakeIdString());
                        insRcd.set("module_role_id", id);
                        insRcd.set("user_id", employeeId);
                        insRcd.set("role_id", roleId);
                        insRcd.set("create_time", new Date());
                        dao.execute(insRcd.getSQL());
                        Logger.info("process user role,employeeId:" + employeeId + ",roleId;" + roleId + " insert success");
                    } else {
                        Logger.info("process user role,employeeId:" + employeeId + ",roleId;" + roleId + " already exist");
                    }
                }
            }
        }
        return ErrorDesc.success();
    }
}
