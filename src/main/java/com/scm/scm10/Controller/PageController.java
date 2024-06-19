package com.scm.scm10.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




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
    
    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("loggedin",true);
        System.out.println("About page handeler");
        return "About";
    }
    @RequestMapping("/services")
    public String requestMethodName(Model model) {
        model.addAttribute("loggedin",true);
        System.out.println("Services page handeler");
        return "services";
    }
    
    
}
