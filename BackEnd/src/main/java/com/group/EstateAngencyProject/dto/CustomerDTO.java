package com.group.EstateAngencyProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private Integer customerId;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private Boolean isActive;
}
