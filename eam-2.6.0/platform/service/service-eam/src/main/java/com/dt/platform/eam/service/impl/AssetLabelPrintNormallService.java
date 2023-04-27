package com.dt.platform.eam.service.impl;


import com.dt.platform.constants.enums.eam.AsseLabelPrintCodeEnum;
import com.dt.platform.constants.enums.eam.AsseLabelTableCellTypeEnum;
import com.dt.platform.domain.eam.AssetLabelCol;
import com.dt.platform.domain.eam.AssetLabelLayout;
import com.dt.platform.domain.eam.meta.AssetLabelPrint;
import com.dt.platform.eam.service.IAssetLabelPrintService;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.log.Logger;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.*;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 变更明细 服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-09 12:26:14
*/
@Service("AssetLabelPrintNormallService")
public class AssetLabelPrintNormallService implements IAssetLabelPrintService {

	//专用打印标签
	@Override
	public AsseLabelPrintCodeEnum getCode() {
		return AsseLabelPrintCodeEnum.NORMAL;
	}

	/**
	 * @Description:生成资产标签图片
	 * @param type
	 * @param data
	 */
	public static  BufferedImage createAssetPic(String type, String data,int w,int h) {
		Logger.info("createAssetPic"+type+data+w+","+h);
		BarcodeFormat format = BarcodeFormat.QR_CODE;
		if ("rwm".equals(type)) {
			format = BarcodeFormat.QR_CODE;
		} else if ("txm".equals(type)) {
			format = BarcodeFormat.CODE_128;
		}
		BitMatrix bitMatrix = null;
		try {
			bitMatrix = new MultiFormatWriter().encode(data, format, w, h);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		BufferedImage buffImg = MatrixToImageWriter.toBufferedImage(bitMatrix);
		return buffImg;
	}


	@Override
	public Result print(AssetLabelPrint print) {

		try {
			String path = System.getProperty("java.io.tmpdir");
			List<Map<String, Object>> assetList=print.getAssetData();
			List<AssetLabelCol> colList=print.getAssetColumnList();
			String pdfFileName =path +File.separator+ print.getUuid()+".pdf";
			Logger.info("pdf out file path:"+pdfFileName);
			PdfDocument pdf = new PdfDocument(new PdfWriter(pdfFileName));
			//字体设置
			PdfFont KeyFont=null;
			PdfFont valueFont=null;
			String workDir=System.getProperty("user.dir");
			String fontPath=workDir+File.separator+"bin"+File.separator+"simhei.ttf";
			File file = new File(fontPath);
			if(file.exists()){
				Logger.info("pdf Font path:"+fontPath);
				Logger.info("pdf Font:simhei");
				PdfFontFactory.register(fontPath,"SIM_HEI");
				KeyFont =PdfFontFactory.createRegisteredFont("SIM_HEI",PdfEncodings.IDENTITY_H);
				valueFont =PdfFontFactory.createRegisteredFont("SIM_HEI",PdfEncodings.IDENTITY_H);
			}else{
				Logger.info("pdf Font path:"+fontPath+" not exist!");
				Logger.info("pdf Font:STSong");
				KeyFont =PdfFontFactory.createFont("STSong-Light","UniGB-UCS2-H");
				valueFont =PdfFontFactory.createFont("STSong-Light","UniGB-UCS2-H");
			}
			Float tableWidthPoint=print.getTableWidthMM()*print.PAGE_SIZE_A4_POINT_PER_MM;
			Float tableHeightPoint=print.getTableHeightMM()*print.PAGE_SIZE_A4_POINT_PER_MM;
			//表的label value 宽度
			Float tableKeyWidthPoint=print.getPointByMM(12f);
			Float tableValueWidthPoint=tableWidthPoint-tableKeyWidthPoint;
			PageSize pageSize =new PageSize(print.getPageSizeWidth(),print.getPageSizeHeight());
			Document document = new Document(pdf, pageSize);
			Logger.info("document:"+document);
			document.setMargins(0,0,0,0);


			Logger.info("print setting option list:");
			Logger.info("print Page Type:"+print.getPaperType());
			Logger.info("print Page columnNumber:"+print.getPrintColumnNumber());
			Logger.info("print Page width(point):"+pageSize.getWidth());
			Logger.info("print Page height(point):"+pageSize.getHeight());
			Logger.info("print Table width(point):"+tableWidthPoint);
			Logger.info("print Table height(point):"+tableHeightPoint);
			Logger.info("print Table tableMarginLeft(mm):"+print.getTableMarginLeftMM());
			Logger.info("print Table tableMarginRight(mm):"+print.getTableMarginRightMM());
			Logger.info("print Table key width(point):"+tableKeyWidthPoint);
			Logger.info("print Table value width(point):"+tableValueWidthPoint);
			Logger.info("print Image show:"+print.getLabelTpl().getImageShow());
			Logger.info("print Image type:"+print.getLabelTpl().getImageType());
			Logger.info("print Image position:"+print.getLabelTpl().getImagePosition());
			String imageType=print.getLabelTpl().getImageType();

			//div设置百分之白
			Div div = new Div();
			div.setKeepTogether(true);
			div.setHorizontalAlignment(HorizontalAlignment.CENTER);
			div.setVerticalAlignment(VerticalAlignment.MIDDLE);
			div.setWidth(UnitValue.createPercentValue(100));
			// div.setBackgroundColor(ColorConstants.GREEN);
			div.setMargin(0);
			div.setPadding(0);
			Logger.info("print document div width:"+div.getWidth());
			Logger.info("print document div height:"+div.getHeight());
			Logger.info("print document div margin top:"+div.getMarginTop());
			Logger.info("print document div margin bottom:"+div.getMarginBottom());
			Logger.info("print document div margin left:"+div.getPaddingLeft());
			Logger.info("print document div margin right:"+div.getPaddingRight());
			Logger.info("print document div padding top:"+ div.getPaddingTop());
			Logger.info("print document div padding bottom:"+div.getPaddingBottom());
			Logger.info("print document div padding left:"+div.getPaddingLeft());
			Logger.info("print document div padding right:"+div.getPaddingRight());
			Paragraph paragraphIncludeTable=null;
			if(assetList!=null){
				Logger.info("print asset label number:"+assetList.size());
				for(int i=0;i<assetList.size();i++){
					Map<String, Object> asset=assetList.get(i);
					String assetId=asset.getOrDefault("id","none").toString();
					String assetCode=asset.getOrDefault("assetCode","none").toString();
					Logger.info("i%print.getPrintColumnNumber():"+i%print.getPrintColumnNumber());
					if(i%print.getPrintColumnNumber()==0){
						if(paragraphIncludeTable!=null){
							div.add(paragraphIncludeTable);
						}
						paragraphIncludeTable = new Paragraph();
						//      paragraphIncludeTable.setBackgroundColor(ColorConstants.YELLOW);
						//必须设置宽度
						// paragraphIncludeTable.setWidth(tableWidthPoint);
						paragraphIncludeTable.setTextAlignment(TextAlignment.CENTER);
						paragraphIncludeTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
						paragraphIncludeTable.setVerticalAlignment(VerticalAlignment.MIDDLE);
						paragraphIncludeTable.setMargins(0,0,0,0);
						paragraphIncludeTable.setPaddings(0,0,0,0);
					}

					//设置表格列数
					Table table = new Table(2);
					table.setFixedLayout();
					table.setKeepTogether(true);
					table.setPadding(0);
					table.setMarginTop(0);
					table.setMarginBottom(0);
					table.setMarginLeft(10);
					table.setMarginRight(10);
//					table.setMarginLeft(print.getPointByMM(print.getTableMarginLeftMM()));
//					table.setMarginRight(print.getPointByMM(print.getTableMarginLeftMM()));
					table.setWidth(UnitValue.createPointValue(print.getPointByMM(print.getTableWidthMM())));
					Logger.info("######table layout######");
					Logger.info("print table width mm:"+print.getTableWidthMM());
					Logger.info("print table height mm:"+print.getTableHeightMM());
					Logger.info("print table width:"+table.getWidth());
					Logger.info("print table height:"+table.getHeight());
					Logger.info("print table margin top:"+table.getMarginTop());
					Logger.info("print table margin bottom:"+table.getMarginBottom());
					Logger.info("print table margin left:"+table.getPaddingLeft());
					Logger.info("print table margin right:"+table.getPaddingRight());
					Logger.info("print table padding top:"+ table.getPaddingTop());
					Logger.info("print table padding bottom:"+table.getPaddingBottom());
					Logger.info("print table padding left:"+table.getPaddingLeft());
					Logger.info("print table padding right:"+table.getPaddingRight());
					Cell imageCell=null;
					Cell imageLabelCell=null;

					float imageContainerHeight=print.getPointByMM(21);
					float labelHeight=(print.getPageSizeHeight()-imageContainerHeight)/colList.size();
					Logger.info("pageSize height:"+print.getPageSizeHeight());
					Logger.info("setting height:"+labelHeight);
					Logger.info("size number:"+colList.size());
					Logger.info("image container height:"+imageContainerHeight);

					if("1".equals(print.getLabelTpl().getImageShow())){
						//图像
						BufferedImage buffImg=createAssetPic(imageType, assetCode,10,10);
						File imageFile = new File(path +File.separator+ assetId+".jpg");
						/////////////////图像生成开始
						ImageIO.write(buffImg,"jpg",imageFile);
						Logger.info(path + assetId+".jpg");
						Image img=new Image(ImageDataFactory.create(path +File.separator+ assetId+".jpg"));
						if("rwm".equals(imageType)){
							img.setHeight(imageContainerHeight-10);
							img.setWidth(imageContainerHeight-10);
						}else{
							img.setHeight(25);
							img.setWidth(UnitValue.createPointValue(tableWidthPoint*0.7f));
						}
						img.setMargins(0,0,0,0);
						img.setPaddings(0,0,0,0);

						Paragraph imgGaragraph = new Paragraph();
						imgGaragraph.add(img);
						imageCell= new Cell(1,2)
								.setTextAlignment(TextAlignment.CENTER)
								.setHorizontalAlignment(HorizontalAlignment.CENTER)
								.setWidth(UnitValue.createPercentValue(100))
								.setVerticalAlignment(VerticalAlignment.MIDDLE).add(imgGaragraph);



						imageCell.setHeight(imageContainerHeight-10);

						imageLabelCell= new Cell(1,2)
								.add(new Paragraph(assetCode)
										.setFont(valueFont).setFontSize(print.getFontSizeImageInfo()).setWidth(UnitValue.createPercentValue(100)).setTextAlignment(TextAlignment.CENTER));


						/////////////////图像生产结束
					}
					//图像
					if("1".equals(print.getLabelTpl().getImageShow()) &&"u".equals(print.getLabelTpl().getImagePosition())){
						table.addCell(imageCell);
						if("1".equals(print.getLabelTpl().getImageLabelShow())){
							table.addCell(imageLabelCell);
						}
					}

					for(AssetLabelCol col:colList){

						table.startNewRow();
						Paragraph vK=new Paragraph(col.getColName())
								.setFont(KeyFont)
								.setFontSize(print.getFontSizeValue());
						vK.setMargin(0);
						vK.setPadding(0);
						vK.setProperty(Property.OVERFLOW_X, OverflowPropertyValue.VISIBLE);
						Cell keyCell=new Cell().add(vK)
								.setWidth(UnitValue.createPointValue(tableKeyWidthPoint))
								.setTextAlignment(TextAlignment.LEFT);
						keyCell.setPadding(0);
						keyCell.setMargin(0);
						keyCell.setMaxWidth(UnitValue.createPointValue(tableKeyWidthPoint));
						keyCell.setProperty(Property.OVERFLOW_X, OverflowPropertyValue.VISIBLE);

						//key value
						Paragraph vP=new Paragraph(asset.getOrDefault(col.getColValue(),"").toString())
								.setFont(valueFont)
								.setFontSize(print.getFontSizeValue()).setWidth(UnitValue.createPointValue(tableValueWidthPoint))
								.setTextAlignment(TextAlignment.LEFT);
						vP.setMargin(0);
						vP.setPadding(0);
						vP.setProperty(Property.OVERFLOW_X, OverflowPropertyValue.VISIBLE);
						Cell valueCell=new Cell().add(vP)
								.setFontSize(print.getFontSizeValue())
								.setWidth(UnitValue.createPointValue(tableValueWidthPoint))
								.setTextAlignment(TextAlignment.LEFT);
						valueCell.setPadding(0);
						valueCell.setMargin(0);


						vP.setProperty(Property.OVERFLOW_X, OverflowPropertyValue.VISIBLE);
						table.addCell(keyCell);
						table.addCell(valueCell);
						Logger.info("keyCell width:"+keyCell.getWidth());
						Logger.info("keyCell height:"+keyCell.getHeight());
						Logger.info("valueCell width:"+valueCell.getWidth());
						Logger.info("valueCell height:"+valueCell.getHeight());
					}

					//图像
					if("1".equals(print.getLabelTpl().getImageShow()) &&"d".equals(print.getLabelTpl().getImagePosition())){
						table.addCell(imageCell);
						if("1".equals(print.getLabelTpl().getImageLabelShow())){
							//   table.addCell(imageLabelCell);
						}
					}
					//  paragraphIncludeTable.setProperty(Property.OVERFLOW_X, OverflowPropertyValue.VISIBLE);
					//   TR tr=new TR();
					paragraphIncludeTable.add(table);

				}
			}

			//div  paragraphIncludeTable  table
			if(paragraphIncludeTable!=null){
				div.add(paragraphIncludeTable);
			}
			if(div!=null){
				document.add(div);
			}

			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ErrorDesc.failureMessage("生成pdf失败");
		}

		return ErrorDesc.success();
	}



	private  BitMatrix reduceWhite(BitMatrix matrix, int margin) {
		int tempM = margin * 2;
		int[] rec = matrix.getEnclosingRectangle(); // 获取二维码图案的属性
		int resWidth = rec[2] + tempM;
		int resHeight = rec[3] + tempM;
		BitMatrix resMatrix = new BitMatrix(resWidth, resHeight); // 按照自定义边框生成新的BitMatrix
		resMatrix.clear();
		for (int i = margin; i < resWidth - margin; i++) { // 循环，将二维码图案绘制到新的bitMatrix中
			for (int j = margin; j < resHeight - margin; j++) {
				if (matrix.get(i - margin + rec[0], j - margin + rec[1])) {
					resMatrix.set(i, j);
				}
			}
		}
		return resMatrix;
	}


	public Image createImage(String imageType,String content,int w,int h){
		//图像
		String uid= IDGenerator.getSnowflakeIdString();
		String path = System.getProperty("java.io.tmpdir");
		Logger.info("iamgeType:"+imageType+",w:"+w+",h:"+h+",path:"+path + uid+".jpg");
		BarcodeFormat format = BarcodeFormat.QR_CODE;
		if(AsseLabelTableCellTypeEnum.QR_CODE.code().equals(imageType)){
			format = BarcodeFormat.QR_CODE;
		}else if(AsseLabelTableCellTypeEnum.BAR_CODE.code().equals(imageType)){
			format = BarcodeFormat.CODE_128;
		}
		BitMatrix bitMatrix = null;
		try {
			bitMatrix =reduceWhite( new MultiFormatWriter().encode(content, format, w, h),1);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		BufferedImage buffImg = MatrixToImageWriter.toBufferedImage(bitMatrix);
		File imageFile = new File(path +File.separator+ uid+".jpg");
		Image img=null;
		try {
			ImageIO.write(buffImg,"jpg",imageFile);
			img=new Image(ImageDataFactory.create(path + uid+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(AsseLabelTableCellTypeEnum.QR_CODE.code().equals(imageType)){
			//二维码
			img.setHeight(h);
			img.setWidth(h);
		}else{
			//img.setHeight(25);
		}
		img.setBackgroundColor(ColorConstants.BLUE);
		img.setMargins(0,0,0,0);
		img.setPaddings(0,0,0,0);
		Logger.info("image finish,width:"+img.getWidth()+",height:"+img.getWidth());
		Logger.info("image finish,image width:"+img.getImageWidth()+",image height:"+img.getImageHeight());
		return img;
	}



}