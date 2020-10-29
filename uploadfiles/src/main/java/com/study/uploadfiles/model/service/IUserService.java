package com.study.uploadfiles.model.service;

import java.util.List;

import com.study.uploadfiles.model.entity.User;

public interface IUserService {

    public User findByUserId(Long id);

    public List<User> findAllUsers();

    public User saveUser(User user);

    public void deleteByUserId(Long id);

}
