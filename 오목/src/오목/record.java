package 오목;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class record  implements ActionListener{
	JLabel title=new JLabel("기록실");
	JFrame record=new JFrame("recordpage");
	JList<String> list;
	JButton back=new JButton("뒤로가기");
	recorddata data=new recorddata();
	JButton initial=new JButton("초기화");
	DefaultListModel model = new DefaultListModel();
	JScrollPane scrollpane;

	
	record(){
	
		String[] array = data.getrecorddata().toArray(new String[data.getrecorddata().size()]);
		list=new JList<String>(array);
		//record.setLayout(null);
		//title.setBounds(350, 10, 100, 30);
		scrollpane= new JScrollPane(list);
		record.setBounds(200,200, 800, 800);
		record.getContentPane().add(scrollpane, BorderLayout.CENTER);
		//record.add(title);
		//back.setBounds(250,700 ,90, 30);
		//initial.setBounds(400, 700, 90, 30);
		//record.add(initial);
		//record.add(back);
		//list.setBounds(50, 50, 700, 650);
		//record.add(list);
		//back.addActionListener(this);
		//initial.addActionListener(this);
		record.setVisible(true);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			record.setVisible(false);
		}
		if(e.getSource()==initial) {
			try {
			list.removeAll();
			model.removeAllElements();
			
			ArrayList <String>ndata=data.getrecorddata();
			for(int i=0;i<ndata.size();i++) {
				model.addElement(ndata.get(i));
			}
			list.setModel(model);}
			catch(NullPointerException e1) {}
		}
		
		
	}
	

	public static void main(String[] args) {
		// record x=new  record();
		
		
	}




	
	
	

	
}
