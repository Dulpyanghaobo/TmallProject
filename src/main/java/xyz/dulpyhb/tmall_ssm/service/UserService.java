package xyz.dulpyhb.tmall_ssm.service;

import java.util.List;

import xyz.dulpyhb.tmall_ssm.entity.User;

public interface UserService {
void add(User c);
void delete(int id);
void update(User c);
User get(int id);
List list();
}
