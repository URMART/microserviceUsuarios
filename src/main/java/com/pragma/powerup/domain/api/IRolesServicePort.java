package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Roles;

public interface IRolesServicePort {

    void saveRol(Roles roles);
    Roles findByNombre(String nombre);
}
