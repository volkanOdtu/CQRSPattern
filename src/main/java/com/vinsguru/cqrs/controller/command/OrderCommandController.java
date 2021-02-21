package com.vinsguru.cqrs.controller.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinsguru.cqrs.dto.OrderCommandDto;
import com.vinsguru.cqrs.service.OrderCommandService;

@RestController
@RequestMapping("/po")
@ConditionalOnProperty(name = "app.write.enabled" ,havingValue = "true")
public class OrderCommandController {
	
	@Autowired
	private OrderCommandService orderCommandService;
	
	@PostMapping("/sale")
	public void placeOrder(@RequestBody OrderCommandDto dto) {
		this.orderCommandService.createOrder(dto.getUserIndex(), dto.getProductIndex());
	}
	
	@PutMapping("/cancel-order/{orderId}")
	public void cancelOrder(@PathVariable long orderId) {
		this.orderCommandService.cancelOrder(orderId);
	}
}
