package cn.ukar.httpclient.test;

import cn.ukar.entity.User;
import cn.ukar.service.DateSourceTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jyou on 2017/9/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext*.xml")
public class DateSourceTest {
    @Autowired
    private DateSourceTestService dateSourceTestService;

    @Test
    public void test(){
        for(int i = 0 ; i < 20 ; i++){
//            User user = dateSourceTestService.selectByPassword("456");
//            if(user != null){
//                System.out.println(user.getName());
//            }
        }

//        dateSourceTestService.insertTest();
    }
}
