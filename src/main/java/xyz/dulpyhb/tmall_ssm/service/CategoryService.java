package xyz.dulpyhb.tmall_ssm.service;

import java.util.List;

import xyz.dulpyhb.tmall_ssm.entity.Category;
import xyz.dulpyhb.tmall_ssm.util.Page;

public interface CategoryService {

List<Category> list();
public void add(Category category);
public void delete(int id);
public Category get(int id);
public void update(Category category);

}
