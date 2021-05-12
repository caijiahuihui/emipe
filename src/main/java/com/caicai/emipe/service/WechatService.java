package com.caicai.emipe.service;

import com.caicai.emipe.util.BaseUtil;
import com.caicai.emipe.util.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

/**
 * @author caicai
 * @create 2021/4/28
 */
@Service
@Slf4j
public class WechatService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String APP_ID = "wx7c455a4a433d485d";

    public static final String MCH_ID = "1583601471";

    public static final String KAY = "B55E55697AD211eabd9b02420a000102";

    private static final String APP_HOST = "https://api.mch.weixin.qq.com/v3/pay/transactions/app";

    private static final String NATIVE_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    public String appPay() {
        return null;
    }

    /**
     * 微信扫码支付
     *
     * @return
     */
    public String nativePay() throws Exception {
        Map<String, Object> params = new TreeMap<>();
        params.put("appid", APP_ID);
        params.put("mch_id", MCH_ID);
        String nonceStr = getNonceStr();// 随机字符串
        params.put("nonce_str", nonceStr);
        params.put("body", "快易车-服务费");
        params.put("out_trade_no", BaseUtil.getTimestamp());
        params.put("notify_url", "http://223.75.245.243:9094/gaea/v1/callback/wechat");
        params.put("total_fee", 1);
        params.put("trade_type", "NATIVE");
        params.put("spbill_create_ip", InetAddress.getLocalHost().getHostAddress());
        params.put("sign", getMd5Sign(params));
        log.info("本机地址为：  " + InetAddress.getLocalHost().getHostAddress());
        String response = restTemplate.postForObject(NATIVE_URL, transferMaptoXml(params), String.class);
        log.info(response);
        return response;
    }

    /**
     * 随机数算法
     *
     * @return
     */
    private String getNonceStr() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private String getMd5Sign(Map<String, Object> params) {
        Set<Map.Entry<String, Object>> set = params.entrySet();
        String beforeMd5Sign = "";
        for (Map.Entry<String, Object> entry : set)
            beforeMd5Sign += entry.getKey() + "=" + entry.getValue().toString() + "&";
        beforeMd5Sign += "key=" + KAY;
        String afterMd5Sign = Md5Util.getMD5Code(beforeMd5Sign);
        return afterMd5Sign;
    }

    private String transferMaptoXml(Map<String, Object> params) {
        Set<Map.Entry<String, Object>> set = params.entrySet();
        StringBuffer buffer = new StringBuffer();
        buffer.append("<xml>");
        for (Map.Entry<String, Object> entry : set)
            buffer.append("<" + entry.getKey() + ">" + entry.getValue().toString() + "</" + entry.getKey() + ">");
        buffer.append("</xml>");
        return buffer.toString();
    }

}
