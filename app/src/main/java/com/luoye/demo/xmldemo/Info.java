package com.luoye.demo.xmldemo;

/**
 * Created by Luoye on 2016/11/2.
 */

public class Info {
    private String title;
    private String author;
    private int year;
    private float price;
    public Info() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Info{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
