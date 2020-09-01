package com.example.demo;

import com.uih.uplus.common.utils.basic.CollUtil;
import com.uih.uplus.common.utils.basic.XmlUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import javax.xml.xpath.XPathConstants;
import java.util.LinkedHashMap;
import java.util.Map;

public class XmlUtilTest {
    @Test
    public void disableDefaultDocumentBuilderFactoryTest() {
        XmlUtil.disableDefaultDocumentBuilderFactory();
        Assert.assertTrue(true);
    }

    @Test
    public void parseTest() {
        String result = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"//
                + "<returnsms>"//
                + "<returnstatus>Success</returnstatus>"//
                + "<message>ok</message>"//
                + "<remainpoint>1490</remainpoint>"//
                + "<taskID>885</taskID>"//
                + "<successCounts>1</successCounts>"//
                + "</returnsms>";
        Document docResult = XmlUtil.parseXml(result);
        String elementText = XmlUtil.elementText(docResult.getDocumentElement(), "returnstatus");
        Assert.assertEquals("Success", elementText);
    }

    @Test
    public void writeTest() {
        String result = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"//
                + "<returnsms>"//
                + "<returnstatus>Success（成功）</returnstatus>"//
                + "<message>ok</message>"//
                + "<remainpoint>1490</remainpoint>"//
                + "<taskID>885</taskID>"//
                + "<successCounts>1</successCounts>"//
                + "</returnsms>";
        Document docResult = XmlUtil.parseXml(result);
        XmlUtil.toFile(docResult, "test.xml", "utf-8");
    }

    @Test
    public void xpathTest() {
        String result = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"//
                + "<returnsms>"//
                + "<returnstatus>Success（成功）</returnstatus>"//
                + "<message>ok</message>"//
                + "<remainpoint>1490</remainpoint>"//
                + "<taskID>885</taskID>"//
                + "<successCounts>1</successCounts>"//
                + "</returnsms>";
        Document docResult = XmlUtil.parseXml(result);
        Object value = XmlUtil.getByXPath("//returnsms/message", docResult, XPathConstants.STRING);
        Assert.assertEquals("ok", value);
    }

    @Test
    public void xmlToMapTest() {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"//
                + "<returnsms>"//
                + "<returnstatus>Success</returnstatus>"//
                + "<message>ok</message>"//
                + "<remainpoint>1490</remainpoint>"//
                + "<taskID>885</taskID>"//
                + "<successCounts>1</successCounts>"//
                + "</returnsms>";
        Map<String, Object> map = XmlUtil.xmlToMap(xml);

        Assert.assertEquals(5, map.size());
        Assert.assertEquals("Success", map.get("returnstatus"));
        Assert.assertEquals("ok", map.get("message"));
        Assert.assertEquals("1490", map.get("remainpoint"));
        Assert.assertEquals("885", map.get("taskID"));
        Assert.assertEquals("1", map.get("successCounts"));
    }

    @Test
    public void xmlToMapTest2() {
        String xml = "<root><name>张三</name><name>李四</name></root>";
        Map<String, Object> map = XmlUtil.xmlToMap(xml);

        Assert.assertEquals(1, map.size());
        Assert.assertEquals(CollUtil.newArrayList("张三", "李四"), map.get("name"));
    }

    @Test
    public void mapToXmlTest() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", "张三");
        map.put("age", 12);

        Document doc = XmlUtil.mapToXml(map, "user");
        // Console.log(XmlUtil.toStr(doc, false));
        Assert.assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"//
                        + "<user>"//
                        + "<name>张三</name>"//
                        + "<age>12</age>"//
                        + "</user>", //
                XmlUtil.toStr(doc, false));
    }

    @Test
    public void readTest() {
        Document doc = XmlUtil.readXML("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"//
                + "<user>"//
                + "<name>张三</name>"//
                + "<age>12</age>"//
                + "</user>");
        Assert.assertNotNull(doc);
    }
}
