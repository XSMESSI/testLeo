package SGG.JavaBase.day_面向对象.day_16.java2;

/**
 * @Author: Leo messi
 * @Date: 2022/05/14/21:30
 * @Description:
 */
public class ReturnExceptionDemo {
    static void methodA() {
        try {
            System.out.println("进入方法A");
            throw new RuntimeException("制造异常methodA");
        } finally {
            System.out.println("用A方法的finally");
        }
    }

    static void methodB() {
        try {
            System.out.println("进入方法B");
            return;
        } finally {
            System.out.println("调用B方法的finally");
        }
    }
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println("输出异常信息:" + e.getMessage());
        }
        methodB();
    }
}
