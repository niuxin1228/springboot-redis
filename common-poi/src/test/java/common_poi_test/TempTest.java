
package common_poi_test;

import com.uih.uplus.common.utils.csv.CsvWriter;
import com.uih.uplus.common.utils.io.FileUtil;
import org.bouncycastle.util.encoders.UTF8;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.charset.Charset;

import static com.uih.uplus.common.utils.basic.CharsetUtil.CHARSET_UTF_8;


public class TempTest {

    @Test
    public void test_write_coverfile(){

        Assert.assertTrue(true);

        File directory  = new File("");
        String absolutePath = directory.getAbsolutePath();

       // CsvWriter csvWriter = new CsvWriter(absolutePath + "/test-write.csv");
//        String[] line = {"test_write success!"};
//        csvWriter.write(line);
//        csvWriter.close();
        CsvWriter csvWriter = new CsvWriter("E:\\common_lib_test\\common-poi\\demo" + "/test-write.csv",CHARSET_UTF_8,true);
        FileUtil.getWriter("/test-write.csv",CHARSET_UTF_8,true);
    }


    @Test
    public void test_write(){

        Assert.assertTrue(true);

        File directory  = new File("");
        String absolutePath = directory.getAbsolutePath();

        CsvWriter csvWriter = new CsvWriter("E:\\common_lib_test\\common-poi\\demo"  + "/test-write.csv");
        String[] line = {"test_write success!"};
        csvWriter.write(line);
        csvWriter.close();

    }

    @Test
    public void test_write_coverpath(){

        Assert.assertTrue(true);

        File directory  = new File("");
        String absolutePath = directory.getAbsolutePath();

        CsvWriter csvWriter = new CsvWriter(absolutePath + "/test-write-changepath.csv");
        String[] line = {"coverpath test_write success!"};
        csvWriter.write(line);
        csvWriter.close();

    }

    @Test
    public void test_write_lines()
    {

        Assert.assertTrue(true);

        File directory  = new File("");
        String absolutePath = directory.getAbsolutePath();
        CsvWriter csvWriter = new CsvWriter("E:\\common_lib_test\\common-poi"+"/test-write-pathandcharset.csv",CHARSET_UTF_8);
        csvWriter.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {},
                new String[] {"a2", "b2", "c2","d2"},
                new String[] {"a3", "b3", "c3"}
        );
        csvWriter.close();
    }



}

