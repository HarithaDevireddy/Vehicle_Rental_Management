package com.cg.vm.service;

import com.cg.vm.domain.User;

public interface UserService {

	public User ValidateUser(User user);
	public User addorUpdateUser(User user);
	public void RemoveUser(User user) ;
}
