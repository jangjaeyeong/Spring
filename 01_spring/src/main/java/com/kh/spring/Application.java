package com.kh.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * @SpringBootApplication 어노테이션
 * 	=>@Configuration			이 클래스 설정 클래스임
 * 	+ @EnableAutoConfiguration	spring boot의 자동 설정 기능 활성화
 * 	+ @ComponentScan			이 클래스가 위치한 패키기 (및 하위 패키지)에서 @Component, @Controller등을 
 * 								자동으로 찾아서 Bean 으로 등록
 * */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
