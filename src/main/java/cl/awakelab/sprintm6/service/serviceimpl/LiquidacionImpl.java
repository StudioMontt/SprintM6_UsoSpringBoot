package cl.awakelab.sprintm6.service.serviceimpl;

import cl.awakelab.sprintm6.entity.Liquidacion;
import cl.awakelab.sprintm6.repository.ILiquidacionRepository;
import cl.awakelab.sprintm6.service.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service("liquidacionImpl")
public class LiquidacionImpl implements ILiquidacionService {

    @Autowired
    ILiquidacionRepository objLiquidacionRepo;

    @Override
    public List<Liquidacion> listarLiquidacion() {
        return objLiquidacionRepo.findAll();
    }

    @Override
    public Liquidacion crearLiquidacion(Liquidacion liquidacion) {
        return objLiquidacionRepo.save(liquidacion);
    }

    @Override
    public Liquidacion buscarLiquidacionPorId(int idLiquidacion) {
        return objLiquidacionRepo.findById(idLiquidacion).orElseThrow(() -> new NoSuchElementException("Liquidación no encontrada"));
    }

    @Override
    public Liquidacion actualizarLiquidacion(Liquidacion liquidacionActualizar, int idLiquidacion) {
        Liquidacion liquidacion = objLiquidacionRepo.findById(idLiquidacion).orElseThrow(() -> new NoSuchElementException("Liquidación no encontrada"));
        liquidacion.setTrabajador(liquidacionActualizar.getTrabajador());
        liquidacion.setPeriodo(liquidacionActualizar.getPeriodo());
        liquidacion.setSueldoImponible(liquidacionActualizar.getSueldoImponible());
        liquidacion.setSueldoLiquido(liquidacionActualizar.getSueldoLiquido());
        liquidacion.setSalud(liquidacionActualizar.getSalud());
        liquidacion.setDctoSalud(liquidacionActualizar.getDctoSalud());
        liquidacion.setPrevision(liquidacionActualizar.getPrevision());
        liquidacion.setDctoPrevision(liquidacionActualizar.getDctoPrevision());
        liquidacion.setTotalDescuento(liquidacionActualizar.getTotalDescuento());
        liquidacion.setTotalHaberes(liquidacionActualizar.getTotalHaberes());
        liquidacion.setAnticipo(liquidacionActualizar.getAnticipo());
        return objLiquidacionRepo.save(liquidacion);
    }

    @Override
    public void eliminarLiquidacion(int idLiquidacion) {
        objLiquidacionRepo.deleteById(idLiquidacion);
    }
}
