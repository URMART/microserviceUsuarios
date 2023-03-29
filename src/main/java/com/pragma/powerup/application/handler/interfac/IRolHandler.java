package com.pragma.powerup.application.handler.interfac;

import com.pragma.powerup.application.dto.request.RolRequestDto;
import com.pragma.powerup.application.dto.response.RolResponseDto;
import com.pragma.powerup.domain.model.Roles;

public interface IRolHandler {

    void saveRol(RolRequestDto rolRequestDto);
    RolResponseDto findByNombre(String nombre);
}
