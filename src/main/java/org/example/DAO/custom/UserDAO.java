package org.example.DAO.custom;

public interface UserDAO extends CrudDAO<User,String> {
    String getNextId();
}
