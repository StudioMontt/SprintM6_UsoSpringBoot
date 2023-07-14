package cl.awakelab.sprintm6.service;

import cl.awakelab.sprintm6.entity.InstSalud;
import java.util.List;

public interface IInstSaludService {
    List<InstSalud> listarInstSalud();
    InstSalud crearInstSalud(InstSalud instSalud);
    InstSalud buscarInstSaludPorId(int idInstSalud);
    InstSalud actualizarInstSalud(InstSalud instSalud, int idInstSalud);
    void eliminarInstSalud(int idInstSalud);
}
