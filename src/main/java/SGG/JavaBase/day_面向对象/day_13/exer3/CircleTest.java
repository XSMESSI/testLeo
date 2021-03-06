package SGG.JavaBase.day_面向对象.day_13.exer3;

/**
 * @Author: Leo messi
 * @Date: 2022/04/04/13:56
 * @Description:
 */

/**
 * 创建两个Circle对象，判断其颜色是否相等；利用equals方法判断其半径是否相等；利用
 * toString()方法输出其半径。
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle circle1 = new Circle(2.3);
        Circle circle2 = new Circle(3.3,"white",2.0);


        System.out.println("颜色是否相等:"+circle1.getColor().equals(circle2.getColor()));

        System.out.println("半径是否相等："+circle1.equals(circle2));

        System.out.println(circle1);
    }
}
