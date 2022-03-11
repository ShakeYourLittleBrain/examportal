package com.practice.examportal.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String surName;
	private String email;
	private String password;
	private String phone;
	private boolean enabled;
	private String profile;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "users")
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<UserRole>();
	
	
	
	public User() {
		super();
	}
	
	public User(Long id, String name, String surName, String email, String password, String phone, boolean enabled,
			String profile) {
		super();
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.enabled = enabled;
		this.profile = profile;
	}
	
	

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surName=" + surName + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", enabled=" + enabled + ", profile=" + profile + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, enabled, id, name, password, phone, profile, surName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && enabled == other.enabled && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(phone, other.phone) && Objects.equals(profile, other.profile)
				&& Objects.equals(surName, other.surName);
	}

	

}
