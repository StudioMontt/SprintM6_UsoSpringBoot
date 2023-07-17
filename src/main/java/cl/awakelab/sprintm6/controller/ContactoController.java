package cl.awakelab.sprintm6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactoController {
        @PostMapping("/contacto")
        public String index(){ return "index";
        }

    }
