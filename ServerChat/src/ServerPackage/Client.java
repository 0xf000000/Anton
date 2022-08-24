package ServerPackage;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	
	Socket server; 
	//Reads input from the Console
	
	
public Client(String Adress, int port) {
	try {
		server = new Socket(Adress,port);
	}catch(IOException e ) {
		e.printStackTrace();
	}
		
	}
	
	public int start() {
		BufferedReader in;
		DataOutputStream out; 
		try {
			server = new Socket("127.0.0.1",8080);
			System.out.println("Connection established with: " + server.getInetAddress());
			in = new BufferedReader( new InputStreamReader(System.in));
			out = new DataOutputStream(server.getOutputStream());
			
			
			String line= ""; 
			while(!line.equals("Stop")) {
				line = in.readLine();
				out.writeUTF(line);
			}
			
			
			in.close();
			out.close();
			server.close();
			return 0; 
			
		}catch(IOException e ) {
			e.printStackTrace();
			return -1; 
		}
		
	}
	
	
	
	public static void main(String[] args ) {
		// without this to parameters the function wont work 
		Client client = new Client(args[0], Integer.parseInt(args[1]));
				
		client.start();
		
	}
	

}
