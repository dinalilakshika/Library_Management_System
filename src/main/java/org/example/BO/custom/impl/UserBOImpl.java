package org.example.BO.custom.impl;

import java.util.List;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaofactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public List<UserDTO> getAll() {
        return null;
    }

    @Override
    public boolean saveUser(UserDTO userDTO) {
        return userDAO.save(new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getNic(),
                userDTO.getEmail(),
                userDTO.getPassword()
        ));
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        return userDAO.update(new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getNic(),
                userDTO.getEmail(),
                userDTO.getPassword()
        ));
    }

    @Override
    public UserDTO getUser(String cusId) {
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        return userDAO.delete(id);
    }

    @Override
    public String getNextId() {
        return null;
    }
}
