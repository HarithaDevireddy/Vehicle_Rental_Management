package com.cg.vm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vm.domain.User;
import com.cg.vm.exceptions.UserIdException;
import com.cg.vm.repository.UserRepository;
import com.cg.vm.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User ValidateUser(User user)
	{
		User validateUser = userRepository.findByUserIdAndPassword(user.getUserId(), user.getPassword());
		if(validateUser == null) throw new UserIdException("Invalid User Id or Password");
		return validateUser;
	}

	public User addorUpdateUser(User user) {
		if (user.getRole().equalsIgnoreCase("admin")) {
			return userRepository.save(user);
		} else
			throw new UserIdException("Cannot Save User for " + user.getRole());
	}

	public void RemoveUser(User user) {
		if (userRepository.findByUserId(user.getUserId()) == null)
			throw new UserIdException("UserId Does Not Exists");
		userRepository.delete(user);
	}

}
