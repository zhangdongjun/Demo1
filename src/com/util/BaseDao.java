package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//dao:数据持久层 
public class BaseDao {
	//mysql的jdbc驱动
    public static String driver="com.mysql.jdbc.Driver";
    //数据库的路径地址
    public static String url ="jdbc:mysql://localhost:3306/stu?userUnicode=true&characterEncoding=utf-8";
	//连接数据库的用户名
    public static String name="root";
    //连接数据库的密码
    public static String pwd ="root";
    
    public  Connection conn;       //数据库连接对象
    public  Statement  st;         //sql语句对象
    public  PreparedStatement  ps; //预编译sql语句对象
    public  ResultSet          rs; //结果集对象
    
    //产生数据库连接对象
    public Connection getConn(){
    	try {
			Class.forName(driver); //加载数据库驱动程序
			conn = DriverManager.getConnection(url,name,pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return conn;
    }
    //关闭资源
    public void closeAll(){
    	try {
    		if(rs!=null){
    			rs.close();
    			rs = null;
    		}
    		if(ps!=null){
    			ps.close();
    			ps = null;
    		}
			if(st!=null){
				st.close();
				st = null;
			}
			if(conn!=null){
				conn.close();
				conn= null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }

}
