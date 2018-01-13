package me.davidx.learnjava;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    User user = new User();
    @RequestMapping("/home")
    public String home(Model model) {
        Map<String,User> map = new HashMap<String, User>();
        model.addAttribute("map",map);
        return "aa";
    }

    @RequestMapping("/bb")
    public String bb(Model model) {
        user.setMsg("i am excited!");
        model.addAttribute("message", "hello, world,i am ningwenhui");
        return "bb";
    }
}