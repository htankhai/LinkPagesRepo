import java.net.*;
import java.io.*;
public class MyClient
{
	Socket s;
	DataInputStream din;
	DataOutputStream dout;
	public MyClient()
	{
		try	{

		s = new Socket("localhost",10);
		din = new DataInputStream(s.getInputStream());
		dout = new DataOutputStream(s.getOutputStream());
		clientChat();
		}
		catch(Exception e)	{
			System.out.println(e);
		}		
		
	}
	
	public void clientChat()	
	{
		My t = new My(din);
		Thread t1 = new Thread(t);
		t1.start();
		String s1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try	{
			do{
			s1 = br.readLine();
			dout.writeUTF(s1);
			dout.flush();
			}while(!s1.equals("stop"));

		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String []ar)
	{
		new MyClient();		
	}
}
class My implements Runnable
{	
	DataInputStream din;
	My(DataInputStream din)
	{	
		this.din=din;		
	}
	public void run()
	{
		String s1="";
		do
		{
		try	{
		s1=din.readUTF();
		System.out.println(s1);	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}while(!s1.equals("stop"));
	}
}