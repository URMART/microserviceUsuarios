package com.pragma.powerup.application.handler.interfac;


import com.pragma.powerup.application.dto.request.RolRequestDto;
import com.pragma.powerup.application.dto.request.UsuariosRequestDto;
import com.pragma.powerup.application.dto.response.UsuariosResponseDto;

import java.util.List;

public interface IUsuariosHandler {

    void saveUsuario(UsuariosRequestDto usuariosRequestDto);

    List<UsuariosResponseDto> getAllUsuarios();

    UsuariosResponseDto getUsuarioById(Long id);

    UsuariosResponseDto findByEmail(String email);
}