package com.pragma.powerup.application.handler.impl;


import com.pragma.powerup.application.dto.request.RolRequestDto;
import com.pragma.powerup.application.dto.request.UsuariosRequestDto;
import com.pragma.powerup.application.dto.response.UsuariosResponseDto;

import com.pragma.powerup.application.handler.interfac.IUsuariosHandler;
import com.pragma.powerup.application.mapper.roles.IRolRequestMapper;
import com.pragma.powerup.application.mapper.usuarios.IUsuariosRequestMapper;
import com.pragma.powerup.application.mapper.usuarios.IUsuariosResponseMapper;
import com.pragma.powerup.domain.api.IUsuariosServicePort;


import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UsuariosHandler implements IUsuariosHandler {

    private final IUsuariosServicePort usuariosServicePort;
    private final IUsuariosRequestMapper usuariosRequestMapper;
    private final IUsuariosResponseMapper usuariosResponseMapper;

    private final PasswordEncoder passwordEncoder;


    @Override
    public void saveUsuario(UsuariosRequestDto usuariosRequestDto) {
        usuariosServicePort.saveUsuario(usuariosRequestMapper.toUsuarios(usuariosRequestDto));
    }

    @Override
    public List<UsuariosResponseDto> getAllUsuarios() {
        return usuariosResponseMapper.toUsuariosListDto(usuariosServicePort.findAll());
    }

    @Override
    public UsuariosResponseDto getUsuarioById(Long id) {
        return usuariosResponseMapper.toUsuarioDto(usuariosServicePort.findById(id));
    }

    @Override
    public UsuariosResponseDto findByEmail(String email) {
        return usuariosResponseMapper.toUsuarioDto(usuariosServicePort.findByEmail(email));
    }
}