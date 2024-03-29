package _2023._02_Feb;

/**
 * @Description
 * @Author XuShen
 * @Date 2023/2/27 15:59
 */
public class BaseTest {

    public static final InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        inheritableThreadLocal.set("Inheritable hello");
        threadLocal.set("hello");
        new Thread(() -> {
            System.out.println(String.format("子线程可继承值：%s", inheritableThreadLocal.get()));
            System.out.println(String.format("子线程值：%s", threadLocal.get()));
            new Thread(() -> {
                System.out.println(String.format("孙子线程可继承值：%s", inheritableThreadLocal.get()));
                System.out.println(String.format("孙子线程值：%s", threadLocal.get()));
            }).start();

        }).start();


    }
}
