package com.company;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public List<Comics> listComics= new ArrayList<>();

    public String Add(Comics comics){
        if (listComics.contains(comics) == false){
            listComics.add(comics);
            return "Комикс успешно добавлен!";
        }
        else return "Комикс уже добавлен!";
    }


}
