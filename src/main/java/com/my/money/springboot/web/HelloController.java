package com.my.money.springboot.web;

import com.my.money.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*
    json을 반환하는 컴트롤러를 만들어 줍니다
    예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있도록 해줍니다.
    @RestController = @Controller + @ResponseBody
*/
public class HelloController {

    // @GetMapping은 HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 줍니다.
    // 예전에는 @RequestMapping(method = RequestMethod.GET)으로 사용됩었습니다.
    // /hello 요청이 오면 문자열 hello를 반환하는 기능
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    // @RequestParam 외부에서 API로 넘긴 파라미터를 가져오는 어노테이견입니다.
    public HelloResponseDto helloDto(@RequestParam(name = "name") String name, @RequestParam(name = "amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

}
