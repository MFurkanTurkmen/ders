package com.furkan;

import java.awt.EventQueue;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

public class ComplateSwingJdbc {

	private JFrame frame;
	private JTable table;
	private JButton btnac;
	private JTextField txfdeleteid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComplateSwingJdbc window = new ComplateSwingJdbc();
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
	public ComplateSwingJdbc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1003, 586);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 24, 994, 528);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Search and delete", null, panel, null);
		panel.setLayout(null);
		
		txfdeleteid = new JTextField();
		txfdeleteid.setBackground(new Color(243, 173, 166));
		txfdeleteid.setToolTipText("id giriniz:");
		txfdeleteid.setBounds(472, 52, 130, 26);
		panel.add(txfdeleteid);
		txfdeleteid.setColumns(10);
		
		JButton btnsil = new JButton("sil");
		btnsil.setBounds(614, 48, 56, 36);
		panel.add(btnsil);
		btnsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				delete();
				List <User> list = findAll();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Object[] columns = new Object[3];
                model.setRowCount(0); // tablo içeriğini sıfırlar
				for (int i=0;i<list.size();i++) {
                    columns[0] = list.get(i).getId();
                    columns[1] = list.get(i).getAd();
                    columns[2] = list.get(i).getSoyad();
                    model.addRow(columns);
                }
			
				
				
			}
		});
		btnsil.setIcon(new ImageIcon(ComplateSwingJdbc.class.getResource("/resources/Button-Delete-icon.png")));
		
		JButton btnlist = new JButton("DB listesi cek");
		btnlist.setBounds(6, 18, 113, 36);
		panel.add(btnlist);
		btnlist.setIcon(new ImageIcon(ComplateSwingJdbc.class.getResource("/resources/User-Group-icon.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 56, 454, 420);
		panel.add(scrollPane);
		
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
		
		btnac = new JButton("dB ac");
		btnac.setBounds(472, 160, 72, 36);
		panel.add(btnac);
		btnac.setIcon(new ImageIcon(ComplateSwingJdbc.class.getResource("/resources/database.png")));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ComplateSwingJdbc window = new ComplateSwingJdbc();
				window.frame.setVisible(true);				
				
			}
		});
		btnNewButton.setBounds(749, 164, 117, 29);
		panel.add(btnNewButton);
		btnac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnect();
				JOptionPane.showMessageDialog(null, "baglanti basarili");
			}
		});
		btnlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List <User> list = findAll();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Object[] columns = new Object[3];
                model.setRowCount(0); // tablo içeriğini sıfırlar
				for (int i=0;i<list.size();i++) {
                    columns[0] = list.get(i).getId();
                    columns[1] = list.get(i).getAd();
                    columns[2] = list.get(i).getSoyad();
                    model.addRow(columns);
                }
			}
		});
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("create and update", null, panel_1, null);
	}
	
	
	 
	
	
	public Connection DBConnect() {
		System.out.println("Trying to connect...");

		String adres = "jdbc:postgresql://127.0.0.1:5432/21.12.2022DB";	

		String kullaniciadi = "postgres";

		String sifre = "asd123asd";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(adres, kullaniciadi, sifre);
			System.out.println("Connection established..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		return conn;
		
	}
	
	
	public List<User> findAll(){
		List <User> list= new ArrayList<>();
		Connection conn= DBConnect();
		String sqlSorgu= "select * from users";
		PreparedStatement prp ;
		
		try {
			prp= conn.prepareCall(sqlSorgu);
			ResultSet rs= prp.executeQuery();
			
			while(rs.next()) {
				User u= new User(rs.getInt("id"), rs.getString(2), rs.getString("soyad"));
				list.add(u);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {if(conn != null) {
		
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("VT bağlantısı kapatılırken hata oluştu");
				}
			}
			
			System.out.println("Veri tabanı kapatılmıştır");
			
		}
		
		
		return list ;
	}

	public void delete() {
		Connection conn= DBConnect();
		
		String sql= "delete from users where id="+ txfdeleteid.getText();
		try {
			PreparedStatement prp = conn.prepareCall(sql);
			prp.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "DB kapanırken hata");
				}
		}
		
		
	}
}
