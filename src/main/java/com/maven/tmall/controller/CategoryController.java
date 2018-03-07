package com.maven.tmall.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maven.tmall.pojo.Category;
import com.maven.tmall.service.CategoryService;
import com.maven.tmall.util.ImageUtil;
import com.maven.tmall.util.Page;
import com.maven.tmall.util.UploadedImageFile;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("admin_category_list")
	public String list(Model model, Page page) {
		System.out.println(page);
		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<Category> cs = categoryService.list();
		int total = (int) new PageInfo<>(cs).getTotal();
		page.setTotal(total);
		System.out.println(page);
		model.addAttribute("cs", cs);
		model.addAttribute("page", page);
		return "admin/listCategory";
	}

	@RequestMapping("admin_category_add")
	public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
		System.out.println(c.getId());
		categoryService.add(c);
		System.out.println(c.getId());
		File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
		File file = new File(imageFolder, c.getId() + ".jpg");
		if (!file.getParentFile().exists())
			file.getParentFile().mkdirs();
		System.out.println(uploadedImageFile);
		System.out.println(uploadedImageFile.getImage());
		System.out.println(file);
		uploadedImageFile.getImage().transferTo(file);
		BufferedImage img = ImageUtil.change2jpg(file);
		ImageIO.write(img, "jpg", file);

		return "redirect:/admin_category_list";
	}

	@RequestMapping("admin_category_delete")
	public String delete(int id, HttpSession session) {
		categoryService.delete(id);

		File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
		File file = new File(imageFolder, id + ".jpg");
		file.delete();

		return "redirect:/admin_category_list";
	}

	@RequestMapping("admin_category_edit")
	public String edit(int id, Model model) {
		Category c = categoryService.get(id);
		model.addAttribute("c", c);
		return "admin/editCategory";
	}

	@RequestMapping("admin_category_update")
	public String update(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
		categoryService.update(c);
		MultipartFile image = uploadedImageFile.getImage();
		if (null != image && !image.isEmpty()) {
			File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
			File file = new File(imageFolder, c.getId() + ".jpg");
			image.transferTo(file);
			BufferedImage img = ImageUtil.change2jpg(file);
			ImageIO.write(img, "jpg", file);
		}
		return "redirect:/admin_category_list";
	}

}
