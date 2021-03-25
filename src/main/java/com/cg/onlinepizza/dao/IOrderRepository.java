package com.cg.onlinepizza.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.onlinepizza.entities.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Integer> {
    

}


