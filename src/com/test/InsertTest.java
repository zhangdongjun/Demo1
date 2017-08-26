package com.test;

import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.entity.Users;

public class InsertTest {


	public static void main(String[] args) {
		Users u = new Users();//对实体类赋值
		u.setName("张三");
		u.setPass("123456");
		UsersDao dao = new UsersDaoImpl();
		try {
			int ret = dao.addUser(u);
			if(ret!=0){
				System.out.println("插入成功！");
			}else{
				System.out.println("插入失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
