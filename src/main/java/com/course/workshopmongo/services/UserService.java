package com.course.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.workshopmongo.domain.User;
import com.course.workshopmongo.dto.UserDTO;
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
		
		Optional<User> obj = repo.findById(id);
		if(!obj.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
			
		}
		return obj;
		
		
		//return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
		
	
	public User insert(User obj) {
		
		return repo.insert(obj);
		
	}
	
	
	public void delete(String id) {
				
		repo.deleteById(id);
			
	}

	public User FromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
		
	}

	
	
}
