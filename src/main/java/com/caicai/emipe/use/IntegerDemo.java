package com.caicai.emipe.use;

/**
 * @author caicai+.0000000
 * @create 2021/3/26
 */
public class IntegerDemo {
    public static void main(String[] args) {
        Integer a1 = new Integer(100);
        Integer a2 = new Integer(100);
        System.out.println("是不是内存地址一样呢？" + (a1 == a2));
        Integer b1 = Integer.valueOf(100);
        Integer b2 = Integer.valueOf(100);
        System.out.println("是不是内存地址一样呢？" + (b1 == b2));
    }
}
