package com.furkan;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
class MessageReceiver implements Runnable {
    // DatagramSocket for receiving packets
	DatagramSocket socket;
	// byte array for storing the received message
	byte buffer[];
	// ClientWindow object for displaying the message
	ClientW window;
	// nickname of the user
	String nickname;

    // constructor for initializing the socket, buffer, window, and nickname
	MessageReceiver(DatagramSocket sock, ClientW wind,String nick) {
		socket = sock;
		buffer = new byte[155];
		window = wind;
		nickname=nick;
	}

	public void run() {
        // continuously receive packets
		while (true) {
			try {
                // create a new DatagramPacket with the buffer and its length
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                // receive the packet
				socket.receive(packet);
                // extract the message from the packet, trim it and remove the first element
				String received = new String(packet.getData(), 1, packet.getLength() - 1).trim();
                // display the message on the window
				window.displayMessage(nickname+": "+received);
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}
}


