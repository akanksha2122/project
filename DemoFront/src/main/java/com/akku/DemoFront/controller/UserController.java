package com.akku.DemoFront.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akku.Spring_Hibernate.DAO.CartLineDAO;
import com.akku.Spring_Hibernate.DAO.UserDAO;
import com.akku.Spring_Hibernate.model.Address;
import com.akku.Spring_Hibernate.model.Cart;
import com.akku.Spring_Hibernate.model.User;

@Controller
public class UserController {
	
	@Autowired
	UserDAO userDAO;

	@Autowired
	CartLineDAO cartLineDAO;
	
	
	@RequestMapping(value = { "/register" })
	public String register(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			switch (error) {
			case "1":
				model.addAttribute("error", "User with email alredy exist !");
				break;
			case "2":
				model.addAttribute("error", "User Password and confirm password do not match !");
				break;
			}
		}
		model.addAttribute("userClickedRegister", true);
		model.addAttribute("user", new User());

		return "index";
	}

	@PostMapping(value = { "/register" })
	public String saveUser(@ModelAttribute("user") User user, Model model) {

		if (userDAO.getByEmail(user.getEmail()) != null) {

			return "redirect:/register?error=1";
		}
		if (!user.getConfirmPassword().equals(user.getPassword())) {
			return "redirect:/register?error=2";
		}

		user.setRole("USER");

		userDAO.add(user);

		Address address = new Address();

		address.setUserId(user.getId());
		
		Cart cart=new Cart();
		cart.setUser(user);
		
		cartLineDAO.addCart(cart);
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

	@RequestMapping(value="/login")
	public String login(@RequestParam(name="error", required = false)	String error,
			@RequestParam(name="logout", required = false) String logout,Model model) {
		model.addAttribute("userClickedLogin", true);
		//model.addAttribute("title", "Login");
		if(error!=null) {
			model.addAttribute("message", "Username and Password is invalid!");
		}
		if(logout!=null) {
			model.addAttribute("logout", "You have logged out successfully!");
		}
		return "index";
	}
	
	@RequestMapping("/login_success")
	public String login_success(Model model,HttpSession session) {
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		
		String email=auth.getName();
		User user=userDAO.getByEmail(email);
		
		
		session.setAttribute("user", user);

		return "redirect:/";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// Invalidates HTTP Session, then unbinds any objects bound to it.
	    // Removes the authentication from securitycontext 		
		session.setAttribute("user", null);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		
		return "redirect:/login?logout";
	}	
	
	
}
