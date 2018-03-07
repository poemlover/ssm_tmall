package com.maven.tmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maven.tmall.pojo.Category;
import com.maven.tmall.pojo.Property;
import com.maven.tmall.service.CategoryService;
import com.maven.tmall.service.PropertyService;
import com.maven.tmall.util.Page;

@Controller
public class PropertyController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PropertyService propertyService;

	@RequestMapping("admin_property_list")
	public String list(int cid, Model model, Page page) {
		Category c = categoryService.get(cid);

		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<Property> ps = propertyService.list(cid);// 从属性表中， 查询到 分类 为 cid 的属性

		int total = (int) new PageInfo<>(ps).getTotal();
		page.setTotal(total);
		page.setParam("&cid=" + c.getId());

		model.addAttribute("ps", ps);
		model.addAttribute("c", c);
		model.addAttribute("page", page);

		return "admin/listProperty";
	}

	@RequestMapping("admin_property_add")
	public String add(Property property, Model model) {
		propertyService.add(property);
		return "redirect:admin_property_list?cid=" + property.getCid();
	}

	@RequestMapping("admin_property_edit")
	public String edit(int id, Model model) {
		Property property = propertyService.get(id);
		Category category = categoryService.get(property.getCid());
		property.setCategory(category);
		model.addAttribute("p", property);
		return "admin/editProperty";
	}

	@RequestMapping("admin_property_update")
	public String update(Property property) {
		propertyService.update(property);
		return "redirect:admin_property_list?cid=" + property.getCid();
	}
	
	@RequestMapping("admin_property_delete")
	public String delete(int id){
		Property property = propertyService.get(id);
		propertyService.delete(id);
		return "redirect:admin_property_list?cid=" + property.getCid();
	}

}
