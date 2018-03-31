package xyz.dulpyhb.tmall_ssm.mapper;

import java.util.List;
import xyz.dulpyhb.tmall_ssm.entity.Property;
import xyz.dulpyhb.tmall_ssm.entity.PropertyExample;

public interface PropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Property record);

    int insertSelective(Property record);

    List<Property> selectByExample(PropertyExample example);

    Property selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
}