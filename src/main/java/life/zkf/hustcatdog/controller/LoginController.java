package life.zkf.hustcatdog.controller;

import life.zkf.hustcatdog.pojo.Admin;
import life.zkf.hustcatdog.service.AdminService;
import life.zkf.hustcatdog.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private AdminService adminService;
    private AnimalService animalService;

    @Autowired
    public LoginController(AdminService adminService, AnimalService animalService) {
        this.adminService = adminService;
        this.animalService = animalService;
    }

    @GetMapping("/admin")
    public String loginPage() {
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes,
                        Model model) {

        Admin admin = adminService.checkAdmin(username, password);

        if (admin != null) {
            admin.setPassWord(null);
            session.setAttribute("user", admin);

            return "redirect:/dashboard";
        } else {
            attributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/admin";
        }

    }

    @GetMapping("/dashboard/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
