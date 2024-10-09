package com.group.EstateAngencyProject.service.impl;

import com.group.EstateAngencyProject.converter.ProductsConverter;
import com.group.EstateAngencyProject.dto.ProductsDTO;
import com.group.EstateAngencyProject.entity.ProductEntity;
import com.group.EstateAngencyProject.repository.ProductRepository;
import com.group.EstateAngencyProject.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final ProductsConverter productsConverter;

    // Constructor injection
    public ProductService(ProductRepository productRepository, ProductsConverter productsConverter) {
        this.productRepository = productRepository;
        this.productsConverter = productsConverter;
    }

    @Override
    public List<ProductsDTO> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities.stream()
                .map(productsConverter::toProductsDTO) // Chuyển đổi từ Entity sang DTO
                .collect(Collectors.toList());
    }

    @Override
    public ProductsDTO addProducts(ProductsDTO productsDTO) {
        ProductEntity productEntity = productsConverter.toProductEntity(productsDTO); // Chuyển đổi DTO thành Entity
        ProductEntity savedProduct = productRepository.save(productEntity); // Lưu vào DB
        return productsConverter.toProductsDTO(savedProduct); // Trả về DTO đã lưu
    }

    @Override
    public Object deleteProduct(int id) {
        productRepository.deleteById(id);
        return null;
    }

    public ProductsDTO updateProduct(int id, ProductsDTO productsDTO) {
        // Tìm sản phẩm theo ID
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found")); // Ném ra ngoại lệ nếu không tìm thấy

        // Cập nhật thông tin sản phẩm
        productEntity.setName(productsDTO.getName());
        productEntity.setPrice(productsDTO.getPrice());
        productEntity.setType(productsDTO.getType());
        productEntity.setImageUrl(productsDTO.getImage());

        // Lưu sản phẩm đã được cập nhật
        ProductEntity updatedProduct = productRepository.save(productEntity);

        // Chuyển đổi và trả về sản phẩm đã được cập nhật
        return productsConverter.toProductsDTO(updatedProduct);
    }
}
