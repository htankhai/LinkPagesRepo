import java.net.*;
import java.util.*;
import java.io.*;
class MyServer	{

	ServerSocket ss;
	Socket s;
	ArrayList al = new ArrayList();
	
	MyServer() throws Exception	{
	
		
		ss = new ServerSocket(10);
		while(true)
		{
			s = ss.accept();
			System.out.println(":::::::::::::Client Connected::::::::::");
			al.add(s);
			Runnable t = new MyThread(al,s);
			Thread t1 = new Thread(t);
			t1.start();		
		}
	
	}
	public static void main(String arg[]) throws Exception
	{
		new MyServer();
	}
}

class MyThread implements Runnable
{
	DataInputStream din;
	DataOutputStream dout;
	ArrayList al;
	Socket s;
	String s1;
	public void run()
	{	
		try {
		din = new DataInputStream(s.getInputStream());
		
		do	{
			
			s1=din.readUTF();
			System.out.println(s1);
			if(!s1.equals("stop"))
			tellEveryOne(s1);
		else	{
				dout = new DataOutputStream(s.getOutputStream());
				dout.writeUTF("stop");
				dout.flush();
				al.remove(s);
			}
		}while(!s1.equals("stop"));
		
		}
		catch(Exception e) {	System.out.println(e); }
	}	
	public void tellEveryOne(String str) throws Exception
	{
		Socket s;
		Iterator i = al.iterator();
		while(i.hasNext())
		{
			s =(Socket) i.next();	
		dout = new DataOutputStream(s.getOutputStream());

			dout.writeUTF(str);	
		}
	}
	MyThread(ArrayList al , Socket s)
	{
				this.s = s;
		this.al = al;
					
	}
}