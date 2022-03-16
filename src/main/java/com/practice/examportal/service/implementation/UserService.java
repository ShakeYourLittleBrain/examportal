package com.practice.examportal.service.implementation;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.examportal.model.User;
import com.practice.examportal.model.UserRole;
import com.practice.examportal.repository.RoleRepository;
import com.practice.examportal.repository.UserRepository;
import com.practice.examportal.service.interfaces.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception{
		
		Optional<User> local = this.userRepo.findByName(user.getName());
		
		if(local.isEmpty()) {
			userRoles.stream().forEach(role -> roleRepo.save(role.getRoles()));
			
			user.getUserRoles().addAll(userRoles);

			return this.userRepo.save(user);
		}else {
			throw new Exception("User is already exist");
		}
	}

	@Override
	public User getUser(String name) throws Exception {
		Optional<User> temp = userRepo.findByName(name);
		return temp.orElseThrow(()-> new Exception("User does't exist"));
	}

	@Override
	public User updateUser(User user) throws Exception {
		Optional<User> userOpt = userRepo.findByName(user.getName());
		
		userOpt.orElseThrow(()-> new Exception("User doesn't exist"));
		
		User tempUp = userOpt.get();
		tempUp.setName(user.getName());
		tempUp.setSurName(user.getSurName());
		tempUp.setEmail(user.getEmail());
		tempUp.setPhone(user.getPhone());
		tempUp.setProfile(user.getProfile());
		
		return this.userRepo.save(tempUp);
	}

	@Override
	public Integer deleteUser(String name) throws Exception {
		Optional<User> userOpt = userRepo.findByName(name);

		userOpt.orElseThrow(() -> new Exception("User doesn't exist"));
		
		return this.userRepo.deleteByName(name);
	}

}
