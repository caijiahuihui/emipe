package com.caicai.emipe.util;

import java.util.UUID;

/**
 * @author caicai
 * @create 2021/4/29
 */
public class BaseUtil {
    /**
     * 获取精确到毫秒的时间戳
     *
     * @return
     **/
    public static Long getTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * 获取UUID
     *
     * @return
     */
    public static String getUUIDStr() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
