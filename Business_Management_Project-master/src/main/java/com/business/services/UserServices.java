package com.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.business.entities.User;
import com.business.repositories.UserRepository;
@Component
public class UserServices 
{
	@Autowired
	private UserRepository userRepository;
		
	
	public List<User> getAllUser()
	{
		List<User> users = (List<User>) this.userRepository.findAll();
		return users;
	}
	
	
	public User getUser(int id)
	{
		Optional<User> optional = this.userRepository.findById(id);
		User user = optional.get();
		return user;
	}
	

	public User getUserByEmail(String email)
	{
	 User user=	this.userRepository.findUserByUemail(email);
	 return user;
	}
	

	public void updateUser(User user,int id)
	{
		user.setU_id(id);
		 this.userRepository.save(user);
	}
	

	public void deleteUser(int id)
	{
		this.userRepository.deleteById(id);
	}

	
	public void addUser(User user)
	{
	this.userRepository.save(user);
	}
	
	public boolean validateLoginCredentials(String email, String password) {
	    User user = userRepository.findByUemailAndUpassword(email, password);
	    return user != null;
	}
	
	

}
