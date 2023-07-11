package com.awakelab.sprintm6.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "trabajador")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trabajador")
    private int idTrabajador;
    @Column
    private int run;
    @Column
    private String nombre;
    @Column(name = "apellido_1")
    private String apellido1;
    @Column(name = "apellido_2")
    private String apellido2;
    @Column
    private String email;
    @Column(name = "id_prevision")
    private int idPrevision;
    @Column(name = "id_salud")
    private int idSalud;
    @Column
    private int telefono;

}
