package xyz.dulpyhb.tmall_ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import xyz.dulpyhb.tmall_ssm.entity.Category;
import xyz.dulpyhb.tmall_ssm.entity.Property;
import xyz.dulpyhb.tmall_ssm.service.CategoryService;
import xyz.dulpyhb.tmall_ssm.service.PropertyService;
import xyz.dulpyhb.tmall_ssm.util.Page;

@Controller
@RequestMapping("")
public class PropertyController {

@Autowired
CategoryService categoryService;
@Autowired
PropertyService propertyService;

@RequestMapping("admin_property_add")
public String add(Model model,Property p) {
	propertyService.add(p);
	return "redirct:admin_property_list?cid="+p.getCid();
}
@RequestMapping("admin_property_delete")
public String delete(int id) {
	Property p = propertyService.get(id);
	return "redirct:admin_property_list?cid="+p.getCid();
}

@RequestMapping("admin_property_edit")
public String edit(Model model,int id ) {
	Property p = propertyService.get(id);
	Category c = categoryService.get(p.getCid());
	p.setCategory(c);
	model.addAttribute("p",p);
	return "admin/editProperty";
}
@RequestMapping("admin_property_update")
public String update(Property p) {
	propertyService.update(p);
	return "redirct:admin+property_list?cid="+p.getCid();
}
@RequestMapping("admin_property_list")
public String list(int cid,Model model,Page page) {
	Category c = categoryService.get(cid);
	PageHelper.offsetPage(page.getStart(), page.getCount());
	List<Property> ps = propertyService.list(cid);
	int total = (int) new PageInfo<>(ps).getTotal();
	page.setTotal(total);
	page.setParam("&cid="+c.getId());
	model.addAttribute("ps", ps);
	model.addAttribute("c", c);
	model.addAttribute("page", page);
	return "admin/listProperty";
}
}
