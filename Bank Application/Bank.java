//Bank.java

import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.sql.*;
import javax.swing.*;
public class Bank extends JFrame implements ActionListener
{
static JLabel label1,label2,label3,sep;
static JButton sign,create,deposit,withdraw,trans,balance,close,clear;
static JTextField txtA1;
static JTextField txtA2;
static Connection con;
static Statement st1,st2,st3;
static ResultSet rs1;
int numd;
int numf;
int nume;
public Bank()
   {
 	super("MY Bank");
 	setLayout( null);
 	try	{
 		 Class.forName("oracle.jdbc.driver.OracleDriver");
 	 	 con = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:XE","deepak","oraclep");
 	 	 st1=con.createStatement();
		 rs1=st1.executeQuery("select * from tab1");
		}
	catch(Exception e)
		{
		 System.out.println("there was some error in establishing connection : "+e);
		}
	


       sep = new JLabel("Existing User Signin  :  ");
	add(sep);
	sep.setBounds(40,40,150,25); 


        label1 = new JLabel(" Account Number : ");
	add(label1);
        label1.setBounds(40,80,300,55); 
       

         txtA1 = new JTextField(15);
       	add(txtA1);
	txtA1.setBounds(40,120,150,25); 

        label2 = new JLabel("Name : ");
       	add(label2);
	label2.setBounds(40,160,300,55); 

        txtA2 = new JTextField(15);
 	add(txtA2);
        txtA2.setBounds(40,200,150,25); 	

        sign=new JButton("SIGN IN");
  	add(sign);
        sign.setBounds(40,260,150,25); 	


        sep = new JLabel("New User Signup: ");
	add(sep);
        sep.setBounds(250,100,300,55);         

        create=new JButton("CREATE ACCOUNT");
 	add(create);
        create.setBounds(250,150,160,25); 	
        
       

        deposit=new JButton("DEPOSIT");
	add(deposit);
        deposit.setBounds(80,340,100,25); 	

        withdraw=new JButton("WITHDRAW");
	add(withdraw);
        withdraw.setBounds(280,340,100,25); 	

        trans=new JButton("TRANSACTION");
	add(trans);
        trans.setBounds(80,310,100,25);     
        

        balance=new JButton("BALANCE");
	add(balance);
	balance.setBounds(280,310,100,25); 
        
        clear=new JButton("CLEAR");
	add(clear);
        clear.setBounds(160,400,150,25); 	
	

        close=new JButton("CLOSE");
	add(close);
        close.setBounds(160,430,150,25); 	

        create.addActionListener(this);
	deposit.addActionListener(this);
	withdraw.addActionListener(this);
	trans.addActionListener(this);
	balance.addActionListener(this);
	clear.addActionListener(this);
	close.addActionListener(this);
        sign.addActionListener(this);
        deposit.setEnabled(false);
	withdraw.setEnabled(false);
	trans.setEnabled(false);
	balance.setEnabled(false);

  }
 public void actionPerformed(ActionEvent e)
	 {
if(e.getSource()==create)
	{
	 String stra = JOptionPane.showInputDialog(null,"Please enter the NAME to open a CURRENT ACCOUNT");
	 String strb = JOptionPane.showInputDialog(null,"Please enter the ACCOUNT NUMBER");
	 if(stra==null || strb==null)
		{
		JOptionPane.showMessageDialog(null," Either any one or both the values were left blank");
	        deposit.setEnabled(false);
		 withdraw.setEnabled(false);
		trans.setEnabled(false);
		balance.setEnabled(false);
		create.setEnabled(true);
		sign.setEnabled(true);	 
		    }
		else
		 {
	 	 	try
		    {
			st2=con.createStatement();
			String rr="insert into tab1 values('"+stra+"','"+strb+"',0,0,0)";
			st2.executeUpdate(rr);
			st2.close();
			JOptionPane.showMessageDialog(null,"ACCOUNT Created Successfully");	
			txtA1.setText(strb);
			txtA2.setText(stra);
		   }
		catch(Exception e2)
			 {
	JOptionPane.showMessageDialog(null," There was some problem while createing your account, plz try again ");
			 }
		   	deposit.setEnabled(true);
			withdraw.setEnabled(true);
			trans.setEnabled(true);
			balance.setEnabled(true);
			create.setEnabled(true);
		    sign.setEnabled(true);	
		}
	 }
else if(e.getSource()==sign)
	 	 {
	 	  	 	String num=txtA1.getText();
	 	 	try
				{
					st1.close();				
					st1=con.createStatement();
					rs1=st1.executeQuery("Select * from tab1 where AccNum Like '"+num+"'");
					rs1.next();
					txtA1.setText(rs1.getString("AccNum"));
					txtA2.setText(rs1.getString("UserName"));
				}
			catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null,"Invalid Account Number");
				}				
			deposit.setEnabled(true);
			withdraw.setEnabled(true);
			trans.setEnabled(true);
			balance.setEnabled(true);
			create.setEnabled(false);
	 	 }
else if(e.getSource()==deposit)
	      	 {
	      	 	String strc = JOptionPane.showInputDialog(null,"Please enter the amount to be DEPOSITED");
	 	 	    numd=Integer.parseInt(strc);
	 	 	    int numb=Integer.parseInt(txtA1.getText());	
	 	 	    	if (numd<=0)
	 	 	    	{
	 	 	    		JOptionPane.showMessageDialog(null," NO Amount Deposited");
	 	 	    	}
	 	 	    	else
	 	 	    	{
   	 	 	try
				{
			    int num,num1;
			    st3=con.createStatement();
		    	rs1=st3.executeQuery("select * from tab1 where Accnum like '"+txtA1.getText()+"'");
		    	rs1.next();
		    	num1=Integer.parseInt(rs1.getString("Deposit"));
		    	num=Integer.parseInt(rs1.getString("Balance"));
		    	JOptionPane.showMessageDialog(null,"Amount Deposited Successfully , Amount is "+numd);
		    	numf=num+numd;
		    	num1=num1+numd;
				st2=con.createStatement();
				String ss="update tab1 set Deposit="+num1+" where AccNum="+numb+"";
			    String aa="update tab1 set Balance="+numf+" where AccNum="+numb+"";
				st2.executeUpdate(ss);
				st2.executeUpdate(aa);
				st2.close();
				st3.close();
				}
			catch(Exception e2)
				{
			JOptionPane.showMessageDialog(null,"Amount can not be DEPOSITED");
				}
	 	     }
	      	 }
else if(e.getSource()==withdraw)
	   {
	        String strd = JOptionPane.showInputDialog(null,"Please enter the amount to be WITHDRAWN");
	        nume=Integer.parseInt(strd);
	        int numc=Integer.parseInt(txtA1.getText());
	        if(numf<=nume)
			{
			   JOptionPane.showMessageDialog(null,"Sorry can not Withdraw, no sufficient Balance");
			}
			else
			{
	 	 	try
		    {
		    	int num1;
			    st3=con.createStatement();
		    	rs1=st3.executeQuery("select * from tab1 where Accnum like '"+txtA1.getText()+"'");
		    	rs1.next();
		    	num1=Integer.parseInt(rs1.getString("Withdraw"));
		    	numf=Integer.parseInt(rs1.getString("Balance"));
		    	JOptionPane.showMessageDialog(null,"Amount Withdrawn is "+nume);
		    	numf=numf-nume;
		    	num1=num1+nume;
		    	st2=con.createStatement();
			    String pp="update tab1 set Withdraw="+num1+" where AccNum="+numc+"";
			    String pp1="update tab1 set Balance="+numf+" where AccNum="+numc+"";
				st2.executeUpdate(pp);
				st2.executeUpdate(pp1);
				st2.close();
		    }
		catch(Exception e2)
			 {
			 	JOptionPane.showMessageDialog(null," Can't WITHDRAW ");
			 }	
		    }
	   }
		
else if(e.getSource()==balance)
	 	 {
             String num=txtA1.getText();	 	 	
	 	 	
	 	 	try
		    {
		       	
				st3=con.createStatement();
		    	rs1=st3.executeQuery("select * from tab1 where Accnum like '"+num+"'");
		    	rs1.next();
		    	numf=Integer.parseInt(rs1.getString("Balance"));
		    	
				JOptionPane.showMessageDialog(null,"Balance is "+numf);	
		    }
		catch(Exception e2)
			 {
			 	 	JOptionPane.showMessageDialog(null," Balance null ");
			 }
	     
	 }
else if(e.getSource()==trans)
	 	 {	
	 	String strq = JOptionPane.showInputDialog(null,"Enter the ACCOUNT NUMBER to view the TRANSACTION DONE");
	 	 int numk=Integer.parseInt(strq);
	    int numa=Integer.parseInt(txtA1.getText());
	 		if(numk==numa)
	 		{
	 		JOptionPane.showMessageDialog(null,"Amount Deposited  is "+numd);
	 		JOptionPane.showMessageDialog(null,"Amount Withdrawn is "+nume);
	 		}
	 	 else
	 	 {
	 	 	JOptionPane.showMessageDialog(null,"The Account Number is not the same as in the TEXTFIELD");
	 	 }
	 	 }
	 	 
else if(e.getSource()==clear)
	 	 {
	 	 	txtA1.setText("");
			txtA2.setText("");
			deposit.setEnabled(false);
			withdraw.setEnabled(false);
			trans.setEnabled(false);
			balance.setEnabled(false);
			create.setEnabled(true);
            sign.setEnabled(true);
	 	 }
else if(e.getSource()==close)
	 	 {
	 	System.exit(0);
	 	 }
	  }
 public static void main(String args[])
   {
   	Bank obj = new Bank();
   	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	obj.setSize(470,510);
   	obj.setVisible(true);  
    }

}