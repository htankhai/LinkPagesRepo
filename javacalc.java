import java.awt.*;

import javax.swing.*;

class Calculator 
{
	JFrame frame;
	JButton jb[];	
	JTextField input;
	JPanel gridButton;
	Calculator(String st)	
	{
		frame = new JFrame(st);
		input = new JTextField();
		gridButton = new JPanel();
		String s[] = {"MC","MR","MS","M+","M-","<-","CE","C","+/-","sqrt","7","8","9","/","%","4","5","6","*","1/x","1","2","3","-","0",".","+","="};
		jb = new JButton[s.length];
		for(int i=0 ; i<s.length ; i++)
		{
			jb[i] = new JButton(s[i]);
			gridButton.add(jb[i]);
		}
		gridButton.setLayout(new GridLayout(6,5,10,10));
		
		frame.add(input , BorderLayout.NORTH);
		frame.add(gridButton , BorderLayout.CENTER);
		frame.setSize(200,250);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String [] s)
	{
		new Calculator("Calculator");
	}

	

}