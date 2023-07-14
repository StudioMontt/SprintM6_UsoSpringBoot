package cl.awakelab.sprintm6.service.serviceimpl;

import cl.awakelab.sprintm6.entity.Usuario;
import cl.awakelab.sprintm6.repository.IUsuarioRepository;
import cl.awakelab.sprintm6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("usuarioImpl")
public class UsuarioImpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository objUsuarioRepo;
    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return objUsuarioRepo.save(usuario);
    }
    @Override
    public List<Usuario> listarUsuarios() {
        return objUsuarioRepo.findAll();
    }
    @Override
    public Usuario buscarUsuarioPorId(int idUsuario) {
        return objUsuarioRepo.findById(idUsuario).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
    }
    @Override
    public Usuario actualizarUsuario(Usuario usuarioActualizar, int idUsuario) {
        Usuario usuario = objUsuarioRepo.findById(idUsuario).orElseThrow(()->new NoSuchElementException("Usuario no encontrado"));
        usuario.setRun(usuarioActualizar.getRun());
        usuario.setClave(usuarioActualizar.getClave());
        usuario.setNombre(usuarioActualizar.getNombre());
        usuario.setApellido1(usuarioActualizar.getApellido1());
        usuario.setApellido2(usuarioActualizar.getApellido2());
        usuario.setPerfil(usuarioActualizar.getPerfil());
        usuario.setEmail(usuarioActualizar.getEmail());
        usuario.setTelefono(usuarioActualizar.getTelefono());
        return objUsuarioRepo.save(usuario);
    }
    @Override
    public void eliminarUsuario(int idUsuario) {
        objUsuarioRepo.deleteById(idUsuario);
    }
}
