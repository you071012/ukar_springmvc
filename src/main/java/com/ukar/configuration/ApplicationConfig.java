package com.ukar.configuration;

import com.ukar.dao.DemoDao;
import com.ukar.dao.DemoDaoImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * Created by jyou on 2017/8/22.
 */
@Configuration
@ImportResource({"classpath:spring/applicationContext*.xml"})//引入外部xml配置文件
@ComponentScan({"com.ukar.service"})//注解扫描包
@PropertySource(value = {"classpath:httpclient.properties","xxx"}, ignoreResourceNotFound = true)
public class ApplicationConfig {

    @Value("${httpclient.maxTotal}")
    private String maxTotal;
    @Bean
    public DemoDao getDao(){
        return new DemoDaoImpl();
    }
}
