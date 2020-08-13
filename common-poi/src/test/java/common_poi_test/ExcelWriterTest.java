
package common_poi_test;

import com.uih.uplus.common.utils.basic.CollUtil;
import com.uih.uplus.common.utils.poi.excel.ExcelUtil;
import com.uih.uplus.common.utils.poi.excel.ExcelWriter;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

//如果不writer.close()释放空间，无法创建文件
//写出集合数据
public class ExcelWriterTest {
//    @Test
//    public  void testwww(){
//
//        //第一步创建一个要写入的数据集合
//        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
//        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
//        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
//        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
//        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
//        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
//        //第二步使用ExcelWriter写出数据到文件
//        //通过工具类创建writer
//        //ExcelWriter writer = ExcelUtil.getWriter("E:\\common_lib_test\\writeExcelTest3.xlsx");
//        ExcelWriter writer = ExcelUtil.getWriter("E:\\common_lib_test\\common-poi\\writeExcelTest4.xlsx");
//        //通过构造方法创建writer
//        //ExcelWriter writer = new ExcelWriter("d:/writeTest.xls");
//        //跳过当前行，既第一行，非必须，在此演示用
//        writer.passCurrentRow();
//        //合并单元格后的标题行，使用默认标题样式
//        writer.merge(row1.size() - 1, "测试标题");
//        //设置样式集，如果不使用样式，传入null
//        writer.setStyleSet(null);
//        //获取样式集
//        writer.getStyleSet();
//        //获取头部样式
//        //writer.getHeadCellStyle();
//        //获取单元格样式
//        //writer.getCellStyle();
//        //获得当前指向行数
//        writer.getCurrentRow();
//        //增加下拉列表	1.列号，从0开始；2.行号，从0开始；3.下拉列表内容
//        writer.addSelect(3,3,"成绩");
//        //判断是否为xlsx格式的Excel表
//        writer.isXlsx();
//        //获取第一行总列数
//        writer.getColumnCount();
//        //获取总行数
//        writer.getRowCount();
//        //一次性写出内容，强制输出标题
//        writer.write(rows, true);
//        //关闭writer，释放内存
//        writer.close();
//    }
    @Test
    public void ExcelwriteSuccess(){
        //第一步创建一个要写入的数据集合
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        //第二步使用ExcelWriter写出数据到文件
        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("E:\\common_lib_test\\common-poi\\writeExcelTest19.xlsx");
        writer.write(rows, true);
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteNewSuccess(){
        //第一步创建一个要写入的数据集合
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        //第二步使用ExcelWriter写出数据到文件
        //通过工具类创建writer
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest19.xlsx");
        writer.write(rows, true);
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteErrorNoF(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = null;
        try {
            writer = ExcelUtil.getWriter("F:\\");
            writer.write(rows, true);
            writer.close();

        } catch (Exception e) {
            Assert.assertNotNull(writer);
        }
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteNewErrorNoF(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = null;
        try {
            writer = new ExcelWriter("F:\\");
            writer.write(rows, true);
            writer.close();

        } catch (Exception e) {
            Assert.assertNotNull(writer);
        }
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteErrorNoPath(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = null;
        try {
            writer = ExcelUtil.getWriter("");
            writer.write(rows, true);
            writer.close();
        } catch (Exception e) {
            Assert.assertNull(writer);
        }
        Assert.assertNull(writer);
    }
    @Test
    public void ExcelwriteNewErrorNoPath(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = null;
        try {
            writer = new ExcelWriter("");
            writer.write(rows, true);
            writer.close();
        } catch (Exception e) {
            Assert.assertNull(writer);
        }
        Assert.assertNull(writer);
    }
    @Test
    public void ExcelwriteErrortxt(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = ExcelUtil.getWriter("E:\\common_lib_test\\common-poi\\writeExcelTesttxt.txt");
        writer.write(rows, true);
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteNewErrortxt(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTesttxt.txt");
        writer.write(rows, true);
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteSetnameSheetSuccess(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest11.xlsx");
        writer.setSheet("切换到新sheet，sheet2");
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteSetnameSheetSuccess2(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest10.xlsx");
        writer.setSheet(3);
        List<String> aa=writer.getSheetNames();
        writer.close();
        Assert.assertNotNull(aa);
    }
    @Test
    public void ExcelwriteSetnameSheetError(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest9.xlsx");
        writer.setSheet(-1);
        List<String> aa=writer.getSheetNames();
        writer.close();
        Assert.assertNotNull(aa);
    }
    @Test
    public void ExcelwriteRenameSheetSuccess(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest8.xlsx");
        List<String> aa=null;
        List<String> list=null;
        try {
            writer.renameSheet("sheettest1");
            aa=writer.getSheetNames();
            list=new ArrayList<>(Arrays.asList("sheettest1"));
            writer.close();
        } catch (Exception e) {
            Assert.assertEquals(aa,list);
        }
        Assert.assertEquals(aa,list);
    }
    @Test
    public void ExcelwriteRenameSheetSuccess2(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest6.xlsx");
        //writer.renameSheet(0,"sheettest");
        //List<String> aa=writer.getSheetNames();
        List<String> aa=null;
        //List<String> list = new ArrayList<>(Arrays.asList("sheettest","sheet1"));
        List<String> list = null;
        try {
            writer.renameSheet(0,"sheettest");
            aa=writer.getSheetNames();
            list = new ArrayList<>(Arrays.asList("sheettest","sheet1"));
            writer.close();
        } catch (Exception e) {
            Assert.assertEquals(aa,list);
        }
        Assert.assertEquals(aa,list);
    }
    @Test
    public void ExcelwriteRenameSheetError(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = null;
        List<String> aa=null;
        try {
            writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest7.xlsx");
            writer.renameSheet(-1,"sheettest");
            aa=writer.getSheetNames();
            writer.close();
        } catch (Exception e) {
            Assert.assertNull(aa);
        }
        Assert.assertNull(aa);
    }
    @Test
    public void ExcelwriteRenameSheetError2(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = null;
        List<String> aa=null;
        try {
            writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest7.xlsx");
            writer.renameSheet(1,"sheettest");
            aa=writer.getSheetNames();
            writer.close();
        } catch (Exception e) {
            Assert.assertNull(aa);
        }
        Assert.assertNull(aa);
    }
    @Test
    public void ExcelwriteautoSizeColumnSuccess(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest11.xlsx");
        writer.write(rows, true);
        writer.autoSizeColumnAll();
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteautoSizeColumnSuccess2(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest12.xlsx");
        writer.write(rows, true);
        writer.autoSizeColumn(2);
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteautoSizeColumnToobigError(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest13.xlsx");
        writer.write(rows, true);
        writer.autoSizeColumn(10);
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteautoSizeColumnToosmallError(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest13.xlsx");
        writer.write(rows, true);
        try {
            writer.autoSizeColumn(-1);
            writer.close();
        } catch (Exception e) {
            Assert.assertNotNull(writer);
        }
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteCurrentRowSuccess(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest14.xlsx");
        writer.write(rows, true);
        int rownum=writer.getCurrentRow();
        System.out.println(rownum);
        writer.close();
        Assert.assertEquals(rownum,5);
    }
    @Test
    public void ExcelwriteCurrentRowSuccess2(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest15.xlsx");
        writer.write(rows, true);
        writer.passCurrentRow();
        int rownum=writer.getCurrentRow();
        System.out.println(rownum);
        writer.close();
        Assert.assertEquals(rownum-1,4);
    }
    @Test
    public void ExcelwriteCurrentRowSuccess3(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest16.xlsx");
        writer.write(rows, true);
        writer.passRows(100);
        int rownum=writer.getCurrentRow();
        System.out.println(rownum);
        writer.close();
        Assert.assertEquals(rownum,104);
    }
    @Test
    public void ExcelwriteCurrentRowSuccess4(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest17.xlsx");
        writer.write(rows, true);
        writer.passRows(-1);
        int rownum=writer.getCurrentRow();
        System.out.println(rownum);
        writer.close();
        Assert.assertEquals(rownum,3);
    }
    @Test
    public void ExcelwriteSetCurrentRowSuccess(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest18.xlsx");
        writer.write(rows, true);
        writer.setCurrentRow(-1);
        int rownum=writer.getCurrentRow();
        System.out.println(rownum);
        writer.close();
        Assert.assertEquals(rownum,-1);
    }
    @Test
    public void ExcelwriteSetCurrentWidthSuccess(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest20.xlsx");
        writer.write(rows, true);
        writer.setColumnWidth(1,100);
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteSetCurrentWidthSuccess2(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest21.xlsx");
        writer.write(rows, true);
        writer.setColumnWidth(1,-100);
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteSetCurrentWidthSuccess3(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest21.xlsx");
        writer.write(rows, true);
        writer.setColumnWidth(5,100);
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteSetCurrentWidthToobigError(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest22.xlsx");
        writer.write(rows, true);
        try {
            writer.setColumnWidth(5,288);
            writer.close();
        } catch (Exception e) {
            Assert.assertNotNull(writer);
        }
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteSetRowHeightSuccess(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest23.xlsx");
        writer.write(rows, true);
        writer.setRowHeight(1,50);
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteSetRowHeightSuccess2(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest24.xlsx");
        writer.write(rows, true);
        writer.setRowHeight(1,-100);
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteSetRowHeightSuccess3(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest25.xlsx");
        writer.write(rows, true);
        writer.setRowHeight(-1,50);
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteAddSelectSuccess(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest26.xlsx");
        writer.write(rows, true);
        writer.addSelect(1,1,"下拉试试");
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteAddSelectSuccess2(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest27.xlsx");
        writer.write(rows, true);
        writer.addSelect(-1,-1,"下拉试试");
        writer.close();
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteMergeSuccess(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest28.xlsx");
        writer.write(rows, true);
        try {
            writer.merge(2);
            writer.close();
        } catch (Exception e) {
            Assert.assertNotNull(writer);
        }
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteMergeSuccess2(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest29.xlsx");
        writer.write(rows, true);
        try {
            writer.merge(2,"测试",true);
            writer.close();
        } catch (Exception e) {
            Assert.assertNotNull(writer);
        }
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteMergeSuccess3(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest30.xlsx");
        writer.write(rows, true);
        try {
            writer.merge(1,2,1,2,"测试",true);
            writer.close();
        } catch (Exception e) {
            Assert.assertNotNull(writer);
        }
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteMergeError(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest31.xlsx");
        writer.write(rows, true);
        try {
            writer.merge(0);
            writer.close();
        } catch (Exception e) {
            Assert.assertNotNull(writer);
        }
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteMergeError2(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest32.xlsx");
        writer.write(rows, true);
        try {
            writer.merge(2,2,2,2,"测试",true);
            writer.close();
        } catch (Exception e) {
            Assert.assertNotNull(writer);
        }
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwriteMergeError3(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest33.xlsx");
        writer.write(rows, true);
        try {
            writer.merge(0,"测试",true);
            writer.close();
        } catch (Exception e) {
            Assert.assertNotNull(writer);
        }
        Assert.assertNotNull(writer);
    }
    @Test
    public void ExcelwritegetOrCreateCellSuccess(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest34.xlsx");
        writer.write(rows, true);
        Cell a=writer.getOrCreateCell(2,2);
        writer.close();
        Assert.assertEquals("cc2",row3.get(2));
    }
    @Test
    public void ExcelwritegetOrCreateCellSuccess2(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest35.xlsx");
        writer.write(rows, true);
        Cell a=writer.getOrCreateCell(5,5);
        writer.close();
        Assert.assertNotNull(a);
    }
    @Test
    public void ExcelwritegetOrCreateCellError(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest36.xlsx");
        writer.write(rows, true);
        Cell a=null;
        try {
            a=writer.getOrCreateCell(-1,-1);
            writer.close();
        } catch (Exception e) {
            Assert.assertNull(a);
        }
        Assert.assertNull(a);
    }
    @Test
    public void ExcelwritegetOrCreateRowSuccess(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest37.xlsx");
        writer.write(rows, true);
        Row a=writer.getOrCreateRow(3);
        writer.close();
        Assert.assertEquals("dd3",row4.get(3));
    }
    @Test
    public void ExcelwritegetOrCreateRowError(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest38.xlsx");
        writer.write(rows, true);
        Row a=null;
        try {
            a=writer.getOrCreateRow(-1);
            writer.close();
        } catch (Exception e) {
            Assert.assertNull(a);
        }
        Assert.assertNull(a);
    }
    @Test
    public void ExcelwritegetColumnCountSuccess(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1","ee1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest39.xlsx");
        writer.write(rows, true);
        int num=writer.getColumnCount();
        writer.close();
        Assert.assertEquals(num,4);
    }
    @Test
    public void ExcelwritegetColumnCountSuccess2(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1","ee1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest40.xlsx");
        writer.write(rows, true);
        int num=writer.getColumnCount(1);
        writer.close();
        Assert.assertEquals(num,5);
    }
    @Test
    public void ExcelwritegetColumnCountError(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1","ee1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest41.xlsx");
        writer.write(rows, true);
        int num=writer.getColumnCount(5);
        writer.close();
        Assert.assertEquals(num,-1);
    }
    @Test
    public void ExcelwritegetColumnCountError2(){
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1","ee1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest42.xlsx");
        writer.write(rows, true);
        int num=writer.getColumnCount(-1);
        writer.close();
        Assert.assertEquals(num,-1);
    }
    @Test
    public void ExcelwritegetRowCountSuccess(){
        List<String> row1 = CollUtil.newArrayList();
        List<String> row2 = CollUtil.newArrayList();
        List<String> row3 = CollUtil.newArrayList();
        List<String> row4 = CollUtil.newArrayList();
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest43.xlsx");
        writer.write(rows, true);
        int num=writer.getRowCount();
        writer.close();
        Assert.assertEquals(num,4);
    }
    @Test
    public void ExcelwriteisXlsxSuccess(){
        List<String> row1 = CollUtil.newArrayList();
        List<String> row2 = CollUtil.newArrayList();
        List<String> row3 = CollUtil.newArrayList();
        List<String> row4 = CollUtil.newArrayList();
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest43.xlsx");
        writer.write(rows, true);
        boolean xlsx=writer.isXlsx();
        writer.close();
        Assert.assertEquals(xlsx,true);
    }
    @Test
    public void ExcelwriteisXlsxSuccess2(){
        List<String> row1 = CollUtil.newArrayList();
        List<String> row2 = CollUtil.newArrayList();
        List<String> row3 = CollUtil.newArrayList();
        List<String> row4 = CollUtil.newArrayList();
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\common-poi\\writeExcelTest43.txt");
        writer.write(rows, true);
        boolean xlsx=writer.isXlsx();
        writer.close();
        Assert.assertEquals(xlsx,false);
    }

    @Test
    public void testwriteexcel() {
        //第一步创建一个要写入的数据集合
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        //第二步使用ExcelWriter写出数据到文件
        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("E:\\common_lib_test\\common-poi\\writeExcelTest.xlsx");
        //通过构造方法创建writer
        //ExcelWriter writer = new ExcelWriter("E:\\common_lib_test\\writeExcelTest.xlsx");
        //跳过当前行，既第一行，非必须，在此演示用
        writer.passCurrentRow();
        //合并单元格后的标题行，使用默认标题样式
        //writer.merge(row1.size() - 1, "测试标题");
        //设置所有列为自动宽度，不考虑合并单元格
        writer.autoSizeColumnAll();
        //一次性写出内容，强制输出标题
        writer.write(rows, true);
        //关闭writer，释放内存
        writer.close();
        Assert.assertNotNull(writer);
   }
    //写出Map数据
    @Test
    public void writeMapTest() {
        //第一步创建一个要写入的数据Map
        Map<String, Object> row1 = new LinkedHashMap<>();
        row1.put("姓名", "张三");
        row1.put("年龄", 23);
        Map<String, Object> row2 = new LinkedHashMap<>();
        row2.put("姓名", "李四");
        row2.put("年龄", 33);
        ArrayList<Map<String, Object>> rows = (ArrayList<Map<String, Object>>) CollUtil.newArrayList(row1, row2);
        //第二步使用ExcelWriter写出数据到文件
        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        // 合并单元格后的标题行，使用默认标题样式
        //writer.merge(row1.size() - 1, "测试名单");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
        // 关闭writer，释放内存
        writer.close();
        Assert.assertNotNull(writer);
    }
//
//    @Test
//    public void test_write_excel0() throws IOException {
//
//        Assert.assertTrue(true);
//
//        File directory = new File("");
//        String absolutePath = directory.getAbsolutePath();
//        //第一步创建一个要写入的数据Map
//        Map<String, Object> row1 = new LinkedHashMap<>();
//        row1.put("姓名", "张三");
//        row1.put("年龄", 23);
//        Map<String, Object> row2 = new LinkedHashMap<>();
//        row2.put("姓名", "李四");
//        row2.put("年龄", 33);
//        ArrayList<Map<String, Object>> rows = (ArrayList<Map<String, Object>>) CollUtil.newArrayList(row1, row2);
//        //第二步使用ExcelWriter写出数据到文件
//        // 通过工具类创建writer
//        ExcelWriter writer = ExcelUtil.getWriter();
//        // 一次性写出内容，使用默认样式，强制输出标题
//        writer.write(rows, true);
//        //response为HttpServletResponse对象
//        HttpServletResponse response = null;
//        response.setContentType("application/vnd.ms-excel;charset=utf-8");
//        //test.xlsx是弹出下载对话框的文件名，中文名需再编码
//        response.setHeader("Content-Disposition","attachment;filename=test.xlsx");
//        ServletOutputStream out=response.getOutputStream();
//        //将Excel Workbook刷出到流
//        writer.flush(out, true);
//        // 关闭writer，释放内存
//        writer.close();
//    }

}
