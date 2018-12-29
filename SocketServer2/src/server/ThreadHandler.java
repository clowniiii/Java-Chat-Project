package server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadHandler implements Runnable {

	private Socket client;
	
	public ThreadHandler(Socket client){
		this.client = client;
	}
	
	@Override
	public void run() {
		try {
			//Streams
			
			//an den Client
			OutputStream out = client.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			
			//an den Server
			InputStream in = client.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			//Nachricht vom Client ausgeben
			String s = null;
			
			while((s = reader.readLine())!=null) {
				writer.write(s+"\n");
				writer.flush();
				System.out.println("Vom Client empfangen: "+s);
			}
			
			writer.close();
			reader.close();
			
			client.close();
			
		}catch (Exception e) {
			
		}
	}

}
