package com.group.EstateAngencyProject.controller;


import com.group.EstateAngencyProject.constant.GlobalMessage;
import com.group.EstateAngencyProject.dto.CustomerDTO;
import com.group.EstateAngencyProject.dto.UserDTO;
import com.group.EstateAngencyProject.response.APIResponse;
import com.group.EstateAngencyProject.service.impl.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> createOrUpdateUser(@RequestBody UserDTO userDTO){
        return APIResponse.responseBuilder(HttpStatus.CREATED, GlobalMessage.SUCCESS, userService.creatrOrUpdateUser(userDTO));
    }
    @DeleteMapping
    public ResponseEntity<Object> deleteUser(@RequestBody UserDTO userDTO){
        return  APIResponse.responseBuilder(HttpStatus.OK, GlobalMessage.SUCCESS, userService.deleteUser(userDTO));
    }
}
