package com.infinite.can;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class WalletDAO {

	SessionFactory sFactory;
	Session session;
	
	public List<Wallet> searchWallet(String cId){
		sFactory=SessionHelper.getConnection();
		session=sFactory.openSession();
		Criteria cr=session.createCriteria(Wallet.class);
		cr.add(Restrictions.eq("customerId", cId));
		Projection projection=Projections.property("walletType");
		 cr.setProjection(projection);
		List<Wallet> walletList=cr.list();
		return walletList;
	}
}
