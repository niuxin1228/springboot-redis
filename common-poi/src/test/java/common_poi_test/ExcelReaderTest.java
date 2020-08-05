
package common_poi_test;

import com.sun.org.apache.xpath.internal.objects.XObject;
import com.uih.uplus.common.utils.poi.excel.ExcelReader;
import com.uih.uplus.common.utils.poi.excel.ExcelUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ExcelReaderTest {
    @Test
    public void ExcelreadTest() {

        Assert.assertTrue(true);

        File directory = new File("");
        String absolutePath = directory.getAbsolutePath();

        //ExcelReader使用示例（读取为集合数据）：
        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\common-poi\\writeMapTest.xlsx");
        List<List<Object>> readAll = reader.read();


//        //ExcelReader使用示例（读取为Map数据）：
//        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\writeMapTest.xlsx");
//        List<Map<String,Object>> readAll = reader.readAll();
        //设置是否忽略空行
        reader.setIgnoreEmptyRow(false);
        //读取为文本格式
        String text=reader.readAsText(false);
        //获得标题行的别名Map
        Map<String,String> mm=reader.getHeaderAlias();
        //读取某一行数据
        List<Object> rowdata=reader.readRow(0);
        List<Object> rowdata1=reader.readRow(3);
        List<Object> rowdata2=reader.readRow(4);
        //返回工作簿Sheet数
        int sheetcount=reader.getSheetCount();
        //获取或创建指定坐标单元格(4,4)
        Cell orCreateCell = reader.getOrCreateCell(1, 1);
        Cell orCreateCell1 = reader.getOrCreateCell(2, 2);
        Cell orCreateCell2 = reader.getOrCreateCell(0, 0);
        Cell orCreateCell3 = reader.getOrCreateCell(0, 1);
        Cell orCreateCell4 = reader.getOrCreateCell(1, 0);
        //获取或者创建行
        Row b=reader.getOrCreateRow(0);
        Row b1=reader.getOrCreateRow(1);
        Row b2=reader.getOrCreateRow(4);
        boolean isxlsx=reader.isXlsx();
        reader.close();

// //ExcelReader使用示例（读取为Bean集合）：
//        ExcelReader reader = ExcelUtil.getReader("E:\\common_lib_test\\writeMapTest.xlsx");
//        List<Person> all = reader.readAll(Person.class);

    }
}

