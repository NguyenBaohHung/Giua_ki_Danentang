package com.group.EstateAngencyProject.service;

import com.group.EstateAngencyProject.dto.ProductsDTO;
import java.util.List;

public interface IProductService {

    List<ProductsDTO> getAllProducts();


    ProductsDTO addProducts(ProductsDTO productsDTO);


    Object deleteProduct(int id);

    Object updateProduct(int id, ProductsDTO productsDTO);
}
