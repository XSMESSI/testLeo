package _2021._11_November.test_1110;

import lombok.Data;

/**
 * @Description
 * @Author XuShen
 * @Date 2021/11/10 10:51
 */
@Data
public class Person {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private String age;

    /**
     * 年度
     */
    private Integer year;

    public void say(){
        System.out.println("方法");
    }

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
