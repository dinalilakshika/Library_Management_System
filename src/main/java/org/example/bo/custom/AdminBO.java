package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.AdminDTO;

public interface AdminBO extends SuperBO {
    AdminDTO search(String userName);

}

