package com.skilldistillery.lifts.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
	
	@PostMapping("lifts/{liftId}")
	public Lift addLift(@PathVariable Integer liftId,
			@RequestBody Lift lift,
			HttpServletResponse res,
			HttpServletRequest req) {
		lift = liftSvc.addLift(liftId, lift);
		if(lift == null) {
			res.setStatus(404);
		}
		else {
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(lift.getId());
			res.setHeader("Location", url.toString());
		}
		return lift;
	}
	
	@DeleteMapping("lifts/{liftId}")
	public void deleteLift(
			@PathVariable Integer liftId,
			HttpServletResponse res) {
		if(liftSvc.deleteLift(liftId)) {
			res.setStatus(204);
		}
		else {
			res.setStatus(404);
		}
	}
	
	@PutMapping("lifts/{liftId}")
	public Lift replaceLift(
			@PathVariable Integer liftId,
			@RequestBody Lift lift,
			HttpServletResponse res) {
		try {
			post = postDao.update(postId, post);
			if(post == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			post = null;
		}
		return post;
	}
}
