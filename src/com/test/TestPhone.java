package com.test;

import java.util.List;

import com.dao.PhoneDao;
import com.dao.impl.PhoneDaoImpl;
import com.entity.Phone;

public class TestPhone {

	public static void main(String[] args) {
		//add(); //����ֻ���Ϣ
        //del();
		//edit();
		//queryAll();
		//fy();
		queryOne();
	}
	
	
	public static  void queryOne(){
		PhoneDao dao = new PhoneDaoImpl();
		try {
			Phone p = dao.queryPhone("0");
			if(p==null){
				System.out.println("û�д������ݣ�");
			}else{
				System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getCcrq());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void fy(){
		PhoneDao dao = new PhoneDaoImpl();
		try {//��ʾ��1ҳ��ÿҳ3������
			List<Phone> list = dao.queryPhone(2,3);
			for(Phone p:list){
			  System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getCcrq());	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void queryAll(){
		PhoneDao dao = new PhoneDaoImpl();
		try {
			List<Phone> list = dao.queryPhone();
			for(Phone p:list){
			  System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getCcrq());	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void edit(){
		Phone p = new Phone();
        p.setId("001");
        p.setName("С��5");
        p.setCcrq("2010-12-12");
        p.setBrandId(1);
        p.setBrandPic("d:\\img\\img1.jpg");
		PhoneDao dao = new PhoneDaoImpl();
		try {
			int ret = dao.editPhone(p);
			if(ret!=0){
				System.out.println("�޸ĳɹ���");
			}else{
				System.out.println("�޸�ʧ��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	public static void del(){
		PhoneDao dao = new PhoneDaoImpl();
		try {
			int ret= dao.delPhone("2");
			if(ret!=0){
				System.out.println("ɾ���ɹ�");
			}else{
				System.out.println("ɾ��ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void add(){
		Phone p = new Phone();
        p.setId("002");
        p.setName("С��5");
        p.setCcrq("2017-12-12");
        p.setBrandId(1);
        p.setBrandPic("d:\\img\\img1.jpg");
        
        PhoneDao  dao = new PhoneDaoImpl();
        try {
			int ret=dao.addPhone(p);
			if(ret!=0){
				System.out.println("����ֻ���Ϣ�ɹ���");
			}else{
				System.out.println("����ֻ���Ϣʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
