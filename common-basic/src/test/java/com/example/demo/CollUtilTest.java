package com.example.demo;

import com.uih.uplus.common.utils.basic.CollUtil;
import com.uih.uplus.common.utils.basic.Editor;
import com.uih.uplus.common.utils.basic.MapUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class CollUtilTest {
    @Test
    public void newHashSetTest() {
        Set<String> set = CollUtil.newHashSet(CollUtil.newArrayList("a", "b", "b", "c", "d", "x"));
        Assert.assertNotNull(set);
    }

    @Test
    public void unionTest() {
        List<String> list1 = CollUtil.newArrayList("a", "b", "b", "c", "d", "x");
        List<String> list2 = CollUtil.newArrayList("a", "b", "b", "b", "c", "d");

        Collection<String> union = CollUtil.union(list1, list2);

        Assert.assertEquals(3, CollUtil.count(union, t -> t.equals("b")));
    }

    @Test
    public void intersectionTest() {
        List<String> list1 = CollUtil.newArrayList("a", "b", "b", "c", "d", "x");
        List<String> list2 = CollUtil.newArrayList("a", "b", "b", "b", "c", "d");

        Collection<String> union = CollUtil.intersection(list1, list2);
        Assert.assertEquals(2, CollUtil.count(union, t -> t.equals("b")));
    }

    @Test
    public void disjunctionTest() {
        List<String> list1 = CollUtil.newArrayList("a", "b", "b", "c", "d", "x");
        List<String> list2 = CollUtil.newArrayList("a", "b", "b", "b", "c", "d", "x2");

        Collection<String> disjunction = CollUtil.disjunction(list1, list2);
        Assert.assertTrue(disjunction.contains("b"));
        Assert.assertTrue(disjunction.contains("x2"));
        Assert.assertTrue(disjunction.contains("x"));

        Collection<String> disjunction2 = CollUtil.disjunction(list2, list1);
        Assert.assertTrue(disjunction2.contains("b"));
        Assert.assertTrue(disjunction2.contains("x2"));
        Assert.assertTrue(disjunction2.contains("x"));
    }

    @Test
    public void disjunctionTestoneEmpty() {
        // 任意一个集合为空，差集为另一个集合
        List<String> list1 = CollUtil.newArrayList();
        List<String> list2 = CollUtil.newArrayList("a", "b", "b", "b", "c", "d", "x2");

        Collection<String> disjunction = CollUtil.disjunction(list1, list2);
        Assert.assertEquals(list2, disjunction);
        Collection<String> disjunction2 = CollUtil.disjunction(list2, list1);
        Assert.assertEquals(list2, disjunction2);
    }

    @Test
    public void disjunctionTestnoIntersection() {
        // 无交集下返回共同的元素
        List<String> list1 = CollUtil.newArrayList("1", "2", "3");
        List<String> list2 = CollUtil.newArrayList("a", "b", "c");

        Collection<String> disjunction = CollUtil.disjunction(list1, list2);
        Assert.assertTrue(disjunction.contains("1"));
        Assert.assertTrue(disjunction.contains("2"));
        Assert.assertTrue(disjunction.contains("3"));
        Assert.assertTrue(disjunction.contains("a"));
        Assert.assertTrue(disjunction.contains("b"));
        Assert.assertTrue(disjunction.contains("c"));
        Collection<String> disjunction2 = CollUtil.disjunction(list2, list1);
        Assert.assertTrue(disjunction2.contains("1"));
        Assert.assertTrue(disjunction2.contains("2"));
        Assert.assertTrue(disjunction2.contains("3"));
        Assert.assertTrue(disjunction2.contains("a"));
        Assert.assertTrue(disjunction2.contains("b"));
        Assert.assertTrue(disjunction2.contains("c"));
    }

    @Test
    public void toMapListAndToListMapTest() {
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("a", "值1");
        map1.put("b", "值1");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("a", "值2");
        map2.put("c", "值3");

        // ----------------------------------------------------------------------------------------
        List<HashMap<String, String>> list = CollUtil.newArrayList(map1, map2);
        Map<String, List<String>> map = MapUtil.toListMap(list);
        Assert.assertEquals("值1", map.get("a").get(0));
        Assert.assertEquals("值2", map.get("a").get(1));

        // ----------------------------------------------------------------------------------------
        List<Map<String, String>> listMap = MapUtil.toMapList(map);
        Assert.assertEquals("值1", listMap.get(0).get("a"));
        Assert.assertEquals("值2", listMap.get(1).get("a"));
    }

    @Test
    public void splitTest() {
        final List<Integer> list = CollUtil.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<List<Integer>> split = CollUtil.split(list, 3);
        Assert.assertEquals(3, split.size());
        Assert.assertEquals(3, split.get(0).size());
    }

    @Test
    public void filterTest() {
        List<String> list = CollUtil.newArrayList("a", "b", "c");

        Collection<String> filtered = CollUtil.filter(list, (Editor<String>) t -> t + 1);

        Assert.assertEquals(CollUtil.newArrayList("a1", "b1", "c1"), filtered);
    }

    @Test
    public void groupTest() {
        List<String> list = CollUtil.newArrayList("1", "2", "3", "4", "5", "6");
        List<List<String>> group = CollUtil.group(list, null);
        Assert.assertTrue(group.size() > 0);

        List<List<String>> group2 = CollUtil.group(list, t -> {
            // 按照奇数偶数分类
            return Integer.parseInt(t) % 2;
        });
        Assert.assertEquals(CollUtil.newArrayList("2", "4", "6"), group2.get(0));
        Assert.assertEquals(CollUtil.newArrayList("1", "3", "5"), group2.get(1));
    }

    @Test
    public void groupByFieldTest() {
        List<TestBean> list = CollUtil.newArrayList(new TestBean("张三", 12), new TestBean("李四", 13), new TestBean("王五", 12));
        List<List<TestBean>> groupByField = CollUtil.groupByField(list, "age");
        Assert.assertEquals("张三", groupByField.get(0).get(0).getName());
        Assert.assertEquals("王五", groupByField.get(0).get(1).getName());

        Assert.assertEquals("李四", groupByField.get(1).get(0).getName());
    }

    @Test
    public void sortByPropertyTest() {
        List<TestBean> list = CollUtil.newArrayList(new TestBean("张三", 13), //
                new TestBean("李四", 11), //
                new TestBean("王五", 12)//
        );

        CollUtil.sortByProperty(list, "age");
        Assert.assertEquals("李四", list.get(0).getName());
        Assert.assertEquals("王五", list.get(1).getName());
        Assert.assertEquals("张三", list.get(2).getName());
    }

    public static class TestBean {
        private String name;
        private int age;

        public TestBean(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "TestBeans [name=" + name + ", age=" + age + "]";
        }
    }

    @Test
    public void listTest() {
        List<Object> list1 = CollUtil.list(false);
        List<Object> list2 = CollUtil.list(true);

        Assert.assertTrue(list1 instanceof ArrayList);
        Assert.assertTrue(list2 instanceof LinkedList);
    }

    @Test
    public void listTestvalue() {
        List<String> list1 = CollUtil.list(false, (Collection<String>) null);
        Assert.assertNotNull(list1);
        List<String> list2 = CollUtil.list(false, "a", "b", "c");
        List<String> list3 = CollUtil.list(true, "a", "b", "c");
        Assert.assertEquals("[a, b, c]", list2.toString());
        Assert.assertEquals("[a, b, c]", list3.toString());

        List<String> list4 = CollUtil.toList("a", "b", "c");
        Assert.assertEquals("[a, b, c]", list4.toString());

        List<String> list5 = CollUtil.newArrayList("a", "b", "c");
        Assert.assertEquals("[a, b, c]", list5.toString());

        List<String> list6 = CollUtil.distinct( CollUtil.toList("a", "a", "b", "b", "c"));
        Assert.assertEquals("[a, b, c]", list6.toString());

        List<String> list7 = CollUtil.sub( CollUtil.toList("a", "a", "b", "b", "c"), 1, 2);
        Assert.assertEquals("[a]", list7.toString());

        List<String> list8 = CollUtil.sub( CollUtil.toList("a", "a", "b", "b", "c"), 1, 4, 2);
        Assert.assertEquals("[a, b]", list8.toString());

        Assert.assertTrue(CollUtil.containsAny(list7, list8));

        Assert.assertTrue(CollUtil.isEmpty((Collection<String>) null));
        Assert.assertTrue(!CollUtil.isNotEmpty((Collection<String>) null));
        Assert.assertTrue(CollUtil.isEmpty((Map) null));
        Assert.assertTrue(!CollUtil.isNotEmpty((Map) null));

    }

    @Test
    public void listTesthash() {
        List<String> list1 = CollUtil.list(false, (Iterable<String>) null);
        Assert.assertNotNull(list1);

        HashSet<String> set = new LinkedHashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        List<String> list2 = CollUtil.list(false, set);
        List<String> list3 = CollUtil.list(true, set);
        Assert.assertEquals("[a, b, c]", list2.toString());
        Assert.assertEquals("[a, b, c]", list3.toString());

        List<String> list4 = CollUtil.newArrayList(set);
        Assert.assertEquals("[a, b, c]", list4.toString());

        Assert.assertTrue(!CollUtil.isEmpty(set));
        Assert.assertTrue(CollUtil.isNotEmpty(set));
        Assert.assertTrue(!CollUtil.hasNull(set));
    }

    @Test
    public void listTestvector() {
        List<String> list1 = CollUtil.list(false, (Enumeration<String>) null);
        Assert.assertNotNull(list1);

        Vector v = new Vector();
        v.addElement("a");
        v.addElement("b");
        v.addElement("c");
        Enumeration enumeration = v.elements();

        List<String> list2 = CollUtil.list(false, enumeration);
        List<String> list3 = CollUtil.list(true, enumeration);
        Assert.assertNotNull(list2);
        Assert.assertNotNull(list3);

        List<String> list4 = CollUtil.newArrayList(enumeration);
        Assert.assertNotNull(list4);

        Assert.assertTrue(CollUtil.isEmpty(enumeration));
        Assert.assertTrue(!CollUtil.isNotEmpty(enumeration));
    }

    @Test
    public void getTest() {
        HashSet<String> set = CollUtil.newHashSet(true, CollUtil.newArrayList("A", "B", "C", "D"));
        String str = CollUtil.get(set, 2);
        Assert.assertEquals("C", str);

        str = CollUtil.get(set, -1);
        Assert.assertEquals("D", str);
    }

    @Test
    public void addAllIfNotContainsTest() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("2");
        list2.add("3");
        CollUtil.addAllIfNotContains(list1, list2);

        Assert.assertEquals(3, list1.size());
        Assert.assertEquals("1", list1.get(0));
        Assert.assertEquals("2", list1.get(1));
        Assert.assertEquals("3", list1.get(2));
    }

    @Test
    public void subInput1PositiveNegativePositiveOutput1() {
        // Arrange
        final List<Integer> list = new ArrayList<>();
        list.add(null);
        final int start = 3;
        final int end = -1;
        final int step = 2;
        // Act
        final List<Integer> retval = CollUtil.sub(list, start, end, step);
        // Assert result
        final List<Integer> arrayList = new ArrayList<>();
        arrayList.add(null);
        Assert.assertEquals(arrayList, retval);
    }

    @Test
    public void subInput1ZeroPositivePositiveOutput1() {
        // Arrange
        final List<Integer> list = new ArrayList<>();
        list.add(null);
        final int start = 0;
        final int end = 1;
        final int step = 2;
        // Act
        final List<Integer> retval = CollUtil.sub(list, start, end, step);

        // Assert result
        final List<Integer> arrayList = new ArrayList<>();
        arrayList.add(null);
        Assert.assertEquals(arrayList, retval);
    }

    @Test
    public void subInput1PositiveZeroOutput0() {
        // Arrange
        final List<Integer> list = new ArrayList<>();
        list.add(null);
        final int start = 1;
        final int end = 0;
        // Act
        final List<Integer> retval = CollUtil.sub(list, start, end);

        // Assert result
        final List<Integer> arrayList = new ArrayList<>();
        Assert.assertEquals(arrayList, retval);
    }

    @Test
    public void subInput0ZeroZeroZeroOutputNull() {
        // Arrange
        final List<Integer> list = new ArrayList<>();
        final int start = 0;
        final int end = 0;
        final int step = 0;
        // Act
        final List<Integer> retval = CollUtil.sub(list, start, end, step);
        // Assert result
        Assert.assertTrue(retval.isEmpty());
    }

    @Test
    public void subInput1PositiveNegativeZeroOutput0() {
        // Arrange
        final List<Integer> list = new ArrayList<>();
        list.add(null);
        final int start = 1;
        final int end = -2_147_483_648;
        final int step = 0;
        // Act
        final List<Integer> retval = CollUtil.sub(list, start, end, step);
        // Assert result
        final List<Integer> arrayList = new ArrayList<>();
        Assert.assertEquals(arrayList, retval);
    }

    @Test
    public void subInput1PositivePositivePositiveOutput0() {
        // Arrange
        final List<Integer> list = new ArrayList<>();
        list.add(null);
        final int start = 2_147_483_647;
        final int end = 2_147_483_647;
        final int step = 1_073_741_824;
        // Act
        final List<Integer> retval = CollUtil.sub(list, start, end, step);
        // Assert result
        final List<Integer> arrayList = new ArrayList<>();
        Assert.assertEquals(arrayList, retval);
    }

    @Test
    public void subInput0ZeroPositiveNegativeOutputNull() {
        // Arrange
        final List<Integer> list = new ArrayList<>();
        final int start = 0;
        final int end = 1;
        final int step = -2_147_483_646;
        // Act
        final List<Integer> retval = CollUtil.sub(list, start, end, step);
        // Assert result
        Assert.assertTrue(retval.isEmpty());
    }

    @Test
    public void subInput1PositivePositivePositiveOutput02() {
        // Arrange
        final List<Integer> list = new ArrayList<>();
        list.add(null);
        final int start = 2_147_483_643;
        final int end = 2_147_483_642;
        final int step = 1_073_741_824;
        // Act
        final List<Integer> retval = CollUtil.sub(list, start, end, step);
        // Assert result
        final List<Integer> arrayList = new ArrayList<>();
        Assert.assertEquals(arrayList, retval);
    }

    @Test
    public void subInput1ZeroZeroPositiveOutput0() {
        // Arrange
        final List<Integer> list = new ArrayList<>();
        list.add(0);
        final int start = 0;
        final int end = 0;
        final int step = 2;
        // Act
        final List<Integer> retval = CollUtil.sub(list, start, end, step);
        // Assert result
        final List<Integer> arrayList = new ArrayList<>();
        Assert.assertEquals(arrayList, retval);
    }

    @Test
    public void subInput1NegativeZeroPositiveOutput0() {
        // Arrange
        final List<Integer> list = new ArrayList<>();
        list.add(0);
        final int start = -1;
        final int end = 0;
        final int step = 2;
        // Act
        final List<Integer> retval = CollUtil.sub(list, start, end, step);
        // Assert result
        final List<Integer> arrayList = new ArrayList<>();
        Assert.assertEquals(arrayList, retval);
    }

    @Test
    public void subInput0ZeroZeroOutputNull() {
        // Arrange
        final List<Integer> list = new ArrayList<>();
        final int start = 0;
        final int end = 0;
        // Act
        final List<Integer> retval = CollUtil.sub(list, start, end);
        // Assert result
        Assert.assertTrue(retval.isEmpty());
    }

    @Test
    public void containsAnyTest() {
        List<Integer> list1 = CollUtil.newArrayList(1, 2, 3, 4, 5);
        List<Integer> list2 = CollUtil.newArrayList(5, 3, 1, 9, 11);

        Assert.assertTrue(CollUtil.containsAny(list1, list2));
    }

    @Test
    public void containsAllTest() {
        List<Integer> list1 = CollUtil.newArrayList(1, 2, 3, 4, 5);
        List<Integer> list2 = CollUtil.newArrayList(5, 3, 1);

        Assert.assertTrue(CollUtil.containsAll(list1, list2));
    }

    @Test
    public void zipTest() {
        Collection<String> keys = CollUtil.newArrayList("a", "b", "c", "d");
        Collection<Integer> values = CollUtil.newArrayList(1, 2, 3, 4);

        Map<String, Integer> map = CollUtil.zip(keys, values);

        Assert.assertEquals(4, map.size());

        Assert.assertEquals(1, map.get("a").intValue());
        Assert.assertEquals(2, map.get("b").intValue());
        Assert.assertEquals(3, map.get("c").intValue());
        Assert.assertEquals(4, map.get("d").intValue());
    }
}
