package com.vtn.model;

import javax.persistence.*;

@Entity()
@Table(name = "HotKeySearch")
public class HotKeySearch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;
    @Column(name = "Word")
    private String word;
    @Column(name = "Total")
    private int total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
