package com.company;

import com.company.dao.ComicsDao;
import com.company.dao.SaleDao;
import com.company.dao.UserDao;

import java.time.LocalDate;
import java.util.*;

import static java.time.LocalTime.now;

public class Application {
    private final ComicsDao comicsDao;
    private final UserDao userDao;
    private final SaleDao saleDao;
    private final Scanner scanner;
    private boolean running;
    private User currentUser;

    public Application(ComicsDao comicsDao, UserDao userDao, SaleDao saleDao) {
        this.comicsDao = comicsDao;
        this.userDao = userDao;
        this.saleDao = saleDao;
        this.scanner = new Scanner(System.in);
        this.running = true;
        this.currentUser = currentUser;
    }

    public void run() {
        while(running) {
            //Если пользователь авторизован
            if(currentUser != null) {
                selectionMenu();
            }
            else {
                mainMenu();
            }
        }


        userDao.save();
        comicsDao.save();
    }

    private void mainMenu() {
        System.out.println("------------ГЛАВНОЕ МЕНЮ------------");
        System.out.println("Чтобы авторизоваться - нажмите 1\nЧтобы зарегистрироваться - 2\n Выход - 3");
        int action = scanner.nextInt();
        if(action == 1) {
            authHanlder();
        }
        else if(action == 2) {
            registerHandler();
        }
        else if(action == 3) {
            this.running = false;
        }
        else {
            System.out.println("Неизвестная команда...");
        }
    }
    private void saleComics(){
        System.out.println("Введите ID комикса:");
        int id = scanner.nextInt();
        saleDao.allSales().add(new Sale(LocalDate.now(),comicsDao.findById(id)));
        comicsDao.allComics().remove(comicsDao.findById(id));
        comicsDao.save();
        saleDao.save();
        System.out.println("Комикс продан!");
    }

    private void selectionMenu() {
        System.out.println("---------Выберите действие---------");
        System.out.println("1 - Продать комикс\n2 - Поиск комикса\n3 - Списки комиксов\n4 - Добавить комикс" +
                "\n5 - Редактировать комикс \n6 - Удалить комикс\n7 - Выйти из системы\n8 - все комиксы");
        int action = scanner.nextInt();
        if(action == 1) {
            saleComics();
        }
        else if(action == 2) {
            findComicsHandler();
        }
        else if(action == 3) {
            ListComicsHandler();
        }
        else if(action == 4) {
            createComicsHandler();
        }
        else if(action == 5) {
            editComicsHandler();
        }
        else if(action == 6) {
            deleteComicsHandler();
        }
        else if(action == 7) {
            logoutHandler();
        }
        else if(action == 8) {
            List<Comics> comics = comicsDao.allComics();
            for(Comics com:comics){
                System.out.println(com.toString());
            }
        } else{
            System.out.println("Неизвестная команда...");
        }
    }

    private void findByTitle(){
        System.out.println("Введите название комикса:");
        String title = scanner.next();
        List<Comics> comics = comicsDao.findByTitle(title);
        for(Comics com : comics) {
            System.out.println(com.toString());
        }
    }
    private void findByAuthor(){
        System.out.println("Введите автора комикса:");
        String author = scanner.next();
        List<Comics> comics = comicsDao.findByAuthor(author);
        for(Comics com : comics) {
            System.out.println(com.toString());
        }
    }
    private void findByGenre(){
        System.out.println("Введите жанр комикса:");
        String author = scanner.next();
        List<Comics> comics = comicsDao.findByGenre(author);
        for(Comics com : comics) {
            System.out.println(com.toString());
        }
    }
    private void newComicsDay(String data, int days){
        System.out.println("---------За " + data + "---------");
        List <LocalDate> dates= new ArrayList<>();
        dates.add(LocalDate.now());
        for (int j = 1; j < days; j++){
            dates.add(LocalDate.now().plusDays(j));
            List <Comics> c1 = comicsDao.findByDate(LocalDate.now());
            for(Comics com : c1) {
                System.out.println(com.toString());
            }
    }}

    private void ListComicsHandler() {
        System.out.println("---------Выберите действие---------");
        System.out.println("1 - Новинки\n2 - Самые продаваемые\n3 - Популярные авторы\n4 - Популярные жанры");
        int action = scanner.nextInt();
        if(action == 1) {
            System.out.println("---------За день---------");
            List <Comics> comics = comicsDao.findByDate(LocalDate.now());
            for(Comics com : comics) {
                System.out.println(com.toString());
        }
            if(action == 2) {

        }
        else if(action == 3) {

        }
        else if(action == 4) {

        }
        else {
            System.out.println("Неизвестная команда...");
        }
    }}


    private void findComicsHandler() {
        System.out.println("---------Выберите действие---------");
        System.out.println("1 - Поиск по названию\n2 - Поиск по автору\n3 - Поиск по жанру\n4 - Выйти из системы");
        int action = scanner.nextInt();
        if(action == 1) {
            findByTitle();
        }else if(action == 2) {
            findByAuthor();
        }
        else if(action == 3) {
            findByGenre();
        }
        else if(action == 4) {
            logoutHandler();
        }
        else {
            System.out.println("Неизвестная команда...");
        }
    }

    private void createComicsHandler() {
        System.out.println("Введите название коллекции комикса:");
        String collection = scanner.next();
        System.out.println("Введите название комикса:");
        String title = scanner.next();
        System.out.println("Введите автора комикса:");
        String author = scanner.next();
        System.out.println("Введите издателя комикса:");
        String publisher = scanner.next();
        System.out.println("Введите количество страниц комикса:");
        int size = scanner.nextInt();
        System.out.println("Введите жанр комикса:");
        String genre = scanner.next();
        System.out.println("Введите год издания комикса:");
        int date = scanner.nextInt();
        System.out.println("Введите себестоимость комикса:");
        int cost = scanner.nextInt();
        System.out.println("Введите цену комикса:");
        int price = scanner.nextInt();
        Comics comics = new Comics(title,author,publisher,size,genre,date,cost,price,collection,LocalDate.now());
        comicsDao.saveComics(comics);
        comicsDao.save();
        System.out.println("Комикс успешно добавлен!");

    }

    private void editComicsHandler() {
        System.out.println("Введите ID комикса: ");
        int id = scanner.nextInt();
        Comics comics = comicsDao.allComics().stream()
                .filter(post -> post.getId() == id)
                .findFirst().orElseThrow();
        System.out.println("Введите название коллекции комикса:");
        String collection = scanner.next();
        comics.setCollection(collection);
        System.out.println("Введите название комикса:");
        String title = scanner.next();
        comics.setTitle(title);
        System.out.println("Введите автора комикса:");
        String author = scanner.next();
        comics.setAuthor(author);
        System.out.println("Введите издателя комикса:");
        String publisher = scanner.next();
        comics.setPublisher(publisher);
        System.out.println("Введите количество страниц комикса:");
        int size = scanner.nextInt();
        comics.setSize(size);
        System.out.println("Введите жанр комикса:");
        String genre = scanner.next();
        comics.setGenre(genre);
        System.out.println("Введите год издания комикса:");
        int date = scanner.nextInt();
        comics.setDate(date);
        System.out.println("Введите себестоимость комикса:");
        int cost = scanner.nextInt();
        comics.setCost(cost);
        System.out.println("Введите цену комикса:");
        int price = scanner.nextInt();
        comics.setPrice(price);
        System.out.println("Комикс успешно отредактирован!");

    }

    private void deleteComicsHandler() {
        System.out.println("Введите ID комикса: ");
        int id = scanner.nextInt();
        comicsDao.allComics().remove(comicsDao.findById(id));
        System.out.println("Комикс удален!");
    }

    private void registerHandler() {
        System.out.println("Введите никнейм:");
        String nickName = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        User user = new User(nickName, password);
        if(userDao.register(user)) {
            System.out.println("Вы успешно зарегистрированы!");
        }
        else {
            System.out.println("Такой пользователь уже существует.");
        }
        userDao.save();
    }

    //Обработка авторизации
    private void authHanlder() {
        System.out.println("Введите никнейм:");
        String nickName = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        User user = new User(nickName, password);
        if(userDao.auth(user)) {
            this.currentUser = user;
            System.out.println("Вы успешно авторизованы...");
        }
        else {
            System.out.println("Неверный логин или пароль!");
        }
    }
    private void logoutHandler() {
        currentUser = null;
    }
}
