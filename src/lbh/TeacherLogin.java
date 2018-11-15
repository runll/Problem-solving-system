package lbh;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TeacherLogin extends JFrame implements ActionListener{
	JLabel Mytitle=new JLabel("教师模式",JLabel.CENTER);
    JLabel Account=new JLabel("Account:",JLabel.LEFT);
    JLabel Password=new JLabel("Password:",JLabel.LEFT);
    JLabel ask=new JLabel("没有账号？",JLabel.LEFT);
    JButton bOK=new JButton("登录");
    JButton bReg=new JButton("立即注册一个");
    JButton bChange=new JButton("学生登录");
    JButton bExit=new JButton("Exit");
    public static JTextField MyAccount=new JTextField(20);
    JPasswordField MyPassword=new JPasswordField(20);
 TeacherLogin(){
 	setUndecorated(true);
 	setLayout(null);
 	setBounds(0,0,750,450);
	Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
	setLocation((screen.width-750)/2,(screen.height-450)/2);
 	JPanel p=new JPanel();
 	this.add(p);
 	p.setBounds(0, 0, 750, 450);
 	p.setBackground(Color.WHITE);
 	p.setLayout(null);
 	Mytitle.setFont(new Font("隶书",Font.BOLD,60));
 	Account.setFont(new Font("Script MT Bold",Font.BOLD,30));
 	Password.setFont(new Font("Script MT Bold",Font.BOLD,30));
 	ask.setFont(new Font("隶书",Font.BOLD,20));
 	bOK.setFont(new Font("隶书",Font.BOLD,30));
 	bReg.setFont(new Font("隶书",Font.BOLD,30));
 	bChange.setFont(new Font("隶书",Font.BOLD,25));
 	bExit.setFont(new Font("Script MT Bold",Font.BOLD,20));
 	MyAccount.setFont(new Font("Tekton Pro",Font.BOLD,30));
 	MyPassword.setFont(new Font("Script MT Bold",Font.BOLD,30));
 	Mytitle.setForeground(Color.DARK_GRAY);
 	Account.setForeground(Color.DARK_GRAY);
 	Password.setForeground(Color.DARK_GRAY);
 	ask.setForeground(Color.DARK_GRAY);
 	bOK.setForeground(Color.DARK_GRAY);
 	bOK.setBorderPainted(false);
 	bOK.setBackground(Color.WHITE);
 	bReg.setForeground(Color.DARK_GRAY);
 	bReg.setBorderPainted(false);
 	bReg.setBackground(Color.WHITE);
 	bChange.setForeground(Color.DARK_GRAY);
 	bChange.setBorderPainted(false);
 	bChange.setBackground(Color.WHITE);
 	bExit.setForeground(Color.DARK_GRAY);
 	bExit.setBorderPainted(false);
 	bExit.setBackground(Color.WHITE); 
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
	 if(arg.getSource()==bOK) {
		 if(MyAccount.getText().equals("lbh")&&(MyPassword.getText().equals("123"))){
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
		 StudentLogin TL=new StudentLogin();
	 }
 }
}

