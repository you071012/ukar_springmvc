package cn.ukar.controller.position;

import cn.ukar.httpclient.HttpClientApi;
import cn.ukar.util.AdressUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**地理位置获取controller
 * Created by jyou on 2017/8/31.
 */
@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private HttpClientApi httpClient;

    @RequestMapping(value = "/loadPosition.do")
    @ResponseBody
    public String loadPosition(HttpServletRequest request, HttpServletResponse response){
        String ip = null;
        if (request.getHeader("x-forwarded-for") == null) {
            ip = request.getRemoteAddr();
        }else{
            ip = getRemoteHost(request);
        }
        if(ip != null && ip.contains(",")){
            ip = ip.split(",")[0];
        }
        System.out.println("IP地址:" + ip);
        try {
            Map<String,String> map = new HashMap<>();
            map.put("ip", ip);
            map.put("ak", AdressUtils.AK);
            String result = AdressUtils.getAddresses(map, httpClient);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "FAIL";
    }
    private String getRemoteHost(javax.servlet.http.HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
    }
}
