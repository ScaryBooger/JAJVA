package 오목;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class rank implements ActionListener{
	data data=new data();
	JLabel title=new JLabel("랭킹");
	JFrame rankpage=new JFrame("rankpage");
	Choice choice=new Choice();
	JButton ok=new JButton("선택");
	JButton back=new JButton("뒤로가기");
	JList<String>list;
	DefaultListModel model = new DefaultListModel();
	rank(){
		rankpage.setBounds(200, 200, 800, 800);
		title.setBounds(300, 20, 40, 30);
		choice.add("winrate");
		choice.add("wincount");
		choice.add("wincombo");
		choice.add("defultcombo");
		choice.setBounds(400, 20, 100, 30);
		ok.setBounds(550, 20, 60, 30);
		rankpage.add(ok);
		rankpage.setLayout(null);
		rankpage.add(choice);
		rankpage.add(title);
		ok.addActionListener(this);
		back.addActionListener(this);
		ArrayList<String> win=data.all();
		String[] array = win.toArray(new String[win.size()]);
		list=new JList<String>(array);
		list.setBounds(50, 50, 700, 650);
		rankpage.add(list);
		rankpage.setVisible(true);
						
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ok&&choice.getSelectedItem().equals("wincount")) {
			
				list.removeAll();
				model.removeAllElements();
				ArrayList<String> win=data.win();
				for(int i=0;i<win.size();i++) {
					model.addElement(win.get(i));
				}
				list.setModel(model);
			}
	
	if(e.getSource()==ok&&choice.getSelectedItem().equals("winrate")) {
			list.removeAll();
			model.removeAllElements();
				ArrayList<String> winrate=data.winrate();
				for(int i=0;i<winrate.size();i++) {
					model.addElement(winrate.get(i));
				}
				list.setModel(model);					
			}
	if(e.getSource()==ok&&choice.getSelectedItem().equals("wincombo")) {
			
				list.removeAll();
				model.removeAllElements();
				ArrayList<String> wincombo=data.wincombo();
				for(int i=0;i<wincombo.size();i++) {
					model.addElement(wincombo.get(i));
				}
				list.setModel(model);					
			}
	if(e.getSource()==ok&&choice.getSelectedItem().equals("defultcombo")) {
		
			list.removeAll();
			model.removeAllElements();
			ArrayList<String> defultcombo=data.defultcombo();
			for(int i=0;i<defultcombo.size();i++) {
			model.addElement(defultcombo.get(i));
		}
			list.setModel(model);					
	}
	}
	
		
		
		
	
	
	


	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		//rank x=new rank();
		
		
	}


	
	
	
	
}
