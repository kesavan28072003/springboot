package com.example.demo.day5.onlinestorecontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.day5.onlinestoremodel.*;
import com.example.demo.day5.onlinestoreservice.*;

@RestController
public class onlinestorecontroller {
	@Autowired
	onlinestoreservice gser;
	@PostMapping("/savegift")
	public onlinestoremodel saveGiftDetails(@RequestBody onlinestoremodel gm)
	{
		return gser.saveDetails(gm);
	}
	@PutMapping("/updategift")
	public onlinestoremodel updateHotelDe(@RequestBody onlinestoremodel gm) {
		return gser.updateDetails(gm);
	}
	@DeleteMapping("/delete/{serialNum}")
	public String deleteds(@PathVariable("serialNum")int serialNum) {
		gser.delete(serialNum);
		return "Data in the  "+serialNum+"th row is deleted....";
	}
	@DeleteMapping("/deletegift/{serialNum}")
	public ResponseEntity<String> deleteGiftInfo(@PathVariable int serialNum){
		boolean deleted = gser.deleteGift(serialNum);
		
		if (deleted) {
			return ResponseEntity.ok("Data in the " + serialNum+ "th row is deleted successfully...");
		}
		
		else{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(serialNum+ "th row is not found...");
		}
		
	}
	@GetMapping("/users/{userId}")
	public ResponseEntity<?>getUserId(@PathVariable int userId)
	{
	Optional<onlinestoremodel>gift=gser.getUserId(userId);
	if(gift!=null) {
		return ResponseEntity.ok(gift); 
	}
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not available in "+userId+"th row");
		
	}
	@GetMapping("/getonlinestore")
	public List<onlinestoremodel> getonlinestoreDetails()
	{
		return gser.getDetails();
	}
}