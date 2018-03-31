package xyz.dulpyhb.tmall_ssm.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.dulpyhb.tmall_ssm.entity.Property;
import xyz.dulpyhb.tmall_ssm.entity.PropertyExample;
import xyz.dulpyhb.tmall_ssm.mapper.PropertyMapper;
import xyz.dulpyhb.tmall_ssm.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService{

	@Autowired
	PropertyMapper propertyMapper;
	@Override
	public void add(Property c) {
		propertyMapper.insert(c);	
	}
	@Override
	public void delete(int id) {
	propertyMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void update(Property c) {
	propertyMapper.updateByPrimaryKeySelective(c);
		
	}

	@Override
	public Property get(int id) {
	
		return propertyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List list(int id) {
	PropertyExample example = new PropertyExample();
	example.createCriteria().andCidEqualTo(id);
	example.setOrderByClause("id desc");
		return propertyMapper.selectByExample(example);
	}

	
}
