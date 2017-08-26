package com.test;

import java.util.List;

import com.dao.PhoneDao;
import com.dao.impl.PhoneDaoImpl;
import com.entity.Phone;

public class TestPhone {

	public static void main(String[] args) {
		//add(); //添加手机信息
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
				System.out.println("没有此条数据！");
			}else{
				System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getCcrq());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void fy(){
		PhoneDao dao = new PhoneDaoImpl();
		try {//显示第1页，每页3条数据
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
        p.setName("小米5");
        p.setCcrq("2010-12-12");
        p.setBrandId(1);
        p.setBrandPic("d:\\img\\img1.jpg");
		PhoneDao dao = new PhoneDaoImpl();
		try {
			int ret = dao.editPhone(p);
			if(ret!=0){
				System.out.println("修改成功！");
			}else{
				System.out.println("修改失败");
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
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void add(){
		Phone p = new Phone();
        p.setId("002");
        p.setName("小米5");
        p.setCcrq("2017-12-12");
        p.setBrandId(1);
        p.setBrandPic("d:\\img\\img1.jpg");
        
        PhoneDao  dao = new PhoneDaoImpl();
        try {
			int ret=dao.addPhone(p);
			if(ret!=0){
				System.out.println("添加手机信息成功！");
			}else{
				System.out.println("添加手机信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
