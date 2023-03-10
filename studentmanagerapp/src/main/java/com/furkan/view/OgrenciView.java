package com.furkan.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.furkan.entity.Ogrenci;
import com.furkan.entity.OgrenciBilgi;
import com.furkan.service.OgrenciService;

public class OgrenciView {
	private JFrame frame;
	private JTable table;
	private JTextField textFieldID;
	private JTextField textFieldEmail;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldTel1;
	private JTextField textFieldTel2;
	private JEditorPane textFieldAdres1;
	private JEditorPane textFieldAdres2;
	private JLabel lblId;
	private JLabel lblEmail;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblCinsiyet;
	private JComboBox comboBoxGender;
	private JButton btnEmailSorgula;
	private JButton btnFirstNameSorgula;
	private JButton btnLastNameSorgula;
	private JComboBox comboBoxLanguage;
	private JButton btnGetAll;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblTel;
	private JLabel lblAdres;
	private JLabel lblFoto;
	private JLabel lblLanguage;
	private ResourceBundle resourceBundle;
	private OgrenciService ogrenciService;
	private JScrollPane scrollPane_1;
	private byte[] image;
	private String path;
	private ImageIcon myimage;
	private String imagePaths;
	private String imagePath = " ";
	private JLabel lblAddress;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OgrenciView window = new OgrenciView();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * @wbp.parser.entryPoint
	 */
	public OgrenciView() {
		ogrenciService = new OgrenciService();
		initialize();
		Locale.setDefault(new Locale("en","EN"));
	}
	
	private void i18n() {
		resourceBundle = ResourceBundle.getBundle("com/furkan/config/resource_bundle");
		comboBoxGender.removeAllItems();
		lblId.setText(resourceBundle.getString("id"));
		lblEmail.setText(resourceBundle.getString("email"));
		lblFirstName.setText(resourceBundle.getString("firstname"));
		lblLastName.setText(resourceBundle.getString("lastname"));
		lblCinsiyet.setText("gender");         
		comboBoxGender.removeAllItems();
		comboBoxGender.addItem(resourceBundle.getString("genderM"));
		comboBoxGender.addItem(resourceBundle.getString("genderW"));
		btnEmailSorgula.setText(resourceBundle.getString("querybyemail"));
		btnFirstNameSorgula.setText(resourceBundle.getString("querybyfirstname"));
		btnLastNameSorgula.setText(resourceBundle.getString("querybylastname"));
		lblTel.setText(resourceBundle.getString("tel"));
		lblAdres.setText(resourceBundle.getString("address"));

		btnGetAll.setText(resourceBundle.getString("getall"));
		btnSave.setText(resourceBundle.getString("save"));
		btnUpdate.setText(resourceBundle.getString("update"));
		btnDelete.setText(resourceBundle.getString("delete"));
		lblLanguage.setText(resourceBundle.getString("language"));
		lblCinsiyet.setText(resourceBundle.getString("gender"));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					resourceBundle.getString("id"), resourceBundle.getString("email"), resourceBundle.getString("firstname"), resourceBundle.getString("lastname")
				}
			));
		comboBoxLanguage.removeAllItems();
		comboBoxLanguage.addItem(resourceBundle.getString("languageen"));
		comboBoxLanguage.addItem(resourceBundle.getString("languagetr"));
		comboBoxLanguage.addItem(resourceBundle.getString("languagefr"));

		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldID.setText("");
				textFieldFirstName.setText("");
				textFieldLastName.setText("");
				textFieldEmail.setText("");
				textFieldTel1.setText("");
				textFieldAdres1.setText("");
				textFieldTel2.setText("");
				textFieldAdres2.setText("");
				lblFoto.setIcon(null);
				
			}
		});
		frame.setBounds(100, 100, 1204, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(528, 137, 621, 387);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionForeground(new Color(225, 109, 4));
		table.setSelectionBackground(new Color(40, 40, 40));
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(Color.LIGHT_GRAY);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int satir = table.getSelectedRow();
				if(satir !=-1) {
					TableModel model = table.getModel();
					textFieldID.setText(model.getValueAt(satir, 0).toString());
					textFieldEmail.setText(model.getValueAt(satir, 1).toString());
					textFieldFirstName.setText(model.getValueAt(satir, 2).toString());
					textFieldLastName.setText(model.getValueAt(satir, 3).toString());
					List<Ogrenci> ogrenciList = ogrenciService.findByEmail(textFieldEmail.getText());
					Ogrenci ogrenci = ogrenciList.get(0);
					textFieldAdres1.setText(ogrenci.getOgrenciBilgileri().getAdres1());
					textFieldTel1.setText(String.valueOf(ogrenci.getOgrenciBilgileri().getTel1()));

					if(ogrenci.getOgrenciBilgileri().getAdres2()!= null) {
						textFieldAdres2.setText(ogrenci.getOgrenciBilgileri().getAdres2());
					}else {
						textFieldAdres2.setText("");
					}

					if(ogrenci.getOgrenciBilgileri().getTel2()!=0) {
						textFieldTel2.setText(String.valueOf(ogrenci.getOgrenciBilgileri().getTel2()));
					}else {
						textFieldTel2.setText("");
					}
					
					if(ogrenci.getOgrenciBilgileri().getCinsiyet().equalsIgnoreCase("MAN")) {
						comboBoxGender.setSelectedItem(comboBoxGender.getItemAt(0));
					}
					if(ogrenci.getOgrenciBilgileri().getCinsiyet().equalsIgnoreCase("WOMAN")) {
						comboBoxGender.setSelectedItem(comboBoxGender.getItemAt(1));
					}
					
					byte[] r = ogrenci.getImage();
					if(ogrenci.getImage() != null) {
						ImageIcon image = new ImageIcon(r);
						Image img = image.getImage();
						Image img2 = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
						ImageIcon imgicon = new ImageIcon(img2);
						lblFoto.setIcon(imgicon);
					}
					else {
						lblFoto.setIcon(null);
					}
					
					
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Email", "First Name", "Last Name"
			}
		));
		scrollPane.setViewportView(table);
		
		lblId = new JLabel("ID:");
		lblId.setForeground(new Color(9, 11, 5));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblId.setBounds(12, 46, 94, 20);
		frame.getContentPane().add(lblId);
		
		textFieldID = new JTextField();
		textFieldID.setBackground(Color.LIGHT_GRAY);
		textFieldID.setForeground(Color.WHITE);
		textFieldID.setEditable(false);
		textFieldID.setBounds(127, 46, 128, 20);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(127, 76, 128, 20);
		frame.getContentPane().add(textFieldEmail);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setColumns(10);
		textFieldFirstName.setBounds(127, 106, 128, 20);
		frame.getContentPane().add(textFieldFirstName);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(127, 136, 128, 20);
		frame.getContentPane().add(textFieldLastName);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(9, 11, 5));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEmail.setBounds(12, 76, 94, 20);
		frame.getContentPane().add(lblEmail);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFirstName.setBounds(12, 106, 114, 20);
		frame.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLastName.setBounds(12, 136, 114, 20);
		frame.getContentPane().add(lblLastName);
		
		lblCinsiyet = new JLabel("Gender:");
		lblCinsiyet.setForeground(Color.BLACK);
		lblCinsiyet.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCinsiyet.setBounds(12, 166, 94, 20);
		frame.getContentPane().add(lblCinsiyet);
		
		comboBoxGender = new JComboBox();
		comboBoxGender.setBackground(Color.LIGHT_GRAY);
		comboBoxGender.setForeground(Color.BLACK);
		comboBoxGender.setFont(new Font("Tahoma", Font.BOLD, 10));
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"MAN", "WOMAN"}));
		comboBoxGender.setBounds(127, 165, 128, 22);
		frame.getContentPane().add(comboBoxGender);
		
		btnEmailSorgula = new JButton("Query By Email");
		btnEmailSorgula.setBackground(Color.DARK_GRAY);
		btnEmailSorgula.setForeground(Color.BLACK);
		btnEmailSorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldEmail.getText().isEmpty()) {
					List<Ogrenci> list =ogrenciService.findByEmail(textFieldEmail.getText());
						
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					Object[] column = new Object[4];
					model.setRowCount(0);
					for (int i = 0; i <list.size(); i++) {
						column[0]=list.get(i).getId();
						column[1]=list.get(i).getEmail();
						column[2]=list.get(i).getAd();
						column[3]=list.get(i).getSoyad();
						model.addRow(column);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Email k??sm??n?? doldurun");
				}
			}
		});
		btnEmailSorgula.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEmailSorgula.setBounds(290, 78, 181, 20);
		frame.getContentPane().add(btnEmailSorgula);
		
		btnFirstNameSorgula = new JButton("Query By First Name");
		btnFirstNameSorgula.setBackground(Color.DARK_GRAY);
		btnFirstNameSorgula.setForeground(Color.BLACK);
		btnFirstNameSorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					if(!textFieldFirstName.getText().isEmpty()) {
						List<Ogrenci>list=ogrenciService.findByUsername(textFieldFirstName.getText());
						
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						
						Object[] column = new Object[4];
						model.setRowCount(0);
						for (int i = 0; i <list.size(); i++) {
							column[0]=list.get(i).getId();
							column[1]=list.get(i).getEmail();
							column[2]=list.get(i).getAd();
							column[3]=list.get(i).getSoyad();
							model.addRow(column);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Ad k??sm??n?? doldurun");
					}
					
				
				
			}
		});
		btnFirstNameSorgula.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnFirstNameSorgula.setBounds(290, 108, 181, 20);
		frame.getContentPane().add(btnFirstNameSorgula);
		
		btnLastNameSorgula = new JButton("Query By Last Name");
		btnLastNameSorgula.setBackground(Color.DARK_GRAY);
		btnLastNameSorgula.setForeground(Color.BLACK);
		btnLastNameSorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!textFieldLastName.getText().isEmpty()) {
					List<Ogrenci>list=ogrenciService.findByLastName(textFieldLastName.getText());
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					Object[] column = new Object[4];
					model.setRowCount(0);
					for (int i = 0; i <list.size(); i++) {
						column[0]=list.get(i).getId();
						column[1]=list.get(i).getEmail();
						column[2]=list.get(i).getAd();
						column[3]=list.get(i).getSoyad();
						model.addRow(column);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Soyad k??sm??n?? doldurun");
				}
				
			}
		});
		btnLastNameSorgula.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnLastNameSorgula.setBounds(290, 138, 181, 20);
		frame.getContentPane().add(btnLastNameSorgula);
		
		lblTel = new JLabel("Telephone:");
		lblTel.setForeground(Color.BLACK);
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTel.setBounds(12, 198, 114, 20);
		frame.getContentPane().add(lblTel);
		
		lblAdres = new JLabel("Address:");
		lblAdres.setForeground(Color.BLACK);
		lblAdres.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAdres.setBounds(12, 262, 94, 23);
		frame.getContentPane().add(lblAdres);
		
		textFieldTel1 = new JTextField();
		textFieldTel1.setColumns(10);
		textFieldTel1.setBounds(127, 199, 128, 20);
		frame.getContentPane().add(textFieldTel1);
		
		textFieldTel2 = new JTextField();
		textFieldTel2.setColumns(10);
		textFieldTel2.setBounds(127, 230, 130, 20);
		frame.getContentPane().add(textFieldTel2);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(127, 262, 128, 80);
		frame.getContentPane().add(scrollPane_1);
		
		textFieldAdres1 = new JEditorPane();
		scrollPane_1.setViewportView(textFieldAdres1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(127, 354, 130, 80);
		frame.getContentPane().add(scrollPane_2);
		
		textFieldAdres2 = new JEditorPane();
		scrollPane_2.setViewportView(textFieldAdres2);
		
		lblFoto = new JLabel("");
		lblFoto.setForeground(Color.BLACK);
		lblFoto.setIcon(null);
		lblFoto.setBounds(127, 446, 150, 150);
		frame.getContentPane().add(lblFoto);
		path = null;
		
		
		lblLanguage = new JLabel("Language:");
		lblLanguage.setForeground(Color.BLACK);
		lblLanguage.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLanguage.setBounds(653, 6, 94, 20);
		frame.getContentPane().add(lblLanguage);
		
		comboBoxLanguage = new JComboBox();
		comboBoxLanguage.setBackground(Color.DARK_GRAY);
		comboBoxLanguage.setForeground(Color.BLACK);
		comboBoxLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resourceBundle = ResourceBundle.getBundle("com/furkan/config/resource_bundle");
				
				if(comboBoxLanguage.getSelectedItem().toString().equalsIgnoreCase(resourceBundle.getString("languageen"))) {
					Locale.setDefault(new Locale("en","EN"));
					i18n();
					comboBoxLanguage.setSelectedIndex(0);
				} else if(comboBoxLanguage.getSelectedItem().toString().equalsIgnoreCase(resourceBundle.getString("languagefr"))) {
					Locale.setDefault(new Locale("fr","FR"));
					i18n();
					comboBoxLanguage.setSelectedIndex(2);
				} else if(comboBoxLanguage.getSelectedItem().toString().equalsIgnoreCase(resourceBundle.getString("languagetr"))) {
					Locale.setDefault(new Locale("tr","TR"));
					i18n();
					comboBoxLanguage.setSelectedIndex(1);
				}
			}
		});
		comboBoxLanguage.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxLanguage.setModel(new DefaultComboBoxModel(new String[] {"English", "Turkish", "French"}));
		comboBoxLanguage.setBounds(759, 6, 121, 22);
		frame.getContentPane().add(comboBoxLanguage);
		
		btnGetAll = new JButton("Get All");
		btnGetAll.setBackground(Color.DARK_GRAY);
		btnGetAll.setForeground(Color.BLACK);
		btnGetAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabloDoldur();
				
			}
		});
		btnGetAll.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnGetAll.setBounds(931, 107, 212, 23);
		frame.getContentPane().add(btnGetAll);
		
		btnSave = new JButton("Save");
		btnSave.setBackground(Color.DARK_GRAY);
		btnSave.setForeground(Color.BLACK);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				kaydet();
				tabloDoldur();
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSave.setBounds(281, 231, 194, 23);
		frame.getContentPane().add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBackground(Color.DARK_GRAY);
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				tabloDoldur();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUpdate.setBounds(281, 305, 194, 23);
		frame.getContentPane().add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.DARK_GRAY);
		btnDelete.setForeground(Color.BLACK);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if(table.getSelectedRow() != -1) {
					String email =(String)model.getValueAt(table.getSelectedRow(), table.getSelectedColumn());	
					model.removeRow(table.getSelectedRow());
					List<Ogrenci> ogrenciler = ogrenciService.findByEmail(email);
					Ogrenci ogrenci = ogrenciler.get(0);			
					if(ogrenci != null) {
						ogrenciService.delete(ogrenci);
					}
					tabloDoldur();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDelete.setBounds(281, 375, 194, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnNewButton = new JButton("Add Photo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File("user.dir"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("All Pic", "png", "jpg", "jpeg", "gif");
				fc.addChoosableFileFilter(filter);
				int a = fc.showSaveDialog(null);
				if (a == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				String p = f.getAbsolutePath();
				imagePaths = fc.getSelectedFile().getAbsolutePath();
				lblFoto.setIcon(seticon(p,image));
				
				
				}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(12, 501, 110, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblTelephone = new JLabel("Telephone2:");
		lblTelephone.setForeground(Color.BLACK);
		lblTelephone.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTelephone.setBounds(12, 230, 114, 20);
		frame.getContentPane().add(lblTelephone);
		
		lblAddress = new JLabel("Address2:");
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAddress.setBounds(12, 354, 94, 22);
		frame.getContentPane().add(lblAddress);
		
		
	}
	public void kaydet() {
		if(!textFieldAdres1.getText().isEmpty() && !textFieldTel1.getText().isEmpty() && !textFieldEmail.getText().isEmpty() && !textFieldFirstName.getText().isEmpty() && !textFieldLastName.getText().isEmpty()) {
			OgrenciBilgi ogrenciBilgi = new OgrenciBilgi();
			ogrenciBilgi.setCinsiyet(comboBoxGender.getSelectedItem().toString());
			ogrenciBilgi.setAdres1(textFieldAdres1.getText());
			ogrenciBilgi.setTel1(Long.parseLong(textFieldTel1.getText()));

			
			if(!textFieldAdres2.getText().isEmpty()) {
				ogrenciBilgi.setAdres2(textFieldAdres2.getText());
			}
			if(!textFieldTel2.getText().isEmpty()) {
				ogrenciBilgi.setTel2(Long.parseLong(textFieldTel2.getText()));
			}
			byte[] data=null;
			if(imagePaths != null) {
				FileInputStream fis;
				
				try {
					fis = new FileInputStream(imagePaths);
					data = new byte[fis.available()];
					fis.read(data);
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			
			Ogrenci ogrenci = new Ogrenci(textFieldEmail.getText(), textFieldFirstName.getText(), textFieldLastName.getText(), ogrenciBilgi);
			ogrenci.setImage(data);
	
			ogrenciService.create(ogrenci);
		}else {
			JOptionPane.showMessageDialog(null,"BO?? ALANLARI DOLDURUN");
		}
	}
	public void tabloDoldur() {
		List<Ogrenci> list =ogrenciService.listAll();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] column = new Object[4];
		model.setRowCount(0);
		for (int i = 0; i <list.size(); i++) {
			column[0]=list.get(i).getId();
			column[1]=list.get(i).getEmail();
			column[2]=list.get(i).getAd().substring(0,1).toUpperCase()+list.get(i).getAd().substring(1).toLowerCase();
			column[3]=list.get(i).getSoyad().substring(0,1).toUpperCase()+list.get(i).getSoyad().substring(1).toLowerCase();
			model.addRow(column);
		}
	}
	public void update() {
		if(!textFieldAdres1.getText().isEmpty() && !textFieldTel1.getText().isEmpty() && !textFieldEmail.getText().isEmpty() && !textFieldFirstName.getText().isEmpty() && !textFieldLastName.getText().isEmpty()) {
			OgrenciBilgi ogrenciBilgi = new OgrenciBilgi();
			ogrenciBilgi.setCinsiyet(comboBoxGender.getSelectedItem().toString());
			ogrenciBilgi.setAdres1(textFieldAdres1.getText());
			ogrenciBilgi.setTel1(Long.parseLong(textFieldTel1.getText()));

			if(!textFieldAdres2.getText().isEmpty()) {
				ogrenciBilgi.setAdres2(textFieldAdres2.getText());
			}
			if(!textFieldTel2.getText().isEmpty()) {
				ogrenciBilgi.setTel2(Long.parseLong(textFieldTel2.getText()));
			}
			
			FileInputStream fis;
			byte[] data=null;
			try {
				fis = new FileInputStream(imagePaths);
				data = new byte[fis.available()];
				fis.read(data);
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Ogrenci ogrenci = new Ogrenci(textFieldEmail.getText(), textFieldFirstName.getText(), textFieldLastName.getText(), ogrenciBilgi);
			ogrenci.setImage(data);
			ogrenciService.update(Long.parseLong(textFieldID.getText()),ogrenci);
		}else {
			JOptionPane.showMessageDialog(null,"BO?? ALANLARI DOLDURUN");
		}
	}
	
	public ImageIcon seticon(String m, byte[] image) {
		if (m != null) {
			myimage = new ImageIcon(m);
		} else {
			myimage = new ImageIcon(image);
		}
		Image img1 = myimage.getImage();
		Image img2 = img1.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img2);
		return i;
	}
	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
