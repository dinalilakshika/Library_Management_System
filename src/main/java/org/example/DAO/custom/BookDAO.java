package org.example.DAO.custom;

import org.example.DAO.CrudDAO;
import org.example.Entity.Book;

public interface BookDAO extends CrudDAO<Book,String> {
    String getNextId();
}