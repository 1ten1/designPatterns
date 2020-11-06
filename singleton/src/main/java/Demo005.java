/**
 * @author wangwenchao
 * @version 1.0
 * @date 2020/11/5 22:15
 * 懒汉式
 * 优点：使用时才去生成实例
 * 缺点：使用synchronized 锁代码块，解决性能问题，但是又带来了线程安全问题
 */
public class Demo005 {
    private static Demo005 INSTANCE;

    /**
     * 构造方法私有化
     */
    private Demo005() {}

    public static  Demo005 getInstance() {
        if (null == INSTANCE) {
            synchronized (Demo005.class) {
                // 加休眠是测试用，实际使用不需要
                // ********************************
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // *********************************
                INSTANCE = new Demo005();
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
            new Thread(() -> System.out.println(Demo005.getInstance().hashCode())).start();
        }
    }
}
