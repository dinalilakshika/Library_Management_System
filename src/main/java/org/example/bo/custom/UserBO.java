package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.UserDTO;

import java.util.List;

public interface UserBO extends SuperBO {
    boolean addUser(UserDTO dto);
    List<UserDTO> getAllUser();
    boolean updateUser(UserDTO dto);
    boolean isExistUser(String id);
    UserDTO searchUser(String id);
    boolean deleteUser(String id);
    public String getLastUserId();
}
