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
	 * �ֻ�����ϵͳ
	 */
	static Scanner   scan    = new Scanner(System.in); //ȫ�ֱ���
	static Users     user    = new Users();
	static UsersDao  userDao = new UsersDaoImpl();
	static PhoneDao  phoneDao = new PhoneDaoImpl();
	public static void main(String[] args) {
		System.out.println("====��ӭ�����ֻ�����ϵͳ=====");
		try {
			Users obj = login();
			if(obj==null){
				System.out.println("�û������������");
			}else{
				System.out.println("��¼�ɹ�����ӭ���٣���");
				while(true){
					welcome();//���ò�������

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//����ֻ���Ϣ����
	public static void addPhone() throws Exception{
	  Phone p = new Phone();	
	  System.out.println("�����ֻ���Ӳ���....");	
	  System.out.print("�������ֻ���ţ�");
	  p.setId(scan.next());
	  System.out.print("�������ֻ����ƣ�");
	  p.setName(scan.next());
	  System.out.print("�������ֻ���������");
	  p.setCcrq(scan.next());
	  System.out.print("�������ֻ�Ʒ�Ʊ��");
	  p.setBrandId(scan.nextInt());
	  System.out.print("�������ֻ�ͼƬ·��");
	  p.setBrandPic(scan.next());
	  int ret = phoneDao.addPhone(p);
	  if(ret!=0){
		  System.out.println("�ֻ���Ϣ��ӳɹ���");
	  }else{
		  System.out.println("�ֻ���Ϣ���ʧ�ܣ�");
	  }
	}
	
	
	
	public static void  welcome() throws Exception {
		System.out.println("=================");
		System.out.println("1������ֻ���Ϣ");
		System.out.println("2���޸��ֻ���Ϣ");
		System.out.println("3��ɾ���ֻ���Ϣ");
		System.out.println("4���鿴�ֻ���Ϣ");
		System.out.println("5���˳�ϵͳ");
		System.out.println("6�������ֻ���Ϣ(�ֻ����ƣ���������)");
		System.out.println("=================");
		System.out.println("��ѡ��");
		int n = scan.nextInt();
		switch(n){
		 case 1: addPhone(); break;
		 case 2:  break;
		 case 3:  break;
		 case 4:  break;
		 case 5:  exit(); break;
		 default:  System.out.println("�������");
		}

	}
	//�˳�ϵͳ
	public static void exit(){
		System.out.println("��ӭ�´�������ByeBye");
		System.exit(0);
	}
	
	//��¼����
	public static Users login() throws Exception {
		System.out.print("�������û�����");
		user.setName(scan.next());
		System.out.print("���������룺");
		user.setPass(scan.next());
	    return  userDao.login(user);
	}
	
	

}
