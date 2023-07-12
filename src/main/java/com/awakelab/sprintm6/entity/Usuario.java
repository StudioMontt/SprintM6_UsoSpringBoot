package com.awakelab.sprintm6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

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

    @JoinColumn(name = "id_perfil")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Perfil perfil;

    @Column
    private String email;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column
    private int telefono;

    @OneToMany(mappedBy = "usuario")
    private List<Empleador> listaEmpleadores;
}
