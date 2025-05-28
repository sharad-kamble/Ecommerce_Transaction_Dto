package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PlacedOrder;

public interface PlacedOrderRepo extends JpaRepository<PlacedOrder, Integer> {

}
