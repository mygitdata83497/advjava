package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;


import com.sunbeam.daos.ProductsDao;
import com.sunbeam.daos.ProductsDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;


public class AddProduct {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in)
				) {
			
			ProductsDao dao=new ProductsDaoImpl();
			System.out.println("Enter product details -category (BAKERY|SHOES|CLOTHES|STATIONAY) ,product name(unique)  , price , available quantity;");
			Products newProduct=new Products(Category.valueOf(sc.next().toUpperCase()), sc.next(), sc.nextDouble(), sc.nextInt());
			System.out.println(dao.addProduct(newProduct));
		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}

}
