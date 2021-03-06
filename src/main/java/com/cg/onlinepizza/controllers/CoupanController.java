package com.cg.onlinepizza.controllers;

import java.util.List;
import javax.validation.Valid;
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
import com.cg.onlinepizza.services.ICoupanService;

@RestController
@RequestMapping("/coupans")
public class CoupanController {

	@Autowired
	private ICoupanService  coupanService;

	//adding coupans

	@PostMapping
	public ResponseEntity<Coupan> addCoupans(@Valid @RequestBody Coupan coupan)
	{
		coupanService.addCoupans(coupan);
		return new ResponseEntity<Coupan>(coupan,HttpStatus.OK);
	}

	//updating coupan 

	@PutMapping("/{id}") 
	public ResponseEntity<Coupan> editCoupans(@Valid @RequestBody Coupan coupan, @PathVariable int id) throws CoupanIdNotFoundException
	{

		Coupan c1 = coupanService.listCoupanById(id);
		coupanService.editCoupans(id,coupan);
		return new ResponseEntity<Coupan>(coupan,HttpStatus.OK);
	}

	//deleting coupan
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> deleteCoupans(@PathVariable int id) throws CoupanIdNotFoundException
	{
		coupanService.deleteCoupanById(id);
		return new ResponseEntity<>(id,HttpStatus.OK);	

	}
	@GetMapping
	public ResponseEntity<List<Coupan>> listCoupans()
	{
		List<Coupan> listAllCoupan= coupanService.listAllCoupans();
		return new ResponseEntity<List<Coupan>>(listAllCoupan,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Coupan> listCoupanById(@PathVariable int id) throws CoupanIdNotFoundException 
	{
		Coupan c1=coupanService.listCoupanById(id);
		return new ResponseEntity<Coupan>(c1,HttpStatus.OK);
		
	}
}