package com.study.uploadfiles.model.dao;

import com.study.uploadfiles.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User, Long>{
    
}
