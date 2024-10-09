package com.group.EstateAngencyProject.service.impl;

import com.group.EstateAngencyProject.converter.UserConverter;
import com.group.EstateAngencyProject.dto.UserDTO;
import com.group.EstateAngencyProject.entity.RoleEntity;
import com.group.EstateAngencyProject.entity.UserEntity;
import com.group.EstateAngencyProject.repository.RoleRepository;
import com.group.EstateAngencyProject.repository.UserRepository;
import com.group.EstateAngencyProject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService implements IUserService {
    private UserConverter userConverter;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserConverter userConverter, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.roleRepository = roleRepository;
    }
    @Override
    public UserDTO creatrOrUpdateUser(UserDTO userDTO) {
        RoleEntity roleEntity = roleRepository.findById(userDTO.getRoleId()).get();
        UserEntity customerEntity = userConverter.toEntity(userDTO);
        customerEntity.setRole(roleEntity);
        userRepository.save(customerEntity);
        UserDTO storedUser = userConverter.toUserDto(customerEntity);
//        return userConverter.toUserDto(customerEntity);
        return storedUser;
    }

    @Override
    public String deleteUser(@RequestBody UserDTO userDTO) {
        UserEntity userEntity = userRepository.findById(userDTO.getUserId()).get();
        userEntity.setIsActive(userDTO.getIsActive());
        userRepository.save(userEntity);
        return "success";
    }
}
