package kr.ac.hansung.cse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.cse.model.Product;
import kr.ac.hansung.cse.service.ProductService;

@Controller

@RequestMapping("/admin") //class level
public class AdminController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping("/productInventory") //method level
	public String getProducts(Model model) { // controller -> model -> view
		
		List<Product> products = productService.getProducts(); //db조회
		model.addAttribute("products", products);
		
		return "productInventory";
	}
	
	@RequestMapping(value="/productInventory/addProduct", method=RequestMethod.GET)
	public String addProduct(Model model) {
		
		Product product = new Product();
		product.setCategory("컴퓨터"); //webform에 초기값 설정
		
		model.addAttribute("product", product);
		
		return "addProduct";
	}
	
	//web form에서 utf-8로 인코딩을 하고 넘어오도록 필터를 등록해야함 form->filter->dispatcher ->controller
	@RequestMapping(value="/productInventory/addProduct", method=RequestMethod.POST)
	public String addProductPost(@Valid Product product, BindingResult result) { //http body에 담겨진 form data를 객체에 자동적으로 바인딩
		
		if(result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors =result.getAllErrors();
			
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "addProduct";
		}
		
		if( !productService.addProduct(product) )
			System.out.println("Adding product cannot be done");
		
		return "redirect:/admin/productInventory"; // redirect : 다시 db조회하도록
	}
	
	//id값이 pathvariable로 넘어감
	@RequestMapping(value="/productInventory/deleteProduct/{id}", method=RequestMethod.GET)
	public String deleteProduct(@PathVariable int id) {
		
		if( !productService.deleteProduct(id) ) {
			System.out.println("Deleting product cannot be done");
		}
		
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping(value="/productInventory/updateProduct/{id}", method=RequestMethod.GET)
	public String updateProduct(@PathVariable int id, Model model) {
		
		Product product = productService.getProductByid(id);
		
		model.addAttribute("product", product);
		
		return "updateProduct";
	}

	@RequestMapping(value="/productInventory/updateProduct", method=RequestMethod.POST)
	public String updateProductPost(@Valid Product product, BindingResult result) { //http body에 담겨진 form data를 객체에 자동적으로 바인딩
		
		//System.out.println(product);
		
		if(result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors =result.getAllErrors();
			
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "updateProduct";
		}
		
		if( !productService.updateProduct(product) )
			System.out.println("Updating product cannot be done");
		
		return "redirect:/admin/productInventory"; // redirect : 다시 db조회하도록
	}
	
	
}



