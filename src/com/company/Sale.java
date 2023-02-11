package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Sale implements Serializable {
    private static int COUNT = 0;
    private int id;

    private LocalDate date;
    private Comics comics;
    private String bron;

    public Sale(LocalDate date, Comics comics) {
        this.id = ++COUNT;
        this.date = date;
        this.comics = comics;
    }

    public LocalDate getDate() {
        return date;
    }
}
