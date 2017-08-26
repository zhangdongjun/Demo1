package com.dao;

import com.entity.Users;

//dao:对user表的数据库操作
public interface UsersDao {
  public int addUser(Users user)    throws Exception; //添加用户
  public int delUser(int id)        throws Exception; //删除用户
  public int editUser(Users user)   throws Exception; //修改用户
  //验证登录功能
  public Users login(Users user) throws Exception;
  
}
