package xyz.dulpyhb.tmall_ssm.service;

import java.util.List;

import xyz.dulpyhb.tmall_ssm.entity.Product;
import xyz.dulpyhb.tmall_ssm.entity.Property;

public interface PropertyService {

	void add(Property c);
	void delete(int id);
	void update(Property c);
	Property get(int id);
	List list(int id);

}
