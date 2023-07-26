package cl.awakelab.sprintm6.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "liquidacion")
public class Liquidacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_liquidacion", nullable = false)
    private int idLiquidacion;

    @JoinColumn(name = "id_trabajador", nullable = false)
    @ManyToOne
    @ToString.Exclude
    private Trabajador trabajador;

    @Column(nullable = false)
    private LocalDate periodo;

    @Column(name = "sueldo_imponible", nullable = false)
    private int sueldoImponible;

    @Column(name = "sueldo_liquido", nullable = false)
    private int sueldoLiquido;

    @JoinColumn(name = "id_inst_salud", nullable = false)
    @ManyToOne
    @ToString.Exclude
    private InstSalud salud;

    @Column(name = "monto_inst_salud", nullable = false)
    private int dctoSalud;

    @JoinColumn(name = "id_inst_prevision", nullable = false)
    @ManyToOne
    @ToString.Exclude
    private InstPrevision prevision;

    @Column(name = "monto_inst_prevision", nullable = false)
    private int dctoPrevision;

    @Column(name = "total_descuento", nullable = false)
    private int totalDescuento;

    @Column(name = "total_haberes", nullable = false)
    private int totalHaberes;

    @Column(nullable = false)
    private int anticipo;
}
