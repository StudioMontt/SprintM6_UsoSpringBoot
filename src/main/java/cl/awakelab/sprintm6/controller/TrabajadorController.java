package cl.awakelab.sprintm6.controller;

import cl.awakelab.sprintm6.entity.Empleador;
import cl.awakelab.sprintm6.entity.InstPrevision;
import cl.awakelab.sprintm6.entity.InstSalud;
import cl.awakelab.sprintm6.entity.Trabajador;
import cl.awakelab.sprintm6.service.IEmpleadorService;
import cl.awakelab.sprintm6.service.IInstPrevisionService;
import cl.awakelab.sprintm6.service.IInstSaludService;
import cl.awakelab.sprintm6.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {

    @Autowired
    ITrabajadorService objTrabajadorService;
    @Autowired
    private IEmpleadorService objEmpleadorService;
    @Autowired
    IInstPrevisionService objPrevisionService;
    @Autowired
    IInstSaludService objSaludService;

    // MUESTRA EL LISTADO
    @GetMapping
    public String listarTrabajadores(Model model) {
        List<Trabajador> listaTrabajadores = objTrabajadorService.listarTrabajador();
        model.addAttribute("trabajador", listaTrabajadores);
        return "Workers/listWorker";
    }

    // MUESTRA FORMULARIO DE GUARDAR
    @GetMapping("/creacion")
    public String mostrarFormularioCrearTrabajador(Model model) {
        List<Empleador> listaEmpleadores = objEmpleadorService.listarEmpleadores();
        model.addAttribute("listaEmpleadores", listaEmpleadores);
        List<InstPrevision> listaPrevision = objPrevisionService.listarInstPrevision();
        model.addAttribute("listaPrevision", listaPrevision);
        List<InstSalud> listaSalud = objSaludService.listarInstSalud();
        model.addAttribute("listaSalud", listaSalud);
        return "Workers/createWorker";
    }

    // GUARDA Y REDIRIGE AL LISTADO
    @PostMapping("/crearTrabajador")
    public String crearTrabajador(@ModelAttribute Trabajador trabajadorCrear, @RequestParam("empleadores") List<Integer> idsEmpleadores) {
        List<Empleador> empleadores = new ArrayList<>();
        for (Integer idEmpleador : idsEmpleadores) {
            Empleador empleador = objEmpleadorService.buscarEmpleadorPorId(idEmpleador);
            empleadores.add(empleador);
        }
        trabajadorCrear.setListaEmpleadores(empleadores);
        objTrabajadorService.crearTrabajador(trabajadorCrear);
        return "redirect:/trabajador";
    }

    // MUESTRA FORMULARIO DE EDITAR
    @GetMapping("/editar/{idTrabajador}")
    public String mostrarFormularioEditarTrabajador(@PathVariable int idTrabajador, Model model) {
        Trabajador trabajadorParaEditar = objTrabajadorService.buscarTrabajadorPorId(idTrabajador);
        model.addAttribute("trabajador", trabajadorParaEditar);
        List<Empleador> listaEmpleadores = objEmpleadorService.listarEmpleadores();
        List<Integer> idsEmpleadoresDesigandos = new ArrayList<>();
        for (Empleador empleador : trabajadorParaEditar.getListaEmpleadores()) {
            idsEmpleadoresDesigandos.add(empleador.getIdEmpleador());
        }
        model.addAttribute("listaEmpleadores", listaEmpleadores);
        model.addAttribute("idsEmpleadores", idsEmpleadoresDesigandos);
        List<InstPrevision> listaPrevision = objPrevisionService.listarInstPrevision();
        model.addAttribute("listaPrevision", listaPrevision);
        List<InstSalud> listaSalud = objSaludService.listarInstSalud();
        model.addAttribute("listaSalud", listaSalud);

        return "Workers/editWorker";
    }

    // ACTUALIZAR Y REDIRIGE A LISTADO
    @PostMapping("/actualizar/{idTrabajador}")
    public String actualizarTrabajador(@ModelAttribute Trabajador trabajadorEditar, @PathVariable int idTrabajador, @RequestParam("empleadores") List<Integer> idsEmpleadores) {
        List<Empleador> empleadores = new ArrayList<>();
        for (Integer idEmpleador : idsEmpleadores) {
            Empleador empleador = objEmpleadorService.buscarEmpleadorPorId(idEmpleador);
            empleadores.add(empleador);
        }
        trabajadorEditar.setListaEmpleadores(empleadores);
        trabajadorEditar.setIdTrabajador(idTrabajador);
        objTrabajadorService.actualizarTrabajador(trabajadorEditar, idTrabajador);
        return "redirect:/trabajador";
    }

    // ELIMINAR Y REDIRIGIR A LISTADO
    @PostMapping("/eliminar/{idTrabajador}")
    public String eliminarTrabajador(@PathVariable int idTrabajador) {
        objTrabajadorService.eliminarTrabajador(idTrabajador);
        return "redirect:/trabajador";
    }
}
