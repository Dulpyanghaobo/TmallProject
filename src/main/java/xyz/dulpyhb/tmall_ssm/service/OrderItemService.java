package xyz.dulpyhb.tmall_ssm.service;

import java.util.List;

import xyz.dulpyhb.tmall_ssm.entity.Order;
import xyz.dulpyhb.tmall_ssm.entity.OrderItem;

public interface OrderItemService {
	public void add(OrderItem orderItem);
	public void delete(int id);
	public OrderItem get(int id);
	public void update(OrderItem orderItem); 
	List list();
	void fill(List<Order> os);
	void fill(Order o);
}
