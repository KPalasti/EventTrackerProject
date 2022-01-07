package com.skilldistillery.lifts.services;

import java.util.List;

import com.skilldistillery.lifts.entities.Lift;

public interface LiftService {

	List<Lift> getAllLifts();
	Lift getLiftById(int liftId);
}
