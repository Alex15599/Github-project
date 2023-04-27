package com.dt.platform.domain.eam.meta;

import com.dt.platform.domain.eam.*;
import com.github.foxnic.commons.log.Logger;

import java.util.List;
import java.util.Map;

public class AssetLabelPrint {


    //1mm 对应pt个数
    public float PAGE_SIZE_A4_POINT_PER_MM=595/210f;
    List<Map<String, Object>> assetData=null;

    private AssetLabel label;
    private AssetLabelTpl labelTpl;
    private AssetLabelPaper assetLabelPaper;
    private List<AssetLabelCol> assetColumnList=null;
    private List<AssetLabelLayout> assetLabelLayoutList=null;

    private String uuid;
    //列个数
    private String paperType="a4";
    private int printColumnNumber=3;
    private int tableColumnNumber=4;
    private int fontSizeLabel=8;
    private int fontSizeValue=8;
    private int fontSizeImageInfo=6;

    private int tableMarginLeftMM =0;
    private int tableMarginRightMM =0;
    private int tableMarginTopMM =0;
    private int tableMarginBottomMM =0;

    //A4 长 宽
    private float pageSizeWidth=210f;
    private float pageSizeHeight=297f;
    private float tableWidthMM =60;
    private float tableHeightMM =80;




    public float getPageSizeWidth() {
        return pageSizeWidth;
    }
    public void setPageSizeWidth(float pageSizeWidth) {
        this.pageSizeWidth = pageSizeWidth;
    }
    public float getPageSizeHeight() {
        return pageSizeHeight;
    }
    public void setPageSizeHeight(float pageSizeHeight) {
        this.pageSizeHeight = pageSizeHeight;
    }
    public float getTableWidthMM() {
        return tableWidthMM;
    }
    public void setTableWidthMM(float tableWidthMM) {
        this.tableWidthMM = tableWidthMM;
    }
    public float getTableHeightMM() {
        return tableHeightMM;
    }
    public void setTableHeightMM(float tableHeightMM) {
        this.tableHeightMM = tableHeightMM;
    }

    public AssetLabelPaper getAssetLabelPaper() {
        return assetLabelPaper;
    }

    public void setAssetLabelPaper(AssetLabelPaper assetLabelPaper) {
        this.assetLabelPaper = assetLabelPaper;
    }

    public int getTableMarginTopMM() {
        return tableMarginTopMM;
    }

    public void setTableMarginTopMM(int tableMarginTopMM) {
        this.tableMarginTopMM = tableMarginTopMM;
    }

    public int getTableMarginBottomMM() {
        return tableMarginBottomMM;
    }

    public void setTableMarginBottomMM(int tableMarginBottomMM) {
        this.tableMarginBottomMM = tableMarginBottomMM;
    }

    public List<AssetLabelLayout> getAssetLabelLayoutList() {
        return assetLabelLayoutList;
    }

    public void setAssetLabelLayoutList(List<AssetLabelLayout> assetLabelLayoutList) {
        this.assetLabelLayoutList = assetLabelLayoutList;
    }

    public void setTableMarginLeftMM(int tableMarginLeftMM) {
        this.tableMarginLeftMM = tableMarginLeftMM;
    }


    public float getPointByMM(float mm){
        return mm*PAGE_SIZE_A4_POINT_PER_MM;
    }

    public void setLabel(AssetLabel label) {
        this.label = label;
        if(label.getAssetPaper()!=null){
            this.paperType=label.getAssetPaper().getType();
            this.printColumnNumber=label.getAssetPaper().getColumnNumber();
        }
       // this.curTableWidthMM =label.getLabelWidth().floatValue()*10;
        this.tableWidthMM=label.getLabelWidth().floatValue()*10;
        this.tableHeightMM=label.getLabelHeight().floatValue()*10;
    }

    public String getPaperType() {
        return paperType;
    }
    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }
    public List<Map<String, Object>> getAssetData() {
        return assetData;
    }
    public void setAssetData(List<Map<String, Object>> assetData) {
        this.assetData = assetData;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public List<AssetLabelCol> getAssetColumnList() {
        return assetColumnList;
    }
    public void setAssetColumnList(List<AssetLabelCol> assetColumnList) {
        this.assetColumnList = assetColumnList;
    }
    public AssetLabel getLabel() {
        return label;
    }
    public int getPrintColumnNumber() {
        return printColumnNumber;
    }
    public void setPrintColumnNumber(int printColumnNumber) {
        this.printColumnNumber = printColumnNumber;
    }
    public int getTableColumnNumber() {
        return tableColumnNumber;
    }
    public void setTableColumnNumber(int tableColumnNumber) {
        this.tableColumnNumber = tableColumnNumber;
    }
    public int getFontSizeLabel() {
        return fontSizeLabel;
    }
    public void setFontSizeLabel(int fontSizeLabel) {
        this.fontSizeLabel = fontSizeLabel;
    }
    public int getFontSizeValue() {
        return fontSizeValue;
    }
    public void setFontSizeValue(int fontSizeValue) {
        this.fontSizeValue = fontSizeValue;
    }
    public int getFontSizeImageInfo() {
        return fontSizeImageInfo;
    }
    public void setFontSizeImageInfo(int fontSizeImageInfo) {
        this.fontSizeImageInfo = fontSizeImageInfo;
    }
    public int getTableMarginLeftMM() {
        return tableMarginLeftMM;
    }
    public int getTableMarginRightMM() {
        return tableMarginRightMM;
    }
    public void setTableMarginRightMM(int tableMarginRightMM) {
        this.tableMarginRightMM = tableMarginRightMM;
    }
    public AssetLabelTpl getLabelTpl() {
        return labelTpl;
    }
    public void setLabelTpl(AssetLabelTpl labelTpl) {
        this.labelTpl = labelTpl;
    }


}
