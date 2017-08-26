package com.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DatabaseWin extends JFrame implements ActionListener {

	JMenuBar  menubar;
	JMenu     menu;
	JMenuItem itemShow,itemUpdate,itemInsert;
	ShowRecord showRecord = new ShowRecord("显示记录对话框");
	InsertRecord insertRecord = new InsertRecord("插入数据");
	
	public static void main(String args[]){
		DatabaseWin win = new DatabaseWin();
	}
	
	
	
	
	public DatabaseWin(){
	  menubar = new JMenuBar();
	  menu = new JMenu("操作数据库");
	  itemShow = new JMenuItem("显示记录");
	  itemUpdate = new JMenuItem("更新记录");
	  itemInsert = new JMenuItem("插入记录");
	  itemShow.addActionListener(this);
	  itemUpdate.addActionListener(this);
	  itemInsert.addActionListener(this);
	  menu.add(  itemShow);
	  menu.add(  itemUpdate);
	  menu.add(  itemInsert);
	  menubar.add(menu);
	  
	  setJMenuBar(menubar);
	  setBounds(100,100,370,250);
	  setVisible(true);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
		public void actionPerformed(ActionEvent e) {
		if(e.getSource()==itemShow)
			showRecord.setVisible(true);
		if(e.getSource()==itemInsert)
			insertRecord.setVisible(true);
		
	}

	

}
