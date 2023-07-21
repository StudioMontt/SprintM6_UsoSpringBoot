package cl.awakelab.sprintm6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "empleador")
public class Empleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleador", nullable = false)
    private int idEmpleador;

    @Column(unique = true, nullable = false)
    private int run;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(name = "apellido_1", length = 100, nullable = false)
    private String apellido1;

    @Column(name = "apellido_2", length = 100)
    private String apellido2;

    @Column
    private String direccion;

    @Column(length = 100)
    private String email;

    @JoinColumn(name = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;

    @Column
    private long telefono;

    @ManyToMany(mappedBy = "listaEmpleadores")
    private List<Trabajador> listaTrabajadores;
}
