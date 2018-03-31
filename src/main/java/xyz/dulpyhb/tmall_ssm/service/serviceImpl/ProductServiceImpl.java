package xyz.dulpyhb.tmall_ssm.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.dulpyhb.tmall_ssm.entity.Category;
import xyz.dulpyhb.tmall_ssm.entity.Product;
import xyz.dulpyhb.tmall_ssm.entity.ProductExample;
import xyz.dulpyhb.tmall_ssm.entity.ProductImage;
import xyz.dulpyhb.tmall_ssm.mapper.ProductMapper;
import xyz.dulpyhb.tmall_ssm.service.CategoryService;
import xyz.dulpyhb.tmall_ssm.service.ProductImageService;
import xyz.dulpyhb.tmall_ssm.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{

@Autowired
ProductMapper productMapper;
	
@Autowired
CategoryService categoryService;

@Autowired
ProductImageService productImageService;
@Override
public void add(Product p) {
	productMapper.insert(p);
	
}

@Override
public void delete(int id) {
	productMapper.deleteByPrimaryKey(id);
	
}

@Override
public void update(Product p) {
	productMapper.updateByPrimaryKeySelective(p);
	
}

@Override
public Product get(int id) {
	Product p = productMapper.selectByPrimaryKey(id);
	setCategory(p);
	return p;
}
public void setCategory(List<Product> ps) {
	for(Product p : ps) {
		setCategory(p);
	}
}

private void setCategory(Product p) {
int cid = p.getCid();
Category c = categoryService.get(cid);
p.setCategory(c);
	
}

@Override
public List list(int cid) {
	ProductExample example = new ProductExample();
	example.createCriteria().andCidEqualTo(cid);
	example.setOrderByClause("id desc");
	List result = productMapper.selectByExample(example);
	setCategory(result);
	setFirstProductImage(result);
	return result;
}

@Override
public void setFirstProductImage(Product p) {
	List<ProductImage>pis =productImageService.list(p.getId(), ProductImageService.type_single);
	if(!pis.isEmpty()) {
		ProductImage pi = pis.get(0);
		p.setFirstProductImage(pi);
	}
}
public void setFirstProductImage(List<Product> ps) {
	for(Product p:ps) {
		setFirstProductImage(p);
	}
}
}