package com.group.EstateAngencyProject.repository;

import com.group.EstateAngencyProject.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
}
