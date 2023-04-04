package com.pragma.powerup.infrastructure.out.jpa.repository;



import com.pragma.powerup.infrastructure.out.jpa.entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuariosRepository extends JpaRepository<UsuariosEntity, Integer> {
    UsuariosEntity findById(Long id);
    UsuariosEntity findByEmail(String email);
}