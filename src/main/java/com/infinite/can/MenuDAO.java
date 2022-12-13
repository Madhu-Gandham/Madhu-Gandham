package com.infinite.can;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.criterion.Restrictions;

@SessionScoped
@ManagedBean
public class MenuDAO {

	SessionFactory sessionFactory;

	public List<Menu> showMenu() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Query query = session.createQuery("from Menu");
		List<Menu> list = query.list();
		return list;
	}

	public List<Menu> searchMenu(String rest_id) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Menu.class);
		cr.add(Restrictions.eq("rest_id", rest_id));

		List<Menu> menuList = cr.list();
		return menuList;
	}

	public Menu searchById(String menu_id) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Menu.class);
		cr.add(Restrictions.eq("menu_id", menu_id));
     
		List<Menu> menuList = cr.list();
		return menuList.get(0);
	}
	public String searchById1(String menu_id) throws IOException {
//		Map<String,Object> sessionMap = 
//				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Menu.class);
		cr.add(Restrictions.eq("menu_id", menu_id));
     
		List<Menu> menuList = cr.list();
		Menu menu = menuList.get(0);
		
		FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        externalContext.getSessionMap().put("menu", menu);
        externalContext.redirect("AddCart.jsp");
		return null;
	}
	public List<Menu> searchRest(String menu) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Menu.class);
		cr.add(Restrictions.eq("menu_item", menu));

		List<Menu> menuList = cr.list();
		return menuList;
	}

	public String AddMenu(Menu menu) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		String menuid = generateMenuID();
		menu.setMenu_id(menuid);
		Transaction tran = session.beginTransaction();
		session.save(menu);
		tran.commit();
		return "Menu Added";

	}

	public String generateMenuID() {

		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Menu.class);
		List<Menu> menulist = cr.list();
		session.close();

		if (menulist.size() == 0) {
			return "M001";
		} else {
			String id = menulist.get(menulist.size() - 1).getMenu_id();
			int id1 = Integer.parseInt(id.substring(1));
			id1++;
			String id2 = String.format("M%03d", id1);
			return id2;
		}
	}

	public Menu searchRest(int rest_id) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Menu");
		List<Menu> restList = query.list();
		if (restList.size() == 0) {
			return null;
		}
		return restList.get(0);
	}

}
