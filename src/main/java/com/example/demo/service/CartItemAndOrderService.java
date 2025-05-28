package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RequestDto;
import com.example.demo.entity.CartItem;
import com.example.demo.entity.Order;
import com.example.demo.entity.PlacedOrder;

public interface CartItemAndOrderService {

	void addCartItemAndOrder(RequestDto dto);

	List<CartItem> getAllCartItems();

	List<Order> getAllPaymentAndPlacedOrder();

}
