package com.example.demo1.controller;

public class Readings {

    private String book;
    private int chapter;

    public Readings(String book, int chapter) {
        this.book = book;
        this.chapter = chapter;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }
}
