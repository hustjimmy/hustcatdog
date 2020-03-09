package life.zkf.hustcatdog.mapper;

import life.zkf.hustcatdog.pojo.Animal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// 表示这是一个mybatis的mapper类
@Mapper
@Repository
public interface AnimalMapper {

    // 查询所有动物
    List<Animal> queryAnimalList();

    // 用id查询某一个动物
    Animal queryAnimalById(Integer id);

    // 按地区查询动物
    List<Animal> queryAnimalByArea(String area);

    // 按动物类别查询动物
    List<Animal> queryAnimalByType(String type);

    // 增
    int addAnimal(Animal animal);

    // 改
    int updateAnimal(Animal animal);

    // 删
    int deleteAnimal(Integer id);

}
