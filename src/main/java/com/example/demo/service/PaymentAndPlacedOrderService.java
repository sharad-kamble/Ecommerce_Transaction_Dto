package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RequestDto;
import com.example.demo.entity.Payment;
import com.example.demo.entity.PlacedOrder;

public interface PaymentAndPlacedOrderService {

	void addPaymentAndPlacedOrder(RequestDto dto);

	List<Payment> getAllPayments();

	List<PlacedOrder> getAllPlacedOrder();

}
