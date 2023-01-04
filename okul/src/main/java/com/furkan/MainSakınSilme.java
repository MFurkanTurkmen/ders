//package com.furkan;
//
//import java.util.List;
//import java.util.Objects;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//
//import com.furkan.entity.Classroom;
//import com.furkan.entity.Student;
//
//import lombok.NonNull;
//
//public class MainSakınSilme {
//	public static void main(String[] args) {
//		
//		System.out.println("-------------------");
//		
//	System.out.println("public class Student {\n"
//			+ "	@Id\n"
//			+ "	@GeneratedValue(strategy = GenerationType.IDENTITY)\n"
//			+ "	@Column(name=\"STUDENT_NUMBER\")\n"
//			+ "	private int studentNumber;\n"
//			+ "	\n"
//			+ "	@Column(nullable = false)\n"
//			+ "	@NonNull\n"
//			+ "	private String studentName;\n"
//			+ "	@NonNull\n"
//			+ "	private String studentSurname;\n"
//			+ "	@NonNull\n"
//			+ "	@Column(nullable = false)\n"
//			+ "	private String password;\n"
//			+ "	\n"
//			+ "	@ManyToOne(cascade = CascadeType.ALL)\n"
//			+ "	@NonNull\n"
//			+ "	@JoinColumn(name =\"classroom_id\", referencedColumnName = \"CLASSROOM_ID\")\n"
//			+ "	private Classroom classroom;\n"
//			+ "\n"
//			+ "	@Override\n"
//			+ "	public String toString() {\n"
//			+ "		return \"Student [studentNumber=\" + studentNumber + \", studentName=\" + studentName + \", studentSurname=\"\n"
//			+ "				+ studentSurname + \", password=\" + password + \", classroom=\" + classroom + \"]\";\n"
//			+ "	}\n"
//			+ "		");
//	
//	
//	System.out.println("public class Classroom {\n"
//			+ "\n"
//			+ "	@Id\n"
//			+ "	@GeneratedValue(strategy = GenerationType.IDENTITY)\n"
//			+ "	@Column(name=\"CLASSROOM_ID\")\n"
//			+ "	private int classroomId;\n"
//			+ "	\n"
//			+ "	@NonNull\n"
//			+ "	@Column(unique = true)\n"
//			+ "	private String className;\n"
//			+ "\n"
//			+ "	\n"
//			+ "	@OneToMany(cascade = CascadeType.ALL)\n"
//			+ "	@JoinTable(name = \"classroom_detail_forstudent\",\n"
//			+ "	joinColumns = @JoinColumn(name =\"classroom_id\",referencedColumnName = \"CLASSROOM_ID\"),\n"
//			+ "	inverseJoinColumns = @JoinColumn(name=\"student_id\",referencedColumnName = \"STUDENT_NUMBER\")\n"
//			+ "			)\n"
//			+ "	private List<Student> student;\n"
//			+ "	");
//	
//	
//	
//	System.out.println("find all first: iki adet çağırma şekli var \nDENENEN YÖNTEMLER : "
//			+ "\n---repo da return dan önce eklendi: authorList.forEach(System.out::println); ---> hata verdi \n"
//			+ "---burada main de denendi : stu.findAllStudent().forEach(System.out::println);   ---> hata verdi \n"
//			+ "---mainde denendi yine : stu.findAllFirst().stream().forEach(System.out::println); ---> hata verdi   \n\n\n"
//			+ "REPOSİTORY : \n1_	public List<Student> findAllFirst(){\n"
//			+ "		List <Student> a = new ArrayList<>();\n"
//			+ "		Session session = HibernateUtils.getSessionFactory().openSession();\n"
//			+ "		String queryy = \"From Student\";\n"
//			+ "		TypedQuery<Student> st = session.createQuery(queryy);\n"
//			+ "		a= st.getResultList();\n"
//			+ "		\n"
//			+ "		return a;\n"
//			+ "	} \n"
//			+ "2_ 	public List<T> findAll(T t) {\n"
//			+ "			List<T> list=null;\n"
//			+ "       	 openSession();\n"
//			+ "       	 Criteria cr=session.createCriteria(t.getClass());\n"
//			+ "       	 list=cr.list();\n"
//			+ "        closeSession();\n"
//			+ "\n"
//			+ "        return list;\n"
//			+ "	} \n"
//			+ "CALİSAN YONTEMLER :\n"
//			+ "1_ System.out.println(stu.findAllFirst().stream().map(obj -> Objects.toString(obj.getStudentName())).toList());\n"
//			+ "2_ for(Student uye : stu.findAllFirst()){\n"
//			+ "		System.out.println(\"id : \"+uye.getStudentNumber()+\" , ad=\"+uye.getStudentName()+\" , sınıf : \"+uye.getClassroom().getClassName());}\n");
//			
//	
//	
//	System.out.println(stu.findAllFirst().stream().map(obj -> Objects.toString(obj.getStudentName())).toList());
//
//	for(Student uye : stu.findAllFirst()){
//		System.out.println("id : "+uye.getStudentNumber()+" , ad="+uye.getStudentName()+" , sınıf : "+uye.getClassroom().getClassName());
//	}
//
//
//
//}
//	
//	
//	
//}
