package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.ProductsDao;
import com.sunbeam.daos.ProductsDaoImpl;



public class GetProductDetails  {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			
			ProductsDao dao = new ProductsDaoImpl();
			System.out.println("Enter user id");
			System.out.println(dao.getProductDetails(sc.nextLong()));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
