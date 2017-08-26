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
		entity.setId(20);       //�������id���Ը�ֵ
		entity.setName("zzz");  //��name��ֵ
		entity.setPrice(200);   //��price��ֵ
		int result = insert(entity); //ִ�ж����ݿ��Ĳ������
		if(result!=0){
			System.out.println("����ɹ���");
		}else{
			System.out.println("����ʧ�ܣ�");
		}
	}
	
	// �������
	public static int insert(A entity){
		int ret = 0;
		Connection conn = null; //���ݿ����Ӷ���
		Statement  st   = null; //����sql������
		BaseDao b = new BaseDao();
	    try {
	    	conn= b.getConn();
			String sql="insert into a (id,name,price)values(";
		           sql+=entity.getId()+",";
		           sql+="'"+entity.getName()+"',";
		           sql+=entity.getPrice();
		           sql+=")";
		    System.out.println(sql); //��ӡ��sql���
		    st=conn.createStatement();//3����sql������
		    ret = st.executeUpdate(sql);//4ִ��sql���
	    } catch (Exception e) {
			e.printStackTrace();
		} finally{  //5�ر���Դ
			b.closeAll();
		}

		
		return ret;
	}
	
	

}
