package com.skilldistillery.lifts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.lifts.entities.Lift;
import com.skilldistillery.lifts.repositories.LiftRepository;

@Service
public class LiftServiceImpl implements LiftService {
	
	@Autowired
	private LiftRepository liftRepo;
	
	@Override
	public List<Lift> getAllLifts() {
		return liftRepo.findAll();
	}

	@Override
	public Lift getLiftById(int liftId) {
		// TODO Auto-generated method stub
		return null;
	}

}
