package cl.awakelab.sprintm6.service.serviceimpl;

import cl.awakelab.sprintm6.entity.InstPrevision;
import cl.awakelab.sprintm6.repository.IInstPrevisionRepository;
import cl.awakelab.sprintm6.service.IInstPrevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service("instPrevisionImpl")
public class InstPrevisionImpl implements IInstPrevisionService {

    @Autowired
    IInstPrevisionRepository objInstPrevisionRepo;

    @Override
    public List<InstPrevision> listarInstPrevision() {
        return objInstPrevisionRepo.findAll();
    }

    @Override
    public InstPrevision crearInstPrevision(InstPrevision instPrevision) {
        return objInstPrevisionRepo.save(instPrevision);
    }

    @Override
    public InstPrevision buscarInstPrevisionPorId(int idInstPrevision) {
        return objInstPrevisionRepo.findById(idInstPrevision).orElseThrow(() -> new NoSuchElementException("Institución de Previsión no encontrada"));
    }

    @Override
    public InstPrevision actualizarInstPrevision(InstPrevision instPrevisionActualizar, int idInstPrevision) {
        InstPrevision instPrevision = objInstPrevisionRepo.findById(idInstPrevision).orElseThrow(() -> new NoSuchElementException("Institución de Previsión no encontrada"));
        instPrevision.setDescripcion(instPrevisionActualizar.getDescripcion());
        instPrevision.setPorcDctoPrev(instPrevisionActualizar.getPorcDctoPrev());
        return objInstPrevisionRepo.save(instPrevision);
    }

    @Override
    public void eliminarInstPrevision(int idInstPrevision) {
        objInstPrevisionRepo.deleteById(idInstPrevision);
    }
}
