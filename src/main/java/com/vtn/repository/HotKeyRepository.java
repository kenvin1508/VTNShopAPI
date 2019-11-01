package com.vtn.repository;

import com.vtn.model.HotKeySearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotKeyRepository extends JpaRepository<HotKeySearch, Integer> {
    @Query(value = "SELECT TOP 10 Word FROM HotKeySearch ORDER BY Total DESC ", nativeQuery = true)
    List<String> getAll();

    //@Query(value = "SELECT Word FROM HotKeySearch WHERE Word=?1 ", nativeQuery = true)
    HotKeySearch findByWord(String word);

    @Query(value = "UPDATE HotKeySearch SET Total=Total+1 WHERE Word=?1", nativeQuery = true)
    HotKeySearch increaseTotal(String word);

}
