package com.bhaskar.sample.demoswagger.service;

import com.bhaskar.sample.demoswagger.config.UserProps;
import com.bhaskar.sample.demoswagger.controller.DemoController;
import com.bhaskar.sample.demoswagger.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserProps userProps;

    public List<User> getUsers(){
        LOG.info("inside getUsers() service");
        return userProps.getUser();
    }
}
