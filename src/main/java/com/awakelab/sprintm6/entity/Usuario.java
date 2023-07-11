package com.awakelab.sprintm6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;
    @Column
    private int run;
    @Column
    private String nombre;
    @Column(name = "apellido_1")
    private String apellido1;
    @Column(name = "apellido_2")
    private String apellido2;
    @Column(name = "id_perfil")
    private int idPerfil;
    @Column
    private String email;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @Column
    private int telefono;
}
