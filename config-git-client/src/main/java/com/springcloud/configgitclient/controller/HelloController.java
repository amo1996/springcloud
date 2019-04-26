package com.springcloud.configgitclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * liZhi
 * 2019年4月26日12:38:59
 *
 */
@RestController
// 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
//但是这种配置方式需要客户端手动访问refresh端点  默认关闭该端点 需要在配置文件开启
/**
 * 在git上面的配置修改了之后，需要用post 方式 访问下面这个路径 返回对应的配置属性名就可以了
 * 在去刷新，就发现获得的配置值已经修改了 我用的post man
 * http://localhost:8092/actuator/refresh
 */
/**
 * 如果不想每次变更都要手动去访问refresh端点 可以利用webhook选项。
 * webhook
 WebHook是当某个事件发生时，通过发送http post请求的方式来通知信息接收方
 。Webhook来监测你在Github.com上的各种事件，最常见的莫过于push事件。
 如果你设置了一个监测push事件的Webhook，
 那么每当你的这个项目有了任何提交，这个Webhook都会被触发，
 这时Github就会发送一个HTTP POST请求到你配置好的地址。
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
