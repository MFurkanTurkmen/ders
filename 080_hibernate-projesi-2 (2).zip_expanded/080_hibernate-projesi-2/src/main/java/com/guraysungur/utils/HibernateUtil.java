package com.guraysungur.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.guraysungur.entity.Dolap;
import com.guraysungur.entity.Kitap;
import com.guraysungur.entity.Lab;
import com.guraysungur.entity.Okul;
import com.guraysungur.entity.Sinif;
import com.guraysungur.entity.Student;
import com.guraysungur.entity.Yazar;



public class HibernateUtil {


	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			try {
				// Hibernate condiguration nesnesi oluşturulur
				Configuration configuration = new Configuration();

				// Hibernate settings nesnesi oluşturulur (hibernate.cfg.xml)
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/dbtest");
				settings.put(Environment.USER, "postgres");
				settings.put(Environment.PASS, "robot9");

				settings.put(Environment.HBM2DDL_AUTO, "create"); // create update
				// create -> bu sınıfta belirtilen ORM tablolarını siler (içeirğiyle beraber) ve
				// yeniden oluşturur. Test amaçlı çalışmalarda bu şekilde kullanılabilir.
				// update -> tablo yoksa oluşturur, varsa silmez. İçeriğini günceller.

				settings.put(Environment.SHOW_SQL, "false"); // Hibernate üzerinden VT'ye giden SQL komutlaırnı görmemize
															// yarar, false yaparsanız görmezsiniz.
				settings.put(Environment.FORMAT_SQL, "true"); // Hibernate üzerinden VT'ye giden SQL komutlarının
																// bizlerin anlayacağı basitlikte düzenler.

				configuration.setProperties(settings);

				// ORM mapping işlemine tabi tutulacak anotasyon içeren sınıfları buraya
				// yazalım..
				// Entity'leri belirledikten sonra bu satırlara eklemeler yapıp Güncelliyeceğiz:
				configuration.addAnnotatedClass(Student.class);
				configuration.addAnnotatedClass(Sinif.class);
				configuration.addAnnotatedClass(Lab.class);
				configuration.addAnnotatedClass(Dolap.class);
				configuration.addAnnotatedClass(Okul.class);
				configuration.addAnnotatedClass(Yazar.class);
				configuration.addAnnotatedClass(Kitap.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				// Session factory nesnesi üretiliyor..
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return sessionFactory;

	}
	
}
