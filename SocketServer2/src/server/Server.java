package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class Server {
	//Attribute
	ServerSocket server;
	ArrayList<PrintWriter> list; //Client Writer
	
	//Nachrichtenstatus
	final int ERROR = 1;
	final int NORMAL = 0;
	

	public static void main(String[] args) {
		Server s = new Server();
		
		if(s.runServer()) {
			s.listenToClient();
		}else {
			//nichts
		}
	}
	
	public class ThreadHandler implements Runnable {
		
		Socket client;
		BufferedReader reader;
		
		public ThreadHandler(Socket client) {
			try {
				this.client = client;
				
				//Nachrichten der Clients im Reader speichern
				reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			String message;
			
			try {
				//Nachrichten der Clients aus Reader auslesen und an alle anderen Clients senden
				while((message = reader.readLine()) != null) {
					consoleText(message, NORMAL);
					sendToAllClients(message);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void listenToClient() {
		//Soll dauerhauft "lauschen"
		while(true) {
			try {
				Socket client = server.accept(); //Client-Socket bei Verbindung speichern
				
				//OutputStreams aller Clients als PrintWriter in ArrayList speichern
				PrintWriter writer = new PrintWriter(client.getOutputStream()); 
				list.add(writer);
				
				//Neuen Thread für Client öffnen
				Thread clientThread = new Thread(new ThreadHandler(client));
				clientThread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public boolean runServer() {
		try {
			server = new ServerSocket(5555);
			consoleText("Server gestartet", ERROR);
			
			list = new ArrayList<PrintWriter>();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			consoleText("Server konnte nicht gestartet werden", ERROR);
			return false;
		}
		
	}
	
	//Methode um Nachrichten an alle Clients zu übermitteln
	public void sendToAllClients(String message) {
		Iterator i = list.iterator();
		
		while(i.hasNext()) {
			PrintWriter writer = (PrintWriter) i.next();
			writer.println(message);
			writer.flush();
		}
	}
	
	public void consoleText(String message, int type) {
		if(type == ERROR) {
			System.err.println(message + "\n");
		}else {
			System.out.println(message + "\n");
		}
	}
	
	
}
