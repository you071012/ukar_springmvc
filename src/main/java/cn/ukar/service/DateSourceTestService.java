package cn.ukar.service;

import cn.ukar.entity.User;

/**
 * Created by jyou on 2017/9/19.
 */
public interface DateSourceTestService {
    void insertTest();

    void selectTest();

    User selectOne(Long id);
}
