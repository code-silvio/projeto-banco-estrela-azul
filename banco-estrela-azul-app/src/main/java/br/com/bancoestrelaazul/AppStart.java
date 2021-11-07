package br.com.bancoestrelaazul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AppStart {

	public static void main(String[] args) {
		SpringApplication.run(AppStart.class, args);
		initData();
	}

	private static void initData() {
	}

}
