package org.example.DAO.custom;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<TransactionDTO> getAllTransaction();
}
