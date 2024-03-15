package org.example.BO.custom;

public interface AdminBO extends SuperBO {
    boolean saveUser(AdminDTO userDTO);
    AdminDTO getUser(AdminDTO userDTO);
    boolean updateUser(AdminDTO userDTO);
}