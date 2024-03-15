package org.example.BO.custom;

import java.util.List;

public interface UserBO extends SuperBO {
    List<UserDTO> getAll();
    boolean saveUser(UserDTO customerDTO);
    boolean updateUser(UserDTO customerDTO);
    UserDTO getUser(String cusId);
    boolean deleteUser(String cusId);
    String getNextId();
}