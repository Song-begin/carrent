package com.pu.carrent.service.impl;

import com.pu.carrent.dao.UserMapper;
import com.pu.carrent.entity.User;
import com.pu.carrent.entityExample.UserExample;
import com.pu.carrent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUsers() {
        return userMapper.selectUsersWithDetail();
    }

    @Override
    public User findUserById(Integer userId) {
        return userMapper.selectUserWithDetailById(userId);
    }

    @Override
    public User login(String userName, String password) {

        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(userName).andPasswordEqualTo(password);
        return userMapper.selectByExample(example).get(0);
    }

    @Override
    public int addUser(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int changeUser(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteUserById(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }
}
