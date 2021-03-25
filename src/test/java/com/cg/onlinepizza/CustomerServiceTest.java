package com.cg.onlinepizza;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlinepizza.dao.ICustomerRepository;
import com.cg.onlinepizza.entities.Customer;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;
import com.cg.onlinepizza.services.CustomerServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CustomerServiceTest {
	
	@Mock
	ICustomerRepository customerRepo;
	@InjectMocks
	CustomerServiceImpl customerService;
	
	static Customer cust1;
	static Customer cust2;
	static Customer cust3;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cust1=new Customer(1,"997686543","Hello","customer","Neha","ns05@gmail.com","shakarpur");
		cust2=new Customer(2,"783825478","World","customer","Ajay","ajay@gmail.com","Noida");
		cust3=new Customer(3,"9872431256","Abc123","customer","Sanjay","sanjay@gmail.com","RK Puram");
	}


	@Test
	public void addCust() {
		when(customerRepo.save(Mockito.anyObject())).thenReturn(cust1);
		assertEquals("Neha",customerService.addCustomer(cust1).getName());
	}
	
	@Test
	public void updateCust() throws CustomerIdNotFoundException {
		when(customerRepo.findById(1)).thenReturn(Optional.of(cust1));
		when(customerRepo.save(Mockito.anyObject())).thenReturn(cust1);
		assertEquals("Neha",customerService.updateCustomer(cust1.getId(),cust1).getName());
	}
	
	@Test
	public void deleteCust() throws CustomerIdNotFoundException
	{
		when(customerRepo.findById(1)).thenReturn(Optional.of(cust1));
		Exception exception = assertThrows(CustomerIdNotFoundException.class, () -> customerService.deleteCustomer(5));
		assertTrue(exception.getMessage().contains("Customer Id Not Found"));
	}
	
	@Test
	public void listAll()
	{
		List<Customer> list=new ArrayList<Customer>();
		list.add(cust1);
		list.add(cust2);
		list.add(cust3);
		
		when(customerRepo.findAll()).thenReturn(list);
		List<Customer> list2=customerService.viewCustomers();
		assertEquals(3,list2.size());
		verify(customerRepo,times(1)).findAll();
	}
	
	@Test
	public void listCustomerById() throws CustomerIdNotFoundException
	{
		 when(customerRepo.findById(1)).thenReturn(Optional.of(cust1));
         assertEquals("Neha",  customerService.viewCustomer(1).getName());  
	}

}
