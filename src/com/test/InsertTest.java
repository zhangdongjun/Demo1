package com.test;

import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.entity.Users;

public class InsertTest {


	public static void main(String[] args) {
		Users u = new Users();//��ʵ���ำֵ
		u.setName("����");
		u.setPass("123456");
		UsersDao dao = new UsersDaoImpl();
		try {
			int ret = dao.addUser(u);
			if(ret!=0){
				System.out.println("����ɹ���");
			}else{
				System.out.println("����ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
