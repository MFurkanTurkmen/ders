package com.furkan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TabloSwing {
	ArrayList<User> list = new ArrayList<>();


	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabloSwing window = new TabloSwing();
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
	public TabloSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 915, 586);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 264, 836, 246);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
				
		
		table.setModel (new DefaultTableModel( 
		new Object[][] {
			
		},
		new String[] {
		"ID",
		"Ad",
		"Sovad"}
		));
		
		
		scrollPane.setViewportView(table);
		
		JButton btnliste = new JButton("liste cek");
		btnliste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                User user1 = new User(1, "John", "Nash");
                User user2 = new User(2, "Smith", "Watson");
                User user3 = new User(3, "Alfred", "Rock");
                list.add(user1);
                list.add(user2);
                list.add(user3);
                
                // Table'a bu arrayllisti insert edeceğim..
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                Object[] columns = new Object[3];
                for (int i=0;i<list.size();i++) {
                    columns[0] = list.get(i).getId();
                    columns[1] = list.get(i).getAd();
                    columns[2] = list.get(i).getSoyad();
                    model.addRow(columns);
                }
				
				

			}
		});
		btnliste.setBounds(41, 223, 117, 29);
		frame.getContentPane().add(btnliste);
		
		JLabel lblNewLabel = new JLabel("kayıt ekleme");
		lblNewLabel.setBounds(28, 6, 130, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setBounds(6, 51, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ad");
		lblNewLabel_2.setBounds(6, 79, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("soyad");
		lblNewLabel_3.setBounds(6, 107, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(108, 46, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(108, 74, 130, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(108, 102, 130, 26);
		frame.getContentPane().add(textField_2);
		
		JButton btnekle = new JButton("ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                Object[] columns = new Object[3];
                
				 columns[0] = textField.getText();
                 columns[1] = textField_1.getText();
                 columns[2] = textField_2.getText();
                 model.addRow(columns);
				
				
			}
		});
		btnekle.setBounds(182, 140, 117, 29);
		frame.getContentPane().add(btnekle);
		
		JButton btnsil = new JButton("sil");
		btnsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model= (DefaultTableModel) table.getModel();
				if(table.getSelectedRow()!=-1) {
					model.removeRow(table.getSelectedRow());
					JOptionPane.showMessageDialog(null, "kayıt silindi"); // küçük mesaj penceresi pop-up
					
				}
			}
		});
		btnsil.setBounds(319, 140, 117, 29);
		frame.getContentPane().add(btnsil);
	}
}
