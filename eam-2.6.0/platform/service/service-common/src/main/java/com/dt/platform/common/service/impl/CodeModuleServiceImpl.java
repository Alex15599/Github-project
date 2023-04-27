package com.dt.platform.common.service.impl;


import com.dt.platform.common.service.ICodeModuleService;
import com.dt.platform.constants.enums.common.CodeAttrTypeEnum;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.busi.id.SequenceType;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.spec.DBSequence;

import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.stereotype.Service;
import com.github.foxnic.api.transter.Result;
import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 编码分配属性 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-07 22:35:49
*/


@Service("CodeParseService")
public class CodeModuleServiceImpl implements ICodeModuleService {

	private Random rand;
	{
		try {
			rand = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }


	public Result generateCode2(String module){

		String v="${string_fix,1011}${string_fix,-}${string_fix,1011}${string_fix,-}${number_seq,5,1011_1011_asset}";
		return null;
	}



	@Override
	public Result generateCodeByRule(String rule) {
		Result result = new Result();
	//	rule="${string_fix,1011}${string_fix,-}${string_fix,1011}${string_fix,-}${number_seq,5,1011_1011_asset}";
		String code=parseCode(rule);
		Logger.info("generate code result:"+code);
		result.success(true);
		result.data(code);
		return result;
	}


	/**
	 * 获取业务编码
	 * @param module 传入业务编码模块
	 * @return 返回编号
	 * */
	@Override
	public Result generateCode(String module){
		Logger.info("generateCode:"+module);
		Rcd rs=dao.queryRecord("select b.rule rule from sys_code_allocation a,sys_code_rule b where a.rule_id=b.id and a.deleted=0 and b.deleted=0 and a.code=?",module);
		if(rs==null){
			return ErrorDesc.failure().message("资产编号不允许为 null 。");
		}
		String rule=rs.getString("rule");
		Logger.info("generateCode rule:"+rule);
		return generateCodeByRule(rule);
	}


	public static void main(String[] args) {
		String v="${org,ownOrgId}${org,ownOrgId}${string_fix,-}${busi,assetCategoryCode}${string_fix,-}${number_seq,5,asset}";

	}

	public Result generateCodeByData(String module,String ownOrgId,String pcmId){
		Logger.info("module:"+module+",ownerOrgId:"+ownOrgId+",pcmId:"+pcmId);
		Rcd rs=dao.queryRecord("select b.rule rule from sys_code_allocation a,sys_code_rule b where a.rule_id=b.id and a.deleted=0 and b.deleted=0 and a.code=?",module);
		if(rs==null){
			return ErrorDesc.failure().message("资产编号不允许为 null 。");
		}
		String rule=rs.getString("rule");
		String[] pharr=rule.split("\\$");
		String ruleRewrite="";
		String prefix="";
		for(int i=0;i< pharr.length;i++){
			String item=pharr[i];
			Logger.info("index:"+(i+1)+",item:"+item);
			if(StringUtil.isBlank(item)){
				continue;
			}
			if(item.contains("org,ownOrgCode")){
				if(StringUtil.isBlank(ownOrgId)){
					return ErrorDesc.failureMessage("当前归属公司ID为空,Id:"+ownOrgId);
				}
				Rcd orgRs=dao.queryRecord("select code,full_name from hrm_organization where id=?",ownOrgId);
				if(orgRs==null){
					return ErrorDesc.failureMessage("无该公司数据,Id:"+ownOrgId);
				}
				String code=orgRs.getString("code");
				if(StringUtil.isBlank(code)){
					return ErrorDesc.failureMessage("当前归属公司编码为空,Id:"+ownOrgId+",名称:"+orgRs.getString("full_name"));
				}
				prefix=prefix+code.trim()+"_";
				ruleRewrite=ruleRewrite+"$"+item.replace("org,ownOrgCode","string_fix,"+code);

			}else if(item.contains("pcm,pcmCode")){
				if(StringUtil.isBlank(pcmId)){
					return ErrorDesc.failureMessage("当前PCM ID为空,Id:"+pcmId);
				}
				Rcd pcmRs=dao.queryRecord("select code,name from pcm_catalog where id=?",pcmId);
				if(pcmRs==null){
					return ErrorDesc.failureMessage("无该PCM数据,id:"+pcmId);
				}
				if(StringUtil.isBlank(pcmRs.getString("code"))){
					return ErrorDesc.failureMessage("当前PCM编码为空,Id:"+pcmId+",名称:"+pcmRs.getString("name"));
				}
				String code=pcmRs.getString("code");
				prefix=prefix+code.trim()+"_";
				ruleRewrite=ruleRewrite+"$"+item.replace("pcm,pcmCode","string_fix,"+code);
			}else if(item.contains("number_seq_relation")){
				if(StringUtil.isBlank(prefix)){
					ruleRewrite=ruleRewrite+"$"+item;
				}else{
					ruleRewrite=ruleRewrite+"$"+item.replace("}",prefix+"}");
				}
			}else{
				ruleRewrite=ruleRewrite+"$"+item;
			}
		}
		Logger.info("generateCode rule:"+rule);
		Logger.info("generateCode rule rewrite:"+ruleRewrite);
		return generateCodeByRule(ruleRewrite);

	}

	/**
	 * 生成编码
	 * @param ph 传入占位符
	 * @return 返回编号
	 * */
	public String parseCode(String ph){
		String result="";
		String[] pharr=ph.split("\\$");
		Logger.info("parseCode value:"+ph);
		for(int i=0;i< pharr.length;i++){
			if(i>0){
				Logger.info("parseCode index:"+i+",value:"+pharr[i]);
				result=result+parsePlaceholder(pharr[i]);
			}
		}
		return result;
	}

	/**
	 * 解析占位符编码
	 * @param ph 传入占位符
	 * @return 返回编号
	 * */
	public String parsePlaceholder(String ph){

		String type=ph.replaceAll("\\{","").replaceAll("\\}","").split(",")[0];
		if(type.equals(CodeAttrTypeEnum.TIME.code())){
			return parseTime(ph);
		}else if (type.equals(CodeAttrTypeEnum.STRING_FIX.code())){
			return parseStringFix(ph);
		}else if (type.equals(CodeAttrTypeEnum.STRING_RAND.code())){
			return parseStringRand(ph);
		}else if (type.equals(CodeAttrTypeEnum.NUMBER_RAND.code())){
			return parseNumberRand(ph);
		}else if (type.equals(CodeAttrTypeEnum.NUMBER_SEQ.code())){
			return parseNumberSeq(ph);
		}else if (type.equals(CodeAttrTypeEnum.NUMBER_SEQ_RELATION.code())){
			return parseNumberSeqRelation(ph);
		}else if (type.equals(CodeAttrTypeEnum.ORG.code())){
			//正常前面已转
			return "";
		}else if (type.equals(CodeAttrTypeEnum.PCM_CODE.code())){
			//正常前面已转
			return "";
		}
		return null;
	}

	/**
	 * 解析时间占位符
	 * @param ph 传入占位符
	 * @return 返回编号
	 * */
	public String parseTime(String ph){
		String timeNow = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS").format(Calendar.getInstance().getTime());
		String [] timeArr=timeNow.split("-");
		String year=timeArr[0];
		String month=timeArr[1];
		String day=timeArr[2];
		String hour=timeArr[3];
		String mins=timeArr[4];
		String second=timeArr[4];
//		if(ph==null){
//			return "";
//		}
		return ph.replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",yyyy\\}",year)
				.replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",mm\\}",month)
				.replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",dd\\}",day)
				.replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",hh\\}",hour)
				.replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",mm\\}",mins)
				.replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",ss\\}",second);
	}

	/**
	 * 解析字符串占位符
	 * @param ph 传入占位符
	 * @return 返回编号
	 * */
	public String parseStringFix(String ph){
		return ph.replaceAll("\\{"+CodeAttrTypeEnum.STRING_FIX.code() +",","")
				.replaceAll("\\}","").trim();
	}


	/**
	 * 按照指定长度生成字符串
	 * @param length 长度
	 * @return 返回随时资产负债
	 * */
	public String getRandomString(int length){
		String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<length;i++){
			int number=this.rand.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 解析字符串占位符
	 * @param ph 传入占位符
	 * @return 返回编号
	 * */
	public String parseStringRand(String ph){
		int phLength=1;
		String[] attr=ph.replaceAll("\\{","").replaceAll("\\}","").split(",");
		if(attr.length>=2){
			phLength=Integer.valueOf(attr[1]);
		}
		return getRandomString(phLength).toUpperCase();
	}

	/**
	 * 解析数字类型占位符
	 * @param ph 传入占位符
	 * @return 返回编号
	 * */
	public String parseNumberRand(String ph){
		int phLength=1;
		String[] attr=ph.replaceAll("\\{","").replaceAll("\\}","").split(",");
		if(attr.length>=2){
			phLength=Integer.valueOf(attr[1]);
		}
		return String.valueOf((int)((Math.random()*9+1)*Math.pow(10,phLength-1)));
	}

	/**
	 * 解析数字类型占位符
	 * @param ph 传入占位符
	 * @return 返回编号
	 * */
	public String parseNumberSeq(String ph){
		String seqSource="default";
		int phLength=0;
		String[] attr=ph.replaceAll("\\{","").replaceAll("\\}","").split(",");
		for(int i=0;i<attr.length;i++){
			if(i==1){
				phLength=Integer.valueOf(attr[i]);
			}else if(i==2){
				seqSource=attr[i];
			}
		}
		DBSequence seq=dao.getSequence(seqSource);
		if(!seq.exists()){
			seq.create(SequenceType.AI,phLength);
		}
		return seq.next();
	}

	public String parseNumberSeqRelation(String ph){
		String seqSource="default";
		int phLength=0;
		String[] attr=ph.replaceAll("\\{","").replaceAll("\\}","").split(",");
		for(int i=0;i<attr.length;i++){
			if(i==1){
				phLength=Integer.valueOf(attr[i]);
			}else if(i==2){
				seqSource=attr[i];
			}
		}
		DBSequence seq=dao.getSequence(seqSource);
		if(!seq.exists()){
			seq.create(SequenceType.AI,phLength);
		}
		return seq.next();
	}

}