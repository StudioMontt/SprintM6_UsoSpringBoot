package cl.awakelab.sprintm6.restcontroller;

import cl.awakelab.sprintm6.entity.Perfil;
import cl.awakelab.sprintm6.entity.Usuario;
import cl.awakelab.sprintm6.entity.request.UsuarioRequest;
import cl.awakelab.sprintm6.service.IPerfilService;
import cl.awakelab.sprintm6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
        Integer perfil = Integer.parseInt(String.valueOf(usuario.getPerfil()));
        Perfil perfilObj= objPerfilService.buscarPerfilPorId(usuario.getPerfil());
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setRun(usuario.getRun());
        usuarioNuevo.setClave(usuario.getClave());
        usuarioNuevo.setNombre(usuario.getNombre());
        usuarioNuevo.setApellido1(usuario.getApellido1());
        usuarioNuevo.setApellido2(usuario.getApellido2());
        usuarioNuevo.setPerfil(perfilObj);
        usuarioNuevo.setEmail(usuario.getEmail());
/*
        usuarioNuevo.setFechaCreacion(LocalDateTime.now());
*/
        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime fechaActualConZonaHoraria = fechaActual.atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss");
        String fechaActualFormateada = fechaActualConZonaHoraria.format(formatter);
        usuarioNuevo.setFechaCreacion(LocalDateTime.parse(fechaActualFormateada));

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

    /*    @PutMapping("/{idUsuario}")
        public Usuario actualizarUsuario(@RequestBody Usuario usuarioActualizar, @PathVariable int idUsuario){
            return objUsuarioService.actualizarUsuario(usuarioActualizar,idUsuario);
        }
    */
    @PutMapping("/{idUsuario}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable int idUsuario, @RequestBody UsuarioRequest usuario){
        Integer perfil = Integer.parseInt(String.valueOf(usuario.getPerfil()));
        Perfil perfilObj= objPerfilService.buscarPerfilPorId(usuario.getPerfil());
        Usuario usuarioActualizar = new Usuario();
        usuarioActualizar.setIdUsuario(idUsuario);
        usuarioActualizar.setRun(usuario.getRun());
        usuarioActualizar.setClave(usuario.getClave());
        usuarioActualizar.setNombre(usuario.getNombre());
        usuarioActualizar.setApellido1(usuario.getApellido1());
        usuarioActualizar.setApellido2(usuario.getApellido2());
        usuarioActualizar.setPerfil(perfilObj);
        usuarioActualizar.setEmail(usuario.getEmail());
        usuarioActualizar.setTelefono(usuario.getTelefono());
        objUsuarioService.actualizarUsuario(usuarioActualizar, usuarioActualizar.getIdUsuario());
        return ResponseEntity.ok("Usuario actualizado");
    }

    @DeleteMapping("/{idUsuario}")
    public void eliminarUsuario(@PathVariable int idUsuario){
        objUsuarioService.eliminarUsuario(idUsuario);
    }
}
