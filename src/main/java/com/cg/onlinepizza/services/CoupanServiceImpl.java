package com.cg.onlinepizza.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinepizza.dao.ICoupanRepository;
import com.cg.onlinepizza.entities.Coupan;
import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidCoupanOperationException;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;


@Service
public class CoupanServiceImpl implements ICoupanService {
	
	@Autowired
	private ICoupanRepository repo;
	
	
	@Override
	public Coupan addCoupans(Coupan coupan) {
		// TODO Auto-generated method stub
		return repo.save(coupan);
		
	}
	
	/*
	 * @Override public Coupan editCoupans(Coupan coupan) {
	 * 
	 * return repo.save(coupan); }
	 */
	 
	
	
	  @Override public Coupan editCoupans(int id,Coupan coupan) throws CoupanIdNotFoundException
	  { 
	   Optional<Coupan> c1 = repo.findById(id);
       c1.orElseThrow(() -> new CoupanIdNotFoundException("Coupan Id Not Found"));
	  repo.save(coupan); 
	  return coupan ;
			  
	  }
	 
	
	  
	
	
	
	
	
	  @Override 
	  public Coupan deleteCoupanById(int id) throws CoupanIdNotFoundException{ 
		  // TODO Auto-generated method stub Optional
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
    public Optional<Coupan> listCoupanById(int id) {
        // TODO Auto-generated method stub
		//System.out.println(repo.findById);
        return repo.findById(id);
    }
	
}
	
	
	
	
//	 * @Override public Optional<Coupan> listCoupanById(int id){ //throws
//	 * InvalidCoupanOperationException { // TODO Auto-generated method stub return
//	 * repo.findById(id); }
//	 * 
//	 */
	
	
	
	

	

	/*@Override
	public Optional<Coupan> viewCoupans(int id) {
		// TODO Auto-generated method stub
		return null;*/
	


	/*
	 * @Override public List<Coupan> viewCoupans() { // TODO Auto-generated method
	 * stub return null; }
	 */
	
	/*
	 * @Override public List<Coupan> viewCoupans() { // TODO Auto-generated method
	 * stub return repo.viewCoupans(); }
	 */
	
	/*
	 * @Override public Coupan deleteCoupans(int coupanId) throws
	 * CoupanIdNotFoundException { // TODO Auto-generated method stub return
	 * repo.deleteCoupans(coupanId);
	 * 
	 * }
	 */

	



	


