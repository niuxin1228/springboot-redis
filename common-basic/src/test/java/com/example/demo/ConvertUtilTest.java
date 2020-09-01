package com.example.demo;

import com.uih.uplus.common.utils.basic.ConvertUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class ConvertUtilTest {
    @Test
    public void ConvertUtiltoBooleanallSuccess() {
        Boolean a=true;
        Object d = new Object[]{"1", "2", 3, 4D};
        Boolean b= ConvertUtil.toBoolean(d);
        Assert.assertEquals(b,a);
    }
    @Test
    public void ConvertUtiltoBooleannullSuccess() {
        Boolean a=true;
        Object d = null;
        Boolean b= ConvertUtil.toBoolean(d);
        Assert.assertEquals(b,null);
    }
    @Test
    public void ConvertUtiltoBooleanyesSuccess() {
        Boolean a=true;
        Object d = "yes";
        Boolean b= ConvertUtil.toBoolean(d);
        Assert.assertEquals(b,a);
    }
    @Test
    public void ConvertUtiltoBooleanoneSuccess() {
        Boolean a=true;
        Object d = 1;
        Boolean b= ConvertUtil.toBoolean(d);
        Assert.assertEquals(b,a);
    }
    @Test
    public void ConvertUtiltoBooleanonSuccess() {
        Boolean a=true;
        Object d = "on";
        Boolean b= ConvertUtil.toBoolean(d);
        Assert.assertEquals(b,a);
    }
    @Test
    public void ConvertUtiltoBooleanySuccess() {
        Boolean a=true;
        Object d = "y";
        Boolean b= ConvertUtil.toBoolean(d);
        Assert.assertEquals(b,a);
    }
    @Test
    public void ConvertUtiltoBooleantrueSuccess() {
        Boolean a=true;
        Object d = true;
        Boolean b= ConvertUtil.toBoolean(d);
        Assert.assertEquals(b,a);
    }
    @Test
    public void ConvertUtiltoBooleanfalseSuccess() {
        Boolean a=false;
        Object d = false;
        Boolean b= ConvertUtil.toBoolean(d);
        Assert.assertEquals(b,a);
    }
    @Test
    public void ConvertUtiltoBooleannSuccess() {
        Boolean a=false;
        Object d = "n";
        Boolean b= ConvertUtil.toBoolean(d);
        Assert.assertEquals(b,a);
    }
    @Test
    public void ConvertUtiltoBooleannoSuccess() {
        Boolean a=false;
        Object d = "no";
        Boolean b= ConvertUtil.toBoolean(d);
        Assert.assertEquals(b,a);
    }
    @Test
    public void ConvertUtiltoBooleanoffSuccess() {
        Boolean a=false;
        Object d = "off";
        Boolean b= ConvertUtil.toBoolean(d);
        Assert.assertEquals(b,a);
    }
    @Test
    public void ConvertUtiltoBoolean0Success() {
        Boolean a=false;
        Object d = 0;
        Boolean b= ConvertUtil.toBoolean(d);
        Assert.assertEquals(b,a);
    }
    @Test
    public void ConvertUtiltoBooleanotherSuccess() {
        Object d = "dasdafsfsdfsd";
        Boolean b= ConvertUtil.toBoolean(d);
        Assert.assertEquals(b,null);
    }
    @Test
    public void ConvertUtiltoIntegerSuccess() {
        Object d = new Object[]{"1", "2", 3, 4D};
        Integer a=999;
        Integer integer = ConvertUtil.toInteger(d, a);
        String s=integer.toString();
        Assert.assertEquals(s,"1");
    }
    @Test
    public void ConvertUtiltoIntegernullSuccess() {
        Object d = null;
        Integer a=999;
        Integer integer = ConvertUtil.toInteger(d, a);
        String s=integer.toString();
        Assert.assertEquals(integer,a);
    }
    @Test
    public void ConvertUtiltoIntegeroneSuccess() {
        Object d = 1;
        Integer a=999;
        Integer integer = ConvertUtil.toInteger(d, a);
        String s=integer.toString();
        Assert.assertEquals(s,"1");
    }
    @Test
    public void ConvertUtiltoIntegernegativeSuccess() {
        Object d = -1;
        Integer a=999;
        Integer integer = ConvertUtil.toInteger(d, a);
        String s=integer.toString();
        Assert.assertEquals(s,"-1");
    }
    @Test
    public void ConvertUtiltoLongSuccess() {
        Object d = 1;
        Long l = ConvertUtil.toLong(d);
        String s=l.toString();
        Assert.assertEquals(s,"1");
    }
    @Test
    public void ConvertUtiltoLonglongSuccess() {
        Object d = 999.99999;
        Long l = ConvertUtil.toLong(d);
        String s=l.toString();
        Assert.assertEquals(s,"999");
    }
    @Test
    public void ConvertUtiltoLongnullError() {
        Object d = null;
        try{
            Long l = ConvertUtil.toLong(d);
        }catch (Exception e){
            Assert.assertEquals(d,null);
        }
        Assert.assertEquals(d,null);
    }
    @Test
    public void ConvertUtiltoLongnegativeSuccess() {
        Object d = -999.99999;
        Long l = ConvertUtil.toLong(d);
        String s=l.toString();
        Assert.assertEquals(s,"-999");
    }
    @Test
    public void ConvertUtiltoLongmoreSuccess() {
        Object d = new Object[]{"1", "2", 3, 4D};
        Long l = ConvertUtil.toLong(d);
        String s=l.toString();
        Assert.assertEquals(s,"1");
    }
    @Test
    public void ConvertUtiltoStringsSuccess() {
        Object d = 1;
        String[] s = ConvertUtil.toStrings(d);
        Assert.assertEquals(s.length,1);
    }
    @Test
    public void ConvertUtiltoStringsmoreSuccess() {
        Object d = new Object[]{"1", "2", 3, 4D};
        String[] s = ConvertUtil.toStrings(d);
        Assert.assertEquals(s.length,4);
    }
    @Test
    public void ConvertUtiltoStringsnegativeSuccess() {
        Object d = -999;
        String[] s = ConvertUtil.toStrings(d);
        Assert.assertEquals(s.length,1);
    }
    @Test
    public void ConvertUtiltoStringsnullError() {
        Object d = null;
        try{
            String[] s = ConvertUtil.toStrings(d);
        }catch (Exception e){
            Assert.assertEquals(d,null);
        }
        Assert.assertEquals(d,null);
    }
    @Test
    public void ConvertUtiltoBigDecimalSuccess() {
        Object d = 1.0;
        BigDecimal bigDecimal = ConvertUtil.toBigDecimal(d);
        String s = bigDecimal.toString();
        Assert.assertEquals(s,"1.0");
    }
    @Test
    public void ConvertUtiltoBigDecimalnullError() {
        Object d = 1.0;
        try{
            String[] s = ConvertUtil.toStrings(d);
        }catch (Exception e){
            Assert.assertEquals(d.toString(),"1.0");
        }
        Assert.assertEquals(d.toString(),"1.0");
    }
}
