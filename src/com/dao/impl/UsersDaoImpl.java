package com.dao.impl;

import java.sql.SQLException;

import com.dao.UsersDao;
import com.entity.Users;
import com.util.BaseDao;
//对users表增删改查方法
public class UsersDaoImpl extends BaseDao implements UsersDao {
    //添加用户
	public int addUser(Users user) throws Exception {
		this.conn = this.getConn();//1创建数据库连接对象
		/*
		this.st = conn.createStatement();//2创建sql语句对象
		String sql="insert into users(name,pass)values(";
		       sql+="'"+user.getName()+"',";
		       sql+="'"+user.getPass()+"'";
		       sql+=")";*/
		String sql="insert into users(name,pass)values(?,?)";
		this.ps = conn.prepareStatement(sql);
		System.out.println(sql); 
		ps.setString(1,user.getName());//动态绑定
		ps.setString(2,user.getPass());
		int ret = st.executeUpdate(sql);//3执行sql语句
		this.closeAll();//4关闭资源
		return ret;
	}

	//删除用户
	public int delUser(int id) throws Exception {
		this.conn = this.getConn(); //1创建数据库连接对象
		//this.st = conn.createStatement(); //2创建sql语句对象
		String sql="delete from  users where id=?";
		this.ps = conn.prepareStatement(sql);
		//int ret = st.executeUpdate(sql);//3执行sql语句
		ps.setInt(1,id); //绑定参数
		int ret = ps.executeUpdate();
		this.closeAll();//4、关闭资源
		return ret;
	}

	//修改用户
	public int editUser(Users user) throws Exception {
		this.conn = this.getConn();//1创建数据库连接对象
		StringBuilder sb = new StringBuilder("update users set ");
		sb.append("name=?, ");
		sb.append("pass=?  ");
		sb.append("where id=? ");
		this.ps = conn.prepareStatement(sb.toString());//2创建预编译sql语句对象
		ps.setString(1,user.getName());//动态绑定参数
		ps.setString(2,user.getPass());
		ps.setInt(3, user.getId());
		int ret = ps.executeUpdate();//执行sql语句
		this.closeAll();//关闭资源
		return ret;
	}

	public Users login(Users user) throws Exception {
		Users obj = null;
		this.conn = this.getConn();//1
		String sql="select * from users where name=? and pass=?";
		this.ps = conn.prepareStatement(sql);//2
		ps.setString(1, user.getName());
		ps.setString(2, user.getPass());
		this.rs = ps.executeQuery();//3、执行sql
		if(rs.next()){
		  obj = new Users();
		  obj.setId(rs.getInt("id"));
		  obj.setName(rs.getString("name"));
		  obj.setPass(rs.getString("pass"));
		}
		this.closeAll(); //关闭资源
		return obj;
	}

	

}
