package cl.awakelab.sprintm6.service;

import cl.awakelab.sprintm6.entity.Trabajador;

import java.util.List;

public interface ITrabajadorService {
    List<Trabajador> listarTrabajador();
    Trabajador crearTrabajador(Trabajador trabajador);
    Trabajador buscarTrabajadorPorId(int idTrabajador);
    Trabajador actualizarTrabajador(Trabajador trabajador, int idTrabajador);
    void eliminarTrabajador(int idTrabajador);
}
