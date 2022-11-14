package com.course.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.workshopmongo.domain.User;
import com.course.workshopmongo.repository.UserRepository;
import com.course.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		
		return repo.findAll();
		
				
	}
	
	
	public Optional<User> findById(String id) {
		
		Optional<User> user = repo.findById(id);
		
		if(!user.isPresent()) {
			
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return user;
		
		
		
	}

}
