package com.bhaskar.sample.demoswagger.config;

import com.bhaskar.sample.demoswagger.model.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "config")
public class UserProps {

    private List<User> user;

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}

