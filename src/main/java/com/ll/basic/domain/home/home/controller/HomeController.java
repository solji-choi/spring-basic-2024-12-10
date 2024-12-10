package com.ll.basic.domain.home.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller 어노테이션을 붙여주면 스프링부트가 이 클래스를 컨트롤러로 인식하게 된다.
@Controller
public class HomeController {
    private int age = 22;

    @GetMapping("/") // @GetMapping("/") 어노테이션을 붙여주면 이 메소드는 "/" 경로로 들어왔을 때 실행된다.
    @ResponseBody // @ResponseBody 어노테이션을 붙여주면 리턴값이 뷰 파일명이 아니라 응답 바디에 들어가게 된다.
    public String showMain() {
        return """
                <h1>안녕하세요.</h1>
                <p><strong>메인페이지</strong>입니다.</p>
                """;
    }

    @GetMapping("/about")
    @ResponseBody
    public String showAbout() {
        return """
                <h1>저는 홍길동입니다.</h1>
                <p><strong>소개페이지</strong>입니다.</p>
                """;
    }

    @GetMapping("/ageUp")
    @ResponseBody
    public int getAgeAndUp() {
        return age++;
    }
}
