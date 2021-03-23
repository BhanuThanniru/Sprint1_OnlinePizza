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
            //throws InvalidCoupanOperationException  {
        // TODO Auto-generated method stub
        return repo.save(coupan);
    }
    
    @Override
    public Optional<Coupan> deleteCoupan(int id) throws InvalidCoupanOperationException  {
        // TODO Auto-generated method stub
         Optional <Coupan> coupan= repo.findById(id);
         repo.deleteById(id);
         return coupan;
    }

    @Override
    public List<Coupan> viewCoupans(){
            //throws InvalidCoupanOperationException  {
        // TODO Auto-generated method stub
         return repo.findAll();
    }

    @Override
    public Coupan viewCoupans(int id) {
        // TODO Auto-generated method stub
        return repo.findById(id).get();
    }
 

}