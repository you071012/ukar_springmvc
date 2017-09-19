package cn.ukar.service.impl;

import cn.ukar.service.DateSourceTestService;
import org.springframework.stereotype.Service;

/**
 * Created by jyou on 2017/9/19.
 */
@Service
public class DateSourceTestServiceImpl implements DateSourceTestService{
    public void insertTest() {
        System.out.println("这是写库测试.........");
    }

    public void selectTest() {
        System.out.println("这是读库测试.........");
    }
}
