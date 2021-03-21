/*
 * package com.cg.onlinepizza;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertNull;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.junit.jupiter.api.AfterAll; import
 * org.junit.jupiter.api.AfterEach; import org.junit.jupiter.api.BeforeAll;
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 * import com.cg.onlinepizza.dao.ICustomerRepository; import
 * com.cg.onlinepizza.entities.Customer; import
 * com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;
 * 
 * 
 * 
 * class ICustomerRepositoryImplTest {
 * 
 * @Autowired
 * 
 * 
 * private ICustomerRepository repo;
 * 
 * @BeforeAll static void setUpBeforeClass() throws Exception { }
 * 
 * @AfterAll static void tearDownAfterClass() throws Exception { }
 * 
 * @BeforeEach void setUp() throws Exception {
 * 
 * }
 * 
 * @AfterEach void tearDown() throws Exception { }
 * 
 * 
 * 
 * 
 * @Test void Addcustomer() { Customer c1 =new
 * Customer(2,"Vandu",9810830597l,"neha@gmail.com","Laxminagar","Neha_Saxena",
 * "12345678"); Customer c2=new
 * Customer(2,"Vandu",9810830597l,"neha@gmail.com","Laxminagar","Neha_Saxena",
 * "12345678"); repo.addCustomer(c1);
 * 
 * assertEquals(c1.getCustomerName(),c2.getCustomerName(),()-
 * >"Object should return the same name");
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * @Test void UpdateCustomer() {
 * 
 * Customer c2=new
 * Customer(2,"Neha",9810830597l,"neha@gmail.com","Laxminagar","Neha_Saxena123",
 * "12345678"); repo.updateCustomer(c2);
 * 
 * assertEquals("Neha",c2.getCustomerName(),()-
 * >"Object should return the same name");
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @Test void DelCustomer() throws CustomerIdNotFoundException {
 * 
 * Integer id=2; Customer customerdeleted= repo.deleteCustomer(id);
 * assertNull(customerdeleted);
 * 
 * }
 * 
 * 
 * 
 * 
 * @Test void SpecificCustomer() throws CustomerIdNotFoundException { int id=2;
 * Customer c1=new Customer(); c1=repo.viewCustomer(id);
 * 
 * assertEquals(c1.getCustomerId(),2);
 * 
 * }
 * 
 * 
 * @Test void AllCustomer() { Customer c1=new
 * Customer(3,"Nikhil",123456789l,"nikhil@gmail.com","Khan Market","Nikhil_1234"
 * ,"1234567890"); Customer c2=new
 * Customer(4,"Sanjay",987456321l,"sanjay@gmail.com","RK Puram","Sanjay_1234",
 * "1284539"); Customer c3=new
 * Customer(5,"amandeep",587469321l,"amandeep@gmail.com","PatelNagar",
 * "amandeep_1234","25874685");
 * 
 * 
 * 
 * repo.addCustomer(c1); repo.addCustomer(c2); repo.addCustomer(c3);
 * 
 * 
 * List<Customer> list1=new ArrayList<Customer>(); list1.add(c1); list1.add(c2);
 * list1.add(c3);
 * 
 * List<Customer> list2 = (ArrayList<Customer>)repo.viewCustomers();
 * 
 * int list1size=list1.size(); int list2size=list2.size();
 * 
 * assertEquals(list1size,list2size); }
 * 
 * 
 * }
 */