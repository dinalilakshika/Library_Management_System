package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.dao.custom.AdminDAO;
import org.example.entity.Admin;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AdminDaoImpl implements AdminDAO {
    @Override
    public boolean add(Admin entity) {
        return false;
    }

    @Override
    public List<Admin> getAll() {
        return null;
    }

    @Override
    public boolean update(Admin entity) {
        return false;
    }

    @Override
    public boolean isExists(String id) {
        return false;
    }

    @Override
    public Admin search(String id) {
        return null;
    }

    @Override
    public Admin searchByName(String userName) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Admin> query = session.createQuery("FROM Admin WHERE userName=:userName",Admin.class);
        query.setParameter("userName",userName);

        Admin admin = query.getSingleResult();

        transaction.commit();
        session.close();

        return admin;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
