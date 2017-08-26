package com.dao.impl;

import java.sql.SQLException;

import com.dao.UsersDao;
import com.entity.Users;
import com.util.BaseDao;
//��users����ɾ�Ĳ鷽��
public class UsersDaoImpl extends BaseDao implements UsersDao {
    //����û�
	public int addUser(Users user) throws Exception {
		this.conn = this.getConn();//1�������ݿ����Ӷ���
		/*
		this.st = conn.createStatement();//2����sql������
		String sql="insert into users(name,pass)values(";
		       sql+="'"+user.getName()+"',";
		       sql+="'"+user.getPass()+"'";
		       sql+=")";*/
		String sql="insert into users(name,pass)values(?,?)";
		this.ps = conn.prepareStatement(sql);
		System.out.println(sql); 
		ps.setString(1,user.getName());//��̬��
		ps.setString(2,user.getPass());
		int ret = st.executeUpdate(sql);//3ִ��sql���
		this.closeAll();//4�ر���Դ
		return ret;
	}

	//ɾ���û�
	public int delUser(int id) throws Exception {
		this.conn = this.getConn(); //1�������ݿ����Ӷ���
		//this.st = conn.createStatement(); //2����sql������
		String sql="delete from  users where id=?";
		this.ps = conn.prepareStatement(sql);
		//int ret = st.executeUpdate(sql);//3ִ��sql���
		ps.setInt(1,id); //�󶨲���
		int ret = ps.executeUpdate();
		this.closeAll();//4���ر���Դ
		return ret;
	}

	//�޸��û�
	public int editUser(Users user) throws Exception {
		this.conn = this.getConn();//1�������ݿ����Ӷ���
		StringBuilder sb = new StringBuilder("update users set ");
		sb.append("name=?, ");
		sb.append("pass=?  ");
		sb.append("where id=? ");
		this.ps = conn.prepareStatement(sb.toString());//2����Ԥ����sql������
		ps.setString(1,user.getName());//��̬�󶨲���
		ps.setString(2,user.getPass());
		ps.setInt(3, user.getId());
		int ret = ps.executeUpdate();//ִ��sql���
		this.closeAll();//�ر���Դ
		return ret;
	}

	public Users login(Users user) throws Exception {
		Users obj = null;
		this.conn = this.getConn();//1
		String sql="select * from users where name=? and pass=?";
		this.ps = conn.prepareStatement(sql);//2
		ps.setString(1, user.getName());
		ps.setString(2, user.getPass());
		this.rs = ps.executeQuery();//3��ִ��sql
		if(rs.next()){
		  obj = new Users();
		  obj.setId(rs.getInt("id"));
		  obj.setName(rs.getString("name"));
		  obj.setPass(rs.getString("pass"));
		}
		this.closeAll(); //�ر���Դ
		return obj;
	}

	

}
