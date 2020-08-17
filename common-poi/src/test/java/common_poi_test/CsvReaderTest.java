
package common_poi_test;

import com.jsoniter.spi.OmitValue;
import com.uih.uplus.common.utils.csv.*;
import com.uih.uplus.common.utils.io.FileUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static com.uih.uplus.common.utils.basic.CharsetUtil.CHARSET_GBK;
import static com.uih.uplus.common.utils.basic.CharsetUtil.CHARSET_UTF_8;

/*通过CsvReaderConfig设置读取规则
* 是否首行做为标题行，默认false；
* 是否跳过空白行，默认true;
* 设置每行字段个数不同时是否抛出异常，默认false
* */

public class CsvReaderTest {
    @Test
    public void CsvReaderSuccess(){
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file("E:\\common_lib_test\\common-poi\\WriteCsvTest.csv"));
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvReaderSuccess2(){
        CsvReader cr=CsvUtil.getReader();
        CsvData data=cr.read(FileUtil.file("E:\\common_lib_test\\common-poi\\WriteCsvTest.csv"));
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvReaderSuccess3(){
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file("E:\\common_lib_test\\common-poi\\WriteCsvTest.csv"),CHARSET_GBK);
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvReaderSuccess4(){
        CsvReader cr=new CsvReader();
        File file=new File("E:\\common_lib_test\\common-poi\\WriteCsvTest.csv");
        CsvData data=cr.read(file);
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvReaderSuccess5(){
        CsvReader cr=new CsvReader();
        File file=new File("E:\\common_lib_test\\common-poi\\WriteCsvTest.csv");
        CsvData data=cr.read(file,CHARSET_UTF_8);
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvReaderSuccess6(){
        CsvReader cr=CsvUtil.getReader();
        CsvData data=cr.read(FileUtil.file("E:\\common_lib_test\\common-poi\\WriteCsvTest.csv"),CHARSET_GBK);
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvReaderErrorxlsx(){
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file("E:\\common_lib_test\\common-poi\\WriteCsvTest1.xlsx"));
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write error!");
    }
    @Test
    public void CsvReaderErrorNoPath(){
        CsvData data=null;
        try {
            CsvReader cr=new CsvReader();
            data=cr.read(FileUtil.file("F:\\"));
            Assert.assertNull(data);

        } catch (Exception e) {
            Assert.assertNull(data);
        }
    }
    @Test
    public void CsvReaderErrorEmptyPath(){
        CsvData data=null;
        try {
            CsvReader cr=new CsvReader();
            data=cr.read(FileUtil.file(""));
            Assert.assertNull(data);

        } catch (Exception e) {
            Assert.assertNull(data);
        }
    }
    @Test
    public void CsvReaderErrorEmptyNoFile(){
        CsvData data=null;
        try {
            CsvReader cr=new CsvReader();
            data=cr.read(FileUtil.file("E:\\common_lib_test\\common-poi\\WriteCsvTest111111111111111111111111.csv"));
            Assert.assertNull(data);

        } catch (Exception e) {
            Assert.assertNull(data);
        }
    }
    @Test
    public void CsvReaderErrorFile(){
        CsvData data=null;
        try {
            CsvReader cr=new CsvReader();
            File file=new File("E:\\common_lib_test\\common-poi\\WriteCsvTest1111111111111.csv");
            data=cr.read(file,CHARSET_UTF_8);
            Assert.assertNull(data);

        } catch (Exception e) {
            Assert.assertNull(data);
        }
    }
    @Test
    public void CsvReaderErrorFileNoPath(){
        CsvData data=null;
        try {
            CsvReader cr=new CsvReader();
            File file=new File("F:\\");
            data=cr.read(file,CHARSET_UTF_8);
            Assert.assertNull(data);

        } catch (Exception e) {
            Assert.assertNull(data);
        }
    }
    @Test
    public void CsvReaderErrorFileEmptyPath() {
        CsvData data = null;
        try {
            CsvReader cr = new CsvReader();
            File file = new File("");
            data = cr.read(file, CHARSET_UTF_8);
            Assert.assertNull(data);

        } catch (Exception e) {
            Assert.assertNull(data);
        }
    }
    @Test
    public void CsvReaderErrorFliexlsx(){
        CsvReader cr=new CsvReader();
        File file=new File("E:\\common_lib_test\\common-poi\\WriteCsvTest1.xlsx");
        CsvData data=cr.read(file);
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write error!");
    }
    @Test
    public void CsvReaderConfigSetContainsHeaderSuccess(){
        CsvReadConfig config=new CsvReadConfig();
        config.setContainsHeader(true);
        CsvReader cr=new CsvReader(config);
        File file=new File("E:\\common_lib_test\\common-poi\\CsvWriterlines5.csv");
        CsvData data=cr.read(file);
        System.out.println(data.getRows());
        System.out.println(data.getRowCount());
        Assert.assertEquals(data.getRowCount(),1);
    }
    @Test
    public void CsvReaderConfigSetContainsHeaderSuccess2(){
        CsvReadConfig config=new CsvReadConfig();
        config.setContainsHeader(false);
        CsvReader cr=new CsvReader(config);
        File file=new File("E:\\common_lib_test\\common-poi\\CsvWriterlines5.csv");
        CsvData data=cr.read(file);
        System.out.println(data.getRows());
        System.out.println(data.getRowCount());
        Assert.assertEquals(data.getRowCount(),2);
    }
    @Test
    public void CsvReaderConfigSetSkipEmptyRowsSuccess(){
        CsvReadConfig config=new CsvReadConfig();
        config.setSkipEmptyRows(true);
        CsvReader cr=new CsvReader(config);
        File file=new File("E:\\common_lib_test\\common-poi\\CsvWriterlines5.csv");
        CsvData data=cr.read(file);
        System.out.println(data.getRows());
        System.out.println(data.getRowCount());
        Assert.assertEquals(data.getRowCount(),2);
    }
    @Test
    public void CsvReaderConfigSetSkipEmptyRowsSuccess2(){
        CsvReadConfig config=new CsvReadConfig();
        config.setSkipEmptyRows(false);
        CsvReader cr=new CsvReader(config);
        File file=new File("E:\\common_lib_test\\common-poi\\CsvWriterlines5.csv");
        CsvData data=cr.read(file);
        System.out.println(data.getRows());
        System.out.println(data.getRowCount());
        Assert.assertEquals(data.getRowCount(),3);
    }
    @Test
    public void CsvReaderConfigSetSkipEmptyRowsSuccess3(){
        CsvReadConfig config=new CsvReadConfig();
        config.setSkipEmptyRows(false);
        CsvReader cr=new CsvReader(config);
        File file=new File("E:\\common_lib_test\\common-poi\\CsvWriterlines2.csv");
        CsvData data=cr.read(file);
        String ss=data.getRow(2).get(5);
        Assert.assertEquals(ss,null);
    }
    @Test
    public void CsvReaderConfigSetSkipEmptyRowsSuccess4(){
        CsvReadConfig config=new CsvReadConfig();
        config.setSkipEmptyRows(false);
        CsvReader cr=new CsvReader(config);
        File file=new File("E:\\common_lib_test\\common-poi\\CsvWriterlines2.csv");
        CsvData data=cr.read(file);
        String ss=data.getRow(1).get(1);
        Assert.assertEquals(ss,null);
    }
    @Test
    public void CsvReaderConfigSetSkipEmptyRowsSuccess5(){
        CsvReadConfig config=new CsvReadConfig();
        config.setSkipEmptyRows(true);
        CsvReader cr=new CsvReader(config);
        File file=new File("E:\\common_lib_test\\common-poi\\CsvWriterlines2.csv");
        CsvData data=cr.read(file);
        String ss=data.getRow(1).get(1);
        Assert.assertEquals(ss,"b2");
    }
    @Test
    public void CsvReaderConfigsetErrorOnDifferentFieldCountSuccess(){
        CsvReadConfig config=new CsvReadConfig();
        config.setErrorOnDifferentFieldCount(false);
        CsvReader cr=new CsvReader(config);
        File file=new File("E:\\common_lib_test\\common-poi\\CsvWriterlines2.csv");
        CsvData data=cr.read(file);
        System.out.println(data.getRows());
        System.out.println(data.getRowCount());
        Assert.assertEquals(data.getRowCount(),3);
    }
    @Test
    public void CsvReaderConfigsetErrorOnDifferentFieldCountSuccess2(){
        CsvData data=null;
        try {
            CsvReadConfig config=new CsvReadConfig();
            config.setErrorOnDifferentFieldCount(true);
            CsvReader cr = new CsvReader();
            File file=new File("E:\\common_lib_test\\common-poi\\CsvWriterlines2.csv");
            data=cr.read(file);
            System.out.println(data.getRows());
            System.out.println(data.getRowCount());
            Assert.assertEquals(data.getRowCount(),3);
        } catch (Exception e) {
            Assert.assertEquals(data.getRowCount(),3);
        }
    }
    @Test
    public void CsvReaderConfigsetErrorOnDifferentFieldCountSuccess3(){
        CsvReadConfig config=new CsvReadConfig();
        config.setErrorOnDifferentFieldCount(false);
        CsvReader cr=new CsvReader(config);
        File file=new File("E:\\common_lib_test\\common-poi\\CsvWriterlines6.xlsx");
        CsvData data=cr.read(file);
        System.out.println(data.getRows());
        System.out.println(data.getRowCount());
        Assert.assertEquals(data.getRowCount(),2);
    }

}

