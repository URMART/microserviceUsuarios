package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IUsuariosServicePort;

import com.pragma.powerup.domain.exception.DomainException;
import com.pragma.powerup.domain.model.Usuarios;
import com.pragma.powerup.domain.spi.IUsuariosPersistencePort;

import java.util.List;

public class UsuariosUseCase implements IUsuariosServicePort {

    private final IUsuariosPersistencePort usuariosPersistencePort;
    public UsuariosUseCase(IUsuariosPersistencePort usuariosPersistencePort) {
        this.usuariosPersistencePort = usuariosPersistencePort;
    }

    @Override
    public void saveUsuario(Usuarios usuario)  {

        if(usuario.getNombre() == null || usuario.getApellido() == null || usuario.getEmail() == null
                || usuario.getDocumentoIdentidad() == null || usuario.getRol() == null || usuario.getClave() == null
                || usuario.getCelular() == null ) {
            throw new DomainException("Los datos no pueden ser nulos");
        }
        usuariosPersistencePort.saveUsuario(usuario);


    }

    @Override
    public List<Usuarios> findAll() {
        return usuariosPersistencePort.findAll();
    }

    @Override
    public Usuarios findById(Long id) {
        return usuariosPersistencePort.findById(id);
    }

    @Override
    public Usuarios findByEmail(String email) {
        return usuariosPersistencePort.findByEmail(email);
    }
}