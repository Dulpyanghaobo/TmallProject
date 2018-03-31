package xyz.dulpyhb.tmall_ssm.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.dulpyhb.tmall_ssm.entity.Order;
import xyz.dulpyhb.tmall_ssm.entity.OrderItem;
import xyz.dulpyhb.tmall_ssm.entity.OrderItemExample;
import xyz.dulpyhb.tmall_ssm.entity.Product;
import xyz.dulpyhb.tmall_ssm.mapper.OrderItemMapper;
import xyz.dulpyhb.tmall_ssm.service.OrderItemService;
import xyz.dulpyhb.tmall_ssm.service.ProductService;

@Service
public class OrderItemServiceImpl implements OrderItemService{

@Autowired
OrderItemMapper orderItemlMapper;
@Autowired
ProductService productService;
@Override
public void add(OrderItem orderItem) {
	orderItemlMapper.insert(orderItem);
	
}
@Override
public void delete(int id) {
	orderItemlMapper.deleteByPrimaryKey(id);
	
}
@Override
public OrderItem get(int id) {
	OrderItem result = orderItemlMapper.selectByPrimaryKey(id);
	setProduct(result);
	return result;
}
@Override
public void update(OrderItem orderItem) {
	orderItemlMapper.updateByPrimaryKeySelective(orderItem);
	
}
@Override
public List<OrderItem> list() {
	OrderItemExample example =new OrderItemExample();
    example.setOrderByClause("id desc");
    return orderItemlMapper.selectByExample(example);
}
@Override
public void fill(List<Order> os) {
	for (Order o : os) {
        fill(o);
    }
	
}
@Override
public void fill(Order o) {
	OrderItemExample example =new OrderItemExample();
    example.createCriteria().andOidEqualTo(o.getId());
    example.setOrderByClause("id desc");
    List<OrderItem> ois =orderItemlMapper.selectByExample(example);
    setProduct(ois);

    float total = 0;
    int totalNumber = 0;
    for (OrderItem oi : ois) {
        total+=oi.getNumber()*oi.getProduct().getPromotePrice();
        totalNumber+=oi.getNumber();
    }
    o.setTotal(total);
    o.setTotalNumber(totalNumber);
    o.setOrderItems(ois);
}
public void setProduct(List<OrderItem>ois) {
	for(OrderItem oi:ois) {
		setProduct(oi);
	}
	
}
private void setProduct(OrderItem oi) {
    Product p = productService.get(oi.getPid());
    oi.setProduct(p);
}
}
