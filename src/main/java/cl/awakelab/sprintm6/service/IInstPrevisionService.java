package cl.awakelab.sprintm6.service;

import cl.awakelab.sprintm6.entity.InstPrevision;
import java.util.List;

public interface IInstPrevisionService {
    List<InstPrevision> listarInstPrevision();
    InstPrevision crearInstPrevision(InstPrevision instPrevision);
    InstPrevision buscarInstPrevisionPorId(int idInstPrevision);
    InstPrevision actualizarInstPrevision(InstPrevision instPrevision, int idInstPrevision);
    void eliminarInstPrevision(int idInstPrevision);
}