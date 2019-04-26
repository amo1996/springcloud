package com.springcloud.configgitserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//启动配置中心
@EnableConfigServer
public class ConfigGitServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigGitServerApplication.class, args);
	}

}
