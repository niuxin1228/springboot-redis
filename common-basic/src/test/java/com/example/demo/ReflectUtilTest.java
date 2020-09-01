package com.example.demo;

import com.uih.uplus.common.utils.reflect.BeanField;
import com.uih.uplus.common.utils.reflect.IFieldFilter;
import com.uih.uplus.common.utils.reflect.ReflectUtil;
import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectUtilTest {
    @Data
    static class TestClass{
        private Long id;
        private String name;
    }

    @Test
    public void newInstanceTestnull() throws ReflectiveOperationException {
        TestClass test = ReflectUtil.newInstance(TestClass.class, null);

        Assert.assertNotNull(test);
    }

    @Test
    public void newInstanceTest() {
        TestClass test = ReflectUtil.newInstance(
                "com.example.demo.ReflectUtilTest$TestClass", null);
        Assert.assertNotNull(test);
    }

    @Test
    public void findConstructorTest() {
        Constructor result = ReflectUtil.findConstructor(TestClass.class);
        Assert.assertNotNull(result);
    }

    @Test
    public void findConstructorTestcount() {
        Constructor[] result = ReflectUtil.findConstructor(TestClass.class, 0);
        Assert.assertEquals(result.length, 1);
    }

    @Test
    public void getConstructorsTest() {
        Constructor[] result = ReflectUtil.getConstructors(TestClass.class);
        Assert.assertEquals(result.length, 1);
    }

    @Test
    public void getClassByNameTest() throws ClassNotFoundException {
        Class result = ReflectUtil.getClassByName("com.example.demo.ReflectUtilTest$TestClass");
        Assert.assertEquals(result, TestClass.class);
    }

    @Test
    public void getBeanFieldsTest() throws NoSuchMethodException {
        List<BeanField> result = ReflectUtil.getBeanFields(TestClass.class);
        Assert.assertEquals(result.size(), 2);
    }

    @Test
    public void getBeanFieldsTestIFieldFilte() throws NoSuchMethodException {
        List<BeanField> result = ReflectUtil.getBeanFields(TestClass.class, new IFieldFilter() {
            @Override
            public String name() {
                return "testFilter";
            }
            @Override
            public boolean filter(Field field) {
                return field.getName().equals("id");
            }
        });
        Assert.assertEquals(result.size(), 1);
    }

    @Test
    public void getBeanFieldsTestsuper() throws NoSuchMethodException {
        List<BeanField> result = ReflectUtil.getBeanFields(TestClass.class, false);
        Assert.assertEquals(result.size(), 2);
    }

    @Test
    public void getBeanFieldsTestallindex() throws NoSuchMethodException {
        List<BeanField> result = ReflectUtil.getBeanFields(TestClass.class, false, new IFieldFilter() {
            @Override
            public String name() {
                return "testFilter";
            }
            @Override
            public boolean filter(Field field) {
                return field.getName().equals("id");
            }
        });
        Assert.assertEquals(result.size(), 1);
    }

    @Test
    public void getFieldsTest() {
        List<Field> result = ReflectUtil.getFields(TestClass.class);
        Assert.assertEquals(result.size(), 2);
    }

    @Test
    public void getFieldsTestIFieldFilter() {
        List<Field> result = ReflectUtil.getFields(TestClass.class, new IFieldFilter() {
            @Override
            public String name() {
                return "testFilter";
            }
            @Override
            public boolean filter(Field field) {
                return field.getName().equals("id");
            }
        });
        Assert.assertEquals(result.size(), 1);
    }

    @Test
    public void getFieldsTestsuper() throws NoSuchMethodException {
        List<Field> result = ReflectUtil.getFields(TestClass.class, false);
        Assert.assertEquals(result.size(), 2);
    }

    @Test
    public void getFieldsTestallindex() throws NoSuchMethodException {
        List<Field> result = ReflectUtil.getFields(TestClass.class, false, new IFieldFilter() {
            @Override
            public String name() {
                return "testFilter";
            }
            @Override
            public boolean filter(Field field) {
                return field.getName().equals("id");
            }
        });
        Assert.assertEquals(result.size(), 1);
    }

    @Test
    public void getFieldTest() {
        // 能够获取到父类字段
        Field privateField = ReflectUtil.getField(TestClass.class, ReflectUtil.getMethod(TestClass.class, "getName", null));
        Assert.assertNotNull(privateField);
    }


    @Test
    public void setFieldTest() throws NoSuchMethodException {
        TestClass testClass = new TestClass();
        ReflectUtil.setFieldValue(testClass, "name", "张三");
        Assert.assertEquals("张三", testClass.getName());
    }

    @Test
    public void getMethodTest() {
        Method method = ReflectUtil.getMethod(TestClass.class, "getId", null);
        Assert.assertEquals("getId", method.getName());
        Assert.assertEquals(0, method.getParameterTypes().length);

        Method[] methods = ReflectUtil.getMethod(TestClass.class, "setId", 1);
        Assert.assertEquals("setId", methods[0].getName());
        Assert.assertEquals(1, methods[0].getParameterTypes().length);
    }

    @Test
    public void getSetterMethodsTest() {
        List<Method> methods = ReflectUtil.getSetterMethods(TestClass.class);
        Assert.assertEquals(methods.size(), 2);
    }

    @Test
    public void getSetterMethodsTestsuper() {
        List<Method> methods = ReflectUtil.getSetterMethods(TestClass.class, true);
        Assert.assertEquals(methods.size(), 2);
    }

    @Test
    public void getSetterMethodTest() {
        Method result = ReflectUtil.getSetterMethod(TestClass.class, "name");
        Assert.assertEquals(result.getName(), "setName");
    }

    @Test
    public void getSetterMethodTestgetFields() {
        Method result = ReflectUtil.getSetterMethod(TestClass.class, ReflectUtil.getFields(TestClass.class).get(0));
        Assert.assertEquals(result.getName(), "setId");
    }

    @Test
    public void getGetterMethodsTest() {
        List<Method> methods = ReflectUtil.getSetterMethods(TestClass.class);
        Assert.assertEquals(methods.size(), 2);
    }

    @Test
    public void getGetterMethodsTestsuper() {
        List<Method> methods = ReflectUtil.getSetterMethods(TestClass.class, true);
        Assert.assertEquals(methods.size(), 2);
    }

    @Test
    public void getGetterMethodTest() {
        Method result = ReflectUtil.getGetterMethod(TestClass.class, "name");
        Assert.assertEquals(result.getName(), "getName");
    }

    @Test
    public void getGetterMethodTestgetFields() {
        Method result = ReflectUtil.getGetterMethod(TestClass.class, ReflectUtil.getFields(TestClass.class).get(0));
        Assert.assertEquals(result.getName(), "getId");
    }

    @Test
    public void getGetterMethodNameTest() {
        String result = ReflectUtil.getGetterMethodName("name");
        Assert.assertNotNull(result);
    }

    @Test
    public void getGetterMethodNameTestgetFields() {
        String result = ReflectUtil.getGetterMethodName(ReflectUtil.getFields(TestClass.class).get(0));
        Assert.assertNotNull(result);
    }

    @Test
    public void getSetterMethodNameTest() {
        String result = ReflectUtil.getSetterMethodName("name");
        Assert.assertNotNull(result);
    }

    @Test
    public void getSetterMethodNameTestgetFields() {
        String result = ReflectUtil.getSetterMethodName(ReflectUtil.getFields(TestClass.class).get(0));
        Assert.assertNotNull(result);
    }

    @Test
    public void getFieldNameTest() {
        String result = ReflectUtil.getFieldName(ReflectUtil.getSetterMethods(TestClass.class).get(0));
        Assert.assertNotNull(result);
    }

    @Test
    public void getArrayClassesTest() {
        Object[] objs = new Object[]{1, 2L, "3"};
        Class<?>[] result = ReflectUtil.getArrayClasses(objs);
        Assert.assertEquals(result.length ,3);
    }

    @Test
    public void getGenericTypeTest() {
        Class<?> result = ReflectUtil.getGenericType(ReflectUtil.getFields(TestClass.class).get(0));
        Assert.assertEquals(result, Map.class);
    }

    @Test
    public void getFieldValueTest() {
        TestClass testClass = new TestClass();
        testClass.setId(123L);
        testClass.setName("张三");
        String result = (String) ReflectUtil.getFieldValue(testClass, "name");
        Assert.assertEquals(result, "张三");
    }

    @Test
    public void getFieldValuesTest() throws ReflectiveOperationException {
        TestClass testClass = new TestClass();
        testClass.setId(123L);
        testClass.setName("张三");
        Map<Field, Object> result = ReflectUtil.getFieldValues(testClass);
        Assert.assertEquals((long)result.get(ReflectUtil.getFields(TestClass.class).get(0)), 123l);
        Assert.assertEquals(result.get(ReflectUtil.getFields(TestClass.class).get(1)), "张三");
    }

    @Test
    public void setFieldValueTest() throws ReflectiveOperationException {
        TestClass testClass = new TestClass();
        ReflectUtil.setFieldValue(testClass, "name", "张三");
        Assert.assertEquals(testClass.getName(), "张三");
    }

    @Test
    public void findFieldTest() {
        Field field = ReflectUtil.findField(TestClass.class, "name");
        Assert.assertEquals(field.getName(), "name");
    }

    @Test
    public void findFieldIgnoreCaseTest() {
        Field field = ReflectUtil.findFieldIgnoreCase(TestClass.class, "NAME");
        Assert.assertEquals(field.getName(), "name");
    }

    @Test
    public void invokeTest() {
        TestClass testClass = new TestClass();
        ReflectUtil.invoke(testClass, "setName", new Object[]{"张三"});
        Assert.assertEquals("张三", testClass.getName());
    }

    @Test
    public void fieldFilterTest() {
        TestClass testClass = new TestClass();
        testClass.setId(123L);
        testClass.setName("张三");
        Map<String, Object> result = ReflectUtil.fieldFilter(testClass, "name");
        Assert.assertEquals(result.size(), 1);
        Assert.assertEquals(result.get("name"), "张三");
    }

    @Test
    public void isSystemTypeTest() {
        boolean result = ReflectUtil.isSystemType("com.uih.uplus.common.basictest.testcase.ReflectUtilTestCase$TestClass");
        Assert.assertTrue(!result);
        result = ReflectUtil.isSystemType("java.lang.Integer");
        Assert.assertTrue(result);
    }

    @Test
    public void getObjectFromMapTest() throws ParseException, ReflectiveOperationException {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 123L);
        map.put("name", "张三");
        TestClass result = ReflectUtil.getObjectFromMap(TestClass.class, map, false);
        Assert.assertEquals(result.getName(), "张三");
    }

    @Test
    public void getObjectFromMapTestallindex() throws ParseException, ReflectiveOperationException {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 123L);
        map.put("name", "张三");
        TestClass result = ReflectUtil.getObjectFromMap(TestClass.class, map, null, false);
        Assert.assertEquals(result.getName(), "张三");
    }

    @Test
    public void getGenericClassTest() {
        TestClass testClass = new TestClass();
        List<TestClass> list = new ArrayList<>();
        list.add(testClass);
        Class[] result = ReflectUtil.getGenericClass(list);
        Assert.assertNotNull(result);
    }

    @Test
    public void getGenericClassTestlist() {
        Class[] result = ReflectUtil.getGenericClass(List.class);
        Assert.assertNull(result);
    }

    @Test
    public void isBasicTypeTest() {
        boolean result = ReflectUtil.isBasicType(TestClass.class);
        Assert.assertNotNull(!result);
    }

    @Test
    public void classCheckerTest() {
        boolean result = ReflectUtil.classChecker(TestClass.class, null);
        Assert.assertNotNull(!result);
    }
}
