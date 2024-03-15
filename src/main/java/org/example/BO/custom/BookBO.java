package org.example.BO.custom;

import java.util.List;

public interface BookBO extends SuperBO {
    List<BookDTO> getAll();
    boolean saveBook(BookDTO bookDTO);
    boolean updateBook(BookDTO bookDTO);
    BookDTO getBook(String bookId);
    boolean deleteBook(String bookId);
    String getNextId();
}

