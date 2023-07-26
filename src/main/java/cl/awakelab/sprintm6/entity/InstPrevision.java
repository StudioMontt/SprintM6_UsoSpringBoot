package cl.awakelab.sprintm6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(length = 50, nullable = false)
    private String descripcion;

    @Column(name = "porc_dcto", nullable = false)
    private float porcDctoPrev;

    @JsonIgnore
    @OneToMany(mappedBy = "prevision", fetch = FetchType.LAZY)
    private List<Trabajador> listTrabajadores;

    @JsonIgnore
    @OneToMany(mappedBy = "prevision", fetch = FetchType.LAZY)
    private List<Liquidacion> listLiquidaciones;
}
