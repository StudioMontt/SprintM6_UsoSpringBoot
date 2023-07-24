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

    @Column(unique = true, nullable = true)
    private int run;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(name = "apellido_1", length = 100, nullable = false)
    private String apellido1;

    @Column(name = "apellido_2", length = 100)
    private String apellido2;

    @Column(length = 100)
    private String email;

    @JoinColumn(name = "id_inst_prevision")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private InstPrevision prevision;

    @JoinColumn(name = "id_inst_salud")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private InstSalud salud;

    @Column(nullable = false)
    private long telefono;

    @OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL)
    private List<Liquidacion> listaLiquidaciones;

    @ManyToMany
    @JoinTable(name = "empl_trab",
            joinColumns = @JoinColumn(name = "id_trabajador", nullable=false),
            inverseJoinColumns = @JoinColumn(name = "id_empleador", nullable = false))
    private List<Empleador> listaEmpleadores;

}
