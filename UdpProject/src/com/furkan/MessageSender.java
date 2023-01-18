package com.furkan;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalTime;
class MessageSender implements Runnable {
    // port number for sending packets
	public final static int PORT = 5000;
    // DatagramSocket for sending packets
	private DatagramSocket socket;
	// hostname of the server
	private String hostName;
	// ClientWindow object for displaying messages
	private ClientW window;
    // nickname of the user
	private String nickname;

    // constructor for initializing the socket, hostname, window and nickname
	public MessageSender(DatagramSocket sock, String host, ClientW win,String nick) {
		socket = sock;
		hostName = host;
		window = win;
		nickname=nick;
	}

    // function for sending a message
	private void sendMessage(String s) throws Exception {
		
		byte buffer[] = (s).getBytes();
        // get the InetAddress of the hostname
		InetAddress address = InetAddress.getByName(hostName);
        // create a new DatagramPacket with the buffer, length, address and port
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, PORT);
		socket.send(packet);
	}

	public void run() {
		boolean connected = false;
        // continuously try to connect
		do {
			try {
                // send a message that the user has connected
				sendMessage(nickname+" connected - welcome!");
				connected = true;
			} catch (Exception e) {
				window.displayMessage(e.getMessage());
			}
		} while (!connected);
		while (true) {
			try {
                // wait until the message is ready to be sent
				while (!window.message_is_ready) {
					Thread.sleep(100);
				}
                // get the current time
				LocalTime now = LocalTime.now();
				String time = now.getHour()+":"+now.getMinute()+":"+now.getSecond();
                // format the message with the time, nickname, and the message
				String messg = time+" || "+nickname+" : "+window.getMessage();
                // send the message
				sendMessage(messg);
                // reset the message_is_ready flag
				window.setMessageReady(false);
			} catch (Exception e) {
                // display any errors on the window
				window.displayMessage(e.getMessage());
			}
		}
	}
}

