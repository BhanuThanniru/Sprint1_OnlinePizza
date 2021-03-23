package com.cg.onlinepizza.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizza.entities.Coupan;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidCoupanOperationException;

@Repository
public interface ICoupanRepository extends JpaRepository<Coupan, Integer>
{

	/*
	 * Coupan addCoupans(Coupan coupan);
	 * 
	 * Coupan editCoupans(Coupan coupan);
	 * 
	 * //Coupan deleteCoupans(int id)throws CoupanIdNotFoundException;
	 * 
	 * List<Coupan> viewCoupans();
	 * 
	 * Coupan viewCoupan(int id) throws CoupanIdNotFoundException;
	 */
     

}