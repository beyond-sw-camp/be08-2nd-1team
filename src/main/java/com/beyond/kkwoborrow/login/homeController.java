package com.beyond.kkwoborrow.login;

import com.beyond.kkwoborrow.users.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class homeController {

    @GetMapping("/")
    public String homeLogin(@SessionAttribute(name = sessionConst.LOGIN_MEMBER, required = false) Users user, Model model) {
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "blank";
    }
}
