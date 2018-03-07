package com.maven.tmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maven.tmall.pojo.Category;
import com.maven.tmall.pojo.Product;
import com.maven.tmall.service.CategoryService;
import com.maven.tmall.service.ProductService;
import com.maven.tmall.util.Page;

@Controller
public class ProductController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@RequestMapping("admin_product_list")
	public String list(int cid, Model model, Page page) {
		Category category = categoryService.get(cid);

		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<Product> products = productService.list(cid);

		int total = (int) new PageInfo<>().getTotal();
		page.setTotal(total);
		page.setParam("&cid=" + category.getId());

		model.addAttribute("c", category);
		model.addAttribute("ps", products);
		model.addAttribute("page", page);
		return "admin/listProduct";
	}

	@RequestMapping("admin_product_add")
	public String add(Product product) {
		// System.out.println(product);
		productService.add(product);
		return "redirect:admin_product_list?cid=" + product.getCid();
	}
	
	@RequestMapping("admin_product_edit")
	public String edit(int id, Model model){
		Product product = productService.get(id);
		Category category = categoryService.get(product.getCid());
		product.setCategory(category);
		model.addAttribute("p", product);
		return "admin/editProduct";
	}
	
	@RequestMapping("admin_product_update")
	public String update(Product product){
		productService.update(product);
		return "redirect:admin_product_list?cid=" + product.getCid();
	}
	
	
	@RequestMapping("admin_product_delete")
	public String delete(int id){
		Product product = productService.get(id);
		productService.delete(id);
		return "redirect:admin_product_list?cid=" + product.getCid();
	}

}
