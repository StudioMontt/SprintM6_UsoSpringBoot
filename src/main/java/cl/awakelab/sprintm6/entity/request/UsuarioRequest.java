package cl.awakelab.sprintm6.entity.request;

import cl.awakelab.sprintm6.entity.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UsuarioRequest {
    private int idUsuario;

    private int run;

    private String clave;

    private int perfil;

    private String nombre;

    private String apellido1;

    private String apellido2;

    private String email;

    private LocalDateTime fechaCreacion;

    private int telefono;
}
