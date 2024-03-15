package org.example.DAO.custom.impl;

import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    Session session = FactoryConfiguration.getInstance().getSession();
    @Override
    public boolean save(User dto) {
        try {
            Transaction transaction = session.beginTransaction();
            Serializable save = (Serializable) session.save(dto);
            transaction.commit();
            return save != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(User dto) {
        try {
            Transaction transaction = session.beginTransaction();
            session.update(dto);
            transaction.commit();
            return true;
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            Transaction transaction = session.beginTransaction();
            User customer = session.get(User.class,id);
            session.delete(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAll() {
        try {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = (CriteriaBuilder) session.getCriteriaBuilder();
            CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
            query.from(User.class);
            List<User> resultList = session.createQuery(String.valueOf(query)).getResultList();
            transaction.commit();
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public User getItem(String id) {
        try {
            Transaction transaction = session.beginTransaction();
            User customer = session.get(User.class,id);
            transaction.commit();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public String getNextId() {
        return null;
    }
}
