package com.spriti.Form_Portal.service;

import com.spriti.Form_Portal.entity.User;

public interface UserService {

    User registerUser(User user);

    User loggedInUser(String email, String password);
}
