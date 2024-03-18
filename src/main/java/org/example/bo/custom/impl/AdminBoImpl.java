package org.example.bo.custom.impl;

import org.example.bo.custom.AdminBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.AdminDAO;
import org.example.dao.custom.UserDAO;
import org.example.dto.AdminDTO;
import org.example.dto.UserDTO;
import org.example.entity.Admin;
import org.example.entity.User;

public class AdminBoImpl implements AdminBO {

    private AdminDAO adminDAO = (AdminDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ADMIN);
    @Override
    public AdminDTO search(String userName) {
        Admin search = adminDAO.searchByName(userName);
        AdminDTO adminDTO = new AdminDTO(search.getUserName(),search.getPassword());
        return adminDTO;
    }
}
