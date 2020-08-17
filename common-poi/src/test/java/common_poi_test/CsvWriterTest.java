
package common_poi_test;

import com.uih.uplus.common.utils.csv.CsvUtil;
import com.uih.uplus.common.utils.csv.CsvWriteConfig;
import com.uih.uplus.common.utils.csv.CsvWriter;
import com.uih.uplus.common.utils.io.FileUtil;
import org.bouncycastle.util.encoders.UTF8;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.uih.uplus.common.utils.basic.CharsetUtil.*;


public class CsvWriterTest {

    @Test
    public void CsvWriterSuccess(){
        CsvWriter cw=new CsvWriter("E:\\common_lib_test\\common-poi\\WriteCsvTest.csv");
        String[] line = {"test_write success!"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterCoverpathSuccess(){
        CsvWriter csvWriter = new CsvWriter("E:\\common_lib_test\\common-poi\\WriteCsvTest.csv");
        String[] line = {"coverpath test_write success!"};
        csvWriter.write(line);
        csvWriter.close();
        Assert.assertNotNull(csvWriter);
    }
    @Test
    public void CsvWriterSuccess2(){
        CsvWriter cw=new CsvWriter("E:\\common_lib_test\\common-poi\\WriteCsvTest.csv",CHARSET_UTF_8);
        String[] line = {"test_write success!utf-8"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterSuccess3(){
        File file=new File("E:\\common_lib_test\\common-poi\\WriteCsvTest.csv");
        CsvWriter cw=new CsvWriter(file);
        String[] line = {"test_write success!"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterSuccess4(){
        File file=new File("E:\\common_lib_test\\common-poi\\WriteCsvTest.csv");
        CsvWriter cw=new CsvWriter(file,CHARSET_UTF_8);
        String[] line = {"test_write success!"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterSuccess5(){
        File file=new File("E:\\common_lib_test\\common-poi\\WriteCsvTest.csv");
        CsvWriter cw=new CsvWriter(file,CHARSET_UTF_8,true);
        String[] line = {"test_write success!"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterSuccess6(){
        CsvWriter cw=new CsvWriter("E:\\common_lib_test\\common-poi\\WriteCsvTest.csv",CHARSET_UTF_8,true);
        String[] line = {"test_write success!utf-8"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterSuccess7(){
        CsvWriteConfig config=new CsvWriteConfig();
        config.setAlwaysDelimitText(true);
        CsvWriter cw=new CsvWriter("E:\\common_lib_test\\common-poi\\WriteCsvTest.csv",CHARSET_UTF_8,true,config);
        String[] line = {"test_write success!utf-8,config"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterSuccess8(){
        CsvWriteConfig config=new CsvWriteConfig();
        config.setAlwaysDelimitText(true);
        File file=new File("E:\\common_lib_test\\common-poi\\WriteCsvTest.csv");
        CsvWriter cw=new CsvWriter(file,CHARSET_UTF_8,true,config);
        String[] line = {"test_write success!"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterErrorXlsx(){
        CsvWriter cw=new CsvWriter("E:\\common_lib_test\\common-poi\\WriteCsvTest1.xlsx");
        String[] line = {"test_write error!"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterErrorXlsx2(){
        CsvWriter cw=new CsvWriter("E:\\common_lib_test\\common-poi\\WriteCsvTest1.xlsx",CHARSET_GBK);
        String[] line = {"test_write error!"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterErrorXlsx3(){
        CsvWriter cw=new CsvWriter("E:\\common_lib_test\\common-poi\\WriteCsvTest1.xlsx",CHARSET_GBK,true);
        String[] line = {"test_write error!"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterErrorNoPath(){
        CsvWriter cw=null;
        String[] line = {"test_write error!"};
        try {
            cw=new CsvWriter("F:\\");
            cw.write(line);
            cw.close();

        } catch (Exception e) {
            Assert.assertNull(cw);
        }
        Assert.assertNull(cw);
    }
    @Test
    public void CsvWriterErrorEmptyPath(){
        CsvWriter cw=null;
        String[] line = {"test_write error!"};
        try {
            cw=new CsvWriter("");
            cw.write(line);
            cw.close();

        } catch (Exception e) {
            Assert.assertNull(cw);
        }
        Assert.assertNull(cw);
    }
    @Test
    public void CsvWriterUtilSuccess(){
        CsvWriter cw= CsvUtil.getWriter("E:\\common_lib_test\\common-poi\\WriteCsvUtilTest.csv",CHARSET_GBK);
        String[] line = {"test_write_util success!"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterUtilSuccess2(){
        File file=new File("E:\\common_lib_test\\common-poi\\WriteCsvUtilTest.csv");
        CsvWriter cw= CsvUtil.getWriter(file,CHARSET_GBK);
        String[] line = {"test_write_util success!"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterUtilSuccess3(){
        CsvWriter cw= CsvUtil.getWriter("E:\\common_lib_test\\common-poi\\WriteCsvUtilTest.csv",CHARSET_GBK,true);
        String[] line = {"test_write_util success!"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterUtilSuccess4(){
        File file=new File("E:\\common_lib_test\\common-poi\\WriteCsvUtilTest.csv");
        CsvWriter cw= CsvUtil.getWriter(file,CHARSET_GBK,true);
        String[] line = {"test_write_util success!"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterUtilSuccess5(){
        CsvWriteConfig config=new CsvWriteConfig();
        config.setAlwaysDelimitText(true);
        File file=new File("E:\\common_lib_test\\common-poi\\WriteCsvUtilTest.csv");
        CsvWriter cw= CsvUtil.getWriter(file,CHARSET_GBK,true,config);
        String[] line = {"test_write_util success!"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterUtilErrorXlsx(){
        CsvWriter cw=CsvUtil.getWriter("E:\\common_lib_test\\common-poi\\WriteCsvUtilTest.xlsx",CHARSET_ISO_8859_1);
        String[] line = {"test_write_util error!"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterUtilErrorXlsx2(){
        CsvWriter cw=CsvUtil.getWriter("E:\\common_lib_test\\common-poi\\WriteCsvUtilTest.xlsx",CHARSET_ISO_8859_1,true);
        String[] line = {"test_write_util error!"};
        cw.write(line);
        Assert.assertNotNull(cw);
    }
    @Test
    public void CsvWriterUtilErrorNoPath(){
        CsvWriter cw=null;
        String[] line = {"test_write_util error!"};
        try {
            cw=CsvUtil.getWriter("F:\\",CHARSET_ISO_8859_1);
            cw.write(line);
            cw.close();

        } catch (Exception e) {
            Assert.assertNull(cw);
        }
        Assert.assertNull(cw);
    }
    @Test
    public void CsvWriterUtilErrorEmptyPath(){
        CsvWriter cw=null;
        String[] line = {"test_write error!"};
        try {
            cw=CsvUtil.getWriter("",CHARSET_ISO_8859_1);
            cw.write(line);
            cw.close();

        } catch (Exception e) {
            Assert.assertNull(cw);
        }
        Assert.assertNull(cw);
    }
    @Test
    public void CsvWriterlinesSuccess()
    {
        CsvWriter csvWriter = new CsvWriter("E:\\common_lib_test\\common-poi\\CsvWriterlines1.csv",CHARSET_UTF_8);
        csvWriter.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {"a2", "b2", "c2"},
                new String[] {"a3", "b3", "c3"}
        );
        csvWriter.close();
        Assert.assertNotNull(csvWriter);
    }
    @Test
    public void CsvWriterlinesSuccess2()
    {
        CsvWriter csvWriter = new CsvWriter("E:\\common_lib_test\\common-poi\\CsvWriterlines2.csv",CHARSET_UTF_8);
        csvWriter.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {},
                new String[] {"a2", "b2", "c2","d2"},
                new String[] {"a3", "b3", "c3"}
        );
        csvWriter.close();
        Assert.assertNotNull(csvWriter);
    }
    @Test
    public void CsvWriteConfigSuccess()
    {
        CsvWriteConfig config=new CsvWriteConfig();
        config.setAlwaysDelimitText(true);
        CsvWriter csvWriter = new CsvWriter("E:\\common_lib_test\\common-poi\\CsvWriterlines3.csv",CHARSET_UTF_8);
        csvWriter.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {"a2", "b2", "c2"},
                new String[] {"a3", "b3", "c3"}
        );
        System.out.println(config);
        csvWriter.close();
        Assert.assertNotNull(csvWriter);
    }
    @Test
    public void CsvWriteConfigSuccess2()
    {
        CsvWriteConfig config=new CsvWriteConfig();
        config.setLineDelimiter(
                new char[]{'\n'}
        );
        CsvWriter csvWriter = new CsvWriter("E:\\common_lib_test\\common-poi\\CsvWriterlines4.csv",CHARSET_UTF_8);
        csvWriter.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {"a2", "b2", "c2"},
                new String[] {"a3", "b3", "c3"}
        );

        System.out.println(config);
        csvWriter.close();
        Assert.assertNotNull(config);
    }


}

