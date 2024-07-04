package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.ProductsDao;
import com.sunbeam.daos.ProductsDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;

public class TestGetAllProducts {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			ProductsDao prodDao = new ProductsDaoImpl();
			System.out.println("Enter Category for which all product to be fetched:");
			// prodDao.getAllProducts(Category.valueOf(sc.next().toUpperCase())).forEach(System.out::println);
			List<Products> products = prodDao.getAllProducts(Category.valueOf(sc.next().toUpperCase()));
			products.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
