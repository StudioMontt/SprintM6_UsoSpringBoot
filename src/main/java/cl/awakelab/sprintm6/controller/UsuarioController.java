package cl.awakelab.sprintm6.controller;

import cl.awakelab.sprintm6.entity.Usuario;
import cl.awakelab.sprintm6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService objUsuarioService;

    //MUESTRA EL LISTADO
    @GetMapping
    public String listarUsuarios(Model model){
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("usuario", listaUsuarios);
        return "listUsers";
    }

    //MUESTRA FORMULARIO DE GUARDAR
    @GetMapping("/mostrarCrear")
    public String mostrarFormularioCrearUsuario(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "createUser";
    }

    //GUARDA Y REDIRIGE AL LISTADO
    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario){
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/usuario";
    }

    //MUESTRA FORMULARIO DE EDITAR
    @GetMapping("/editar/{idUsuario}")
    public String mostrarFormularioEditarUsuario(@PathVariable int idUsuario, Model model){
        Usuario usuarioParaEditar = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuarioParaEditar);
        return "editUser";
    }

    //ACTUALIZAR Y REDIRIGE A LISTADO
    @PutMapping("/{idUsuario}")
    public String listarUsuarioPorId(@PathVariable int idUsuario, Model model){
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuario);
        return "redirect:/usuario";
    }
/*
    //MUESTRA PAGINA DE ELIMINAR (ES NECESARIO?)
    @GetMapping("/eliminar/{idUsuario}")
    public String mostrarEliminarUsuario(@PathVariable int idUsuario, Model model){
        Usuario usuarioEliminar = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuarioEliminar);
        return "eliminarUsuario";
    }

    //ELIMINAR Y REDIRIGIR A LISTADO
    @RequestMapping(value = "/{idUsuario}", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String eliminarUsuario(@PathVariable("idUsuario") int idUsuario){
        objUsuarioService.eliminarUsuario(idUsuario);
        return "redirect:/usuario";
    }*/
}
