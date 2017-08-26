package com.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.dao.PhoneDao;
import com.dao.impl.PhoneDaoImpl;
import com.entity.Phone;

public class InsertRecord extends JDialog implements ActionListener{

	JLabel hintLabel;
	JTable table;
	Object a[][] = new Object[1][5];   //复制
	Object name[]={"id","name","ccrq","bid","bpic"};
	JButton enterInsert;
	String num;
	
	public InsertRecord(String s){
		setTitle(s);
		hintLabel= new JLabel("输入新记录");
		table= new JTable(a,name);
		enterInsert= new JButton("插入新记录");

		setLayout(null);
		Box baseBox = Box.createHorizontalBox();
		baseBox.add(hintLabel);
		baseBox.add(new JScrollPane(table));
		baseBox.add(enterInsert);
		add(baseBox);
		baseBox.setBounds(10,40,600,38);
		enterInsert.addActionListener(this);//注册事件
		setBounds(120,160,700,200);
		
		
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("aaaaaaaaaaaaa");
		PhoneDao  dao1 = new PhoneDaoImpl();
		Phone phone = new Phone();
		phone.setId(a[0][0].toString());
		phone.setName(a[0][1].toString());
		phone.setCcrq(a[0][2].toString());
		phone.setBrandId(Integer.parseInt(a[0][3].toString()));
		phone.setBrandPic(a[0][4].toString());
		try {
			int ret = dao1.addPhone(phone);
			if(ret==1){
				JOptionPane.showMessageDialog(this, "插入成功","成功",JOptionPane.PLAIN_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(this, "插入失败","失败",JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	
}
