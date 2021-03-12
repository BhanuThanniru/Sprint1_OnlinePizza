package com.cg.onlinepizza.service;

import java.util.List;

import com.cg.onlinepizza.dao.CoupanRepositoryImpl;
import com.cg.onlinepizza.dao.ICoupanRepository;
import com.cg.onlinepizza.entities.Coupan;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidCoupanOperationException;

public class ICoupanServiceImpl implements ICoupanService {
	
	ICoupanRepository repo = new CoupanRepositoryImpl();
	@Override
	public Coupan addCoupans(Coupan coupan) {
		// TODO Auto-generated method stub
		return repo.addCoupans(coupan);
	}
	

	@Override
	public Coupan editCoupans(Coupan coupan) throws InvalidCoupanOperationException  {
		// TODO Auto-generated method stub
		return repo.editCoupans(coupan);
	}

	@Override
	public Coupan deleteCoupans(int coupanId) throws CoupanIdNotFoundException {
		// TODO Auto-generated method stub
		return repo.deleteCoupans(coupanId);
		
	}
	

	@Override
	public List<Coupan> viewCoupans() {
		// TODO Auto-generated method stub
		return repo.viewCoupans();
	}

	

	

	

}
