package lbh;


import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class StudentLogin extends JFrame implements ActionListener{
	JLabel Mytitle=new JLabel("Serve The People",JLabel.CENTER);
    JLabel Account=new JLabel("Account:",JLabel.LEFT);
    JLabel Password=new JLabel("Password:",JLabel.LEFT);
    JLabel ask=new JLabel("没有账号？",JLabel.LEFT);
    JButton bOK=new JButton("登录");
    JButton bReg=new JButton("立即注册一个");
    JButton bChange=new JButton("教师登录");
    JButton bExit=new JButton("Exit");
    public static JTextField MyAccount=new JTextField(20);
    JPasswordField MyPassword=new JPasswordField(20);
 StudentLogin(){
 	setUndecorated(true);
 	setLayout(null);
 	setBounds(0,0,750,450);
	Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
	setLocation((screen.width-750)/2,(screen.height-450)/2);
 	JPanel p=new JPanel();
 	this.add(p);
 	p.setBounds(0, 0, 750, 450);
 	p.setBackground(Color.DARK_GRAY);
 	p.setLayout(null);
 	Mytitle.setFont(new Font("Script MT Bold",Font.BOLD,50));
 	Account.setFont(new Font("Script MT Bold",Font.BOLD,30));
 	Password.setFont(new Font("Script MT Bold",Font.BOLD,30));
 	ask.setFont(new Font("隶书",Font.BOLD,20));
 	bOK.setFont(new Font("隶书",Font.BOLD,30));
 	bReg.setFont(new Font("隶书",Font.BOLD,30));
 	bChange.setFont(new Font("隶书",Font.BOLD,25));
 	bExit.setFont(new Font("Script MT Bold",Font.BOLD,20));
 	MyAccount.setFont(new Font("Tekton Pro",Font.BOLD,30));
 	MyPassword.setFont(new Font("Script MT Bold",Font.BOLD,30));
 	Mytitle.setForeground(Color.WHITE);
 	Account.setForeground(Color.WHITE);
 	Password.setForeground(Color.WHITE);
 	ask.setForeground(Color.WHITE);
 	bOK.setForeground(Color.WHITE);
 	bOK.setBorderPainted(false);
 	bOK.setBackground(Color.DARK_GRAY);
 	bReg.setForeground(Color.WHITE);
 	bReg.setBorderPainted(false);
 	bReg.setBackground(Color.DARK_GRAY);
 	bChange.setForeground(Color.WHITE);
 	bChange.setBorderPainted(false);
 	bChange.setBackground(Color.DARK_GRAY);
 	bExit.setForeground(Color.WHITE);
 	bExit.setBorderPainted(false);
 	bExit.setBackground(Color.DARK_GRAY); 
 	p.add(Mytitle);
 	p.add(Account);
 	p.add(MyAccount);
 	p.add(Password);
 	p.add(MyPassword);
 	p.add(bOK);
 	p.add(ask);
 	p.add(bReg);
 	p.add(bChange);
 	p.add(bExit);
 	Mytitle.setBounds(0, 0, 750, 100);
 	Account.setBounds(50,125,250,100);
 	Password.setBounds(50,210,250,100);
 	MyAccount.setBounds(225,150,350,50);
 	MyPassword.setBounds(225,235,350,50);
 	bOK.setBounds(245, 310, 250, 40);
 	ask.setBounds(120, 360, 250, 40);
 	bReg.setBounds(255,360,250,40);
 	bChange.setBounds(250, 410, 250, 40);
 	bExit.setBounds(650, 400, 100, 45);
 	bOK.addActionListener(this);
 	bReg.addActionListener(this);
 	bChange.addActionListener(this);
 	bExit.addActionListener(this);
 	this.setResizable(false);
 	this.setVisible(true);
 } 
 public void actionPerformed(ActionEvent arg){
	 //do here by runll
	 if(arg.getSource()==bOK) {
		 boolean isHad = false;
		 String idString = MyAccount.getText();
		 String passwordString = MyPassword.getText();
		 String returnId = "";
		 String returnPassword = "";
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
				ResultSet rs = stmt.executeQuery("select * from User where id = '"+idString+"'");
				while(rs.next()) {
				returnId = rs.getString("Id");
				returnPassword = rs.getString("Password");
				}
				
			} catch (Exception e) {
				System.out.print("get data error!");
				e.printStackTrace();
			}

		
		 if(returnId.toString().equals(idString)&&returnPassword.toString().equals(passwordString)){
			 dispose();
			 Load load=new Load();
		 }
		 else {
			 JOptionPane.showMessageDialog(this,"账号或密码错误","Error",JOptionPane.ERROR_MESSAGE);
		 }
	 }
	 else if(arg.getSource()==bExit) {
		 System.exit(0);
	 }
	 else if(arg.getSource()==bReg) {
		 dispose();
		 Register re=new Register();
	 }
	 else if(arg.getSource()==bChange) {
		 dispose();
		 TeacherLogin TL=new TeacherLogin();
	 }
 }
}
