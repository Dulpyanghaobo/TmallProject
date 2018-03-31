package xyz.dulpyhb.tmall_ssm.mapper;

import java.util.List;
import xyz.dulpyhb.tmall_ssm.entity.Category;
import xyz.dulpyhb.tmall_ssm.entity.CategoryExample;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}