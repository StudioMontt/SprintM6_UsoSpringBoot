package cl.awakelab.sprintm6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "institucion_salud")
public class InstSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_int_salud")
    private int idSalud;

    @Column
    private String descripcion;

    @Column(name = "porc_dcto")
    private float porcDctoSalud;

    @OneToMany(mappedBy = "salud")
    private List<Trabajador> listTrabajadores;

    @OneToMany(mappedBy = "salud")
    private List<Liquidacion> listLiquidaciones;

}
