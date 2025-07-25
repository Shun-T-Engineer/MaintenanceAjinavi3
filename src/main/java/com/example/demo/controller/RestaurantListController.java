package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Restaurant;
import com.example.demo.form.RestaurantSearchForm;
import com.example.demo.service.RestaurantListService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class RestaurantListController {
	
	private final RestaurantListService service;

	@GetMapping("/restaurant-list")
	private String restaurantList(@ModelAttribute RestaurantSearchForm form) {
		return "restaurant-list";
	}
	
	@PostMapping("/restaurant-search")
	private String restaurantSearch(@ModelAttribute RestaurantSearchForm form, Model model) {
		
		List<Restaurant> list = service.findByNameWildcard(form.getRestaurantName());
				
		model.addAttribute("restaurantList", list);
		return "restaurant-list";
	}
}
