package com.infinite.lmshib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LeaveHistoryDAO {
    SessionFactory sessionFactory;
    public List<LeaveHistory> showLeaveHistory(int empId) {
        sessionFactory = SessionHelper.getSession();
 Session session=sessionFactory.openSession(); 
 Query query = session.getNamedQuery("searchLeaveHistory");
 query.setParameter("empId", empId);
 List<LeaveHistory> leavehistory = query.list();
 return leavehistory;

}
}
