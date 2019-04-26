package com.springcloud.configgitserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//启动配置中心
@EnableConfigServer
public class ConfigGitServerApplication {
	/**
	 * 记录log
	 * 启动的时候报错
	 * org.yaml.snakeyaml.error.YAMLException:
	 * java.nio.charset.MalformedInputException : Input length = 1 /2
	 * 可能的原因是我之前yml文件编码被不小心改成了GBK 然后我又改回来了 就启动不了
	 * 解决：尝试了编码改回来也不行 就直接删除了原文件 重新将内容粘贴到新的yml文件中。
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigGitServerApplication.class, args);
	}

}
