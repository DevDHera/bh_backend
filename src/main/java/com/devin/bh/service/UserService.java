package com.devin.bh.service;

import java.util.List;

import com.devin.bh.entity.Authorities;
import com.devin.bh.entity.User;
import com.devin.bh.entity.UserDetails;

public interface UserService {

	public List<User> getUsers();

	public void saveUser(User theUser, Authorities theAuthority, UserDetails theUserDetail);

	public User getUser(String theUserName);

	public void deleteUser(String theUserName);
	
}
