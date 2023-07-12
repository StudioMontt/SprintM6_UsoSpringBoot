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

    @JoinColumn(name = "id_trabajador")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Trabajador trabajador;

    @Column
    private LocalDate periodo;

    @Column(name = "sueldo_imponible")
    private int sueldoImponible;

    @Column(name = "sueldo_liquido")
    private int sueldoLiquido;

    @JoinColumn(name = "id_inst_salud")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private InstSalud salud;

    @Column(name = "monto_inst_salud")
    private int dctoSalud;

    @JoinColumn(name = "id_inst_prevision")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private InstPrevision prevision;

    @Column(name = "monto_inst_prevision")
    private int dctoPrevision;

    @Column(name = "total_descuento")
    private int totalDescuento;

    @Column(name = "total_haberes")
    private int totalHaberes;

    @Column
    private int anticipo;
}
