package cl.awakelab.sprintm6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
        @GetMapping("/login")
        public String index(){
            return "login";
        }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

}
