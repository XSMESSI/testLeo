package common.json_list_str;

import lombok.Data;

/**
 * @Description
 * @Author XuShen
 * @Date 2022/10/9 14:27
 */
@Data
public class People {

    private Integer id;

    private String name;

    private Integer age;

    private Integer ddd;

    public People(){

    }

    public People(Integer id,String name,Integer age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
