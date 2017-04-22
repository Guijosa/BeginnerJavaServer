import java.net.*;

public class MyServer2 {
	ServerSocket ss;
	Socket s;
	public static int clientNum = 0;
	
	public MyServer2(){
		try{
			ss = new ServerSocket(10);
			while(true){
				s = ss.accept();
				if(s != null){
					clientNum++;
				}
				new ClientHandler(s).start();
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	public static void main(String[] args){
		new MyServer2();
	}
}
