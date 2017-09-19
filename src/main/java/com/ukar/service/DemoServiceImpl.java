package com.ukar.service;

import com.ukar.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jyou on 2017/8/22.
 */
@Service
public class DemoServiceImpl implements DemoService{
    @Autowired
    private DemoDao demoDao;

    @Override
    public void demo() {
        System.out.println("service 执行..............");
        demoDao.demo();
    }
}
