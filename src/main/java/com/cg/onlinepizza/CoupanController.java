package com.cg.onlinepizza;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.entities.Coupan;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidCoupanOperationException;
import com.cg.onlinepizza.services.ICoupanService;

@RestController
public class CoupanController {
	
	@Autowired
	private ICoupanService  coupanService;
	
	//adding coupans
	
	@PostMapping("/coupans")
	public ResponseEntity<Coupan> addCoupans(@RequestBody Coupan coupan)
	{
		coupanService.addCoupans(coupan);
		
		return new ResponseEntity<Coupan>(coupan,HttpStatus.OK);
	}
	
	
	//updating coupan 
	
	  @PutMapping("/coupans/{id}") 
	  public ResponseEntity<Coupan> editCoupans(@RequestBody Coupan coupan, @PathVariable int id) throws CoupanIdNotFoundException
	  {
		  Optional<Coupan> c1=coupanService.listCoupanById(id);
			/*
			 * if(c1.isPresent()==false) { return ResponseEntity.notFound().build(); } else
			 * {
			 */
			  coupanService.editCoupans(coupan);
			  return new ResponseEntity<Coupan>(coupan,HttpStatus.OK);
		  }
	  
	  //deleting coupan
	
	  @DeleteMapping("/coupans/{id}") 
	   public ResponseEntity<Coupan> deleteCoupans(@PathVariable int id) throws InvalidCoupanOperationException
	  {
		  //Optional<Coupan> c1=coupanService.viewCoupans(id);
			/*
			 * if(c1.isPresent()==false) { return ResponseEntity.notFound().build(); } else
			 * {
			 */ 
		  //Optional<Coupan>c1= coupanService.deleteCoupan(id);
		  
		  coupanService.deleteCoupanById(id);
		  return new ResponseEntity<Coupan>(HttpStatus.OK);
		  //return new ResponseEntity<Optional<Coupan>>(c1,HttpStatus.OK);
		  }
	  
	  
	  //view coupan
	  
	  @GetMapping("/coupans")
		public ResponseEntity<List<Coupan>> listCoupans()
		{
			List<Coupan> listAllCoupan= coupanService.listAllCoupans();
			return new ResponseEntity<List<Coupan>>(listAllCoupan,HttpStatus.OK);
		}
	  
	  @GetMapping("/coupans/{id}")
	  public ResponseEntity<Optional<Coupan>> listCoupanById(@PathVariable int id) 
		{
		  Optional<Coupan> c1=coupanService.listCoupanById(id);
		  
			
			return new ResponseEntity<Optional<Coupan>>(c1,HttpStatus.OK);
		}
	  
	
	
	
	
	/*
	 * @PutMapping("/coupans") public ResponseEntity<Coupan>
	 * editCoupans(@RequestBody Coupan coupan) { coupanservice.editCoupans(coupan);
	 * return new ResponseEntity<Coupan>(coupan,HttpStatus.OK); }
	 */
}
