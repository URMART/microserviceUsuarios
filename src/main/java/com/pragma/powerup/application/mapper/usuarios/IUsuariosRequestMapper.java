package com.pragma.powerup.application.mapper.usuarios;

import com.pragma.powerup.application.dto.request.UsuariosRequestDto;
import com.pragma.powerup.domain.model.Usuarios;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUsuariosRequestMapper {

    Usuarios toUsuarios(UsuariosRequestDto usuariosRequestDto);
}
