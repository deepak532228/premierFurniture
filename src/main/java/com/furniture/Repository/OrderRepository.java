package com.furniture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furniture.Entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
