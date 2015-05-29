import java.awt.*;
import java.awt.event.*;
import java.sql.*;

 class StudAbout extends Dialog implements WindowListener,ActionListener
{	private Button btok;
	public Label lblcap;
	private Panel p,p2;
	
	public StudAbout(Frame f)
	{	
		super(f,"About",true);
		btok=new Button("OK");
		p=new Panel();
		p2=new Panel();
		lblcap=new Label("Councellor Session Management");
		p.add(lblcap);
		p2.add(btok);
		add("Center",p);
		add("South",p2);

		addWindowListener(this);
		btok.addActionListener(this);		
		setTitle("About");
		setSize(250,100);
		Rectangle r = f.getBounds();		
		setBounds((int)(r.getX()+r.getWidth()/2-125),(int)(r.getY()+r.getHeight()/2-50),250,100);
		setBackground(new Color(220,200,220));		
	}
	
	public void windowOpened(WindowEvent e)		{}	
	public void windowClosing(WindowEvent e)	{		dispose();}
	public void windowClosed(WindowEvent e)		{}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btok)
		{	
			dispose();
		}
	}
}		

class StudMessageBox extends Dialog implements WindowListener,ActionListener
{	
	private Button btok;
	public Label lblcap;
	private Panel p,p2;
	
	public StudMessageBox(Frame f)
	{	
		super(f,"Message",true);
		btok=new Button("OK");
		p=new Panel();
		p2=new Panel();
		lblcap=new Label("");
		p.add(lblcap);
		p2.add(btok);
		add("Center",p);
		add("South",p2);

		addWindowListener(this);
		btok.addActionListener(this);		
		setTitle("About");
		Rectangle r = f.getBounds();		
		setBounds((int)(r.getX()+r.getWidth()/2-125),(int)(r.getY()+r.getHeight()/2-50),250,100);
		setBackground(Color.gray);
	}
	public static void Show(String msg,String title,Frame parent)
	{
			StudMessageBox msgbox = new StudMessageBox(parent);
			msgbox.lblcap.setText(msg);
			msgbox.setTitle(title);
			msgbox.show();				
	}	
	public void windowOpened(WindowEvent e)		{}	
	public void windowClosing(WindowEvent e)	{		dispose();}
	public void windowClosed(WindowEvent e)		{}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void actionPerformed(ActionEvent e)	{		if(e.getSource()==btok) dispose(); }
}	

class StudReport extends Frame implements WindowListener
{
	private boolean flag=true;
	
	List lstrpt;

	public StudReport()
	{	setLayout(null);
		
		lstrpt=new List();
		add(lstrpt);
		lstrpt.setBounds(10,40,400,300);
		addWindowListener(this);
		try
			{
				setTitle("Report");
				setSize(420,350);	
				ResultSet rsTemp = StudConnection.executeQuery("Select * from tblStud");
				String st="";
				while(rsTemp.next())
				{
					st = rsTemp.getString("StudID")+"       "+
					rsTemp.getString("Name")+"     "+rsTemp.getByte("Age")+
					"     "+rsTemp.getString("Class")+"     "+
					rsTemp.getString("Cgroup");					
					lstrpt.add(st);					
				}				
			}
			catch(Exception e)
			{
			}	
	}
	
	public void itemStateChanged(ItemEvent e)	{}
	public void windowOpened(WindowEvent e)		{}	
	public void windowClosing(WindowEvent e)	{		dispose();}
	public void windowClosed(WindowEvent e)		{}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
}

class StudConnection
{	
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","deepak","oraclep");	
		}
		catch(java.lang.Exception e)
		{
			System.out.println(e);
		}
		return con;
	}	
	
	public static ResultSet executeQuery(String stSQL) throws Exception
	{
		Connection cn = getConnection();
		Statement  st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = st.executeQuery(stSQL);
		return rs;		
	}
	
	public static int executeUpdate(String stSQL) throws Exception
	{
		Connection cn = getConnection();
		Statement  st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		int  n = st.executeUpdate(stSQL);
		return n;		
	}
}


public  class Stud extends Frame implements WindowListener,ActionListener
{
	TextField txtid,txtname,txtage;

	String lbls[]   	 = { "ID","Name","Age","Class","Group"};	
	Button btMove[] 	 = { new Button("<<"),new Button("<"),
											 	 new Button(">"),new Button(">>")
											 };
	Button btActions[] = { new Button("New"),new Button("Edit"),new Button("Delete"), 
												 new Button("Update"), new Button("Cancel"),
												 new Button("Report")
											 };

	String stcurId;	
	MenuBar mbar;

	Choice chclass;
	Choice chgroup;

	boolean flag;

	public Connection conn;
	public Statement stmt,s1;
	public ResultSet rs,r1;
	
	public Stud()
	{	setLayout(null);
		flag=false;
	
		for(int i=0;i<lbls.length;i++)
		{
				Label lbl=new Label(lbls[i]);
				lbl.setBounds(20,60+i*30,100,20);
				add(lbl);		
		}
		
		for(int i=0;i<btMove.length;i++)
		{
				btMove[i].setBounds(20+i*50,220,50,20);
				add(btMove[i]);
				btMove[i].addActionListener(this);
		}
		
		for(int i=0;i<btActions.length;i++)
		{
				btActions[i].setBounds(270,60+i*25,60,20);
				add(btActions[i]);
				btActions[i].addActionListener(this);	
		}
		add(txtid=new TextField(10));
		add(txtname=new TextField(20));
		add(txtage=new TextField(3));
		add(chclass=new Choice());
		add(chgroup=new Choice());

		txtid.setBounds(130,60,60,20);
		txtname.setBounds(130,90,120,20);
		txtage.setBounds(130,120,60,20);
		chclass.addItem("");		
		chclass.addItem("X");
		chclass.addItem("XI");
		chclass.addItem("XII");
		chclass.setBounds(130,150,60,20);
		chgroup.addItem("");
		chgroup.setBounds(130,180,60,20);
		

		mbar=new MenuBar();
		Menu help=new Menu("Help");
		help.add("About...");
		mbar.add(help).addActionListener(this);
		setMenuBar(mbar);

		addWindowListener(this);
		help.addActionListener(this);
		setSize(360,250);
		loadCG();
		connect();
		EnableFields(false);
		setBackground(Color.lightGray);
	}

	private void EnableFields(boolean b)
	{
		txtid.setEnabled(b);
		txtname.setEnabled(b);
		txtage.setEnabled(b);
		chclass.setEnabled(b);
		chgroup.setEnabled(b);
		btMove[0].setEnabled(!b);
		btMove[1].setEnabled(!b);
		btMove[2].setEnabled(!b);
		btMove[3].setEnabled(!b);

		btActions[0].setEnabled(!b);
		btActions[1].setEnabled(!b);
		btActions[2].setEnabled(!b);
		btActions[3].setEnabled(b);
		btActions[4].setEnabled(b);
		btActions[5].setEnabled(!b);

	}
	public void windowOpened(WindowEvent e)		{}	
	public void windowClosing(WindowEvent e)	{	System.exit(0);}
	public void windowClosed(WindowEvent e)		{}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}

	public void connect()
	{	
		try
		{
			rs=StudConnection.executeQuery("select * from tblStud");
			if(rs.next())		Display(rs);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(java.lang.Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex);
		}
	}
	public void loadCG()
	{
		try
		{
		chgroup.removeAll();
		chgroup.addItem("");
		ResultSet rs1=	StudConnection.executeQuery("select * from tblCg");
		while(rs1.next())
			chgroup.addItem(rs1.getString(1));
		rs1.close();
		}
			
		catch(Exception e2) {e2.getMessage();}
		
	}	
	public void actionPerformed(ActionEvent e) 
	{	
	
		String stAction = e.getActionCommand();

		if(stAction.equals("About..."))
		{
				StudAbout a = new StudAbout(this);
				a.show();
		}
		else if(stAction.equals("Report"))
		{
			StudReport r=new StudReport();
			r.show();		
		}
		else if(stAction.equals("New"))
		{
			EnableFields(true);
			stcurId = "";
			txtid.setText("");
			txtname.setText("");
			txtage.setText("");
			chclass.select("");
			chgroup.select("");
			txtid.requestFocus();
			flag=true;
		}
		else if(stAction.equals("Cancel"))
		{
			EnableFields(false);
			try
		{
			Display(rs);
		}
		catch(Exception e1)
		{
			
		}
			flag=false;
		}
		else if(stAction.equals("Update"))
		{
			String sql="";
			if(flag)
				sql="insert into tblStud values('"+txtid.getText()+"','"+
				   txtname.getText()+"',"+txtage.getText()+",'"+
				   chclass.getSelectedItem()+"','"+
				   chgroup.getSelectedItem()+"')";	
			else
				sql="update tblStud set Name='"+txtname.getText()+
				"',Age="+txtage.getText()+
				",Class='"+chclass.getSelectedItem()+
				"',CGroup='"+chgroup.getSelectedItem()+"'  where StudID='"+txtid.getText()+"'";
			try
			{

				ResultSet rsTemp = StudConnection.executeQuery("select * from tblStud Where StudID='" + txtid.getText() + "' and StudId<>'" + stcurId + "'");
				
				if(rsTemp.next())
				{
					StudMessageBox.Show("Duplicate Id. Try another","Invalid Id",this);
				}
				else
				{
					StudConnection.executeUpdate(sql);
					
				}
			}
			catch(Exception e1) 
			{
				System.out.println(e1);
			}
			
			finally
			{
				try
			{
					EnableFields(false);
					rs=StudConnection.executeQuery("select * from tblStud");
					if(rs.next())		Display(rs);
				}
				catch(Exception e2) 
			{
				System.out.println(e2);
			}

			}
		}
		else if(stAction.equals("Delete"))
		{
			String sql;
			sql="delete from tblStud where StudID ='"+txtid.getText()+"'";	
			try
			{
				stmt.executeUpdate(sql);
			}
			catch(SQLException e1) {}
		}
		else if(stAction.equals("Edit"))
		{
			flag=false;
			EnableFields(true);
		}
		else
		{
			try
			{	
				if(e.getSource()==btMove[0])
				{
					if(rs.first())
					{
						Display(rs);
					}	
				}
				else if(e.getSource()==btMove[3])
				{
					if(rs.last())
					{
						Display(rs);
					}	
				}
				else if(e.getSource()==btMove[2])
				{
					if(rs.isLast())
					{	
						rs.afterLast();
						StudMessageBox.Show("Last Record","Error",this);
					}
					if(rs.next())
					{
						Display(rs);
					}	
				}
				else if(e.getSource()==btMove[1])
				{	
					if(rs.isFirst())
					{	rs.beforeFirst();
					StudMessageBox.Show("First Record","Error",this);
				}
					if(rs.previous())
					{	
					 	Display(rs);
					}		
				}
			}
			catch(SQLException e1) 
			{
			}
		}
	}
	
	private void Display(ResultSet rs) throws SQLException
	{
		stcurId = rs.getString(1);
		txtname.setText(rs.getString(2));
		txtid.setText(stcurId);
		txtage.setText(String.valueOf(rs.getByte(3)));
		chclass.select(rs.getString(4));
		chgroup.select(rs.getString(5));
		txtid.requestFocus();

	}
	public String loadName(String n)
	{
		String name="";
		try
		{
		ResultSet rs1=	StudConnection.executeQuery("select Name from tblStud where StudID='"+n+"'");
		if(rs1.next())
			name=rs1.getString("Name");
		else
			name="no such id";
		}
		catch(Exception e2) {}
		return(name);
	}
	
	public static void main(String s1[])
	{	
		Stud s=new Stud();			
		s.setTitle("Student Details");
		s.show();
	}	
}