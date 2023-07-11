package com.awakelab.sprintm6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "liquidacion")
public class Liquidacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_liquidacion")
    private int idLiquidacion;
    @Column(name = "id_trabajador")
    private int idTrabajador;
    @Column
    private LocalDate periodo;
    @Column(name = "sueldo_imponible")
    private int sueldoImponible;
    @Column(name = "sueldo_liquido")
    private int sueldoLiquido;
    @Column(name = "id_inst_salud")
    private int idSalud;
    @Column(name = "monto_inst_salud")
    private int dctoSalud;
    @Column(name = "id_inst_prevision")
    private int idPrevision;
    @Column(name = "monto_inst_prevision")
    private int dctoPrevision;
    @Column(name = "total_descuento")
    private int totalDescuento;
    @Column(name = "total_haberes")
    private int totalHaberes;
    @Column
    private int anticipo;
}
