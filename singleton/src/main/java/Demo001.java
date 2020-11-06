/**
 * @author wangwenchao
 * @version 1.0
 * @date 2020/11/5 22:15
 * 饿汉式
 * 优点：简单实用，线程安全
 * 缺点：类加载时就创建了实例（算不上啥缺点）
 */
public class Demo001 {
    /**
     * 类加载时就创建一个实例
     */
    private static final Demo001  INSTANCE = new Demo001();

    /**
     * 构造方法私有化
     */
    private Demo001() {}

    public static Demo001 getInstance() {
        // 加休眠是测试用，实际使用不需要
        // ********************************
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // *********************************
        return INSTANCE;
    }

    /**
     * 验证
     * 打印出来的hashcode相同，证明获取的是同一个对象
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Demo001.getInstance().hashCode())).start();
        }
    }
}
