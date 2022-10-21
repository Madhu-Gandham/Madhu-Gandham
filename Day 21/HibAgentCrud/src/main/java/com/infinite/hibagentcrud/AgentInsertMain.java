package com.infinite.hibagentcrud;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class AgentInsertMain {
public static void main(String[] args) {
Agent agent = new Agent();
Scanner sc = new Scanner(System.in);
System.out.println("Enter AgentId");
agent.setName(sc.next());
System.out.println("Enter Name");
agent.setName(sc.next());
System.out.println("Enter City");
agent.setCity(sc.next());
System.out.println("Enter Gender ");
agent.setGender(Gender.valueOf(sc.next()));
System.out.println("Maritalstatus");
agent.setMaritalStatus(sc.nextInt());
System.out.println("Premium");
agent.setPremium(sc.nextDouble());
Configuration cfg = new AnnotationConfiguration().configure();
SessionFactory sf = cfg.buildSessionFactory();
Session session = sf.openSession();
Query query = session.createQuery("from Agent where agentid="+agent.getAgentId());
List<Agent> agentList = query.list();

Transaction trans = session.beginTransaction();
session.save(agent);
trans.commit();
System.out.println("***Record inserted***");


}
}