package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;

public interface ProductsDao {
	String addProduct(Products product);
	Products getProductDetails(Long productId);
	List<Products>getAllProducts(Category cat);
	String applyDiscount(Category cat,double discount);
}
