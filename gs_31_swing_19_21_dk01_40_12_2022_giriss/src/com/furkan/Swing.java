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
import javax.swing.JTable;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

public class Swing {

	private JFrame frame;
	private JTextField txfogrno;
	private JTextField txfad;
	private JTextField txfsoyad;
	private JTextField txfbirlestir;
	private JLabel lblvize1;
	private JLabel lblvize2;
	private JLabel lblfinal;
	private JTextField txfvize1;
	private JTextField txfvize2;
	private JTextField txffinal;
	private JButton btnortalama;
	private JTextField txfortalama;
	private JButton btnNewButton;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws InterruptedException {
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
	public Swing() throws InterruptedException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws InterruptedException {
		frame = new JFrame();
		frame.setBounds(100, 100, 992, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblogrno = new JLabel("ogrenci no:");
		lblogrno.setBounds(6, 16, 86, 16);
		frame.getContentPane().add(lblogrno);
		
		JLabel lblAd = new JLabel("ad :");
		lblAd.setBounds(6, 44, 86, 16);
		frame.getContentPane().add(lblAd);
		
		JLabel lblSoyad = new JLabel("soyad:");
		lblSoyad.setBounds(6, 72, 86, 16);
		frame.getContentPane().add(lblSoyad);
		
		txfogrno = new JTextField();
		txfogrno.setBounds(104, 11, 130, 26);
		frame.getContentPane().add(txfogrno);
		txfogrno.setColumns(10);
		
		txfad = new JTextField();
		txfad.setColumns(10);
		txfad.setBounds(104, 39, 130, 26);
		frame.getContentPane().add(txfad);
		
		txfsoyad = new JTextField();
		txfsoyad.setColumns(10);
		txfsoyad.setBounds(104, 67, 130, 26);
		frame.getContentPane().add(txfsoyad);
		
		JButton btnbirlestir = new JButton("birlestir");
		btnbirlestir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txfbirlestir.setText(txfad.getText()+" "+txfsoyad.getText()+" "+txfogrno.getText());
			}
		});
		btnbirlestir.setBounds(6, 180, 86, 29);
		frame.getContentPane().add(btnbirlestir);

		lblvize1 = new JLabel("vize1");
		lblvize1.setBounds(396, 16, 61, 16);
		frame.getContentPane().add(lblvize1);
		
		lblvize2 = new JLabel("vize2");
		lblvize2.setBounds(396, 44, 61, 16);
		frame.getContentPane().add(lblvize2);
		
		lblfinal = new JLabel("final");
		lblfinal.setBounds(396, 72, 61, 16);
		frame.getContentPane().add(lblfinal);
		
		txfvize1 = new JTextField();
		txfvize1.setBounds(486, 11, 74, 26);
		frame.getContentPane().add(txfvize1);
		txfvize1.setColumns(10);
		
		txfvize2 = new JTextField();
		txfvize2.setColumns(10);
		txfvize2.setBounds(486, 39, 74, 26);
		frame.getContentPane().add(txfvize2);
		
		txffinal = new JTextField();
		txffinal.setColumns(10);
		txffinal.setBounds(486, 67, 74, 26);
		frame.getContentPane().add(txffinal);
		
		btnortalama = new JButton("ortalama");
		btnortalama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			float  ort= ((Integer.parseInt(txfvize1.getText())*(float)3/10)+ (Integer.parseInt(txfvize2.getText())*(float)3/10)+ (Integer.parseInt(txffinal.getText())*(float)4/10));
			txfortalama.setText(String.valueOf(ort));
			}
		});
		btnortalama.setBounds(371, 123, 86, 29);
		frame.getContentPane().add(btnortalama);
		
		txfortalama = new JTextField();
		txfortalama.setBounds(486, 123, 74, 26);
		frame.getContentPane().add(txfortalama);
		txfortalama.setColumns(10);
		
		
		JLabel lblDnem = new JLabel("dönem: ");
		lblDnem.setBounds(6, 128, 86, 16);
		frame.getContentPane().add(lblDnem);
		
		txfbirlestir = new JTextField();
		txfbirlestir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txfbirlestir.setBounds(119, 180, 190, 26);
		frame.getContentPane().add(txfbirlestir);
		txfbirlestir.setColumns(10);
		
		
		
		
		JComboBox cmbbmevsim = new JComboBox();
		cmbbmevsim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txfbirlestir.setText(cmbbmevsim.getSelectedItem().toString());
			}
		});
		cmbbmevsim.setModel(new DefaultComboBoxModel(new String[] {"ilkbahar", "güz", "yaz"}));
		cmbbmevsim.setBounds(104, 124, 130, 27);
		frame.getContentPane().add(cmbbmevsim);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(694, 128, 222, 137);
		frame.getContentPane().add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(694, 300, 190, 137);
		frame.getContentPane().add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textArea.setText(String.valueOf(slider.getValue()));
			}
		});
		slider.setMinimum(100);
		slider.setMaximum(300);
		slider.setBounds(655, 469, 246, 61);
		frame.getContentPane().add(slider);
		
		JButton btnslider = new JButton("slider");
		btnslider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(String.valueOf(slider.getValue()));
				
			}
		});
		btnslider.setBounds(500, 469, 117, 29);
		frame.getContentPane().add(btnslider);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("Allahu ekbeeeer!!!");
				int a=slider.getValue();
				while(a>0) {
					
					
					a--;
					editorPane.setText(editorPane.getText()+ ""+a+"\n");
				}
			}
		});
		btnNewButton.setToolTipText("allahu ekber yazdırır");
		btnNewButton.setIcon(new ImageIcon(Swing.class.getResource("/com/furkan/resources/rifle-2.png")));
		btnNewButton.setBounds(600, 169, 40, 38);
		frame.getContentPane().add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(61, 273, 246, 164);
		frame.getContentPane().add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("müsteri", null, panel, null);
		panel.setLayout(null);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(6, 30, 117, 29);
		panel.add(btnNewButton_1);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("ürün", null, panel_1, null);
		panel_1.setLayout(null);
		
		
		
		
		
		
	}
}
