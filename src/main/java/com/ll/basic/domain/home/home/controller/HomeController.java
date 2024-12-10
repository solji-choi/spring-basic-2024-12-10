package com.ll.basic.domain.home.home.controller;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/boolean")
    @ResponseBody
    public boolean getBoolean() {
        return true;
    }

    @GetMapping("/byte")
    @ResponseBody
    public byte getByte() {
        return 127;
    }

    @GetMapping("/short")
    @ResponseBody
    public short getShort() {
        return 32000;
    }

    @GetMapping("/long")
    @ResponseBody
    public long getLong() {
        return 100_000_000_000_000L;
    }

    @GetMapping("/char")
    @ResponseBody
    public char getChar() {
        return '꽑';
    }

    @GetMapping("/float")
    @ResponseBody
    public float getFloat() {
        return 3.14f;
    }

    @GetMapping("/double")
    @ResponseBody
    public double getDouble() {
        return 3.141592;
    }

    @GetMapping("/array")
    @ResponseBody
    public String[] getArray() {
        String[] arr = {"a", "b", "c"};
        return arr;
    }
    @GetMapping("/list")
    @ResponseBody
    public List<String> getList() {
        return List.of("a", "b", "c");
    }
    @GetMapping("/map")
    @ResponseBody
    public Map<String, String> getMap() {
        return Map.of("name", "Paul", "hobby", "reading");
    }

    @GetMapping("/article")
    @ResponseBody
    public Article getArticle() {
        return Article
                .builder()
                .body("내용")
                .title("제목")
                .build();
    }
}

@Builder
@Getter
class Article {
    @Builder.Default
    private long id = 1L;
    private String title;
    private String body;
    @Builder.Default
    private boolean published = true;
}
