package common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;;

public class HiberFactorySessionUtil {

	 private static final SessionFactory sessionFactory = buildSessionFactory();

	    private static SessionFactory buildSessionFactory() {
	        try {
	            // Create the SessionFactory from hibernate.cfg.xml
	        	Configuration cfg = new Configuration().configure();
	        	StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
	        	SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	        	return sessionFactory;
	        }
	        catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	      
	    public static Session OpenSession(){
	    	return getSessionFactory().openSession();
	    }
}
