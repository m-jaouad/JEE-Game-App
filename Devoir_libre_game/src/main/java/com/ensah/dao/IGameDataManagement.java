package com.ensah.dao;

import java.util.List;

import com.ensah.bo.User ;


public interface IGameDataManagement {

	public List<User> getAllUsers();

	public void updateScore(User user);

	public void insertUser(User user);

	public User getUserByLogin(String login);
}
