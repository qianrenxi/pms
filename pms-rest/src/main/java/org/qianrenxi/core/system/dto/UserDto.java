package org.qianrenxi.core.system.dto;

public class UserDto {

	private Long id;
	private String username;
	private String email;
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private String displayName;
	private String avatar;
	
	private UserInfoDto createdBy;
	private UserInfoDto lastModifiedBy;
	
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
	public UserInfoDto getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(UserInfoDto createdBy) {
		this.createdBy = createdBy;
	}
	public UserInfoDto getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(UserInfoDto lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
