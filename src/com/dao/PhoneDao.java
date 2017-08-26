package com.dao;

import java.util.List;

import com.entity.Phone;

public interface PhoneDao {
  //手机信息的添加
  public int addPhone(Phone p) throws Exception;	
  //删除手机信息
  public int delPhone(String id) throws Exception;
  //修改手机信息
  public int editPhone(Phone p)  throws Exception; 
  //查询全部手机信息
  public List<Phone> queryPhone() throws Exception;
  //分页查询手机信息 pa:当前页  pagesize:每页记录数
  public List<Phone> queryPhone(int pa,int pagesize) throws Exception;
  //查询一条手机信息
  public Phone queryPhone(String id) throws Exception;
  
}
