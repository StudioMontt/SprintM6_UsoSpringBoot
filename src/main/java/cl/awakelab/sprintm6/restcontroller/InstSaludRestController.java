package cl.awakelab.sprintm6.restcontroller;

import cl.awakelab.sprintm6.entity.InstSalud;
import cl.awakelab.sprintm6.service.IInstSaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/instsalud")
public class InstSaludRestController {

    @Autowired
    IInstSaludService objInstSaludService;

    @PostMapping
    public InstSalud crearInstSalud(@RequestBody InstSalud instSalud){
        return objInstSaludService.crearInstSalud(instSalud);
    }

    @GetMapping("/{idInstSalud}")
    public InstSalud buscarInstSaludPorId(@PathVariable int idInstSalud){
        return objInstSaludService.buscarInstSaludPorId(idInstSalud);
    }

    @GetMapping
    public List<InstSalud> listarInstSalud(){
        return objInstSaludService.listarInstSalud();
    }

    @PutMapping("/{idInstSalud}")
    public InstSalud actualizarInstSalud(@RequestBody InstSalud instSaludActualizar, @PathVariable int idInstSalud){
        return objInstSaludService.actualizarInstSalud(instSaludActualizar,idInstSalud);
    }

    @DeleteMapping("/{idInstSalud}")
    public void eliminarInstSalud(@PathVariable int idInstSalud){
        objInstSaludService.eliminarInstSalud(idInstSalud);
    }
}
