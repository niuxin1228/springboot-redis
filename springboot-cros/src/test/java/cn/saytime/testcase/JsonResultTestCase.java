package cn.saytime.testcase;

import cn.saytime.Application;
import com.uih.uplus.common.log.logger.IUihLogger;
import com.uih.uplus.common.log.logger.UihLoggerFactory;
import com.uih.uplus.common.utils.result.JsonResult;
import com.uih.uplus.common.utils.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;


@SpringBootTest(classes = Application.class)
public class JsonResultTestCase extends AbstractTestNGSpringContextTests {
    private static final IUihLogger logger = UihLoggerFactory.getUihLogger(JsonResultTestCase.class);

    private static String logicalCode;
    @Value("${app.logical-code}")
    private void setLogicalCode(String code){
        this.logicalCode = code;
    }


    @Test
    public void testResultError1() {
        String code = "34";

        Result result = JsonResult.error(code,"global");
        Result result1 = new Result("U0099" + code, "global");
        Assert.assertEquals(result, result1);
    }
    @Test
    public void testResultError2() {
        String code = "34";
        String data = "xxx";

        Result result = JsonResult.error(code, data,"global");
        Result result1 = new Result("U0099" + code, data, "global");
        Assert.assertEquals(result, result1);
    }
    @Test
    public void testResultSuccess1() {
        Result result = JsonResult.success();
        Result result1 = new Result("U000000" , "success.id");
        Assert.assertEquals(result, result1);
    }
    @Test
    public void testResultSuccess2() {
        String data = "xxx";

        Result result = JsonResult.success(data);
        Result result1 = new Result("U000000" , data, "success.id");
        Assert.assertEquals(result, result1);
    }
    @Test
    public void testResultSuccess3() {
        String data = "xxx";

        Result result = JsonResult.success(data, "global");
        Result result1 = new Result("U000000" , data, "global");
        Assert.assertEquals(result, result1);
    }
}
