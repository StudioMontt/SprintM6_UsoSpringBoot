package cl.awakelab.sprintm6.restcontroller;

import cl.awakelab.sprintm6.entity.Liquidacion;
import cl.awakelab.sprintm6.service.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/liquidacion")
public class LiquidacionRestController {

    @Autowired
    ILiquidacionService objLiquidacionService;

    @PostMapping
    public Liquidacion crearLiquidacion(@RequestBody Liquidacion liquidacion) {
        return objLiquidacionService.crearLiquidacion(liquidacion);
    }

    @GetMapping("/{idLiquidacion}")
    public Liquidacion buscarLiquidacionPorId(@PathVariable int idLiquidacion) {
        return objLiquidacionService.buscarLiquidacionPorId(idLiquidacion);
    }

    @GetMapping
    public List<Liquidacion> listarLiquidacion() {
        return objLiquidacionService.listarLiquidacion();
    }

    @PutMapping("/{idLiquidacion}")
    public Liquidacion actualizarLiquidacion(@RequestBody Liquidacion liquidacionActualizar,
            @PathVariable int idLiquidacion) {
        return objLiquidacionService.actualizarLiquidacion(liquidacionActualizar, idLiquidacion);
    }

    @DeleteMapping("/{idLiquidacion}")
    public void eliminarLiquidacion(@PathVariable int idLiquidacion) {
        objLiquidacionService.eliminarLiquidacion(idLiquidacion);
    }
}
