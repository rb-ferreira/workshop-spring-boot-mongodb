package com.course.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.workshopmongo.domain.Post;
import com.course.workshopmongo.repository.PostRepository;
import com.course.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	
	public Post findById(String id) {
		
	Optional<Post> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findBtTitle(String text){
		
		//return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
				
	}
	
	public List<Post> fullSearch(String text, Date mindate, Date maxDate){
		
		maxDate = new Date(maxDate.getTime() + 24 * 60 *60 *1000);
		
		return repo.fullSearch(text, mindate, maxDate);
		
	}
	
	
	
}
