package com.akku.DemoFront.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akku.Spring_Hibernate.DAO.ProductDAO;
import com.akku.Spring_Hibernate.DAO.UserDAO;
import com.akku.Spring_Hibernate.model.Address;
import com.akku.Spring_Hibernate.model.User;

@Controller
public class HomeController {

	@Autowired // Spring
	ProductDAO productDAO;
	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = { "/", "/category/All" })
	public String Home(Model model) {
		model.addAttribute("userClickedHome", true);
		// model.addAttribute("categories", categoryDAO.list());
		model.addAttribute("products", productDAO.listActiveProducts());// hibernate by product dao

		return "index";
	}

	@RequestMapping(value = { "/register" })
	public String register(Model model) {
		model.addAttribute("userClickedRegister", true);
		model.addAttribute("user", new User());

		return "index";
	}

	@PostMapping(value = { "/register" })
	public String saveUser(@ModelAttribute("user") User user, Model model) {

		user.setRole("USER");

		userDAO.add(user);

		Address address = new Address();

		address.setUserId(user.getId());

		model.addAttribute("userClickedSaveUser", true);
		model.addAttribute("address", address);

		return "index";
	}

	@PostMapping(value = { "/saveAddress" })
	public String Address(@ModelAttribute("address") Address address, @RequestParam("country") String country,
			@RequestParam("state") String state, Model model) {

		address.setCountry(country);
		address.setState(state);
		address.setBilling(true);

		userDAO.addAddress(address);

		return "redirect:/login";
	}

	@RequestMapping("/category/{id}/products")
	public String filterByCategory(@PathVariable("id") int id, Model model) {

		model.addAttribute("userClickedHome", true);
		// model.addAttribute("categories", categoryDAO.list());
		model.addAttribute("products", productDAO.listActiveProductsByCategory(id));// hibernate by product dao

		return "index";
	}

}