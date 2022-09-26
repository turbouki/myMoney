package com.my.money.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombokTest() {
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);


        //then
        assertThat(dto.getName()).isEqualTo(name); //assert 검증하고 싶은 대상을 메소드 인자로 받습니다, 메소드 체이닝이 지원되며 isEqualTo와 같이 메소들
        assertThat(dto.getAmount()).isEqualTo(amount); //assertj의 동등 비교
        // asserJ vs assertThat
//        public enum AccessLevel {
//            PUBLIC, MODULE, PROTECTED, PACKAGE, PRIVATE,
//            /** Represents not generating anything or the complete lack of a method. */
//            NONE;
//        }


    }
}
