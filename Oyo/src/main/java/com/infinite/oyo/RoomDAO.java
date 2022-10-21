package com.infinite.oyo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RoomDAO {
	
	SessionFactory sessionFactory;

public String generateRoomId(){
	sessionFactory = SessionHelper.getConnection();
Session session = sessionFactory.openSession();
	Criteria cr = session.createCriteria(Room.class);
	List<Room> roomlist = cr.list();
	session.close();
	String id = roomlist.get(roomlist.size()-1).getRoomId();
	int id1 = Integer.parseInt(id.substring(1));
			id1++;
	String id2 = String.format("R%03d", id1);
	return id2;
}

public String addroom(Room room) {
	//room.setRoomId("R001");
	sessionFactory = SessionHelper.getConnection();
	Session session = sessionFactory.openSession();
	String roomId=generateRoomId();
	room.setRoomId(roomId);
	room.setStatus(Status.AVAILABLE);
	Criteria cr = session.createCriteria(Room.class);
    Transaction t = session.beginTransaction();
    session.save(room);
    t.commit();
    return "Room Added";
}
}