package com.springcloud.ordereurekaclient.controller;


import com.springcloud.ordereurekaclient.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger LOGGER= LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        //restTemplate 远程调用user的方法
    // return this.restTemplate.getForObject("http://localhost:8081/"+id,User.class);
    //整合了ribbon（负载均衡）的写法  整合了ribbon之后 会自动将虚拟主机名映射成微服务的网络地址
        return this.restTemplate.getForObject("http://user-provider/"+id,User.class);
    }

   @GetMapping("/log-user-instance")
    public void logUserInstance(){
        ServiceInstance choose = this.loadBalancerClient.choose("user-provider");
    OrderController.LOGGER.info("{}:{}:{}",choose.getServiceId(),choose.getHost(),choose.getPort());
    }
}
