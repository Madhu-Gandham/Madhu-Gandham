package com.infinite.hib1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Mainprog {
public static void main(String[] args) {
Configuration cfg = new AnnotationConfiguration().configure();
SessionFactory sf = cfg.buildSessionFactory();
Session session = sf.openSession();
Transaction transaction = session.beginTransaction();
Question question1 = new Question();
question1.setQname("What is Java?");

Answer ans1 = new Answer();
ans1.setAnswerName("java is a programming language");
ans1.setPostedBy("Prasanna Pappu");
Answer ans2 = new Answer();
ans2.setAnswerName(" By using java we can make any kind of Application");
ans2.setPostedBy("Sunil kumar");
List<Answer> listAnswers1 = new ArrayList<Answer>();
listAnswers1.add(ans1);
listAnswers1.add(ans2);
question1.setAnswer(listAnswers1);
session.save(question1);
transaction.commit();
}
}