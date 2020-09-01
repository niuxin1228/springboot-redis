package com.example.demo;

import com.uih.uplus.common.utils.basic.img.Img;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ImgUtilTest {
    private File directory = new File("");
    private String rootPath=directory.getAbsolutePath();
    @Test
    public void ImgUtilFromSuccess() {
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"img1.jpg";
        File file=new File(filePath);
        Img a = Img.from(file);
        Assert.assertNotNull(a);
    }
    @Test
    public void ImgUtilFromNoimgSuccess() {
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"img999.jpg";
        File file=new File(filePath);
        Img a=null;
        try {
            a = Img.from(file);
        }catch (Exception e){
            Assert.assertNull(a);
        }
        Assert.assertNull(a);
    }
    @Test
    public void ImgUtilFromNopathSuccess() {
        String filePath=rootPath+File.separator+"Files"+File.separator+"img1.jpg";
        File file=new File(filePath);
        Img a=null;
        try {
            a = Img.from(file);
        }catch (Exception e){
            Assert.assertNull(a);
        }
        Assert.assertNull(a);
    }
    @Test
    public void ImgUtilsetTargetImageTypeSuccess() {
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"img1.jpg";
        File file=new File(filePath);
        Img a = Img.from(file);
        Img type = a.setTargetImageType("png");
        String s = type.toString();
        Assert.assertNotNull(s);
    }
    @Test
    public void ImgUtilsetPositionBaseCentreSuccess() {
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"img1.jpg";
        File file=new File(filePath);
        Img a = Img.from(file);
        Img type = a.setPositionBaseCentre(true);
        String s = type.toString();
        Assert.assertNotNull(s);
    }
    @Test
    public void ImgUtilsetQualitySuccess() {
        String filePath=rootPath+File.separator+"TestFiles"+File.separator+"img1.jpg";
        File file=new File(filePath);
        Img a = Img.from(file);
        Img type = a.setQuality(0);
        String s = type.toString();
        a.gray();
        a.getImg();
        Assert.assertNotNull(s);
    }
}
