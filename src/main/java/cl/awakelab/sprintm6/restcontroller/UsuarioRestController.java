package cl.awakelab.sprintm6.restcontroller;

import cl.awakelab.sprintm6.entity.Perfil;
import cl.awakelab.sprintm6.entity.Usuario;
import cl.awakelab.sprintm6.entity.request.UsuarioRequest;
import cl.awakelab.sprintm6.service.IPerfilService;
import cl.awakelab.sprintm6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {

    @Autowired
    IUsuarioService objUsuarioService;
    @Autowired
    IPerfilService objPerfilService;
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioRequest usuario){
        Perfil perfil= objPerfilService.buscarPerfilPorId(usuario.getPerfil());
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setRun(usuario.getRun());
        usuarioNuevo.setClave(usuario.getClave());
        usuarioNuevo.setNombre(usuario.getNombre());
        usuarioNuevo.setApellido1(usuario.getApellido1());
        usuarioNuevo.setApellido2(usuario.getApellido2());
        usuarioNuevo.setPerfil(perfil);
        usuarioNuevo.setEmail(usuario.getEmail());
        usuarioNuevo.setTelefono(usuarioNuevo.getTelefono());
        objUsuarioService.crearUsuario(usuarioNuevo);
        return ResponseEntity.ok("Usuario creado");
    }
    @GetMapping("/{idUsuario}")
    public Usuario buscarUsuarioPorId(@PathVariable int idUsuario){
        return objUsuarioService.buscarUsuarioPorId(idUsuario);
    }
    @GetMapping
    public List<Usuario> listarUsuarios(){
        return objUsuarioService.listarUsuarios();
    }
    @PutMapping("/{idUsuario}")
    public Usuario actualizarUsuario(@RequestBody Usuario usuarioActualizar, @PathVariable int idUsuario){
        return objUsuarioService.actualizarUsuario(usuarioActualizar,idUsuario);
    }
    @DeleteMapping("/{idUsuario}")
    public void eliminarUsuario(@PathVariable int idUsuario){
        objUsuarioService.eliminarUsuario(idUsuario);
    }
}
