package xyz.dulpyhb.tmall_ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import xyz.dulpyhb.tmall_ssm.entity.User;
import xyz.dulpyhb.tmall_ssm.service.UserService;
import xyz.dulpyhb.tmall_ssm.util.Page;

@Controller
@RequestMapping("")
public class UserController {
@Autowired
UserService userService;
@RequestMapping("admin_user_list")
public String list(Model model,Page page) {
	PageHelper.offsetPage(page.getStart(), page.getCount());
	List<User> us = userService.list();
	int total = (int) new PageInfo<>(us).getTotal();
	page.setTotal(total);
	model.addAttribute("us",us);
	model.addAttribute("page", page);
	return "admin/listUser";
}
}
