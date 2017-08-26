package com.util;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.dao.PhoneDao;
import com.dao.impl.PhoneDaoImpl;
import com.entity.Phone;
//负责显示记录的类
public class ShowRecord extends JDialog implements ActionListener{
    JTable table;
    Object a[][];
    Object name[]={"id","name","ccrq"};
    JButton showRecord;
    
    ShowRecord(String title){
    	setTitle(title);
    	showRecord = new JButton("显示记录");
    	showRecord.addActionListener(this);
    	add(showRecord,BorderLayout.NORTH);
    	setBounds(200,60,400,250);
    }
    
    
    
	
	public void actionPerformed(ActionEvent e) {
		PhoneDao dao = new PhoneDaoImpl();
		try {
			List<Phone> list = dao.queryPhone();
			a= new Object[list.size()][3];
			for(int i=0;i<list.size();i++){
				Phone p = list.get(i);
				a[i][0]=p.getId();
				a[i][1]=p.getName();
				a[i][2]=p.getCcrq();
			}
			table= new JTable(a,name);
			getContentPane().removeAll();
			add(showRecord,BorderLayout.NORTH);
			add(new JScrollPane(table),BorderLayout.CENTER);
			validate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

}
