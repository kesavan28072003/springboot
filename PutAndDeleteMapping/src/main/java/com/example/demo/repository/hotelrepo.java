package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.hotelmodel;

public interface hotelrepo extends JpaRepository<hotelmodel,Integer>{

}