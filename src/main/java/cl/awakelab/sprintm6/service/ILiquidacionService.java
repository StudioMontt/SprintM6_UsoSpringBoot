package cl.awakelab.sprintm6.service;

import cl.awakelab.sprintm6.entity.Liquidacion;
import java.util.List;

public interface ILiquidacionService {
    List<Liquidacion> listarLiquidacion();
    Liquidacion crearLiquidacion(Liquidacion liquidacion);
    Liquidacion buscarLiquidacionPorId(int idLiquidacion);
    Liquidacion actualizarLiquidacion(Liquidacion liquidacion, int idLiquidacion);
    void eliminarLiquidacion(int idLiquidacion);
}
