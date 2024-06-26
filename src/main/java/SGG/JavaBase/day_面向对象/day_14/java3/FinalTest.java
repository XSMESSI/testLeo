package SGG.JavaBase.day_面向对象.day_14.java3;

/**
 * @Author: Leo messi
 * @Date: 2022/04/10/11:31
 * @Description:
 */

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * final:最终的
 *
 * 1.final可以用来修饰的结构：类，方法，变量
 *
 * 2.final用来修饰一个类:此类不能被其他类继承。
 *          比如：String,System类，StringBuffer类
 *
 *
 * 3.final 用来修饰方法：表明此方法不可以被重写
 *          比如：Object类中的getClass();
 *
 * 4.final 用来修饰变量：此时的变量就称为一个常量
 *          4.1 final 修饰一个属性：可以考虑赋值的位置有：显式初始化、在代码块中初始化
 *          4.2 final 修饰局部变量，
 *              尤其是使用final修饰形参时，表明此形参是一个常量。当我们调用此方法时，给常量形参赋一个实参，一旦赋值
 *              以后，就只能在方法体内使用此形参，但不能进行重新赋值。
 *
 *   static final 用来修饰属性：全局常量；
 *
 *
 */
public class FinalTest {

    public static void main(String[] args) {

        int num = 10;
        num = num + 5;

        FinalTest test = new FinalTest();
        test.show(10);




    }

    final int WIDTH = 10;
    final int LEFT;
    final int RIGHT;
//    final int DOWN;

    {
        LEFT = 1;
    }

    public void doWidth(){
//        width = 20;
    }

    public void show(){
        final int num = 10;//常量
//        num += 20;
    }

    public void show(final int num){

    }

    public FinalTest(){
        RIGHT = 2;
    }

    public FinalTest(int n){
        RIGHT = n;
    }

//    public void setDOWN(int down){
//        this.DOWN = down;
//    }


}

final class FinalA{

}

class B {

}

class Aa{
    public final void show(){

    }
}

class Bb extends Aa{

//    @Override
//    public void show() {
//        super.show();
//    }
}


