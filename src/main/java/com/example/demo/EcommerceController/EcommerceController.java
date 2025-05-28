package com.example.demo.EcommerceController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RequestDto;
import com.example.demo.entity.CartItem;
import com.example.demo.entity.Order;
import com.example.demo.service.CartItemAndOrderService;
import com.example.demo.service.PaymentAndPlacedOrderService;

@RestController
public class EcommerceController {

	@Autowired
	CartItemAndOrderService cardAndOrderService;

	@Autowired
	PaymentAndPlacedOrderService paymentAndPlacedOrderService;

	@PostMapping("/cart-with-orders")
	public ResponseEntity<String> placeOrder(@RequestBody RequestDto dto) {
		cardAndOrderService.addCartItemAndOrder(dto);
		return new ResponseEntity<>("Cart items and order saved successfully", HttpStatus.CREATED);
	}

	@PostMapping("/payment-with-placedorder")
	public ResponseEntity<String> makePayment(@RequestBody RequestDto dto) {
		paymentAndPlacedOrderService.addPaymentAndPlacedOrder(dto);
		return new ResponseEntity<>("Payment and Placed Order saved successfully", HttpStatus.CREATED);
	}

	@GetMapping("/cart-items")
	public ResponseEntity<List<CartItem>> getAllCartItems() {
		return ResponseEntity.ok(cardAndOrderService.getAllCartItems());
	}

	@GetMapping("/get-all-placedorders-and-payments")
	public ResponseEntity<List<Order>> getAllPaymentAndPlacedOrder() {
		return ResponseEntity.ok(cardAndOrderService.getAllPaymentAndPlacedOrder());
	}
}
