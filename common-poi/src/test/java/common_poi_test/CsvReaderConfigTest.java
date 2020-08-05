
package common_poi_test;

import com.jsoniter.spi.OmitValue;
import com.uih.uplus.common.utils.csv.*;
import com.uih.uplus.common.utils.io.FileUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static com.uih.uplus.common.utils.basic.CharsetUtil.CHARSET_UTF_8;

/*通过CsvReaderConfig设置读取规则
* 是否首行做为标题行，默认false；
* 是否跳过空白行，默认true;
* 设置每行字段个数不同时是否抛出异常，默认false
* */

public class CsvReaderConfigTest {
    @Test
    public void setContainsHeadertest()
    {
        CsvReadConfig aa=new CsvReadConfig();
        aa.setContainsHeader(false);//是否首行做为标题行，默认false；
        aa.setSkipEmptyRows(true);//是否跳过空白行，默认true
        aa.setErrorOnDifferentFieldCount(false);//设置每行字段个数不同时是否抛出异常，默认false
        Assert.assertTrue(true);

        File directory  = new File("");
        CsvReader csvReader=new CsvReader(aa);
        CsvData data = csvReader.read(FileUtil.file("E:\\common_lib_test\\common-poi\\test-write-pathandcharset.csv"));
        //data.getHeader();

        System.out.println("11111");
    }


}

