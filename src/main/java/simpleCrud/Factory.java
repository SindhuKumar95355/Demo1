package simpleCrud;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factory {
	
	static SessionFactory factory;
	
	public static SessionFactory fact()
	{
		factory = new Configuration().configure("praticeHiber.cfg.xml").buildSessionFactory();
		
		return factory;
	}

}
