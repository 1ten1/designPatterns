/**
 * @author wangwenchao
 * @version 1.0
 * @date 2020/11/5 22:15
 * 懒汉式
 * 优点：使用时才去生成实例，线程安全， 比在方法上加锁性能好
 * 缺点：比较复杂
 */
public class Demo006 {
    private static Demo006 INSTANCE;

    /**
     * 构造方法私有化
     */
    private Demo006() {}

    public static Demo006 getInstance() {
        if (null == INSTANCE) {
            synchronized (Demo006.class) {
                if (null == INSTANCE) {
                    // 加休眠是测试用，实际使用不需要
                    // ********************************
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // *********************************
                    INSTANCE = new Demo006();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 验证
     * 打印出来的hashcode相同，证明获取的是同一个对象
     * hashcode不同则是不同的对象
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Demo006.getInstance().hashCode())).start();
        }
    }
}
