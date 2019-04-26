package com.springcloud.configgitclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
//但是这种配置方式需要客户端手动访问refresh端点  默认关闭该端点 需要在配置文件开启
/**
 * 在git上面的配置修改了之后，需要用post 方式 访问下面这个路径 返回对应的配置属性名就可以了
 * 在去刷新，就发现获得的配置值已经修改了 我用的post man
 * http://localhost:8092/actuator/refresh
 */
@RefreshScope
public class HelloController {
    @Value("${neo.hello}")
     private String hello;

    @RequestMapping("/hello")
    public String testGetForGit(){
        return this.hello;
    }
}
