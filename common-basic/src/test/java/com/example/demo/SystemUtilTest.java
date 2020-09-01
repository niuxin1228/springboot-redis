package com.example.demo;

import com.uih.uplus.common.utils.basic.SystemUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class SystemUtilTest {
    @Test
    public void SystemUtilgetPropertiesMapSuccess() {
        String s = SystemUtil.getPropertiesMap().toString();
        System.out.println("系统属性：" + s);
        Assert.assertNotNull(s);
    }
    @Test
    public void SystemUtilgetEnvMapSuccess() {
        String s = SystemUtil.getEnvMap().toString();
        System.out.println("系统环境属性：" + s);
        Assert.assertNotNull(s);
    }
    @Test
    public void SystemUtilgetSystemLoadAverageSuccess() {
        double s = SystemUtil.getSystemLoadAverage();
        System.out.println("当前系统负载：" + s);
        Assert.assertNotNull(s);
    }
    @Test
    public void SystemUtilgetProcessorCountSuccess() {
        int count = SystemUtil.getProcessorCount();
        System.out.println("当前系统CPU数：" + count);
        Assert.assertNotNull(count);
    }
    @Test
    public void SystemUtilcpuPerCoreLoadAvgSuccess() {
        double v = SystemUtil.cpuPerCoreLoadAvg();
        System.out.println("当前系统CPU平均负载：" + v);
        Assert.assertNotNull(v);
    }
    @Test
    public void SystemUtilgetProcessorInfoSuccess() {
        String s = SystemUtil.getProcessorInfo().toString();
        System.out.println("当前处理器信息：" + s);
        Assert.assertNotNull(s);
    }
    @Test
    public void SystemUtilgetJVMMemoryUsageSuccess() {
        double j = SystemUtil.getJVMMemoryUsage();
        System.out.println("当前JVM虚拟机的内存使用情况：" + j);
        Assert.assertNotNull(j);
    }
    @Test
    public void SystemUtilgetJVMMemoryInfoSuccess() {
        long j = SystemUtil.getJVMMemoryInfo(SystemUtil.MEMTYPE.NOHEAP_INIT);
        System.out.println("当前JVM虚拟机(栈,非栈)的内存使用情况：" + j);
        Assert.assertNotNull(j);
    }

}
