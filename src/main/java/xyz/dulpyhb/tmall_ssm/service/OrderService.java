package xyz.dulpyhb.tmall_ssm.service;

import java.util.List;

import xyz.dulpyhb.tmall_ssm.entity.Order;

public interface OrderService {
	String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";
 
    void add(Order c);
 
    void delete(int id);
    void update(Order c);
    Order get(int id);
    List<Order> list();
}
