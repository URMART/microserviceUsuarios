package com.pragma.powerup.application.mapper.roles;

import com.pragma.powerup.application.dto.request.RolRequestDto;
import com.pragma.powerup.application.dto.request.UsuariosRequestDto;
import com.pragma.powerup.domain.model.Roles;
import com.pragma.powerup.domain.model.Usuarios;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRolRequestMapper {

    Roles toRol(RolRequestDto rolRequestDto);
    RolRequestDto toRolDto(Roles rol);
}
