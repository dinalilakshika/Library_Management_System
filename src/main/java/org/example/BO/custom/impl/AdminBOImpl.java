package org.example.BO.custom.impl;

public class AdminBOImpl implements AdminBO {
    AdminDAO userDAO = (AdminDAO)DAOFactory.getDaofactory().getDAO(DAOFactory.DAOTypes.ADMIN);
    @Override
    public boolean saveUser(AdminDTO userDTO) {
        return userDAO.save(new Admin(
                userDTO.getMail(),
                userDTO.getPassword()
        ));
    }

    @Override
    public AdminDTO getUser(AdminDTO userDTO) {
        Admin user = userDAO.getItem(userDTO.getMail());
        if (user!=null) {
            return new AdminDTO(user.getMail(),user.getPassword());
        } else {
            return null;
        }
    }

    @Override
    public boolean updateUser(AdminDTO userDTO) {
        return userDAO.update(new Admin(
                userDTO.getMail(),
                userDTO.getPassword()
        ));
    }
}
