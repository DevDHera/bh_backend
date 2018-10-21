package com.devin.bh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	
	public UserDetails() {
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}


	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}


	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + "]";
	}
	
	
	
	

}
