package com.ll.basic.domain.wiseSaying.wiseSaying.controller;

import com.ll.basic.domain.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import com.ll.basic.domain.domain.wiseSaying.wiseSaying.service.WiseSayingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor//여기에 붙이면 모든 메소드에 적용됨
public class WiseSayingController {
    private final WiseSayingService wiseSayingService;

    @GetMapping("/wiseSayings")
    public List<WiseSaying> getItems() {
        return wiseSayingService.findAll();
    }

    @GetMapping("/wiseSayings/write")
    public WiseSaying write(
            String content,
            @RequestParam(defaultValue = "무명") String author
    ) {
        return wiseSayingService.write(content, author);
    }

    @GetMapping("/wiseSayings/1")
    public WiseSaying getItem() {
        Optional<WiseSaying> opWiseSaying = wiseSayingService.findFyId(1L);

        return opWiseSaying.get();
    }
}
