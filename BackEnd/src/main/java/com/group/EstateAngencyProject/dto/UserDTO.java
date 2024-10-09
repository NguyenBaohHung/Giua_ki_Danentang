package com.group.EstateAngencyProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Integer userId;
    private Integer roleId;
    private String userName;
    private String passWord;
    private String fullName;
    private String email;
    private Boolean isActive;
}
