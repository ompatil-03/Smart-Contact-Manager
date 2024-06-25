package com.scm.scm10.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.scm10.Entity.User;
import com.scm.scm10.forms.UserForm;
import com.scm.scm10.services.UserService;

import jakarta.servlet.http.HttpSession;




@Controller 
public class PageController {

        @SuppressWarnings("unused")
        @Autowired
        private UserService userService;


   //Home page
    @RequestMapping("/home")
    public String home(Model model) {
       
        System.out.println("Home page handeler");
        return "Home";
    }
    
    //About page
    @RequestMapping("/about")
    public String about(Model model){
        System.out.println("About page handeler");
        return "About";
    }

    //Services page
    @RequestMapping("/services")
    public String services(Model model) {
        System.out.println("Services page handeler");
        return "services";
    }

    //Contact page
    @RequestMapping("/contact")
    public String contact(Model model) {
        System.out.println("contact page handeler");
        return "contact";
    }

    //Login page
    @RequestMapping("/login")
    public String login() {
        System.out.println("login page handeler");
        return "login";
    }

    //Register page
    @RequestMapping("/register")
    public String register(Model model) {
        System.out.println("register page handeler");
        //creating userform object and passing it to register.html
        UserForm userForm = new UserForm();
        //you can add dfault values to userForm object here
        model.addAttribute("userForm", userForm);
        return "register";
    }
    
    //processing Register page
    @RequestMapping(value = "/do-register",method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession httpSession) {
        System.out.println("Processing register page handeler");

        //link for default profil picture 
         String porfilePic="https://img.freepik.com/free-vector/blue-circle-with-white-user_78370-4707.jpg?w=740&t=st=1719233373~exp=1719233973~hmac=2cc5b8821ed1e5d2ab30f7fd506a1c1f7ea7788e340572bb6f7e20a6091e20e7";

        //  System.out.println("*****The value of emali is*******"+userForm.getEmail());
        //  System.out.println("*****The value of NAME is*******"+userForm.getName());
        //  System.out.println("*****The value of phoneNumber is*******"+userForm.getPhoneNumber());
        //  System.out.println("*****The value of about is*******"+userForm.getAbout());

        //Converting userform into user object 
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic(porfilePic);

        User savedUser = userService.saveUser(user);

        System.out.println("user saved :");
    
        //sending messege to front end 
        httpSession.setAttribute("messege","You have successfully registered");
        
        return "redirect:/register";
    }
    
}
