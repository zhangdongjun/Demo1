package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo2 {
	//mysql的jdbc驱动
    public static String driver="com.mysql.jdbc.Driver";
    //数据库的路径地址
    public static String url ="jdbc:mysql://localhost:3306/gongsi?userUnicode=true&characterEncoding=utf-8";
	//连接数据库的用户名
    public static String name="root";
    //连接数据库的密码
    public static String pwd ="root";

	public static void main(String[] args) {
	   Connection conn = null;  //数据库连接对象
	   Statement  st   = null;  //sql语句对象
	   try {
		  Class.forName(driver); //1加载数据库驱动程序
		  conn = DriverManager.getConnection(url,name,pwd);//2创建数据库连接对象
		  st=conn.createStatement();//3、创建sql语句对象
		  String sql="delete from a where id=1";
		  int ret = st.executeUpdate(sql);//4执行sql语句
		  if(ret!=0){
			  System.out.println("删除成功！");
		  }else{
			  System.out.println("删除失败！");
		  }
	   } catch (Exception e) {
		e.printStackTrace();
	   } finally{
		  try{
			  if(st!=null){
				  st.close();
				  st=null;
			  }
			  if(conn!=null){
				 conn.close();
				 conn=null;
			  }
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	   }
	   

	}

}
