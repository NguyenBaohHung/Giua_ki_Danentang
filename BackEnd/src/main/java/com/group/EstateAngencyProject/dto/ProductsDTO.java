package com.group.EstateAngencyProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsDTO {
    private Integer id;              // Đổi từ products_id
    private String name;             // Đổi từ products_name
    private Integer price;           // Đổi từ products_price
    private String image;            // Đổi từ products_image
    private String type;             // Đổi từ products_type
}
