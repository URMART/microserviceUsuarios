package com.pragma.powerup.infrastructure.out.jpa.repository;

import com.pragma.powerup.domain.model.Roles;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRolRepository extends JpaRepository<RolEntity, Integer> {
    RolEntity findByNombre(String nombre);
}
