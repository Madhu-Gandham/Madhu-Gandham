package com.infinite.payroll;



import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class EmployDAO { 
	
	    SessionFactory sessionFactory;
	      public String addEmploy(Employ employ) {
	          sessionFactory = SessionHelper.getConnection();
	          Session session = sessionFactory.openSession();
	          Criteria cr = session.createCriteria(Employ.class);
	        /*
	         * String empName = employ.getEmpname(); employ.setEmpname(empName);
	         */
	          double  sal = employ.getSalary() ;
	          double hra = (sal*0.02);
	          employ.setHra(hra);
	          double da= (sal*0.0125);
	          employ.setDa(da);
	          double ta = (sal*0.0095);
	          employ.setTa(ta);
	          double tax = (sal*0.0023);
	          employ.setTax(tax);
	          double pf = (sal*0.03);
	          employ.setPf(pf);
	          double gross = sal + hra + da + ta;
	          employ.setGross(gross);
	          double netpay = gross - tax - pf;
	          employ.setNetPay(netpay);
	          employ.setLeaveAvailable(16);
	          Transaction transaction = session.beginTransaction();
	          session.save(employ);
	          transaction.commit();
	          session.close();
	          return "Employ Added...";
	      }
	      
	          public String applyLeave(LeaveTable leaveTable) {  
		      sessionFactory = SessionHelper.getConnection();
		      Session session = sessionFactory.openSession();
		      Criteria cr = session.createCriteria(LeaveTable.class);
		      long sdate = leaveTable.getLeaveStartDate().getTime();
		      long edate = leaveTable.getLeaveEndDate().getTime();
		      long diff =  edate - sdate;
		      long m = diff/(1000*24*60*60);
		      int days=(int)m;
		      days=days+1;
		      leaveTable.setNoOfDays(days);
		      int no = leaveTable.getNoOfDays();
		      if(no > 3) {
		    	  leaveTable.setLossOfPay((double) (no-3));
		    	   }else {
		    	       leaveTable.setLossOfPay((double) 0);
		    	     }
		       Transaction transaction = session.beginTransaction();
		       session.save(leaveTable);
	       	    transaction.commit();
	       	   session.close();
	    
	       	  return "Leave Applied....";	        

	       }
	          //date
	          public Date convertDate(java.util.Date dt) {
	              java.sql.Date sqlDate = new java.sql.Date(dt.getTime());
	              return sqlDate;
	          }  
	          
	          public List<Employ> searchEmploy(int empno) {
	        	  sessionFactory = SessionHelper.getConnection();
			      Session session = sessionFactory.openSession();
	              Criteria cr = session.createCriteria(Employ.class);
	              cr.add(Restrictions.eq("empno", empno));
	              List<Employ> employList = cr.list();
	              
	              return employList;
	          }
	          public List<LeaveTable> searchLeave(int empno) {
	        	  sessionFactory = SessionHelper.getConnection();
			      Session session = sessionFactory.openSession();
	              Criteria cr = session.createCriteria(LeaveTable.class);
	              cr.add(Restrictions.eq("empno", empno));
	              List<LeaveTable> leaveTableList = cr.list();
	              
	              return leaveTableList;
	          }
	         
	          public double takeHome(double salary) {
	      		
	      		sessionFactory = SessionHelper.getConnection();
	      		Session session = sessionFactory.openSession();
	      		LeaveTable leaveTable = new LeaveTable();
	      		Employ employ = new Employ();
	      		int month=11;
	      		int empno=1;
	      		Object ob = payslip(1, 11);
	      		long lop = (Long)ob;
	      		lop = lop - 3;
	      		double lossofpay = (salary/30.43) * lop;
	    			      		
	      		Query query =session.createQuery("from LeaveTable where empno=:empno"
	      				+ " AND (MONTH(leaveStartDate)=:month AND MONTH(leaveEndDate)=:month)").setParameter("empno", empno)
	      				.setParameter("month", month);
	      		
	      		List<LeaveTable> leavelist = query.list();
	      		
	      		LeaveTable lastRecord = leavelist.get(leavelist.size()-1);
	      		lastRecord.setLossOfPay(lossofpay);
	      	
	      		Transaction transaction = session.beginTransaction();
	      		session.update(lastRecord);
	      		transaction.commit();
//	      		leaveTable.setLossOfPay(lossofpay);
	      		
	      		List<Employ> emplist = searchEmploy(1);
	      		
	      		double ntp = emplist.get(0).getNetPay();
	      		
	      		double take = ntp - lossofpay;
	      		
	      		return  take;
	      	}
	      	public Object payslip(int empno,int month) {
	      		Employ employ = new Employ();
	      		LeaveTable leaveTable = new LeaveTable();
	      		sessionFactory = SessionHelper.getConnection();
	      		Session session = sessionFactory.openSession();
	      		Query query=session.createQuery("select sum(noOfDays) "
	      				+ "from LeaveTable where empno=:empno AND (MONTH(leaveStartDate)=:month AND"
	      				+ " MONTH(leaveEndDate)=:month)").setParameter("empno", empno)
	      				.setParameter("month", month);
	      		List<Long> count = query.list();	
	      		

	      		return count.get(0);
	      	}
	      	
	      	
	      	
	      	
	      	
	      	
	      	

	      }         

	     






	  



	


