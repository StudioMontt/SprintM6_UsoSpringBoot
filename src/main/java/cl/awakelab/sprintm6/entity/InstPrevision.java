package cl.awakelab.sprintm6.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "institucion_prevision")
public class InstPrevision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_int_prevision")
    private int idPrevision;

    @Column
    private String descripcion;

    @Column(name = "porc_dcto")
    private float porcDctoPrev;

    @OneToMany(mappedBy = "prevision")
    private List<Trabajador> listTrabajadores;

    @OneToMany(mappedBy = "prevision")
    private List<Liquidacion> listLiquidaciones;
}
