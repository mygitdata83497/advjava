package com.sunbeam.daos;

import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;

public class ProductsDaoImpl implements ProductsDao  {

	@Override
	public String addProduct(Products product) {
		String msg="product not added!!";
		
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Serializable productId = session.save(product);
			tx.commit();
			msg="product added succesfully!!!";
			
		} catch (RuntimeException e) {
			if (tx !=null)
				tx.rollback();
			
			throw e;
		}
		
		return msg;
	}

	@Override
	public Products getProductDetails(Long productId) {
		Products product=null;
		
		Session session =getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			product=session.get(Products.class, productId);
			
		} catch (RuntimeException e) {
			
			if(tx !=null)
				tx.rollback();
			
			throw e;
			
		}
		
		return product;
	}

	@Override
	public List<Products> getAllProducts(Category cat) {
			String jpql ="select p from Products p where p.category = :cat";
			List <Products> product = null;
			Session session = getFactory().getCurrentSession();
			Transaction tx=session.beginTransaction();
			try {
				product=session.createQuery(jpql,Products.class).setParameter("cat", cat).getResultList();
				tx.commit();
			} catch (RuntimeException e) {
				if(tx!=null)
					tx.rollback();
				throw e;
			}
			return product;
	}

	@Override
	public String applyDiscount(Category cat, double discount) {
		String msg="Discount application Failed!!!";
		String  jpql="update Products p set p.price-:discount where p.category=:category";
		Session session = getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			int rows=session.createQuery(jpql)
					.setParameter("discount", discount)
					.setParameter("ct",cat)
					.executeUpdate();
			tx.commit();
			msg="The number of products discounted are"+rows;
			
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return null;
	}
	
}
