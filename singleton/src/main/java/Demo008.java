/**
 * @author wangwenchao
 * @version 1.0
 * @date 2020/11/5 22:15
 * 枚举
 * 优点：线程安全，还可以防止反射破解单例
 * 缺点：类变成枚举了，感觉怪怪的，不常用
 */
public enum  Demo008 {

    INSTANCE;

    /**
     * 验证
     * 打印出来的hashcode相同，证明获取的是同一个对象
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Demo008.INSTANCE.hashCode())).start();
        }
    }
}
