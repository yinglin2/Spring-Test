package com.spring.iocxml.di;

public class Book {
    private String bname;
    private String author;

    public Book() {
        System.out.println("无参数构造进行创建.....");
    }

    public Book(String bname, String author) {
        System.out.println("有参数构造进行创建.....");
        this.bname = bname;
        this.author = author;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
