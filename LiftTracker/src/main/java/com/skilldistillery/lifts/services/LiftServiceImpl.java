package com.skilldistillery.lifts.services;

import java.util.List;
import java.util.Optional;

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
	public Lift addLift(Lift lift) {
		
		return liftRepo.save(lift);
	}

	@Override
	public void deleteLift(int liftId) {
		liftRepo.deleteById(liftId);
	}

	@Override
	public Lift updateLift(int liftId, Lift lift) {
		lift.setId(liftId);
		if(liftRepo.existsById(liftId)) {
			
			return liftRepo.saveAndFlush(lift);
		}
		return null;
	}

	@Override
	public Lift getLiftById(int liftId) {
        return liftRepo.findById(liftId);
	}	

}
