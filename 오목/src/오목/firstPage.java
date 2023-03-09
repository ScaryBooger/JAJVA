package 오목;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class firstPage implements ActionListener{
	
	JFrame mainpage=new JFrame("시작화면");
	
	ImageIcon rank = new ImageIcon("images//rank.png");
	ImageIcon list = new ImageIcon("images//record.png");
	ImageIcon start=new ImageIcon("images//start.png");
	ImageIcon add=new ImageIcon("images//add.png");
	JButton gameStart,Rank,Record,playeradd;
	firstPage(){
		
		
		mainpage.setLayout(null);
		gameStart=new JButton("");
		gameStart.setIcon(start);
		Rank=new JButton("");
		Rank.setIcon(rank);
		Record=new JButton("");
		Record.setIcon(list);
		playeradd=new JButton("");
		playeradd.setIcon(add);
		mainpage.setLayout(new GridLayout(3,0));
		mainpage.setBounds(500, 500, 400, 400);
		gameStart.addActionListener(this);
		Rank.addActionListener(this);
		Record.addActionListener(this);	
		playeradd.addActionListener(this);
		mainpage.add(gameStart);
		mainpage.add(Rank);
		mainpage.add(Record);
		mainpage.add(playeradd);
		mainpage.setVisible(true);	
		mainpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==gameStart) {
			choiceplayer x=new choiceplayer();		
		}	
		if(e.getSource()==playeradd) {
			addplayer addpage=new addplayer();
			
		}
		if(e.getSource()==Record) {	
			record recordpage=new record();
		}
		if(e.getSource()==Rank) {
			rank rank1=new rank();
			
		}
		
	}
	
	public static void main(String[] args) {
		firstPage x=new firstPage();
	}
	
}