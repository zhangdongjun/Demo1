package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo2 {
	//mysql��jdbc����
    public static String driver="com.mysql.jdbc.Driver";
    //���ݿ��·����ַ
    public static String url ="jdbc:mysql://localhost:3306/gongsi?userUnicode=true&characterEncoding=utf-8";
	//�������ݿ���û���
    public static String name="root";
    //�������ݿ������
    public static String pwd ="root";

	public static void main(String[] args) {
	   Connection conn = null;  //���ݿ����Ӷ���
	   Statement  st   = null;  //sql������
	   try {
		  Class.forName(driver); //1�������ݿ���������
		  conn = DriverManager.getConnection(url,name,pwd);//2�������ݿ����Ӷ���
		  st=conn.createStatement();//3������sql������
		  String sql="delete from a where id=1";
		  int ret = st.executeUpdate(sql);//4ִ��sql���
		  if(ret!=0){
			  System.out.println("ɾ���ɹ���");
		  }else{
			  System.out.println("ɾ��ʧ�ܣ�");
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
