package com.example.commontest.testcase;

import com.example.commontest.Application;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ActuatorTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    private static final String HEALTH_PATH = "/health";

    @Before
    public void before() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testHealth() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get(HEALTH_PATH).contentType(MediaType.APPLICATION_JSON_UTF8);
        //perform：执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
        //andExpect：添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确；
        //andDo：添加ResultHandler结果处理器，比如调试时打印结果到控制台；
        //andReturn：最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理；
        MvcResult mvcResult = mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andDo(
                MockMvcResultHandlers.print()).andReturn();
        //获取状态码
        int status = mvcResult.getResponse().getStatus();
        //获取返回 @ResponseBody json字符串 : 进行反序列化处理即可
        //注意: 500/400/302则是返回的HTML源码String类型
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertNotNull(content);//断言content不为空,如果为空就抛出异常
    }
}
