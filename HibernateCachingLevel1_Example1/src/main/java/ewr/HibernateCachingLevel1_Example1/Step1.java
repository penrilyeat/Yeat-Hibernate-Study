package ewr.HibernateCachingLevel1_Example1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Step1 {

	public static void main(String[] args) {
		// Import data into database for step 2 experiment to demonstrate the cache 
		Alien a1=new Alien();
		a1.setId(1);
		a1.setName("Bean");
		a1.setColor("Blue");
		Alien a2=new Alien();
		a2.setId(2);
		a2.setName("Pig");
		a2.setColor("Green");
		Alien a3=new Alien();
		a3.setId(3);
		a3.setName("Bear");
		a3.setColor("White");
		Alien a4=new Alien();
		a4.setId(4);
		a4.setName("Xeon");
		a4.setColor("Black");
		Alien a5=new Alien();
		a5.setId(5);
		a5.setName("Ultra");
		a5.setColor("Red");
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		SessionFactory sf=con.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.save(a1);
		s.save(a2);
		s.save(a3);
		s.save(a4);
		s.save(a5);
		tx.commit();
		s.close();
		

	}

}
