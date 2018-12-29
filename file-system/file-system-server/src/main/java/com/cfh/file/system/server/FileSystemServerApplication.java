package com.cfh.file.system.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FileSystemServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileSystemServerApplication.class, args);
	}

}

