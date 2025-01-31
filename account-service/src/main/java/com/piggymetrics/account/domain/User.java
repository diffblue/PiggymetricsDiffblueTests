package com.piggymetrics.account.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class User {

	@NotNull
	@Length(min = 3, max = 20)
	private String username;

	@NotNull
	@Length(min = 6, max = 40)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (username.length() < 3) {
			throw new IllegalArgumentException();
		}
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password.length() < 6) {
			throw new IllegalArgumentException();
		}
		this.password = password;
	}
}