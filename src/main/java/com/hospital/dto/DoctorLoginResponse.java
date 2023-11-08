package com.hospital.dto;

public class DoctorLoginResponse {

	private String message;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public DoctorLoginResponse(String message) {
		super();
		this.message = message;
	}

	public DoctorLoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}


