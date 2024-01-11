package org.example.service;



import org.example.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> listAllRoles();
    RoleDTO findById(Long id);
}
