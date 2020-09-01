package com.example.demo;

import com.uih.uplus.common.utils.basic.StrUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class StrUtilTest {
    @Test
    public void isBlankTest() {
        String blank = "	  　";
        Assert.assertTrue(StrUtil.isBlank(blank));
    }

    @Test
    public void isBlankTest2() {
        String blank = "\u202a";
        Assert.assertTrue(StrUtil.isBlank(blank));
    }

    @Test
    public void trimTest() {
        String blank = "	 哈哈 　";
        String trim = StrUtil.trim(blank);
        Assert.assertEquals("哈哈", trim);
    }

    @Test
    public void splitTest() {
        String str = "a,b ,c,d,,e";
        List<String> split = StrUtil.split(str, ',', -1, true, true);
        // 测试空是否被去掉
        Assert.assertEquals(5, split.size());
        // 测试去掉两边空白符是否生效
        Assert.assertEquals("b", split.get(1));
    }

    @Test
    public void formatTest() {
        String template = "你好，我是{}，我的电话是：{}";
        String result = StrUtil.format(template, "张三", "13888881111");
        Assert.assertEquals("你好，我是张三，我的电话是：13888881111", result);

        String result2 = StrUtil.format(template, "张三", null);
        Assert.assertEquals("你好，我是张三，我的电话是：null", result2);
    }

    @Test
    public void indexOfIgnoreCaseTest() {
        Assert.assertEquals(-1, StrUtil.indexOfIgnoreCase(null, "balabala", 0));
        Assert.assertEquals(-1, StrUtil.indexOfIgnoreCase("balabala", null, 0));
        Assert.assertEquals(0, StrUtil.indexOfIgnoreCase("", "", 0));
        Assert.assertEquals(0, StrUtil.indexOfIgnoreCase("aabaabaa", "A", 0));
        Assert.assertEquals(2, StrUtil.indexOfIgnoreCase("aabaabaa", "B", 0));
        Assert.assertEquals(1, StrUtil.indexOfIgnoreCase("aabaabaa", "AB", 0));
        Assert.assertEquals(5, StrUtil.indexOfIgnoreCase("aabaabaa", "B", 3));
        Assert.assertEquals(-1, StrUtil.indexOfIgnoreCase("aabaabaa", "B", 9));
        Assert.assertEquals(2, StrUtil.indexOfIgnoreCase("aabaabaa", "B", -1));
        Assert.assertEquals(2, StrUtil.indexOfIgnoreCase("aabaabaa", "", 2));
        Assert.assertEquals(-1, StrUtil.indexOfIgnoreCase("abc", "", 9));
    }

    @Test
    public void lastIndexOfTest() {
        String a = "aabbccddcc";
        int lastIndexOf = StrUtil.lastIndexOf(a, "c", 0, false);
        Assert.assertEquals(-1, lastIndexOf);
    }

    @Test
    public void lastIndexOfIgnoreCaseTest() {
        Assert.assertEquals(-1, StrUtil.lastIndexOfIgnoreCase(null, "balabala", 0));
        Assert.assertEquals(-1, StrUtil.lastIndexOfIgnoreCase("balabala", null));
        Assert.assertEquals(0, StrUtil.lastIndexOfIgnoreCase("", ""));
        Assert.assertEquals(7, StrUtil.lastIndexOfIgnoreCase("aabaabaa", "A"));
        Assert.assertEquals(5, StrUtil.lastIndexOfIgnoreCase("aabaabaa", "B"));
        Assert.assertEquals(4, StrUtil.lastIndexOfIgnoreCase("aabaabaa", "AB"));
        Assert.assertEquals(2, StrUtil.lastIndexOfIgnoreCase("aabaabaa", "B", 3));
        Assert.assertEquals(5, StrUtil.lastIndexOfIgnoreCase("aabaabaa", "B", 9));
        Assert.assertEquals(-1, StrUtil.lastIndexOfIgnoreCase("aabaabaa", "B", -1));
        Assert.assertEquals(2, StrUtil.lastIndexOfIgnoreCase("aabaabaa", "", 2));
        Assert.assertEquals(3, StrUtil.lastIndexOfIgnoreCase("abc", "", 9));
    }

    @Test
    public void replaceTest() {
        String string = StrUtil.replace("aabbccdd", 2, 6, '*');
        Assert.assertEquals("aa****dd", string);
        string = StrUtil.replace("aabbccdd", 2, 12, '*');
        Assert.assertEquals("aa******", string);
    }

    @Test
    public void replaceTest2() {
        String result = StrUtil.replace("123", "2", "3");
        Assert.assertEquals("133", result);
    }

    @Test
    public void replaceTest3() {
        String result = StrUtil.replace(",abcdef,", ",", "|");
        Assert.assertEquals("|abcdef|", result);
    }

    @Test
    public void subTest() {
        String a = "abcderghigh";
        String pre = StrUtil.sub(a, -5, a.length());
        Assert.assertEquals("ghigh", pre);
    }

    @Test
    public void subBeforeTest() {
        String a = "abcderghigh";
        String pre = StrUtil.subBefore(a, "d", false);
        Assert.assertEquals("abc", pre);
        pre = StrUtil.subBefore(a, 'd', false);
        Assert.assertEquals("abc", pre);
        pre = StrUtil.subBefore(a, 'a', false);
        Assert.assertEquals("", pre);

        //找不到返回原串
        pre = StrUtil.subBefore(a, 'k', false);
        Assert.assertEquals(a, pre);
        pre = StrUtil.subBefore(a, 'k', true);
        Assert.assertEquals(a, pre);
    }

    @Test
    public void subAfterTest() {
        String a = "abcderghigh";
        String pre = StrUtil.subAfter(a, "d", false);
        Assert.assertEquals("erghigh", pre);
        pre = StrUtil.subAfter(a, 'd', false);
        Assert.assertEquals("erghigh", pre);
        pre = StrUtil.subAfter(a, 'h', true);
        Assert.assertEquals("", pre);

        //找不到字符返回空串
        pre = StrUtil.subAfter(a, 'k', false);
        Assert.assertEquals("", pre);
        pre = StrUtil.subAfter(a, 'k', true);
        Assert.assertEquals("", pre);
    }

    @Test
    public void subSufByLengthTest() {
        Assert.assertEquals("cde", StrUtil.subSufByLength("abcde", 3));
        Assert.assertEquals("", StrUtil.subSufByLength("abcde", -1));
        Assert.assertEquals("", StrUtil.subSufByLength("abcde", 0));
        Assert.assertEquals("abcde", StrUtil.subSufByLength("abcde", 5));
        Assert.assertEquals("abcde", StrUtil.subSufByLength("abcde", 10));
    }

    @Test
    public void removePrefixIgnorecaseTest() {
        String a = "aaabbb";
        String prefix = "aaa";
        Assert.assertEquals("bbb", StrUtil.removePrefixIgnoreCase(a, prefix));

        prefix = "AAA";
        Assert.assertEquals("bbb", StrUtil.removePrefixIgnoreCase(a, prefix));

        prefix = "AAABBB";
        Assert.assertEquals("", StrUtil.removePrefixIgnoreCase(a, prefix));
    }

    @Test
    public void maxLengthTest() {
        String text = "我是一段正文，很长的正文，需要截取的正文";
        String str = StrUtil.maxLength(text, 5);
        Assert.assertEquals("我是一段正...", str);
        str = StrUtil.maxLength(text, 21);
        Assert.assertEquals(text, str);
        str = StrUtil.maxLength(text, 50);
        Assert.assertEquals(text, str);
    }

    @Test
    public void toUnderLineCaseTest() {
        String str = "Table_Test_Of_day";
        String result = StrUtil.toUnderlineCase(str);
        Assert.assertEquals("table_test_of_day", result);

        String str1 = "_Table_Test_Of_day_";
        String result1 = StrUtil.toUnderlineCase(str1);
        Assert.assertEquals("_table_test_of_day_", result1);

        String str2 = "_Table_Test_Of_DAY_";
        String result2 = StrUtil.toUnderlineCase(str2);
        Assert.assertEquals("_table_test_of_DAY_", result2);

        String str3 = "_TableTestOfDAYtoday";
        String result3 = StrUtil.toUnderlineCase(str3);
        Assert.assertEquals("_table_est_f_AY_today", result3);

        String str4 = "HelloWorld_test";
        String result4 = StrUtil.toUnderlineCase(str4);
        Assert.assertEquals("hello_orld_test", result4);
    }

    @Test
    public void containsAnyTest() {
        //字符
        boolean containsAny = StrUtil.containsAny("aaabbbccc", 'a', 'd');
        Assert.assertTrue(containsAny);
        containsAny = StrUtil.containsAny("aaabbbccc", 'e', 'd');
        Assert.assertFalse(containsAny);
        containsAny = StrUtil.containsAny("aaabbbccc", 'd', 'c');
        Assert.assertTrue(containsAny);

        //字符串
        containsAny = StrUtil.containsAny("aaabbbccc", "a", "d");
        Assert.assertTrue(containsAny);
        containsAny = StrUtil.containsAny("aaabbbccc", "e", "d");
        Assert.assertFalse(containsAny);
        containsAny = StrUtil.containsAny("aaabbbccc", "d", "c");
        Assert.assertTrue(containsAny);
    }

    @Test
    public void padAfterTest() {
        Assert.assertNull(StrUtil.padAfter(null, 10, ' '));
        Assert.assertEquals("100", StrUtil.padAfter("1", 3, '0'));
        Assert.assertEquals("23", StrUtil.padAfter("123", 2, '0'));

        Assert.assertNull(StrUtil.padAfter(null, 10, "ABC"));
        Assert.assertEquals("1AB", StrUtil.padAfter("1", 3, "ABC"));
        Assert.assertEquals("23", StrUtil.padAfter("123", 2, "ABC"));
    }
}
