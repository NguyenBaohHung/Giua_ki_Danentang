package com.group.EstateAngencyProject.controller;

import com.group.EstateAngencyProject.constant.GlobalMessage;
import com.group.EstateAngencyProject.dto.ProductsDTO;
import com.group.EstateAngencyProject.entity.ProductEntity;
import com.group.EstateAngencyProject.response.APIResponse;
import com.group.EstateAngencyProject.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;


    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<Object> getAllProducts() {
        return APIResponse.responseBuilder(HttpStatus.OK, GlobalMessage.SUCCESS, productService.getAllProducts());
    }


    @PostMapping
    public ResponseEntity<Object> addProduct(@RequestBody ProductsDTO productsDTO) {
        return APIResponse.responseBuilder(HttpStatus.OK, GlobalMessage.SUCCESS, productService.addProducts(productsDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsDTO> updateProduct(@PathVariable int id, @RequestBody ProductsDTO productDTO) {
            ProductsDTO updatedProduct = (ProductsDTO) productService.updateProduct(id, productDTO);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);

    }
}
