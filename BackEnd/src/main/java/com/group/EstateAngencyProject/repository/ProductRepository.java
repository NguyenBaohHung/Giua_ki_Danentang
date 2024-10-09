// ProductRepository.java
package com.group.EstateAngencyProject.repository;
import com.group.EstateAngencyProject.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
