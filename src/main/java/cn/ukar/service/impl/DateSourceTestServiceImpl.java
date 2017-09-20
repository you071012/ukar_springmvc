package cn.ukar.service.impl;

import cn.ukar.entity.User;
import cn.ukar.mapper.UserMapper;
import cn.ukar.service.DateSourceTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jyou on 2017/9/19.
 */
@Service
public class DateSourceTestServiceImpl implements DateSourceTestService{

    @Autowired
    private UserMapper userMapper;

    public void insertTest() {
        System.out.println("这是写库测试.........");
    }

    public void selectTest() {
        System.out.println("这是读库测试.........");
    }

    @Override
    public User selectOne(Long id) {
        User user = new User();
        user.setId(id);
        return userMapper.selectOne(user);
    }


}
