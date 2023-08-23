package com.example.demo.day5.onlinestorecontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.day5.onlinestoremodel.*;
import com.example.demo.day5.repository.*;

@Service
public class onlinestoreservice {
	@Autowired
	onlinestorerepo grepo;
	
	public onlinestoremodel saveDetails(onlinestoremodel gm) {
		return grepo.save(gm);
	}
	public onlinestoremodel updateDetails(onlinestoremodel gm) {
		return grepo.saveAndFlush(gm);
	}
	public void delete(int serialNum) {
		System.out.print("Deleted");
		grepo.deleteById(serialNum);
	}
	public boolean deleteGift(int serialNum) {
		if(grepo.existsById(serialNum)) {
			grepo.deleteById(serialNum);
			return true;
		}
		return false;
	}
	public Optional<onlinestoremodel> getUserId(int userId)
	   {
		   Optional<onlinestoremodel>gift=grepo.findById(userId);
		   if(gift.isPresent())
		   {
			   return gift;
		   }
		   return null;
	   }
	public List<onlinestoremodel> getDetails()
	{
		return grepo.findAll();
	}
	
}