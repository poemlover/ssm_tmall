package com.maven.tmall.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maven.tmall.pojo.Product;
import com.maven.tmall.pojo.ProductImage;
import com.maven.tmall.service.ProductImageService;
import com.maven.tmall.service.ProductService;
import com.maven.tmall.util.ImageUtil;
import com.maven.tmall.util.UploadedImageFile;

@Controller
public class ProductImageController {

	@Autowired
	private ProductImageService productImageService;

	@Autowired
	private ProductService productService;

	@RequestMapping("admin_productImage_list")
	public String list(int pid, Model model) {
		Product product = productService.get(pid);
		List<ProductImage> pisSingle = productImageService.list(pid, ProductImageService.type_single);
		List<ProductImage> pisDetail = productImageService.list(pid, ProductImageService.type_detail);

		// System.out.println(pisSingle);
		// System.out.println(pisDetail);

		model.addAttribute("p", product);
		model.addAttribute("pisSingle", pisSingle);
		model.addAttribute("pisDetail", pisDetail);
		return "admin/listProductImage";
	}

	@RequestMapping("admin_productImage_add")
	public String add(ProductImage productImage, HttpSession httpSession, UploadedImageFile uploadedImageFile) {
		productImageService.add(productImage);
		String fileName = productImage.getId() + ".jpg";
		String imageFolder;
		String imageFolder_small = null;
		String imageFolder_middle = null;
		if (ProductImageService.type_single.equals(productImage.getType())) {
			imageFolder = httpSession.getServletContext().getRealPath("img/productSingle");
			imageFolder_small = httpSession.getServletContext().getRealPath("img/productSingle_small");
			imageFolder_middle = httpSession.getServletContext().getRealPath("img/productSingle_middle");
		} else {
			imageFolder = httpSession.getServletContext().getRealPath("img/productDetail");
		}

		File f = new File(imageFolder, fileName);
		f.getParentFile().mkdirs();
		try {
			uploadedImageFile.getImage().transferTo(f);
			BufferedImage img = ImageUtil.change2jpg(f);
			ImageIO.write(img, "jpg", f);

			if (ProductImageService.type_single.equals(productImage.getType())) {
				File f_small = new File(imageFolder_small, fileName);
				File f_middle = new File(imageFolder_middle, fileName);

				ImageUtil.resizeImage(f, 56, 56, f_small);
				ImageUtil.resizeImage(f, 217, 190, f_middle);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:admin_productImage_list?pid=" + productImage.getPid();
	}

	@RequestMapping("admin_productImage_delete")
	public String delete(int id, HttpSession httpSession) {
		ProductImage productImage = productImageService.get(id);
		// System.out.println(productImage);

		String fileName = productImage.getId() + ".jpg";
		String imageFolder;
		String imageFolder_small = null;
		String imageFolder_middle = null;

		if (ProductImageService.type_single.equals(productImage.getType())) {
			imageFolder = httpSession.getServletContext().getRealPath("img/productSingle");
			imageFolder_small = httpSession.getServletContext().getRealPath("img/productSingle_small");
			imageFolder_middle = httpSession.getServletContext().getRealPath("img/productSingle_middle");
			File imageFile = new File(imageFolder, fileName);
			File f_small = new File(imageFolder_small, fileName);
			File f_middle = new File(imageFolder_middle, fileName);
			imageFile.delete();
			f_small.delete();
			f_middle.delete();

		} else {
			imageFolder = httpSession.getServletContext().getRealPath("img/productDetail");
			File imageFile = new File(imageFolder, fileName);
			imageFile.delete();
		}

		productImageService.delete(id);

		return "redirect:admin_productImage_list?pid=" + productImage.getPid();
	}

}
