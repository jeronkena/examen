package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
	Comics comics1 = new Comics("manga","fdgdg","ecsmo",
            123,"fantasy", 2021, 150,250,"comics");
    Comics comics2 = new Comics("toro","fdgdg","ecsmo",
                123,"fantasy", 2022, 150,350,"comics");
    try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("comics.bin"))){
        outputStream.writeObject(comics1);
        outputStream.writeObject(comics2);
    }
    catch (IOException ex){
        System.out.println(ex.getMessage());
    }
    }
}
