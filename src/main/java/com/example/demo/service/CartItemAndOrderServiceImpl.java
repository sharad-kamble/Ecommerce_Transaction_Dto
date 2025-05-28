package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RequestDto;
import com.example.demo.entity.CartItem;
import com.example.demo.entity.Order;
import com.example.demo.repository.CartItemRepo;
import com.example.demo.repository.OrderRepo;

@Service
public class CartItemAndOrderServiceImpl implements CartItemAndOrderService {

	@Autowired
	CartItemRepo cardItemRepo;

	@Autowired
	OrderRepo orderRepo;

	@Override
	public void addCartItemAndOrder(RequestDto dto) {

		saveCartItem(dto);
		saveOrder(dto);

	}

	private void saveOrder(RequestDto dto) {
		Order order = new Order();
		order.setAddress(dto.getAddress());
		order.setCustomerName(dto.getCustomerName());
		order.setEmail(dto.getEmail());
		orderRepo.save(order); // Save to DB

	}

	private void saveCartItem(RequestDto dto) {
		CartItem cartitem = new CartItem();
		cartitem.setProductName(dto.getProductName());
		cartitem.setQuantity(dto.getQuantity());
		cardItemRepo.save(cartitem);// Save to DB

	}

	@Override
	public List<CartItem> getAllCartItems() {

		return cardItemRepo.findAll();
	}

	@Override
	public List<Order> getAllPaymentAndPlacedOrder() {
		return orderRepo.findAll(); // List<Order> return
	}

}
