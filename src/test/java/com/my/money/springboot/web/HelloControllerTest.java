package com.my.money.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // @RunWith 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킵니다.   ex)SpringRunner(스프링실행자) -  스프링부트 테스트와 JUnit 사이에 연결자 역할을 합니다.
@WebMvcTest( controllers = HelloController.class) // @WebMvcTest Web에 집중할 수 있는 어노테이션. 선언할 경우 @Controller, @ControllerAdvice등을 사용할 수 있습니다.
public class HelloControllerTest {
    @Autowired // 스프링이 관리하는 빈(Bean)을 주입받습니다.
    private MockMvc mvc; //뒙 API를 테스트할 때 사용합니다. 스프링  MVC 테스트의 시작점입니다. 이클래스를 통해  HTTP GET, POST 등에 대한 API 테스트를 할 수 있습니다.

    @Test
    public void hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))  // MockMvc를 통해 /hello 주소로 GET 요청을 합니다. 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있습니다.
                .andExpect(status().isOk()) // mvc.perfrom의 결과를 검증합니다. HTTP Header의 Status를 검증합니다. 우리가 흔히 알고 있는 200, 404, 500 등의 상태를 검증합니다. 여기선 OK 즉 200인지 아닌지를 검증합니다.
                .andExpect(content().string(hello)); // mvc.perfrom의 결과를 검증합니다. 응답 본문의 내용을 검증합니다. Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증합니다.
    }

    @Test
    public void helloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name) // param API
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}

//[인텔리제이오류]Execution failed for task ':test'.
//테스트구동시 나타나는 오류
//Execution failed for task ':test'.
//No tests found for given includes : ~~~~
// settings > Build, Execution, Deployment > Gradle > Run tests using: IntelliJ IDEA 로 변경


//    Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
//    java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
//  패키지 구조가 다를경우 발생하는 오류
// 패키지 구조를 맞추거나  value 옵션으로 바꾸기  @WebMvcTest( value = HelloController.class)
