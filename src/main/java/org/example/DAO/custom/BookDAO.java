package org.example.DAO.custom;

public interface BookDAO extends CrudDAO<Book,String> {
    String getNextId();
}