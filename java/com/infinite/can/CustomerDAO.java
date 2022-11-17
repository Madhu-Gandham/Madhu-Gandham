package com.infinite.can;
import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;



public class CustomerDAO {
    
    
    SessionFactory sFactory;
    



    public String GenerateCustomerid() {    
        sFactory = SessionHelper.getConnection();
        Session session = sFactory.openSession();
        Criteria cr = session.createCriteria(Customer.class);
        List<Customer> customerList = cr.list();
        session.close();
        if( customerList.size()==0) {
            return "S001";
    
        }
        else {
            String id = customerList.get(customerList.size()-1).getCust_id();
            int id1 = Integer.parseInt(id.substring(1));
            id1++;
            String id2 = String.format("S%03d", id1);
             return id2;        
        }    
    }


    public String addcustomer(Customer customer) {
        sFactory = SessionHelper.getConnection();
        Session session = sFactory.openSession();
        String customerid = GenerateCustomerid();
        customer.setCust_id(customerid);
        Criteria cr = session.createCriteria(Customer.class);
        org.hibernate.Transaction tran =  session.beginTransaction();
        session.save(customer);
        tran.commit();
        return "customer details Added";
    }
    public List<Customer> CustomerShow() {
        sFactory = SessionHelper.getConnection();
        Session session = sFactory.openSession();
        Criteria cr = session.createCriteria(Customer.class);
        List<Customer> customerList = cr.list();
        return customerList;
        
    }
    public Customer  searchCustomer(String user) {
    	sFactory = SessionHelper.getConnection();
        Session session = sFactory.openSession();
        Criteria cr = session.createCriteria(Customer.class);
        cr.add(Restrictions.eq("cust_userName",user));
        List<Customer> customerList = cr.list();
        return customerList.get(0);
    	
    }
    public Customer  Updatecustomer(String custid) {
    	sFactory = SessionHelper.getConnection();
        Session session = sFactory.openSession();
        Customer customer = searchCustomer(custid);  
        Criteria cr = session.createCriteria(Customer.class);
        cr.add(Restrictions.eq("cust_email",customer.getCust_email()));
        cr.add(Restrictions.eq("cust_name",customer.getCust_name()));
        cr.add(Restrictions.eq("cust_phn_no",customer.getCust_phn_no()));
        cr.add(Restrictions.eq("cust_password",customer.getCust_password()));
        List<Customer> customerList =  cr.list();
        return customerList.get(0);
        
    	
    }



public int loginCheck(String cust_userName, String cust_password) {
	sFactory = SessionHelper.getConnection();
	Session session = sFactory.openSession();
    Criteria cr = session.createCriteria(Customer.class);
    cr.add(Restrictions.eq("cust_userName", cust_userName));
    cr.add(Restrictions.eq("cust_password", cust_password));
    List<Customer>listcustomer = cr.list();
    return listcustomer.size();
}
    
    
	
}
