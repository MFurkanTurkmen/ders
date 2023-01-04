package com.furkan.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.furkan.entity.Classroom;
import com.furkan.entity.Student;
import com.furkan.repository.ClassroomDao;
import com.furkan.repository.StudentDao;

import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class View {

	private JFrame frame;
	private JTextField textField_name;
	private JTextField textField_surname;
	private JTextField textField_password;
	private JButton btn_student_save;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1089, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(6, 214, 112, 27);
		frame.getContentPane().add(comboBox);
	
		
		JButton btnguncelle = new JButton("guncelle");
		btnguncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassroomDao classroomDao = new ClassroomDao();
				Object [] a = new String [classroomDao.findAll().size()];
				for (int i =0 ;i<classroomDao.findAll().size();i++) {
					a[i]="id"+classroomDao.findAll().get(i).getClassroomId()+", classroom name "+classroomDao.findAll().get(i).getClassName();
				}
				DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>(a);
				comboBox.setModel(model);


				
				
			}
		});
		btnguncelle.setBounds(172, 213, 117, 29);
		frame.getContentPane().add(btnguncelle);
		
		textField_name = new JTextField();
		textField_name.setBounds(6, 45, 130, 26);
		frame.getContentPane().add(textField_name);
		textField_name.setColumns(10);
		
		textField_surname = new JTextField();
		textField_surname.setBounds(6, 107, 130, 26);
		frame.getContentPane().add(textField_surname);
		textField_surname.setColumns(10);
		
		textField_password = new JTextField();
		textField_password.setBounds(6, 165, 130, 26);
		frame.getContentPane().add(textField_password);
		textField_password.setColumns(10);
		
		btn_student_save = new JButton("New button");
		btn_student_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Classroom cl= (Classroom)comboBox.getSelectedItem();
				Student st= new Student(textField_name.getText(),textField_surname.getText(),textField_password.getText(),cl);
				StudentDao studentDao = new StudentDao();
				studentDao.save(st);
			}
		});
		btn_student_save.setBounds(188, 45, 117, 29);
		frame.getContentPane().add(btn_student_save);
	
	}
}
