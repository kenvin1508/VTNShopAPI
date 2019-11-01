package com.vtn.service;

import com.vtn.model.HotKeySearch;
import com.vtn.repository.HotKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class HotKeyService {
    @Autowired
    HotKeyRepository hkRes;

    public List<String> getAll() {
        return hkRes.getAll();
    }

    public void increaseTotal(String word) {
        HotKeySearch hotKeySearch = hkRes.findByWord(word);
        if (hotKeySearch != null) {
            System.out.println("tren");
            hotKeySearch.setTotal(hotKeySearch.getTotal() + 1);
            hkRes.save(hotKeySearch);
        } else {
            System.out.println("duoi");
            hkRes.save(new HotKeySearch(word, 1));
        }
    }
}
