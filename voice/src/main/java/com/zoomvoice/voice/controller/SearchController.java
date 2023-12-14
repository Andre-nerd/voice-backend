package com.zoomvoice.voice.controller;

import com.zoomvoice.voice.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;

    @GetMapping("/yahoo")
    public ResponseEntity<List<String>> goYahoo(){
        searchService.parseYahoo();
        return ResponseEntity.ok(searchService.parseYahoo());
    }
    @GetMapping("/count")
    public ResponseEntity<int[]> countYahoo(){
        searchService.countYahoo();
        return ResponseEntity.ok(searchService.countYahoo());
    }
}
