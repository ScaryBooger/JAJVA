package 오목;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class addplayer implements ActionListener{

	data data=new data();
	JButton add=new JButton("등록");
	JFrame addpage=new JFrame("등록화면");
	JLabel name=new JLabel("이름");
	JTextField nameTf=new JTextField();
	JButton back=new JButton("뒤로가기");
	addplayer(){
		addpage.setBounds(400, 400, 400, 400);
		name.setBounds(50, 100, 100, 100);
		addpage.setLayout(null);
		nameTf.setBounds(110, 140, 60, 30);
		add.setBounds(210, 140, 60, 30);
		back.setBounds(150, 300, 100, 30);
		addpage.add(add);
		addpage.add(name);
		addpage.add(nameTf);
		addpage.add(back);
		add.addActionListener(this);
		back.addActionListener(this);
		addpage.setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Set x=new HashSet();
		x=data.getName();
		if(e.getSource()==add) {
			if(nameTf.getText().equals("")) {
				JOptionPane.showMessageDialog(addpage,"이름을 입력하세요");
				return;
				}
			else if(x.add(nameTf.getText())) {
				nameTf.setEnabled(false);
				System.out.println(nameTf.getText());
				data.addPlayer(nameTf.getText());
				JOptionPane.showMessageDialog(addpage,"등록완료");
				
			}
			else {
				JOptionPane.showMessageDialog(addpage,"이름중복");
				
			}
		
		}
	
		if(e.getSource()==back) {
			addpage.setVisible(false);
		}
		}
	
	
	public static void main(String[] args) {
		//addplayer x=new addplayer();
		
		
		
	}




	
	
	
	
	
	
	
	
	
	
	
	
}
