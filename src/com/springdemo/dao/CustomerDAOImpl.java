package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	 
	
	public List<Customer> getCustomer(){
		
	    Session currentSession = sessionFactory.getCurrentSession();
	    
	    //crateQuery order by last name
	    Query<Customer> theQuery = currentSession.createQuery("from Customer oder by lastName", Customer.class);
	    
	    
	    List<Customer> customers = theQuery.getResultList();
	    
		return customers;
	}




	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub

		//get current hibernate session 
	    Session currentSession = sessionFactory.getCurrentSession();

	    //save the customer
	    currentSession.save(theCustomer);
	}

}
