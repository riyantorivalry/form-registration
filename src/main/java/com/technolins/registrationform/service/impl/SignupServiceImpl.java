package com.technolins.registrationform.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technolins.registrationform.entity.User;
import com.technolins.registrationform.repository.UserRepository;
import com.technolins.registrationform.service.SignupService;

@Service
public class SignupServiceImpl implements SignupService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User findOne(User entity) {
		Optional<User> optUser = userRepository.findById(entity.getId());
		return optUser.get();
	}

	@Override
	@Transactional
	public User save(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public boolean isExistById(Long id) {
		return userRepository.existsById(id);
	}

	@Override
	public boolean isExistByMobileNumber(String mobileNumber) {
		return userRepository.isExistByMobileNumber(mobileNumber);
	}

	@Override
	public boolean isExistByEmail(String email) {
		return userRepository.isExistByEmail(email);
	}
}
