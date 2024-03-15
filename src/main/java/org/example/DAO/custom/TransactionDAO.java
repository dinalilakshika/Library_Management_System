package org.example.DAO.custom;

public interface TransactionDAO extends CrudDAO<Transactions,String> {
    String getNextId();
}

