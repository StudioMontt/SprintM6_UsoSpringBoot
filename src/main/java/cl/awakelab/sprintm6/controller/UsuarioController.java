package cl.awakelab.sprintm6.controller;

import cl.awakelab.sprintm6.entity.Usuario;
import cl.awakelab.sprintm6.service.IPerfilService;
import cl.awakelab.sprintm6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService objUsuarioService;
    @Autowired
    IPerfilService objPerfilService;

    // MUESTRA EL LISTADO
    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("usuario", listaUsuarios);
        return "Users/listUsers";
    }

    // MUESTRA FORMULARIO DE GUARDAR
    @GetMapping("/creacion")
    public String mostrarFormularioCrearUsuario(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "Users/createUser";
    }

    // GUARDA Y REDIRIGE AL LISTADO

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuarioCrear) {
        usuarioCrear.setFechaCreacion(LocalDateTime.now());
        objUsuarioService.crearUsuario(usuarioCrear);
        return "redirect:/usuario";
    }

    // MUESTRA FORMULARIO DE REGISTRAR
    @GetMapping("/registro")
    public String mostrarFormularioRegistroUsuario(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "registration";
    }

    // REGISTRA Y REDIRIGE A LA BIENVENIDA
    @PostMapping("/registroUsuario")
    public String registrarUsuario(@ModelAttribute Usuario usuarioReg) {
        usuarioReg.setFechaCreacion(LocalDateTime.now());
        objUsuarioService.crearUsuario(usuarioReg);
        return "redirect:/welcome";
    }

    // MUESTRA FORMULARIO DE EDITAR
    @GetMapping("/editar/{idUsuario}")
    public String mostrarFormularioEditarUsuario(@PathVariable int idUsuario, Model model) {
        Usuario usuarioParaEditar = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuarioParaEditar);
        return "Users/editUser";
    }

    // ACTUALIZAR Y REDIRIGE A LISTADO
    @PostMapping("/actualizar/{idUsuario}")
    public String actualizarUsuario(@ModelAttribute Usuario usuarioActualizar, @PathVariable int idUsuario) {
        objUsuarioService.actualizarUsuario(usuarioActualizar, idUsuario);
        return "redirect:/usuario";
    }

    // ELIMINAR Y REDIRIGIR A LISTADO
    @PostMapping("/eliminar/{idUsuario}")
    public String eliminarUsuario(@PathVariable int idUsuario, RedirectAttributes redirectAttributes) {

        objUsuarioService.eliminarUsuario(idUsuario);
        return "redirect:/usuario";
    }
}
