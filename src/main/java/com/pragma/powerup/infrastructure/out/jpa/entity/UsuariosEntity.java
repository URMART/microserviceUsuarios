package com.pragma.powerup.infrastructure.out.jpa.entity;


import com.pragma.powerup.domain.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuariosEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column( nullable = false)
    private Integer id;

    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotNull
    @Column(name = "documento_identidad")
    private Long documentoIdentidad;
    @NotNull
    @Column(length = 13)
    @Pattern(regexp="^\\+?[\\d]{1,13}$", message="El teléfono debe tener un máximo de 13 caracteres y puede contener " +
            "el símbolo '+'")
    private String celular;
    @NotEmpty(message = "el correo no debe estar vacio")
    @Email(message = "El correo electrónico no es válido")
    private String email;
    private String clave;

    @ManyToOne
    private RolEntity rol;

}
