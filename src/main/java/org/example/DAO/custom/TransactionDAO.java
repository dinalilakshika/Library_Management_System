package org.example.DAO.custom;

import org.example.DAO.CrudDAO;
import org.example.Entity.Transactions;

public interface TransactionDAO extends CrudDAO<Transactions,String> {
    String getNextId();
}

