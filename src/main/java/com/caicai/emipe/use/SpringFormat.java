package com.caicai.emipe.use;

import lombok.extern.slf4j.Slf4j;

/**
 * 字符串格式化
 *
 * @author caicai
 * @create 2021/3/9
 */
@Slf4j
public class SpringFormat {

    public static void main(String[] args) {
        char a = 'a';
        char b = 'b';
        // 1.字符串
        log.info(String.format("aaaaa: %s", "vv"));
        // 2.字符类型
        log.info(String.format("字符串类型： 1. %c, 2. %c", a, b));
        // 3.布尔类型
        log.info(String.format("是真还是假？ %b : %b", true, false));
        // 4.整数类型
        log.info("整数类型：%d" + 153);
        
    }
}
