package org.qianrenxi.core.system.dto;

public class UserDto {

	private Long id;
	private String username;
	private String email;
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private String displayName;
	
	private Long createdById;
	private String createdByUsername;
	private String createdByDisplayName;
	
	private Long lastModifiedById;
	private String lastModifiedByUsername;
	private String lastModifiedByDisplayName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public Long getCreatedById() {
		return createdById;
	}
	public void setCreatedById(Long createdById) {
		this.createdById = createdById;
	}
	public String getCreatedByUsername() {
		return createdByUsername;
	}
	public void setCreatedByUsername(String createdByUsername) {
		this.createdByUsername = createdByUsername;
	}
	public String getCreatedByDisplayName() {
		return createdByDisplayName;
	}
	public void setCreatedByDisplayName(String createdByDisplayName) {
		this.createdByDisplayName = createdByDisplayName;
	}
	public Long getLastModifiedById() {
		return lastModifiedById;
	}
	public void setLastModifiedById(Long lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}
	public String getLastModifiedByUsername() {
		return lastModifiedByUsername;
	}
	public void setLastModifiedByUsername(String lastModifiedByUsername) {
		this.lastModifiedByUsername = lastModifiedByUsername;
	}
	public String getLastModifiedByDisplayName() {
		return lastModifiedByDisplayName;
	}
	public void setLastModifiedByDisplayName(String lastModifiedByDisplayName) {
		this.lastModifiedByDisplayName = lastModifiedByDisplayName;
	}
}
