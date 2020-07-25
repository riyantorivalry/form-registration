package com.technolins.registrationform.service;

import com.technolins.registrationform.entity.User;

public interface SignupService {
	public User findOne(User user);
	public User save (User user);
	public boolean isExistById(Long id);
	public boolean isExistByMobileNumber(String mobileNumber);
	public boolean isExistByEmail(String email);
}
