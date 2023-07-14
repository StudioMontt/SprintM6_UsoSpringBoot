package cl.awakelab.sprintm6.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private int idPerfil;

    @Column
    private String descripcion;

    @Column
    private boolean estado;

    public boolean getEstado() {
        return estado;
    }

    @OneToMany(mappedBy = "perfil")
    private List<Usuario> listaUsuarios;
}
