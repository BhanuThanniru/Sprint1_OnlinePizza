package com.cg.onlinepizza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.onlinepizza.entities.Coupan;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidCoupanOperationException;

@Service
public interface ICoupanService {
	 Coupan addCoupans(Coupan coupan);
	 Coupan editCoupans(Coupan coupan) ; 
	 Optional<Coupan>listCoupanById(int id);
	 Coupan deleteCoupanById(int id) throws InvalidCoupanOperationException;
	 List<Coupan> listAllCoupans();
	
	
}

	/*Coupan addCoupans(Coupan coupan);

	Coupan editCoupans(Coupan coupan)throws InvalidCoupanOperationException;

	Coupan deleteCoupans(int coupanId)throws CoupanIdNotFoundException;

	List<Coupan> viewCoupans();
}*/
