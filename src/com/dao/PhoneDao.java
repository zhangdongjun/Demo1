package com.dao;

import java.util.List;

import com.entity.Phone;

public interface PhoneDao {
  //�ֻ���Ϣ�����
  public int addPhone(Phone p) throws Exception;	
  //ɾ���ֻ���Ϣ
  public int delPhone(String id) throws Exception;
  //�޸��ֻ���Ϣ
  public int editPhone(Phone p)  throws Exception; 
  //��ѯȫ���ֻ���Ϣ
  public List<Phone> queryPhone() throws Exception;
  //��ҳ��ѯ�ֻ���Ϣ pa:��ǰҳ  pagesize:ÿҳ��¼��
  public List<Phone> queryPhone(int pa,int pagesize) throws Exception;
  //��ѯһ���ֻ���Ϣ
  public Phone queryPhone(String id) throws Exception;
  
}
