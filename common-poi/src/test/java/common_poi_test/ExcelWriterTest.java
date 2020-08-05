
package common_poi_test;

import com.uih.uplus.common.utils.basic.CollUtil;
import com.uih.uplus.common.utils.poi.excel.ExcelUtil;
import com.uih.uplus.common.utils.poi.excel.ExcelWriter;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//写出集合数据
public class ExcelWriterTest {
    @Test
    public  void testwww(){

        //第一步创建一个要写入的数据集合
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        //第二步使用ExcelWriter写出数据到文件
        //通过工具类创建writer
        //ExcelWriter writer = ExcelUtil.getWriter("E:\\common_lib_test\\writeExcelTest3.xlsx");
        ExcelWriter writer = ExcelUtil.getWriter("E:\\common_lib_test\\common-poi\\writeExcelTest4.xlsx");
        //通过构造方法创建writer
        //ExcelWriter writer = new ExcelWriter("d:/writeTest.xls");
        //跳过当前行，既第一行，非必须，在此演示用
        writer.passCurrentRow();
        //合并单元格后的标题行，使用默认标题样式
        //writer.merge(row1.size() - 1, "测试标题");
        //设置样式集，如果不使用样式，传入null
        writer.setStyleSet(null);
        //获取样式集
        writer.getStyleSet();
        //获取头部样式
        //writer.getHeadCellStyle();
        //获取单元格样式
        //writer.getCellStyle();
        //获得当前指向行数
        writer.getCurrentRow();
        //增加下拉列表	1.列号，从0开始；2.行号，从0开始；3.下拉列表内容
        writer.addSelect(3,3,"成绩");
        //判断是否为xlsx格式的Excel表
        writer.isXlsx();
        //获取第一行总列数
        writer.getColumnCount();
        //获取总行数
        writer.getRowCount();
        //一次性写出内容，强制输出标题
        writer.write(rows, true);
        //关闭writer，释放内存
        writer.close();
    }
    @Test
    public void test_write_excel() {

        Assert.assertTrue(true);

        File directory = new File("");
        String absolutePath = directory.getAbsolutePath();
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
    }

    //写出Map数据
    @Test
    public void writeMapTest() {

        Assert.assertTrue(true);

        File directory = new File("");
        String absolutePath = directory.getAbsolutePath();
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
    }

    @Test
    public void test_write_excel0() throws IOException {

        Assert.assertTrue(true);

        File directory = new File("");
        String absolutePath = directory.getAbsolutePath();
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
        ExcelWriter writer = ExcelUtil.getWriter();
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
        //response为HttpServletResponse对象
        HttpServletResponse response = null;
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xlsx是弹出下载对话框的文件名，中文名需再编码
        response.setHeader("Content-Disposition","attachment;filename=test.xlsx");
        ServletOutputStream out=response.getOutputStream();
        //将Excel Workbook刷出到流
        writer.flush(out, true);
        // 关闭writer，释放内存
        writer.close();
    }

}
