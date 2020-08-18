
package common_poi_test;

import com.sun.org.apache.xpath.internal.objects.XObject;
import com.uih.uplus.common.utils.poi.excel.ExcelReader;
import com.uih.uplus.common.utils.poi.excel.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReaderTest {
//    @Test
//    public void ExcelreadTest() {
//        //Assert.assertTrue(true);
//
//        File directory = new File("");
//        String absolutePath = directory.getAbsolutePath();
//
//        //ExcelReader使用示例（读取为集合数据）：
//        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
//        List<List<Object>> readAll = reader.read();
//
//
////        //ExcelReader使用示例（读取为Map数据）：
////        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\writeMapTest.xlsx");
////        List<Map<String,Object>> readAll = reader.readAll();
//        //设置是否忽略空行
//        reader.setIgnoreEmptyRow(false);
//        //读取为文本格式
//        String text=reader.readAsText(false);
//        //获得标题行的别名Map
//        Map<String,String> mm=reader.getHeaderAlias();
//        //读取某一行数据
//        List<Object> rowdata=reader.readRow(0);
//        List<Object> rowdata1=reader.readRow(3);
//        List<Object> rowdata2=reader.readRow(4);
//        //返回工作簿Sheet数
//        int sheetcount=reader.getSheetCount();
//        //获取或创建指定坐标单元格(4,4)
//        Cell orCreateCell = reader.getOrCreateCell(1, 1);
//        Cell orCreateCell1 = reader.getOrCreateCell(2, 2);
//        Cell orCreateCell2 = reader.getOrCreateCell(0, 0);
//        Cell orCreateCell3 = reader.getOrCreateCell(0, 1);
//        Cell orCreateCell4 = reader.getOrCreateCell(1, 0);
//        //获取或者创建行
//        Row b=reader.getOrCreateRow(0);
//        Row b1=reader.getOrCreateRow(1);
//        Row b2=reader.getOrCreateRow(4);
//        boolean isxlsx=reader.isXlsx();
//        reader.close();
//
//// //ExcelReader使用示例（读取为Bean集合）：
////        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\writeMapTest.xlsx");
////        List<Person> all = reader.readAll(Person.class);
//
//    }


    @Test
    public void ExcelreaderSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        Cell cell=reader.getCell(0,0);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"姓名");
    }
    @Test
    public void ExcelreaderSuccess2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx",0);
        Cell cell=reader.getCell(0,1);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"张三");
    }
    @Test
    public void ExcelreaderSuccess3(){
        File file=new File("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        ExcelReader reader = ExcelUtil.getReader(file);
        Cell cell=reader.getCell(0,1);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"张三");
    }
    @Test
    public void ExcelreaderSuccess4(){
        File file=new File("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        ExcelReader reader = ExcelUtil.getReader(file,0);
        Cell cell=reader.getCell(0,0);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"姓名");
    }
    @Test
    public void ExcelreaderSuccess5(){
        File file=new File("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        ExcelReader reader = ExcelUtil.getReader(file,"sheet1");
        Cell cell=reader.getCell(0,0);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"姓名");
        List<String> sheetnames = reader.getSheetNames();
        System.out.println(sheetnames);
        List<String> expect = new ArrayList<>();
        expect.add("sheet1");
        Assert.assertEquals(sheetnames,expect);
    }
    @Test
    public void ExcelreaderError(){
        ExcelReader reader = null;
        try {
            reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx",1);
        } catch (Exception e) {
            Assert.assertNull(reader);
        }
        Assert.assertNull(reader);
    }
    @Test
    public void ExcelreaderError2(){
        File file=new File("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        ExcelReader reader = null;
        try {
            reader = ExcelUtil.getReader(file,1);
        } catch (Exception e) {
            Assert.assertNull(reader);
        }
        Assert.assertNull(reader);
    }
    @Test
    public void ExcelreaderError3(){
        File file=new File("");
        ExcelReader reader = null;
        try {
            reader = ExcelUtil.getReader(file);
        } catch (Exception e) {
            Assert.assertNull(reader);
        }
        Assert.assertNull(reader);
    }
    @Test
    public void ExcelreaderError4(){
        File file=new File("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        ExcelReader reader = null;
        try {
            reader = ExcelUtil.getReader(file,"sheet0000000");
        } catch (Exception e) {
            Assert.assertNull(reader);
        }
        Assert.assertNull(reader);
    }
    @Test
    public void ExcelreaderErrorNofile(){
        ExcelReader reader = null;
        try {
            reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest111111.xlsx");
        } catch (Exception e) {
            Assert.assertNull(reader);
        }
        Assert.assertNull(reader);
    }
    @Test
    public void ExcelreaderErrorNoxlsx(){
        ExcelReader reader = null;
        try {
            reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.txt");
        } catch (Exception e) {
            Assert.assertNull(reader);
        }
        Assert.assertNull(reader);
    }
    @Test
    public void ExcelreaderErrorempty(){
        ExcelReader reader = null;
        try {
            reader = ExcelUtil.getReader("");
            System.out.println(reader);
        } catch (Exception e) {
            Assert.assertNull(reader);
        }
        Assert.assertNull(reader);
    }

    @Test
    public void ExcelreadSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        List<List<Object>> read = reader.read();
        System.out.println(read);
        Cell cell=reader.getCell(1,0);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"年龄");
    }
    @Test
    public void ExcelreadSuccess2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        List<List<Object>> read = reader.read(1);
        System.out.println(read);
        Cell cell=reader.getCell(0,1);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"张三");
    }
    @Test
    public void ExcelreadSuccessStartRowIndex(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        List<List<Object>> readAll = reader.read(1,2);
        System.out.println(readAll);
        Cell cell=reader.getCell(0,2);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"李四");
    }
    @Test
    public void ExcelreadSuccessNotRow(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        List<List<Object>> readAll = reader.read(4,5);
        System.out.println(readAll);
        List<List<Object>> expect=new ArrayList<>();
        Assert.assertEquals(readAll,expect);
    }
    @Test
    public void ExcelreadErrorNoFile(){
        ExcelReader reader = null;
        List<List<Object>> readAll=null;
        try {
            reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest1111111.txt");
            readAll = reader.read(1,2);
        } catch (Exception e) {
            Assert.assertNull(readAll);
        }
        Assert.assertNull(readAll);
    }
    @Test
    public void ExcelreadErrorNoFile2(){
        ExcelReader reader = null;
        List<List<Object>> readAll=null;
        try {
            reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest1111111.txt");
            readAll = reader.read(1);
        } catch (Exception e) {
            Assert.assertNull(readAll);
        }
        Assert.assertNull(readAll);
    }
    @Test
    public void ExcelreadErrorTxt(){
        ExcelReader reader = null;
        List<List<Object>> readAll=null;
        try {
            reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.txt");
            readAll = reader.read(1,2);
        } catch (Exception e) {
            Assert.assertNull(readAll);
        }
        Assert.assertNull(readAll);
    }
    @Test
    public void ExcelreadErrorTxt2(){
        ExcelReader reader = null;
        List<List<Object>> readAll=null;
        try {
            reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.txt");
            readAll = reader.read(1);
        } catch (Exception e) {
            Assert.assertNull(readAll);
        }
        Assert.assertNull(readAll);
    }
    @Test
    public void ExcelreadErrorEmpty(){
        ExcelReader reader = null;
        List<List<Object>> readAll=null;
        try {
            reader = ExcelUtil.getReader("");
            readAll = reader.read(1);
        } catch (Exception e) {
            Assert.assertNull(readAll);
        }
        Assert.assertNull(readAll);
    }
    @Test
    public void ExcelreadErrorEmpty2(){
        ExcelReader reader = null;
        List<List<Object>> readAll=null;
        try {
            reader = ExcelUtil.getReader("");
            readAll = reader.read(1,2);
        } catch (Exception e) {
            Assert.assertNull(readAll);
        }
        Assert.assertNull(readAll);
    }

    @Test
    public void ExcelreadSuccessAllIndex(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        List<Map<String,Object>> readAll = reader.read(1,2,3);
        Cell cell=reader.getCell(0,2);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"李四");
    }
    @Test
    public void ExcelreadError(){
        ExcelReader reader = null;
        List<Map<String,Object>> readAll=null;
        try {
            reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
            readAll = reader.read(1,3,1);
        } catch (Exception e) {
            Assert.assertNull(readAll);
        }
        Assert.assertNull(readAll);
    }
    @Test
    public void ExcelreadErrorNegative(){
        ExcelReader reader = null;
        List<Map<String,Object>> readAll=null;
        try {
            reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
            readAll = reader.read(-1,1,3);
        } catch (Exception e) {
            Assert.assertNull(readAll);
        }
        Assert.assertNull(readAll);
    }
    @Test
    public void ExcelreadGetWorkbookSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        Workbook wb=reader.getWorkbook();
        System.out.println(wb);
        int number = wb.getNumberOfFontsAsInt();
        Assert.assertEquals(number,1);
    }
    @Test
    public void ExcelreadRowSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        List<Object> readrow=reader.readRow(0);
        System.out.println(readrow);
        List<Object> expect=new ArrayList<>();
        expect.add("姓名");
        expect.add("年龄");
        Assert.assertEquals(readrow,expect);
    }
    @Test
    public void ExcelreadRowSuccess2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        List<Object> readrow=reader.readRow(111);
        System.out.println(readrow);
        List<Object> expect=new ArrayList<>();
        Assert.assertEquals(readrow,expect);
    }
    @Test
    public void ExcelreadRowError(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        List<Object> readrow=reader.readRow(-1);
        System.out.println(readrow);
        List<Object> expect=new ArrayList<>();
        Assert.assertEquals(readrow,expect);
    }
    @Test
    public void ExcelreadsetIgnoreEmptyRowSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest.xlsx");
        reader.setIgnoreEmptyRow(true);
        int rowCount = reader.getRowCount();
        System.out.println(rowCount);
        Assert.assertEquals(rowCount,7);
    }
    @Test
    public void ExcelreadsetIgnoreEmptyRowSuccess2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest.xlsx");
        reader.setIgnoreEmptyRow(true);
        Cell cell=reader.getCell(1,1);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"bb");
    }
    @Test
    public void ExcelreadAsTextSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        String text=reader.readAsText(false);
        System.out.println(text);
        int length = text.length();
        Assert.assertEquals(length,18);
    }
    @Test
    public void ExcelreadAsTextSuccess2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        String text=reader.readAsText(true);
        System.out.println(text);
        int length = text.length();
        Assert.assertEquals(length,25);
    }
    @Test
    public void ExcelreadAsTextErrortxt(){
        ExcelReader reader = null;
        String text=null;
        try {
            reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.txt");
            text=reader.readAsText(true);
        } catch (Exception e) {
            Assert.assertNull(text);
        }
        Assert.assertNull(text);
    }
    @Test
    public void ExcelreadAsTextErrorEmpty(){
        ExcelReader reader = null;
        String text=null;
        try {
            reader = ExcelUtil.getReader("");
            text=reader.readAsText(true);
        } catch (Exception e) {
            Assert.assertNull(text);
        }
        Assert.assertNull(text);
    }
    @Test
    public void ExcelreadGetSheetCountSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest.xlsx");
        int num=reader.getSheetCount();
        Assert.assertEquals(num,1);
    }
    @Test
    public void ExcelreadGetSheetCountSuccess2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest11.xlsx");
        int num=reader.getSheetCount();
        Assert.assertEquals(num,2);
    }
    @Test
    public void ExcelreadGetSheetsSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest11.xlsx");
        List<Sheet> list=reader.getSheets();
        int size = list.size();
        Assert.assertEquals(size,2);
    }
    @Test
    public void ExcelreadGetSheetsSuccess2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        List<Sheet> list=reader.getSheets();
        int size = list.size();
        Assert.assertEquals(size,1);
    }
    @Test
    public void ExcelreadGetSheetsErrorTxt(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest43.txt");
        List<Sheet> list=reader.getSheets();
        System.out.println(list);
        int size = list.size();
        Assert.assertEquals(size,1);
    }
    @Test
    public void ExcelreadGetSheetNamesSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        List<String> li=reader.getSheetNames();
        List<String> li1=new ArrayList<String>();
        li1.add("sheet1");
        System.out.println(li);
        Assert.assertEquals(li,li1);
    }
    @Test
    public void ExcelreadGetSheetNamesSuccess2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest11.xlsx");
        List<String> li=reader.getSheetNames();
        List<String> li1=new ArrayList<String>();
        li1.add("sheet1");
        li1.add("切换到新sheet，sheet2");
        System.out.println(li);
        Assert.assertEquals(li,li1);
    }
    @Test
    public void ExcelreadGetSheetNamesError(){
        ExcelReader reader = null;
        List<String> li=null;
        try {
            ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest111111111.xlsx");
            li=reader.getSheetNames();
        } catch (Exception e) {
            Assert.assertNull(li);
        }
        Assert.assertNull(li);
    }
    @Test
    public void ExcelreadGetSheetNamesError2(){
        ExcelReader reader = null;
        List<String> li=null;
        try {
            ExcelUtil.getReader("");
            li=reader.getSheetNames();
        } catch (Exception e) {
            Assert.assertNull(li);
        }
        Assert.assertNull(li);
    }
    @Test
    public void ExcelreadGetSheetNamesError3(){
        ExcelReader reader = null;
        List<String> li=null;
        try {
            ExcelUtil.getReader("F:\\");
            li=reader.getSheetNames();
        } catch (Exception e) {
            Assert.assertNull(li);
        }
        Assert.assertNull(li);
    }
    @Test
    public void ExcelreadGetHeaderAliasSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest4.xlsx");
        Map<String,String> mm=reader.getHeaderAlias();
        System.out.println(mm);
        Map<String,String> expect=new HashMap<>();
        Assert.assertEquals(mm,expect);
    }
    @Test
    public void ExcelreadGetHeaderAliasSuccess2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest4.xlsx");
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        reader.setHeaderAlias(map);
        Map<String,String> mm=reader.getHeaderAlias();
        System.out.println(mm);
        Assert.assertEquals(mm,map);
    }
    @Test
    public void ExcelreadGetHeaderAliasSuccess3(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest4.xlsx");
        Map<String, String> map = new HashMap<String, String>();
        reader.setHeaderAlias(map);
        Map<String,String> mm=reader.getHeaderAlias();
        System.out.println(mm);
        Assert.assertEquals(mm,map);
    }

    @Test
    public void ExcelreadgetOrCreateCellSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest34.xlsx");
        Cell a=reader.getOrCreateCell(2,2);
        System.out.println(a);
        String A=a.getStringCellValue();
        reader.close();
        Assert.assertEquals(A,"cc2");
    }
    @Test
    public void ExcelreadgetOrCreateCellSuccess2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest34.xlsx");
        Cell a=reader.getOrCreateCell(5,5);
        System.out.println(a);
        String A=a.getStringCellValue();
        reader.close();
        Assert.assertEquals(A,"");
    }
    @Test
    public void ExcelreadgetOrCreateCellError(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest34.xlsx");
        Cell a=null;
        try {
            a=reader.getOrCreateCell(-1,-1);
            reader.close();
        } catch (Exception e) {
            Assert.assertNull(a);
        }
        Assert.assertNull(a);
    }
    @Test
    public void ExcelreadgetOrCreateRowSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest34.xlsx");
        Row a=reader.getOrCreateRow(3);
        Cell cell = a.getCell(1);
        String act=cell.getStringCellValue();
        reader.close();
        Assert.assertEquals(act,"bb3");
    }
    @Test
    public void ExcelreadgetOrCreateRowError(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest34.xlsx");
        Row a=null;
        try {
            a=reader.getOrCreateRow(-1);
            reader.close();
        } catch (Exception e) {
            Assert.assertNull(a);
        }
        Assert.assertNull(a);
    }
    @Test
    public void ExcelreadgetColumnCountSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest34.xlsx");
        int num=reader.getColumnCount();
        reader.close();
        Assert.assertEquals(num,4);
    }
    @Test
    public void ExcelreadgetColumnCountSuccess2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest40.xlsx");
        int num=reader.getColumnCount(1);
        reader.close();
        Assert.assertEquals(num,5);
    }
    @Test
    public void ExcelreadgetColumnCountError(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest41.xlsx");
        int num=reader.getColumnCount(5);
        reader.close();
        Assert.assertEquals(num,-1);
    }
    @Test
    public void ExcelreadgetColumnCountError2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest42.xlsx");
        int num=reader.getColumnCount(-1);
        reader.close();
        Assert.assertEquals(num,-1);
    }
    @Test
    public void ExcelreadgetRowCountSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest43.xlsx");
        int num=reader.getRowCount();
        reader.close();
        Assert.assertEquals(num,4);
    }
    @Test
    public void ExcelreadisXlsxSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest34.xlsx");
        boolean xlsx=reader.isXlsx();
        reader.close();
        Assert.assertEquals(xlsx,true);
    }
    @Test
    public void ExcelreadisXlsxSuccess2(){
        ExcelReader reader =ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest43.txt");
        boolean xlsx=reader.isXlsx();
        reader.close();
        Assert.assertEquals(xlsx,false);
    }
}



