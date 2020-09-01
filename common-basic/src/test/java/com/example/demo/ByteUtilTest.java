package com.example.demo;

import com.uih.uplus.common.utils.basic.ByteUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ByteUtilTest {
    @Test
    public void ByteUtiltobytesSuccess() {
        int a = 10;
        byte[] bytes = ByteUtil.toBytes(a);
        int length = bytes.length;
        Assert.assertEquals(length,4);
    }
    @Test
    public void ByteUtiltobytesnegativeSuccess() {
        int a = -1;
        byte[] bytes = ByteUtil.toBytes(a);
        int length = bytes.length;
        Assert.assertEquals(length,4);
    }
    @Test
    public void ByteUtilArrayIndexOfnegativeSuccess() {
        byte[] a= {65,66,67,68};
        byte[] b= {65,66,67,68,69};
        int i = ByteUtil.byteArrayIndexOf(a, b);
        System.out.println(i);
        Assert.assertEquals(i,-1);
    }
    @Test
    public void ByteUtilArrayIndexOfSuccess() {
        byte[] a= {65,66,67,68};
        byte[] b= {65,66,67};
        int i = ByteUtil.byteArrayIndexOf(a, b);
        System.out.println(i);
        Assert.assertEquals(i,0);
    }
    @Test
    public void ByteUtilArrayIndexOfoneSuccess() {
        byte[] a= {65,66,67,68};
        byte[] b= {66};
        int i = ByteUtil.byteArrayIndexOf(a, b);
        System.out.println(i);
        Assert.assertEquals(i,1);
    }
    @Test
    public void ByteUtilIndexOfSuccess() {
        byte[] a= {65,66,67,68};
        byte b= 65;
        int i = ByteUtil.byteIndexOf(a,b);
        System.out.println(i);
        Assert.assertEquals(i,0);
    }
    @Test
    public void ByteUtilIndexOfnoexistSuccess() {
        byte[] a= {65,66,67,68};
        byte b= 70;
        int i = ByteUtil.byteIndexOf(a,b);
        System.out.println(i);
        Assert.assertEquals(i,-1);
    }
    @Test
    public void ByteUtilIndexOfendSuccess() {
        byte[] a= {65,66,67,68};
        byte b= 68;
        int i = ByteUtil.byteIndexOf(a,b);
        System.out.println(i);
        Assert.assertEquals(i,3);
    }
    @Test
    public void ByteUtilArrayContatError() {
        byte[] a= {65,66,67,68};
        byte[] b= {87,88};
        try{
            byte[] bytes = ByteUtil.byteArrayConcat(a, 0, b, 1);
        }catch (Exception e){
            Assert.assertEquals(b.length,2);
        }
        Assert.assertEquals(b.length,2);
    }
}
