package com.pragma.powerup.infrastructure.out.jpa.adapter;


import com.pragma.powerup.domain.model.Usuarios;
import com.pragma.powerup.domain.spi.IUsuariosPersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.out.jpa.entity.UsuariosEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IUsuariosEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IUsuariosRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UsuariosJpaAdapter implements IUsuariosPersistencePort {

    private final IUsuariosRepository usuariosRepository;
    private final IUsuariosEntityMapper usuariosEntityMapper;


    @Override
    public Usuarios saveUsuario(Usuarios usuario) {

        UsuariosEntity usuariosEntity = usuariosRepository.save(usuariosEntityMapper.toEntity(usuario));
        return usuariosEntityMapper.toUsuariosModel(usuariosEntity);
    }

    @Override
    public List<Usuarios> findAll() {
        List<UsuariosEntity> entityList = usuariosRepository.findAll();
        if(entityList.isEmpty()){

            throw new NoDataFoundException();
        }

        return  usuariosEntityMapper.toUsuariosModelList(entityList);
    }

    @Override
    public Usuarios findById(Long id) {
        return usuariosEntityMapper.toUsuariosModel(usuariosRepository.findById(id));
    }

    @Override
    public Usuarios findByEmail(String email) {
        return usuariosEntityMapper.toUsuariosModel(usuariosRepository.findByEmail(email));
    }


}