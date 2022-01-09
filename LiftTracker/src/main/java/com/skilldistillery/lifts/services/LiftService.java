package com.skilldistillery.lifts.services;

import java.util.List;

import com.skilldistillery.lifts.entities.Lift;

public interface LiftService {

	public List<Lift> getAllLifts();
	public Lift getLiftById(int liftId);
	public void deleteLift(int liftId);
	public Lift addLift(Lift lift);
	public Lift updateLift(int liftId, Lift lift);
}
