package cl.awakelab.sprintm6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @JoinColumn(name = "id_inst_prevision")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private InstPrevision prevision;

    @JoinColumn(name = "id_inst_salud")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private InstSalud salud;

    @Column
    private int telefono;

    @OneToMany(mappedBy = "trabajador")
    private List<Liquidacion> listaLiquidaciones;

    @ManyToMany
    @JoinTable(name = "empl_trab",
            joinColumns = @JoinColumn(name = "id_trabajador", nullable=false),
            inverseJoinColumns = @JoinColumn(name = "id_empleador", nullable = false))
    private List<Empleador> listaEmpleadores;

}
