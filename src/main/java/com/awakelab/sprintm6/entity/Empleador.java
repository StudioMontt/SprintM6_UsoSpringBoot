package com.awakelab.sprintm6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "empleador")
public class Empleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleador")
    private int idEmpleador;

    @Column
    private int run;

    @Column
    private String nombre;

    @Column(name = "apellido_1")
    private String apellido1;

    @Column(name = "apellido_2")
    private String apellido2;

    @Column
    private String direccion;

    @Column
    private String email;

    @JoinColumn(name = "id_usuario")
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;

    @Column
    private int telefono;

    @ManyToMany(mappedBy = "listaEmpleadores")
    private List<Trabajador> listaTrabajadores;
}
