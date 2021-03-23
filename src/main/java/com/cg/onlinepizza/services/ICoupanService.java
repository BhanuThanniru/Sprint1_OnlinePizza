package com.cg.onlinepizza.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.cg.onlinepizza.entities.Coupan;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidCoupanOperationException;

@Service
public interface ICoupanService {
    public Coupan addCoupans(Coupan coupan);
    public Coupan editCoupans(Coupan coupan);
    public Optional<Coupan> deleteCoupan(int id) throws InvalidCoupanOperationException;
    
    public List<Coupan> viewCoupans();
    public Coupan viewCoupans(int id);
    
}