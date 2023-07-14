package cl.awakelab.sprintm6.service.serviceimpl;

import cl.awakelab.sprintm6.entity.Perfil;
import cl.awakelab.sprintm6.repository.IPerfilRepository;
import cl.awakelab.sprintm6.service.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service("perfilImpl")
public class PerfilImpl implements IPerfilService {

    @Autowired
    IPerfilRepository objPerfilRepo;

    @Override
    public List<Perfil> listarPerfil() {
        return objPerfilRepo.findAll();
    }

    @Override
    public Perfil crearPerfil(Perfil perfil) {
        return objPerfilRepo.save(perfil);
    }

    @Override
    public Perfil buscarPerfilPorId(int idPerfil) {
        return objPerfilRepo.findById(idPerfil).orElseThrow(() -> new NoSuchElementException("Perfil no encontrado"));
    }

    @Override
    public Perfil actualizarPerfil(Perfil perfilActualizar, int idPerfil) {
        Perfil perfil = objPerfilRepo.findById(idPerfil).orElseThrow(() -> new NoSuchElementException("Perfil no encontrado"));
        perfil.setDescripcion(perfilActualizar.getDescripcion());
        perfil.setEstado(perfilActualizar.getEstado());
        return objPerfilRepo.save(perfil);
    }

    @Override
    public void eliminarPerfil(int idPerfil) {
        objPerfilRepo.deleteById(idPerfil);
    }
}
