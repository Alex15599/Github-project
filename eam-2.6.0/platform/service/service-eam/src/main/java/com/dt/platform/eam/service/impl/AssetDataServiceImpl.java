package com.dt.platform.eam.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.datacenter.Rack;
import com.dt.platform.domain.datacenter.RackVO;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.service.*;

import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.dt.platform.proxy.datacenter.RackServiceProxy;
import com.dt.platform.proxy.eam.AssetRackServiceProxy;
import com.dt.platform.proxy.eam.OperateServiceProxy;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.mysql.jdbc.log.Log;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.domain.pcm.*;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DictItemVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.github.foxnic.web.proxy.hrm.OrganizationServiceProxy;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.github.foxnic.web.proxy.pcm.PcmCatalogDelegate;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("EamAssetDataService")
public class AssetDataServiceImpl  extends SuperService<Asset> implements IAssetDataService {


    @Autowired
    private IAssetService assetService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IAssetStatusService assetStatusService;

    @Autowired
    private IWarehouseService warehouseService;

    @Autowired
    private IMaintainerService maintainerService;

    @Autowired
    private IManufacturerService manufacturerService;

    @Autowired
    private ISupplierService supplierService;

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private ICategoryFinanceService categoryFinanceService;

    @Autowired
    private IAssetLabelService assetLabelService;

    @Autowired
    private IAssetLabelTplService assetLabelTplService;


    @Autowired
    AssetPrintLabelFactory assetPrintLabelFactory;
    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    /**
     * 获得 DAO 对象
     * */
    public DAO dao() { return dao; }

    @Override
    public <T> Map<T, ReferCause> hasRefers(List<T> list) {
        return null;
    }


    @Override
    public String queryPcmIdByCode(String code){
        String res="";
        CatalogVO voGId=new CatalogVO();
        voGId.setCode(code);
        Result<List<Catalog>> vgGidRes=CatalogServiceProxy.api().queryList(voGId);
        if(vgGidRes.isSuccess()){
            List<Catalog> vgGidList=vgGidRes.getData();
            if(vgGidList.size()>0){
                res=vgGidList.get(0).getId();
            }
        }
        Logger.info("queryPcmIdByCode|result:"+res);
        return res;
    }


    @Override
    public PagedList<Asset> queryAssetPagedList(List<String> ids, AssetVO asset) {
        if(StringUtil.isBlank(asset.getOwnerCode())){
            asset.setOwnerCode(AssetOwnerCodeEnum.ASSET.code());
        }
        return assetService.queryPagedList(asset,asset.getPageSize(),asset.getPageIndex());
    }


    @Override
    public List<Asset> queryAssetList(List<String> ids, AssetVO asset) {
        if(StringUtil.isBlank(asset.getOwnerCode())){
            asset.setOwnerCode(AssetOwnerCodeEnum.ASSET.code());
        }
        PagedList<Asset> pageList= assetService.queryPagedList(asset,10000000,0);
        return pageList.getList();
    }



    @Override
    public String queryMapKeyByValue(HashMap<String,String> map, String value){
        String key = null;
        //Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
        for(String getKey: map.keySet()){
            if(map.get(getKey).equals(value)){
                key = getKey;
                return key;
            }
        }
        return key;
    }



    @Override
    public Result<JSONObject> queryAssetLuckySheet(String oper,int row,String handleId) {
        if(row<10){
            row=60;
        }
        List<Map<String, Object>> mapList=null;
        if(!StringUtil.isBlank(handleId)){
            List<String> assetIdsList=dao.query("select * from eam_asset_item where deleted=0 and handle_id=?",handleId).getValueList("asset_id",String.class);
            if(assetIdsList!=null&&assetIdsList.size()>0){
                ConditionExpr expr=new ConditionExpr();
                expr.andIn("id",assetIdsList);
                List<Asset> assetList=assetService.queryList(expr);
                if(assetList.size()>row){
                    row=assetList.size()+1;
                }
                if(assetList!=null&&assetList.size()>0){
                    Map<String,Object> map=queryAssetMap(assetList,null);
                    mapList= (List<Map<String, Object>>) map.get("dataList");
                }
            }
        }

        List<AssetLuckySheetColumnMeta> list= queryExcelMetaData(oper);
        JSONObject dataVerification=queryLuckyExcelDataDataVerification(list,row-1);
        JSONObject configObj=fillExcelData(list,mapList);
        Result<JSONObject> res=new Result<>();
        JSONObject resData=new JSONObject();
        resData.put("name","资产");
        resData.put("index","Sheet_"+IDGenerator.getSnowflakeIdString());
        resData.put("row",row);
        resData.put("column",list.size());
        JSONObject frozen=new JSONObject();
        frozen.put("type","row");
        resData.put("frozen",frozen);
        resData.put("celldata",configObj.getJSONArray("celldata"));
        resData.put("dataVerification",dataVerification);
        res.data(resData);
        return res;
    }

    private JSONObject queryLuckyExcelDataDataVerification(List<AssetLuckySheetColumnMeta> list,int row){
        JSONObject data=new JSONObject();
        for(AssetLuckySheetColumnMeta assetLuckySheetColumnMeta:list){
            int columnNumber=assetLuckySheetColumnMeta.getColNumber();
            if(assetLuckySheetColumnMeta.getDataVerification()!=null){
                for(int i=1;i<row;i++){
                    String key=i+"_"+columnNumber;
                    data.put(key,assetLuckySheetColumnMeta.getDataVerification());
                }
            }
        }
        return data;
    }


    private JSONObject fillExcelData(List<AssetLuckySheetColumnMeta> assetColumnMetaList,List<Map<String, Object>> mapList){
         JSONArray cellData=new JSONArray();
         JSONObject res=new JSONObject();
         boolean dataFill=false;
         if(mapList!=null&&mapList.size()>0){
             dataFill=true;
         }
         String sql="select b.code,a.required from eam_asset_attribute_item a,eam_asset_attribute b \n" +
                 "where a.attribute_id=b.id \n" +
                 "and a.owner_code='"+AssetAttributeItemOwnerEnum.ASSET_ONLINE_EXCEL.code()+"'\n" +
                 "and a.deleted=0 \n" +
                 "and b.deleted=0 ";
        Map<String,String> colMap= this.dao.query(sql).getValueMap("code",String.class,"required",String.class);
        for(int i=0;i<assetColumnMetaList.size();i++){
            AssetLuckySheetColumnMeta assetColumnMeta=assetColumnMetaList.get(i);
            Logger.info("assetColumnMeta:"+assetColumnMeta.getCol());
            JSONObject col=new JSONObject();
            col.put("r",0);
            col.put("c",i);
            JSONObject value=new JSONObject();
            value.put("bl",1);
            value.put("m",assetColumnMeta.getColName());
            value.put("v",assetColumnMeta.getColName());
            //必选字段颜色
            CodeTextEnum enumValue=EnumUtil.parseByCode(AssetDataExportColumnEnum.class,assetColumnMeta.getCol());
            if(enumValue!=null){
                if(colMap.containsKey(enumValue.text())){
                   if( "1".equals(colMap.getOrDefault(enumValue.text(),"-1"))){
                       value.put("fc","#ff00ff");
                   }
                }
            }
//            if(assetColumnMeta.getDataVerification()!=null){
//                value.put("fc","#ff00ff");
//            }

            JSONObject ct=new JSONObject();
            System.out.println("1212"+assetColumnMeta.getValueFormat()+"1161616");
            ct.put("fa",assetColumnMeta.getValueFormat());
            ct.put("t",assetColumnMeta.getValueType());
            value.put("ct",ct);
            col.put("v",value);
            cellData.add(col);
        }

        if(dataFill){
             for(int j=0;j<mapList.size();j++){
                 Map<String, Object> map=mapList.get(j);
                 for(int i=0;i<assetColumnMetaList.size();i++){
                     JSONObject col=new JSONObject();
                     AssetLuckySheetColumnMeta assetColumnMeta=assetColumnMetaList.get(i);
                     col.put("r",j+1);
                     col.put("c",i);
                     JSONObject value=new JSONObject();
                     value.put("bl",0);
                     if(map.containsKey(assetColumnMeta.getCol())){
                         value.put("m",map.get(assetColumnMeta.getCol()));
                         value.put("v",map.get(assetColumnMeta.getCol()));
                     }else{
                         value.put("m","");
                         value.put("v","");
                     }
                     //必选字段颜色
                     CodeTextEnum enumValue=EnumUtil.parseByCode(AssetDataExportColumnEnum.class,assetColumnMeta.getCol());
                     if(enumValue!=null){
                         if(colMap.containsKey(enumValue.text())){
                             if( "1".equals(colMap.getOrDefault(enumValue.text(),"-1"))){
                                 value.put("fc","#ff00ff");
                             }
                         }
                     }
                     JSONObject ct=new JSONObject();
                     System.out.println("1515"+assetColumnMeta.getValueFormat()+"1161616");
                     ct.put("fa",assetColumnMeta.getValueFormat());
                     ct.put("t",assetColumnMeta.getValueType());
                     value.put("ct",ct);
                     col.put("v",value);
                     cellData.add(col);
                 }
             }
        }
         res.put("celldata",cellData);
        return res;
    }


    public List<AssetLuckySheetColumnMeta> queryExcelMetaData(String oper){
        List<AssetLuckySheetColumnMeta> list=new ArrayList<>();
        InputStream inputStream= TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_BATCH_UPLOAD_ASSET.code());
        ExcelStructure es=new ExcelStructure();
        //	es.setDataColumnBegin(0);
        es.setDataRowBegin(2);
        Short lastNum=0;
        //从模板获取属性
        Workbook workbook;
        if ( inputStream != null) {
            try {
                workbook = WorkbookFactory.create(inputStream);
                Sheet sheet=workbook.getSheetAt(0);
                Row firstRow=sheet.getRow(0);
                Row secondRow=sheet.getRow(1);
                String charIndex="";
                Logger.debug("row:"+secondRow.getLastCellNum());
                for(int i=0;i<secondRow.getLastCellNum();i++){
                    AssetLuckySheetColumnMeta metaData=new AssetLuckySheetColumnMeta();
                    String firstAssetColumn=firstRow.getCell(i).toString();
                    String secondAssetColumn=secondRow.getCell(i).toString().replaceFirst("\\{\\{\\$fe:","")
                            .replaceFirst("dataList","")
                            .replaceFirst("}}","")
                            .replaceFirst("t.","").trim();

                    metaData.setRowNumber(0);
                    metaData.setColNumber(i);
                    metaData.setColName(firstAssetColumn);
                    metaData.setCol(secondAssetColumn);
                    metaData.setValueType("g/n");
                    metaData.setValueFormat("General");
                    JSONObject dataVer=new JSONObject();
                    JSONObject dataVerification=null;
                    dataVer.put("type",null);
                    dataVer.put("type2",null);
                    dataVer.put("value1","");
                    dataVer.put("value2",null);
                    dataVer.put("checked",false);
                    dataVer.put("remote",false);
                    dataVer.put("prohibitInput",false);
                    dataVer.put("hintShow",false);
                    dataVer.put("hintText","");
                    System.out.println("secondAssetColumn:"+secondAssetColumn);
                    if("name".equals(secondAssetColumn)||
                            "id".equals(secondAssetColumn)||
                            "model".equals(secondAssetColumn)||
                            "unit".equals(secondAssetColumn)||
                            "purpose".equals(secondAssetColumn)||
                            "rfid".equals(secondAssetColumn)||
                            "contacts".equals(secondAssetColumn)||
                            "contact_information".equals(secondAssetColumn)||
                            "director".equals(secondAssetColumn)||
                            "label1".equals(secondAssetColumn)||
                            "label2".equals(secondAssetColumn)||
                            "label3".equals(secondAssetColumn)||
                            "label4".equals(secondAssetColumn)||
                            "label5".equals(secondAssetColumn)||
                            "maintenance_notes".equals(secondAssetColumn)||
                            "customer_info".equals(secondAssetColumn)||
                            "assetNotes".equals(secondAssetColumn)||
                            "serialNumber".equals(secondAssetColumn)){
                        //文本
                        metaData.setValueFormat("@");
                        metaData.setValueType("s");
                    }else if ("assetNumber".equals(secondAssetColumn)||
                            "remainNumber".equals(secondAssetColumn)||
                            "rackUpNumber".equals(secondAssetColumn)||
                            "rackDownNumber".equals(secondAssetColumn)||
                            "equipmentCpu".equals(secondAssetColumn)||
                            "equipmentMemory".equals(secondAssetColumn)
                    ){
                        dataVer.put("type","number");
                        dataVer.put("type2","bw");
                        dataVer.put("value1","1");
                        dataVer.put("value2","100000");
                        dataVer.put("prohibitInput",true);
                        metaData.setValueFormat("0");
                        metaData.setValueType("n");
                        dataVerification=dataVer;

                    }else if ("assetStatusName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        List<String> value=this.dao.query("select name from eam_asset_status where deleted=0" ).getValueList("name",String.class);
                        dataVer.put("value1",  String.join(",", value));
                        dataVerification=dataVer;
                    }else if("serviceLife".equals(secondAssetColumn)){
                        dataVer.put("type","number");
                        dataVer.put("type2","bw");
                        dataVer.put("value1","1");
                        dataVer.put("value2","1000");
                        dataVer.put("prohibitInput",true);
                        dataVerification=dataVer;
                        metaData.setValueFormat("0.00");
                        metaData.setValueType("n");
                    }else if("productionDate".equals(secondAssetColumn)||
                            "maintenanceStartDate".equals(secondAssetColumn)||
                            "maintenanceEndDate".equals(secondAssetColumn)||
                            "purchaseDate".equals(secondAssetColumn)||
                            "registerDate".equals(secondAssetColumn)||
                            "lastVerificationDate".equals(secondAssetColumn)
                    ){
                        dataVer.put("type","date");
                        dataVer.put("type2","bw");
                        dataVer.put("value1","1979-01-01");
                        dataVer.put("value2","2600-01-01");
                        dataVer.put("prohibitInput",true);
                        metaData.setValueFormat("yyyy-MM-dd");
                        metaData.setValueType("d");
                        dataVerification=dataVer;
                    }else if(
                                      "maintenancePrice".equals(secondAssetColumn)||
                                    "totalAmountPrice".equals(secondAssetColumn)||
                                    "purchaseUnitPrice".equals(secondAssetColumn)||
                                    "originalUnitPrice".equals(secondAssetColumn)||
                                    "navPrice".equals(secondAssetColumn)||
                                    "assetUsedServiceLife".equals(secondAssetColumn)||
                                    "taxAmountRate".equals(secondAssetColumn)||
                                    "taxAmountPrice".equals(secondAssetColumn)
                      ){
                        dataVer.put("type","number");
                        dataVer.put("type2","bw");
                        dataVer.put("value1","1");
                        dataVer.put("value2","10000000");
                        dataVer.put("prohibitInput",true);
                        dataVerification=dataVer;
                        metaData.setValueFormat("0.00");
                        metaData.setValueType("n");
                    }else if("assetSourceName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        List<String> value=this.dao.query("select label from sys_dict_item where deleted=0 and dict_code='eam_source'" ).getValueList("label",String.class);
                        dataVer.put("value1",  String.join(",", value));
                        dataVerification=dataVer;
                    }else if("assetPositionName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        List<String> value=this.dao.query("select hierarchy_name from eam_position where deleted=0" ).getValueList("hierarchy_name",String.class);
                        dataVer.put("value1",  String.join(",", value));
                        dataVerification=dataVer;
                    }else if("assetSupplierName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        List<String> value=this.dao.query("select supplier_name from eam_supplier where deleted=0" ).getValueList("supplier_name",String.class);
                        dataVer.put("value1",  String.join(",", value));
                        dataVerification=dataVer;
                    }else if("maintainerName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        List<String> value=this.dao.query("select maintainer_name from eam_maintainer where deleted=0" ).getValueList("maintainer_name",String.class);
                        dataVer.put("value1",  String.join(",", value));
                        dataVerification=dataVer;
                    }else if("maintenanceStatusName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        List<String> value=this.dao.query("select label from sys_dict_item where deleted=0 and dict_code='eam_maintenance_status'" ).getValueList("label",String.class);
                        dataVer.put("value1",  String.join(",", value));
                        dataVerification=dataVer;
                    }else if("equipmentEnvironmentName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        List<String> value=this.dao.query("select label from sys_dict_item where deleted=0 and dict_code='eam_equipment_environment'" ).getValueList("label",String.class);
                        dataVer.put("value1",  String.join(",", value));
                        dataVerification=dataVer;
                    }else if("suggestMaintenanceMethodName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        List<String> value=this.dao.query("select label from sys_dict_item where deleted=0 and dict_code='eam_suggest_maintenance_method'" ).getValueList("label",String.class);
                        dataVer.put("value1",  String.join(",", value));
                        dataVerification=dataVer;
                    }else if("assetManufacturerName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        List<String> value=this.dao.query("select manufacturer_name from eam_manufacturer where deleted=0" ).getValueList("manufacturer_name",String.class);
                        dataVer.put("value1",  String.join(",", value));
                        dataVerification=dataVer;
                    }else if("assetCategoryFinanceName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        List<String> value=this.dao.query("select hierarchy_name from eam_category_finance where deleted=0" ).getValueList("hierarchy_name",String.class);
                        dataVer.put("value1",  String.join(",", value));
                        dataVerification=dataVer;
                    }else if("assetCategoryName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        HashMap<String,String> catalogMap = queryAssetCategoryNodes("all");
                        List<String> values = new ArrayList(catalogMap.values());
                        Collections.sort(values);
                        dataVer.put("value1",  String.join(",", values));
                        dataVerification=dataVer;
                    }else if("ownCompanyName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        HashMap<String,String> compMap = queryOrganizationNodes("comp");
                        List values = new ArrayList(compMap.values());
                        Collections.sort(values);
                        dataVer.put("value1",  String.join(",", values));
                        dataVerification=dataVer;
                    }else if("useOrganizationName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        HashMap<String,String> orgMap = queryOrganizationNodes("org");
                        List values = new ArrayList(orgMap.values());
                        Collections.sort(values);
                        dataVer.put("value1",  String.join(",", values));
                        dataVerification=dataVer;
                    }else if("safetyLevelName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        List<String> value=this.dao.query("select label from sys_dict_item where deleted=0 and dict_code='eam_safety_level'" ).getValueList("label",String.class);
                        dataVer.put("value1",  String.join(",", value));
                        dataVerification=dataVer;
                    }
                    else if("expenseItemName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        List<String> value=this.dao.query("select label from sys_dict_item where deleted=0 and dict_code='eam_expense_items'" ).getValueList("label",String.class);
                        dataVer.put("value1",  String.join(",", value));
                        dataVerification=dataVer;
                    }
                    else if("financialOptionName".equals(secondAssetColumn)){
                        dataVer.put("prohibitInput",true);
                        dataVer.put("type","dropdown");
                        List<String> value=this.dao.query("select label from sys_dict_item where deleted=0 and dict_code='eam_financial_options'" ).getValueList("label",String.class);
                        dataVer.put("value1",  String.join(",", value));
                        dataVerification=dataVer;
                    }
                    if(dataVerification!=null){
                        metaData.setDataVerification(dataVerification);
                    }
                    Logger.info("metaData"+metaData);
                    list.add(metaData);
                }
                //追加自定义属性部分
            } catch (Exception e) {
                Logger.debug("Excel 读取错误", e);
            }
        }

        return list;
    }

    @Override
    public Result importAssetByLuckySheet(String ownerCode,String content,String selectedCode) {
        Workbook wb = null;
        OutputStream out = null;
        String path = System.getProperty("java.io.tmpdir");
        File tempFile = new File(path +File.separator+ IDGenerator.getSnowflakeIdString()+".xls");
        try {
            wb = new HSSFWorkbook();
            Sheet sheet = wb.createSheet("数据");
            sheet.setColumnWidth(0, 18 * 256);
            sheet.setColumnWidth(1, 18 * 256);
//            Row r = sheet.createRow(0);
//            r.createCell(0).setCellValue("ip");
            JSONArray ctArr=JSONArray.parseArray(content);
            for(int i=0;i<ctArr.size();i++){
                JSONArray valueArr=ctArr.getJSONArray(i);
                //验证第二行是否输入
                if(valueArr==null){
                    break;
                }
                JSONObject vObj=valueArr.getJSONObject(1);
                if(vObj==null||vObj.getString("m")==null||"".equals(vObj.getString("m"))){
                    break;
                }
                Row r = sheet.createRow(i);
                for(int j=0;j<valueArr.size();j++){
                    JSONObject valueObj=valueArr.getJSONObject(j);
                    if(valueObj!=null){
                        r.createCell(j).setCellValue(valueObj.getString("m"));
                        Logger.info("out:"+valueObj.getString("m"));
                    }
                }
            }
            out = new FileOutputStream(tempFile);
            //获取inputStream
            wb.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(out!=null){
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        boolean dataFill=false;
        Result dataFillResult= OperateServiceProxy.api().queryAssetDirectUpdateMode();
        if(dataFillResult.isSuccess()){
            dataFill=(boolean)dataFillResult.getData();
        }
        FileInputStream input=null;
        try {
            input=new FileInputStream(tempFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<ValidateResult> errors=assetService.importExcel(input,0,true, ownerCode, true,AssetOperateEnum.EAM_BATCH_UPLOAD_ASSET.code(),selectedCode);

        if(errors==null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            Logger.info("import Result:");
            String msg="导入失败";
            for(int i=0;i<errors.size();i++){
                Logger.info(i+":"+errors.get(i).message);
                msg=errors.get(i).message;
            }
            return ErrorDesc.failure().message(msg).data(errors);
        }
    }

    //type:all,org,part,
    @Override
    public HashMap<String,String> queryOrganizationNodes(String type){
        //id name
        HashMap<String,String> map=new HashMap<String,String>();
        OrganizationVO vo=new OrganizationVO();
        vo.setIsLoadAllDescendants(1);
        if(!StringUtil.isBlank(type)){
         //   vo.setTargetType(type);
        }
        vo.setTenantId(SessionUser.getCurrent().getActivatedTenantId());
        Result r= OrganizationServiceProxy.api().queryNodesFlatten(vo);
        if(r.isSuccess()){
            List<ZTreeNode> list= (List<ZTreeNode> )r.getData();
            for( ZTreeNode node:list){
                if("com".equals(type)){
                    if("com".equals(node.getType())){
                        Logger.info("add");
                    }else{
                        continue;
                    }
                }else if("org".equals(type)){
                    if("com".equals(node.getType()) || "dept".equals(node.getType())){
                        Logger.info("add");
                    }else{
                        continue;
                    }
                }
                String path="";
                for(int j=0;j<node.getNamePathArray().size();j++){
                    if(j==0){
                        path=node.getNamePathArray().get(j);
                    }else{
                        path=path+"/"+node.getNamePathArray().get(j);
                    }
                }
                Logger.info("node:"+node.getId()+",path:"+path+"type:"+node.getType());
                map.put(node.getId(),path);
            }
        }
        return map;
    }

    @Override
    public Result pdfPrint(List<Asset> assetList) {

        String uuid=IDGenerator.getSnowflakeIdString();
        AssetLabel label=assetLabelService.queryAssetLabel();
        Map<String,Object> map=queryAssetMap(assetList,null);
        List<Map<String, Object>> mapList= (List<Map<String, Object>>) map.get("dataList");
        AssetLabelPrint printData=new AssetLabelPrint();
        printData.setLabel(label);
        printData.setUuid(uuid);
        printData.setLabelTpl(label.getAssetTpl());
        printData.setLabel(label);
        AssetLabelTpl assetLabelTpl=label.getAssetTpl();
        assetLabelService.dao().fill(assetLabelTpl).with(AssetLabelTplMeta.ASSET_LABEL_LAYOUT_LIST).execute();
        printData.setAssetLabelLayoutList(assetLabelTpl.getAssetLabelLayoutList());
        printData.setAssetColumnList(label.getAssetLabelColumnList());
        printData.setAssetData(mapList);
        printData.setPageSizeHeight(Float.parseFloat(label.getAssetPaper().getH().toString()));
        printData.setPageSizeWidth(Float.parseFloat(label.getAssetPaper().getW().toString()));
        String code=label.getAssetPaper().getActionCode();
        AsseLabelPrintCodeEnum codeEnum = null;
        if(AsseLabelPrintCodeEnum.NORMAL.code().equals(code)){
            codeEnum = AsseLabelPrintCodeEnum.NORMAL;
        }
        if(AsseLabelPrintCodeEnum.SPECIAL.code().equals(code)){
            codeEnum = AsseLabelPrintCodeEnum.SPECIAL;
        }
        Result printResult=assetPrintLabelFactory.getService(codeEnum).print(printData);
        return  ErrorDesc.success().data(uuid);
    }


    //all,ownerCode
    @Override
    public HashMap<String,String> queryAssetCategoryNodes(String type){
        //所有分类转换成  id + 全路径名称
        HashMap<String,String> map=new HashMap<>();
        CatalogVO voGId=new CatalogVO();
        voGId.setCode(AssetPcmCodeEnum.ASSET.code());
        Result<List<Catalog>> vgGidRes=CatalogServiceProxy.api().queryList(voGId);
        if(!vgGidRes.isSuccess()){
            return map;
        }
        List<Catalog> vgGidList=vgGidRes.getData();
        if(vgGidList.size()!=1){
            return map;
        }
        String rootId= vgGidList.get(0).getId();
        PcmCatalogDelegate delegate=new PcmCatalogDelegate(rootId);
        Result r = delegate.queryNodesFlatten(true,true);
        if(r.isSuccess()){
            List<ZTreeNode> list= (List<ZTreeNode> )r.getData();
            for( ZTreeNode node:list){
                String path="";
                for(int j=0;j<node.getNamePathArray().size();j++){
                    if(j==0){
                        path=node.getNamePathArray().get(j);
                    }else{
                        path=path+"/"+node.getNamePathArray().get(j);
                    }
                }
                Logger.info("id:"+node.getId()+","+path+","+node.getHierarchy());
                if(node.getHierarchy().startsWith(rootId)){
                    map.put(node.getId(),path);
                }
            }
        }

        return map;
    }



    @Override
    public HashMap<String,String> queryDictItemDataByDictCode(String dictCode){
        HashMap<String,String> map=new HashMap<>();
        DictItemVO vo=new DictItemVO();
        vo.setDictCode(dictCode);
        Result<List<DictItem>> result=DictItemServiceProxy.api().queryList(vo);
        if(result.isSuccess()){
            List<DictItem> list=result.getData();
            for(int i=0;i<list.size();i++){
                Logger.info(dictCode+" put data:"+list.get(i).getCode()+","+list.get(i).getLabel());
                map.put(list.get(i).getCode(),list.get(i).getLabel());
            }
        }else{
        }
        return map;
    }

    @Override
    public Result<CatalogData> verifyAssetExtColumnRecord(Rcd rcd, List<CatalogAttribute> attributeList, boolean fill){
        Result r=new Result();
        CatalogData data=new CatalogData();
        data.setCatalogId(rcd.getString("category_id"));
        data.setOwnerId(rcd.getString("id"));
        data.setTenantId(SessionUser.getCurrent().getActivatedTenantId());
        Map<String,Object> dataMap=new HashMap<>();
        String id=rcd.getString("pcm_ext_id");
        if(!StringUtil.isBlank(id)){
            data.setId(id);
        }
        for(CatalogAttribute attribute:attributeList){
            String col=attribute.getField();
            String value= rcd.getString(col);
            if("pcm_ext_id".equals(col))continue;
            if(!StringUtil.isBlank(value)){
                dataMap.put(col.replaceFirst("pcm_ext_",""),value==null?"":value);
            }
        }
        data.setData(dataMap);
        return r.success(true).data(data);
    }

    @Override
    public Result verifyAssetRecord(Rcd rcd,HashMap<String,HashMap<String,String>> matchMap, boolean filldata){

        HashMap<String,String> orgMap=matchMap.get("organizationMap");
        HashMap<String,String> categoryMap=matchMap.get("categoryMap");


        String category=BeanNameUtil.instance().depart(AssetMeta.CATEGORY_ID);
        String valueCategory=rcd.getString(category);

//        for (String f:rcd.getFields()){
//        }
        if(!StringUtil.isBlank(valueCategory)){
            if(categoryMap.containsValue(valueCategory.trim())){
                String key= queryMapKeyByValue(categoryMap,valueCategory);
                rcd.setValue(category,key);
            }else{
                //返回报错
                return ErrorDesc.failureMessage("资产分类未匹配到:"+valueCategory);
            }
        }else{
            return ErrorDesc.failureMessage("资产分类不存在:"+valueCategory);
        }


        //数据字典
        HashMap<String,String> dictColumns=new HashMap<>();
        dictColumns.put(AssetMeta.SOURCE_ID,"eam_source,资产来源");
        dictColumns.put(AssetMeta.SAFETY_LEVEL_CODE,"eam_safety_level,安全等级");
        dictColumns.put(AssetMeta.EQUIPMENT_ENVIRONMENT_CODE,"eam_equipment_environment,设备运行状态");
        dictColumns.put(AssetMeta.MAINTENANCE_STATUS,"eam_maintenance_status,维保状态");
        dictColumns.put(AssetMeta.MAINTENANCE_METHOD,"eam_maintenance_method,维保方式");
        dictColumns.put(AssetMeta.SUGGEST_MAINTENANCE_METHOD,"eam_suggest_maintenance_method,建议维保方式");
        dictColumns.put(AssetMeta.EXPENSE_ITEM,"eam_expense_items,费用项目");
        dictColumns.put(AssetMeta.FINANCIAL_OPTION,"eam_financial_options,财务选项");
        for(String key:dictColumns.keySet()){
            String keyValue=dictColumns.get(key);
            String[] keyValueArr=keyValue.split(",");
            String dict=keyValueArr[0];
            String notes=keyValueArr[1];
            HashMap<String,String> map=matchMap.get(dict);
            String col=BeanNameUtil.instance().depart(key);
            String valueCol=rcd.getString(col);
            Logger.info("col:"+col+",valueCol:"+valueCol);
            if(!StringUtil.isBlank(valueCol)){
                if(map.containsValue(valueCol)){
                    rcd.setValue(col,queryMapKeyByValue(map,valueCol));
                }else{
                    return ErrorDesc.failureMessage(notes+":"+valueCol);
                }
            }
        }

        //字符串类型
        String[] stringColumns = {AssetMeta.ASSET_CODE,AssetMeta.NAME,AssetMeta.SERIAL_NUMBER,AssetMeta.BATCH_CODE,
                AssetMeta.MODEL,AssetMeta.UNIT,AssetMeta.POSITION_DETAIL,AssetMeta.RFID,
                AssetMeta.ASSET_NOTES,AssetMeta.MAINTAINER_NAME,AssetMeta.CONTACTS,AssetMeta.CONTACT_INFORMATION,
                AssetMeta.DIRECTOR,AssetMeta.MAINTENANCE_NOTES,AssetMeta.FINANCIAL_CODE,AssetMeta.CUSTOMER_INFO};
        for(int j=0;j<stringColumns.length;j++){
            String stringColumn=stringColumns[j];
            String value=rcd.getString(BeanNameUtil.instance().depart(stringColumn));
            if(!StringUtil.isBlank(value)){
                rcd.set(stringColumn,value);
            }
        }


        //日期类型
        String[] dateColumns = {AssetMeta.MAINTENANCE_START_DATE,
                AssetMeta.MAINTENANCE_END_DATE,
                AssetMeta.PURCHASE_DATE,
                AssetMeta.ENTRY_TIME,
                AssetMeta.PRODUCTION_DATE,
                AssetMeta.LAST_VERIFICATION_DATE,
                AssetMeta.REGISTER_DATE};
        for(int j=0;j<dateColumns.length;j++){
            String dateColumn=dateColumns[j];
            String value=rcd.getString(BeanNameUtil.instance().depart(dateColumn));
            if(!StringUtil.isBlank(value)){
                int valueLen=value.trim().length();
                try {
                    DateFormat format1=null;
                    if(valueLen==10){
                        format1 = new SimpleDateFormat("yyyy-MM-dd");
                    }else if(valueLen==19){
                        format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    }else{
                        return ErrorDesc.failureMessage("时间转换失败,字段:"+dateColumn+",时间:"+value);
                    }
                    Date date = format1.parse(value);
                    rcd.set(dateColumn,date);
                } catch (ParseException e) {
                    return ErrorDesc.failureMessage("时间转换失败,字段:"+dateColumn+",时间:"+value);
                }
            }
        }



        //设备状态
        String equipStatus=BeanNameUtil.instance().depart(AssetMeta.EQUIPMENT_STATUS);
        String valueEquipStatus=rcd.getString(equipStatus);
        if(!StringUtil.isBlank(valueEquipStatus)){
            CodeTextEnum value=EnumUtil.parseByText(AssetStatusEnum.class,valueEquipStatus);
            if(StringUtil.isBlank(value)){
                return ErrorDesc.failureMessage("设备状态不存在:"+valueEquipStatus);
            }else{
                rcd.setValue(equipStatus,value.code());
            }
        }

        //下拉框类型
        String useOrganization=BeanNameUtil.instance().depart(AssetMeta.USE_ORGANIZATION_ID);
        String valueUseOrganization=rcd.getString(useOrganization);
        if(!StringUtil.isBlank(valueUseOrganization)){
            if(orgMap.containsValue(valueUseOrganization.trim())){
                String key= queryMapKeyByValue(orgMap,valueUseOrganization);
                rcd.setValue(useOrganization,key);
            }else{
                //返回报错
                return ErrorDesc.failureMessage("组织节点未匹配到:"+valueUseOrganization);
            }
        }


        String companyId=BeanNameUtil.instance().depart(AssetMeta.OWN_COMPANY_ID);
        String valueOwnerCompany=rcd.getString(companyId);
        if(!StringUtil.isBlank(valueOwnerCompany)){
            if(orgMap.containsValue(valueOwnerCompany.trim())){
                String key= queryMapKeyByValue(orgMap,valueOwnerCompany);
                rcd.setValue(companyId,key);
            }else{
                //返回报错
                return ErrorDesc.failureMessage("组织节点未匹配到:"+valueOwnerCompany);
            }
        }


        String manager=BeanNameUtil.instance().depart(AssetMeta.MANAGER_ID);
        String valueManager=rcd.getString(manager);
        if(!StringUtil.isBlank(valueManager)){
            Result<Employee> resEmp=EmployeeServiceProxy.api().getByBadge(valueManager);
            if(resEmp.isSuccess()){
                if(resEmp.getData()!=null&&resEmp.getData().getId()!=null){
                    String empId=resEmp.getData().getId();
                    rcd.setValue(manager,empId);
                }else{
                    Logger.info("获取人员失败:"+resEmp.getMessage()+",info:"+resEmp.getData());
                    return ErrorDesc.failureMessage("管理人员不存在:"+valueManager);
                }
            }else{
                Logger.info("获取人员失败:"+resEmp.getMessage());
                return ErrorDesc.failureMessage("管理人员不存在:"+valueManager);
            }
        }

        String useUser=BeanNameUtil.instance().depart(AssetMeta.USE_USER_ID);
        String valueUseUser=rcd.getString(useUser);
        if(!StringUtil.isBlank(valueUseUser)){
            Result<Employee> resEmp=EmployeeServiceProxy.api().getByBadge(valueUseUser);
            if(resEmp.isSuccess()){
                if(resEmp.getData()!=null&&resEmp.getData().getId()!=null){
                    String empId=resEmp.getData().getId();
                    rcd.setValue(useUser,empId);
                }else{
                    Logger.info("获取人员失败:"+",info:"+resEmp.getData());
                    return ErrorDesc.failureMessage("使用人员不存在:"+valueUseUser);
                }
            }else{
                Logger.info("获取人员失败:"+resEmp.getMessage());
                return ErrorDesc.failureMessage("使用人员不存在:"+valueUseUser);
            }
        }


        //下拉框
        String financialCategory=BeanNameUtil.instance().depart(AssetMeta.FINANCIAL_CATEGORY_ID);
        String valueFinancialCategory=rcd.getString(financialCategory);
        if(!StringUtil.isBlank(valueFinancialCategory)){
            CategoryFinance categoryFinance = categoryFinanceService.queryEntity(CategoryFinance.create().setHierarchyName(valueFinancialCategory));
            if(categoryFinance==null){
                return ErrorDesc.failureMessage("财务分类不存在:"+valueFinancialCategory);
            }else{
                rcd.setValue(financialCategory,categoryFinance.getId());
            }
        }

        //物品档案fill
        String goodsId=BeanNameUtil.instance().depart(AssetMeta.GOODS_ID);
        String valueGoods=rcd.getString(goodsId);
        if(!StringUtil.isBlank(valueGoods)){
            Goods goods = goodsService.queryEntity(Goods.create().setName(valueGoods));
            if(goods==null){
                if(filldata){
                    goods=new Goods();
                    goods.setName(valueGoods);
                    goodsService.insert(goods);
                    rcd.setValue(goodsId,goods.getId());
                }else{
                    return ErrorDesc.failureMessage("物品档案不存在:"+valueGoods);
                }
            }else{
                rcd.setValue(goodsId,goods.getId());
            }
        }

        //位置 fill
        String positionId=BeanNameUtil.instance().depart(AssetMeta.POSITION_ID);
        String valuePosition=rcd.getString(positionId);
        if(!StringUtil.isBlank(valuePosition)){
            Position position = positionService.queryEntity(Position.create().setHierarchyName(valuePosition));
            if(position==null){
                return ErrorDesc.failureMessage("资产位置不存在:"+valuePosition);
            }else{
                rcd.setValue(positionId,position.getId());
            }
        }



//        String assetStatus=BeanNameUtil.instance().depart(AssetMeta.ASSET_STATUS);
//        String valueAssetStatus=rcd.getString(assetStatus);
//        if(!StringUtil.isBlank(valueAssetStatus)){
//            String value=EnumUtil.parseByText(AssetStatusEnum.class,valueAssetStatus)==null
//                    ?AssetStatusEnum.IDLE.code()
//                    :EnumUtil.parseByText(AssetStatusEnum.class,valueAssetStatus).code();
//            rcd.setValue(assetStatus,value);
//        } else{
//            rcd.setValue(assetStatus,AssetStatusEnum.IDLE.code());
//        }
        String assetStatusId=BeanNameUtil.instance().depart(AssetMeta.ASSET_STATUS);
        String valueAssetStatus=rcd.getString(assetStatusId);
        if(!StringUtil.isBlank(valueAssetStatus)){
            AssetStatus assetStatus= assetStatusService.queryEntity(AssetStatus.create().setName(valueAssetStatus));
            if(assetStatus==null){
                return ErrorDesc.failureMessage("当前资产状态设置不正确,值:"+valueAssetStatus);
            }else{
                rcd.setValue(assetStatusId,assetStatus.getCode());
            }
        }else{
            rcd.setValue(assetStatusId,AssetStatusEnum.IDLE.code());
        }


        //仓库 fill
        String wareHouseId=BeanNameUtil.instance().depart(AssetMeta.WAREHOUSE_ID);
        String valueWarehouse=rcd.getString(wareHouseId);
        if(!StringUtil.isBlank(valueWarehouse)){
            Warehouse warehouse = warehouseService.queryEntity(Warehouse.create().setWarehouseName(valueWarehouse));
            if(warehouse==null){
                if(filldata){
                    warehouse=new Warehouse();
                    warehouse.setWarehouseName(valueWarehouse);
                    warehouseService.insert(warehouse);
                    rcd.setValue(wareHouseId,warehouse.getId());
                }else{
                    return ErrorDesc.failureMessage("资产仓库不存在:"+valueWarehouse);
                }
            }else{
                rcd.setValue(wareHouseId,warehouse.getId());
            }
        }


        //供应商
        String supplierId=BeanNameUtil.instance().depart(AssetMeta.SUPPLIER_ID);
        String valueSupplier=rcd.getString(supplierId);
        if(!StringUtil.isBlank(valueSupplier)){
            Supplier manufacturer = supplierService.queryEntity(Supplier.create().setSupplierName(valueSupplier));
            if(manufacturer==null){
                if(filldata){
                    Supplier supplier=new Supplier();
                    supplier.setSupplierName(valueSupplier);
                    supplierService.insert(supplier);
                    rcd.setValue(supplierId,manufacturer.getId());
                }else{
                    //返回报错
                    return ErrorDesc.failureMessage("供应商不存在:"+valueSupplier);
                }
            }else{
                rcd.setValue(supplierId,manufacturer.getId());
            }
        }



        //厂商 fill
        String manufacturerId=BeanNameUtil.instance().depart(AssetMeta.MANUFACTURER_ID);
        String valueManufacturer=rcd.getString(manufacturerId);
        if(!StringUtil.isBlank(valueManufacturer)){
            Manufacturer manufacturer = manufacturerService.queryEntity(Manufacturer.create().setManufacturerName(valueManufacturer));
            if(manufacturer==null){
                if(filldata){
                    manufacturer=new Manufacturer();
                    manufacturer.setManufacturerName(valueManufacturer);
                    manufacturerService.insert(manufacturer);
                    rcd.setValue(manufacturerId,manufacturer.getId());
                }else{
                    //返回报错
                    return ErrorDesc.failureMessage("厂商不存在:"+valueManufacturer);
                }
            }else{
                rcd.setValue(manufacturerId,manufacturer.getId());
            }
        }


        //机柜 fill
        String rackId=BeanNameUtil.instance().depart(AssetMeta.RACK_ID);
        String valueRack=rcd.getString(rackId);
        if(!StringUtil.isBlank(valueRack)){
            AssetRackVO vo=new AssetRackVO();
            vo.setHierarchyName(valueRack);
            vo.setType(AssetRackTreeTypeEnum.RACK.code());
            Result<List<AssetRack>> rackResult= AssetRackServiceProxy.api().queryList(vo);
            if(!rackResult.isSuccess()){
                return rackResult;
            }
            String matchRackId="";
            if (rackResult.getData().size()==0){
                return ErrorDesc.failureMessage("机柜不存在:"+valueRack);
            }else{
                matchRackId=rackResult.getData().get(0).getId();
            }
            rcd.setValue(rackId,matchRackId);
        }
        return ErrorDesc.success();
    }




    //将assetList转Map,保存dataList,categoryId过滤条件
    @Override
    public Map<String, Object> queryAssetMap(List<Asset> list,String categoryId) {
        long start = System.currentTimeMillis();

        HashMap<String,String> orgMap=queryOrganizationNodes("");
        HashMap<String,String> categoryMap=queryAssetCategoryNodes("");

        Map<String,Object> map=new HashMap<>();
        assetService.joinData(list);
        String tenantId=SessionUser.getCurrent().getActivatedTenantId();
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        for(int i=0;i<list.size();i++){
            Asset assetItem=list.get(i);
//            if(!StringUtil.isBlank(categoryId)){
//                if(!categoryId.equals(assetItem.getCategoryId())){
//                    continue;
//                }
//            }
            Map<String, Object> assetMap= BeanUtil.toMap(assetItem);

            //获取自定义属性
           // 暂时去除自定义属性
//            DataQueryVo vo=new DataQueryVo();
//            vo.setCatalogId(categoryId);
//            vo.setTenantId(tenantId);
//            List<String> ids=new ArrayList<>();
//            ids.add(assetItem.getId());
//            vo.setOwnerIds(ids);
//            Result itemResult=CatalogServiceProxy.api().queryData(vo);
//            if(itemResult.isSuccess()){
//                JSONArray dataArr=(JSONArray)itemResult.getData();
//                if(dataArr.size()>0){
//                    JSONObject dataObj=dataArr.getJSONObject(0);
//                    for(String key:dataObj.keySet()){
//                        assetMap.put("pcm_ext_"+key,dataObj.get(key));
//                    }
//                }
//            }
            //资产状态
            if(assetItem.getAssetCycleStatus()!=null){
                assetMap.put(AssetDataExportColumnEnum.ASSET_STATUS_NAME.code(),assetItem.getAssetCycleStatus().getName());
            }
            //办理状态
            CodeTextEnum vStatus= EnumUtil.parseByCode(AssetHandleStatusEnum.class,assetItem.getStatus());
            assetMap.put(AssetDataExportColumnEnum.STATUS_NAME.code(),vStatus==null?"":vStatus.text());
            //设备状态
            CodeTextEnum vEquipStatus= EnumUtil.parseByCode(AssetEquipmentStatusEnum.class,assetItem.getEquipmentStatus());
            assetMap.put(AssetDataExportColumnEnum.EQUIPMENT_STATUS_NAME.code(),vEquipStatus==null?"":vEquipStatus.text());
            //数据字典
            if(assetItem.getSuggestMaintenanceMethodData()!=null){
                assetMap.put(AssetDataExportColumnEnum.SUGGEST_MAINTENANCE_METHOD.code(),assetItem.getSuggestMaintenanceMethodData().getLabel());
            }
            if(assetItem.getMaintenanceMethodData()!=null){
                assetMap.put(AssetDataExportColumnEnum.MAINTENANCE_METHOD.code(),assetItem.getMaintenanceMethodData().getLabel());
            }
            if(assetItem.getExpenseItemDict()!=null){
                assetMap.put(AssetDataExportColumnEnum.EXPENSE_ITEM.code(),assetItem.getExpenseItemDict().getLabel());
            }
            if(assetItem.getFinancialOptionDict()!=null){
                assetMap.put(AssetDataExportColumnEnum.FINANCIAL_OPTION.code(),assetItem.getFinancialOptionDict().getLabel());
            }
            if(assetItem.getSource()!=null){
                assetMap.put(AssetDataExportColumnEnum.ASSET_SOURCE_NAME.code(),assetItem.getSource().getLabel());
            }
            if(assetItem.getSafetyLevel()!=null){
                assetMap.put(AssetDataExportColumnEnum.SAFETY_LEVEL_NAME.code(),assetItem.getSafetyLevel().getLabel());
            }
            if(assetItem.getEquipmentEnvironment()!=null){
                assetMap.put(AssetDataExportColumnEnum.EQUIPMENT_ENVIRONMENT_NAME.code(),assetItem.getEquipmentEnvironment().getLabel());
            }
            if(assetItem.getAssetMaintenanceStatus()!=null){
                assetMap.put(AssetDataExportColumnEnum.MAINTENANCE_STATUS.code(),assetItem.getAssetMaintenanceStatus().getLabel());
            }
            if(assetItem.getPosition()!=null){
                // 关联出 存放位置 数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_POSITION_NAME.code(),assetItem.getPosition().getHierarchyName());
            }
            if(assetItem.getGoods()!=null){
                //关联出 物品档案 数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_GOOD_NAME.code(),assetItem.getGoods().getName());
            }
            if(assetItem.getRack()!=null){
                //关联出 机柜 数据
                assetMap.put(AssetDataExportColumnEnum.RACK_NAME.code(),assetItem.getRack().getHierarchyName());
                assetMap.put("rackCode",assetItem.getRack().getCode());
            }
            if(assetItem.getManufacturer()!=null){
                //关联出 厂商 数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_MANUFACTURER_NAME.code(),assetItem.getManufacturer().getManufacturerName());
            }
            if(assetItem.getWarehouse()!=null){
                //关联出 仓库 数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_WAREHOUSE_NAME.code(),assetItem.getWarehouse().getWarehouseName());
            }
            if(assetItem.getMaintnainer()!=null){
                //关联出 维保商 数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_MAINTAINER_NAME.code(),assetItem.getMaintnainer().getMaintainerName());
            }
            if(assetItem.getCategoryFinance()!=null){
                // 关联出 财务分类数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_CATEGORY_FINANCE_NAME.code(),assetItem.getCategoryFinance().getHierarchyName());
            }
            if(assetItem.getSupplier()!=null){
                // 关联出 供应商 数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_SUPPLIER_NAME.code(),assetItem.getSupplier().getSupplierName());
            }
            String companyName=orgMap.get(assetItem.getOwnCompanyId());
            assetMap.put(AssetDataExportColumnEnum.OWN_COMPANY_NAME.code(),companyName);
            String orgName=orgMap.get(assetItem.getUseOrganizationId());
            assetMap.put(AssetDataExportColumnEnum.USE_ORGANIZATION_NAME.code(),orgName);
            String categoryName=categoryMap.get(assetItem.getCategoryId());
            assetMap.put(AssetDataExportColumnEnum.ASSET_CATEGORY_NAME.code(),categoryName);
            if(assetItem.getManager()!=null){
                assetMap.put(AssetDataExportColumnEnum.MANAGER_NAME_BADGE.code(),assetItem.getManager().getNameAndBadge());
                assetMap.put(AssetDataExportColumnEnum.MANAGER_NAME.code(),assetItem.getManager().getName());
                assetMap.put(AssetDataExportColumnEnum.MANAGER_BADGE.code(),assetItem.getManager().getBadge());
            }
            if(assetItem.getUseUser()!=null){
                assetMap.put(AssetDataExportColumnEnum.USE_USER_NAME_BADGE.code(),assetItem.getUseUser().getNameAndBadge());
                assetMap.put(AssetDataExportColumnEnum.USE_USER_NAME.code(),assetItem.getUseUser().getName());
                assetMap.put(AssetDataExportColumnEnum.USE_USER_BADGE.code(),assetItem.getUseUser().getBadge());
            }
            listMap.add(assetMap);
        }
        long finish = System.currentTimeMillis();
        long cost=(finish-start)/1000L;
        Logger.info("queryAssetMap execute cost:"+cost);
        map.put("dataList", listMap);
        return map;
    }


    public File saveTempFile(InputStream is, String fileName){
        int BYTESIZE=1024;
        String path = System.getProperty("java.io.tmpdir");
        File temp = new File(path +File.separator+ fileName);
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(new FileOutputStream(temp));                            //把文件流转为文件，保存在临时目录
            int len = 0;
            byte[] buf = new byte[10*BYTESIZE];                                                    //缓冲区
            while((len=bis.read(buf)) != -1){
                bos.write(buf, 0, len);
            }
            bos.flush();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try {
                if(bos!=null) bos.close();
                if(bis!=null) bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return temp;
    }



}
