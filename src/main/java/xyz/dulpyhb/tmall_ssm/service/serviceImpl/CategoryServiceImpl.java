package xyz.dulpyhb.tmall_ssm.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.dulpyhb.tmall_ssm.entity.Category;
import xyz.dulpyhb.tmall_ssm.entity.CategoryExample;
import xyz.dulpyhb.tmall_ssm.entity.PropertyExample;
import xyz.dulpyhb.tmall_ssm.mapper.CategoryMapper;
import xyz.dulpyhb.tmall_ssm.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	
	@Autowired
	CategoryMapper categoryMapper; 
	
	@Override
	public void add(Category category) {
	categoryMapper.insert(category);
		
	}
	@Override
	public void delete(int id) {
	categoryMapper.deleteByPrimaryKey(id);
		
	}
	@Override
	public Category get(int id) {
		return categoryMapper.selectByPrimaryKey(id);
	}
	@Override
	public void update(Category category) {
		categoryMapper.updateByPrimaryKeySelective(category);
		
	}
	@Override
	public List<Category> list() {
		CategoryExample example =new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
	}

	
}
