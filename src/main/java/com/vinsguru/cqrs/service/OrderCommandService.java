package com.vinsguru.cqrs.service;

public interface OrderCommandService {
	void createOrder(int userIndex ,int productIndex );
	void cancelOrder(long orderId);
}
