/*
 * package com.cg.onlinepizza;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals;
 * 
 * import java.util.ArrayList; import java.util.HashMap; import java.util.List;
 * import java.util.Map;
 * 
 * import org.junit.jupiter.api.AfterAll; import
 * org.junit.jupiter.api.AfterEach; import org.junit.jupiter.api.BeforeAll;
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * 
 * import com.cg.onlinepizza.dao.IPizzaRepository; import
 * com.cg.onlinepizza.dao.PizzaRepositoryImpl; import
 * com.cg.onlinepizza.entities.Pizza; import
 * com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;
 * 
 * class PizzaSpecTest {
 * 
 * private IPizzaRepository repo;
 * 
 * @BeforeAll static void setUpBeforeClass() throws Exception { }
 * 
 * @AfterAll static void tearDownAfterClass() throws Exception { }
 * 
 * @BeforeEach void setUp() throws Exception {
 * 
 * repo = new PizzaRepositoryImpl(); }
 * 
 * @AfterEach void tearDown() throws Exception { }
 * 
 * 
 * @Test public void addPizza() {
 * 
 * Map<String, Integer> map1 = new HashMap<String, Integer>();
 * 
 * 
 * Pizza pizza1 = new Pizza(); pizza1.setPizzaId(1);
 * pizza1.setPizzaName("Tandoori"); pizza1.setPizzaType("Tandoori");
 * pizza1.setPizzaDescription("Too Delicious"); map1.put("Medium", 300);
 * map1.put("Regular", 350); map1.put("Large", 400); pizza1.setMap1(map1);
 * 
 * 
 * 
 * Map<String, Integer> map2 = new HashMap<String, Integer>(); Pizza pizza3 =
 * new Pizza(); pizza3.setPizzaId(2); pizza3.setPizzaName("Paneer");
 * pizza3.setPizzaType("Paneer"); pizza3.setPizzaDescription("Too Yummy");
 * map2.put("Medium", 350); map2.put("Regular", 400); map2.put("Large", 450);
 * pizza3.setMap1(map2);
 * 
 * 
 * //System.out.println("pizza 1 data is : "+pizza3.toString());
 * 
 * repo.addPizza(pizza3);
 * 
 * Pizza pizza2 = new Pizza(); pizza2.setPizzaId(1);
 * pizza2.setPizzaName("Tandoori"); pizza2.setPizzaType("Tandoori");
 * pizza2.setPizzaDescription("Too Delicious");
 * 
 * 
 * Pizza pizza4 = new Pizza(); pizza4.setPizzaId(1);
 * pizza4.setPizzaName("Tandoori"); pizza4.setPizzaType("Tandoori");
 * pizza4.setPizzaDescription("Too Yummy"); map2.put("Medium", 400);
 * map2.put("Regular", 450); map2.put("Large", 500); pizza4.setMap1(map2);
 * 
 * 
 * //repo.addPizza(pizza4);
 * 
 * assertEquals(pizza3.getPizzaType(),pizza2.getPizzaType(),()->
 * "Pizza ID's mapped");
 * 
 * }
 * 
 * 
 * 
 * @Test public void updatePizza() { Pizza pizza = repo.updatePizza(1,
 * "Tandoori Pizza"); Pizza pizza4= new Pizza(9, "Tandoori", "Tandoori Pizza",
 * "Too Yummy");
 * 
 * assertEquals( pizza.getPizzaName(), pizza4.getPizzaName());
 * 
 * }
 * 
 * @Test public void deletePizza() throws PizzaIdNotFoundException { Pizza pizz
 * = new Pizza(); pizz= repo.deletePizza(9); assertEquals(
 * pizz.getPizzaName(),null, () -> "Pizza deleted..."); }
 * 
 * @Test public void viewPizza() throws PizzaIdNotFoundException {
 * 
 * Pizza pizza = new Pizza(); pizza = repo.viewPizza(1); //viewing pizza by id
 * 
 * Pizza pizza3 = new Pizza(1, "Paneer", "Paneer","Too Yummy");
 * 
 * assertEquals(pizza.getPizzaName(),pizza3.getPizzaName(),()->
 * "Pizza names must match");
 * 
 * }
 * 
 * @Test public void viewPizzaList() {
 * 
 * List<Pizza> list = new ArrayList<Pizza>(); list = repo.viewPizzaList();
 * for(Pizza pizza : list) { System.out.println(pizza.toString()); }
 * //assertEquals(); } }
 */