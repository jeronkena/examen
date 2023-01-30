package com.company;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Comics implements Serializable {
    public String title;
    public String author;
    public String publisher;
    public int size;
    public String genre;
    public int date;
    public int cost;
    public int price;
    public String collection;

    public Comics(String title, String author, String publisher, int size, String genre,
                  int date, int cost, int price, String collection) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.size = size;
        this.genre = genre;
        this.date = date;
        this.cost = cost;
        this.price = price;
        this.collection = collection;
    }

    @Override
    public String toString() {
        return "Comics{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", size=" + size +
                ", genre='" + genre + '\'' +
                ", date=" + date +
                ", cost=" + cost +
                ", price=" + price +
                ", collection='" + collection + '\'' +
                '}';
    }
}
