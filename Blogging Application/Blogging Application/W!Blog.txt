import java.io.*;
    import java.lang.*;
public class WBlog
{
    public static void main(String args[])throws IOException
    {
    BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter function( Post, Reply, Check ):  ");
    java.lang.String Q=input.readLine();
    if(Q.equals("post"))
    {
    System.out.println("1. Games  ");
    System.out.println("2. Computers  ");
    System.out.println("3. Internet  ");
    System.out.println("4. Softwares  ");
    System.out.println("5. Programming  ");
    System.out.println("6. Other  ");
    System.out.print("Enter category:  ");
    java.lang.String Group=input.readLine();
    System.out.print("Enter your name:  ");
    java.lang.String Name=input.readLine();
    
    System.out.println("--------------Enter W!Blog question--------------");
    java.lang.String Ques=input.readLine();
    
    
    if(Group.equals("games"))
    {
    FileWriter fout=new FileWriter("Games",true);
    BufferedWriter bout=new BufferedWriter(fout);
    PrintWriter pout=new PrintWriter(bout);
    pout.println(Name+",");
    pout.println(Ques);
    pout.println();
    bout.close();
    pout.close();
    bout.close();
    }
    else
    if(Group.equals("computers"))
    {
    FileWriter fout=new FileWriter("Computers",true);
    BufferedWriter bout=new BufferedWriter(fout);
    PrintWriter pout=new PrintWriter(bout);
    pout.println(Name+",");
    pout.println(Ques);
    pout.println();
    bout.close();
    pout.close();
    bout.close();
    }
    else
    if(Group.equals("internet"))
    {
    FileWriter fout=new FileWriter("Internet",true);
    BufferedWriter bout=new BufferedWriter(fout);
    PrintWriter pout=new PrintWriter(bout);
    pout.println(Name+",");
    pout.println(Ques);
    pout.println();
    bout.close();
    pout.close();
    bout.close();
    }
    else
    if(Group.equals("softwares"))
    {
    FileWriter fout=new FileWriter("Softwares",true);
    BufferedWriter bout=new BufferedWriter(fout);
    PrintWriter pout=new PrintWriter(bout);
    pout.println(Name+",");
    pout.println(Ques);
    pout.println();
    bout.close();
    pout.close();
    bout.close();
    }
    else
    if(Group.equals("programming"))
    {
    FileWriter fout=new FileWriter("Programming",true);
    BufferedWriter bout=new BufferedWriter(fout);
    PrintWriter pout=new PrintWriter(bout);
    pout.println(Name+",");
    pout.println(Ques);
    pout.println();
    bout.close();
    pout.close();
    bout.close();
    }
    else
    if(Group.equals("other"))
    {
    FileWriter fout=new FileWriter("Other",true);
    BufferedWriter bout=new BufferedWriter(fout);
    PrintWriter pout=new PrintWriter(bout);
    pout.println(Name+",");
    pout.println(Ques);
    pout.println();
    bout.close();
    pout.close();
    bout.close();
    }
    else
    {
    System.out.println("Wrong category!");
    }
    FileWriter fut=new FileWriter(Name);
    BufferedWriter but=new BufferedWriter(fut);
    PrintWriter put=new PrintWriter(but);
    put.println(Ques);
    System.out.println("W!Blog was posted!");
    
    but.close();
    put.close();
    but.close();
    }
    else
    if(Q.equals("reply"))
    {
    

    System.out.println("1. Games  ");
    System.out.println("2. Computers  ");
    System.out.println("3. Internet  ");
    System.out.println("4. Softwares  ");
    System.out.println("5. Programming  ");
    System.out.println("6. Other  ");
    System.out.print("Enter category:  ");
    java.lang.String Group=input.readLine();
    FileReader fout=new FileReader(Group);
    BufferedReader bout=new BufferedReader(fout);
    System.out.println("");
    java.lang.String Questions;
    while((Questions=bout.readLine())!=null)
    {
    System.out.println(Questions);
    }
    System.out.println("");
    System.out.print("Enter name to reply:  ");
    java.lang.String Name=input.readLine();
    System.out.println("---------Post Reply----------  ");
    java.lang.String Ans=input.readLine();
    System.out.print("Enter your name:  ");
    java.lang.String Name2=input.readLine();
    
    FileWriter fot=new FileWriter(Name,true);
    BufferedWriter bot=new BufferedWriter(fot);
    PrintWriter pot=new PrintWriter(bot);
    pot.println("");
    
    pot.println("From "+Name2+",");
    pot.println(Ans);
    bout.close();
    bot.close();
    pot.close();
    bot.close();
    }
    else
    if(Q.equals("check"))
    {
    

    System.out.print("Enter your name:  ");
    java.lang.String Name=input.readLine();
    FileReader fout=new FileReader(Name);
    BufferedReader bout=new BufferedReader(fout);
    System.out.println("");
    java.lang.String Questions;
    while((Questions=bout.readLine())!=null)
    {
    System.out.println(Questions);
    }
    System.out.println("");
    System.out.println("Thank you for using W!Blog!!");
    bout.close();
    
    }
    else
    System.out.println("Wrong choice!");
    }
    }