package org.restapi.com.messenger.model;

import java.util.Date;

public class Profile {
	
	private long id;
	private String profileName;
	private String firtName;
	private String lastName;
	private Date created;
	
	public Profile(long id, String profileName, String firtName, String lastName) {
		super();
		this.id = id;
		this.profileName = profileName;
		this.firtName = firtName;
		this.lastName = lastName;
		created = new Date();
	}

	public Profile() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getFirtName() {
		return firtName;
	}
	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	

}
