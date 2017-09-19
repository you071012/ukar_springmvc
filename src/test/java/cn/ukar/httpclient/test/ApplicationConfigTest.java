package cn.ukar.httpclient.test;

import com.ukar.configuration.ApplicationConfig;
import com.ukar.service.DemoService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jyou on 2017/8/22.
 */
public class ApplicationConfigTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        DemoService demoService = context.getBean(DemoService.class);
        demoService.demo();
    }
}
