package xyz.dulpyhb.tmall_ssm.controller;

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

import xyz.dulpyhb.tmall_ssm.entity.Category;
import xyz.dulpyhb.tmall_ssm.service.CategoryService;
import xyz.dulpyhb.tmall_ssm.util.ImageUtil;
import xyz.dulpyhb.tmall_ssm.util.Page;
import xyz.dulpyhb.tmall_ssm.util.UploadedImageFile;

@Controller
@RequestMapping("")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping("admin_category_list")
	public String list(Model model,Page page) {
		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<Category> cs = categoryService.list();
		int total = (int) new PageInfo<>(cs).getTotal();
		page.setTotal(total);
		model.addAttribute("cs",cs);
		model.addAttribute("page",page);
		return "admin/listCategory";
	}
	@RequestMapping("admin_category_add")
	public String add(Category c, HttpSession session,UploadedImageFile uploadedImageFile)	throws IOException {
		categoryService.add(c);
		File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
		File file = new File(imageFolder,c.getId()+".jpg");
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
			uploadedImageFile.getImage().transferTo(file);
			BufferedImage img = ImageUtil.change2jpg(file);
			ImageIO.write(img, "jpg", file);
			return "redirect:/admin_category_list";
		}
		return "redirect:/admin_category_list";
	}
	@RequestMapping("admin_category_delete")
	public String delete(int id,HttpSession httpSession )throws IOException {
		categoryService.delete(id);
		File imageFolder = new File(httpSession.getServletContext().getRealPath("img/category"));
		File file = new File(imageFolder,id+".jsp");
		file.delete();
		return "redirect:/admin_category_list";
	}
	@RequestMapping("admin_category_edit")
	public String edit(int id,Model model) throws IOException{
			Category c = categoryService.get(id);
			model.addAttribute("c",c);
		return "admin/editCategory";
	}
	@RequestMapping("admin_category_update")
	public String update(Category category,HttpSession httpSession,UploadedImageFile uploadedImageFile) throws IOException{
		categoryService.update(category);
		MultipartFile multipartFile = uploadedImageFile.getImage();
		if(null!=multipartFile && !multipartFile.isEmpty()) {
			File imageFolder = new File(httpSession.getServletContext().getRealPath("img/caregory"));
			File file = new File(imageFolder,category.getId()+".jpg");
			multipartFile.transferTo(file);
			BufferedImage img = ImageUtil.change2jpg(file);
			ImageIO.write(img, "jpg", file);
		}
		return "redirect:/admin_category_list";
	}
}
