package com.course.workshopmongo.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.course.workshopmongo.domain.User;
import com.course.workshopmongo.dto.UserDTO;
import com.course.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UseResource {
	
	@Autowired
	private UserService service;
	
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		
		//List<User> users = new ArrayList<>();
		//User maria = new User("1001", "Maria Brown", "maria@gmail.com");
		//User alex = new User("1002", "Alex Green", "alex@gmail.com");
		//users.addAll(Arrays.asList(maria, alex));
		List<User> users = service.findAll();
		List<UserDTO> listDto = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	
		
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		
		Optional<User> obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
		
	}

}
