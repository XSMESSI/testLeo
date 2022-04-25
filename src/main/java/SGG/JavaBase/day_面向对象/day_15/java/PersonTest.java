package SGG.JavaBase.day_面向对象.day_15.java;

/**
 * @Author: Leo messi
 * @Date: 2022/04/17/12:14
 * @Description:
 */


/**
 * 抽象类的匿名子类：
 *
 *
 */
public class PersonTest {
    public static void main(String[] args) {
        method(new Student());//匿名对象

        Worker worker = new Worker();
        method1(worker);//非匿名的类非匿名的对象

        method1(new Worker());//非匿名的类匿名对象

    }

    public static void method1(Person p){
        p.eat();
        p.walk();
    }

    public static void method(Student s){

    }
}

class Worker extends Person{

    @Override
    public void eat() {

    }

    @Override
    public void breath() {

    }


}
