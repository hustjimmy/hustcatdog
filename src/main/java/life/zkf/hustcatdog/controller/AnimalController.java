package life.zkf.hustcatdog.controller;


import life.zkf.hustcatdog.pojo.Animal;
import life.zkf.hustcatdog.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@Controller
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    // 去Dashboard首页
    @GetMapping("/dashboard")
    public String toDashboard(Model model) {

        Collection<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);

        return "dashboard";
    }




    // 去添加动物的页面
    @GetMapping("/dashboard/animal")
    public String toAddPage() {
        return "add";
    }

    // 处理添加动物的POST请求
    @PostMapping("/dashboard/addAnimal")
    public String addAnimal(Animal animal) {

        animalService.addAnimal(animal);

        return "redirect:/dashboard";
    }

    // 去修改动物的页面
    @GetMapping("/dashboard/update/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        // 查出原来的数据
        Animal animal = animalService.getAnimalById(id);

        model.addAttribute("animalToUpdate", animal);

        return "update";
    }

    // 处理修改动物的POST请求
    @PostMapping("/dashboard/updateAnimal")
    public String updateAnimal(Animal animal) {

        animalService.updateAnimal(animal);

        return "redirect:/dashboard";
    }

    // 处理删除动物的GET请求
    @GetMapping("/dashboard/delete/{id}")
    public String deleteAnimal(@PathVariable("id") Integer id) {

        animalService.deleteAnimalById(id);

        return "redirect:/dashboard";

    }

    /*// 打开上传图片的页面
    @GetMapping("/dashboard/uploadPage")
    public String uploadImagePage() {

        return "uploadPage";
    }

    // 处理上传图片的POST请求
    @PostMapping("/dashboard/upload")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile,
                              @RequestParam("id") Integer id) {


        try {
            animalService.saveImageById(imageFile, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/dashboard";
    }*/


}
