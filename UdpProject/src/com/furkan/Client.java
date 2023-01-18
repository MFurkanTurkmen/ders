package com.furkan;

import java.net.DatagramSocket;

public class Client {
    /**
     * Main method that creates a new instance of the ClientWindow, 
     * gets the hostname, nickname and creates a socket for the client
     * creates an instance of the MessageReceiver and MessageSender classes,
     * starts the threads for the receiver and sender
     */
	public static void main(String args[]) throws Exception {
			
		ClientW window = new ClientW();
        // get the hostname
		String host = window.getHostName();
        // get the nickname
		String nickname = window.getNickname();
		window.setTitle("UDP CHAT - "+nickname);
        // create a new socket for the client
		DatagramSocket socket = new DatagramSocket();
        // create a new instance of the MessageReceiver class
		MessageReceiver receiver = new MessageReceiver(socket, window,nickname);
        // create a new instance of the MessageSender class
		MessageSender sender = new MessageSender(socket, host, window,nickname);
		Thread receiverThread = new Thread(receiver);
		Thread senderThread = new Thread(sender);
		receiverThread.start();
		senderThread.start();
	}
}

