package 오목;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class choiceplayer implements ActionListener{

	static String blackPlayer;
	static String whitePlayer;
	Font f2 = new Font("궁서", Font.BOLD, 25);
	data data=new data();
	
	JFrame choie=new JFrame();
	
	JLabel blackdol=new JLabel("선공");
	JLabel whitedol=new JLabel("후공");
	Choice blakchoice=new Choice();
	Choice whitechoice=new Choice();
	JButton blackButton=new JButton("선택");
	JButton whiteButton=new JButton("선택");
	JButton start=new JButton("게임시작");
	choiceplayer(){
		//String name[]=data.getName();
		Set x=new HashSet();
		x=data.getName();
		Iterator it=x.iterator();
		
		while(it.hasNext()) {
			Object obj=it.next();
			blakchoice.add(obj.toString());
			whitechoice.add(obj.toString());			
		}
		choie.setBounds(200, 200, 400, 400);
		choie.setLayout(null);
		
		blackdol.setFont(f2);
		whitedol.setFont(f2);
		
		blackdol.setBounds(40, 40, 60, 60);
		blakchoice.setBounds(120, 55, 80, 50);
		blackButton.setBounds(230,55, 80, 30);
		
		
		whitedol.setBounds(40, 140, 60, 60);
		whitechoice.setBounds(120, 155, 80, 50);
		whiteButton.setBounds(230,155, 80, 30);
		
		start.setBounds(130, 255, 100, 40);
		
		choie.add(start);
		choie.add(blackdol);
		choie.add(blackButton);
		choie.add(whitedol);
		choie.add(whiteButton);
		choie.add(blakchoice);
		choie.add(whitechoice);
		choie.setVisible(true);
		
		start.addActionListener(this);
		blackButton.addActionListener(this);
		whiteButton.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if(e.getSource()==blackButton) {
				blackPlayer=blakchoice.getSelectedItem();
				deletChoice1();
				blakchoice.setEnabled(false);
			}
			if(e.getSource()==whiteButton) {
				whitePlayer=whitechoice.getSelectedItem();
				deletChoice2();
				whitechoice.setEnabled(false);
			}	
			
			if(e.getSource()==start) {
				if(blackPlayer==null&&whitePlayer==null) {
					JOptionPane.showMessageDialog(choie,"사람을 선택하시오");
					return;
				}
				choicedol x=new choicedol();
				
				
			}
	}
		
	
	void deletChoice1() {
		String i=blakchoice.getSelectedItem();
		
		whitechoice.remove(i);
	
			
		
	}
	void deletChoice2() {
		String i=whitechoice.getSelectedItem();
		
			blakchoice.remove(i);
		
	}
	
	public static void main(String[] args) {
		//choiceplayer x=new choiceplayer();
	}

	
	
	
}
