package com.pragma.powerup.application.mapper.roles;

import com.pragma.powerup.application.dto.response.RolResponseDto;
import com.pragma.powerup.domain.model.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRolResponseMapper {
    RolResponseDto toRolResponseDto(Roles rol);

    Roles toRoles(RolResponseDto rolResponseDto);
}
