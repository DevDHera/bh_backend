package com.devin.bh.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private int enabled;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	private List<UserDetails> userDetails;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	private List<Authorities> authorities;
	
	/**
	 * @return the authorities
	 */
	public List<Authorities> getAuthorities() {
		return authorities;
	}



	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(List<Authorities> authorities) {
		this.authorities = authorities;
	}



	/**
	 * @return the userDetails
	 */
	public List<UserDetails> getUserDetails() {
		return userDetails;
	}
	
	

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(List<UserDetails> userDetails) {
		this.userDetails = userDetails;
	}

	public User() {
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the enabled
	 */
	public int getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	
	// Add convinience method
	public void addUserDetails(UserDetails theUserDetail) {
		
		if(userDetails == null) {
			userDetails = new ArrayList<>();
		}
		
		userDetails.add(theUserDetail);

	}
	
	public void addAuthorities(Authorities theAuthority) {
		
		if(authorities == null) {
			authorities = new ArrayList<>();
		}
		
		authorities.add(theAuthority);

	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}

}
