package life.zkf.hustcatdog.service;

import life.zkf.hustcatdog.mapper.AnimalMapper;
import life.zkf.hustcatdog.pojo.Animal;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    private AnimalMapper animalMapper;

    @Autowired
    public AnimalServiceImpl(AnimalMapper animalMapper) {
        this.animalMapper = animalMapper;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalMapper.queryAnimalList();
    }

    @Override
    public void addAnimal(Animal animal) {
        animalMapper.addAnimal(animal);
    }

    @Override
    public Animal getAnimalById(int id) {
        return animalMapper.queryAnimalById(id);
    }

    @Override
    public void updateAnimal(Animal animal) {
        animalMapper.updateAnimal(animal);
    }

    @Override
    public void deleteAnimalById(int id) {
        // 数据库中删除这一行
        animalMapper.deleteAnimal(id);

        //磁盘上删除图片
        String folder = "upload-dir/";
        String[] extensionList = {".png", ".jpeg", "jpg"};
        for (String extension : extensionList) {
            try {
                System.out.println("在删除");
                Files.deleteIfExists(Paths.get(folder + id + extension));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void saveImageById(MultipartFile imageFile, Integer id) {

        //String folder = "src/main/uploadImages/";
        String folder = "file://" + System.getProperty("user.dir") + "/uploadImages/";

        String extension = FilenameUtils.getExtension(imageFile.getOriginalFilename());


        try {
            byte[] bytes = imageFile.getBytes();

            Path path = Paths.get(folder + id + "." + extension);

            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
