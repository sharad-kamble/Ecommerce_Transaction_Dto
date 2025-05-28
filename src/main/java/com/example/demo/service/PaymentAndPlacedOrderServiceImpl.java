package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RequestDto;
import com.example.demo.entity.Payment;
import com.example.demo.entity.PlacedOrder;
import com.example.demo.repository.PaymentRepo;
import com.example.demo.repository.PlacedOrderRepo;

@Service
public class PaymentAndPlacedOrderServiceImpl implements PaymentAndPlacedOrderService {

	@Autowired
	PaymentRepo paymentRepo;

	@Autowired
	PlacedOrderRepo placedOrderRepo;

	@Override
	public void addPaymentAndPlacedOrder(RequestDto dto) {
		savePayment(dto);
		saveplacedOrder(dto);
	}

	private void saveplacedOrder(RequestDto dto) {
		PlacedOrder placedorder = new PlacedOrder();
		placedorder.setOrderStatus(dto.getOrderStatus());
		placedorder.setShippingAddress(dto.getShippingAddress());
		placedOrderRepo.save(placedorder);
	}

	private void savePayment(RequestDto dto) {
		Payment payment = new Payment();
		payment.setAmount(dto.getAmount());
		payment.setPaymentDate(dto.getPaymentDate());
		payment.setPaymentMethod(dto.getPaymentMethod());
		paymentRepo.save(payment);

	}

	@Override
	public List<Payment> getAllPayments() {

		return paymentRepo.findAll();
	}

	@Override
	public List<PlacedOrder> getAllPlacedOrder() {

		return placedOrderRepo.findAll();
	}

}
