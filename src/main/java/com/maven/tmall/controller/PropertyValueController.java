package com.maven.tmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maven.tmall.pojo.Product;
import com.maven.tmall.pojo.PropertyValue;
import com.maven.tmall.service.ProductService;
import com.maven.tmall.service.PropertyValueService;

@Controller
public class PropertyValueController {

	@Autowired
	private PropertyValueService propertyValueService;

	@Autowired
	private ProductService productService;

	@RequestMapping("admin_propertyValue_edit")
	public String edit(int pid, Model model) {
		Product product = productService.get(pid);
		propertyValueService.init(product);
		List<PropertyValue> pvs = propertyValueService.list(product.getId());

		model.addAttribute("p", product);
		model.addAttribute("pvs", pvs);

		return "admin/editPropertyValue";
	}

	@ResponseBody
	@RequestMapping("admin_propertyValue_update")
	public String update(PropertyValue propertyValue) {
		propertyValueService.update(propertyValue);
		return "success";
	}

}
