package com.furkan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Swing {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing window = new Swing();
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
	public Swing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox chcmarul = new JCheckBox("marul");
		chcmarul.setBounds(6, 49, 92, 23);
		frame.getContentPane().add(chcmarul);
		
		JCheckBox chcmısır = new JCheckBox("mısır");
		chcmısır.setBounds(6, 84, 92, 23);
		frame.getContentPane().add(chcmısır);
		
		JCheckBox chcsogan = new JCheckBox("sogan");
		chcsogan.setBounds(6, 119, 92, 23);
		frame.getContentPane().add(chcsogan);
		
		JLabel lblmarul = new JLabel("8 TL");
		lblmarul.setBounds(123, 53, 61, 16);
		frame.getContentPane().add(lblmarul);
		
		JLabel lblmısır = new JLabel("15 TL");
		lblmısır.setBounds(123, 88, 61, 16);
		frame.getContentPane().add(lblmısır);
		
		JLabel lblsogan = new JLabel("10 TL");
		lblsogan.setBounds(123, 123, 61, 16);
		frame.getContentPane().add(lblsogan);
		
		JLabel lblkumpir = new JLabel("50 TL");
		lblkumpir.setBounds(123, 16, 61, 16);
		frame.getContentPane().add(lblkumpir);
		
		
		
		JComboBox combomarul = new JComboBox();
		combomarul.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		combomarul.setBounds(211, 49, 76, 27);
		frame.getContentPane().add(combomarul);
		
		
		JLabel lblücret = new JLabel("50 TL");
		lblücret.setBounds(123, 178, 61, 16);
		frame.getContentPane().add(lblücret);
		
		JLabel lblKumpir = new JLabel("Kumpir");
		lblKumpir.setBounds(37, 16, 61, 16);
		frame.getContentPane().add(lblKumpir);
		
		JButton btnsepet = new JButton("sepete ekle");
		btnsepet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int toplam =50;
			if(chcmarul.isSelected()) {
				toplam= toplam+Integer.parseInt(combomarul.getSelectedItem().toString())*Integer.parseInt(lblmarul.getText());
				lblücret.setText(String.valueOf(toplam));		
				
			}
				
			}
		});
		btnsepet.setBounds(6, 173, 108, 29);
		frame.getContentPane().add(btnsepet);
		
		
	}

}
