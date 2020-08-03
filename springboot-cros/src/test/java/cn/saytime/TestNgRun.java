package cn.saytime;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class TestNgRun {
    public TestNgRun() {
    }

    public static void main(String[] args) {
        XmlSuite suite = new XmlSuite();
        suite.setName("Suite");
        XmlTest test = new XmlTest(suite);
        test.setName("test1");
        List<XmlClass> classes = new ArrayList();
        classes.add(new XmlClass("com.uih.uplus.common.commontest.testcase.ResultTestCase"));
        classes.add(new XmlClass("com.uih.uplus.common.commontest.testcase.ActuatorTest"));
        classes.add(new XmlClass("com.uih.uplus.common.commontest.testcase.CoreExceptionTest"));
        classes.add(new XmlClass("com.uih.uplus.common.commontest.testcase.GlobalExceptionTest"));
        classes.add(new XmlClass("com.uih.uplus.common.commontest.testcase.JsonResultTestCase"));
        classes.add(new XmlClass("com.uih.uplus.common.commontest.testcase.SpringContextUtilTest"));
        classes.add(new XmlClass("com.uih.uplus.common.commontest.testcase.UnifiedMessageSourceTest"));
        test.setXmlClasses(classes);
        List<XmlSuite> suites = new ArrayList();
        suites.add(suite);
        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();
    }
}
