package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//dao:���ݳ־ò� 
public class BaseDao {
	//mysql��jdbc����
    public static String driver="com.mysql.jdbc.Driver";
    //���ݿ��·����ַ
    public static String url ="jdbc:mysql://localhost:3306/stu?userUnicode=true&characterEncoding=utf-8";
	//�������ݿ���û���
    public static String name="root";
    //�������ݿ������
    public static String pwd ="root";
    
    public  Connection conn;       //���ݿ����Ӷ���
    public  Statement  st;         //sql������
    public  PreparedStatement  ps; //Ԥ����sql������
    public  ResultSet          rs; //���������
    
    //�������ݿ����Ӷ���
    public Connection getConn(){
    	try {
			Class.forName(driver); //�������ݿ���������
			conn = DriverManager.getConnection(url,name,pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return conn;
    }
    //�ر���Դ
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
