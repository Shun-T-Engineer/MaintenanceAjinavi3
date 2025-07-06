package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Shop;
import com.example.demo.form.RestaurantEditForm;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RestaurantEditController {
	
//	private final ShopService service;
	
	@PostMapping("/show-edit-restaurant")
	public String showEditForm(@ModelAttribute RestaurantEditForm form) {
		return "edit-restaurant";
	}
	
	@PostMapping("/edit-restaurant")
	public String registShop(@Validated @ModelAttribute 
			RestaurantEditForm form, BindingResult result) {
		if(result.hasErrors()) {
			return "edit-restaurant";
			}
			
		return "confirm-edit-restaurant";
	}
	
	@PostMapping("/confirm-edit-restaurant")
	public String confirmRegistShop(@Validated RestaurantEditForm form,
															BindingResult result, 
															RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			return "edit-restaurant";
		}
		
		Shop r = new Shop();
		r.setRestaurantName(form.getRestaurantName());
		r.setCachPhrase(form.getCachPhrase());
		
		System.out.println(r);
		
		redirectAttributes.addFlashAttribute("msg", "お店を登録");
		
		return "redirect:/shop-regist-complete";
	}
	
	

}
