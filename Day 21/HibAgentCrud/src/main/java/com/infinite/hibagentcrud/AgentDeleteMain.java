package com.infinite.hibagentcrud;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class AgentDeleteMain {

public static void main(String[] args) {
int agentid;
Scanner sc = new Scanner(System.in);
System.out.println("Enter Agent Id  ");
agentid = sc.nextInt();
Configuration cfg = new AnnotationConfiguration().configure();
SessionFactory sf = cfg.buildSessionFactory();
Session session = sf.openSession();
Query query = session.createQuery("from Agent where agentid="+agentid);
List<Agent> agentlist = query.list();
if(agentlist.size()==1){
Transaction trans = session.beginTransaction();
session.delete(agentlist.get(0));
trans.commit();
System.out.println("Record deleted");
}else{
System.out.println("*** Record not found***");
}

}

}
