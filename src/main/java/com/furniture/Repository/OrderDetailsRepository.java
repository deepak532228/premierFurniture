package com.furniture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furniture.Entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long>{

}
