package org.example.BO.custom.impl;

import org.example.BO.custom.BookBO;
import org.example.DAO.DAOFactory;
import org.example.DAO.custom.BookDAO;
import org.example.DTO.BookDTO;
import org.example.Entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookBOImpl implements BookBO {
    BookDAO bookDAO = (BookDAO) DAOFactory.getDaofactory().getDAO(DAOFactory.DAOTypes.BOOK);

    @Override
    public List<BookDTO> getAll() {
        List<BookDTO> bookDTOS = new ArrayList<>();
        List<Book> books = bookDAO.getAll();
        if (books != null) {
            for (Book book : books) {
                bookDTOS.add(new BookDTO(
                        book.getId(),
                        book.getName(),
                        book.getType()
                ));
            }
        }
        return bookDTOS;
    }

    @Override
    public boolean saveBook(BookDTO bookDTO) {
        return bookDAO.save(new Book(
                bookDTO.getId(),
                bookDTO.getName(),
                bookDTO.getType()
        ));
    }

    @Override
    public boolean updateBook(BookDTO bookDTO) {
        return bookDAO.update(new Book(
                bookDTO.getId(),
                bookDTO.getName(),
                bookDTO.getType()
        ));
    }

    @Override
    public BookDTO getBook(String bookId) {
        return null;
    }

    @Override
    public boolean deleteBook(String bookId) {
        return false;
    }

    @Override
    public String getNextId() {
        String id = bookDAO.getNextId();
        Integer newId = Integer.parseInt(id.replace("B","")) + 1;
        return String.format("B%03d",newId);
    }
}
