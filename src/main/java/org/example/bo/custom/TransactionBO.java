package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.TransactionDto;
import org.example.dto.UserTransactionDto;
import org.example.entity.CustomEntity;
import org.example.entity.Transaction;

import java.util.List;

public interface TransactionBO extends SuperBO {
    boolean saveTransaction(TransactionDto dto);
    List<TransactionDto> getTransactions();
    List<UserTransactionDto> getUserTransactions();
    public List<UserTransactionDto> getUserAllTransaction();
    public boolean updateStatus(String id);
    public boolean delete(String id);
    List<Transaction> getAllToday();
    public String getLastTransactionId();

}
