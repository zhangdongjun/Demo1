package com.test;

import java.util.Scanner;

import com.dao.PhoneDao;
import com.dao.UsersDao;
import com.dao.impl.PhoneDaoImpl;
import com.dao.impl.UsersDaoImpl;
import com.entity.Phone;
import com.entity.Users;

public class PhoneManager {

	/**
	 * 手机管理系统
	 */
	static Scanner   scan    = new Scanner(System.in); //全局变量
	static Users     user    = new Users();
	static UsersDao  userDao = new UsersDaoImpl();
	static PhoneDao  phoneDao = new PhoneDaoImpl();
	public static void main(String[] args) {
		System.out.println("====欢迎光临手机管理系统=====");
		try {
			Users obj = login();
			if(obj==null){
				System.out.println("用户名或密码错误！");
			}else{
				System.out.println("登录成功，欢迎光临！！");
				while(true){
					welcome();//调用操作界面

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//添加手机信息功能
	public static void addPhone() throws Exception{
	  Phone p = new Phone();	
	  System.out.println("进行手机添加操作....");	
	  System.out.print("请输入手机编号：");
	  p.setId(scan.next());
	  System.out.print("请输入手机名称：");
	  p.setName(scan.next());
	  System.out.print("请输入手机出厂日期");
	  p.setCcrq(scan.next());
	  System.out.print("请输入手机品牌编号");
	  p.setBrandId(scan.nextInt());
	  System.out.print("请输入手机图片路径");
	  p.setBrandPic(scan.next());
	  int ret = phoneDao.addPhone(p);
	  if(ret!=0){
		  System.out.println("手机信息添加成功！");
	  }else{
		  System.out.println("手机信息添加失败！");
	  }
	}
	
	
	
	public static void  welcome() throws Exception {
		System.out.println("=================");
		System.out.println("1、添加手机信息");
		System.out.println("2、修改手机信息");
		System.out.println("3、删除手机信息");
		System.out.println("4、查看手机信息");
		System.out.println("5、退出系统");
		System.out.println("6、检索手机信息(手机名称，出厂日期)");
		System.out.println("=================");
		System.out.println("请选择：");
		int n = scan.nextInt();
		switch(n){
		 case 1: addPhone(); break;
		 case 2:  break;
		 case 3:  break;
		 case 4:  break;
		 case 5:  exit(); break;
		 default:  System.out.println("输入错误！");
		}

	}
	//退出系统
	public static void exit(){
		System.out.println("欢迎下次再来，ByeBye");
		System.exit(0);
	}
	
	//登录界面
	public static Users login() throws Exception {
		System.out.print("请输入用户名：");
		user.setName(scan.next());
		System.out.print("请输入密码：");
		user.setPass(scan.next());
	    return  userDao.login(user);
	}
	
	

}
