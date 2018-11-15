package lbh;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Register extends JDialog implements ActionListener{
	JLabel Mytitle=new JLabel("Register Now",JLabel.CENTER);
    JLabel Account=new JLabel("你的学号:",JLabel.LEFT);
    JLabel Name=new JLabel("你的姓名:",JLabel.LEFT);
    JLabel Password=new JLabel("你的密码:",JLabel.LEFT);
    JButton bOK=new JButton("注册");
    JButton bCan=new JButton("取消");
    JTextField MyAccount=new JTextField(20);
    JTextField MyName=new JTextField(20);
    JPasswordField MyPassword=new JPasswordField(20);
 Register(){
 	setUndecorated(true);
 	setLayout(null);
 	this.setBounds(0,0,750,460);
	Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
	setLocation((screen.width-750)/2,(screen.height-460)/2);
 	JPanel p=new JPanel();
 	this.add(p);
 	p.setBounds(0, 0, 750, 460);
 	p.setBackground(Color.DARK_GRAY);
 	p.setLayout(null);
 	Mytitle.setFont(new Font("Century Gothic",Font.BOLD,50));
 	Account.setFont(new Font("幼圆",Font.BOLD,30));
 	Name.setFont(new Font("幼圆",Font.BOLD,30));
 	Password.setFont(new Font("幼圆",Font.BOLD,30));
 	bOK.setFont(new Font("幼圆",Font.BOLD,30));
 	bCan.setFont(new Font("幼圆",Font.BOLD,30));
 	MyAccount.setFont(new Font("Tekton Pro",Font.BOLD,30));
 	MyName.setFont(new Font("隶书",Font.BOLD,30));
 	MyPassword.setFont(new Font("Script MT Bold",Font.BOLD,30));
 	Mytitle.setForeground(Color.WHITE);
 	Account.setForeground(Color.WHITE);
 	Name.setForeground(Color.WHITE);
 	Password.setForeground(Color.WHITE);
 	bOK.setForeground(Color.WHITE);
 	bOK.setBorderPainted(false);
 	bOK.setBackground(Color.DARK_GRAY);
 	bCan.setForeground(Color.WHITE);
 	bCan.setBorderPainted(false);
 	bCan.setBackground(Color.DARK_GRAY);
 	p.add(Mytitle);
 	p.add(Account);
 	p.add(MyAccount);
 	p.add(Name);
 	p.add(MyName);
 	p.add(Password);
 	p.add(MyPassword);
 	p.add(bOK);
 	p.add(bCan);
 	Mytitle.setBounds(0, 0, 750, 100);
 	Account.setBounds(50,125,250,100);
 	Name.setBounds(50,200,250,100);
 	Password.setBounds(50,275,250,100);
 	MyAccount.setBounds(275,150,300,50);
 	MyName.setBounds(275,225,300,50);
 	MyPassword.setBounds(275,300,300,50);
 	bOK.setBounds(245, 370, 250, 40);
 	bCan.setBounds(245,420,250,40);
 	bCan.addActionListener(this);
 	bOK.addActionListener(this);
 	this.setResizable(false);
 	this.setVisible(true);
 } 
 public void actionPerformed(ActionEvent arg){
	 if(arg.getSource()==bCan) {
		 dispose();
	     StudentLogin ll=new StudentLogin();
	 }
	 else if(arg.getSource()==bOK) {//Register
		 	String idString = MyAccount.getText();
			String passwordString = MyPassword.getText();
			String nameString = MyName.getText();
			boolean isHad = false;
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
				//ResultSet rs = stmt.executeQuery("select * from User where Id = '"+idString+"'");
				ResultSet rs = stmt.executeQuery("select * from User");
				
				while(rs.next()) {
					//System.out.println(rs.getString("Id"));
					if(rs.getString("Id").toString().equals(idString)) {
						isHad = true;
						break;
					}
				}
				
				if (isHad == false) {
					PreparedStatement Statement = connect.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?)");
					Statement.setString(1, idString);
					Statement.setString(2, passwordString);
					Statement.setString(3, nameString);
					Statement.setString(4, "0");
					Statement.setString(5, "0");
					Statement.setString(6, "0");
					Statement.executeUpdate();
					JOptionPane.showMessageDialog(this,"注册成功");
					dispose();
				    StudentLogin ll=new StudentLogin();
				} else {
					JOptionPane.showMessageDialog(this,"账号已存在","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
	 
}
}