package cl.awakelab.sprintm6.controller;

import cl.awakelab.sprintm6.entity.Usuario;
import cl.awakelab.sprintm6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/inicio")
public class UsuarioController {

    @Autowired
    IUsuarioService objUsuarioService;
    @PostMapping("/registrarse")
    public String crearUsuario(@ModelAttribute Usuario usuario){
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/usuario";
    }
    @GetMapping("/registrarse")
    public String mostrarFormularioCrearUsuario(Model model){
        return "registrarse";
    }
    @GetMapping("/{idUsuario}")
    public String listarUsuarioPorId(@PathVariable int idUsuario, Model model){
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuario);
        return "usuario";
    }
    @GetMapping
    public String listarUsuarios(Model model){
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("usuario", listaUsuarios);
        return "listarUsuarios";
    }
    @GetMapping("/{idUsuario}/editar")
    public String mostrarFormularioEditarUsuario(@PathVariable int idUsuario, Model model){
        Usuario usuarioParaEditar = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuarioParaEditar);
        return "editarUsuario";
    }

    @GetMapping("/{idUsuario}/eliminar")
    public String mostrarEliminarUsuario(@PathVariable int idUsuario, Model model){
        Usuario usuarioEliminar = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuarioEliminar);
        return "eliminarUsuario";
    }

    @DeleteMapping("/{idUsuario}")
    public String eliminarUsuario(@PathVariable int idUsuario){
        objUsuarioService.eliminarUsuario(idUsuario);
        return "redirect: /usuario";
    }
}
