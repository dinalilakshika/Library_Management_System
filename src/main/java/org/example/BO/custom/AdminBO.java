package org.example.BO.custom;

import org.example.BO.SuperBO;
import org.example.DTO.AdminDTO;
import org.example.DTO.UserDTO;

public interface AdminBO extends SuperBO {
    boolean saveAdmin(AdminDTO adminDTO);

    boolean updateAdmin(AdminDTO userDTO);

    AdminDTO getAdmin(AdminDTO adminDTO);
}