package com.yeat.HibernateMappingRelationsOneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Laptop laptop=new Laptop();
    	laptop.setLid(101);
    	laptop.setLname("Dell");
    	
    	Student stu=new Student();
    	stu.setName("Yeat");
    	stu.setRollno(1);
    	stu.setMarks(50);
    	stu.setLaptop(laptop);
    	
        Configuration con=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf=con.buildSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();
        s.save(laptop);
        s.save(stu);
        
        s.getTransaction().commit();
        s.close();
    }
}
