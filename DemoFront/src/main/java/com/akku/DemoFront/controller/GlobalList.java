package com.akku.DemoFront.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.akku.Spring_Hibernate.DAO.CategoryDAO;
import com.akku.Spring_Hibernate.model.Category;

@ControllerAdvice
public class GlobalList {
	
	@Autowired
	CategoryDAO categoryDAO;

	@ModelAttribute("categories")
	public List<Category> getAll(){
		return categoryDAO.list();
	}
}




