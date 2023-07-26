package cl.awakelab.sprintm6.service.serviceimpl;

import cl.awakelab.sprintm6.entity.InstSalud;
import cl.awakelab.sprintm6.repository.IInstSaludRepository;
import cl.awakelab.sprintm6.service.IInstSaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service("instSaludImpl")
public class InstSaludImpl implements IInstSaludService {

    @Autowired
    IInstSaludRepository objInstSaludRepo;

    @Override
    public List<InstSalud> listarInstSalud() {
        return objInstSaludRepo.findAll();
    }

    @Override
    public InstSalud crearInstSalud(InstSalud instSalud) {
        return objInstSaludRepo.save(instSalud);
    }

    @Override
    public InstSalud buscarInstSaludPorId(int idInstSalud) {
        return objInstSaludRepo.findById(idInstSalud)
                .orElseThrow(() -> new NoSuchElementException("Institución de Salud no encontrada"));
    }

    @Override
    public InstSalud actualizarInstSalud(InstSalud instSaludActualizar, int idInstSalud) {
        InstSalud instSalud = objInstSaludRepo.findById(idInstSalud)
                .orElseThrow(() -> new NoSuchElementException("Institución de Salud no encontrada"));
        instSalud.setDescripcion(instSaludActualizar.getDescripcion());
        instSalud.setPorcDctoSalud(instSaludActualizar.getPorcDctoSalud());
        return objInstSaludRepo.save(instSalud);
    }

    @Override
    public void eliminarInstSalud(int idInstSalud) {
        objInstSaludRepo.deleteById(idInstSalud);
    }
}
