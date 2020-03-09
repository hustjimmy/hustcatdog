package life.zkf.hustcatdog.controller;

import life.zkf.hustcatdog.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private AnimalService animalService;

    @Autowired
    public IndexController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping({"/", "/index", "/index.html"})
    public String toIndexPage(Model model) {

        model.addAttribute("animals", animalService.getAllAnimals());
        return "index";

    }

    @GetMapping({"/about", "/about.html"})
    public String toAboutPage() {
        return "about";
    }

}
