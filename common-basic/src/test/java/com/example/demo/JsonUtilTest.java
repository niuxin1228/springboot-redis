package com.example.demo;

import com.uih.uplus.common.utils.basic.JsonUtil;
import com.uih.uplus.common.utils.date.DateUtil;
import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class JsonUtilTest {
    @Data
    static class TestClass{
        private String name;
        private int age;
        private Date birthday;
    }

    private TestClass test = new TestClass();

    @BeforeMethod
    public void before() throws Exception {
        test.setName("张三");
        test.setAge(10);
        test.setBirthday(DateUtil.parseStrToDate("2010/01/01", "yyyy/MM/dd"));
    }

    @Test
    public void bean2JsonTest() {
        String result = JsonUtil.bean2Json(test);
        Assert.assertEquals(result,"{\"age\":10,\"birthday\":{\"date\":1,\"hours\":0,\"seconds\":0,\"month\":0,\"timezoneOffset\":-480,\"year\":110,\"minutes\":0,\"time\":1262275200000,\"day\":5},\"name\":\"张三\"}");
    }

    @Test
    public void bean2JsonTestdate() {
        String result = JsonUtil.bean2Json(test, "yyyy/MM/dd");
        Assert.assertEquals(result,"{\"age\":10,\"birthday\":\"2010/01/01\",\"name\":\"张三\"}");
    }

    @Test
    public void json2BeanTest() {
        TestClass result = JsonUtil.json2Bean("{\"age\":10,\"birthday\":\"2010/01/01\",\"name\":\"张三\"}", TestClass.class);
        Assert.assertEquals(result,test);
    }

    @Test
    public void json2ArrayTest() {
        Object[] resultObj = JsonUtil.json2Array("[{\"age\":10,\"birthday\":\"2010/01/01\",\"name\":\"张三\"}," +
                "{\"age\":10,\"birthday\":\"2010/01/01\",\"name\":\"李四\"}]");

        Assert.assertNotNull(resultObj);
    }

    @Test
    public void json2ArrayTestclass() {
        TestClass[] result = JsonUtil.json2Array("[{\"age\":10,\"birthday\":\"2010/01/01\",\"name\":\"张三\"}," +
                "{\"age\":10,\"birthday\":\"2010/01/01\",\"name\":\"李四\"}]", TestClass.class);

        TestClass test1 = new TestClass();
        test1.setName("李四");
        test1.setAge(10);
        test1.setBirthday(DateUtil.parseStrToDate("2010/01/01", "yyyy/MM/dd"));
        Object[] testArray = new Object[]{test, test1};
        Assert.assertEquals(result, testArray);
    }

    @Test
    public void json2ListTest() {
        List<TestClass> result = JsonUtil.json2List("[{\"age\":10,\"birthday\":\"2010/01/01\",\"name\":\"张三\"}," +
                "{\"age\":10,\"birthday\":\"2010/01/01\",\"name\":\"李四\"}]", TestClass.class);

        TestClass test1 = new TestClass();
        test1.setName("李四");
        test1.setAge(10);
        test1.setBirthday(DateUtil.parseStrToDate("2010/01/01", "yyyy/MM/dd"));
        List<TestClass> testList = new ArrayList<>();
        testList.add(test);
        testList.add(test1);
        Assert.assertEquals(result, testList);
    }

    @Test
    public void json2MapTest() {
        Map<String, Object> result = JsonUtil.json2Map("{\"age\":10,\"birthday\":\"2010/01/01\",\"name\":\"张三\"}");
        Map<String, Object> test = new HashMap<>();
        test.put("age", 10);
        test.put("name", "张三");
        test.put("birthday", "2010/01/01");
        Assert.assertEquals(result, test);
    }

    @Test
    public void map2JsonTest() {
        Map<String, Object> test = new HashMap<>();
        test.put("birthday", "2010/01/01");
        test.put("name", "张三");
        test.put("age", 10);
        String result = JsonUtil.map2Json(test);
        Assert.assertEquals(result, "{\"birthday\":\"2010/01/01\",\"name\":\"张三\",\"age\":10}");
    }

    @Test
    public void isJsonArrayTest() {
        String correct = "[{\"age\":10,\"birthday\":\"2010/01/01\",\"name\":\"张三\"}," +
                "{\"age\":10,\"birthday\":\"2010/01/01\",\"name\":\"李四\"}]";
        boolean result1 = JsonUtil.isJsonArray(correct);
        Assert.assertTrue(result1);

        String unCorrect = "[xxx]";
        boolean result2 = JsonUtil.isJsonArray(unCorrect);
        Assert.assertFalse(result2);
    }

    @Test
    public void isJsonObjectTest() {
        String correct = "{\"age\":10,\"birthday\":\"2010/01/01\",\"name\":\"张三\"}";
        boolean result1 = JsonUtil.isJsonObject(correct);
        Assert.assertTrue(result1);

        String unCorrect = "[xxx]";
        boolean result2 = JsonUtil.isJsonObject(unCorrect);
        Assert.assertFalse(result2);
    }

    @Test
    public void getJsonKeysTest() {
        String json = "{\"age\":10,\"birthday\":\"2010/01/01\",\"name\":\"张三\"}";
        Set result = JsonUtil.getJsonKeys(json);
        Assert.assertTrue(result.size() == 3);
    }
}

