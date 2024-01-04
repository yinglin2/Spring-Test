package com.spring.tx.dao;

public interface BookDao {
    int getBookPriceById(int bookId);

    void updateStock(int bookId);

    void updateUserBalance(int userId, int price);
}
