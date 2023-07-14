package cl.awakelab.sprintm6.service;

import cl.awakelab.sprintm6.entity.Perfil;
import java.util.List;

public interface IPerfilService {
    List<Perfil> listarPerfil();
    Perfil crearPerfil(Perfil perfil);
    Perfil buscarPerfilPorId(int idPerfil);
    Perfil actualizarPerfil(Perfil perfil, int idPerfil);
    void eliminarPerfil(int idPerfil);
}
