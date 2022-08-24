package ServerPackage;

import java.io.BufferedInputStream;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private Socket client; 
	private static int PORT = 8080;
	public Server(Socket c) {
		client = c; 
		
		System.out.println("Connection Established");
	}
	
	
	public int start() {
		DataInputStream in; 
		try {
			in = new  DataInputStream(new BufferedInputStream(client.getInputStream()));
			
			String line = "";
			
			while(!line.equals("stop")) {
				line = in.readUTF();
				System.out.println(line);
				
			}
			
			
			System.out.println("server closes Connection ");
			in.close();
			client.close();
			
			return 0; 
			
		
		}catch(IOException e ) {
			e.printStackTrace();
			
			return -1; 
			
		}
		
		
		
		
		
		
		
		
		
	
	}
	
	
	public static void main(String[] args) {
		ServerSocket server;
		try {
			server = new ServerSocket(PORT);
			System.out.println("Server Listens on Port" + PORT); 
			Server newClient = new Server(server.accept());
			newClient.start();
			
			
			server.close();
			
		}catch(IOException e ) {
			e.printStackTrace();
			
		}
	
	

		
			
		}
	}
