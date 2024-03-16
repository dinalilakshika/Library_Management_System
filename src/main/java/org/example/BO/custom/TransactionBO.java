package org.example.BO.custom;

import org.example.BO.SuperBO;
import org.example.DTO.BookDTO;
import org.example.DTO.TransactionDTO;
import org.example.DTO.UserDTO;
import org.example.Entity.Transactions;

import java.util.List;

public interface TransactionBO extends SuperBO {
    List<Transactions> getAll();
    List<String> getAllBookId();
    List<String> getUserId();
    BookDTO getBook(String book);
    UserDTO getUser(String user);
    boolean saveTransaction(TransactionDTO transactionDTO);
    boolean updateTransaction(TransactionDTO transactionDTO);
    boolean deleteTransaction(String transactionId);
    String getNextId();
}
