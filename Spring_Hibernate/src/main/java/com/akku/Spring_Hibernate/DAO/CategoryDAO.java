package com.akku.Spring_Hibernate.DAO;

import java.util.List;

import com.akku.Spring_Hibernate.model.Category;

public interface CategoryDAO {

	
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	
}