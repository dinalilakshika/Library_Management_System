package org.example.DAO;

import org.example.DAO.custom.impl.AdminDAOImpl;
import org.example.DAO.custom.impl.BookDAOImpl;

public class DAOFactory {
    private static DAOFactory daofactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaofactory() {
        return (daofactory==null)?daofactory=new DAOFactory():daofactory;
    }

    public enum DAOTypes {
        USER,ADMIN,BOOK,TRANSACTION,QUERY
    }

    public SuperDAO getDAO (DAOTypes daoTypes) {
        switch (daoTypes) {
            case ADMIN:
                return new AdminDAOImpl();
            case USER:
                return null;
            case BOOK:
                return new BookDAOImpl();
            case TRANSACTION:
                return null;
            case QUERY:
                return null;
            default:
                return null;
        }
    }
}
