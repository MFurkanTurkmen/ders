package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkan.soru2.entity.Musteri;
import com.furkan.soru2.entity.Siparis;
import com.furkan.soru2.entity.SiparisKalemi;
import com.furkan.soru2.entity.Urun;


public class HibernateUtils {

private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	
	private static SessionFactory sessionFactoryHibernate() {
		

			try {
			Configuration configuration = new Configuration();
			
		//üzerinde çalıştığımız classları gelip buraya ekliyoruz
			configuration.addAnnotatedClass(Musteri.class);
			configuration.addAnnotatedClass(Siparis.class);
			configuration.addAnnotatedClass(SiparisKalemi.class);
			configuration.addAnnotatedClass(Urun.class);





			
			
			
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
			
			} catch (Exception e) {
			System.out.println(e.getMessage());
			}	
		
		return null;
	}


	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
