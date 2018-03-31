package xyz.dulpyhb.tmall_ssm.service.serviceImpl;

import java.lang.reflect.AnnotatedParameterizedType;
import java.util.List;

import org.aspectj.weaver.patterns.AndPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.dulpyhb.tmall_ssm.entity.ProductImage;
import xyz.dulpyhb.tmall_ssm.entity.ProductImageExample;
import xyz.dulpyhb.tmall_ssm.mapper.ProductImageMapper;
import xyz.dulpyhb.tmall_ssm.service.ProductImageService;
@Service
public class ProductImageServiceImpl implements ProductImageService{
@Autowired
ProductImageMapper productImageMapper;
	
	@Override
	public void add(ProductImage pi) {
		productImageMapper.insert(pi);
	}

	@Override
	public void delete(int id) {
		productImageMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void update(ProductImage pi) {
	productImageMapper.updateByPrimaryKeySelective(pi);
		
	}

	@Override
	public ProductImage get(int id) {
	
		return productImageMapper.selectByPrimaryKey(id);
	}

	@Override
	public List list(int pid, String type) {
	ProductImageExample example = new ProductImageExample();
	example.createCriteria().andPidEqualTo(pid).andTypeEqualTo(type);
	example.setOrderByClause("id desc");
		return productImageMapper.selectByExample(example);
	}

}
