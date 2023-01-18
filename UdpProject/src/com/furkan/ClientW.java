package com.furkan;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;


@SuppressWarnings("serial")
public class ClientW extends JFrame {

    // hostname for the server
	String host_name = "localhost";
    // JTextPane for displaying messages
	JTextPane message_field;
    // JTextPane for displaying the chat history
	JTextPane chat_field;
    // nickname of the user
	String nickname;

    // message to be sent to the server
	String message = "";
    // boolean to check if the message is ready to be sent
	boolean message_is_ready = false;

	public ClientW() {
        // set the background color of the frame
		setBackground(new Color(41, 41, 41));
		setAlwaysOnTop(true);
		setForeground(Color.DARK_GRAY);
		getContentPane().setBackground(new Color(41, 41, 41));
        // create a dialog to get the nickname of the user
		JDialog hostNameDialog = new JDialog(this, "Enter your nickname: ", true);
		JTextField hostField = new JTextField("                                ");
		JButton ok = new JButton("OK");
		hostNameDialog.getContentPane().setLayout(new FlowLayout());
		hostNameDialog.getContentPane().add(hostField);
		hostNameDialog.getContentPane().add(ok);
		hostNameDialog.getContentPane().add(ok);
		hostNameDialog.setLocationRelativeTo(null);
        // set the default close operation for the dialog
		hostNameDialog.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		hostNameDialog.setSize(250, 100);
		hostNameDialog.setResizable(false);
        // when the ok button is pressed, get the text from the hostField and store it in the nickname variable
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nickname = hostField.getText().trim();
				hostNameDialog.dispose();
			}
		});
		hostNameDialog.setVisible(true);
		
		setSize(800, 600);
		setTitle("UDP Chat room");
        // set the location of the frame to the center of the screen
		setLocationRelativeTo(null);
        // set the default close operation for the frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        // create a new JTextPane for the chat_field
		chat_field = new JTextPane();
		chat_field.setForeground(Color.WHITE);
		chat_field.setFont(new Font("Tahoma", Font.BOLD, 13));
		chat_field.setBackground(new Color(0, 0, 0));
        // create a new JTextPane for the message_field
		message_field = new JTextPane();
		message_field.setForeground(Color.WHITE);
		message_field.setFont(new Font("Tahoma", Font.BOLD, 11));
		message_field.setBackground(Color.BLACK);
        // set the chat_field to be non-editable
		chat_field.setEditable(false);
        // create a new ScrollPane for the chat_field
		ScrollPane chatscroll = new ScrollPane();
		chatscroll.setBackground(Color.WHITE);
		chatscroll.setBounds(38, 45, 679, 373);
		chatscroll.add(chat_field);
        // create a new ScrollPane for the message_field
		ScrollPane messageScroll = new ScrollPane();
		messageScroll.setBounds(38, 451, 679, 76);
		messageScroll.add(message_field);
		messageScroll.setPreferredSize(new Dimension(100, 100));
		getContentPane().setLayout(null);
		getContentPane().add(chatscroll);
		getContentPane().add(messageScroll);
		
		JLabel lblNick = new JLabel("");
		lblNick.setForeground(Color.WHITE);
		lblNick.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNick.setBounds(38, 11, 334, 21);
	
		getContentPane().add(lblNick);
		lblNick.setText(nickname);

        // set the frame to be visible
		setVisible(true);
        // add a key listener to the message_field
		message_field.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
			
				if (e.getKeyCode() == 10 && !message_is_ready) {
                    // when the enter key is pressed and the message is not ready, get the text from the message_field
                    // set the message_is_ready variable to true and notify the sender thread to send the message
					message = message_field.getText().trim();
					message_is_ready = true;
					synchronized (ClientW.this) {
						ClientW.this.notify();
					}
				}
			}
	
		});
	}
    // function to get the hostname of the server
	public String getHostName() {
		return host_name;
	}
    // function to get the nickname of the user
	public String getNickname() {
		return nickname;
	}
    // function to append a message to the chat_field
	public void appendMessage(String message) {
		chat_field.setText(chat_field.getText() + "\n" + message);
	}
    // function to clear the message_field
	public void clearTextField() {
		message_field.setText("");
	}
    // function to get the message from the message_field
	public String getMessage() {
		return message;
	}
    // function to set the message_is_ready variable to false
	public void resetMessageIsReady() {
		message_is_ready = false;
	}
}

