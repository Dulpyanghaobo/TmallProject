package xyz.dulpyhb.tmall_ssm.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.dulpyhb.tmall_ssm.entity.Order;
import xyz.dulpyhb.tmall_ssm.entity.OrderExample;
import xyz.dulpyhb.tmall_ssm.entity.User;
import xyz.dulpyhb.tmall_ssm.mapper.OrderMapper;
import xyz.dulpyhb.tmall_ssm.service.OrderService;
import xyz.dulpyhb.tmall_ssm.service.UserService;

@Service
public class OrderServiceImpl implements OrderService{
	  @Autowired
	    OrderMapper orderMapper;
	 
	    @Autowired
	    UserService userService;
	 
	@Override
	public void add(Order c) {
		orderMapper.insert(c);
		
	}

	@Override
	public void delete(int id) {
		orderMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void update(Order c) {
		orderMapper.updateByPrimaryKeySelective(c);
		
	}

	@Override
	public Order get(int id) {
		
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Order> list() {
		OrderExample example =new OrderExample();
        example.setOrderByClause("id desc");
        List<Order> result =orderMapper.selectByExample(example);
        setUser(result);
        return result;
	}
	public void setUser(List<Order> os){
        for (Order o : os)
            setUser(o);
    }
    public void setUser(Order o){
        int uid = o.getUid();
        User u = userService.get(uid);
        o.setUser(u);
    }
}
