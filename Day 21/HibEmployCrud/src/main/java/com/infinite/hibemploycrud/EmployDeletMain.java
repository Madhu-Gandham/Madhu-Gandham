package com.infinite.hibemploycrud;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class EmployDeletMain {

public static void main(String[] args) {
int empno;
Scanner sc = new Scanner(System.in);
System.out.println("Enter Employ No  ");
empno = sc.nextInt();
Configuration cfg = new AnnotationConfiguration().configure();
SessionFactory sf = cfg.buildSessionFactory();
Session session = sf.openSession();
Query query = session.createQuery("from Employ where empno="+empno);
List<Employ> employlist = query.list();
if(employlist.size()==1){
Transaction trans = session.beginTransaction();
session.delete(employlist.get(0));
trans.commit();
System.out.println("Record deleted");
}else{
System.out.println("*** Record not found***");
}

}

}
