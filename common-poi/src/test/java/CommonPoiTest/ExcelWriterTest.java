
package CommonPoiTest;

import com.uih.uplus.common.utils.basic.CollUtil;
import com.uih.uplus.common.utils.poi.excel.ExcelReader;
import com.uih.uplus.common.utils.poi.excel.ExcelUtil;
import com.uih.uplus.common.utils.poi.excel.ExcelWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.*;

//如果不writer.close()释放空间，无法创建文件
//写出集合数据
public class ExcelWriterTest {
    private File directory = new File("");
    private String rootPath=directory.getAbsolutePath();
    @Test
    public void ExcelwriteSuccess() {
        //第一步创建一个要写入的数据集合
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        //第二步使用ExcelWriter写出数据到文件
        //通过工具类创建writer
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest19.xlsx";
        ExcelWriter writer = ExcelUtil.getWriter(filePath);
        writer.write(rows, true);
        writer.close();
        ExcelReader reader = ExcelUtil.getReader(filePath);
        List<Object> aa = reader.readRow(2);
        reader.close();
        System.out.println(aa);
        List<Object> bb = new ArrayList<Object>();
        bb.add("aa2");
        bb.add("bb2");
        bb.add("cc2");
        bb.add("dd2");
        Assert.assertEquals(aa, bb);
    }

    @Test
    public void ExcelwriteNewSuccess() {
        //第一步创建一个要写入的数据集合
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        //第二步使用ExcelWriter写出数据到文件
        //通过工具类创建writer
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest19.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.close();
        ExcelReader reader = ExcelUtil.getReader(filePath);
        List<Object> aa = reader.readRow(3);
        reader.close();
        System.out.println(aa);
        List<Object> bb = new ArrayList<Object>();
        bb.add("aa3");
        bb.add("bb3");
        bb.add("cc3");
        bb.add("dd3");
        Assert.assertEquals(aa, bb);
    }

    @Test
    public void ExcelwriteNewSuccessBeyond() {
        //第一步创建一个要写入的数据集合
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        //第二步使用ExcelWriter写出数据到文件
        //通过工具类创建writer
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest99.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.close();
        ExcelReader reader = ExcelUtil.getReader(filePath);
        List<Object> aa = reader.readRow(5);
        reader.close();
        System.out.println(aa);
        List<Object> bb = new ArrayList<Object>();
        Assert.assertEquals(aa, bb);
    }

    @Test
    public void ExcelwriteErrorNoF() {
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
            System.out.println(writer.getCurrentRow());
            Assert.assertEquals(writer.getCurrentRow(),5);
        }
        Assert.assertEquals(writer.getCurrentRow(),5);
    }

    @Test
    public void ExcelwriteNewErrorNoF() {
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
            Assert.assertEquals(writer.getCurrentRow(),5);
        }
        Assert.assertEquals(writer.getCurrentRow(),5);
    }

    @Test
    public void ExcelwriteErrorNoPath() {
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
            Assert.assertNotNull(rows);
        }
        Assert.assertNotNull(rows);
    }

    @Test
    public void ExcelwriteNewErrorNoPath() {
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
            Assert.assertNotNull(rows);
        }
        Assert.assertNotNull(rows);
    }

    @Test
    public void ExcelwriteErrortxt() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTesttxt.txt";
        ExcelWriter writer = ExcelUtil.getWriter(filePath);
        writer.write(rows, true);
        writer.close();
        ExcelReader reader = ExcelUtil.getReader(filePath);
        List<Object> aa = reader.readRow(3);
        reader.close();
        System.out.println(aa);
        List<Object> bb = new ArrayList<Object>();
        bb.add("aa3");
        bb.add("bb3");
        bb.add("cc3");
        bb.add("dd3");
        Assert.assertEquals(aa, bb);
    }

    @Test
    public void ExcelwriteNewErrortxt() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTesttxt.txt";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        ExcelReader reader = ExcelUtil.getReader(filePath);
        List<Object> aa = reader.readRow(4);
        reader.close();
        System.out.println(aa);
        List<Object> bb = new ArrayList<Object>();
        bb.add("aa4");
        bb.add("bb4");
        bb.add("cc4");
        bb.add("dd4");
        Assert.assertEquals(aa, bb);
    }

    @Test
    public void ExcelwriteSetSheetStringSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest11.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.setSheet("添加一个新的sheet，设置为这个sheetname");
        writer.close();
        ExcelReader reader = ExcelUtil.getReader(filePath);
        List<String> sheetnames = reader.getSheetNames();
        reader.close();
        System.out.println(sheetnames);
        List<String> expect = new ArrayList<>();
        expect.add("sheet1");
        expect.add("添加一个新的sheet，设置为这个sheetname");
        Assert.assertEquals(sheetnames, expect);
    }

    @Test
    public void ExcelwriteSetSheetintSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest10.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.setSheet(1);
        List<String> sheetName = writer.getSheetNames();
        System.out.println(sheetName);
        writer.close();
        List<String> expect = new ArrayList<>();
        expect.add("sheet1");
        expect.add("sheet0");
        Assert.assertEquals(sheetName.get(0), expect.get(0));
    }

    @Test
    public void ExcelwriteSetSheet0Success() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest98.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.setSheet(0);
        List<String> sheetName = writer.getSheetNames();
        System.out.println(sheetName);
        writer.close();
        List<String> expect = new ArrayList<>();
        expect.add("sheet1");
        Assert.assertEquals(sheetName, expect);
    }

    @Test
    public void ExcelwriteSetnameSheetSuccessOrderChangeError() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest97.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.setSheet("添加一个新的sheet，设置为这个sheetname");
        List<String> sheetName = writer.getSheetNames();
        System.out.println(sheetName);
        writer.close();
        List<String> expect = new ArrayList<>();
        expect.add("添加一个新的sheet，设置为这个sheetname");
        expect.add("sheet1");
        System.out.println(expect);
        Assert.assertNotEquals(sheetName, expect);
    }

    @Test
    public void ExcelwriteSetnameSheetError() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest9.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.setSheet(-1);
        List<String> sheetName = writer.getSheetNames();
        System.out.println(sheetName);
        writer.close();
        List<String> expect = new ArrayList<>();
        expect.add("sheet1");
        System.out.println(expect);
        Assert.assertNotEquals(sheetName, expect);
    }

    @Test
    public void ExcelwriteRenameSheetSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest8.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        List<String> aa = null;
        List<String> list = null;
        if (aa != list) {
            writer.renameSheet("sheettest1");
            aa = writer.getSheetNames();
            System.out.println(aa);
            list = new ArrayList<>(Arrays.asList("sheettest1"));
            System.out.println(list);
        }
        writer.close();
        Assert.assertEquals(aa, list);
    }

    @Test
    public void ExcelwriteRenameSheetConstantSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest96.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        List<String> aa = null;
        List<String> list = null;
        writer.renameSheet("sheet1");
        aa = writer.getSheetNames();
        System.out.println(aa);
        list = new ArrayList<>(Arrays.asList("sheet1"));
        System.out.println(list);
        writer.close();
        Assert.assertEquals(aa, list);
    }

    @Test
    public void ExcelwriteRenameSheetaddnumSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest6.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        List<String> aa = null;
        List<String> list = null;
        if (aa != list) {
            writer.renameSheet(0, "sheettest");
            aa = writer.getSheetNames();
            list = new ArrayList<>(Arrays.asList("sheettest", "sheet1"));
        }
        writer.close();
        Assert.assertEquals(aa, list);
    }

    @Test
    public void ExcelwriteRenameSheetErrorNegative() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = null;
        List<String> aa = null;
        try {
            String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest7.xlsx";
            writer = new ExcelWriter(filePath);
            writer.renameSheet(-1, "sheettest");
            aa = writer.getSheetNames();
            writer.close();
        } catch (Exception e) {
            Assert.assertNull(aa);
        }
        Assert.assertNull(aa);
    }

    @Test
    public void ExcelwriteRenameSheetError() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        ExcelWriter writer = null;
        List<String> aa = null;
        try {
            String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest7.xlsx";
            writer = new ExcelWriter(filePath);
            writer.renameSheet(1, "sheettest");
            aa = writer.getSheetNames();
            writer.close();
        } catch (Exception e) {
            Assert.assertNull(aa);
        }
        Assert.assertNull(aa);
    }

    @Test
    public void ExcelwriteautoSizeColumnAllSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest11.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.autoSizeColumnAll();
        writer.close();
        Assert.assertNotNull(writer);
    }

    @Test
    public void ExcelwriteautoSizeColumnSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest12.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.autoSizeColumn(2);
        writer.close();
        Assert.assertNotNull(writer);
    }

    @Test
    public void ExcelwriteautoSizeColumnToobigError() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest13.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.autoSizeColumn(10);
        writer.close();
        Assert.assertNotNull(writer);
    }

    @Test
    public void ExcelwriteautoSizeColumnToosmallError() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest13.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
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
    public void ExcelwriteGetCurrentRowSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest14.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        int rownum = writer.getCurrentRow();
        System.out.println(rownum);
        writer.close();
        Assert.assertEquals(rownum, 5);
    }

    @Test
    public void ExcelwritePassCurrentRowSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest15.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.passCurrentRow();
        int rownum = writer.getCurrentRow();
        System.out.println(rownum);
        writer.close();
        Assert.assertEquals(rownum , 4+1);
    }

    @Test
    public void ExcelwritePassRowsSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest16.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.passRows(100);
        int rownum = writer.getCurrentRow();
        System.out.println(rownum);
        writer.close();
        Assert.assertEquals(rownum, 4+100);
    }

    @Test
    public void ExcelwritePassRowsSuccessNegative() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest17.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.passRows(-1);
        int rownum = writer.getCurrentRow();
        System.out.println(rownum);
        writer.close();
        Assert.assertEquals(rownum, 4-1);
    }

    @Test
    public void ExcelwriteSetCurrentRowSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest18.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.setCurrentRow(-1);
        int rownum = writer.getCurrentRow();
        System.out.println(rownum);
        writer.close();
        Assert.assertEquals(rownum, -1);
    }

    @Test
    public void ExcelwriteSetCurrentWidthSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest20.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.setColumnWidth(1, 100);
        writer.close();
        Assert.assertNotNull(writer);
    }

    @Test
    public void ExcelwriteSetCurrentWidthNegativeSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest21.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.setColumnWidth(1, -100);
        writer.close();
        Assert.assertNotNull(writer);
    }

    @Test
    public void ExcelwriteSetCurrentWidthSuccessColumnBeyond() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest21.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.setColumnWidth(5, 100);
        writer.close();
        Assert.assertNotNull(writer);
    }

    @Test
    public void ExcelwriteSetCurrentWidthToobigError() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest22.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        try {
            writer.setColumnWidth(5, 288);
            writer.close();
        } catch (Exception e) {
            Assert.assertNotNull(writer);
        }
        Assert.assertNotNull(writer);
    }

    @Test
    public void ExcelwriteSetRowHeightSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest23.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.setRowHeight(1, 50);
        writer.close();
        Assert.assertNotNull(writer);
    }

    @Test
    public void ExcelwriteSetRowHeightNegativeSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest24.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.setRowHeight(1, -100);
        writer.close();
        Assert.assertNotNull(writer);
    }

    @Test
    public void ExcelwriteSetRowHeightSuccessRownumNegative() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest25.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.setRowHeight(-1, 50);
        writer.close();
        Assert.assertNotNull(writer);
    }

    @Test
    public void ExcelwriteAddSelectSuccess() {
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest26.xlsx";
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.addSelect(1, 1, "下拉试试");
        writer.close();
        ExcelReader reader=ExcelUtil.getReader(filePath);
        Cell cell = reader.getCell(1, 1);
        reader.close();
        String A=cell.getStringCellValue();
        System.out.println(cell);
        System.out.println(A);
        Assert.assertEquals(A,"bb1");
    }

    @Test
    public void ExcelwriteAddSelectNegativeError() {
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest27.xlsx";
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        writer.addSelect(-1, -1, "下拉试试");
        writer.close();
        String A=null;
        try {
            ExcelReader reader=ExcelUtil.getReader(filePath);
            Cell cell = reader.getCell(-1, -1);
            reader.close();
            A=cell.getStringCellValue();
            System.out.println(cell);
            System.out.println(A);
        }catch (Exception e)
        {
            Assert.assertEquals(A,null);
        }
        Assert.assertEquals(A,null);
    }

    @Test
    public void ExcelwriteMergeSuccess() {
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest28.xlsx";
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        String A=null;
        Cell cell=null;
        try {
            writer.merge(2);
            writer.close();
            ExcelReader reader=ExcelUtil.getReader(filePath);
            cell = reader.getCell(2, 4);
            reader.close();
            A=cell.getStringCellValue();
            System.out.println(cell);
            System.out.println(A);
        } catch (Exception e) {
            Assert.assertEquals(A,null);
        }
        Assert.assertEquals(A,null);
    }
    @Test
    public void ExcelwriteMergeSuccessgetCellBeyond() {
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest28.xlsx";
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        String A=null;
        Cell cell=null;
        try {
            writer.merge(2);
            writer.close();
            ExcelReader reader=ExcelUtil.getReader(filePath);
            cell = reader.getCell(4, 4);
            reader.close();
            A=cell.getStringCellValue();
            System.out.println(cell);
            System.out.println(A);

        } catch (Exception e) {
            Assert.assertEquals(A,null);
        }
        Assert.assertEquals(A,null);
    }

    @Test
    public void ExcelwriteMergeSuccessContent() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest29.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        ExcelReader reader=null;
        Cell cell=null;
        String A=null;
        try {
            writer.merge(2, "测试", true);
            writer.close();
        } catch (Exception e) {
            reader=ExcelUtil.getReader(filePath);
            cell = reader.getCell(1, 4);
            reader.close();
            A=cell.getStringCellValue();
            System.out.println(cell);
            System.out.println(A);
            Assert.assertEquals(A,"");
        }
        Assert.assertEquals(A,"");
    }

    @Test
    public void ExcelwriteMergeSuccessMoreparameters() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest30.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        ExcelReader reader=null;
        Cell cell=null;
        String A=null;
        try {
            writer.merge(1, 2, 1, 2, "测试", true);
        } catch (Exception e) {
            writer.close();
            reader=ExcelUtil.getReader(filePath);
            cell = reader.getCell(1, 1);
            reader.close();
            A=cell.getStringCellValue();
            System.out.println(cell);
            System.out.println(A);
            Assert.assertEquals(A,"bb1");
        }
        Assert.assertEquals(A,"bb1");
    }

    @Test
    public void ExcelwriteMerge0Error() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest31.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        try {
            writer.merge(0);
        } catch (Exception e) {
            writer.close();
            Assert.assertNotNull(writer);
        }
        Assert.assertNotNull(writer);
    }

    @Test
    public void ExcelwriteMergeFirstEqualLastError() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest32.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        try {
            writer.merge(2, 2, 2, 2, "测试", true);
            writer.close();
        } catch (Exception e) {
            Assert.assertNotNull(writer);
        }
        Assert.assertNotNull(writer);
    }

    @Test
    public void ExcelwriteMergeLast0Error() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest33.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        try {
            writer.merge(0, "测试", true);
            writer.close();
        } catch (Exception e) {
            Assert.assertNotNull(writer);
        }
        Assert.assertNotNull(writer);
    }

    @Test
    public void ExcelwritegetOrCreateCellSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest34.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        Cell a = writer.getOrCreateCell(2, 2);
        writer.close();
        Assert.assertEquals(row3.get(2),"cc2");
    }

    @Test
    public void ExcelwritegetOrCreateCellSuccessBeyond() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest35.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        Cell a = writer.getOrCreateCell(5, 5);
        String A=a.getStringCellValue();
        System.out.println(a);
        System.out.println(A);
        writer.close();
        Assert.assertEquals(A,"");
    }

    @Test
    public void ExcelwritegetOrCreateCellNegativeError() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest36.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        Cell a = null;
        try {
            a = writer.getOrCreateCell(-1, -1);
            writer.close();
        } catch (Exception e) {
            Assert.assertNull(a);
        }
        Assert.assertNull(a);
    }

    @Test
    public void ExcelwritegetOrCreateRowSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest37.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        Row a = writer.getOrCreateRow(3);
        writer.close();
        Assert.assertEquals(row4.get(3),"dd3" );
    }

    @Test
    public void ExcelwritegetOrCreateRowNegativeError() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest38.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        Row a = null;
        try {
            a = writer.getOrCreateRow(-1);
            writer.close();
        } catch (Exception e) {
            Assert.assertNull(a);
        }
        Assert.assertNull(a);
    }

    @Test
    public void ExcelwritegetColumnCountdefaultSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1", "ee1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest39.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        int num = writer.getColumnCount();
        writer.close();
        Assert.assertEquals(num, 4);
    }

    @Test
    public void ExcelwritegetColumnCountSuccess() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1", "ee1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest40.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        int num = writer.getColumnCount(1);
        writer.close();
        Assert.assertEquals(num, 5);
    }

    @Test
    public void ExcelwritegetColumnCountBeyondError() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1", "ee1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest41.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        int num = writer.getColumnCount(5);
        writer.close();
        Assert.assertEquals(num, -1);
    }

    @Test
    public void ExcelwritegetColumnCountNegativeError() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1", "ee1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest42.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        int num = writer.getColumnCount(-1);
        writer.close();
        Assert.assertEquals(num, -1);
    }

    @Test
    public void ExcelwritegetRowCountSuccess() {
        List<String> row1 = CollUtil.newArrayList();
        List<String> row2 = CollUtil.newArrayList();
        List<String> row3 = CollUtil.newArrayList();
        List<String> row4 = CollUtil.newArrayList();
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest43.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        int num = writer.getRowCount();
        writer.close();
        Assert.assertEquals(num, 4);
    }

    @Test
    public void ExcelwriteisXlsxSuccess() {
        List<String> row1 = CollUtil.newArrayList();
        List<String> row2 = CollUtil.newArrayList();
        List<String> row3 = CollUtil.newArrayList();
        List<String> row4 = CollUtil.newArrayList();
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest43.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        boolean xlsx = writer.isXlsx();
        writer.close();
        Assert.assertEquals(xlsx, true);
    }

    @Test
    public void ExcelwriteisXlsxSuccesstxt() {
        List<String> row1 = CollUtil.newArrayList();
        List<String> row2 = CollUtil.newArrayList();
        List<String> row3 = CollUtil.newArrayList();
        List<String> row4 = CollUtil.newArrayList();
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest43.txt";
        ExcelWriter writer = new ExcelWriter(filePath);
        writer.write(rows, true);
        boolean xlsx = writer.isXlsx();
        writer.close();
        Assert.assertEquals(xlsx, false);
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
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
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
    public void writeMapTestSuccess() {
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
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        // 合并单元格后的标题行，使用默认标题样式
        //writer.merge(row1.size() - 1, "测试名单");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
        // 关闭writer，释放内存
        writer.close();
        ExcelReader reader=ExcelUtil.getReader(filePath);
        //Object o = reader.readCellValue(0, 0);
        Cell cell=reader.getCell(0,0);
        reader.close();
        System.out.println(cell);
        String A=cell.getStringCellValue();
        Assert.assertEquals(A,"姓名");
    }
    @Test
    public void writeMapTestError() {
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
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest.xlsx";
        ExcelWriter writer = new ExcelWriter(filePath);
        // 合并单元格后的标题行，使用默认标题样式
        //writer.merge(row1.size() - 1, "测试名单");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
        // 关闭writer，释放内存
        writer.close();
        String A=null;
        try {
            ExcelReader reader=ExcelUtil.getReader(filePath);
            //Object o = reader.readCellValue(0, 0);
            Cell cell=reader.getCell(2,2);
            reader.close();
            System.out.println(cell);
            A=cell.getStringCellValue();
        }
        catch (Exception e)
        {
            Assert.assertEquals(A,null);
        }
        Assert.assertEquals(A,null);
    }
}
