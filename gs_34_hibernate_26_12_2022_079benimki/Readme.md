1_) pom.xml'e hibernate dependencies ve veritabanı dependencies veya ne gerekiyorsa onlar eklenir.  
  2_) util paketinin altına hibernate.util eklenir ve bu tamamen kopyala yapıştırdır.    
  2.1_) hibernate.util yerine hibernate.cfg.xml dosyasıda yazılır Aynıdır.  
*	configuration.addAnnotatedClass(Ogretmen.class); ==	bu şekilde anatasyon kullanılacak sınıf gösterilmelidir.
*	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();==
 Bunu import ederken dikkat et iki adet import'u var hibernate olanı import etmeliyiz.
  
3_) Save veya diğer işlemlerde transaction ve session oluşturulur. Bunun sebebi önemli degil.  
  *		
public class OgretmenDao {
	
	public void saveOgretmen(Ogretmen ogrtmn) throws Exception {
		Transaction transaction = null;
		
		try(Session session =  HibernateUtil.getSessionFactory().openSession()){
			
			//start transaction
			transaction = session.beginTransaction();
			//save Ogretmen object
			session.save(ogrtmn);  //Tabloyuda oluşturuyor içine kaydıda atıyor
			//commit transaction
			transaction.commit();
			//close session
			session.close();
						
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();  //birden fazla transaction yaptığında bir tanesinde bile
										//hata varsa hop hepsini geri alıyor.
			}
			throw new Exception("Kayıt başarısız!");
		}
		
	}.  

4_)
