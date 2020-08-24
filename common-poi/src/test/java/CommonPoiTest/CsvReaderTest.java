
package CommonPoiTest;

import com.uih.uplus.common.utils.csv.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static com.uih.uplus.common.utils.basic.CharsetUtil.CHARSET_GBK;
import static com.uih.uplus.common.utils.basic.CharsetUtil.CHARSET_UTF_8;

/*通过CsvReaderConfig设置读取规则
* 是否首行做为标题行，默认false；
* 是否跳过空白行，默认true;
* 设置每行字段个数不同时是否抛出异常，默认false
* */

public class CsvReaderTest {
    private File directory = new File("");
    private String rootPath=directory.getAbsolutePath();
    @Test
    public void CsvReaderSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest999.csv";
        CsvReader cr=new CsvReader();
        File file=new File(filePath);
        CsvData data=cr.read(file);
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvReaderUtilSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest999.csv";
        CsvReader cr=CsvUtil.getReader();
        File file=new File(filePath);
        CsvData data=cr.read(file);
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvReadercharsetSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest999.csv";
        CsvReader cr=new CsvReader();
        File file=new File(filePath);
        CsvData data=cr.read(file);
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvReaderfileSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest999.csv";
        CsvReader cr=new CsvReader();
        File file=new File(filePath);
        CsvData data=cr.read(file);
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvReaderfilecharsetSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest999.csv";
        CsvReader cr=new CsvReader();
        File file=new File(filePath);
        CsvData data=cr.read(file,CHARSET_UTF_8);
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvReaderutilcharsetSuccess6(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest999.csv";
        CsvReader cr=CsvUtil.getReader();
        File file=new File(filePath);
        CsvData data=cr.read(file,CHARSET_GBK);
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvReaderErrorxlsx(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest998.xlsx";
        CsvReader cr=new CsvReader();
        File file=new File(filePath);
        CsvData data=cr.read(file);
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write error!");
    }
    @Test
    public void CsvReaderErrorNoPath(){
        CsvData data=null;
        try {
            CsvReader cr=new CsvReader();
            File file=new File("F:\\");
            data=cr.read(file);
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
            File file=new File("");
            data=cr.read(file);
            Assert.assertNull(data);

        } catch (Exception e) {
            Assert.assertNull(data);
        }
    }
    @Test
    public void CsvReaderErrorEmptyNoFile(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest1111111111111111.csv";
        CsvData data=null;
        try {
            CsvReader cr=new CsvReader();
            File file=new File(filePath);
            data=cr.read(file);
            Assert.assertNull(data);

        } catch (Exception e) {
            Assert.assertNull(data);
        }
    }
    @Test
    public void CsvReaderErrorFile(){
        CsvData data=null;
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest1111111111111.csv";
        try {
            CsvReader cr=new CsvReader();
            File file=new File(filePath);
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
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest998.xlsx";
        CsvReader cr=new CsvReader();
        File file=new File(filePath);
        CsvData data=cr.read(file);
        String ss=data.getRow(0).get(0);
        System.out.println(data.getRow(0).get(0));
        Assert.assertEquals(ss,"test_write error!");
    }
    @Test
    public void CsvReaderConfigSetContainsHeaderSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines555.csv";
        CsvReadConfig config=new CsvReadConfig();
        config.setContainsHeader(true);
        CsvReader cr=new CsvReader(config);
        File file=new File(filePath);
        CsvData data=cr.read(file);
        System.out.println(data.getRows());
        System.out.println(data.getRowCount());
        Assert.assertEquals(data.getRowCount(),1);
    }
    @Test
    public void CsvReaderConfignotSetContainsHeaderSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines555.csv";
        CsvReadConfig config=new CsvReadConfig();
        config.setContainsHeader(false);
        CsvReader cr=new CsvReader(config);
        File file=new File(filePath);
        CsvData data=cr.read(file);
        System.out.println(data.getRows());
        System.out.println(data.getRowCount());
        Assert.assertEquals(data.getRowCount(),2);
    }
    @Test
    public void CsvReaderConfigSetSkipEmptyRowsSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines555.csv";
        CsvReadConfig config=new CsvReadConfig();
        config.setSkipEmptyRows(true);
        CsvReader cr=new CsvReader(config);
        File file=new File(filePath);
        CsvData data=cr.read(file);
        System.out.println(data.getRows());
        System.out.println(data.getRowCount());
        Assert.assertEquals(data.getRowCount(),2);
    }
    @Test
    public void CsvReaderConfignotSetSkipEmptyRowsSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines555.csv";
        CsvReadConfig config=new CsvReadConfig();
        config.setSkipEmptyRows(false);
        CsvReader cr=new CsvReader(config);
        File file=new File(filePath);
        CsvData data=cr.read(file);
        System.out.println(data.getRows());
        System.out.println(data.getRowCount());
        Assert.assertEquals(data.getRowCount(),3);
    }
    @Test
    public void CsvReaderConfignotSetSkipEmptyRowsbeyondSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines222.csv";
        CsvReadConfig config=new CsvReadConfig();
        config.setSkipEmptyRows(false);
        CsvReader cr=new CsvReader(config);
        File file=new File(filePath);
        CsvData data=cr.read(file);
        String ss=data.getRow(2).get(5);
        Assert.assertEquals(ss,null);
    }
    @Test
    public void CsvReaderConfigSetSkipEmptyRowsrowSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines222.csv";
        CsvReadConfig config=new CsvReadConfig();
        config.setSkipEmptyRows(false);
        CsvReader cr=new CsvReader(config);
        File file=new File(filePath);
        CsvData data=cr.read(file);
        String ss=data.getRow(1).get(1);
        Assert.assertEquals(ss,null);
    }
    @Test
    public void CsvReaderConfigSetSkipEmptyRowstrueSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines222.csv";
        CsvReadConfig config=new CsvReadConfig();
        config.setSkipEmptyRows(true);
        CsvReader cr=new CsvReader(config);
        File file=new File(filePath);
        CsvData data=cr.read(file);
        String ss=data.getRow(1).get(1);
        Assert.assertEquals(ss,"b2");
    }
    @Test
    public void CsvReaderConfigsetErrorOnDifferentFieldCountfalseSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines222.csv";
        CsvReadConfig config=new CsvReadConfig();
        config.setErrorOnDifferentFieldCount(false);
        CsvReader cr=new CsvReader(config);
        File file=new File(filePath);
        CsvData data=cr.read(file);
        System.out.println(data.getRows());
        System.out.println(data.getRowCount());
        Assert.assertEquals(data.getRowCount(),3);
    }
    @Test
    public void CsvReaderConfigsetErrorOnDifferentFieldCountSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines222.csv";
        CsvData data=null;
        try {
            CsvReadConfig config=new CsvReadConfig();
            config.setErrorOnDifferentFieldCount(true);
            CsvReader cr = new CsvReader();
            File file=new File(filePath);
            data=cr.read(file);
            System.out.println(data.getRows());
            System.out.println(data.getRowCount());
            Assert.assertEquals(data.getRowCount(),3);
        } catch (Exception e) {
            Assert.assertEquals(data.getRowCount(),3);
        }
    }
    @Test
    public void CsvReaderConfigsetErrorOnDifferentFieldCountfalsexlsxSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines666.xlsx";
        CsvReadConfig config=new CsvReadConfig();
        config.setErrorOnDifferentFieldCount(false);
        CsvReader cr=new CsvReader(config);
        File file=new File(filePath);
        CsvData data=cr.read(file);
        System.out.println(data.getRows());
        System.out.println(data.getRowCount());
        Assert.assertEquals(data.getRowCount(),2);
    }

}

