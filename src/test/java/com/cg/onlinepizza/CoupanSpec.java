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
 * 
 * import com.cg.onlinepizza.dao.CoupanRepositoryImpl; import
 * com.cg.onlinepizza.dao.ICoupanRepository; import
 * com.cg.onlinepizza.entities.Coupan; import
 * com.cg.onlinepizza.exceptions.CoupanIdNotFoundException; import
 * com.cg.onlinepizza.exceptions.InvalidCoupanOperationException;
 * 
 * 
 * 
 * 
 * class CoupanSpec { private ICoupanRepository repo;
 * 
 * @BeforeAll static void setUpBeforeClass() throws Exception { }
 * 
 * @AfterAll static void tearDownAfterClass() throws Exception { }
 * 
 * @BeforeEach void setUp() throws Exception { repo = new
 * CoupanRepositoryImpl(); }
 * 
 * @AfterEach void tearDown() throws Exception { }
 * 
 * 
 * @Test void addCoupantest() {
 * 
 * Coupan c1= new Coupan(12, "Swiggy", "Festival Offer","iop"); Coupan c2= new
 * Coupan(12, "Swiggy", "Festival Offer","iop"); repo.addCoupans(c2);
 * assertEquals(c1.getCoupanName(),c2.getCoupanName()); }
 * 
 * 
 * 
 * @Test void editCoupan() throws InvalidCoupanOperationException {
 * 
 * Coupan c2=new Coupan(12, "Zomato", "Festival Offer","iop");
 * repo.editCoupans(c2);
 * 
 * assertEquals("Zomato",c2.getCoupanName(),()-
 * >"Object should return the same name"); }
 * 
 * 
 * 
 * 
 * @Test void delCoupan() throws CoupanIdNotFoundException {
 * 
 * Integer id=12; Coupan coupandeleted= repo.deleteCoupans(id);
 * assertNull(coupandeleted);
 * 
 * }
 * 
 * @Test void AllCoupan() { Coupan c5=new Coupan(98,
 * "Domino","IPL Offer","30% offer pay through via Paytym"); Coupan c7=new
 * Coupan(100, "PizzaHut",
 * "Weekend Offer","30% offer pay through via Phonepay"); Coupan c8 =new
 * Coupan(105, "Uber","CCL Offer","30% offer pay through via Icici debit card");
 * 
 * repo.addCoupans(c5); repo.addCoupans(c7); repo.addCoupans(c8);
 * 
 * 
 * 
 * List<Coupan> list1=new ArrayList<Coupan>(); list1.add(c5); list1.add(c7);
 * list1.add(c8);
 * 
 * 
 * List<Coupan> list2 = (ArrayList<Coupan>) repo.viewCoupans();
 * 
 * int list1size=list1.size(); int list2size=list2.size();
 * 
 * assertEquals(list1size,list2size); }
 * 
 * }
 * 
 * 
 * 
 * 
 * @Test void editCoupantest() {
 * 
 * Coupan c =new Coupan(123, "Swiggy", "Chicken Pizza" , "Festival offer", 34);
 * Coupan cn = new Coupan(456,"Uber", "Chicken Pizza", "Summer", 234);
 * cn.setCoupan(cn);
 * 
 * Coupan c1=repo.updateCoupan(c); Coupan afterUpdate = new Coupan(123,
 * "Swiggy", "Chicken Pizza" , "IPL Cricket Offer", 34);
 * assertEquals(afterUpdate.getCoupanName(), c1.getCoupanName());
 * 
 * }
 * 
 * 
 * 
 * /*
 * 
 * @Test
 * 
 * void deleteCoupan() { int coupanId =12; boolean isExistBeforeDelete =
 * repo.findById(coupanId).isPresent(); repo.deleteById(coupanId); boolean
 * notExistAfterDelete = repo.findById(coupanId).isPresent();
 * assertTrue(isExistBeforeDelete); assertFalse(notExistAfterDelete); }
 * 
 * 
 * 
 * 
 * 
 * @Test void deleteCoupanIdtest() {
 * 
 * Coupan afterUpdate = new Coupan(123, "Swiggy", "Chicken Pizza" ,
 * "IPL Cricket Offer", 84);
 * 
 * Coupan cn = new Coupan(456, "Chicken Month", "Summer", "Passcode", 234);
 * cn.setCoupan(afterUpdate);
 * 
 * Coupan deleteCoupanId = repo.deleteCoupans(afterUpdate);
 * assertEquals(afterUpdate.getCoupanId(),deleteCoupanId.getCoupanName()); }
 * 
 * 
 * @Test void viewCoupanTest() { Coupan c =new Coupan(123, "Swiggy",
 * "Chicken Pizza" , "Festival offer", 34); Coupan cn = new Coupan(456,"Uber",
 * "Chicken Pizza", "Summer", 234); cn.setCoupan(cn); cn.addCoupan(c);
 * 
 * Coupan cn1 = new Coupan(123, "Swiggy", "Chicken Pizza" , "IPL Cricket Offer",
 * 34);; Coupan cn2 = new Coupan(678, "Mutton Month", "Winter", "Pass", 934);
 * cn2.setCoupan(cn1); cn1.addCoupan(cn2);
 * 
 * 
 * 
 * Coupan addCoupans = repo.addCoupans(c); Coupan addCoupans2
 * =repo.addCoupans(cn1); try { Coupan editCoupan=repo.editCoupans(c); } catch
 * (InvalidCoupanOperationException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * 
 * } Coupan viewCoupan = repo.viewCoupans(c.getCoupanId());
 * assertEquals(addCoupans.getCoupanName(), viewCoupans.getCoupanName());
 * 
 * }
 * 
 * @Test void viewAllCoupansTest() { Coupan c =new Coupan(123, "Swiggy",
 * "Chicken Pizza" , "Festival offer", 34); Coupan cn = new Coupan(456,"Uber",
 * "Chicken Pizza", "Summer", 234); cn.setCoupan(cn); cn.addCoupan(c);
 * 
 * Coupan cn1 = new Coupan(123, "Swiggy", "Chicken Pizza" , "IPL Cricket Offer",
 * 34);; Coupan cn2 = new Coupan(678, "Mutton Month", "Winter", "Pass", 934);
 * cn2.setCoupan(cn1); cn1.addCoupan(cn2);
 * 
 * List<Coupan> list =new ArrayList<>(); list.add(c); list.add(cn1);
 * List<Coupan> viewAllCoupans = repo.viewCoupans(); }
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */