package xyz.dulpyhb.tmall_ssm.mapper;

import java.util.List;
import xyz.dulpyhb.tmall_ssm.entity.OrderItem;
import xyz.dulpyhb.tmall_ssm.entity.OrderItemExample;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    List<OrderItem> selectByExample(OrderItemExample example);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}