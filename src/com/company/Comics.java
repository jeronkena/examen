package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Comics  implements Serializable{
    private static int COUNT = 0;
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int size;
    private String genre;
    private int date;
    private int cost;
    private int price;
    private String collection;
    private LocalDate data;

    public Comics(String title, String author, String publisher, int size, String genre,
                  int date, int cost, int price, String collection, LocalDate data) {
        this.id = COUNT++;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.size = size;
        this.genre = genre;
        this.date = date;
        this.cost = cost;
        this.price = price;
        this.collection = collection;
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public String getTitle() {
        return title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Comics{" +
                "id=" + id +
                ", title='" + title + '\'' +
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
