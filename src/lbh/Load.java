package lbh;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Load extends JWindow implements ActionListener{
         JLabel back=new JLabel(new ImageIcon("background01.jpg"));
         JProgressBar progressbar=new JProgressBar(0,100);
         Timer tim;
         int n=100;
     public Load() {
    	 setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    	 progressbar.setStringPainted(true);
    	 progressbar.setString("Loading......");
    	 this.add(back,"Center");
    	 this.add(progressbar,"South");
    	 setSize(1180,562);
    	 toFront();
    	 Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
    	 setLocation((screen.width-1180)/2,(screen.height-562)/2);
    	 setVisible(true);
    	 tim=new javax.swing.Timer(100,this);
    	 tim.addActionListener(this);
    	 tim.start();
     }
     public void actionPerformed(ActionEvent e) {
    	 if(--n>0) {
    		 progressbar.setValue(100-n);
    		 tim.restart();
    	 }
    	 else {
    		 tim.stop();
    		 dispose();
    		 StudentMode SMD=new StudentMode("LBH");
    	 }
     }

}