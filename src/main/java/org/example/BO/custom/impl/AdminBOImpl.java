package org.example.BO.custom.impl;

import org.example.BO.custom.AdminBO;
import org.example.DAO.DAOFactory;
import org.example.DAO.custom.AdminDAO;
import org.example.DTO.AdminDTO;
import org.example.Entity.Admin;

public class AdminBOImpl implements AdminBO {
    AdminDAO userDAO = (AdminDAO) DAOFactory.getDaofactory().getDAO(DAOFactory.DAOTypes.ADMIN);
    @Override
    public boolean saveAdmin(AdminDTO userDTO) {
        return userDAO.save(new Admin(
                userDTO.getMail(),
                userDTO.getPassword()
        ));
    }

    @Override
    public AdminDTO getAdmin(AdminDTO userDTO) {
        Admin user = userDAO.getItem(userDTO.getMail());
        if (user!=null) {
            return new AdminDTO(user.getMail(),user.getPassword());
        } else {
            return null;
        }
    }

    @Override
    public boolean updateAdmin(AdminDTO userDTO) {
        return userDAO.update(new Admin(
                userDTO.getMail(),
                userDTO.getPassword()
        ));
    }
}
