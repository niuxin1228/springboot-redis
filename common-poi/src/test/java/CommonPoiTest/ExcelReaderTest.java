
package CommonPoiTest;

import com.uih.uplus.common.utils.poi.excel.ExcelReader;
import com.uih.uplus.common.utils.poi.excel.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReaderTest {
    private File directory = new File("");
    private String rootPath=directory.getAbsolutePath();
    private ExcelReader reader=null;

    @AfterMethod
    public void AfterMethod(){
        try {
            reader.close();
        }catch(Exception e){
        }
    }
    @Test
    public void ExcelreaderSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        Cell cell=reader.getCell(0,0);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"姓名");
    }
    @Test
    public void ExcelreaderSheetSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        reader = ExcelUtil.getReader(filePath,0);
        Cell cell=reader.getCell(0,1);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"张三");
    }
    @Test
    public void ExcelreaderfileSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        File file=new File(filePath);
        reader = ExcelUtil.getReader(file);
        Cell cell=reader.getCell(0,1);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"张三");
    }
    @Test
    public void ExcelreaderfilesheetSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        File file=new File(filePath);
        reader = ExcelUtil.getReader(file,0);
        Cell cell=reader.getCell(0,0);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"姓名");
    }
    @Test
    public void ExcelreaderfilesheetnameSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        File file=new File(filePath);
        reader = ExcelUtil.getReader(file,"sheet1");
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
    public void ExcelreadersheetBeyondError(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        try {
            reader = ExcelUtil.getReader(filePath,1);
        } catch (Exception e) {
            Assert.assertNotNull(filePath);
        }
        Assert.assertNotNull(filePath);
    }
    @Test
    public void ExcelreaderfilesheetBeyondError(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        File file=new File(filePath);
        try {
            reader = ExcelUtil.getReader(file,1);
        } catch (Exception e) {
            Assert.assertNotNull(filePath);
        }
        Assert.assertNotNull(filePath);
    }
    @Test
    public void ExcelreaderEmptyPathnameError(){
        File file=new File("");
        try {
            reader = ExcelUtil.getReader(file);
        } catch (Exception e) {
            Assert.assertEquals(file.getName(),"");
        }
        Assert.assertEquals(file.getName(),"");
    }
    @Test
    public void ExcelreadersheetNoExistError(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        File file=new File(filePath);
        try {
            reader = ExcelUtil.getReader(file,"sheet0000000");
        } catch (Exception e) {
            Assert.assertNotNull(filePath);
        }
        Assert.assertNotNull(filePath);
    }
    @Test
    public void ExcelreaderErrorNofile(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest111111.xlsx";
        try {
            reader = ExcelUtil.getReader(filePath);
        } catch (Exception e) {
            Assert.assertNotNull(filePath);
        }
        Assert.assertNotNull(filePath);
    }
    @Test
    public void ExcelreaderErrorNoxlsx(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.txt";
        try {
            reader = ExcelUtil.getReader(filePath);
        } catch (Exception e) {
            Assert.assertNotNull(filePath);
        }
        Assert.assertNotNull(filePath);
    }
    @Test
    public void ExcelreaderErroremptybookFilePath(){
        reader=null;
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
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        List<List<Object>> read = reader.read();
        System.out.println(read);
        Cell cell=reader.getCell(1,0);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"年龄");
    }
    @Test
    public void ExcelreadstartRowindexSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        List<List<Object>> read = reader.read(1);
        System.out.println(read);
        Cell cell=reader.getCell(0,1);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"张三");
    }
    @Test
    public void ExcelreadStartEndRowIndexSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        List<List<Object>> readAll = reader.read(1,2);
        System.out.println(readAll);
        Cell cell=reader.getCell(0,2);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"李四");
    }
    @Test
    public void ExcelreadSuccessNotRow(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        List<List<Object>> readAll = reader.read(4,5);
        System.out.println(readAll);
        List<List<Object>> expect=new ArrayList<>();
        Assert.assertEquals(readAll,expect);
    }
    @Test
    public void ExcelreadStartendRowErrorNoFile(){
        List<List<Object>> readAll=null;
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest1111111.xlxs";
        try {
            reader = ExcelUtil.getReader(filePath);
            readAll = reader.read(1,2);
        } catch (Exception e) {
            Assert.assertNull(readAll);
        }
        Assert.assertNull(readAll);
    }
    @Test
    public void ExcelreadStartRowErrorNoFile(){
        List<List<Object>> readAll=null;
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest1111111.xlsx";
        try {
            reader = ExcelUtil.getReader(filePath);
            readAll = reader.read(1);
        } catch (Exception e) {
            Assert.assertNull(readAll);
        }
        Assert.assertNull(readAll);
    }
    @Test
    public void ExcelreadStartEndRowErrorTxt(){
        List<List<Object>> readAll=null;
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.txt";
        try {
            reader = ExcelUtil.getReader(filePath);
            readAll = reader.read(1,2);
        } catch (Exception e) {
            Assert.assertNull(readAll);
        }
        Assert.assertNull(readAll);
    }
    @Test
    public void ExcelreadStartRowErrorTxt(){
        List<List<Object>> readAll=null;
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.txt";
        try {
            reader = ExcelUtil.getReader(filePath);
            readAll = reader.read(1);
        } catch (Exception e) {
            Assert.assertNull(readAll);
        }
        Assert.assertNull(readAll);
    }
    @Test
    public void ExcelreadStartRowErrorEmpty(){
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
    public void ExcelreadStartEndRowErrorEmpty(){
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
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        List<Map<String,Object>> readAll = reader.read(1,2,3);
        Cell cell=reader.getCell(0,2);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"李四");
    }
    @Test
    public void ExcelreadEndMorethanStartError(){
        List<Map<String,Object>> readAll=null;
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        try {
            reader = ExcelUtil.getReader(filePath);
            readAll = reader.read(1,3,1);
        } catch (Exception e) {
            Assert.assertNull(readAll);
        }
        Assert.assertNull(readAll);
    }
    @Test
    public void ExcelreadErrorNegative(){
        List<Map<String,Object>> readAll=null;
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        try {
            reader = ExcelUtil.getReader(filePath);
            readAll = reader.read(-1,1,3);
        } catch (Exception e) {
            Assert.assertNull(readAll);
        }
        Assert.assertNull(readAll);
    }
    @Test
    public void ExcelreadGetWorkbookSuccess() throws IOException {
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        ExcelReader reader = ExcelUtil.getReader(filePath);
        Workbook wb=reader.getWorkbook();
        System.out.println(wb);
        reader.close();
        wb.close();
        int number = wb.getNumberOfFontsAsInt();
        Assert.assertEquals(number,1);
    }
    @Test
    public void ExcelreadRowSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        List<Object> readrow=reader.readRow(0);
        System.out.println(readrow);
        List<Object> expect=new ArrayList<>();
        expect.add("姓名");
        expect.add("年龄");
        Assert.assertEquals(readrow,expect);
    }
    @Test
    public void ExcelreadRowToobigSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        List<Object> readrow=reader.readRow(111);
        System.out.println(readrow);
        List<Object> expect=new ArrayList<>();
        Assert.assertEquals(readrow,expect);
    }
    @Test
    public void ExcelreadRowNegativeError(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        List<Object> readrow=reader.readRow(-1);
        System.out.println(readrow);
        List<Object> expect=new ArrayList<>();
        Assert.assertEquals(readrow,expect);
    }
    @Test
    public void ExcelreadsetIgnoreEmptyRowSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        reader.setIgnoreEmptyRow(true);
        int rowCount = reader.getRowCount();
        System.out.println(rowCount);
        Assert.assertEquals(rowCount,6);
    }
    @Test
    public void ExcelreadsetIgnoreEmptyRowfalseSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        reader.setIgnoreEmptyRow(false);
        Cell cell=reader.getCell(1,1);
        System.out.println(cell);
        String act=cell.getStringCellValue();
        Assert.assertEquals(act,"bb");
    }
    @Test
    public void ExcelreadAsTextSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        String text=reader.readAsText(false);
        System.out.println(text);
        int length = text.length();
        Assert.assertEquals(length,18);
    }
    @Test
    public void ExcelreadAsTextaddsheetSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        String text=reader.readAsText(true);
        System.out.println(text);
        int length = text.length();
        Assert.assertEquals(length,25);
    }
    @Test
    public void ExcelreadAsTextErrortxt(){
        String text=null;
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.txt";
        try {
            reader = ExcelUtil.getReader(filePath);
            text=reader.readAsText(true);
        } catch (Exception e) {
            Assert.assertNull(text);
        }
        Assert.assertNull(text);
    }
    @Test
    public void ExcelreadAsTextErrorEmpty(){
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
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        int num=reader.getSheetCount();
        Assert.assertEquals(num,1);
    }
    @Test
    public void ExcelreadGetmoreSheetCountSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest1111.xlsx";
        reader = ExcelUtil.getReader(filePath);
        int num=reader.getSheetCount();
        Assert.assertEquals(num,2);
    }
    @Test
    public void ExcelreadGetSheetsmoreSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest1111.xlsx";
        reader = ExcelUtil.getReader(filePath);
        List<Sheet> list=reader.getSheets();
        int size = list.size();
        Assert.assertEquals(size,2);
    }
    @Test
    public void ExcelreadGetSheetsSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        List<Sheet> list=reader.getSheets();
        int size = list.size();
        Assert.assertEquals(size,1);
    }
    @Test
    public void ExcelreadGetSheetsErrorTxt(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest4343.txt";
        reader = ExcelUtil.getReader(filePath);
        List<Sheet> list=reader.getSheets();
        System.out.println(list);
        int size = list.size();
        Assert.assertEquals(size,1);
    }
    @Test
    public void ExcelreadGetSheetNamesSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeMapTest999.xlsx";
        reader = ExcelUtil.getReader(filePath);
        List<String> li=reader.getSheetNames();
        List<String> li1=new ArrayList<String>();
        li1.add("sheet1");
        System.out.println(li);
        Assert.assertEquals(li,li1);
    }
    @Test
    public void ExcelreadGetmoreSheetNamesSuccess2(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest1111.xlsx";
        reader = ExcelUtil.getReader(filePath);
        List<String> li=reader.getSheetNames();
        List<String> li1=new ArrayList<String>();
        li1.add("sheet1");
        li1.add("添加一个新的sheet，设置为这个sheetname");
        System.out.println(li);
        Assert.assertEquals(li,li1);
    }
    @Test
    public void ExcelreadGetSheetNamesXlsxNoExistError(){
        List<String> li=null;
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest111111111.xlsx";
        try {
            ExcelUtil.getReader(filePath);
            li=reader.getSheetNames();
        } catch (Exception e) {
            Assert.assertNull(li);
        }
        Assert.assertNull(li);
    }
    @Test
    public void ExcelreadGetSheetNamesEmptyPathError(){
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
    public void ExcelreadGetSheetNamesPathNoExistError(){
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
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest3434.xlsx";
        reader = ExcelUtil.getReader(filePath);
        Map<String,String> mm=reader.getHeaderAlias();
        System.out.println(mm);
        Map<String,String> expect=new HashMap<>();
        Assert.assertEquals(mm,expect);
    }
    @Test
    public void ExcelreadMapSetGetHeaderAliasSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest3434.xlsx";
        reader = ExcelUtil.getReader(filePath);
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
    public void ExcelreadSetGetHeaderAliasSuccess3(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest3434.xlsx";
        reader = ExcelUtil.getReader(filePath);
        Map<String, String> map = new HashMap<String, String>();
        reader.setHeaderAlias(map);
        Map<String,String> mm=reader.getHeaderAlias();
        System.out.println(mm);
        Assert.assertEquals(mm,map);
    }

    @Test
    public void ExcelreadgetOrCreateCellSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest3434.xlsx";
        reader = ExcelUtil.getReader(filePath);
        Cell a=reader.getOrCreateCell(2,2);
        System.out.println(a);
        String A=a.getStringCellValue();
        reader.close();
        Assert.assertEquals(A,"cc2");
    }
    @Test
    public void ExcelreadgetOrCreateCellbeyondSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest3434.xlsx";
        reader = ExcelUtil.getReader(filePath);
        Cell a=reader.getOrCreateCell(5,5);
        System.out.println(a);
        String A=a.getStringCellValue();
        reader.close();
        Assert.assertEquals(A,"");
    }
    @Test
    public void ExcelreadgetOrCreateCellNegativeError(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest3434.xlsx";
        reader = ExcelUtil.getReader(filePath);
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
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest3434.xlsx";
        reader = ExcelUtil.getReader(filePath);
        Row a=reader.getOrCreateRow(3);
        Cell cell = a.getCell(1);
        String act=cell.getStringCellValue();
        reader.close();
        Assert.assertEquals(act,"bb3");
    }
    @Test
    public void ExcelreadgetOrCreateRowNegativeError(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest3434.xlsx";
        reader = ExcelUtil.getReader(filePath);
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
    public void ExcelreadgetColumnCountdefaultSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest3434.xlsx";
        reader = ExcelUtil.getReader(filePath);
        int num=reader.getColumnCount();
        reader.close();
        Assert.assertEquals(num,4);
    }
    @Test
    public void ExcelreadgetColumnCountrowSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest4040.xlsx";
        reader = ExcelUtil.getReader(filePath);
        int num=reader.getColumnCount(1);
        reader.close();
        Assert.assertEquals(num,5);
    }
    @Test
    public void ExcelreadgetColumnCountRowbeyondError(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest4141.xlsx";
        reader = ExcelUtil.getReader(filePath);
        int num=reader.getColumnCount(5);
        reader.close();
        Assert.assertEquals(num,-1);
    }
    @Test
    public void ExcelreadgetColumnCountRowNegativeError(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest4242.xlsx";
        reader = ExcelUtil.getReader(filePath);
        int num=reader.getColumnCount(-1);
        reader.close();
        Assert.assertEquals(num,-1);
    }
    @Test
    public void ExcelreadgetRowCountSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest4343.xlsx";
        reader = ExcelUtil.getReader(filePath);
        int num=reader.getRowCount();
        reader.close();
        Assert.assertEquals(num,4);
    }
    @Test
    public void ExcelreadisXlsxSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest3434.xlsx";
        reader = ExcelUtil.getReader(filePath);
        boolean xlsx=reader.isXlsx();
        reader.close();
        Assert.assertEquals(xlsx,true);
    }
    @Test
    public void ExcelreadnotXlsxSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"writeExcelTest4343.txt";
        reader = ExcelUtil.getReader(filePath);
        boolean xlsx=reader.isXlsx();
        reader.close();
        Assert.assertEquals(xlsx,false);
    }
}



