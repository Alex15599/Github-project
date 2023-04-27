package com.dt.platform.constants.enums.vehicle;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum VehicleDataExportColumnEnum implements CodeTextEnum {


    ID("id","id" ),
    NAME("name","name" ),
    VEHICLE_STATUS_NAME("vehicleStatusName","vehicle_status" ),
    TYPE_NAME("typeName","type" ),
    VEHICLE_CODE("vehicleCode","vehicle_code" ),
    MODEL("model" ,  "model"),
    REGISTRANT("registrant","registrant" ),
    OWNER_ORG_NAME( "ownerOrgName","owner_org_id" ),
    USE_ORG_NAME( "useOrgName","use_org_id" ),
    USE_USER_NAME_BADGE("useUserNameBadge","use_user_name_badge" ),
    USE_USER_BADGE("useUserBadge","use_user_id" ),
    USE_USER_NAME("useUserName","use_user_name" ),
    COLOR("color","color" ),
    ENGINE_NUMBER( "engineNumber","engine_number" ),
    FRAME_NUMBER("frameNumber","frame_number" ),
    DRIVING_LICENSE( "drivingLicense","driving_License" ),
    KILOMETERS( "kilometers","kilometers" ),
    RESCUE_MONEY( "rescueMoney","rescue_money" ),
    COMMERCIAL_INSURANCE_MONEY("commercialInsuranceMoney","commercial_insurance_money" ),
    INSURANCE_COMPANY("insuranceCompany","insurance_company" ),
    LICENSING_TIME("licensingTime","licensing_time"),
    INSURANCE_EXPIRE_DATE( "insuranceExpireDate","insurance_expire_date" ),
    RESCUE_DUE_DATE( "rescueDueDate","rescue_due_date" ),
    SCRAP_TIME( "scrapTime","scrap_time" ),
    POSITION_DETAIL( "positionDetail","position_detail" ),
    TECHNICAL_PARAMETER("technicalParameter","technical_parameter"  ),
    VEHICLE_COUNT( "vehicleCount","VEHICLE_COUNT" ),
    NOTES( "notes","notes" );

    private String code;
    private String text;
    private VehicleDataExportColumnEnum(String code, String text)  {
        this.code=code;
        this.text=text;
    }

    public String code() {
        return code;
    }

    public String text() {
        return text;
    }


}
