package cn.itcast.dao;

import java.util.Map;

import cn.itcast.DB.DB;
import cn.itcast.domain.Book;

public class BookDao {
    public Map getAll() {
        return DB.getAll();
    }

    public Book find(String id) {
        return (Book) DB.getAll().get(id);
    }
}
