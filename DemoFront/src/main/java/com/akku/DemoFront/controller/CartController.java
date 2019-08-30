package com.akku.DemoFront.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akku.Spring_Hibernate.DAO.CartLineDAO;
import com.akku.Spring_Hibernate.DAO.ProductDAO;
import com.akku.Spring_Hibernate.DAO.UserDAO;
import com.akku.Spring_Hibernate.model.Cart;
import com.akku.Spring_Hibernate.model.CartLine;
import com.akku.Spring_Hibernate.model.Product;
import com.akku.Spring_Hibernate.model.User;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CartLineDAO cartLineDAO;
	@Autowired
	UserDAO userDAO;
	
	
	@GetMapping("")
	public String viewCart(HttpSession session,Model model) {
		User user=(User)session.getAttribute("user");
		Cart cart=user.getCart();
		
		List<CartLine> listItems=cartLineDAO.list(cart.getId());
		
		model.addAttribute("listItems", listItems);
		model.addAttribute("userClickedViewCart", true);
		
		cart.setGrandTotal(getGrandTotal(listItems));
		
		cartLineDAO.updateCart(cart);
		
		model.addAttribute("GT", cart.getGrandTotal());
		
		return "index";
	}
	
	private double getGrandTotal(List<CartLine> listItems) {
		int s=0;
		
		for(CartLine ci:listItems) {
			s+=ci.getTotal();
		}
		
		return s;
	}

	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable("id")int id,HttpSession session,Model model) {
		Product product=productDAO.get(id);
		CartLine cartLine=new CartLine();
		
		cartLine.setProduct(product);
		cartLine.setProductCount(1);
		cartLine.setAvailable(product.isActive());
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setTotal(cartLine.getProductCount()*cartLine.getBuyingPrice());
		
		User user=(User)session.getAttribute("user");
		Cart cart=user.getCart();
		cartLine.setCartId(cart.getId());
		
		
		cartLineDAO.add(cartLine);
		
		cart.setCartLines(cart.getCartLines()+1);
		cart.setGrandTotal(cart.getGrandTotal()+cartLine.getTotal());
		
		cartLineDAO.updateCart(cart);
		
		//System.out.println(cart.getId());
		
		model.addAttribute("cartItems",cartLineDAO.listAvailable(cart.getId()));
		
		
		return "redirect:/cart";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteItem(@PathVariable()int id) {
		cartLineDAO.deleteCartItem(id);
		
		return "redirect:/cart";
	}
	
	@GetMapping("/update/{id}")
	public String updateCartItem(@PathVariable()int id,@RequestParam("qty")int qty) {
		CartLine ci=cartLineDAO.get(id);
		ci.setProductCount(qty);
		ci.setTotal(ci.getProductCount()*ci.getBuyingPrice());
		
		cartLineDAO.update(ci);

		return "redirect:/cart";
	}

}
