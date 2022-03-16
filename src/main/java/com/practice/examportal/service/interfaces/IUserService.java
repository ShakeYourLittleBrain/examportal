package com.practice.examportal.service.interfaces;

import java.util.Set;

import com.practice.examportal.model.User;
import com.practice.examportal.model.UserRole;

public interface IUserService {
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	public User getUser(String name) throws Exception;
	public User updateUser(User user) throws Exception;
	public Integer deleteUser(String name) throws Exception;
}
