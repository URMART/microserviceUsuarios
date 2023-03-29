package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.Usuarios;
import com.pragma.powerup.infrastructure.out.jpa.entity.UsuariosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IUsuariosEntityMapper {

    UsuariosEntity toEntity(Usuarios user);

    Usuarios toUsuariosModel(UsuariosEntity  usuariosEntity);

    List<Usuarios> toUsuariosModelList(List<UsuariosEntity> userEntityList);
}
