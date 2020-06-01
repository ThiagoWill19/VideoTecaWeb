package com.thiagowill.videoteca.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thiagowill.videoteca.domain.User;
import com.thiagowill.videoteca.repositories.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
	@Autowired
	private UserRepository ur;
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Optional<User> find(@PathVariable int id){
		Optional<User> obj = ur.findById(id);
		return  obj;
	}
	
	
}
