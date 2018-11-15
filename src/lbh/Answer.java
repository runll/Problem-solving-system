package lbh;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
public class Answer extends JFrame implements ActionListener{
	ImageIcon back=new ImageIcon("back.png");
	ImageIcon mini=new ImageIcon("mini.png");
	ImageIcon close=new ImageIcon("close.png");
	ImageIcon next=new ImageIcon("next.png");
	ImageIcon last=new ImageIcon("last.png");
	JLabel Welcome=new JLabel("学习是生命中最美好的事情!",JLabel.CENTER);
	JLabel ask=new JLabel("学累了?",JLabel.LEFT);
	JButton Back=new JButton(back);
	JButton Mini=new JButton(mini);
	JButton Exit=new JButton(close);
	JButton OptionA=new JButton("A");
	JButton OptionB=new JButton("B");
	JButton OptionC=new JButton("C");
	JButton OptionD=new JButton("D");
	JButton begin=new JButton("开始答题");
	JButton Last=new JButton(last);
	JButton Next=new JButton(next);
	JButton ChangeTextColor=new JButton();
	JButton ChangeBackgroundColor=new JButton();
	JButton OpenWeb=new JButton("点我试试");
    JTextArea write=new JTextArea(30,60);
    JScrollPane sp=new JScrollPane(write);
    String answer = "";
	int order = 0;
	int tag=0;
	ArrayList<Integer> ed = new ArrayList<>();
	
Answer(){
 	setUndecorated(true);
 	setLayout(null);
 	setBounds(0,0,1080,720);
	Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
	setLocation((screen.width-1080)/2,(screen.height-720)/2);
 	JPanel p=new JPanel();
 	this.add(p);
 	p.setBounds(0, 0, 1080, 720);
 	p.setBackground(Color.DARK_GRAY);
 	p.setLayout(null);
 	Welcome.setFont(new Font("隶书",Font.BOLD,50));
 	write.setFont(new Font("隶书",Font.BOLD,35));
 	OptionA.setFont(new Font("Tekton Pro",Font.BOLD,50));
 	OptionB.setFont(new Font("Tekton Pro",Font.BOLD,50));
 	OptionC.setFont(new Font("Tekton Pro",Font.BOLD,50));
 	OptionD.setFont(new Font("Tekton Pro",Font.BOLD,50));
 	begin.setFont(new Font("隶书",Font.BOLD,35));
 	ChangeTextColor.setFont(new Font("隶书",Font.BOLD,35));
 	ChangeBackgroundColor.setFont(new Font("隶书",Font.BOLD,35));
 	OpenWeb.setFont(new Font("隶书",Font.BOLD,35));
 	ask.setFont(new Font("隶书",Font.BOLD,25));
 	
 	Welcome.setForeground(Color.WHITE);
 	Back.setForeground(Color.WHITE);
 	Back.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
 	Back.setBackground(Color.DARK_GRAY);
 	Mini.setForeground(Color.WHITE);
 	Mini.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
 	Mini.setBackground(Color.DARK_GRAY);
 	Exit.setForeground(Color.WHITE);
 	Exit.setBorderPainted(false);
 	Exit.setBackground(Color.DARK_GRAY);
 	write.setLineWrap(true);
 	write.setEditable(false);
 	OptionA.setForeground(Color.WHITE);
 	OptionA.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5, true));
 	OptionA.setBackground(Color.DARK_GRAY);
 	OptionB.setForeground(Color.WHITE);
 	OptionB.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5, true));
 	OptionB.setBackground(Color.DARK_GRAY);
 	OptionC.setForeground(Color.WHITE);
 	OptionC.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5, true));
 	OptionC.setBackground(Color.DARK_GRAY);
 	OptionD.setForeground(Color.WHITE);
 	OptionD.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5, true));
 	OptionD.setBackground(Color.DARK_GRAY);
 	begin.setForeground(Color.WHITE);
 	begin.setBorderPainted(false);
 	begin.setBackground(Color.DARK_GRAY);
 	OpenWeb.setForeground(Color.WHITE);
 	OpenWeb.setBorderPainted(false);
 	OpenWeb.setBackground(Color.DARK_GRAY);
 	ask.setForeground(Color.WHITE);
 	Next.setForeground(Color.WHITE);
 	Next.setBorderPainted(false);
 	Next.setBackground(Color.DARK_GRAY);
 	Last.setForeground(Color.WHITE);
 	Last.setBorderPainted(false);
 	Last.setBackground(Color.DARK_GRAY);
 	
 	p.add(Welcome);
 	p.add(Back);
 	p.add(Mini);
 	p.add(Exit);
 	p.add(sp);
 	p.add(OptionA);
 	p.add(OptionB);
 	p.add(OptionC);
 	p.add(OptionD);
 	p.add(begin);
 	p.add(OpenWeb);
 	p.add(ask);
 	p.add(Next);
 	p.add(Last);
 	
 	
 	Welcome.setBounds(100, 0, 880, 100);
 	Back.setBounds(0, 0, 50, 50);
 	Mini.setBounds(990, 10, 30, 30);
 	Exit.setBounds(1030, 0, 50, 50);
 	sp.setBounds(100, 100, 880, 300);
 	OptionA.setBounds(85, 420, 220, 50);
 	OptionB.setBounds(315, 420, 220, 50);
 	OptionC.setBounds(545, 420, 220, 50);
 	OptionD.setBounds(775, 420, 220, 50);
 	begin.setBounds(415, 490, 225, 50);
 	OpenWeb.setBounds(415, 550, 225, 50);
 	ask.setBounds(310, 558, 100, 40);
	Last.setBounds(0, 210, 75, 75);
 	Next.setBounds(1005, 210, 75, 75);
 	
 	begin.addActionListener(this);
 	OpenWeb.addActionListener(this);
 	Mini.addActionListener(this);
 	Exit.addActionListener(this);
 	Back.addActionListener(this);
 	OptionA.addActionListener(this);
 	OptionB.addActionListener(this);
 	OptionC.addActionListener(this);
 	OptionD.addActionListener(this);
 	Last.addActionListener(this);
 	Next.addActionListener(this);
 	
 	this.setResizable(false);
 	this.setVisible(true);
 }
 
 
 	public int checki(int i,ArrayList<Integer> ed) {
 		if(!ed.isEmpty())
			for(int e : ed) {
				if(e == i)//曾经生成过
					return (int)Math.random()*50;
				else return i;
			}
 		else 
 			ed.add(i);
 		return i;
 		
 	}
 public void actionPerformed(ActionEvent arg){

	 
	 if(arg.getSource()==Mini) {
		 setExtendedState(JFrame.ICONIFIED);
	 }
	 else if(arg.getSource()==Exit) {
		 System.exit(0);
	 }
	 else if(arg.getSource()==Back) {
		 //下一题题目生成
		 tag=0;
		 write.setText("");
		 try {
				Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
				// Class.forName("org.gjt.mm.mysql.Driver");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercises?useSSL=FALSE&"
						+ "serverTimezone=UTC&useUnicode=true&characterEncoding=utf8", "root", "123456");
				// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码
				Statement stmt = connect.createStatement();
				int i=(int)(Math.random()*50);
				i = checki(i, ed);
				ResultSet rs = stmt.executeQuery("select * from single where Eno= '"+i+"'");
				// form 后面为你表的名称
				while (rs.next()) {
					write.append((++order)+"、"+rs.getString("Ee")+" \nA、"+rs.getString("EA")
					+" \nB、"+rs.getString("EB")+" \nC、"+rs.getString("EC")+" \nD、"+rs.getString("ED"));
					answer = rs.getString("Eanswer").toString();
					System.out.println(answer.toString());
				}
			} catch (Exception e) {
				System.out.print("get data error!");
				e.printStackTrace();
			}
		}
	 else if(arg.getSource()==OpenWeb) {
		 Desktop desktop = Desktop.getDesktop();
		 try {
			desktop.browse(new URI("https://baike.baidu.com/item/%E6%AF%9B%E6%B3%BD%E4%B8%9C/113835?fr=aladdin"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	 }
	 else if(arg.getSource()==begin) {
			try {
				Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
				// Class.forName("org.gjt.mm.mysql.Driver");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercises?useSSL=FALSE&"
						+ "serverTimezone=UTC&useUnicode=true&characterEncoding=utf8", "root", "123456");
				// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码
				Statement stmt = connect.createStatement();
				int i=(int)(Math.random()*50);
				i = checki(i, ed);
				ResultSet rs = stmt.executeQuery("select * from single where Eno= '"+i+"'");
				// form 后面为你表的名称
				while (rs.next()) {
					write.append((++order)+"、"+rs.getString("Ee")+" \nA、"+rs.getString("EA")
					+" \nB、"+rs.getString("EB")+" \nC、"+rs.getString("EC")+" \nD、"+rs.getString("ED"));
					answer = rs.getString("Eanswer").toString();
					System.out.println(answer.toString());
				}
			} catch (Exception e) {
				System.out.print("get data error!");
				e.printStackTrace();
			}
		}
	 

	 else if(arg.getSource()==OptionA&&tag==0) {
		 String choose="A";
		 if(choose.equals(answer))
			 write.append("\n\n恭喜你答对了！答案是： "+answer);
		 else {
			 write.append("\n\n很遗憾你答错了，再接再厉");
		 	 }
		 tag=1;
	 }
	 else if(arg.getSource()==OptionB&&tag==0) {
		 String choose="B";
		 if(choose.equals(answer))
			 write.append("\n\n恭喜你答对了！答案是 ： "+answer);
		 else {
			 write.append("\n\n很遗憾你答错了，再接再厉");
		 }
		 tag=1;
	 }
	 else if(arg.getSource()==OptionC&&tag==0) {
		 String choose="C";
		 if(choose.equals(answer))
			 write.append("\n\n恭喜你答对了！答案是 ： "+answer);
		 else {
			 write.append("\n\n很遗憾你答错了，再接再厉");
		 }
		 tag=1;
	 }
	 else if(arg.getSource()==OptionD&&tag==0) {
		 String choose="D";
		 if(choose.equals(answer))
			 write.append("\n\n恭喜你答对了！答案是 ： "+answer);
		 else {
			 write.append("\n\n很遗憾你答错了，再接再厉");
		 }
		 tag=1;
	 }
 }
}

