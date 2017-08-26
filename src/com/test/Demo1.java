package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.A;
import com.util.BaseDao;

public class Demo1 {
 
	public static void main(String[] args) {
		A entity = new A();
		entity.setId(20);       //对类里的id属性赋值
		entity.setName("zzz");  //对name赋值
		entity.setPrice(200);   //对price赋值
		int result = insert(entity); //执行对数据库表的插入操作
		if(result!=0){
			System.out.println("插入成功！");
		}else{
			System.out.println("插入失败！");
		}
	}
	
	// 插入操作
	public static int insert(A entity){
		int ret = 0;
		Connection conn = null; //数据库连接对象
		Statement  st   = null; //产生sql语句对象
		BaseDao b = new BaseDao();
	    try {
	    	conn= b.getConn();
			String sql="insert into a (id,name,price)values(";
		           sql+=entity.getId()+",";
		           sql+="'"+entity.getName()+"',";
		           sql+=entity.getPrice();
		           sql+=")";
		    System.out.println(sql); //打印出sql语句
		    st=conn.createStatement();//3创建sql语句对象
		    ret = st.executeUpdate(sql);//4执行sql语句
	    } catch (Exception e) {
			e.printStackTrace();
		} finally{  //5关闭资源
			b.closeAll();
		}

		
		return ret;
	}
	
	

}
