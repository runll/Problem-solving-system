package lbh;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class StudentMode extends JFrame implements ActionListener{
	ImageIcon head=new ImageIcon("lbh.jpg");
	ImageIcon close=new ImageIcon("close.png");
	ImageIcon mini=new ImageIcon("mini.png");
	ImageIcon bg1=new ImageIcon("background011.jpg");
	ImageIcon bg2=new ImageIcon("background012.jpg");
	ImageIcon bg3=new ImageIcon("background013.jpg");
	ImageIcon bg4=new ImageIcon("background014.jpg");
	JLabel Myhead=new JLabel(head,JLabel.LEFT);
	JLabel Welcome=new JLabel("Welcome Back!LBH",JLabel.CENTER);
	JButton Mini=new JButton(mini);
	JButton Exit=new JButton(close);
	JButton User=new JButton("LBH");
	JButton Mode1=new JButton(bg1);
	JButton Mode2=new JButton(bg2);
	JButton Mode3=new JButton(bg3);
	JButton Mode4=new JButton(bg4);
 StudentMode(String title){
 	setUndecorated(true);
 	setLayout(null);
 	setBounds(0,0,1080,760);
	Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
	setLocation((screen.width-1080)/2,(screen.height-760)/2);
 	JPanel p=new JPanel();
 	this.add(p);
 	p.setBounds(0, 0, 1080, 760);
 	p.setBackground(Color.DARK_GRAY);
 	p.setLayout(null);
 	Welcome.setFont(new Font("Script MT Bold",Font.BOLD,50));
 	User.setFont(new Font("Script MT Bold",Font.BOLD,40));
 	
 	Welcome.setForeground(Color.WHITE);
 	Mini.setForeground(Color.WHITE);
 	Mini.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
 	Mini.setBackground(Color.DARK_GRAY);
 	Exit.setForeground(Color.WHITE);
 	Exit.setBorderPainted(false);
 	Exit.setBackground(Color.DARK_GRAY);
 	User.setForeground(Color.WHITE);
 	User.setBorderPainted(false);
 	User.setBackground(Color.DARK_GRAY);
 	Mode1.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
 	Mode2.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
 	Mode3.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
 	Mode4.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
 	
 	p.add(Welcome);
 	p.add(Mini);
 	p.add(Exit);
 	p.add(Myhead);
 	p.add(User);
 	p.add(Mode1);
 	p.add(Mode2);
 	p.add(Mode3);
 	p.add(Mode4);
 	
 	
 	Welcome.setBounds(100, 0, 880, 100);
 	Mini.setBounds(990, 10, 30, 30);
 	Exit.setBounds(1030, 0, 50, 50);
 	Myhead.setBounds(40, 120, 80, 80);
 	User.setBounds(130, 120, 150, 80);
 	Mode1.setBounds(150, 220, 782, 130);
 	Mode2.setBounds(150, 350, 782, 130);
 	Mode3.setBounds(150, 480, 782, 130);
 	Mode4.setBounds(150, 610, 782, 130);
 	
 	Mini.addActionListener(this);
 	Exit.addActionListener(this);
 	User.addActionListener(this);
 	Mode1.addActionListener(this);
 	Mode2.addActionListener(this);
 	Mode3.addActionListener(this);
 	Mode4.addActionListener(this);
 	
 	this.setResizable(false);
 	this.setVisible(true);
 }
 public void actionPerformed(ActionEvent arg){
	 if(arg.getSource()==Mini) {
		 setExtendedState(JFrame.ICONIFIED);
	 }
	 else if(arg.getSource()==Exit) {
		 System.exit(0);
	 }
	 else if(arg.getSource()==User) {
		
	 }
	 else if(arg.getSource()==Mode1) {
		 dispose();
		 Answer as=new Answer();
	 }
	 else if(arg.getSource()==Mode2) {

	 }
	 else if(arg.getSource()==Mode3) {

	 }
	 else if(arg.getSource()==Mode4) {

	 }
 }
}	
