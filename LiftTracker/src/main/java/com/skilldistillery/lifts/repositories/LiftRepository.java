package com.skilldistillery.lifts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.lifts.entities.Lift;

public interface LiftRepository extends JpaRepository<Lift, Integer> {
}
