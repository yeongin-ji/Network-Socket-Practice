import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient1 {
	
	public TCPClient1(String userInput, ClientGUI gui) {
		String sentence;
		String encodedSentence;
		String serverSentence;
		String serverIP;
		int nPort;
		Socket clientSocket = null;
		
		try {
			//read server IP and port number from config file
			File file = new File("src/server_info.dat");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			serverIP = br.readLine();
			nPort = Integer.parseInt(br.readLine());
			
			//try socket connection to server
			clientSocket = new Socket(serverIP, nPort);
			
			//get input, output stream
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
			
			//User input phase
			sentence = userInput;
			
			//encoding user input (arithmetic expression)
			requestEncoder enc = new requestEncoder(sentence);
			enc.encode(serverIP, nPort);
			encodedSentence = enc.getEncodedRequest();
			
			//print request log
			gui.appendLogger("[Request]");
			gui.appendLogger(encodedSentence);
			gui.appendLogger("----------------------------------");
			
			//send request to server
			outToServer.writeUTF(encodedSentence + "\n");
			outToServer.flush();
			
			//read server response
			serverSentence = inFromServer.readUTF();
			
			//print response log
			gui.appendLogger("[Response]");
			gui.appendLogger(serverSentence);
			gui.appendLogger("----------------------------------");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			try {
				//close socket
				clientSocket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
	}
	
}
