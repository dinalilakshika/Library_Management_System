package org.example.DAO.custom;

import org.example.DAO.SuperDAO;
import org.example.DTO.TransactionDTO;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<TransactionDTO> getAllTransaction();
}
