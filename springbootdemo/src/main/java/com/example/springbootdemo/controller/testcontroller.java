package com.example.springbootdemo.controller;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//public class testcontroller {
////用于将HTTP GET请求映射到特定处理程序方法的注释。具体来说，@GetMapping是一个作为快捷方式的组合注释
////@RequestMapping(method = RequestMethod.GET)。
//    @GetMapping("demo1")
//    public String demo1() {
//        return "Hello nxx!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
//    }
//    @RequestMapping("demo2")
//    @ResponseBody//如果是使用前后端分离直接加上@responsebody注解就可以，不需要去找jackson那几个包，springboot已经帮你搞好了，满足你的正常需求
//    public Map demo2()
//    {
//        Map map=new HashMap();
//        map.put(1,"fads");
//        map.put("55","55");
//        return map;
//    }
//}

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class testcontroller {
//    @GetMapping("hello")
//    public String hello()
//    {
//        return "hello , nxx";
//    }
//}