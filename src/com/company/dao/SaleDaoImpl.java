package com.company.dao;

import com.company.Sale;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SaleDaoImpl implements SaleDao {
    private final String fileName;
    private List<Sale> sales;

    public SaleDaoImpl(String fileName) {
        this.fileName = fileName;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            this.sales = (List<Sale>) inputStream.readObject();
        }
        catch(IOException | ClassNotFoundException ex) {
            this.sales = new ArrayList<>();
        }

    }
    @Override
    public List<Sale> allSales(){
        return sales;
    }

    public List<Sale> findByDate(LocalDate date){
        return sales.stream()
                .filter(c -> c.getDate().equals(date))
                .collect(Collectors.toList());
    }
    @Override
    public void save() {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(sales);
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
