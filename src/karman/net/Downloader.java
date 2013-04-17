package karman.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;

public class Downloader {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		// give constructor location and port
		Socket socket = new Socket("www.amazon.com", 80);
		OutputStream out = socket.getOutputStream();
		out.write("GET /index.html\n\n".getBytes());
		out.flush();// sends out the bytes that we wrote

		InputStream in = socket.getInputStream();
		String s = IOUtils.toString(in);
		System.out.println(s);
		// byte array to store data
		/*
		 * byte[] dataAsBytes= new byte[10000]; int
		 * numBytesRead=in.read(dataAsBytes);
		 * System.out.println(Arrays.toString(dataAsBytes));
		 * System.out.println("Num Bytes Read: " + numBytesRead);
		 */

		/*
		 * good way byte aByte=0; while(aByte!=-1){ aByte=(byte) in.read();
		 * System.out.print((char)aByte);
		 * 
		 * }
		 */

		/*
		 * byte array[] = new byte[8192]; int numRead = in.read(array, 0,
		 * array.length); while (numRead != -1) { numRead = in.read(array, 0,
		 * array.length); System.out.println(new String(array, 0, numRead));
		 * socket.close();}
		 */

		// can also do scanner but also wrong

	}
}
