package com.dao;

import com.entity.Users;

//dao:��user������ݿ����
public interface UsersDao {
  public int addUser(Users user)    throws Exception; //����û�
  public int delUser(int id)        throws Exception; //ɾ���û�
  public int editUser(Users user)   throws Exception; //�޸��û�
  //��֤��¼����
  public Users login(Users user) throws Exception;
  
}
