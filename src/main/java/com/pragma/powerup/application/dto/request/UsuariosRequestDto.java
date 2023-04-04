package com.pragma.powerup.application.dto.request;

import com.pragma.powerup.domain.model.Roles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuariosRequestDto {
    private Long id;
    private String nombre;
    private String apellido;
    private Long documentoIdentidad;
    private String celular;
    private String email;
    private String clave;


    private Roles rol;
}
