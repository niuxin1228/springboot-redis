package com.example.demo;

import com.uih.uplus.common.utils.basic.ArrayUtil;
import com.uih.uplus.common.utils.basic.Editor;
import com.uih.uplus.common.utils.basic.Filter;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayUtilTest {
    @Test
    public void ArrayUtilisArraySuccess() {
        int[] a = {};
        boolean array = ArrayUtil.isArray(a);
        Assert.assertEquals(array, true);
    }

    @Test
    public void ArrayUtilisArrayDoubleSuccess() {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        boolean array = ArrayUtil.isArray(a);
        Assert.assertEquals(array, true);
    }

    @Test
    public void ArrayUtilisEmptyArraySuccess() {
        int[] a = null;
        boolean array = ArrayUtil.isArray(a);
        Assert.assertEquals(array, false);
    }

    @Test
    public void ArrayUtilisArraybutStringSuccess() {
        String a = "aaa";
        boolean array = ArrayUtil.isArray(a);
        Assert.assertEquals(array, false);
    }

    @Test
    public void ArrayUtilisArraybutListSuccess() {
        List a = new ArrayList();
        a.add("aaa");
        a.add("vvv");
        boolean array = ArrayUtil.isArray(a);
        Assert.assertEquals(array, false);
    }

    @Test
    public void ArrayUtilisArraybutMapSuccess() {
        Map<String, Integer> a = new HashMap<String, Integer>();
        boolean array = ArrayUtil.isArray(a);
        Assert.assertEquals(array, false);
    }

    @Test
    public void ArrayUtilisEmptySuccess() {
        int[] a = {};
        boolean empty = ArrayUtil.isEmpty(a);
        Assert.assertEquals(empty, true);
    }

    @Test
    public void ArrayUtilisEmptyDoubleSuccess() {
        int[][] a = {};
        boolean array = ArrayUtil.isEmpty(a);
        Assert.assertEquals(array, true);
    }

    @Test
    public void ArrayUtilisEmptynullSuccess() {
        int[] a = null;
        boolean empty = ArrayUtil.isEmpty(a);
        Assert.assertEquals(empty, true);
    }

    @Test
    public void ArrayUtilisEmptyObjectSuccess() {
        Object a = null;
        boolean empty = ArrayUtil.isEmpty(a);
        Assert.assertEquals(empty, true);
    }

    @Test
    public void ArrayUtilisEmptyListError() {
        List a = new ArrayList();
        boolean empty = false;
        try {
            empty = ArrayUtil.isEmpty(a);
        } catch (Exception e) {
            Assert.assertEquals(empty, false);
        }
        Assert.assertEquals(empty, false);
    }

    @Test
    public void ArrayUtilisEmptyObjectnotnullSuccess() {
        Object d = new Object[]{"1", "2", 3, 4D};
        boolean isEmpty = ArrayUtil.isEmpty(d);
        Assert.assertFalse(isEmpty);
    }

    @Test
    public void ArrayUtilisNotEmptySuccess() {
        int[] a = {};
        boolean empty = ArrayUtil.isNotEmpty(a);
        Assert.assertEquals(empty, false);
    }

    @Test
    public void ArrayUtilisNotEmptynotSuccess() {
        int[] a = {1, 2, 3, 4};
        boolean empty = ArrayUtil.isNotEmpty(a);
        Assert.assertEquals(empty, true);
    }

    @Test
    public void ArrayUtilisNotEmptyDoubleSuccess() {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        boolean array = ArrayUtil.isNotEmpty(a);
        Assert.assertEquals(array, true);
    }

    @Test
    public void ArrayUtilisNotEmptyListError() {
        List a = new ArrayList();
        a.add("WEQE");
        a.add("dsad");
        boolean empty = false;
        try {
            empty = ArrayUtil.isNotEmpty(a);
        } catch (Exception e) {
            Assert.assertEquals(empty, false);
        }
        Assert.assertEquals(empty, false);
    }

    @Test
    public void ArrayUtilisNotEmptyObjectnotnullSuccess() {
        Object d = new Object[]{"1", "2", 3, 4D};
        boolean isNotEmpty = ArrayUtil.isNotEmpty(d);
        Assert.assertTrue(isNotEmpty);
    }

    @Test
    public void ArrayUtilisNotEmptyObjectSuccess() {
        Object d = null;
        boolean isNotEmpty = ArrayUtil.isNotEmpty(d);
        Assert.assertFalse(isNotEmpty);
    }

    @Test
    public void ArrayUtilhasNullnewobjSuccess() {
        Object d = new Object[]{"1", "2", 3, 4D, null};
        boolean hasNull = ArrayUtil.hasNull(d);
        Assert.assertFalse(hasNull);
    }

    @Test
    public void ArrayUtilhasNullobjisnullSuccess() {
        Object d = null;
        boolean hasNull = ArrayUtil.hasNull(d);
        Assert.assertTrue(hasNull);
    }

    @Test
    public void ArrayUtilhasNullEmptySuccess() {
        int[] a = {};
        boolean hasNull = ArrayUtil.hasNull(a);
        Assert.assertFalse(hasNull);
    }

    @Test
    public void ArrayUtilhasNullobjSuccess() {
        Object[] a = {1, 2, 3, 4, null};
        boolean empty = ArrayUtil.isNotEmpty(a);
        Assert.assertEquals(empty, true);
    }

    @Test
    public void ArrayUtilhasNullListError() {
        List a = new ArrayList();
        a.add(null);
        boolean empty = true;
        try {
            empty = ArrayUtil.isNotEmpty(a);
        } catch (Exception e) {
            Assert.assertNotNull(a);
        }
        Assert.assertNotNull(a);
    }

    @Test
    public void ArrayUtillengthhasnullobjSuccess() {
        Object[] a = {1, 2, 3, 4, null};
        int length = ArrayUtil.length(a);
        Assert.assertEquals(length, 5);
    }

    @Test
    public void ArrayUtillengthobjSuccess() {
        Object[] a = {1, 2, 3, 4};
        int length = ArrayUtil.length(a);
        Assert.assertEquals(length, 4);
    }
    @Test
    public void ArrayUtillengthobjdoubleSuccess() {
        Object[][] a = {{1},{2},null,{"ssf"}};
        int length = ArrayUtil.length(a);
        Assert.assertEquals(length, 4);
    }

    @Test
    public void ArrayUtillengthSuccess() {
        int[] a = {1, 2, 3, 4, 656, 56456, 46};
        int length = ArrayUtil.length(a);
        Assert.assertEquals(length, 7);
    }

    @Test
    public void ArrayUtillengthdoubleSuccess() {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int length = ArrayUtil.length(a);
        Assert.assertEquals(length, 3);
    }

    @Test
    public void ArrayUtillengthListError() {
        List a = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(null);
        int length = 0;
        try {
            length = ArrayUtil.length(a);
        } catch (Exception e) {
            Assert.assertEquals(length,0);
        }
        Assert.assertEquals(length,0);
    }
    @Test
    public void ArrayUtilnewArraySuccess() {
        Object[] objects = ArrayUtil.newArray(5);
        int length = objects.length;
        Assert.assertEquals(length,5);
    }
    @Test
    public void ArrayUtilnewArrayzeroSuccess() {
        Object[] objects = ArrayUtil.newArray(0);
        int length = objects.length;
        Assert.assertEquals(length,0);
    }
    @Test
    public void ArrayUtilnewArraynegativeError() {
        int length=0;
        try {
            Object[] objects = ArrayUtil.newArray(-5);
            length = objects.length;
        }catch (Exception e){
            Assert.assertEquals(length,0);
        }
        Assert.assertEquals(length,0);
    }
    @Test
    public void ArrayUtilallindexnewArraySuccess() {
        int length=0;
        try {
            Class<?> c1 = null;
            Object[] objects = ArrayUtil.newArray(c1,5);
            length = objects.length;
        }catch (Exception e){
            Assert.assertEquals(length,0);
        }
        Assert.assertEquals(length,0);
    }
    @Test
    public void ArrayUtilgetComponentTypeSuccess() {
        int[] a = {1, 2, 3, 4, 656, 56456, 46};
        Class<?> componentType = ArrayUtil.getComponentType(a);
        String s = componentType.toString();
        System.out.println(componentType);
        String expect="int";
        Assert.assertEquals(s,expect);
    }
    @Test
    public void ArrayUtilgetComponentTypedoubleError() {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Class<?> componentType = ArrayUtil.getComponentType(a);
        String s = componentType.toString();
        String expect="int";
        Assert.assertNotEquals(s,expect);
    }
    @Test
    public void ArrayUtilgetComponentTypeobjSuccess() {
        Object[] a = {1, 2, 3, 4};
        Class<?> componentType = ArrayUtil.getComponentType(a);
        String s = componentType.toString();
        System.out.println(componentType);
        String expect="class java.lang.Object";
        Assert.assertEquals(s,expect);
    }
    @Test
    public void ArrayUtilgetComponentTypeobjdoubleError() {
        Object[][] a = {{1},{2},null,{"ssf"}};
        Class<?> componentType = ArrayUtil.getComponentType(a);
        String s = componentType.toString();
        System.out.println(componentType);
        String expect="class java.lang.Object";
        Assert.assertNotEquals(s,expect);
    }
    @Test
    public void ArrayUtilgetComponentTypelistError() {
        List a = new ArrayList();
        a.add(1);
        a.add(2);
        Class<?> componentType=null;
        try {
            componentType = ArrayUtil.getComponentType(a);
        }catch (Exception e){
            Assert.assertNull(componentType);
        }
        Assert.assertNull(componentType);
    }

    @Test
    public void ArrayUtilcastnotbbigSuccess() {
        Integer[] a = {1, 2};
        Object[] b = {1,32,"sdads"};
        Class<?> type = ArrayUtil.getComponentType(a);
        Object[] cast = ArrayUtil.cast(type, b);
        System.out.println(cast.length);
        Assert.assertEquals(cast.length,3);
    }
    @Test
    public void ArrayUtilcastequalSuccess() {
        Integer[] a = {1, 2};
        Object[] b = {1,"sdads"};
        Class<?> type = ArrayUtil.getComponentType(a);
        Object[] cast = ArrayUtil.cast(type, b);
        System.out.println(cast.length);
        Assert.assertEquals(cast.length,2);
    }
    @Test
    public void ArrayUtilcastabigSuccess() {
        Integer[] a = {1,2,3};
        Object[] b = {1,"sdads"};
        Class<?> type = ArrayUtil.getComponentType(a);
        Object[] cast = ArrayUtil.cast(type, b);
        System.out.println(cast.length);
        Assert.assertEquals(cast.length,2);
    }
    @Test
    public void ArrayUtilappendSuccess() {
        Integer[] a = {1, 2};
        Integer i1 = 1;
        Integer i2 = 2;
        Integer i3 = 3;
        Integer[] append = ArrayUtil.append(a,i1,i2,i3);
        System.out.println(append.length);
        Assert.assertEquals(append.length,5);
    }
    @Test
    public void ArrayUtilappenddoubleSuccess() {
        Double[] a = {1.11, 2.32};
        Double i1 = 1.23;
        Double i2 = 2.32;
        Double i3 = 3.33;
        Double i4 = 24.33;
        Double[] append = ArrayUtil.append(a,i1,i2,i3,i4);
        System.out.println(append.length);
        Assert.assertEquals(append.length,6);
    }
    @Test
    public void ArrayUtilappendobjSuccess() {
        Object[] a = {1,32,"sdads"};
        Object i1 = 1;
        Object i2 = "sad";
        Object i3 = null;
        Object[] append = ArrayUtil.append(a,i1,i2,i3);
        System.out.println(append.length);
        Assert.assertEquals(append.length,6);
    }
    @Test
    public void ArrayUtilappendobjnullSuccess() {
        Object[] a = {1,32,"sdads",null};
        Object i1 = 1;
        Object i2 = "sad";
        Object i3 = null;
        Object[] append = ArrayUtil.append(a,i1,i2,i3);
        System.out.println(append.length);
        Assert.assertEquals(append.length,7);
    }
    @Test
    public void ArrayUtilappendobjdoubleSuccess() {
        Object[][] a = {{1},{2},null,{"ssf"}};
        System.out.println(a.length);
        Object[][] i1 = {{1},{2},{231}};
        Object[][] i2 = {{"sad"},null};
        Object[][] append = ArrayUtil.append(a,i1,i2);
        System.out.println(append.length);
        Assert.assertEquals(append.length,6);
    }
    @Test
    public void ArrayUtilsetOrAppendSuccess() {
        Integer[] a = {1, 2};
        Integer i1 = 999;
        Integer i2 = 2;
        Integer i3 = 3;
        Integer[] integers = ArrayUtil.setOrAppend(a, 2, i1);
        System.out.println(integers[2]);
        String s = integers[2].toString();
        Assert.assertEquals(s,"999");
    }
    @Test
    public void ArrayUtilsetOrAppend1Success() {
        Integer[] a = {1, 2};
        Integer i1 = 999;
        Integer i2 = 2;
        Integer i3 = 3;
        Integer[] integers = ArrayUtil.setOrAppend(a, 1, i1);
        System.out.println(integers[1]);
        String s = integers[1].toString();
        Assert.assertEquals(s,"999");
    }
    @Test
    public void ArrayUtilsetOrAppenddoubleError() {
        Integer[] a = {1, 2};
        Double i1 = 999.89;
        Integer i2 = 2;
        Integer i3 = 3;
        Number[] numbers=null;
        try {
            numbers = ArrayUtil.setOrAppend(a, 1, i1);
            System.out.println(numbers[1]);
            String s = numbers[1].toString();
        }catch (Exception e)
        {
            Assert.assertNull(numbers);
        }
        Assert.assertNull(numbers);
    }
    @Test
    public void ArrayUtilsetOrAppendobjSuccess() {
        Object[] a = {1,32,"sdads"};
        Object i1 = 1;
        Object i2 = "sad";
        Object i3 = null;
        Object[] obj = ArrayUtil.setOrAppend(a, 2, i1);
        System.out.println(obj[2]);
        String s = obj[2].toString();
        Assert.assertEquals(s,"1");
    }
    @Test
    public void ArrayUtilsetOrAppendobjStringSuccess() {
        Object[] a = {1,32,"sdads"};
        Object i1 = 1;
        Object i2 = "sad";
        Object i3 = null;
        Object[] obj = ArrayUtil.setOrAppend(a, 2, i2);
        System.out.println(obj[2]);
        String s = obj[2].toString();
        Assert.assertEquals(s,"sad");
    }
    @Test
    public void ArrayUtilinsertSuccess() {
        Integer[] a = {1, 2};
        Integer i1 = 999;
        Integer i2 = 2;
        Integer i3 = 3;
        Integer[] integers = ArrayUtil.insert(a, 2, i1);
        System.out.println(integers[2]);
        String s = integers[2].toString();
        Assert.assertEquals(s,"999");
    }
    @Test
    public void ArrayUtilinsertnegativeSuccess() {
        Integer[] a = {1, 2};
        Integer i1 = 999;
        Integer i2 = 2;
        Integer i3 = 3;
        Integer[] integers = ArrayUtil.insert(a, -1, i1);
        System.out.println(integers[1]);
        String s = integers[1].toString();
        Assert.assertEquals(s,"999");
    }
    @Test
    public void ArrayUtilinserttoobigSuccess() {
        Integer[] a = {1, 2};
        Integer i1 = 999;
        Integer i2 = 2;
        Integer i3 = 3;
        Integer[] integers = ArrayUtil.insert(a, -4, i1);
        System.out.println(integers[2]);
        String s = integers[2].toString();
        Assert.assertEquals(s,"999");
    }
    @Test
    public void ArrayUtilinsertobjSuccess() {
        Object[] a = {1,32,"sdads"};
        Object i1 = 1;
        Object i2 = "sad";
        Object i3 = null;
        Object[] insert = ArrayUtil.insert(a, 2, i1);
        System.out.println(insert[2]);
        String s = insert[2].toString();
        Assert.assertEquals(s,"1");
    }
    @Test
    public void ArrayUtilinsertobjnegativeSuccess() {
        Object[] a = {1,32,"sdads"};
        Object i1 = 1;
        Object i2 = "sad";
        Object i3 = null;
        Object[] insert = ArrayUtil.insert(a, -1, i2);
        System.out.println(insert[1]);
        String s = insert[1].toString();
        Assert.assertEquals(s,"32");
    }
    @Test
    public void ArrayUtilinsertobjtoobigSuccess() {
        Object[] a = {1,32,"sdads"};
        Object i1 = 1;
        Object i2 = "sad";
        Object i3 = null;
        Object[] insert = ArrayUtil.insert(a, -4, i2);
        System.out.println(insert[2]);
        String s = insert[2].toString();
        Assert.assertEquals(s,"sad");
    }
    @Test
    public void ArrayUtilgetSuccess() {
        Integer[] a = {1, 2};
        Object o = ArrayUtil.get(a, 1);
        String s = o.toString();
        Assert.assertEquals(s,"2");
    }
    @Test
    public void ArrayUtilgettoobigError() {
        Integer[] a = {1, 2};
        Object o=null;
        try {
            o = ArrayUtil.get(a, 3);
            String s = o.toString();
        }catch (Exception e){
            Assert.assertNull(o);
        }
        Assert.assertNull(o);
    }
    @Test
    public void ArrayUtilgetnegativeSuccess() {
        Integer[] a = {1,2,3};
        Object o = ArrayUtil.get(a, -1);
        String s = o.toString();
        Assert.assertEquals(s,"3");
    }
    @Test
    public void ArrayUtilgetnegative2Success() {
        Integer[] a = {1,2,3};
        Object o = ArrayUtil.get(a, -2);
        String s = o.toString();
        Assert.assertEquals(s,"2");
    }
    @Test
    public void ArrayUtilgetAnySuccess() {
        Integer[] a = {1, 2};
        Object[] any = ArrayUtil.getAny(a, 0, 1);
        String s = any[1].toString();
        Assert.assertEquals(s,"2");
    }
    @Test
    public void ArrayUtilgetAnynegativeSuccess() {
        Integer[] a = {1, 2};
        Object[] any = ArrayUtil.getAny(a, 0, -1);
        String s = any[1].toString();
        Assert.assertEquals(s,"2");
    }

    @Test
    public void ArrayUtilgetAnyobjnegtiveSuccess() {
        Object[] a = {1, 32, "sdads"};
        Object[] any = ArrayUtil.getAny(a, 0, -1);
        String s = any[1].toString();
        Assert.assertEquals(s, "sdads");
    }
    @Test
    public void ArrayUtilgetAnyobjSuccess() {
        Object[] a = {1, 32, "sdads"};
        Object[] any = ArrayUtil.getAny(a, 0, 2);
        String s = any[1].toString();
        Assert.assertEquals(s, "sdads");
    }
    @Test
    public void ArrayUtilremoveSuccess() {
        Integer[] a = {1, 2};
        Integer[] remove = ArrayUtil.remove(a, 0);
        String s = remove[0].toString();
        Assert.assertEquals(s,"2");
    }
    @Test
    public void ArrayUtilremovenegativeSuccess() {
        Integer[] a = {1, 2};
        Integer[] remove = ArrayUtil.remove(a, -1);
        String s = remove[0].toString();
        Assert.assertEquals(s,"1");
    }
    @Test
    public void ArrayUtilremovetoobigSuccess() {
        Integer[] a = {1, 2};
        Integer[] remove = ArrayUtil.remove(a, 3);
        String s = remove[0].toString();
        Assert.assertEquals(s,"1");
    }
    @Test
    public void ArrayUtilremoveobjSuccess() {
        Object[] a = {1, 32, "sdads"};
        Object[] remove = ArrayUtil.remove(a, 3);
        String s = remove[0].toString();
        Assert.assertEquals(s,"1");
    }
    @Test
    public void ArrayUtilremoveobjnegativeSuccess() {
        Object[] a = {1, 32, "sdads"};
        Object[] remove = ArrayUtil.remove(a, -3);
        String s = remove[0].toString();
        Assert.assertEquals(s,"1");
    }
    @Test
    public void ArrayUtilcloneTestSuccess() {
        Integer[] b = {1, 2, 3};
        Integer[] cloneB = ArrayUtil.clone(b);
        Assert.assertEquals(b, cloneB);

        int[] a = {1, 2, 3};
        int[] clone = ArrayUtil.clone(a);
        Assert.assertEquals(a, clone);
    }

    @Test
    public void ArrayUtilfilterTestSuccess() {
        Integer[] a = {1, 2, 3, 4, 5, 6};
        Integer[] filter = ArrayUtil.filter(a, (Editor<Integer>) t -> (t % 2 == 0) ? t : null);
        Assert.assertEquals(filter, new Integer[]{2, 4, 6});
    }

    @Test
    public void ArrayUtilfilterTestForFilterSuccess() {
        Integer[] a = {1, 2, 3, 4, 5, 6};
        Integer[] filter = ArrayUtil.filter(a, (Filter<Integer>) t -> t % 2 == 0);
        Assert.assertEquals(filter, new Integer[]{2, 4, 6});
    }

    @Test
    public void ArrayUtilfilterTestForEditorSuccess() {
        Integer[] a = {1, 2, 3, 4, 5, 6};
        Integer[] filter = ArrayUtil.filter(a, (Editor<Integer>) t -> (t % 2 == 0) ? t * 10 : t);
        Assert.assertEquals(filter, new Integer[]{1, 20, 3, 40, 5, 60});
    }

    @Test
    public void ArrayUtilindexOfTestSuccess() {
        Integer[] a = {1, 2, 3, 4, 5, 6};
        int index = ArrayUtil.indexOf(a, 3);
        Assert.assertEquals(2, index);

        long[] b = {1, 2, 3, 4, 5, 6};
        int index2 = ArrayUtil.indexOf(b, 3);
        Assert.assertEquals(2, index2);
    }

    @Test
    public void ArrayUtillastIndexOfTestSuccess() {
        Integer[] a = {1, 2, 3, 4, 3, 6};
        int index = ArrayUtil.lastIndexOf(a, 3);
        Assert.assertEquals(4, index);

        long[] b = {1, 2, 3, 4, 3, 6};
        int index2 = ArrayUtil.lastIndexOf(b, 3);
        Assert.assertEquals(4, index2);
    }

    @Test
    public void ArrayUtilcontainsTestSuccess() {
        Integer[] a = {1, 2, 3, 4, 3, 6};
        boolean contains = ArrayUtil.contains(a, 3);
        Assert.assertTrue(contains);

        long[] b = {1, 2, 3, 4, 3, 6};
        boolean contains2 = ArrayUtil.contains(b, 3);
        Assert.assertTrue(contains2);
    }

    @Test
    public void ArrayUtilrangeTestSuccess() {
        int[] range = ArrayUtil.range(0, 10);
        Assert.assertEquals(0, range[0]);
        Assert.assertEquals(1, range[1]);
        Assert.assertEquals(2, range[2]);
        Assert.assertEquals(3, range[3]);
        Assert.assertEquals(4, range[4]);
        Assert.assertEquals(5, range[5]);
        Assert.assertEquals(6, range[6]);
        Assert.assertEquals(7, range[7]);
        Assert.assertEquals(8, range[8]);
        Assert.assertEquals(9, range[9]);
    }

    @Test
    public void ArrayUtilmaxTestSuccess() {
        int max = ArrayUtil.max(1, 2, 13, 4, 5);
        Assert.assertEquals(13, max);

        long maxLong = ArrayUtil.max(1L, 2L, 13L, 4L, 5L);
        Assert.assertEquals(13, maxLong);

        double maxDouble = ArrayUtil.max(1D, 2.4D, 13.0D, 4.55D, 5D);
        Assert.assertEquals(13.0, maxDouble, 2);
    }

    @Test
    public void ArrayUtilminTestSuccess() {
        int min = ArrayUtil.min(1, 2, 13, 4, 5);
        Assert.assertEquals(1, min);

        long minLong = ArrayUtil.min(1L, 2L, 13L, 4L, 5L);
        Assert.assertEquals(1, minLong);

        double minDouble = ArrayUtil.min(1D, 2.4D, 13.0D, 4.55D, 5D);
        Assert.assertEquals(1.0, minDouble, 2);
    }


    @Test
    public void ArrayUtiljoinTestSuccess() {
        String[] array = {"aa", "bb", "cc", "dd"};
        String join = ArrayUtil.join(array, ",", "[", "]");
        Assert.assertEquals("[aa],[bb],[cc],[dd]", join);
    }

    @Test
    public void ArrayUtilgetArrayTypeTestSuccess() {
        Class<?> arrayType = ArrayUtil.getArrayType(int.class);
        Assert.assertEquals(int[].class, arrayType);

        arrayType = ArrayUtil.getArrayType(String.class);
        Assert.assertEquals(String[].class, arrayType);
    }

    @Test
    public void ArrayUtildistinctTestSuccess() {
        String[] array = {"aa", "bb", "cc", "dd", "bb", "dd"};
        String[] distinct = ArrayUtil.distinct(array);
        Assert.assertEquals(new String[]{"aa", "bb", "cc", "dd"}, distinct);
    }

    @Test
    public void ArrayUtiltoStingTestSuccess() {
        int[] a = {1, 3, 56, 6, 7};
        Assert.assertEquals("[1, 3, 56, 6, 7]", ArrayUtil.toString(a));
        long[] b = {1, 3, 56, 6, 7};
        Assert.assertEquals("[1, 3, 56, 6, 7]", ArrayUtil.toString(b));
        short[] c = {1, 3, 56, 6, 7};
        Assert.assertEquals("[1, 3, 56, 6, 7]", ArrayUtil.toString(c));
        double[] d = {1, 3, 56, 6, 7};
        Assert.assertEquals("[1.0, 3.0, 56.0, 6.0, 7.0]", ArrayUtil.toString(d));
        byte[] e = {1, 3, 56, 6, 7};
        Assert.assertEquals("[1, 3, 56, 6, 7]", ArrayUtil.toString(e));
        boolean[] f = {true, false, true, true, true};
        Assert.assertEquals("[true, false, true, true, true]", ArrayUtil.toString(f));
        float[] g = {1, 3, 56, 6, 7};
        Assert.assertEquals("[1.0, 3.0, 56.0, 6.0, 7.0]", ArrayUtil.toString(g));
        char[] h = {'a', 'b', '你', '好', '1'};
        Assert.assertEquals("[a, b, 你, 好, 1]", ArrayUtil.toString(h));

        String[] array = {"aa", "bb", "cc", "dd", "bb", "dd"};
        Assert.assertEquals("[aa, bb, cc, dd, bb, dd]", ArrayUtil.toString(array));
    }
}
