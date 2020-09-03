package com.example.demo;

import com.uih.uplus.common.utils.crypto.SecureUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.PrivateKey;

public class SecureUtilTest {
    @Test
    public void generatePrivateKeyECSuccess() {
        byte[] key= null;
        PrivateKey sas = SecureUtil.generatePrivateKey("EC", key);
        Assert.assertEquals(sas,null);
    }
    @Test
    public void generatePrivateKeyRSASuccess() {
        byte[] key= null;
        PrivateKey sas = SecureUtil.generatePrivateKey("RSA", key);
        Assert.assertEquals(sas,null);
    }
}
