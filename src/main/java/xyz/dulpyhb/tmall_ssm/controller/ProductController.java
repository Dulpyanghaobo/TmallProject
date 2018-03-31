package xyz.dulpyhb.tmall_ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import xyz.dulpyhb.tmall_ssm.entity.Category;
import xyz.dulpyhb.tmall_ssm.entity.Product;
import xyz.dulpyhb.tmall_ssm.service.CategoryService;
import xyz.dulpyhb.tmall_ssm.service.ProductService;
import xyz.dulpyhb.tmall_ssm.util.Page;

@Controller
@RequestMapping("")
public class ProductController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	@RequestMapping("admin_product_add")
	public String add(Model model,Product p) {
		return "redirect:admin_product_list?cid="+p.getCid();
	}
	@RequestMapping("admin_product_delete")
	public String delete(int id) {
		Product p = productService.get(id);
		productService.delete(id);
		return "redirect:admin_product_list?cid="+p.getCid();
	}
	
	@RequestMapping("admin_product_edit")
	public String edit(Model model,int id) {
		Product p = productService.get(id);
		Category c = categoryService.get(id);
		p.setCategory(c);
		model.addAttribute("p",p);
		return "redirect:editProduct";
	}
	
	@RequestMapping("admin_product_update")
	public String update(Product p) {
		productService.update(p);
		return "redirect:admin_product_list?cid="+p.getCid();
	}
	
	@RequestMapping("admin_product_list")
	public String list(int cid, Model model, Page page) {
	    Category c = categoryService.get(cid);
	 
	    PageHelper.offsetPage(page.getStart(),page.getCount());
	    List<Product> ps = productService.list(cid);
	 
	    int total = (int) new PageInfo<>(ps).getTotal();
	    page.setTotal(total);
	    page.setParam("&cid="+c.getId());
	 
	    model.addAttribute("ps", ps);
	    model.addAttribute("c", c);
	    model.addAttribute("page", page);
	 
	    return "admin/listProduct";
	}
}
