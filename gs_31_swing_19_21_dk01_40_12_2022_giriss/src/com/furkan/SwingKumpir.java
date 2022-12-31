package com.furkan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingKumpir {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingKumpir window = new SwingKumpir();
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
	public SwingKumpir() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 873, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 77, 861, 460);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("kumpir", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("50");
		lblNewLabel.setBounds(119, 44, 23, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("kumpir");
		lblNewLabel_1.setBounds(6, 44, 101, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblTl = new JLabel("TL");
		lblTl.setBounds(144, 44, 23, 16);
		panel.add(lblTl);
		
		JCheckBox chcbsalata = new JCheckBox("rus salatası");
		chcbsalata.setBounds(6, 94, 104, 23);
		panel.add(chcbsalata);
		
		JCheckBox chcbmısır = new JCheckBox("mısır");
		chcbmısır.setBounds(6, 129, 101, 23);
		panel.add(chcbmısır);
		
		JCheckBox chcbsosis = new JCheckBox("sosis");
		chcbsosis.setBounds(6, 164, 101, 23);
		panel.add(chcbsosis);
		
		JLabel lblsalata = new JLabel("8");
		lblsalata.setBounds(119, 101, 23, 16);
		panel.add(lblsalata);
		
		JLabel lblTl_1 = new JLabel("TL");
		lblTl_1.setBounds(144, 101, 23, 16);
		panel.add(lblTl_1);
		
		JLabel lblmısır = new JLabel("5");
		lblmısır.setBounds(119, 136, 23, 16);
		panel.add(lblmısır);
		
		JLabel lblTl_2 = new JLabel("TL");
		lblTl_2.setBounds(144, 136, 23, 16);
		panel.add(lblTl_2);
		
		JLabel lblsosis = new JLabel("10");
		lblsosis.setBounds(119, 171, 23, 16);
		panel.add(lblsosis);
		
		JLabel lblTl_3 = new JLabel("TL");
		lblTl_3.setBounds(144, 171, 23, 16);
		panel.add(lblTl_3);
		
		JLabel lbltoplam = new JLabel("0");
		lbltoplam.setBounds(184, 232, 45, 16);
		panel.add(lbltoplam);
		
		JLabel lblTl_3_1 = new JLabel("TL");
		lblTl_3_1.setBounds(241, 232, 23, 16);
		panel.add(lblTl_3_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SwingKumpir.class.getResource("/com/furkan/resources/kasarli-kumpir-f5a0.jpg")));
		lblNewLabel_2.setBounds(400, 44, 434, 364);
		panel.add(lblNewLabel_2);
		
		JComboBox cmbbsalata = new JComboBox();
		cmbbsalata.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		cmbbsalata.setBounds(193, 97, 71, 27);
		panel.add(cmbbsalata);
		
		JComboBox cmbbmısır = new JComboBox();
		cmbbmısır.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		cmbbmısır.setBounds(193, 132, 71, 27);
		panel.add(cmbbmısır);
		
		JComboBox cmbbsosis = new JComboBox();
		cmbbsosis.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		cmbbsosis.setBounds(193, 167, 71, 27);
		panel.add(cmbbsosis);
		
		JButton btntoplam = new JButton("ücret hesapla:");
		btntoplam.setIcon(new ImageIcon(SwingKumpir.class.getResource("/com/furkan/resources/price-tag-icon.png")));
		btntoplam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int toplam= 50;
				
				if(chcbmısır.isSelected()) {
					toplam=(Integer.parseInt(lblmısır.getText())*Integer.parseInt(cmbbmısır.getSelectedItem().toString())+toplam);
				}
				if(chcbsalata.isSelected()) {
					toplam=(Integer.parseInt(lblsalata.getText())*Integer.parseInt(cmbbsalata.getSelectedItem().toString()))+toplam;

					
				}
				if(chcbsosis.isSelected()) {
					toplam=(Integer.parseInt(lblsosis.getText())*Integer.parseInt(cmbbsosis.getSelectedItem().toString()))+toplam;
					
				}
				lbltoplam.setText(String.valueOf(toplam));


			}
			
		});
		btntoplam.setBounds(6, 227, 136, 29);
		panel.add(btntoplam);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
	}
}
