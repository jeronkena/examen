package com.company.dao;

import com.company.Sale;

import java.time.LocalDate;
import java.util.List;

public interface SaleDao {

    List<Sale> allSales();
    public List<Sale> findByDate(LocalDate date);
    default void save() {
        throw new UnsupportedOperationException();
    }
}
