package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lcs")
public class LCSController {

	@Autowired
	LCSServices service;
	
	@PostMapping
	public Response methoPost( @RequestBody Request request) throws Exception{
		if (request.setOfStrings.size() < 1)  throw new Exception(" most be set setOfStrings");
		return service.lcs(request);
	}
	
	
	
	
	
	
}
