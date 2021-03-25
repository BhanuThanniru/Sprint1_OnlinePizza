package com.cg.onlinepizza.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.onlinepizza.entities.Pizza;

@Repository

public interface IPizzaRepository extends JpaRepository<Pizza, Integer> {
	
	@Query("select p from Pizza p where p.type = ?1")
	List<Pizza> getPizzaByType(@Param("pizzaType") String pizzaType);
	
	@Query("select p from Pizza p where p.name like %?1%")
	List<Pizza> getPizzaByName(@Param("pizzaName") String pizzaName);
	
	
}
