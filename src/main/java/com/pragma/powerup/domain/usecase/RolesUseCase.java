package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IRolesServicePort;
import com.pragma.powerup.domain.model.Roles;
import com.pragma.powerup.domain.spi.IRolesPersistencePort;

public class RolesUseCase implements IRolesServicePort {

    private final IRolesPersistencePort rolesPersistencePort;

    public RolesUseCase(IRolesPersistencePort rolesPersistencePort) {
        this.rolesPersistencePort = rolesPersistencePort;
    }


    @Override
    public void saveRol(Roles roles) {
        rolesPersistencePort.saveRol(roles);
    }

    @Override
    public Roles findByNombre(String nombre) {
        return rolesPersistencePort.findByNombre(nombre);
    }
}