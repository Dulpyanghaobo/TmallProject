package xyz.dulpyhb.tmall_ssm.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import xyz.dulpyhb.tmall_ssm.entity.Order;
import xyz.dulpyhb.tmall_ssm.service.OrderItemService;
import xyz.dulpyhb.tmall_ssm.service.OrderService;
import xyz.dulpyhb.tmall_ssm.service.serviceImpl.OrderServiceImpl;
import xyz.dulpyhb.tmall_ssm.util.Page;

@Controller
@RequestMapping("")
public class OrderController {
@Autowired
OrderService orderService;
@Autowired
OrderItemService orderItemService;
@RequestMapping("admin_order_list")
public String list(Model model, Page page){
    PageHelper.offsetPage(page.getStart(),page.getCount());

    List<Order> os= orderService.list();

    int total = (int) new PageInfo<>(os).getTotal();
    page.setTotal(total);

    orderItemService.fill(os);

    model.addAttribute("os", os);
    model.addAttribute("page", page);

    return "admin/listOrder";
}

@RequestMapping("admin_order_delivery")
public String delivery(Order o) throws IOException {
    o.setDeliveryDate(new Date());
    o.setStatus(OrderService.waitConfirm);
    orderService.update(o);
    return "redirect:admin_order_list";
}
}
