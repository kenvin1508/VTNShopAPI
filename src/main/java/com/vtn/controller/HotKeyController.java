package com.vtn.controller;

import com.vtn.model.HotKeySearch;
import com.vtn.service.HotKeyService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotKey")
public class HotKeyController {
    @Autowired
    HotKeyService hkSer;

    @GetMapping("/getTop10")
    private List<String> getAll() {
        return hkSer.getAll();
    }

    @GetMapping("/increaseTotal")
    private void increaseTotal(@RequestParam String word) {
        hkSer.increaseTotal(word);
    }
}
