package xyz.dulpyhb.tmall_ssm.mapper;

import java.util.List;
import xyz.dulpyhb.tmall_ssm.entity.PropertyValue;
import xyz.dulpyhb.tmall_ssm.entity.PropertyValueExample;

public interface PropertyValueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PropertyValue record);

    int insertSelective(PropertyValue record);

    List<PropertyValue> selectByExample(PropertyValueExample example);

    PropertyValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PropertyValue record);

    int updateByPrimaryKey(PropertyValue record);
}