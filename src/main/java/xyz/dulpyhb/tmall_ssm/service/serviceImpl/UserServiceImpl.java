package xyz.dulpyhb.tmall_ssm.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.dulpyhb.tmall_ssm.entity.User;
import xyz.dulpyhb.tmall_ssm.entity.UserExample;
import xyz.dulpyhb.tmall_ssm.mapper.UserMapper;
import xyz.dulpyhb.tmall_ssm.service.UserService;
@Service
public class UserServiceImpl implements UserService{
@Autowired
UserMapper userMapper;

@Override
public void add(User c) {
	userMapper.insert(c);
	
}

@Override
public void delete(int id) {
userMapper.deleteByPrimaryKey(id);
	
}

@Override
public void update(User c) {
	userMapper.updateByPrimaryKeySelective(c);
	
}

@Override
public User get(int id) {
	
	return userMapper.selectByPrimaryKey(id);
}

@Override
public List list() {
	UserExample example =new UserExample();
	example.setOrderByClause("id desc");
	return userMapper.selectByExample(example);
}
}
