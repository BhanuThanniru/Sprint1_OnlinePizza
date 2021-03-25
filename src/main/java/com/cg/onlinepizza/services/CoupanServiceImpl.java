package com.cg.onlinepizza.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinepizza.dao.ICoupanRepository;
import com.cg.onlinepizza.entities.Coupan;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;

@Service
public class CoupanServiceImpl implements ICoupanService {

	@Autowired
	private ICoupanRepository repo;
	
	@Override
	public Coupan addCoupans(Coupan coupan) {
		// TODO Auto-generated method stub
		return repo.save(coupan);
	}

	@Override public Coupan editCoupans(int id,Coupan coupan) throws CoupanIdNotFoundException
	{ 
		Optional<Coupan> c1 = repo.findById(id);
		c1.orElseThrow(() -> new CoupanIdNotFoundException("Coupan Id Not Found"));
		repo.save(coupan); 
		return coupan ;
	}

	@Override 
	public Coupan deleteCoupanById(int id) throws CoupanIdNotFoundException{ 
		
		Optional<Coupan> coupan= repo.findById(id); 
		coupan.orElseThrow(() -> new CoupanIdNotFoundException("Coupan not found"));
		repo.deleteById(id); 
		return coupan.get();
	}

	@Override
	public List<Coupan> listAllCoupans(){
		return repo.findAll();
	}

	@Override
	public Coupan listCoupanById(int id) throws CoupanIdNotFoundException {
		Optional<Coupan> coupan= repo.findById(id); 
		return coupan.orElseThrow(() -> new CoupanIdNotFoundException("Coupan not found"));		 
	}

}