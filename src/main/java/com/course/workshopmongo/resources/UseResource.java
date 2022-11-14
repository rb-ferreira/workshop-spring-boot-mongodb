package com.course.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.course.workshopmongo.domain.User;
import com.course.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UseResource {
	
	@Autowired
	private UserService service;
	
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		//List<User> users = new ArrayList<>();
		//User maria = new User("1001", "Maria Brown", "maria@gmail.com");
		//User alex = new User("1002", "Alex Green", "alex@gmail.com");
		//users.addAll(Arrays.asList(maria, alex));
		List<User> users = service.findAll();
			
		return ResponseEntity.ok().body(users);
	
		
	}

}
