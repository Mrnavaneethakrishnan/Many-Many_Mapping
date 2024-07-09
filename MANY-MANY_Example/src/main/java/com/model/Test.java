package com.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction tr=null;
		try (Session ses=HBUtil.getSessionFactory().openSession()){
			tr=ses.beginTransaction();
			Answer a1 = new Answer();
			a1.setAnswername("First Answer");
			a1.setPostedBy("Navaneethan");
			Answer a2 = new Answer();
			a2.setAnswername("Second Answer");
			a2.setPostedBy("Prabhu");
			List<Answer> li=new ArrayList<Answer>();
			li.add(a1);
			li.add(a2);
			Question q1 = new Question();
			q1.setQname("First Question");
			q1.setAnswers(li);
			ses.merge(q1);
			tr.commit();
			ses.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

