package com.cg.onlinepizza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.onlinepizza.entities.Coupan;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;

@Service
public interface ICoupanService {
	
	 Coupan addCoupans(Coupan coupan);
	 
	 Coupan editCoupans(int coupanId, Coupan coupan) throws CoupanIdNotFoundException ; 
	 
	 //Coupan editCoupans(int id) throws CoupanIdNotFoundException;

	 Optional<Coupan>listCoupanById(int id);
	 
	 Coupan deleteCoupanById(int id) throws CoupanIdNotFoundException;
	 
	 List<Coupan> listAllCoupans();
	
	
}
