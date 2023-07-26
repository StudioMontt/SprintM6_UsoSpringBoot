package cl.awakelab.sprintm6.restcontroller;

import cl.awakelab.sprintm6.entity.Usuario;
import cl.awakelab.sprintm6.service.IPerfilService;
import cl.awakelab.sprintm6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/api/usuario", headers = "Accept=Application/json")
public class UsuarioRestController {

    @Autowired
    IUsuarioService objUsuarioService;
    @Autowired
    IPerfilService objPerfilService;

    @PostMapping("/crearUsuario")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setRun(usuario.getRun());
        usuarioNuevo.setNombre(usuario.getNombre());
        usuarioNuevo.setApellido1(usuario.getApellido1());
        usuarioNuevo.setApellido2(usuario.getApellido2());
        usuarioNuevo.setEmail(usuario.getEmail());
        usuarioNuevo.setTelefono(usuario.getTelefono());
        usuarioNuevo.setClave(usuario.getClave());
        usuarioNuevo.setPerfil(usuario.getPerfil());
        usuarioNuevo.setFechaCreacion(LocalDateTime.now());
        return objUsuarioService.crearUsuario(usuarioNuevo);
    }

    @PostMapping("/registroUsuario")
    public Usuario registroUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioReg = new Usuario();
        usuarioReg.setRun(usuario.getRun());
        usuarioReg.setNombre(usuario.getNombre());
        usuarioReg.setApellido1(usuario.getApellido1());
        usuarioReg.setClave(usuario.getClave());
        usuarioReg.setEmail(usuario.getEmail());
        usuarioReg.setPerfil(usuario.getPerfil());
        usuarioReg.setFechaCreacion(LocalDateTime.now());
        return objUsuarioService.crearUsuario(usuarioReg);
    }

    @GetMapping("/{idUsuario}")
    public Usuario buscarUsuarioPorId(@PathVariable int idUsuario) {
        return objUsuarioService.buscarUsuarioPorId(idUsuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return objUsuarioService.listarUsuarios();
    }

    @PutMapping("/{idUsuario}")
    public Usuario actualizarUsuario(@RequestBody Usuario usuarioActualizar, @PathVariable int idUsuario) {
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(idUsuario);
        usuario.setRun(usuarioActualizar.getRun());
        usuario.setNombre(usuarioActualizar.getNombre());
        usuario.setApellido1(usuarioActualizar.getApellido1());
        usuario.setApellido2(usuarioActualizar.getApellido2());
        usuario.setEmail(usuarioActualizar.getEmail());
        usuario.setTelefono(usuarioActualizar.getTelefono());
        usuario.setClave(usuarioActualizar.getClave());
        usuario.setPerfil(usuarioActualizar.getPerfil());
        return objUsuarioService.actualizarUsuario(usuario, usuarioActualizar.getIdUsuario());
    }

    @DeleteMapping("/{idUsuario}")
    public void eliminarUsuario(@PathVariable int idUsuario) {
        objUsuarioService.eliminarUsuario(idUsuario);
    }
}
