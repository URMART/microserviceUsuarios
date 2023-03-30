package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.Roles;
import com.pragma.powerup.domain.spi.IRolesPersistencePort;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;

import com.pragma.powerup.infrastructure.out.jpa.mapper.IRolEntityMapper;

import com.pragma.powerup.infrastructure.out.jpa.repository.IRolRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class RolesJpaAdapter implements IRolesPersistencePort {



    private final IRolRepository rolRepository;
    private final IRolEntityMapper rolEntityMapper;
    @Override
    public Roles saveRol(Roles roles) {
        RolEntity  rolEntity = rolRepository.save(rolEntityMapper.toEntity(roles));
        return rolEntityMapper.toRolesModel(rolEntity);
    }

    @Override
    public Roles findByNombre(String nombre) {
        return rolEntityMapper.toRolesModel(rolRepository.findByNombre(nombre));
    }
}
