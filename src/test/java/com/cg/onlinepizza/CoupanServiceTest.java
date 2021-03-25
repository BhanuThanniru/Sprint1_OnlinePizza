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
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.onlinepizza.dao.ICoupanRepository;
import com.cg.onlinepizza.entities.Coupan;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.services.CoupanServiceImpl;



@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CoupanServiceTest {

	@Mock
	ICoupanRepository coupanRepository;
	@InjectMocks
	CoupanServiceImpl coupanService;

	static Coupan coupan1;
	static Coupan coupan2;
	static Coupan coupan3;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		coupan1 = new Coupan(12, "Swiggy", "First Order", "50% discount for first order",50);
		coupan2 = new Coupan(13, "Zomato", "Phonepay", "60% discount upto Rs80 paying through phonepay",70);
		coupan3 = new Coupan(14, "Uber", "Paytym", "60% discount upto Rs70 paying through paytym",50);
	}

	@Test
	public void addCoupanTest()
	{
		when(coupanRepository.save(Mockito.anyObject())).thenReturn(coupan1);
		assertEquals("Swiggy", coupanService.addCoupans(coupan1).getName());
	}

	@Test
	public void editCoupanTest() throws CoupanIdNotFoundException
	{
		when(coupanRepository.findById(12)).thenReturn(Optional.of(coupan1));
		when(coupanRepository.save(Mockito.anyObject())).thenReturn(coupan1);
		assertEquals("Swiggy", coupanService.editCoupans(coupan1.getId(),coupan1).getName());     
	}

	@Test
	public void deleteCoupanTest() throws CoupanIdNotFoundException
	{
		when(coupanRepository.findById(12)).thenReturn(Optional.of(coupan1));
		Exception exception = assertThrows(CoupanIdNotFoundException.class, () -> coupanService.deleteCoupanById(15));
		assertTrue(exception.getMessage().contains("Coupan not found"));
	}

	@Test
	public void getAllCoupanList()
	{
		List<Coupan> list = new ArrayList<Coupan>();
		list.add(coupan1);
		list.add(coupan2);
		list.add(coupan3);

		when(coupanRepository.findAll()).thenReturn(list);
		List<Coupan> coupanList = coupanService.listAllCoupans();

		assertEquals(3, coupanList.size());
		verify(coupanRepository, times(1)).findAll();
	}

	@Test
	public void getCoupanByIdTest() throws CoupanIdNotFoundException
	{
		when(coupanRepository.findById(12)).thenReturn(Optional.of(coupan1));

		assertEquals("Swiggy",  coupanService.listCoupanById(12).getName());


	}
}