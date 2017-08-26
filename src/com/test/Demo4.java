package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo4 {
	//mysql��jdbc����
    public static String driver="com.mysql.jdbc.Driver";
    //���ݿ��·����ַ
    public static String url ="jdbc:mysql://localhost:3306/gongsi?userUnicode=true&characterEncoding=utf-8";
	//�������ݿ���û���
    public static String name="root";
    //�������ݿ������
    public static String pwd ="root";
	public static void main(String[] args) {
		Connection conn= null;//���ݿ����Ӷ���
		PreparedStatement ps = null;//����Ԥ����sql���
		ResultSet rs = null;
		try {
			Class.forName(driver);//ע�����ݿ���������
			conn=DriverManager.getConnection(url,name,pwd); //�������ݿ����Ӷ���
			String sql="select * from Phone order by id desc";
			ps=conn.prepareStatement(sql);//����sql������
			rs= ps.executeQuery();//ִ�в�ѯsql���
			while(rs.next()){ //��¼ָ�������ƶ�1�У����true����ʾ�м�¼����
				System.out.print(rs.getString(1)+"\t"); //�ӽ������ȡ����
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("ccrq")+"\t");
				System.out.print(rs.getInt("brandId")+"\t");
				System.out.println(rs.getString("brandPic"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try{
				if(rs!=null){  //�ر���Դ
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
