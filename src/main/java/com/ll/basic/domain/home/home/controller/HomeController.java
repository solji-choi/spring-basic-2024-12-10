package com.ll.basic.domain.home.home.controller;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @GetMapping("/articleList")
    @ResponseBody
    public List<Article> getArticles() {
        return List.of(
                Article.builder().body("내용1").title("제목1").build(),
                Article.builder().body("내용2").title("제목2").build()
        );
    }

    @GetMapping("/articleMap")
    @ResponseBody
    public Map<String, Article> articleMap() {
        return Map.of(
                "article1", Article.builder().body("내용1").title("제목1").build(),
                "article2", Article.builder().body("내용2").title("제목2").build()
        );
    }

    @GetMapping("/articleList.html")
    @ResponseBody
    public String getArticlesDotHtml() {
        Article article1 = Article.builder().id(1).body("내용1").title("제목1").build();
        Article article2 = Article.builder().id(2).body("내용2").title("제목2").build();
        Article article3 = Article.builder().id(3).body("내용3").title("제목3").build();
        Article article4 = Article.builder().id(4).body("내용4").title("제목4").build();

        List<Article> articles = List.of(article1, article2, article3, article4);

        String lis = articles
                .stream()
                .map(article -> "<li>%d번 / %s</li>".formatted(article.getId(), article.getTitle()))
                .collect(Collectors.joining("\n"));

        return "<ul>\n" + lis + "\n</ul>";
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
