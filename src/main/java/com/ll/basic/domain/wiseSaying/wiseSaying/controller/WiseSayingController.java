package com.ll.basic.domain.wiseSaying.wiseSaying.controller;

import com.ll.basic.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import com.ll.basic.domain.wiseSaying.wiseSaying.service.WiseSayingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wiseSayings")
@RequiredArgsConstructor//여기에 붙이면 모든 메소드에 적용됨
public class WiseSayingController {
    private final WiseSayingService wiseSayingService;

    @GetMapping
    public List<WiseSaying> getItems() {
        return wiseSayingService.findAll();
    }

    @GetMapping("/write")
    public WiseSaying write(
            String content,
            @RequestParam(defaultValue = "작자미상") String author
    ) {
        return wiseSayingService.write(content, author);
    }

    @GetMapping("/{id}")
    public WiseSaying getItem(
            @PathVariable long id
    ) {
        Optional<WiseSaying> opWiseSaying = wiseSayingService.findById(id);

        return opWiseSaying.get();
    }

    @GetMapping("/{id}/delete")
    public boolean deleteItem(
            @PathVariable long id
    ) {
        return wiseSayingService.deleteById(id);
    }

    @GetMapping("/{id}/modify")
    public WiseSaying modifyItem(
            @PathVariable long id,
            String content,
            @RequestParam(defaultValue = "작자미상") String author
    ) {
        WiseSaying wiseSaying = wiseSayingService.findById(id).get();

        wiseSayingService.modify(wiseSaying, content, author);

        return wiseSaying;
    }
}
