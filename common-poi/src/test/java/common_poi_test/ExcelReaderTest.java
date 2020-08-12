
package common_poi_test;

import com.sun.org.apache.xpath.internal.objects.XObject;
import com.uih.uplus.common.utils.poi.excel.ExcelReader;
import com.uih.uplus.common.utils.poi.excel.ExcelUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
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
        Assert.assertNotNull(reader);
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
        List<List<Object>> readAll = reader.read(1,2);
        Assert.assertNotNull(readAll);
    }
    @Test
    public void ExcelreadSuccessStartRowIndex(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        List<List<Object>> readAll = reader.read(1);
        Assert.assertNotNull(readAll);
    }
    @Test
    public void ExcelreadSuccessNotRow(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        List<List<Object>> readAll = reader.read(4,5);
        Assert.assertNotNull(readAll);
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
    public void ExcelreadErrorEmpty(){
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
        Assert.assertNotNull(readAll);
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
    public void ExcelreadRowSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        List<Object> readrow=reader.readRow(0);
        Assert.assertNotNull(readrow);
    }
    @Test
    public void ExcelreadRowSuccess2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        List<Object> readrow=reader.readRow(111);
        Assert.assertNotNull(readrow);
    }
    @Test
    public void ExcelreadsetIgnoreEmptyRowSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest.xlsx");
        reader=reader.setIgnoreEmptyRow(false);
        Assert.assertNotNull(reader);
    }
    @Test
    public void ExcelreadsetIgnoreEmptyRowSuccess2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest.xlsx");
        reader=reader.setIgnoreEmptyRow(true);
        Assert.assertNotNull(reader);
    }
    @Test
    public void ExcelreadAsTextSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        String text=reader.readAsText(false);
        Assert.assertNotNull(text);
    }
    @Test
    public void ExcelreadAsTextSuccess2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest.xlsx");
        String text=reader.readAsText(true);
        Assert.assertNotNull(text);
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
    public void ExcelreadSheetCountSuccess(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest.xlsx");
        int num=reader.getSheetCount();
        Assert.assertEquals(num,1);
    }
    @Test
    public void ExcelreadSheetCountSuccess2(){
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeExcelTest4.xlsx");
        Map<String,String> mm=reader.getHeaderAlias();
        Assert.assertNotNull(mm);
    }
}



