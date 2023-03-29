package com.pragma.powerup.infrastructure.input.rest;


import com.pragma.powerup.application.dto.request.RolRequestDto;
import com.pragma.powerup.application.dto.request.UsuariosRequestDto;

import com.pragma.powerup.application.dto.response.RolResponseDto;
import com.pragma.powerup.application.dto.response.UsuariosResponseDto;

import com.pragma.powerup.application.handler.interfac.IRolHandler;
import com.pragma.powerup.application.handler.interfac.IUsuariosHandler;
import com.pragma.powerup.application.mapper.roles.IRolRequestMapper;
import com.pragma.powerup.application.mapper.roles.IRolResponseMapper;
import com.pragma.powerup.domain.model.Roles;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UsuariosRestController {

    private final IUsuariosHandler usuariosHandler;
    private final IRolHandler rolHandler;
    private final IRolResponseMapper rolResponseMapper;
    private final IRolRequestMapper rolRequestMapper;
    private final PasswordEncoder passwordEncoder;

    @Operation(summary = "añadir un nuevo usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping("/auth/admin")
    public ResponseEntity<Void> saveObject(@Valid @RequestBody UsuariosRequestDto usuariosRequestDto) {

        RolResponseDto buscarRol = rolHandler.findByNombre("Propietario");
        if(buscarRol!=null) {

            usuariosRequestDto.setRol(rolResponseMapper.toRoles(buscarRol));
            usuariosRequestDto.setClave(passwordEncoder.encode(usuariosRequestDto.getClave()));
            usuariosHandler.saveUsuario(usuariosRequestDto);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        Roles rol = new Roles ();
        rol.setNombre("Propietario");
        rol.setDescripcion("gestion de platos y empleados ");

        rolHandler.saveRol(rolRequestMapper.toRolDto(rol));

        usuariosRequestDto.setRol(rol);
        usuariosRequestDto.setClave(passwordEncoder.encode(usuariosRequestDto.getClave()));
        usuariosHandler.saveUsuario(usuariosRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "añadir un nuevo rol")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping("/rol")
    public ResponseEntity<Void> saveObject(@RequestBody RolRequestDto rolRequestDto) {
        rolHandler.saveRol(rolRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @Operation(summary = "obtener todos los usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All objects returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UsuariosResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/auth/admin")
    public ResponseEntity<List<UsuariosResponseDto>> getAllUsuarios() {
        return ResponseEntity.ok(usuariosHandler.getAllUsuarios());
    }

    @GetMapping("/{nombre}/auth/admin")
    public RolResponseDto buscarPorNombre(@PathVariable String nombre) {
        return rolHandler.findByNombre(nombre);
    }


}