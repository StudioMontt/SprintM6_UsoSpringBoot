package cl.awakelab.sprintm6.restcontroller;

import cl.awakelab.sprintm6.entity.Empleador;
import cl.awakelab.sprintm6.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/empleador")
public class EmpleadorRestController {

    @Autowired
    IEmpleadorService objEmpleadorService;

    @PostMapping
    public Empleador crearEmpleador(@RequestBody Empleador empleador){
        return objEmpleadorService.crearEmpleador(empleador);
    }

    @GetMapping("/{idEmpleador}")
    public Empleador buscarEmpleadorPorId(@PathVariable int idEmpleador){
        return objEmpleadorService.buscarEmpleadorPorId(idEmpleador);
    }

    @GetMapping
    public List<Empleador> listarUsuarios(){
        return objEmpleadorService.listarUsuarios();
    }

    @PutMapping("/{idEmpleador}")
    public Empleador actualizarEmpleador(@RequestBody Empleador empleadorActualizar, @PathVariable int idEmpleador){
        return objEmpleadorService.actualizarEmpleador(empleadorActualizar,idEmpleador);
    }

    @DeleteMapping("/{idEmpleador}")
    public void eliminarEmpleador(@PathVariable int idEmpleador){
        objEmpleadorService.eliminarEmpleador(idEmpleador);
    }
}
