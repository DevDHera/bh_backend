package com.devin.bh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Authorities {
	
	@Column(name="authority")
	private String authority;

	public Authorities() {
	}

	/**
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	public Authorities(String authority) {
		this.authority = authority;
	}

	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Authorities [authority=" + authority + "]";
	}
	

}
