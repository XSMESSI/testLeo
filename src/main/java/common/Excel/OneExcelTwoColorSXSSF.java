package common.Excel;



import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @Description SXSSFWorkbook
 * @Author XuShen
 * @Date 2022/8/19 15:13
 */
public class OneExcelTwoColorSXSSF {
    public static void main( String[] args ) throws IOException {

        SXSSFWorkbook wb = new SXSSFWorkbook();

        Sheet sheet = wb.createSheet("自定义单元格");

        Row row  = sheet.createRow(5);

        Cell cell = row.createCell(5);

        CellStyle cellStyle = wb.createCellStyle();

        Font font = wb.createFont();

        font.setColor(HSSFFont.COLOR_RED);
//        font.setColor(HSSFColor.BLACK.index);

        font.setFontName("宋体");

        font.setFontHeight((short)700);

        Font font2 = wb.createFont();

        font2.setColor(HSSFFont.COLOR_NORMAL);
//        font2.setColor(HSSFColor.RED.index);

        font2.setFontName("黑体");

        font2.setFontHeight((short)800);
//        font2.setBoldweight((short)700);

        cellStyle.setFont(font2);

//        cell.setCellStyle(cellStyle);

        String txt = "测试数据*必填*";

//        HSSFRichTextString text = new HSSFRichTextString(txt);
//        /**
//         * 必填字段的文字样式要求：
//         * 该单元格重点的字体中如果包含*必填*,整个单元格中的字体，只有*必填*显示红色，其余均显示黑色,
//         * 如果单元格中不包含*必填*,全部显示红色
//         */
//        System.out.println(txt.indexOf("*必填*"));
//        if (txt.contains("*必填*")){
//            //黑色
//            text.applyFont(0,txt.indexOf("*必填*")+1,font2);
//            //红色
//            text.applyFont(txt.indexOf("*必填*"),txt.length(),font);
//        }

//        XSSFRichTextString text = new XSSFRichTextString(txt);
//        text.applyFont(0,2,font2);
//        text.applyFont(2,5,font);
//        cell.setCellValue(text);

        RichTextString text1 = cell.getRichStringCellValue();
        text1.applyFont(0,2,font2);
        text1.applyFont(2,5,font);
        cell.setCellValue(text1);
//        sheet.autoSizeColumn(5,true);
        String fileName = "SXSSF测试一个单元格两个颜色" + System.currentTimeMillis() + ".xlsx";

        File file = new File("E:\\AA公司文档\\测试文档\\" + fileName);
        System.out.println("导出成功");
        System.out.println(file.getPath());
        if(file.exists()){

            file.delete();

        }

        file.createNewFile();

        wb.write(new FileOutputStream( file ));

    }
}
