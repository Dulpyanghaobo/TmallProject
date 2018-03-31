package xyz.dulpyhb.tmall_ssm.mapper;

import java.util.List;
import xyz.dulpyhb.tmall_ssm.entity.Order;
import xyz.dulpyhb.tmall_ssm.entity.OrderExample;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}