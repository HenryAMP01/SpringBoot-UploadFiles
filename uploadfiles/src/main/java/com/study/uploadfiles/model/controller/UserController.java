package com.study.uploadfiles.model.controller;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

import javax.validation.Valid;

import com.study.uploadfiles.model.dto.UserDTO;
import com.study.uploadfiles.model.entity.User;
import com.study.uploadfiles.model.mapper.UserMapper;
import com.study.uploadfiles.model.service.IUserService;
import com.study.uploadfiles.util.IUploadFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/users")
@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private IUploadFileService uploadFileService;

    @GetMapping
    public List<UserDTO> findAllUsers() {
        return userMapper.toListDTO(userService.findAllUsers());
    }

    @GetMapping(value = "/{id}")
    public UserDTO findByUserId(@PathVariable Long id) {
        return userMapper.toDTO(userService.findByUserId(id));
    }

    @PostMapping(consumes = { "multipart/form-data" })
    public UserDTO saveUser(@Valid User user, @RequestParam(value = "file") MultipartFile file)
            throws IllegalStateException, IOException {

        user.setAvatar(uploadFileService.saveFile(file));
        return userMapper.toDTO(userService.saveUser(user));
    }

    @PutMapping(value = "/{id}")
    public UserDTO updateByUserId(@Valid User user, @PathVariable Long id,
            @RequestParam(value = "file") MultipartFile file) throws IOException {

        User userFound = userService.findByUserId(id);

        if (userFound != null) {
            // userFound.setId(user.getId());
            userFound.setName(user.getName());
            uploadFileService.deleteFile(userFound.getAvatar());
            userFound.setAvatar(uploadFileService.saveFile(file));
            // userFound.setCreateAt(user.getCreateAt());
            userFound.setUpdateAt(Instant.now());
        }

        return userMapper.toDTO(userService.saveUser(user));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteByUserId(@PathVariable Long id) throws IOException {
        User user = userService.findByUserId(id);
        uploadFileService.deleteFile(user.getAvatar());
        userService.deleteByUserId(user.getId());
    }

}
