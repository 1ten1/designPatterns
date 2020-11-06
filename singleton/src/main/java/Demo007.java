/**
 * @author wangwenchao
 * @version 1.0
 * @date 2020/11/5 22:15
 * 静态内部类
 * 优点：JVM保证单例和线程安全，实现懒加载，不用加锁
 * 缺点：写法复杂
 */
public class Demo007 {

    private static class InnerClass {
        private static final Demo007 INSTANCE = new Demo007();
    }

    /**
     * 构造方法私有化
     */
    private Demo007() {}

    public static Demo007 getInstance() {
        // 加休眠是测试用，实际使用不需要
        // ********************************
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // *********************************
        return InnerClass.INSTANCE;
    }

    /**
     * 验证
     * 打印出来的hashcode相同，证明获取的是同一个对象
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Demo007.getInstance().hashCode())).start();
        }
    }
}
