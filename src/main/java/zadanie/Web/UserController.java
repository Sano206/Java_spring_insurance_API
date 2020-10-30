package zadanie.Web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import zadanie.User.User;
import zadanie.User.UserResource;
import zadanie.User.UserService;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String all(Model model){
        model.addAttribute("users", userService.getUsers());
          return "user/all";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("userResource", new UserResource(userService.findUserById(id)));
        model.addAttribute("id", id);
        return "user/update";
    }

    @PostMapping("/update/{id}")
    public String updateSubmitted(@PathVariable int id, @ModelAttribute @Valid UserResource userResource, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "/user/update";
        }
        User user = userService.findUserById(id);
        userService.editUser(user, userResource.toUser());
        return "/index";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("userResource", new UserResource());
        return "/user/add";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute @Valid UserResource userResource, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "/user/add";
        }
        User user = userResource.toUser();
        userService.addNewUser(user);
        return "/index";
    }

    @GetMapping("/detail/{id}")
    public String detailUser(@PathVariable int id, Model model){
        model.addAttribute("user", userService.findUserById(id));
        return "/user/detailUser";
    }



}
