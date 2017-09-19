package cn.ukar.httpclient.test;

import cn.ukar.httpclient.HttpClientApi;
import cn.ukar.util.AdressUtils;
import cn.ukar.util.Md5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jyou on 2017/8/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext*.xml")
public class HttpClientTest {
    @Autowired
    private HttpClientApi httpClient;

    @Test
    public void test() throws IOException, URISyntaxException {
        Map<String,String> map = new HashMap<String,String>();
        map.put("ip", "115.225.26.34");
        map.put("ak", "F454f8a5efe5e577997931cc01de3974");
        String url = "http://api.map.baidu.com/location/ip";
        String response = httpClient.doGet(url, map);
        System.out.println(AdressUtils.decodeUnicode(response));
    }

    @Test
    public void noticeMerchant() throws IOException, URISyntaxException {
        String dealCode = "WJACGOLKKOBBFOOA";
        String key = "mo9_gateway_merchant_notification";
        String sign = Md5Util.getMD5(dealCode + key);
        String response =  httpClient.doGet("http://jyou.local.mo9.com/gateway/notification/reNotifyOrder.mhtml?dealCode="+dealCode+"&sign="+sign);
        System.out.println(response);
        System.out.println("程序结束");
    }
}
