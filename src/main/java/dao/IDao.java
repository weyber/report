package dao;

import java.util.List;

import model.Book;

public interface IDao {

    public List<Book> select();
}
