package com.bhaskar.sample.demoswagger.controller;

import com.bhaskar.sample.demoswagger.config.UserProps;
import com.bhaskar.sample.demoswagger.model.User;
import com.bhaskar.sample.demoswagger.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    private static Logger LOG = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/getUsers", produces = {"application/json"}, method = RequestMethod.GET)
    public @ResponseBody  List<User> getUsers() {
        LOG.info("inside getUsers() controller");
        return userService.getUsers();
    }
}
