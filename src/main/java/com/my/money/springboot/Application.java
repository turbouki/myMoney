package com.my.money.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링 부트의 자동 설정, 스프링 Bean읽기와 생성을 모두 자동으로 설정됩니다. 이것이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야만 합니다.
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS를 실행합니다.
    }
}
