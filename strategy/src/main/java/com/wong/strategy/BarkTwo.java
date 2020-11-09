package com.wong.strategy;

/**
 * @author wangwenchao
 * @version 1.0
 * @date 2020/11/9 21:45
 * 狗叫策略二
 */
public class BarkTwo implements BarkStrategy {
    @Override
    public void bark() {
        System.out.println("呜呜呜~");
    }
}
