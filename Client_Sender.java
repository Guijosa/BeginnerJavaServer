import java.io.*;
import java.net.*;

public class Client_Sender {
	DataOutputStream dout;
	String s1;

	public Client_Sender(Socket x) {
		try{
		dout = new DataOutputStream(x.getOutputStream()); 
		send();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

	public void send() throws IOException {
		 do{
			 BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			 s1 = br.readLine();
			 dout.writeUTF(s1);
			 dout.flush();
		 }
		 while(!s1.equals("help"));
	}
}