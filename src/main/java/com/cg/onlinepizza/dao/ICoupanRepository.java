package com.cg.onlinepizza.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlinepizza.entities.Coupan;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidCoupanOperationException;

public interface ICoupanRepository extends JpaRepository<Coupan, Integer>{
	/*
	 * Coupan addCoupans(Coupan coupan);
	 * 
	 * Coupan editCoupans(Coupan coupan)throws InvalidCoupanOperationException ;
	 * 
	 * Coupan deleteCoupans(int coupanId)throws CoupanIdNotFoundException;
	 * 
	 * List<Coupan> viewCoupans();
	 */
}
