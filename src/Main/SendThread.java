package Main;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 
 * @author Young
 *
 */
public class SendThread {
	ChatWindow chatWindow;
	private String remoteIP = "";
	private int port = 0;
	private String message = "";
	
	public SendThread(int port,ChatWindow window){ 
		chatWindow = window;
	}
	
	public void notRun() {
		// TODO Auto-generated method stub
		InetSocketAddress isa = new InetSocketAddress(remoteIP,port);
		
		try {
			Socket socket = new Socket();
			socket.connect(isa);
			OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
			writer.write(message);
			writer.flush();
			writer.close();
			System.out.println("������д�뵽����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
			message = "";
		}
	}
    public void sendMessage(String host,int port,String message) {
		// TODO Auto-generated method stub
    	remoteIP = host;
    	this.port = port;
    	this.message = message;
    	notRun();
	}
}
