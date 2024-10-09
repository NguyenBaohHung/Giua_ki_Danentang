package com.group.EstateAngencyProject.service;

import com.group.EstateAngencyProject.dto.UserDTO;

public interface IUserService {
    UserDTO creatrOrUpdateUser(UserDTO userDTO);

    String deleteUser(UserDTO userDTO);
}
