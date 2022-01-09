package com.skilldistillery.lifts.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("lifts/{liftId}")
	public Lift getLiftById(@PathVariable Integer liftId) {
		return liftSvc.getLiftById(liftId);
	}
	
	@PostMapping("lifts")
	public Lift addLift(@RequestBody Lift lift,
			HttpServletResponse res) {
		Lift newLift = liftSvc.addLift(lift);
		if(newLift !=null) {
			res.setStatus(201);
		}
		else {
			res.setStatus(404);
		}
		return newLift;
	}
	
	@DeleteMapping("lifts/{liftId}")
	public void deleteLift(
			@PathVariable Integer liftId) {
		liftSvc.deleteLift(liftId);
	}
	
	
	@PutMapping("lifts/{liftId}")
	public Lift replaceLift(
			@PathVariable Integer liftId,
			@RequestBody Lift lift,
			HttpServletResponse res) {
		try {
			lift = liftSvc.updateLift(liftId, lift);
			if(lift == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			lift = null;
		}
		return lift;
	}
}
