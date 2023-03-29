package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Roles;

public interface IRolesPersistencePort {

    Roles saveRol(Roles roles);
    Roles findByNombre(String nombre);

}
