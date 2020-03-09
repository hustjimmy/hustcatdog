package life.zkf.hustcatdog.service;

import life.zkf.hustcatdog.pojo.Animal;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AnimalService {

    List<Animal> getAllAnimals();

    void addAnimal(Animal animal);

    Animal getAnimalById(int id);

    void updateAnimal(Animal animal);

    void deleteAnimalById(int id);

    void saveImageById(MultipartFile imageFile, Integer id) throws Exception;

}
