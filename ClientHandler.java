import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {
	Socket s;
	DataInputStream din;
	DataOutputStream dout;
	String str, s1;
	int idnum;
	
	public ClientHandler(Socket s) throws IOException 
	{ 
		idnum = MyServer2.clientNum;
		System.out.println("Server connection with client " + idnum);
		this.s = s;
		System.out.println(s);
        System.out.println("CLIENT CONNECTED");               
	}
	
	public void chat()
	{
		try{
			 do
		        {
		        	din = new DataInputStream(s.getInputStream());
		        	dout = new DataOutputStream(s.getOutputStream());
		            str=din.readUTF();
		            System.out.println("Client " +idnum+" Message:"+str);
		            BufferedReader br=new BufferedReader(new   InputStreamReader(System.in));
		            s1=br.readLine();
		            dout.writeUTF(s1);
		            dout.flush();
		        }
		        while(!s1.equals("bye"));
		}
		catch(Exception e){
			System.out.println(e);
		}       
	}
	
	public void run(){
		chat();
	}
}
