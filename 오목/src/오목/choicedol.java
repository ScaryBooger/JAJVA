package 오목;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class choicedol implements ActionListener{

	JFrame dolpage=new JFrame("돌선택페이지");
	
	JLabel select=new JLabel("선공 선택");
	Font f2 = new Font("궁서", Font.BOLD, 30);
	static int fa;
	static int ba;
	
	
	ImageIcon bd=new ImageIcon("images//black.png");
	ImageIcon wd=new ImageIcon("images//white.png");
	ImageIcon rd=new ImageIcon("images//빨달.png");
	ImageIcon dora=new ImageIcon("images//슬라임.png");
	ImageIcon timo=new ImageIcon("images//티모.png");
	ImageIcon rulru=new ImageIcon("images//룰루.png");
	JLabel l1=new JLabel(bd);
	JLabel l2=new JLabel(wd);
	JLabel l3=new JLabel(rd);
	JLabel l4=new JLabel(dora);
	JLabel l5=new JLabel(timo);
	JLabel l6=new JLabel(rulru);
	JButton b1=new JButton("선택");
	JButton b2=new JButton("선택");
	JButton b3=new JButton("선택");
	JButton b4=new JButton("선택");
	JButton b5=new JButton("선택");
	JButton b6=new JButton("선택");
	JButton b7=new JButton("게임시작");
	choicedol(){
		select.setFont(f2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);	
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		dolpage.setLayout(null);
		
		dolpage.setBounds(400, 400, 500, 500);
		l1.setBounds(20, 20, 50, 50);
		l2.setBounds(180, 20, 50, 50);
		l3.setBounds(340, 20, 50, 50);
		dolpage.add(l3);
		dolpage.add(l2);
		dolpage.add(l1);
		b1.setBounds(10, 80, 60, 30);
		b2.setBounds(180, 80, 60, 30);
		b3.setBounds(340, 80, 60, 30);
		dolpage.add(b3);
		dolpage.add(b2);
		dolpage.add(b1);
		

		l4.setBounds(20, 240,50, 50);
		dolpage.add(l4);
		b4.setBounds(10, 300, 60, 30);
		dolpage.add(b4);
		
		l5.setBounds(180, 240, 50, 50);
		l6.setBounds(340, 240, 50, 50);
		b5.setBounds(180, 300, 60, 30);
		b6.setBounds(340, 300, 60, 30);
		select.setBounds(150, 350, 200, 50);
		dolpage.add(select);
		b7.setBounds(350, 350, 90, 30);
		dolpage.add(b7);
		dolpage.add(b5);
		dolpage.add(b6);
		dolpage.add(l5);
		dolpage.add(l6);
		dolpage.setVisible(true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(fa==0) {
			if(e.getSource()==b1) {
				fa=1;
				b1.setEnabled(false);
				select.setText("후공선택");
			}
			else if(e.getSource()==b2) {
				fa=2;
				b2.setEnabled(false);
				select.setText("후공선택");
			}
			else if(e.getSource()==b3) {
				fa=3;
				b3.setEnabled(false);
				select.setText("후공선택");
			}
			else if(e.getSource()==b4) {
				fa=4;
				b4.setEnabled(false);
				select.setText("후공선택");
			}
			else if(e.getSource()==b5) {
				fa=5;
				b5.setEnabled(false);
				select.setText("후공선택");
			}
			else if(e.getSource()==b6) {
				fa=6;
				b6.setEnabled(false);
				select.setText("후공선택");
			}
			
		}
		else {
			if(e.getSource()==b1) {
				ba=1;
				b1.setEnabled(false);
				select.setText("선택완료");
			}
			else if(e.getSource()==b2) {
				ba=2;
				b2.setEnabled(false);
				select.setText("선택완료");
			}
			else if(e.getSource()==b3) {
				ba=3;
				b3.setEnabled(false);
				select.setText("선택완료");
			}
			else if(e.getSource()==b4) {
				ba=4;
				b4.setEnabled(false);
				select.setText("선택완료");
			}
			else if(e.getSource()==b5) {
				ba=5;
				b5.setEnabled(false);
				select.setText("선택완료");
			}
			else if(e.getSource()==b6) {
				ba=6;
				b6.setEnabled(false);
				select.setText("선택완료");
			}
			
		}
		if(e.getSource()==b7) {
			if(fa==0||ba==0) {
				JOptionPane.showMessageDialog(dolpage,"돌을선택하세요");
				
			}
			else {
				JOptionPane.showMessageDialog(dolpage,"게임시작");
				mok x=new mok();
				
				
			}
			
		}
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		//choicedol x=new choicedol();
	}
	
	
	
	
	
	
	
	
}
