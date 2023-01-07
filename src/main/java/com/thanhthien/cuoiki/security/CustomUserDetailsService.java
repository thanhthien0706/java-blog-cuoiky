package com.thanhthien.cuoiki.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thanhthien.cuoiki.model.UserEntity;
import com.thanhthien.cuoiki.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) {
		UserEntity user = userRepository.findByUserName(username);

//		Boolean checkPass = passwordEncoder.matches(updatePassForm.getOldPassword(), oldUser.getPassword());

		if (user != null) {
			return new CustomUserDetails(user, user.getId());
		}

		return (UserDetails) new UsernameNotFoundException("Invalid email or password");
	}

	public UserDetails loadUserById(long id) {
		UserEntity user = userRepository.findOneById(id);
		;
		return new CustomUserDetails(user, user.getId());
	}

}
