package com.infinite.hibweb;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class QuestionDAO {

	SessionFactory sessionFactory;
	
	public String addQuestion(Question question) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(question);
		transaction.commit();
		return "Question Added Successsfully...";
	}
	

	public List<Question> showQuestion() {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Question");
		List<Question> questionsList = query.list();
		return questionsList;
		}
	public List<Answer>showAnswer(){
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
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
		question1.setId(1);
		session.save(question1);
		transaction.commit();
		return listAnswers1;
		}
	

}

		
		
	
	
	
	
	
