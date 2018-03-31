package xyz.dulpyhb.tmall_ssm.service;

import java.util.List;


import xyz.dulpyhb.tmall_ssm.entity.Product;
import xyz.dulpyhb.tmall_ssm.entity.PropertyValue;

public interface PropertyValueService {
void init(Product p);
void update(PropertyValue pv);
PropertyValue get(int ptid,int pid);
List<PropertyValue> list(int pid);

}
