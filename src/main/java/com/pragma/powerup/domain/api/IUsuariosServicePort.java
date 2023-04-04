package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Usuarios;

import java.util.List;

public interface IUsuariosServicePort {

    void saveUsuario(Usuarios usuario);

    List<Usuarios> findAll();

    Usuarios findById(Long id);

    Usuarios findByEmail(String email);
}