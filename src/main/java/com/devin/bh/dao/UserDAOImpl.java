package com.devin.bh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devin.bh.entity.Authorities;
import com.devin.bh.entity.User;
import com.devin.bh.entity.UserDetails;

@Repository
public class UserDAOImpl implements UserDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<User> getUsers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by user name
		Query<User> theQuery = 
				currentSession.createQuery("from users order by username",
											User.class);
		
		// execute query and get result list
		List<User> users = theQuery.getResultList();
				
		// return the results		
		return users;
	}

	@Override
	public void saveUser(User theUser, Authorities theAuthority, UserDetails theUserDetail) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Map to Joins
//		UserDetails theUserDetails =
//		theUser.addAuthorities(new Authorities(theUser.getAuthorities()));
		theUser.addAuthorities(theAuthority);
		theUser.addUserDetails(theUserDetail);
		
		// save/upate the user ... finally LOL
		currentSession.saveOrUpdate(theUser);
		
	}

	@Override
	public User getUser(String theUserName) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		User theUser = currentSession.get(User.class, theUserName);
		
		return theUser;
	}

	@Override
	public void deleteUser(String theUserName) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from users where username=:username");
		theQuery.setParameter("username", theUserName);
		
		theQuery.executeUpdate();		
	}

}











