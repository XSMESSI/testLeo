package SGG.JavaBase.day_面向对象.day_15.exer1;

/**
 * @Author: Leo messi
 * @Date: 2022/04/17/11:46
 * @Description:
 */

/**
 * 编写一个Employee类，声明为抽象类，
 * 包含如下三个属性：name，id，salary。
 * 提供必要的构造器和抽象方法：work()。
 * 对于Manager类来说，他既是员工，还具有奖金(bonus)的属性。
 * 请使用继承的思想，设计CommonEmployee类和Manager类，要求类
 * 中提供必要的方法进行属性访问。
 */
public abstract class Employee {

    private String name;

    private int id;

    private double salary;

    public Employee() {
    }

    public Employee(String name, int id, double salary) {
        super();
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();
}
