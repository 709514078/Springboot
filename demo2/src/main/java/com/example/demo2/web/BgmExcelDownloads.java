package com.example.demo2.web;

import com.example.demo2.entity.Bgm;
import com.example.demo2.service.BgmService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


@RestController
@RequestMapping("/BgmExcelDownloads")
@CrossOrigin
public class BgmExcelDownloads {

    @Autowired
    private BgmService bgmService;

    @RequestMapping(value = "/downloadsExcelDown", method = RequestMethod.GET,consumes = Bgm.CONTENT_TYPE_FROMED)
    public void downloadsExcelDown(HttpServletResponse response) throws IOException {
        List<Bgm> bgmExcelDownloads = bgmService.getBgmList();
        System.out.printf("------------" + bgmExcelDownloads.toString());
        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("获取excel测试表格");

        HSSFRow row = null;

        row = sheet.createRow(0);//创建第一个单元格
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("用户信息列表");//为第一行单元格设值

        /*为标题设计空间
         * firstRow从第1行开始
         * lastRow从第0行结束
         *
         *从第1个单元格开始
         * 从第3个单元格结束
         */
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 2);
        sheet.addMergedRegion(rowRegion);

      /*CellRangeAddress columnRegion = new CellRangeAddress(1,4,0,0);
      sheet.addMergedRegion(columnRegion);*/

        row = sheet.createRow(1);
        row.setHeight((short) (22.50 * 20));//设置行高
        row.createCell(0).setCellValue("Id");//为第一个单元格设值
        row.createCell(1).setCellValue("作者");//为第二个单元格设值
        row.createCell(2).setCellValue("歌名");//为第三个单元格设值
        row.createCell(2).setCellValue("路径");//为第四个单元格设值

        for (int i = 0; i < bgmExcelDownloads.size(); i++) {
            row = sheet.createRow(i + 2);
            Bgm bgm = bgmExcelDownloads.get(i);
            row.createCell(0).setCellValue(bgm.getId());
            row.createCell(1).setCellValue(bgm.getAuthor());
            row.createCell(2).setCellValue(bgm.getName());
            row.createCell(2).setCellValue(bgm.getPath());
        }
        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=BGM.xls");//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();


//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet("信息表");
//        List<Bgm> bgmExcelDownloads = bgmService.getBgmList();
//        //设置要导出的文件名字
//        String fileName = "Bgm" + ".xls";
//        int rowNum = 1;
//        //headers表示excel表中第一行的表头 在excel表中添加表头
//        String [] headers = {"ID","姓名","歌名","路径"};
//        HSSFRow row = sheet.createRow(0);
//        for (int i = 0;i<headers.length;i++){
//            HSSFCell cell = row.createCell(i);
//            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
//            cell.setCellValue(text);
//        }
//        for (Bgm bgm : bgmExcelDownloads){
//            HSSFRow row1 = sheet.createRow(rowNum);
//            row1.createCell((short) 0).setCellValue(new HSSFRichTextString(bgm.getId()));
//            row1.createCell((short) 1).setCellValue(new HSSFRichTextString(bgm.getAuthor()));
//            row1.createCell((short) 2).setCellValue(new HSSFRichTextString(bgm.getName()));
//            row1.createCell((short) 3).setCellValue(new HSSFRichTextString(bgm.getPath()));
//            rowNum++;
//
//        }
//        response.setContentType("application/octet-stream");
//        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
//        response.flushBuffer();
//        workbook.write(response.getOutputStream());
//
    }


}
