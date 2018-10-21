package com.devin.bh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devin.bh.dao.UserDAO;
import com.devin.bh.entity.Authorities;
import com.devin.bh.entity.User;
import com.devin.bh.entity.UserDetails;;

@Service
public class UserServiceImpl implements UserService {

	// need to inject customer dao
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User theUser, Authorities theAuthority, UserDetails theUserDetail) {

		userDAO.saveUser(theUser, theAuthority, theUserDetail);
	}

	@Override
	@Transactional
	public User getUser(String theUserName) {
		
		return userDAO.getUser(theUserName);
	}

	@Override
	@Transactional
	public void deleteUser(String theUserName) {
		
		userDAO.deleteUser(theUserName);
	}
}





