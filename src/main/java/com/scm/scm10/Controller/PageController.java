package com.scm.scm10.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller 
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Om");
        model.addAttribute("age", 20);
        model.addAttribute("city", "Mumbai");
        System.out.println("Home page handeler");
        return "Home";
    }
    
    
}
