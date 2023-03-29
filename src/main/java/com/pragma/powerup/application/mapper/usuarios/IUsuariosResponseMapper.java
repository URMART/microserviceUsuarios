package com.pragma.powerup.application.mapper.usuarios;

import com.pragma.powerup.application.dto.response.UsuariosResponseDto;
import com.pragma.powerup.domain.model.Usuarios;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUsuariosResponseMapper {
    UsuariosResponseDto toUsuarioDto(Usuarios usuarios);

    List<UsuariosResponseDto> toUsuariosListDto( List<Usuarios> usuarios);
}
