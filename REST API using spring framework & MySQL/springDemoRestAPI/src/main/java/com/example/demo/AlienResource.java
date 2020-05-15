package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("Aliens")
public class AlienResource {
	
	@Autowired
	AlienRepo repo;
	
	
	@GetMapping("aliens")
	public List<Alien> getAliens()
	{
		
		
		List<Alien> aliens = (List<Alien>) repo.findAll();
		return aliens;	
		
	}
	
	@GetMapping("alien/{id}")
	public Optional<Alien> getAlien(@PathVariable("id") int id)
	{
		return repo.findById(id);
	}
	 
	@PostMapping("alien")
    public Alien createAlien(@RequestBody final Alien a) {	
		
		return repo.save(a);
		
	}
	
	@PutMapping("alien")
    public Alien updateAlien(@RequestBody final Alien a) {	
		
		return repo.save(a);
		
	}
	
	@DeleteMapping("alien/{id}")
    public Optional<Alien> deleteAlien(@PathVariable("id") int id) {	
		
		Optional<Alien> a = repo.findById(id);
		
		if(a.isPresent())
		repo.deleteById(id);
		return a;
		
	}
}
