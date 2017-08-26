package com.test;

import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.entity.Users;

public class EditTest {

	
	public static void main(String[] args) {
		Users u = new Users();
		u.setId(1);
		u.setName("abc");
		u.setPass("111111");
		UsersDao dao = new UsersDaoImpl();
		try {
			int ret = dao.editUser(u);
			if(ret!=0){
				System.out.println("修改成功！");
			}else{
				System.out.println("修改失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
