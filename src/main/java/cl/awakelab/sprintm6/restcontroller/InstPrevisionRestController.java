package cl.awakelab.sprintm6.restcontroller;

import cl.awakelab.sprintm6.entity.InstPrevision;
import cl.awakelab.sprintm6.service.IInstPrevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/instprevision")
public class InstPrevisionRestController {

    @Autowired
    IInstPrevisionService objInstPrevisionService;

    @PostMapping
    public InstPrevision crearInstPrevision(@RequestBody InstPrevision instPrevision){
        return objInstPrevisionService.crearInstPrevision(instPrevision);
    }

    @GetMapping("/{idInstPrevision}")
    public InstPrevision buscarInstPrevisionPorId(@PathVariable int idInstPrevision){
        return objInstPrevisionService.buscarInstPrevisionPorId(idInstPrevision);
    }

    @GetMapping
    public List<InstPrevision> listarInstPrevision(){
        return objInstPrevisionService.listarInstPrevision();
    }

    @PutMapping("/{idInstPrevision}")
    public InstPrevision actualizarInstPrevision(@RequestBody InstPrevision instPrevisionActualizar, @PathVariable int idInstPrevision){
        return objInstPrevisionService.actualizarInstPrevision(instPrevisionActualizar,idInstPrevision);
    }

    @DeleteMapping("/{idInstPrevision}")
    public void eliminarInstPrevision(@PathVariable int idInstPrevision){
        objInstPrevisionService.eliminarInstPrevision(idInstPrevision);
    }
}
