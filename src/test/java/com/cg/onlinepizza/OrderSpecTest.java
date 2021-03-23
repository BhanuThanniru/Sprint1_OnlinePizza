/*
 * package com.cg.onlinepizza;
 * 
 * import java.util.ArrayList; import java.util.HashMap; import java.util.List;
 * import java.util.Map;
 * 
 * import org.junit.jupiter.api.AfterAll; import
 * org.junit.jupiter.api.AfterEach; import org.junit.jupiter.api.BeforeAll;
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * 
 * import com.cg.onlinepizza.dao.IOrderRepository; import
 * com.cg.onlinepizza.dao.IPizzaRepository; import
 * com.cg.onlinepizza.dao.OrderRepositoryImpl; import
 * com.cg.onlinepizza.dao.PizzaRepositoryImpl; import
 * com.cg.onlinepizza.entities.Coupan; import
 * com.cg.onlinepizza.entities.Customer; import
 * com.cg.onlinepizza.entities.Order; import com.cg.onlinepizza.entities.Pizza;
 * import com.cg.onlinepizza.exceptions.InvalidSizeException; import
 * com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;
 * 
 * class OrderSpecTest {
 * 
 * private IOrderRepository orderRepoTest;
 * 
 * @BeforeAll static void setUpBeforeClass() throws Exception { }
 * 
 * @AfterAll static void tearDownAfterClass() throws Exception { }
 * 
 * @BeforeEach void setUp() throws Exception {
 * 
 * orderRepoTest = new OrderRepositoryImpl(); }
 * 
 * @AfterEach void tearDown() throws Exception { }
 * 
 * @Test void testAdd() throws PizzaIdNotFoundException, InvalidSizeException {
 * 
 * Customer c1 = new Customer(101, "John", Long.parseLong("8945542130"),
 * "john@gmail.com", "Los Angeles", "john", "john123"); Coupan coupan = new
 * Coupan(999, "FIRST_LOGIN_COUPAN", "FIRST_LONG","Apply first coupan"); Order
 * order1 = new Order();
 * 
 * Map<Pizza, Integer> map= new HashMap<Pizza, Integer>();
 * 
 * IPizzaRepository pizzaRepo = new PizzaRepositoryImpl();
 * 
 * Pizza pizza = pizzaRepo.viewPizza(1); Pizza pizza2 = pizzaRepo.viewPizza(2);
 * List<Pizza> list1 = new ArrayList<Pizza>(); list1.add(pizza);
 * list1.add(pizza2);
 * 
 * List<Order> orderList = new ArrayList<Order>();
 * 
 * order1.setOrderId(1000001); order1.setOrderType("Veg Pizza Order");
 * order1.setOrderDescription("order setting"); order1.setCustomerId(c1);
 * order1.setCoupan(coupan); order1.setTransactionMode("Cash"); map.put(pizza,
 * 2); map.put(pizza2, 3); order1.setMapPizzaQuantity(map); orderList =
 * orderRepoTest.caluculateTotal("Medium", 2, list1);
 * 
 * 
 * }
 * 
 * }
 */