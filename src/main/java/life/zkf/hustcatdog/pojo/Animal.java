package life.zkf.hustcatdog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    private Integer id;
    private String name;
    private String gender; // true for male, false for female
    private String type;    // 动物类别
    private String area;    // 活动的地区
    private String introduction; // 一段简短的介绍

    public Animal(String name, String gender, String type, String area, String introduction) {
        this.name = name;
        this.gender = gender;
        this.type = type;
        this.area = area;
        this.introduction = introduction;
    }
}
