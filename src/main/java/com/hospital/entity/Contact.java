package com.hospital.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contact {
	
	@Id
	private String email;
	private String Mob;
	private String address;
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the mob
	 */
	public String getMob() {
		return Mob;
	}
	/**
	 * @param mob the mob to set
	 */
	public void setMob(String mob) {
		Mob = mob;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	public Contact(String email, String mob, String address) {
		super();
		this.email = email;
		Mob = mob;
		this.address = address;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Contact [email=" + email + ", Mob=" + Mob + ", address=" + address + "]";
	}
	
	
	
	
	
	

}
