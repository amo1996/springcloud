package com.springcloud.simpleeurekazuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SimpleEurekaZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleEurekaZuulApplication.class, args);
	}

}
