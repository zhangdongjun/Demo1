package com.test;

import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.entity.Users;

public class TestUser {

	public static void main(String[] args) {
      login();
	}
	
	public static void login(){
		Users user = new Users();
		user.setName("abc");
		user.setPass("111111");
		UsersDao dao = new UsersDaoImpl();
		try {
			Users obj = dao.login(user);
			if(obj==null){
				System.out.println("�û������������");
			}else{
				System.out.println("��¼�ɹ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
