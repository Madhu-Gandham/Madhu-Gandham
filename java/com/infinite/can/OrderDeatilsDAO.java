package com.infinite.can;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

public class OrderDeatilsDAO {
     

	SessionFactory sFactory;
	Session session;
	
	public  String orderIdGen() {
		sFactory=SessionHelper.getConnection();
		session=sFactory.openSession();
		Criteria cr=session.createCriteria(OrderDetails.class);
		List<OrderDetails> orderList=cr.list();
		if(orderList.size()==0) {
			return "O001";
		}
		else {
			int id=Integer.parseInt(orderList.get(orderList.size()-1).getOrderId().substring(1));
			String orderId=String.format("O%03d", ++id);
			return orderId;
		}
	}
	
	public String addOrder(OrderDetails order) {
		System.out.println(order);
		String orderId=orderIdGen();
		order.setOrderId(orderId);
		order.setStatus(Status.PENDING);
		sFactory=SessionHelper.getConnection();
		session=sFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(order);
		//System.out.println("Data Added to cache...");
		tr.commit();
		return "You ordered successfully";
	}
	
	 public List<OrderDetails> searchItem(String mId,String customerId) {
			sFactory = SessionHelper.getConnection();
			 session = sFactory.openSession();
			Query query=session.createQuery("from OrderDetails where menuId=:menuId AND "
					+ "custId=:custId AND address is NULL")
					.setParameter("menuId", mId).setParameter("custId", customerId);
			
			List<OrderDetails> orderlist = query.list();
			return orderlist;
		}
	 public List<OrderDetails> searchByID(String customerId) {
			sFactory = SessionHelper.getConnection();
			 session = sFactory.openSession();
			Query query=session.createQuery("from OrderDetails where "
					+ "custId=:custId AND address is NULL")
					.setParameter("custId", customerId);
			
			List<OrderDetails> orderlist = query.list();
			return orderlist;
		}
	 
	 public double calcTotal(String customerId) {
		 sFactory = SessionHelper.getConnection();
		 session = sFactory.openSession();
		 Query query=session.createQuery("select sum(billamt) from OrderDetails where custId=:custId "
		 		+ "AND address is NULL").setParameter("custId", customerId);
		 List<Double> count=query.list();
		 System.out.println("Count is " +count);
		 Double b = (Double)count.get(0);
		 System.out.println(b);
		 if (b==null) {
			 return 0;
		 }
//		 if (count.get(0).equals("null")) {
//			 return 0;
//		 }
			return count.get(0);
	 }
	 public OrderDetails searchById(String orderId){
		 sFactory = SessionHelper.getConnection();
		  session = sFactory.openSession();
		 Criteria cr=session.createCriteria(OrderDetails.class);
		 Criterion criterion1=Restrictions.eq("orderId", orderId);
		 Criterion criterion2=Restrictions.eq("status", Status.PENDING);
		 cr.add(Restrictions.and(criterion1, criterion2));
		 List<OrderDetails> orderList=cr.list();
		 return orderList.get(0);
	 }
	 public String updateOrder(OrderDetails order) {
		 sFactory = SessionHelper.getConnection();
		 session = sFactory.openSession();
		 		
		 OrderDetails ord=searchById(order.getOrderId());
		 ord.setQuantity(order.getQuantity());
		 ord.setBillamt(order.getBillamt());
		 
		 Transaction tr=session.beginTransaction();
		 
		 session.update(ord);
		 tr.commit();
		 return "Updated...";
	 }
	 
	 
	 public List<OrderDetails> showAllOrder(String custId){
		 sFactory = SessionHelper.getConnection();
		  session = sFactory.openSession();
		 
		  Query query=session.createQuery("from OrderDetails where custId=:custId  "
			 		+ "AND address is NOT NULL").setParameter("custId", custId);
			 List<OrderDetails> orderList=query.list();
		 return orderList;
	 }
	 
	 
	 public List<OrderDetails> showOrderById(String customerId){
		 sFactory = SessionHelper.getConnection();
		  session = sFactory.openSession();
		 Query query=session.createQuery("from OrderDetails where custId=:custId AND status=:status "
		 		+ "AND address is NULL").setParameter("custId", customerId).setParameter("status", Status.PENDING);;
		 List<OrderDetails> orderList=query.list();
		 return orderList;
	 }
	 
	 public String deleteOrder(String orderId) {
		 sFactory = SessionHelper.getConnection();
		 session = sFactory.openSession();
		
		 OrderDetails order=searchById(orderId);
		 Transaction tr=session.beginTransaction();
		 session.delete(order);
		 tr.commit();
		 return "Deleted..";
	 }
	 public Wallet walletAmount(String custId,Type type) {
		 sFactory = SessionHelper.getConnection();
		 session = sFactory.openSession();
		 Criteria cr=session.createCriteria(Wallet.class);
		 Criterion criterion1=Restrictions.eq("customerId", custId);
		 Criterion criterion2=Restrictions.eq("walletType", type);
		 cr.add(Restrictions.and(criterion1, criterion2));
		 List<Wallet> wallet=cr.list();
		 return wallet.get(0);
	 }
	 public String paymentOrder(OrderDetails order) {
		
		 String cid=order.getCustId();
		double billAmt= order.getBillamt();
		Type type=order.getWalletType();
		
		 Wallet wallet=walletAmount(cid, type);
		double walletAmount=wallet.getAmt();
		if(billAmt>walletAmount) {
			return "Insufficient balance in your wallet add amount....";
		}else {
			sFactory = SessionHelper.getConnection();
			 session = sFactory.openSession();
			List<OrderDetails> orderList= searchByID(cid);
			System.out.println(orderList.size());
			for (OrderDetails orders : orderList) {
				System.out.println(order.getAddress());
				System.out.println(order.getWalletType());
				System.out.println(order.getComments());
				 Transaction tr=session.beginTransaction();
				orders.setAddress(order.getAddress());
				orders.setWalletType(order.getWalletType());
				orders.setComments(order.getComments());
				session.update(orders);
				
				tr.commit();
			}
			session.close();
			double remainBal=walletAmount-billAmt;
			wallet.setAmt(remainBal);
			
			session = sFactory.openSession();
			Transaction tr=session.beginTransaction();
			session.update(wallet);
			tr.commit();
			 return "Payment successfull and bill is"  +order.getBillamt();
		}
		 
	 }
}
