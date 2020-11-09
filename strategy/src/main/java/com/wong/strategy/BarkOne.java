package com.wong.strategy;

/**
 * @author wangwenchao
 * @version 1.0
 * @date 2020/11/9 21:44
 * 狗叫策略一
 */
public class BarkOne implements BarkStrategy {
    @Override
    public void bark() {
        System.out.println("汪汪汪~");
    }
}
