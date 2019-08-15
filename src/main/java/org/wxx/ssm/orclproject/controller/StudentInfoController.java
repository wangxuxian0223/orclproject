package org.wxx.ssm.orclproject.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.wxx.ssm.orclproject.entity.ClassInfo;
import org.wxx.ssm.orclproject.entity.Msg;
import org.wxx.ssm.orclproject.entity.StudentInfo;
import org.wxx.ssm.orclproject.service.StudentInfoService;
import org.wxx.ssm.orclproject.utils.ImportExcelUtil;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/studentInfo")
public class StudentInfoController {

	@Autowired
	private StudentInfoService studentInfoService;

	@RequestMapping("/getAll")
	public String getAll(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, Map<String, Object> map) {
		PageHelper.startPage(pageNo, 5);
		List<StudentInfo> list = studentInfoService.getAll();
		PageInfo pageInfo = new PageInfo(list, 5);
		map.put("pageInfo", pageInfo);
		return "list";
	}

	@RequestMapping("/getAllWithMsg")
	@ResponseBody
	public Msg getAllWithMsg(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) {
		PageHelper.startPage(pageNo, 5);
		List<StudentInfo> list = studentInfoService.getAll();
		PageInfo pageInfo = new PageInfo(list, 5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	@RequestMapping("/importExcel")
	public String importExcel(HttpServletRequest request, @RequestParam(value="file",required=false) MultipartFile excelFile, Map<String, Object> map) {
		//File targetFile = null;
		if (excelFile != null) {
			List<List<Object>> objects = null;
			try {
				objects = ImportExcelUtil.getBankListByExcel(excelFile.getInputStream(), excelFile.getOriginalFilename());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			List<StudentInfo> studentInfoList = transferToStudentInfo(objects);
			
			studentInfoService.importExcel(studentInfoList);

		}
		PageHelper.startPage(1, 5);
		List<StudentInfo> list = studentInfoService.getAll();
		PageInfo pageInfo = new PageInfo(list, 5);
		map.put("pageInfo", pageInfo);
		return "list";

	}
	
	private List<StudentInfo> transferToStudentInfo(List<List<Object>> objects) {
		List<StudentInfo> StudentInfoList = new ArrayList<StudentInfo>();
		for(int i = 0; i < objects.size(); i++) {
			List<Object> lo = objects.get(i);
			StudentInfo stu = new StudentInfo();
			stu.setStudentid(null);
			stu.setStudentname((String)lo.get(1));
			stu.setStudentsex((String)lo.get(2));
			stu.setStudentage(Integer.parseInt(lo.get(3).toString()));
			stu.setStudenttel(Long.valueOf(lo.get(4).toString()));
			stu.setStudentaddress((String)lo.get(5));
			stu.setCid(Integer.parseInt(lo.get(6).toString()));
			ClassInfo classInfo = new ClassInfo(Integer.parseInt(lo.get(6).toString()), (String)lo.get(7));
			stu.setClassInfo(classInfo);
			StudentInfoList.add(stu);
		}
		return StudentInfoList;
	}
	
	@RequestMapping("/export")
	public void exportStudentInfo(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, HttpServletRequest request, HttpServletResponse response) {
		PageHelper.startPage(pageNo, 5);
		List<StudentInfo> list = studentInfoService.getAll();
		PageInfo pageInfo = new PageInfo(list, 5);
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("学生信息表");
		// 设置单元格宽度
		int index = 0;
		sheet.setColumnWidth(index++, 256 * 18 + 184);
		sheet.setColumnWidth(index++, 256 * 18 + 184);
		sheet.setColumnWidth(index++, 256 * 9 + 184);
		sheet.setColumnWidth(index++, 256 * 18 + 184);
		sheet.setColumnWidth(index++, 256 * 9 + 184);
		sheet.setColumnWidth(index++, 256 * 9 + 184);
		sheet.setColumnWidth(index++, 256 * 9 + 184);
		sheet.setColumnWidth(index++, 256 * 18 + 184);
		sheet.setColumnWidth(index++, 256 * 18 + 184);
		sheet.setColumnWidth(index++, 256 * 18 + 184);
		sheet.setColumnWidth(index++, 256 * 18 + 184);
		sheet.setColumnWidth(index++, 256 * 18 + 184);
		sheet.setColumnWidth(index++, 256 * 18 + 184);
		sheet.setColumnWidth(index++, 256 * 18 + 184);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style_top_left = wb.createCellStyle();
		HSSFCellStyle style_top_center = wb.createCellStyle();
		HSSFCellStyle style_top_right = wb.createCellStyle();
		
		Font font = wb.createFont();
	    font.setFontHeightInPoints((short)12); //字体大小
	    font.setFontName("微软雅黑");
	    font.setBoldweight(Font.BOLDWEIGHT_BOLD); //粗体
	    font.setColor(HSSFColor.WHITE.index);    //白字
		
		style_top_left.setFillForegroundColor(IndexedColors.GREEN.getIndex());  
		style_top_left.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style_top_left.setFont(font);
		
		style_top_center.setFillForegroundColor(IndexedColors.GREEN.getIndex());  
		style_top_center.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style_top_center.setFont(font);
		
		style_top_right.setFillForegroundColor(IndexedColors.GREEN.getIndex());  
		style_top_right.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style_top_right.setFont(font);
		
		HSSFCellStyle style_content_left = wb.createCellStyle();
		HSSFCellStyle style_content_center = wb.createCellStyle();
		HSSFCellStyle style_content_right = wb.createCellStyle();

		HSSFCellStyle style_buttom_left = wb.createCellStyle();
		HSSFCellStyle style_buttom_center = wb.createCellStyle();
		HSSFCellStyle style_buttom_right = wb.createCellStyle();

		style_top_right.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style_top_left.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style_top_center.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style_content_left.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style_content_center.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style_content_right.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style_buttom_left.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style_buttom_center.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style_buttom_right.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		style_top_left.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框
		style_top_left.setBorderLeft(HSSFCellStyle.BORDER_THICK);// 左边框
		style_top_left.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		style_top_left.setBorderTop(HSSFCellStyle.BORDER_THICK);// 上边框

		style_top_center.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框
		style_top_center.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style_top_center.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		style_top_center.setBorderTop(HSSFCellStyle.BORDER_THICK);// 上边框

		style_top_right.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框
		style_top_right.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style_top_right.setBorderRight(HSSFCellStyle.BORDER_THICK);// 右边框
		style_top_right.setBorderTop(HSSFCellStyle.BORDER_THICK);// 上边框

		style_content_left.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框
		style_content_left.setBorderLeft(HSSFCellStyle.BORDER_THICK);// 左边框
		style_content_left.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		style_content_left.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框

		style_top_right.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框
		style_top_right.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style_top_right.setBorderRight(HSSFCellStyle.BORDER_THICK);// 右边框
		style_top_right.setBorderTop(HSSFCellStyle.BORDER_THICK);// 上边框

		style_buttom_left.setBorderBottom(HSSFCellStyle.BORDER_THICK);// 下边框
		style_buttom_left.setBorderLeft(HSSFCellStyle.BORDER_THICK);// 左边框
		style_buttom_left.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		style_buttom_left.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框

		style_buttom_center.setBorderBottom(HSSFCellStyle.BORDER_THICK);// 下边框
		style_buttom_center.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style_buttom_center.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		style_buttom_center.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框

		style_buttom_right.setBorderBottom(HSSFCellStyle.BORDER_THICK);// 下边框
		style_buttom_right.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style_buttom_right.setBorderRight(HSSFCellStyle.BORDER_THICK);// 右边框
		style_buttom_right.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
		
		style_content_center.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框
		style_content_center.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style_content_center.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		style_content_center.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框

		style_content_right.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框
		style_content_right.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style_content_right.setBorderRight(HSSFCellStyle.BORDER_THICK);// 右边框
		style_content_right.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框


		int nIndex = 0;
		HSSFCell cell = row.createCell(nIndex);
		cell.setCellValue("学生ID");
		cell.setCellStyle(style_top_left);
		cell = row.createCell(++nIndex);
		cell.setCellValue("学上姓名");
		cell.setCellStyle(style_top_center);
		cell = row.createCell(++nIndex);
		cell.setCellValue("学生性别");
		cell.setCellStyle(style_top_center);
		cell = row.createCell(++nIndex);
		cell.setCellValue("学生年齡");
		cell.setCellStyle(style_top_center);
		cell = row.createCell(++nIndex);
		cell.setCellValue("学生電話");
		cell.setCellStyle(style_top_center);
		cell = row.createCell(++nIndex);
		cell.setCellValue("学上地址");
		cell.setCellStyle(style_top_center);
		cell = row.createCell(++nIndex);
		cell.setCellValue("班级编号");
		cell.setCellStyle(style_top_center);
		cell = row.createCell(++nIndex);
		cell.setCellValue("班级名称");
		cell.setCellStyle(style_top_right);

		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		nIndex = 0;
		for (int i = 0; i < pageInfo.getList().size(); i++,nIndex = 0) {
			row = sheet.createRow(i + 1);
			StudentInfo stu = (StudentInfo) pageInfo.getList().get(i);
			// 第四步，创建单元格，并设置值
			HSSFCell c = row.createCell(nIndex++);
			c.setCellValue(stu.getStudentid());
			if (i == list.size() - 1) {
				c.setCellStyle(style_buttom_left);
			} else {
				c.setCellStyle(style_content_left);
			}

			c = row.createCell(nIndex++);
			c.setCellValue(stu.getStudentname());
			if (i == list.size() - 1) {
				c.setCellStyle(style_buttom_center);
			} else {
				c.setCellStyle(style_content_center);
			}

			c = row.createCell(nIndex++);
			c.setCellValue(stu.getStudentsex());
			if (i == list.size() - 1) {
				c.setCellStyle(style_buttom_center);
			} else {
				c.setCellStyle(style_content_center);
			}

			c = row.createCell(nIndex++);
			c.setCellValue(stu.getStudentage());
			if (i == list.size() - 1) {
				c.setCellStyle(style_buttom_center);
			} else {
				c.setCellStyle(style_content_center);
			}

			c = row.createCell(nIndex++);
			c.setCellValue(stu.getStudenttel());
			if (i == list.size() - 1) {
				c.setCellStyle(style_buttom_center);
			} else {
				c.setCellStyle(style_content_center);
			}
			c = row.createCell(nIndex++);
			c.setCellValue(stu.getStudentaddress());
			if (i == list.size() - 1) {
				c.setCellStyle(style_buttom_center);
			} else {
				c.setCellStyle(style_content_center);
			}
			c = row.createCell(nIndex++);
			c.setCellValue(stu.getClassInfo().getClassid());
			if (i == list.size() - 1) {
				c.setCellStyle(style_buttom_center);
			} else {
				c.setCellStyle(style_content_center);
			}
			
			c = row.createCell(nIndex++);
			c.setCellValue(stu.getClassInfo().getClassname());
			if (i == list.size() - 1) {
				c.setCellStyle(style_buttom_right);
			} else {
				c.setCellStyle(style_content_right);
			}
		}
		// 第六步，下载文件
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String filename = cal.get(Calendar.YEAR) + "" + (cal.get(Calendar.MONTH) + 1) + cal.get(Calendar.DAY_OF_MONTH)
				+ "_学生信息表.xls";
		try {
			filename = encodeChineseDownloadFileName(request, filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-disposition", filename);
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename=" + filename);
		response.setHeader("Pragma", "No-cache");
		OutputStream ouputStream = null;

		try {
			
			ouputStream = response.getOutputStream();
			wb.write(ouputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ouputStream.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				ouputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return;

	}
	
	/**
	 * 导出excel编码格式转换
	 * @param request
	 * @param pFileName
	 * @return
	 * @throws Exception
	 */
	public static String encodeChineseDownloadFileName(HttpServletRequest request, String pFileName) throws Exception {

		String filename = null;
		String agent = request.getHeader("USER-AGENT");
		if (null != agent) {
			if (-1 != agent.indexOf("Firefox")) {// Firefox
				filename = "=?UTF-8?B?"
						+ (new String(org.apache.commons.codec.binary.Base64.encodeBase64(pFileName.getBytes("UTF-8"))))
						+ "?=";
			} else if (-1 != agent.indexOf("Chrome")) {// Chrome
				filename = new String(pFileName.getBytes(), "ISO8859-1");
			} else {// IE7+
				filename = java.net.URLEncoder.encode(pFileName, "UTF-8");
				filename = filename.replace("+", "%20");
			}
		} else {
			filename = pFileName;
		}
		return filename;
	}

}
