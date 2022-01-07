package com.skilldistillery.lifts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.lifts.entities.Lift;
import com.skilldistillery.lifts.services.LiftService;

@RestController
@RequestMapping("api")
public class LiftController {

	@Autowired
	private LiftService liftSvc;
	
	@GetMapping("lifts")
	public List<Lift> index() {
		return liftSvc.getAllLifts();
	}
}
