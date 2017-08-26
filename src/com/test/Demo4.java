package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo4 {
	//mysql的jdbc驱动
    public static String driver="com.mysql.jdbc.Driver";
    //数据库的路径地址
    public static String url ="jdbc:mysql://localhost:3306/gongsi?userUnicode=true&characterEncoding=utf-8";
	//连接数据库的用户名
    public static String name="root";
    //连接数据库的密码
    public static String pwd ="root";
	public static void main(String[] args) {
		Connection conn= null;//数据库连接对象
		PreparedStatement ps = null;//数据预编译sql语句
		ResultSet rs = null;
		try {
			Class.forName(driver);//注册数据库驱动程序
			conn=DriverManager.getConnection(url,name,pwd); //创建数据库连接对象
			String sql="select * from Phone order by id desc";
			ps=conn.prepareStatement(sql);//创建sql语句对象
			rs= ps.executeQuery();//执行查询sql语句
			while(rs.next()){ //记录指针往下移动1行，如果true，表示有记录存在
				System.out.print(rs.getString(1)+"\t"); //从结果集中取数据
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("ccrq")+"\t");
				System.out.print(rs.getInt("brandId")+"\t");
				System.out.println(rs.getString("brandPic"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try{
				if(rs!=null){  //关闭资源
					rs.close();
					rs = null;
				}if(ps!=null){
					ps.close();
					ps = null;
				}if(conn!=null){
					conn.close();
					conn= null;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		

	}

}
