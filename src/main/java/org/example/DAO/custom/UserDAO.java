package org.example.DAO.custom;

import org.example.DAO.CrudDAO;
import org.example.Entity.User;

public interface UserDAO extends CrudDAO<User,String> {
    String getNextId();
}
