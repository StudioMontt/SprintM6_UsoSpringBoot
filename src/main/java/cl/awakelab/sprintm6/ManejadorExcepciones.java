package cl.awakelab.sprintm6;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ManejadorExcepciones {

    @ExceptionHandler(Exception.class)
    public ModelAndView manejarExcepcionesGenerales(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("mensaje", "Se ha producido un error inesperado.");
        modelAndView.addObject("excepcion", ex);
        return modelAndView;
    }

    @ExceptionHandler(Throwable.class)
    public ModelAndView manejarErrores(Throwable ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("mensaje", "Se ha producido un error inesperado.");
        modelAndView.addObject("excepcion", ex);
        return modelAndView;
    }
}