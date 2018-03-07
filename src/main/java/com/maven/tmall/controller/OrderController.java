package com.maven.tmall.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maven.tmall.pojo.Order;
import com.maven.tmall.service.OrderItemService;
import com.maven.tmall.service.OrderService;
import com.maven.tmall.util.Page;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderItemService orderItemService;

	@RequestMapping("admin_order_list")
	public String list(Model model, Page page) {
		PageHelper.offsetPage(page.getStart(), page.getCount());

		List<Order> os = orderService.list();

		int total = (int) new PageInfo(os).getTotal();
		page.setTotal(total);

		orderItemService.fill(os);

		model.addAttribute("os", os);
		model.addAttribute("page", page);

		return "admin/listOrder";
	}

	@RequestMapping("admin_order_delivery")
	public String delivery(int id) {
		// System.out.println(id);
		Order order = orderService.get(id);
		// System.out.println(order);
		order.setDeliveryDate(new Date());
		// System.out.println(order);
		order.setStatus(OrderService.waitConfirm);
		// System.out.println(order);
		orderService.update(order);
		return "redirect:admin_order_list";
	}

}
