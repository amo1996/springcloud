package com.springcloud.ordereurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
public class OrderEurekaClientApplication {

	//方法注解 实例化一个Bean并使用该方法的名称命名。 <==>  RestTemplate restTemplate = new RestTemplate();
	@Bean
	//实现负载均衡的能力
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderEurekaClientApplication.class, args);
	}

}
