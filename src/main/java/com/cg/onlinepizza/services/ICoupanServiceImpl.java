package com.cg.onlinepizza.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinepizza.dao.ICoupanRepository;
import com.cg.onlinepizza.entities.Coupan;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidCoupanOperationException;


@Service
public class ICoupanServiceImpl implements ICoupanService {
	
	@Autowired
	private ICoupanRepository repo;
	
	
	@Override
	public Coupan addCoupans(Coupan coupan) {
		// TODO Auto-generated method stub
		return repo.save(coupan);
		
	}
	

	@Override
	public Coupan editCoupans(Coupan coupan) {
	   
		return repo.save(coupan);
	}
	
	/*
	 * @Override public Coupan deleteCoupans(Coupan coupan) throws
	 * InvalidCoupanOperationException { // TODO Auto-generated method stub
	 * repo.delete(coupan); return coupan; }
	 */
	
	
	
	  @Override 
	  public Coupan deleteCoupanById(int id) throws InvalidCoupanOperationException{ 
		  // TODO Auto-generated method stub Optional
		  Optional<Coupan> coupan= repo.findById(id); 
		   coupan.orElseThrow(() -> new InvalidCoupanOperationException("Coupan not found"));
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

	



	


