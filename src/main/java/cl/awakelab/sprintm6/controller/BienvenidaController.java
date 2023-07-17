package cl.awakelab.sprintm6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BienvenidaController {
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
