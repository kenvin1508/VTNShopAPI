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
}
