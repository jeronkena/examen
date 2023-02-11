package com.company.dao;

import com.company.Comics;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ComicsDaoImpl implements ComicsDao{
    private final String fileName;
    private List<Comics> comicses;

    public ComicsDaoImpl(String fileName) {
        this.fileName = fileName;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            this.comicses = (List<Comics>) inputStream.readObject();
        }
        catch(IOException | ClassNotFoundException ex) {
            this.comicses = new ArrayList<>();
        }

    }

    @Override
    public List<Comics> findByAuthor(String author) {
        return comicses.stream()
                .filter(c -> c.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Comics> allComics() {
        return comicses;
    }


    @Override
    public List<Comics> findByTitle(String title) {
        return comicses.stream()
                 .filter(c -> c.getTitle().equals(title))
                 .collect(Collectors.toList());

    }
    @Override
    public List<Comics> findByGenre(String genre) {
        return comicses.stream()
                .filter(c -> c.getGenre().equals(genre))
                .collect(Collectors.toList());

    }

    @Override
    public  Comics findById(int id) {
        return comicses.stream()
                .filter(c -> c.getId() == id)
                .findFirst().orElseThrow();
    }

    @Override
    public void saveComics(Comics comics) {
        comicses.add(comics);

    }

    @Override
    public List<Comics> findByDate(LocalDate data) {
        return comicses.stream()
                .filter(c -> c.getData().equals(data))
                .collect(Collectors.toList());
    }

    @Override
    public void save() {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(comicses);
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
