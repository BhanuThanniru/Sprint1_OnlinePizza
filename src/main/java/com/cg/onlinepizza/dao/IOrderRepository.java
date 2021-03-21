package com.cg.onlinepizza.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizza.entities.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Integer> {
   
    @Query("select p from Order p where customer_id= ?1")
    List<Order> getAllOrders(@Param("customerId") int customerId);
    
    //@Query("select cost from PizzaCost p where size = ?1 and pizza.id = ?2")
    //public int getPriceBasedOnPizzaSize(@Param("size") String size, @Param("id") int id );

}


