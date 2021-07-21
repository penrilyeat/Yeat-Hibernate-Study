package ewr.HibernateCachingLevel1_Example1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Step2 {

	public static void main(String[] args) {
		// Suppose I get 2 different data from the database twice. The first time both data will have
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		SessionFactory sf=con.buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		//Both will instantiate query
		Alien a=new Alien();
		a=(Alien)s.get(Alien.class, 1);
		System.out.println(a);
		a=(Alien)s.get(Alien.class, 2);
		System.out.println(a);
		//Both will not instantiate query as it has been instantiate before
		a=(Alien)s.get(Alien.class, 1);
		System.out.println(a);
		a=(Alien)s.get(Alien.class, 2);
		System.out.println(a);
		//Only the first time will instantiate query
		a=(Alien)s.get(Alien.class, 3);
		System.out.println(a);
		a=(Alien)s.get(Alien.class, 3);
		System.out.println(a);
		
		s.getTransaction().commit();
	}

}
