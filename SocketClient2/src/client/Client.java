package client;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	Socket client;
	PrintWriter writer;
	BufferedReader reader;
	
	static GUI screen;
	static Client c;

	public static void main(String[] args) {
		c = new Client();
		screen = new GUI();
		
		//GUI initialisieren 
		screen.getFrame().setVisible(true);
		
		c.createThread();
	}
	
	//Konstruktor
	public Client() {
		super();
	}
	
	public void createThread() {
		
		//Prüfen, ob eine Verbindung zum Server hergestellt werden konnte
		if(!connectToServer()) {
			System.out.println("Keine Verbindung möglich");
		}
		
		Thread t_message = new Thread(new ServerListener());
		t_message.start();
	}
		
	public class ServerListener implements Runnable{

		@Override
		public void run() {
			String message;
			
			//Auf Nachricht überprüfen
			try {
				while((message = reader.readLine())!=null) {
					appendMessage(message);
					screen.getTa().setCaretPosition(screen.getTa().getText().length());
				}
			} catch (IOException e) {
				appendMessage("Nachricht konnte nicht gesendet werden");
				e.printStackTrace();
			}	
		}
	}
	
	//ActionListener für Sende-Button
	public class SendButtonMessage implements ActionListener{
		
		Client c = new Client();
		
		public SendButtonMessage(Client c){
			super();
			this.c = c;
		}
				
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			c.sendMessageToServer();
		}
				
	}
	
	
	//Überprüfen, ob Verbindung aufgebaut wurde oder nicht
	public boolean connectToServer() {
		try {
			client = new Socket("aniira.de", 5555);
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			appendMessage("Netzwerkverbindung hergestellt");
			
			return true;
		} catch (IOException e) {
			appendMessage("Netzwerverbindung konnte nicht hergestellt werden");
			e.printStackTrace();
			return false;
		}
	}
	
	public void appendMessage(String message) {
		screen.getTa().append(message + "\n");
	}
	
	//Nachricht senden
	public void sendMessageToServer() {
		writer.println(screen.getNickField().getText()+": "+screen.getText().getText());
		writer.flush();
		
		screen.getText().setText("");;
		screen.getText().requestFocus();
	}
}
