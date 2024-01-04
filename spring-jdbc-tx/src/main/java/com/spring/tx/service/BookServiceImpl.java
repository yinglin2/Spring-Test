package com.spring.tx.service;

import com.spring.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Transactional标识在方法上，则只会影响该方法
 * @Transactional标识的类上，则会影响类中所有的方法
 *
 * 1. 只读：设置只读，只能查询，不能修改添加删除
 * 2. 超时：在设置超时时候之内没有完成，抛出异常回滚
 * 3. 回滚策略：设置哪些异常不回滚
 * 4. 隔离级别：读问题
 * 5. 传播行为：事务方法之间调用，事务如何使用
 */

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public void buyBook(int bookId, int userId) {
        int price = bookDao.getBookPriceById(bookId);

        bookDao.updateStock(bookId);
        bookDao.updateUserBalance(userId, price);

    }
}
