package com.jinse.blog.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091200491814";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCqkwqCWxrDT5J5pyz36kEulFyBwzDztqd50H3i4TWMXS/5RkYce/ymXo2qsfEO49vVk8Rn9hXcqAI4z6icuL5uxBPio9A3XjeMklwSAXVskPzE4TV4cJQ9gDm4HBwcWW5knAy9tIDP5w06k1j13QneeYf+uc9g3ytGzRUqSMzLlcsVxkZVfULnSFxyRoe+xwTZ5ep9v0YcG0hfuq60REfZgNqyqvB8JfHTEhoQbN5yaNrTy8RqLHYksKySeIIemVFdMrBkvAF8T+RFLB3UvI3REweuRMCg615kYR+OPclrjOe42bj6C7OBj1fnEwadS0ccfOOglrLVr34NnN009P07AgMBAAECggEBAKPKrHW+K/XOK/X7TNgGrm6e8jF8kD4Gb80uIiPBZB0TwqRYEaz6dgH/m4OEeNh2frsYuKmniRioj/GjneJYGCzexcWEzcTNCQRH6nczxWDp3H7lTuYHHKHtxf7/pxKl4bZkjmt/r41z7aUIpoz4oqhqBOfZ3sPDqJfFCIThAR6fd6xHG2wdnHg3DVOurushPNHv9plVo7QqB0CuSWvFx+VKgwb7Y4C7d9QZwJVXDsx0HP2FPeivLUx2jwFCjpRxn7+SqwICTVM2wQ8zynCE+75E4QNGw/8m4U9ScCRpNPO45wlEPWGJGFFEU4w8XCHfAzQ1c8btCUJQgm8muv076EECgYEA178fQKS86kdIWmcoKokg86ywLfkHHYjM2/miUrda8+HUpYFyzJ+/Ikui5NfAtEESIUwQMWDzWzQeEJ/GY4ikbbzZ3EXAS+ufijyBL4pfKEzXBDk9hx+WMIakl2cSPS3Ychda9EPTSy7mbHAgxhR2if/jeVttpCrY27pyywthpOECgYEAymZSs/oG84AnbaIytJkUth5zyFnTcjXLH+oZDOtDjFxzSrWuoy3Xj0cOiM8mw5jV+fjYWWnyQP0cVfSmcfNBD4n++TGMT6tNEoP0oZvBLZwWGmhqF0YVZVw69Suo4kUwxuZMoNmFIjfuSYRxsgA1Widnt5FYfSKVXWlArAESSZsCgYEAvtD/Z0FNBTi+uZZ7ZAOc7WhS+pZCwNB5wCVueBJLk2CtnyR60JiJiF+1VwmsGsFis6h+ue2xz3ytCq8F3IrCQ3zAg539kih4Ft+kstODjjVIByhJTvWU9J5hfLdg3lNqGJ6nh1tlyh1VF5ukoQ0AOtXj7zX6JzTuUIj7drI+ToECgYBnpO5E64wTtVR7d8uvX5STjhSMTDNTEOjrdt1NGEyG2/DOGStMtHTmEeUHeczH7MPmNd/UKcS8MuEHwzhYsdBnPKsswIqxYW8eRCRJfZD24i8PZtitAl6CgTBPzAO3mubXc6dZ1wmt9CY5z3DJTgIEIJmkDvHZYpRKOVO8wO+0cQKBgD9pex6OaATm5ojR0VIQmaMoNRpSj4e98hpTcQ7XqkQEhX1/MuKPtS+VZInfrgD2HGSCQgcVO/zRfXP7aBNCxzHtzh45bLaIhaOWSWO1UY9iMKpFhYBkI7ofuon2q3lvVSfHFCxa6LHwBZnHc1kble1C5bSvtFB/3NNauqIRO+NT";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqP9sR91OudjwF/QDyTIUO0peBm6UXWwNfuPQ52Vz37Xh1NcwiY6/iabhfgmhd9lM/6khFLyhh5UsEbuB/qXu/W7fsaXXmfTdbEHMVouizwvjD4JNl+uj7VcpoRPO+XpV00q1+SNNbFvmqirapU4vkd+V+ivxwUbN6fM42ilusX8S3Zp7l9uraqgK4NsWHK8ZBb5KZHaOwG16VK+qvuvQfmEPE0Z7lKTcM32n7q9Gd7Vx9l0QTHVsKhxHSbj6xRY1C6rVlVv85SqNCjMqznkainl39SmBv8T3v3OAFIuEmn6sNjrzAF9U/H9wo/KQ9kUm0toERP52P2wtvjWcZIOhRQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/jinseblog/notify_url/view";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/jinseblog/return_url/view";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

