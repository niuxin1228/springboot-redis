package com.example.demo;

import com.uih.uplus.common.utils.random.RandomUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class RandomUtilTest {
    @Test
    public void RandomUtilBooleanSuccess() {
        boolean b = RandomUtil.randomBoolean();
        Assert.assertNotNull(b);
    }
    @Test
    public void RandomUtilIntallindexSuccess() {
        int i = RandomUtil.randomInt(1, 2);
        Assert.assertEquals(i,1);
    }
    @Test
    public void RandomUtilIntsameError() {
        int i=999;
        try{
            i = RandomUtil.randomInt(1, 1);
        }catch (Exception e){
            Assert.assertEquals(i,999);
        }
        Assert.assertEquals(i,999);
    }
    @Test
    public void RandomUtilIntSuccess() {
        int i = RandomUtil.randomInt();
        Assert.assertNotNull(i);
    }
    @Test
    public void RandomUtilIntlimitSuccess() {
        int i = RandomUtil.randomInt(1);
        Assert.assertEquals(i,0);
    }
    @Test
    public void RandomUtilIntlimit0Error() {
        int i=999;
        try{
            i = RandomUtil.randomInt(0);
        }catch (Exception e){
            Assert.assertEquals(i,999);
        }
        Assert.assertEquals(i,999);
    }
    @Test
    public void RandomUtilIntlimitrandomSuccess() {
        int i = RandomUtil.randomInt(848);
        Assert.assertNotNull(i);
    }
    @Test
    public void RandomUtilLongSuccess() {
        long i = RandomUtil.randomLong();
        Assert.assertNotNull(i);
    }
    @Test
    public void RandomUtilLonglimitSuccess() {
        long i = RandomUtil.randomLong(1);
        Assert.assertEquals(i,0);
    }
    @Test
    public void RandomUtilLonglimitrandomSuccess() {
        long i = RandomUtil.randomLong(2);
        Assert.assertNotNull(i);
    }
    @Test
    public void RandomUtilLongallindexSuccess() {
        long i = RandomUtil.randomLong(0,1);
        Assert.assertEquals(i,0);
    }
    @Test
    public void RandomUtilLongallindexError() {
        long i=999;
        try{
            i = RandomUtil.randomLong(2,2);
        }catch (Exception e){
            Assert.assertEquals(i,999);
        }
        Assert.assertEquals(i,999);
    }
    @Test
    public void RandomUtilLongallinderandomSuccess() {
        long i = RandomUtil.randomLong(0,555);
        Assert.assertNotEquals(i,555);
    }
    @Test
    public void RandomUtilBigDecimalSuccess() {
        BigDecimal i = RandomUtil.randomBigDecimal();
        Assert.assertNotNull(i);
    }
    @Test
    public void RandomUtilDoubleSuccess() {
        double i = RandomUtil.randomDouble();
        Assert.assertNotNull(i);
    }
    @Test
    public void RandomUtilDoubleallindexSuccess() {
        double i = RandomUtil.randomDouble(1.0,2.0,1, RoundingMode.DOWN);
        Assert.assertNotNull(i);
    }
    @Test
    public void RandomUtilDoubleindexSuccess() {
        double i = RandomUtil.randomDouble(1, RoundingMode.UP);
        Assert.assertNotNull(i);
    }
    @Test
    public void RandomUtilDoublelimitSuccess() {
        double i = RandomUtil.randomDouble(9.66);
        Assert.assertNotNull(i);
    }
    @Test
    public void RandomUtilBytesSuccess() {
        byte[] i = RandomUtil.randomBytes(5);
        Assert.assertNotNull(i);
    }
    @Test
    public void RandomUtilBytesLength0Success() {
        byte[] i = RandomUtil.randomBytes(0);
        Assert.assertNotNull(i);
    }
    @Test
    public void RandomUtilBytesLengthnegativeError() {
        byte[] s =null;
        try {
            s = RandomUtil.randomBytes(-3);
        }catch (Exception e){
            Assert.assertEquals(s,null);
        }
        Assert.assertEquals(s,null);
    }
    @Test
    public void RandomUtilStringSuccess() {
        String s = RandomUtil.randomString(4);
        Assert.assertNotNull(s);
    }
    @Test
    public void RandomUtilStringLength0Success() {
        String s = RandomUtil.randomString(0);
        Assert.assertNotNull(s);
    }
    @Test
    public void RandomUtilStringLengthnegativeError() {
        String s="0";
        try {
            s = RandomUtil.randomString(-3);
        }catch (Exception e){
            Assert.assertEquals(s,"0");
        }
        Assert.assertEquals(s,"0");
    }
    @Test
    public void RandomUtilStringbaseSuccess() {
        String s = RandomUtil.randomString("sdad",4);
        Assert.assertNotNull(s);
    }
    @Test
    public void RandomUtilStringUppersuccess() {
        String s = RandomUtil.randomStringUpper(3);
        Assert.assertNotNull(s);
    }
    @Test
    public void RandomUtilStringUpperLength0success() {
        String s = RandomUtil.randomStringUpper(0);
        Assert.assertNotNull(s);
    }
    @Test
    public void RandomUtilStringUpperLengthnegativeError() {
        String s="0";
        try {
            s = RandomUtil.randomStringUpper(-2);
        }catch (Exception e){
            Assert.assertEquals(s,"0");
        }
        Assert.assertEquals(s,"0");
    }
    @Test
    public void RandomUtilStringWithoutStrSuccess() {
        String s = RandomUtil.randomStringWithoutStr(3,"sas");
        Assert.assertNotNull(s);
    }
    @Test
    public void RandomUtilStringWithoutStrLength0Success() {
        String s = RandomUtil.randomStringWithoutStr(0,"sas");
        Assert.assertNotNull(s);
    }
    @Test
    public void RandomUtilStringWithoutStrLengthnegativeSuccess() {
        String s="0";
        try {
            s = RandomUtil.randomStringWithoutStr(-2,"ds");
        }catch (Exception e){
            Assert.assertEquals(s,"0");
        }
        Assert.assertEquals(s,"0");
    }
    @Test
    public void RandomUtilNumbersuccess() {
        int i = RandomUtil.randomNumber();
        Assert.assertNotNull(i);
    }
    @Test
    public void RandomUtilNumberssuccess() {
        String s = RandomUtil.randomNumbers(3);
        Assert.assertNotNull(s);
    }
    @Test
    public void RandomUtilNumbersLength0success() {
        String s = RandomUtil.randomNumbers(0);
        Assert.assertNotNull(s);
    }
    @Test
    public void RandomUtilNumbersLengthnegativeError() {
        String s="0";
        try {
            s = RandomUtil.randomNumbers(-2);
        }catch (Exception e){
            Assert.assertEquals(s,"0");
        }
        Assert.assertEquals(s,"0");
    }
    @Test
    public void RandomUtilCharsuccess() {
        char c = RandomUtil.randomChar();
        Assert.assertNotNull(c);
    }
    @Test
    public void RandomUtilCharbasesuccess() {
        char c = RandomUtil.randomChar("AA");
        Assert.assertNotNull(c);
    }
    @Test
    public void RandomUtilColorsuccess() {
        Color color = RandomUtil.randomColor();
        System.out.println(color);
        Assert.assertNotNull(color);
    }
}
