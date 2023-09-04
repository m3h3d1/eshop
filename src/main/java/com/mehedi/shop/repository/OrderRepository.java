package com.mehedi.shop.repository;

import com.mehedi.shop.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

}
