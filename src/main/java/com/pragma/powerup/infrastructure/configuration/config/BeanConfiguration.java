package com.pragma.powerup.infrastructure.configuration.config;

import com.pragma.powerup.domain.api.IRolesServicePort;
import com.pragma.powerup.domain.api.IUsuariosServicePort;
import com.pragma.powerup.domain.spi.IRolesPersistencePort;
import com.pragma.powerup.domain.spi.IUsuariosPersistencePort;
import com.pragma.powerup.domain.usecase.RolesUseCase;
import com.pragma.powerup.domain.usecase.UsuariosUseCase;
import com.pragma.powerup.infrastructure.out.jpa.adapter.RolesJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.adapter.UsuariosJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IRolEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IUsuariosEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRolRepository;
import com.pragma.powerup.infrastructure.out.jpa.repository.IUsuariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration  {
    private final IUsuariosRepository usuariosRepository;
    private final IUsuariosEntityMapper usuariosEntityMapper;

    private final IRolRepository rolRepository;
    private final IRolEntityMapper rolEntityMapper;

    @Bean
    public IUsuariosPersistencePort usuariosPersistencePort() {
        return new UsuariosJpaAdapter(usuariosRepository, usuariosEntityMapper);
    }

    @Bean
    public IUsuariosServicePort usuariosServicePort() {
        return new UsuariosUseCase(usuariosPersistencePort());
    }

    @Bean
    public IRolesPersistencePort rolesPersistencePort() {
        return new RolesJpaAdapter(rolRepository, rolEntityMapper);
    }
    @Bean
    public IRolesServicePort rolesServicePort() {
        return new RolesUseCase(rolesPersistencePort());
    }

}