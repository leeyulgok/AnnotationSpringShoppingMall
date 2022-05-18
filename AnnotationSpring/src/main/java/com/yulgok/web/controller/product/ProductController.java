package com.yulgok.web.controller.product;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yulgok.web.service.product.Product;
import com.yulgok.web.service.product.ProductServiceInt;

@Controller
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private ProductServiceInt service;
	
	
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		String type = request.getParameter("type");
		String pNumber = request.getParameter("pNumber");
		List<Product> list = service.list();
		List<Product> hitList = service.hitList();
		List<Product> recentList = service.recentList();
		List<Product> popularList = service.popularList();
		
		if(type != null) {
			if(pNumber != null) {
				list = service.list(type, pNumber);
			} else {				
				list = service.list(type);
			}
		}
		request.setAttribute("list", list);
		request.setAttribute("hitList", hitList);
		request.setAttribute("recentList", recentList);
		request.setAttribute("popularList", popularList);
		
		return "product.list";
	}
	
	@RequestMapping("typelist")
	public String typelist(HttpServletRequest request) {
		String type = request.getParameter("type");
		String pNumber = request.getParameter("pNumber");
		List<Product> list = service.list();
		
		if(type != null) {
			if(pNumber != null) {
				list = service.list(type, pNumber);
			} else {				
				list = service.list(type);
			}
		}
		request.setAttribute("list", list);
		
		return "product.typelist";
	}
	
	@RequestMapping("detail")
	public String detail(HttpServletRequest request) {
		
		String pNumber = request.getParameter("pNumber");
		List<Product> detail = service.detail(pNumber);
		List<Product> hitList = service.hitList();
		service.hit(pNumber);
		request.setAttribute("detail", detail);
		request.setAttribute("hitList", hitList);
		
		return "product.detail";
	}
	
	@RequestMapping("registerService")
	public String register(MultipartFile file, HttpServletRequest request) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8;");
		request.setCharacterEncoding("UTF-8");
		
		String site = "";
		Random rand = new Random();
		int sale = 0;
		String size = "";
		
		int randNumber = 1 + rand.nextInt(999);
		if(randNumber < 10) {
			randNumber = Integer.parseInt(String.format("00%d", randNumber));
		} else if(randNumber < 100 && randNumber > 9) {
			randNumber = Integer.parseInt(String.format("0%d", randNumber));
		}
		
		String pNumber = request.getParameter("typeNumber") + randNumber;
		String pName = request.getParameter("pName");
		System.out.println(pName);
		String type = request.getParameter("type");
		int price = Integer.parseInt(request.getParameter("price"));
		
		if(request.getParameter("size") != null) {
			size = request.getParameter("size");			
		}
		String content = request.getParameter("content");
		if(request.getParameter("sale") != null) {			
			sale = Integer.parseInt(request.getParameter("sale"));
		}
		
		String uploadPath = "/Users/iyulgog/Documents/workspace-spring-tool-suite-4-4.14.0.RELEASE/AnnotationSpring/src/main/webapp/static/image/product";
		String originalName = file.getOriginalFilename();
		String fileName = originalName.substring(originalName.lastIndexOf("///////////") + 1);
		String uuid = UUID.randomUUID().toString();
		String savefileName = uploadPath + File.separator + uuid + "_" + fileName;
		String uploadName = File.separator + uuid + "_" + fileName;
		Path savePath = Paths.get(savefileName);
	
	    try {
	        file.transferTo(savePath);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    String filePath = String.format("%s",savePath);
		int result = service.register(pNumber, pName, type, price, size, content, sale, filePath, uploadName);
		
		if(result == 1) {
			out.println("<script language='javascript'>");
			out.println("alert('Success!!')");
			out.println("</script>");
			out.flush();
			site = "product.list";
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('Failed!!')");
			out.println("</script>");
			out.flush();
			site = "product.register";
		}
		
		return site;
	}

	@RequestMapping("deleteService")
	public String delete(String pNumber) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8;");
		
		String site = "";
		int result = 0;
		
		result = service.delete(pNumber);
		if(result == 1) {
			out.println("<script language='javascript'>");
			out.println("alert('Success!!')");
			out.println("</script>");
			out.flush();
			site = "root.index";
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('Failed')");
			out.println("</script>");
			out.flush();
			site = "product.detail";
		}
		
		return site;
	}

	@RequestMapping("update")
	public String update(HttpServletRequest request, String pNumber) {
		List<Product> list = service.detail(pNumber);
		request.setAttribute("update", list);
		
		return "product.update";
	}

	@RequestMapping("updateService")
	public String updateService(MultipartFile file, HttpServletRequest request) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8;");
		request.setCharacterEncoding("UTF-8");
		
		int result = 0;
		
		String site = "";
		int sale = 0;
		
		String pNumber = request.getParameter("pNumber");
		String pName = request.getParameter("pName");
		int price = Integer.parseInt(request.getParameter("price"));
		
		String content = request.getParameter("content");
		if(request.getParameter("sale") != null) {			
			sale = Integer.parseInt(request.getParameter("sale"));
		}
		if(!file.isEmpty()) {			
			String uploadPath = "/Users/iyulgog/Documents/workspace-spring-tool-suite-4-4.14.0.RELEASE/AnnotationSpring/src/main/webapp/static/image/product";
			String originalName = file.getOriginalFilename();
			String fileName = originalName.substring(originalName.lastIndexOf("///////////") + 1);
			String uuid = UUID.randomUUID().toString();
			String savefileName = uploadPath + File.separator + uuid + "_" + fileName;
			String uploadName = File.separator + uuid + "_" + fileName;
			Path savePath = Paths.get(savefileName);
			
			try {
				file.transferTo(savePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String filePath = String.format("%s",savePath);
			result = service.updateFile(pNumber, pName, price, content, sale, filePath, uploadName);
		} else {
			result = service.update(pNumber, pName, price, content, sale);
		}
		
		if(result == 1) {
			out.println("<script language='javascript'>");
			out.println("alert('Success!!')");
			out.println("</script>");
			out.flush();
			site = "product.list";
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('Failed!!')");
			out.println("</script>");
			out.flush();
			site = "product.update";
		}
		
		return site;
	}

	@RequestMapping("search")
	public String search(HttpServletRequest request) throws UnsupportedEncodingException {
		response.setContentType("text/html; charset=UTF-8;");
		request.setCharacterEncoding("UTF-8");
		
		String searchType = request.getParameter("searchType");
		if(searchType.equals("pName")) {
			searchType = "P_NAME";
		} else if(searchType.equals("Content")) {
			searchType = "CONTENT";
		}
		String search = request.getParameter("search");
		
		
		List<Product> list = service.search(searchType, search);
		request.setAttribute("search", list);
		
		return "product.search";
	}


}