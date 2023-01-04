package com.furkan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Axaxza {
	int a;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Axaxza window = new Axaxza();
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
	public Axaxza() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 846, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
			 a = 10;
			while(a>=0) {
					System.out.println(a);
					JOptionPane.showMessageDialog(null, a +"ALLAHU EKBEEEER");
					a--;
				}
				
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Axaxza.class.getResource("/resources/AK-47_assault_rifle.jpg")));
		lblNewLabel.setBounds(6, 6, 834, 429);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnates = new JButton("allahu ekbeeeer");
		btnates.setBounds(69, 6, 310, 29);
		frame.getContentPane().add(btnates);
	}
}
