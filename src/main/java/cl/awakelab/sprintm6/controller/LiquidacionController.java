package cl.awakelab.sprintm6.controller;

import cl.awakelab.sprintm6.entity.InstPrevision;
import cl.awakelab.sprintm6.entity.InstSalud;
import cl.awakelab.sprintm6.entity.Liquidacion;
import cl.awakelab.sprintm6.entity.Trabajador;
import cl.awakelab.sprintm6.service.IInstSaludService;
import cl.awakelab.sprintm6.service.ILiquidacionService;
import cl.awakelab.sprintm6.service.IInstPrevisionService;
import cl.awakelab.sprintm6.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/liquidacion")
public class LiquidacionController {

    @Autowired
    ILiquidacionService objLiquidacionService;
    @Autowired
    ITrabajadorService objTrabajadorService;
    @Autowired
    IInstPrevisionService objPrevisionService;
    @Autowired
    IInstSaludService objSaludService;

    // MUESTRA EL LISTADO
    @GetMapping
    public String listarLiquidaciones(Model model) {
        List<Liquidacion> listaLiquidaciones = objLiquidacionService.listarLiquidacion();
        model.addAttribute("liquidaciones", listaLiquidaciones);
        List<Trabajador> listaTrabajadores = objTrabajadorService.listarTrabajador();
        model.addAttribute("trabajadores", listaTrabajadores);
        List<InstPrevision> listaPrevision = objPrevisionService.listarInstPrevision();
        model.addAttribute("listaAFP", listaPrevision);
        List<InstSalud> listaSalud = objSaludService.listarInstSalud();
        model.addAttribute("listaSalud", listaSalud);
        return "Paycheck/listPaycheck";
    }

    // MUESTRA FORMULARIO DE CREAR
    @GetMapping("/creacion")
    public String mostrarFormularioCrearLiquidacion(Model model) {
        List<Trabajador> listaTrabajadores = objTrabajadorService.listarTrabajador();
        model.addAttribute("trabajadores", listaTrabajadores);
        List<InstPrevision> listaPrevision = objPrevisionService.listarInstPrevision();
        model.addAttribute("listaAFP", listaPrevision);
        List<InstSalud> listaSalud = objSaludService.listarInstSalud();
        model.addAttribute("listaSalud", listaSalud);
        return "Paycheck/createPaycheck";
    }

    // GUARDA Y REDIRIGE AL LISTADO
    @PostMapping("/crearLiquidacion")
    public String crearLiquidacion(@ModelAttribute Liquidacion liquidacionCrear) {
        objLiquidacionService.crearLiquidacion(liquidacionCrear);
        return "redirect:/liquidacion";
    }

    // MUESTRA FORMULARIO DE EDITAR
    @GetMapping("/editar/{idLiquidacion}")
    public String mostrarFormularioEditarLiquidacion(@PathVariable int idLiquidacion, Model model) {
        Liquidacion liquidacionEditar = objLiquidacionService.buscarLiquidacionPorId(idLiquidacion);
        model.addAttribute("liquidacion", liquidacionEditar);
        List<Trabajador> listaTrabajador = objTrabajadorService.listarTrabajador();
        model.addAttribute("trabajadores", listaTrabajador);
        List<InstPrevision> listaPrevision = objPrevisionService.listarInstPrevision();
        model.addAttribute("listaAFP", listaPrevision);
        List<InstSalud> listaSalud = objSaludService.listarInstSalud();
        model.addAttribute("listaSalud", listaSalud);
        return "Paycheck/editPaycheck";
    }

    // ACTUALIZAR Y REDIRIGE A LISTADO
    @PostMapping("/actualizar/{idLiquidacion}")
    public String actualizarLiquidacion(@ModelAttribute Liquidacion liquidacionActualizar,
            @PathVariable int idLiquidacion) {
        liquidacionActualizar.setIdLiquidacion(idLiquidacion);
        objLiquidacionService.actualizarLiquidacion(liquidacionActualizar, idLiquidacion);
        return "redirect:/liquidacion";
    }

    // ELIMINAR Y REDIRIGIR A LISTADO
    @PostMapping("/eliminar/{idLiquidacion}")
    public String eliminarLiquidacion(@PathVariable int idLiquidacion) {
        objLiquidacionService.eliminarLiquidacion(idLiquidacion);
        return "redirect:/liquidacion";
    }
}
