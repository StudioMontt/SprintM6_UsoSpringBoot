package cl.awakelab.sprintm6.controller;

import cl.awakelab.sprintm6.entity.Empleador;
import cl.awakelab.sprintm6.entity.Usuario;
import cl.awakelab.sprintm6.service.IUsuarioService;
import cl.awakelab.sprintm6.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {

    @Autowired
    IEmpleadorService objEmpleadorService;
    @Autowired
    IUsuarioService objUsuarioService;

    //MUESTRA EL LISTADO
    @GetMapping
    public String listarEmpleadores(Model model){
        List<Empleador> listaEmpleadores = objEmpleadorService.listarEmpleadores();
        model.addAttribute("empleador", listaEmpleadores);
        return "Employers/listEmployer";
    }

    //MUESTRA FORMULARIO DE GUARDAR
    @GetMapping("/creacion")
    public String mostrarFormularioCrearEmpleador(Model model){
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "Employers/createEmployer";
    }

    //GUARDA Y REDIRIGE AL LISTADO
    @PostMapping("/crearEmpleador")
    public String crearEmpleador(@ModelAttribute Empleador empleadorCrear){
        objEmpleadorService.crearEmpleador(empleadorCrear);
        return "redirect:/empleador";
    }

    //MUESTRA FORMULARIO DE EDITAR
    @GetMapping("/editar/{idEmpleador}")
    public String mostrarFormularioEditarEmpleador(@PathVariable int idEmpleador, Model model){
        Empleador empleadorParaEditar = objEmpleadorService.buscarEmpleadorPorId(idEmpleador);
        model.addAttribute("empleador", empleadorParaEditar);
        return "Employers/editEmployer";
    }

    //ACTUALIZAR Y REDIRIGE A LISTADO
    @PostMapping("/actualizar/{idEmpleador}")
    public String actualizarEmpleador(@ModelAttribute Empleador empleadorActualizar, @PathVariable int idEmpleador){
        objEmpleadorService.actualizarEmpleador(empleadorActualizar, idEmpleador);
        return "redirect:/empleador";
    }

    //ELIMINAR Y REDIRIGIR A LISTADO
    @PostMapping("/eliminar/{idEmpleador}")
    public String eliminarEmpleador(@PathVariable int idEmpleador) {
        objEmpleadorService.eliminarEmpleador(idEmpleador);
        return "redirect:/empleador";
    }
}
