package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Usuarios;

import java.util.List;

public interface IUsuariosPersistencePort {

    Usuarios saveUsuario(Usuarios usuario);

    List<Usuarios> findAll();

    Usuarios findById(Long id);

    Usuarios findByEmail(String email);
}
