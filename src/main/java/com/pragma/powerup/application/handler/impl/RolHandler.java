package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.RolRequestDto;
import com.pragma.powerup.application.dto.response.RolResponseDto;
import com.pragma.powerup.application.handler.interfac.IRolHandler;
import com.pragma.powerup.application.mapper.roles.IRolRequestMapper;
import com.pragma.powerup.application.mapper.roles.IRolResponseMapper;
import com.pragma.powerup.domain.api.IRolesServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RolHandler implements IRolHandler {


    private final IRolesServicePort rolesServicePort;
    private final IRolRequestMapper rolRequestMapper;
    private final IRolResponseMapper rolResponseMapper ;





    @Override
    public void saveRol(RolRequestDto rolRequestDto) {
        rolesServicePort.saveRol(rolRequestMapper.toRol(rolRequestDto));
    }

    @Override
    public RolResponseDto findByNombre(String nombre) {
        return rolResponseMapper.toRolResponseDto(rolesServicePort.findByNombre(nombre));
    }
}
