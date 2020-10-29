package com.study.uploadfiles.model.impl;

import java.util.List;

import com.study.uploadfiles.model.dao.IUserDao;
import com.study.uploadfiles.model.entity.User;
import com.study.uploadfiles.model.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserImpl implements IUserService {

    @Autowired private IUserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public User findByUserId(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    @Transactional
    public void deleteByUserId(Long id) {
        userDao.deleteById(id);
    }
    
}
