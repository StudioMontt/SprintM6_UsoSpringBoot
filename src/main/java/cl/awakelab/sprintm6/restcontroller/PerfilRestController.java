package cl.awakelab.sprintm6.restcontroller;

import cl.awakelab.sprintm6.entity.Perfil;
import cl.awakelab.sprintm6.service.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/perfil")
public class PerfilRestController {

    @Autowired
    IPerfilService objPerfilService;

    @PostMapping
    public Perfil crearPerfil(@RequestBody Perfil perfil) {
        return objPerfilService.crearPerfil(perfil);
    }

    @GetMapping("/{idPerfil}")
    public Perfil buscarPerfilPorId(@PathVariable int idPerfil) {
        return objPerfilService.buscarPerfilPorId(idPerfil);
    }

    @GetMapping
    public List<Perfil> listarPerfil() {
        return objPerfilService.listarPerfil();
    }

    @PutMapping("/{idPerfil}")
    public Perfil actualizarPerfil(@RequestBody Perfil perfilActualizar, @PathVariable int idPerfil) {
        return objPerfilService.actualizarPerfil(perfilActualizar, idPerfil);
    }

    @DeleteMapping("/{idPerfil}")
    public void eliminarPerfil(@PathVariable int idPerfil) {
        objPerfilService.eliminarPerfil(idPerfil);
    }
}
