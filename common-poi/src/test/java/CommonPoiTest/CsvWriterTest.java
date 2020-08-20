
package CommonPoiTest;

import com.uih.uplus.common.utils.csv.*;
import com.uih.uplus.common.utils.io.FileUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static com.uih.uplus.common.utils.basic.CharsetUtil.*;


public class CsvWriterTest {
    private File directory = new File("");
    private String rootPath=directory.getAbsolutePath();
    @Test
    public void CsvWriterSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest.csv";
        CsvWriter cw=new CsvWriter(filePath);
        String[] line = {"test_write success!"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write success!");

    }
    @Test
    public void CsvWriterCoverpathSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest.csv";
        CsvWriter csvWriter = new CsvWriter(filePath);
        String[] line = {"coverpath test_write success!"};
        csvWriter.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"coverpath test_write success!");
    }
    @Test
    public void CsvWriterCharsetSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest.csv";
        CsvWriter cw=new CsvWriter(filePath,CHARSET_UTF_8);
        String[] line = {"test_write success!utf-8"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write success!utf-8");
    }
    @Test
    public void CsvWriterflieSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest.csv";
        File file=new File(filePath);
        CsvWriter cw=new CsvWriter(file);
        String[] line = {"test_write success!"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvWriterfilecharsetSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest.csv";
        File file=new File(filePath);
        CsvWriter cw=new CsvWriter(file,CHARSET_UTF_8);
        String[] line = {"test_write success!"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvWriterfileAppendSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest.csv";
        File file=new File(filePath);
        CsvWriter cw=new CsvWriter(file,CHARSET_UTF_8,true);
        String[] line = {"test_write success!"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvWriterAppendSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest2.csv";
        CsvWriter cw=new CsvWriter(filePath,CHARSET_UTF_8,true);
        String[] line = {"test_write success!utf-8"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write success!utf-8");
    }
    @Test
    public void CsvWriterconfigSuccess(){
        CsvWriteConfig config=new CsvWriteConfig();
        config.setAlwaysDelimitText(true);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest3.csv";
        CsvWriter cw=new CsvWriter(filePath,CHARSET_UTF_8,true,config);
        String[] line = {"test_write success!utf-8,config"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file("E:\\common_lib_test\\common-poi\\WriteCsvTest3.csv"));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write success!utf-8,config");
    }
    @Test
    public void CsvWriterfileconfigSuccess(){
        CsvWriteConfig config=new CsvWriteConfig();
        config.setAlwaysDelimitText(true);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest.csv";
        File file=new File(filePath);
        CsvWriter cw=new CsvWriter(file,CHARSET_UTF_8,true,config);
        String[] line = {"test_write success!"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write success!");
    }
    @Test
    public void CsvWriterErrorXlsx(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest1.xlsx";
        CsvWriter cw=new CsvWriter(filePath);
        String[] line = {"test_write error!"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write error!");
    }
    @Test
    public void CsvWriterErrorXlsxCharset(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest1.xlsx";
        CsvWriter cw=new CsvWriter(filePath,CHARSET_GBK);
        String[] line = {"test_write error!"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write error!");
    }
    @Test
    public void CsvWriterErrorXlsxAppend(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvTest1.xlsx";
        CsvWriter cw=new CsvWriter(filePath,CHARSET_GBK,true);
        String[] line = {"test_write error!"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write error!");
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
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvUtilTest.csv";
        CsvWriter cw=CsvUtil.getWriter(filePath,CHARSET_GBK);
        String[] line = {"test_write_util success!"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file("E:\\common_lib_test\\common-poi\\WriteCsvUtilTest.csv"));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write_util success!");
    }
    @Test
    public void CsvWriterfileUtilSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvUtilTest.csv";
        File file=new File(filePath);
        CsvWriter cw= CsvUtil.getWriter(file,CHARSET_GBK);
        String[] line = {"test_write_util success!"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write_util success!");
    }
    @Test
    public void CsvWriterUtilappendSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvUtilTest.csv";
        CsvWriter cw=CsvUtil.getWriter(filePath,CHARSET_GBK,true);
        String[] line = {"test_write_util success!"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write_util success!");
    }
    @Test
    public void CsvWriterfileUtilappendSuccess(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvUtilTest.csv";
        File file=new File(filePath);
        CsvWriter cw= CsvUtil.getWriter(file,CHARSET_GBK,true);
        String[] line = {"test_write_util success!"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write_util success!");
    }
    @Test
    public void CsvWriterUtilconfigSuccess(){
        CsvWriteConfig config=new CsvWriteConfig();
        config.setAlwaysDelimitText(true);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvUtilTest.csv";
        File file=new File(filePath);
        CsvWriter cw= CsvUtil.getWriter(file,CHARSET_GBK,true,config);
        String[] line = {"test_write_util success!"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write_util success!");
    }
    @Test
    public void CsvWriterUtilErrorXlsx(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvUtilTest.xlsx";
        CsvWriter cw=CsvUtil.getWriter(filePath,CHARSET_GBK);
        String[] line = {"test_write_util error!"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write_util error!");
    }
    @Test
    public void CsvWriterUtilappendErrorXlsx(){
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"WriteCsvUtilTest.xlsx";
        CsvWriter cw=CsvUtil.getWriter(filePath,CHARSET_GBK,true);
        String[] line = {"test_write_util error!"};
        cw.write(line);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"test_write_util error!");
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
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines1.csv";
        CsvWriter csvWriter=CsvUtil.getWriter(filePath,CHARSET_UTF_8);
        csvWriter.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {"a2", "b2", "c2"},
                new String[] {"a3", "b3", "c3"}
        );
        csvWriter.close();
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(0).get(0);
        Assert.assertEquals(ss,"a1");
    }
    @Test
    public void CsvWriterlinesEmptyRowSuccess()
    {
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines2.csv";
        CsvWriter csvWriter=CsvUtil.getWriter(filePath,CHARSET_UTF_8);
        csvWriter.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {},
                new String[] {"a2", "b2", "c2","d2"},
                new String[] {"a3", "b3", "c3"}
        );
        csvWriter.close();
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(2).get(2);
        Assert.assertEquals(ss,"c3");
    }
    @Test
    public void CsvWriterlinesbeyondSuccess3()
    {
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines7.csv";
        CsvWriter csvWriter=CsvUtil.getWriter(filePath,CHARSET_UTF_8);
        csvWriter.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {},
                new String[] {"a2", "b2", "c2","d2"},
                new String[] {"a3", "b3", "c3"}
        );
        csvWriter.close();
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(2).get(5);
        Assert.assertEquals(ss,null);
    }
    @Test
    public void CsvWriteConfigbeyondSuccess()
    {
        CsvWriteConfig config=new CsvWriteConfig();
        config.setAlwaysDelimitText(true);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines3.csv";
        CsvWriter csvWriter=new CsvWriter(filePath,CHARSET_UTF_8,true,config);
        csvWriter.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {"a2", "b2", "c2"},
                new String[] {"a3", "b3", "c3"}
        );
        System.out.println(config);
        csvWriter.close();
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file("E:\\common_lib_test\\common-poi\\CsvWriterlines3.csv"));
        String ss=data.getRow(2).get(5);
        Assert.assertEquals(ss,null);
    }
    @Test
    public void CsvWriteConfigSuccess()
    {
        CsvWriteConfig config=new CsvWriteConfig();
        config.setAlwaysDelimitText(true);
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines3.csv";
        CsvWriter csvWriter=new CsvWriter(filePath,CHARSET_UTF_8,true,config);
        csvWriter.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {"a2", "b2", "c2"},
                new String[] {"a3", "b3", "c3"}
        );
        System.out.println(config);
        csvWriter.close();
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(1).get(1);
        Assert.assertEquals(ss,"b2");
    }
    @Test
    public void CsvWritesetLineDelimiterSuccess()
    {
        CsvWriteConfig config=new CsvWriteConfig();
        config.setLineDelimiter(
                new char[]{'\n'}
        );
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines4.csv";
        CsvWriter csvWriter=new CsvWriter(filePath,CHARSET_UTF_8);
        csvWriter.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {"a2", "b2", "c2"},
                new String[] {"a3", "b3", "c3"}
        );
        System.out.println(config);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(2).get(2);
        Assert.assertEquals(ss,"c3");
    }
    @Test
    public void CsvWritesetLineDelimiterConfigSuccess()
    {
        CsvWriteConfig config=new CsvWriteConfig();
        config.setLineDelimiter(
                new char[]{'\n'}
        );
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines5.csv";
        CsvWriter csvWriter=new CsvWriter(filePath,CHARSET_UTF_8,false,config);
        csvWriter.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {},
                new String[] {"a3", "b3", "c3"}
        );
        System.out.println(config);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(1).get(1);
        Assert.assertEquals(ss,"b3");
    }
    @Test
    public void CsvWritesetLineDelimiterConfigbeyondSuccess()
    {
        CsvWriteConfig config=new CsvWriteConfig();
        config.setLineDelimiter(
                new char[]{'\n'}
        );
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines6.csv";
        CsvWriter csvWriter=new CsvWriter(filePath,CHARSET_UTF_8,false,config);
        csvWriter.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {},
                new String[] {"a3", "b3", "c3"}
        );
        System.out.println(config);
        CsvReader cr=new CsvReader();
        CsvData data=cr.read(FileUtil.file(filePath));
        String ss=data.getRow(1).get(4);
        Assert.assertEquals(ss,null);
    }
    @Test
    public void CsvWriteConfigXlsxError()
    {
        CsvWriteConfig config=new CsvWriteConfig();
        config.setLineDelimiter(
                new char[]{'\n'}
        );
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines8.xlsx";
        CsvWriter csvWriter=new CsvWriter(filePath,CHARSET_UTF_8,false,config);
        csvWriter.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {},
                new String[] {"a3", "b3", "c3"}
        );
        System.out.println(config);
        csvWriter.close();
        String ss=null;
        try {
            CsvReader cr=new CsvReader();
            CsvData data=cr.read(FileUtil.file(filePath));
            ss=data.getRow(1).get(5);
            Assert.assertEquals(ss,null);
        } catch (Exception e) {
            Assert.assertEquals(ss,null);
        }
    }
    @Test
    public void CsvWriteConfigCsvError()
    {
        CsvWriteConfig config=new CsvWriteConfig();
        config.setLineDelimiter(
                new char[]{'\n'}
        );
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"CsvWriterlines9.csv";
        CsvWriter csvWriter=new CsvWriter(filePath,CHARSET_UTF_8,false,config);
        csvWriter.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {},
                new String[] {"a3", "b3", "c3"}
        );
        System.out.println(config);
        String ss=null;
        try {
            CsvReader cr=new CsvReader();
            CsvData data=cr.read(FileUtil.file(filePath));
            ss=data.getRow(1).get(4);
            Assert.assertEquals(ss,null);
        } catch (Exception e) {
            Assert.assertEquals(ss,null);
        }
    }

}

