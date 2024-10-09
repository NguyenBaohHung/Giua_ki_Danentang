package com.group.EstateAngencyProject.converter;

import com.group.EstateAngencyProject.dto.ProductsDTO;
import com.group.EstateAngencyProject.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductsConverter {
    private ModelMapper modelMapper;

    public ProductsConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductEntity toProductEntity(ProductsDTO productsDTO){
        ProductEntity productEntity = modelMapper.map(productsDTO, ProductEntity.class);
        return productEntity;
    }

    public  ProductsDTO toProductsDTO(ProductEntity productEntity){
        ProductsDTO productsDTO = modelMapper.map(productEntity, ProductsDTO.class);
        return productsDTO;
    }
}
