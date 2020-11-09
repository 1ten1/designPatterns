package com.wong.strategy;

import lombok.Data;

/**
 * @author wangwenchao
 * @version 1.0
 * @date 2020/11/9 21:41
 * 狗有一个叫的方法
 * 这个方法可以根据传进来的策略，实现不同的叫声
 * 核心思想就是不同的策略实现同一个接口，调用时调用策略接口
 */
@Data
public class Dog {
    private String name;

    public void bark(BarkStrategy barkStrategy) {
        barkStrategy.bark();
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("小黄");
        dog.bark(new BarkOne());
        dog.bark(new BarkTwo());
    }
}
