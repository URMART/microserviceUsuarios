package com.pragma.powerup.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuariosResponseDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private String celular;
}
