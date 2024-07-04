package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;
import java.time.LocalDate;
import org.hibernate.SessionFactory;

import com.sunbeam.daos.ProductsDao;
import com.sunbeam.daos.ProductsDaoImpl;
import com.sunbeam.entities.Category;

public class applyDiscountByCategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			ProductsDao dao = new ProductsDaoImpl();
			System.out.println("Enter category and discount");
			System.out.println(dao.giveDiscountByCategory(Category.valueOf(sc.next().toUpperCase()),sc.nextDouble()));
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
