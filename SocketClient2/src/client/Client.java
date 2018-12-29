package client;


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
		screen = new GUI(c);
		
		//GUI initialisieren 
		screen.getFrame().setVisible(true);
		
		Thread t_message = new Thread(new ServerListener());
		t_message.start();
	}
	
	//Konstruktor
	public Client() {
		super();
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
	
	public boolean connectToServer() {
		try {
			client = new Socket("127.0.0.1", 5555);
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
