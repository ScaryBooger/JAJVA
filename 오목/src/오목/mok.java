package 오목;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class mok extends Thread implements ActionListener{
	int gamecount=0;
	boolean turn=true; 
	data data=new data();
	choicedol dol;
	Font f2 = new Font("궁서", Font.BOLD, 30);
	int time=30;
	mokcontroll mc=new mokcontroll();
	JFrame main=new JFrame("오목화면");
	JPanel field=new JPanel();
	JDialog dialog=new JDialog(main,"승리");
	JButton ok=new JButton("확인");
	JLabel blackplayer;
	JLabel blackImg;
	JLabel whiteImg;
	JLabel whiteplayer;
	choiceplayer choice;
	JLabel bturn,wturn;
	JLabel timer=new JLabel();
	JButton restart;
	recorddata record=new recorddata();
	ImageIcon waitsign=new ImageIcon("images//wait.png");
	ImageIcon turnsign=new ImageIcon("images//turnsign.png");
	ImageIcon bd;
	ImageIcon wd;
	ImageIcon img = new ImageIcon("images//empty.png");
	ImageIcon white;
	ImageIcon black;
	JButton jb[][]=new JButton[19][19];
	static int cnt;
	boolean exit=true;
	mok(){
		
		dolchoice();
		field.setLayout(new GridLayout(19,19));
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				jb[i][j]=new JButton(img);
				jb[i][j].addActionListener(this);
				jb[i][j].setBorderPainted(false);
				field.add(jb[i][j]);
			}
		}	
		timer.setFont(f2);
		timer.setBounds(1400, 50, 400, 100);
		
		blackplayer =new JLabel("선공"+choice.blackPlayer);
		blackplayer.setFont(f2);
		blackplayer.setBounds(100, 100, 300, 300);
		blackImg=new JLabel(bd);
		blackImg.setBounds(50, 300, 300, 200);
				
		wturn=new JLabel(waitsign);
		wturn.setBounds(1400, 700, 300, 300);
		bturn=new JLabel(turnsign);
		bturn.setBounds(50, 700, 300, 300);
		
		
		
		whiteplayer=new JLabel("후공"+choice.whitePlayer);
		whiteplayer.setFont(f2);
		whiteplayer.setBounds(1400, 100, 300,300);
		whiteImg=new JLabel(wd);
		whiteImg.setBounds(1400, 300, 300, 200);
		
		
		main.add(timer);
		main.add(wturn);
		main.add(bturn);
		main.add(whiteImg);
		main.add(whiteplayer);
		main.add(blackImg);
		main.add(blackplayer);
		field.setBounds(450, 0, 900, 900);
		main.add(field);
		main.setLayout(null);
		main.setBounds(100,0, 1800, 1200);
		main.setVisible(true);
		this.start();
		
		
		
	}
	public void run() {
		while(exit) {
			try { 
				Thread.sleep(1000);
				time--;
				timer.setText(Integer.toString(time));	
				if(time==0) {
					timeDialog(turn);
					
				}
				
				else if(time<0) {
					timer.setText("수를 두면 경기 시작");
					
				}
		}catch(InterruptedException e) {
			
		} 	
			
	}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton dol=(JButton)e.getSource();
		
		Dimension z=dol.getSize();
		int x=dol.getX()/46;
		int y=dol.getY()/45;	
		
		cnt=mc.addarray(x, y);
		
		if(mc.turn) {
			
			time=31;
			dol.setIcon(black);
			wturn.setIcon(turnsign);
			bturn.setIcon(waitsign);
			if(cnt!=-1) {
				time=0;
				makeDialog(mc.turn);	
				mc.resetArray();
				resetField();
				record.addrecorddata(choice.blackPlayer+"승"+choice.whitePlayer+"패");
				data.updatewincombo(choice.blackPlayer,data.getwincombo(choice.blackPlayer)+1);
				data.updatewincombo(choice.whitePlayer, 0);
				data.updatedefultcombo(choice.blackPlayer, 0);
				data.updatedefultcombo(choice.whitePlayer, data.getdefultcombo(choice.whitePlayer)+1);
				data.updatewin(choice.blackPlayer, data.getwin(choice.blackPlayer)+1);
				data.updatedefult(choice.whitePlayer, data.getdefultcombo(choice.whitePlayer)+1);
				gamecount++;
				return;
				}
			mc.turn=false;		
		}
		else {
			
			time=31;
			dol.setIcon(white);
			bturn.setIcon(turnsign);
			wturn.setIcon(waitsign);
			if(cnt!=-1) {
				time=0;
				makeDialog(mc.turn);
				mc.resetArray();
				resetField();
				
				record.addrecorddata(choice.blackPlayer+"패"+" "+choice.whitePlayer+"승"+" ");
				data.updatewincombo(choice.whitePlayer,data.getwincombo(choice.whitePlayer)+1);
				data.updatewincombo(choice.blackPlayer, 0);
				data.updatedefultcombo(choice.whitePlayer, 0);
				data.updatedefultcombo(choice.blackPlayer, data.getdefultcombo(choice.blackPlayer)+1);
				data.updatewin(choice.whitePlayer, data.getwin(choice.whitePlayer)+1);
				data.updatedefult(choice.blackPlayer, data.getdefultcombo(choice.blackPlayer)+1);
				gamecount++;
				return;
				}
			mc.turn=true;
		}
		
		dol.removeActionListener(this);	
	}

	void makeDialog(boolean turn) {
		if(turn) {
			JOptionPane.showMessageDialog(field,"선공승");
			
		}
		else {
				JOptionPane.showMessageDialog(field,"후공승");					
		}
	}
	void timeDialog(boolean turn) {
		
		if(turn) {
			JOptionPane.showMessageDialog(field,"후공승");
			record.addrecorddata(choice.blackPlayer+"패"+" "+choice.whitePlayer+"승"+" ");
			data.updatewincombo(choice.whitePlayer,data.getwincombo(choice.whitePlayer)+1);
			data.updatewincombo(choice.blackPlayer, 0);
			data.updatedefultcombo(choice.whitePlayer, 0);
			data.updatedefultcombo(choice.blackPlayer, data.getdefultcombo(choice.blackPlayer)+1);
			data.updatewin(choice.whitePlayer, data.getwin(choice.whitePlayer)+1);
			data.updatedefult(choice.blackPlayer, data.getdefultcombo(choice.blackPlayer)+1);
			mc.resetArray();
			resetField();
			System.out.print("백돌승");
			
		}
		else {
			 
				JOptionPane.showMessageDialog(field,"선공승");
				record.addrecorddata(choice.blackPlayer+"승"+choice.whitePlayer+"패");
				data.updatewincombo(choice.blackPlayer,data.getwincombo(choice.blackPlayer)+1);
				data.updatewincombo(choice.whitePlayer, 0);
				data.updatedefultcombo(choice.blackPlayer, 0);
				data.updatedefultcombo(choice.whitePlayer, data.getdefultcombo(choice.whitePlayer)+1);
				data.updatewin(choice.blackPlayer, data.getwin(choice.blackPlayer)+1);
				data.updatedefult(choice.whitePlayer, data.getdefultcombo(choice.whitePlayer)+1);
				mc.resetArray();
				resetField();
				System.out.print("흑돌승");	
		}
		
	}
	
	
	
	void resetField() {
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				jb[i][j].setIcon(img);
				jb[i][j].removeActionListener(this);	
				jb[i][j].addActionListener(this);
				jb[i][j].setBorderPainted(false);
			}
		}	
		cnt=-1;
	}
	

	void dolchoice(){
		if(dol.fa==1) {
			black=new ImageIcon("images//black.png");
			bd=new ImageIcon("images//blakcdol.png");
		}
		else if(dol.fa==2) {
			black=new ImageIcon("images//white.png");
			bd=new ImageIcon("images//whitedol.png");
		}
		else if(dol.fa==3) {
			black=new ImageIcon("images//빨달.png");
			bd=new ImageIcon("images//빨달2.png");
		}
		else if(dol.fa==4) {
			black=new ImageIcon("images//슬라임.png");
			bd=new ImageIcon("images//슬라임2.png");
		}
		else if(dol.fa==5) {
			black=new ImageIcon("images//티모.png");
			bd=new ImageIcon("images//티모2.png");
		}
		else if(dol.fa==6) {
			black=new ImageIcon("images//룰루.png");
			bd=new ImageIcon("images//룰루2.png");
		}
		
		if(dol.ba==1) {
			white=new ImageIcon("images//blakc.png");
			wd=new ImageIcon("images//blakcdol.png");
		}
		else if(dol.ba==2) {
			white=new ImageIcon("images//white.png");
			wd=new ImageIcon("images//whitecdol.png");
		}
		else if(dol.ba==3) {
			white=new ImageIcon("images//빨달.png");
			wd=new ImageIcon("images//빨달2.png");
			
		}
		else if(dol.ba==4) {
			white=new ImageIcon("images//슬라임.png");
			wd=new ImageIcon("images//슬라임2.png");
		}
		else if(dol.ba==5) {
			white=new ImageIcon("images//티모.png");
			wd=new ImageIcon("images//티모2.png");
			
		}
		else if(dol.ba==6) {
			white=new ImageIcon("images//룰루.png");
			wd=new ImageIcon("images//룰루2.png");
			
		}
		
		
		
	}
	
	
	
	
	
	

	
}
	

	

