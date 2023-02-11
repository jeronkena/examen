package com.company.dao;

import com.company.Comics;

import java.time.LocalDate;
import java.util.List;

public interface ComicsDao {
    List<Comics> findByAuthor(String author);
    List <Comics> findByGenre(String genre);
    Comics findById(int id);
    List<Comics> allComics();
    List<Comics> findByTitle(String title);
    void saveComics(Comics comics);
    List <Comics> findByDate(LocalDate data);
    default void save() {
        throw new UnsupportedOperationException();
    }
}
