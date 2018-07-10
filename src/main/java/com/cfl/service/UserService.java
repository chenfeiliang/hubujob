package com.cfl.service;

import org.apache.catalina.User;

import java.util.List;

public interface UserService {

    public boolean isExitByName(String name);

    public int addUser(User user);

    public int deleteUserById(int id);

    public int updateUser(User user);

    public User getUserByName(String name);

    public List<User> getUsers();
}
