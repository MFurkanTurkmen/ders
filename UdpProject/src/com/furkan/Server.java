package com.furkan;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server implements  Runnable {
    // port number for the server
	public final static int PORT = 5000;
    // buffer size for incoming messages
	private final static int BUFFER = 155;

    // socket for the server
	private DatagramSocket socket;
    // list of client addresses
	private ArrayList<InetAddress> client_addresses;
    // list of client ports
	private ArrayList<Integer> client_ports;
    // set of existing clients
	private HashSet<String> existing_clients;

    /**
     * Initializes the server and sets up the socket, 
     * and creates the lists and set for storing client information.
     */
	public Server() throws IOException {
		socket = new DatagramSocket(PORT);
		System.out.println("Server is running and is listening on port " + PORT);
		client_addresses = new ArrayList();
		client_ports = new ArrayList();
		existing_clients = new HashSet();
	}

    /**
     * Runs the server and listens for incoming messages.
     * When a message is received, it is sent to all other clients.
     */
	public void run() {
		byte[] buffer = new byte[BUFFER];
		while (true) {
			try {
				Arrays.fill(buffer, (byte) 0);
                // receive a packet
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
                // extract the message and the sender's address and port
				String message = new String(buffer, 0, buffer.length);
				InetAddress clientAddress = packet.getAddress();
				int client_port = packet.getPort();
		
                // create an ID for the sender
				String id = clientAddress.toString() + "|" + client_port;
				
				if (!existing_clients.contains(id)) {
                    // if the sender is a new client, add their address and port to the lists
					existing_clients.add(id);
					client_ports.add(client_port);
					client_addresses.add(clientAddress);
				}
				
                // send the message to all other clients
				byte[] data = (" "+message).getBytes();
				for (int i = 0; i < client_addresses.size(); i++) {
					InetAddress cl_address = client_addresses.get(i);
					int cl_port = client_ports.get(i);
					if(cl_port != client_port) {
						packet = new DatagramPacket(data, data.length, cl_address, cl_port);
						socket.send(packet);
					}
				}
			} catch (Exception e) {
                // print any errors that occur
				System.err.println(e);
			}
		}
	}

    /**
     * Main method that creates a new instance of the ChatServer and starts it.
     */
	public static void main(String args[]) throws Exception {
		Server server_thread = new Server();
		server_thread.run();
	}
} 

				

