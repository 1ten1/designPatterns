/**
 * @author wangwenchao
 * @version 1.0
 * @date 2020/11/5 22:15
 * 懒汉式
 * 优点：使用时才去生成实例
 * 缺点：线程不安全
 */
public class Demo003 {
    private static Demo003 INSTANCE;

    /**
     * 构造方法私有化
     */
    private Demo003() {}

    public static Demo003 getInstance() {
        if (null == INSTANCE) {
            // 加休眠是测试用，实际使用不需要
            // ********************************
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // *********************************
            INSTANCE = new Demo003();
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
            new Thread(() -> System.out.println(Demo003.getInstance().hashCode())).start();
        }
    }
}
