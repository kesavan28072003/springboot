package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.hotelmodel;
import com.example.demo.service.hotelservice;

@RestController
public class hotelcontroller {
	@Autowired
	public hotelservice mm;
	@PostMapping("/posthotel")
	public hotelmodel saverithick(@RequestBody hotelmodel h)
	{
		return mm.saveDetails(h);
	}
	@GetMapping("/gethotel")
	public List<hotelmodel>getrithick()
	{
		return mm.getDetails();
	}

}