package dao;

import pojos.Category;

public interface CategoryDao {
//1. Add a new category
	String addNewCategory(Category newCategory);
	
//2. Delete category
	String deleteCategoryName(Category categoryName);
	

}
