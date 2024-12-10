package com.ll.basic.domain.wiseSaying.wiseSaying.controller;

import com.ll.basic.domain.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import com.ll.basic.domain.domain.wiseSaying.wiseSaying.service.WiseSayingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor//여기에 붙이면 모든 메소드에 적용됨
public class WiseSayingController {
    private final WiseSayingService wiseSayingService;

    @GetMapping("/wiseSayings")
    public List<WiseSaying> getItems() {
        return wiseSayingService.findAll();
    }
}
