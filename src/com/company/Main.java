package com.company;

import com.company.dao.ComicsDaoImpl;
import com.company.dao.SaleDaoImpl;
import com.company.dao.UserDaoImpl;

public class Main {

    public static void main(String[] args) {
        Application app = new Application(new ComicsDaoImpl("comics.bin"), new UserDaoImpl("users.bin"),
                new SaleDaoImpl("sales.bin"));
        app.run();
    }
}