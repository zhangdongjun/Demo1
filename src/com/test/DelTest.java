package com.test;

import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;

public class DelTest {

	public static void main(String[] args) {
		UsersDao dao = new UsersDaoImpl();
		try {
			int ret = dao.delUser(2);
			if(ret!=0){
				System.out.println("ɾ���ɹ���");
			}else{
				System.out.println("ɾ��ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
