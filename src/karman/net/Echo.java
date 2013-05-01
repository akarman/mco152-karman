package karman.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Echo {
	
	public static void main(String[] args) throws UnknownHostException, IOException{
		Socket socket= new Socket("localhost", 8080);
		InputStream in = socket.getInputStream();
		Scanner inputStreamReader = new Scanner(in);
		System.out.println(inputStreamReader.nextLine());
		socket.close(); //close all resources
	}

}
