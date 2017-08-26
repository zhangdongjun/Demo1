package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.PhoneDao;
import com.entity.Phone;
import com.util.BaseDao;

public class PhoneDaoImpl extends BaseDao implements PhoneDao{
    //����ֻ���Ϣ����
	public int addPhone(Phone p) throws Exception {
        this.conn = this.getConn(); //1���������ݿ����Ӷ���
        String sql="insert into phone(id,name,ccrq,brandid,brandpic)";
        sql+="values(?,?,?,?,?)";
        this.ps = conn.prepareStatement(sql);//2������sql������
        ps.setString(1, p.getId()); //3����̬�󶨲������ԣ�ռλ��λ�ø�ֵ
        ps.setString(2, p.getName());
        ps.setString(3, p.getCcrq());
        ps.setInt(4, p.getBrandId());
        ps.setString(5, p.getBrandPic());
        int ret = ps.executeUpdate(); //4��ִ��sql���
        this.closeAll();//5���ر���Դ
		return ret;
	}
	//ɾ���ֻ���Ϣ����
	public int delPhone(String id) throws Exception {
		this.conn = this.getConn(); //1���������ݿ����Ӷ���
        String sql="delete from phone where id="+id;
        this.ps = conn.prepareStatement(sql);//2������sql������
        int ret = ps.executeUpdate(); //4��ִ��sql���
        this.closeAll();//5���ر���Դ
		return ret;
	}
	//�޸��ֻ���Ϣ����
	public int editPhone(Phone p) throws Exception {
		this.conn = this.getConn(); //1���������ݿ����Ӷ���
        StringBuilder sb = new StringBuilder("update phone set");
        sb.append(" name     =?,");
        sb.append(" ccrq     =?,");
        sb.append(" brandid  =?,");
        sb.append(" brandpic =? ");
        sb.append(" where id =? ");
        System.out.println(sb.toString());
        this.ps = conn.prepareStatement(sb.toString());//2������sql������
        //3����̬�󶨲������ԣ�ռλ��λ�ø�ֵ
        ps.setString(1, p.getName());
        ps.setString(2, p.getCcrq());
        ps.setInt(3, p.getBrandId());
        ps.setString(4, p.getBrandPic());
        ps.setString(5, p.getId());
        int ret = ps.executeUpdate(); //4��ִ��sql���
        this.closeAll();//5���ر���Դ
		return ret;
	}
	//��ѯ�����ֻ���Ϣ
	public List<Phone> queryPhone() throws Exception {
		List<Phone> list = new ArrayList<Phone>();
		this.conn = this.getConn(); //1���������ݿ����Ӷ���
		String sql="select * from phone order by id desc";
		this.ps = conn.prepareStatement(sql); //2������Ԥ����sql������
		this.rs = ps.executeQuery();//3��ִ�в�ѯ�����ؽ����
		while(rs.next()){
			Phone p = new Phone();
			p.setId(rs.getString("id"));
			p.setName(rs.getString("name"));
			p.setCcrq(rs.getString("ccrq"));
			p.setBrandId(rs.getInt("brandid"));
			p.setBrandPic(rs.getString("brandpic"));
			list.add(p);
		}
		this.closeAll();//�ر���Դ
		return list;
	}

	public List<Phone> queryPhone(int pa, int pagesize) throws Exception {
		List<Phone> list = new ArrayList<Phone>();
		this.conn = this.getConn(); //1���������ݿ����Ӷ���
		String sql="select * from phone  order by id desc  limit ?,?";
		this.ps = conn.prepareStatement(sql); //2������Ԥ����sql������
		ps.setInt(1, (pa-1)*pagesize);
		ps.setInt(2, pagesize); //ÿҳ��¼��
		this.rs = ps.executeQuery();//3��ִ�в�ѯ�����ؽ����
		while(rs.next()){
			Phone p = new Phone();
			p.setId(rs.getString("id"));
			p.setName(rs.getString("name"));
			p.setCcrq(rs.getString("ccrq"));
			p.setBrandId(rs.getInt("brandid"));
			p.setBrandPic(rs.getString("brandpic"));
			list.add(p);
		}
		this.closeAll();//�ر���Դ
		return list;
	}
	//��ѯ1���ֻ���Ϣ
	public Phone queryPhone(String id) throws Exception {
		Phone p = null;
	    this.conn = this.getConn();//1�������ݿ����Ӷ���
	    this.ps = conn.prepareStatement("select * from phone where id="+id);
	    this.rs = ps.executeQuery(); //ִ��sql���
	    if(rs.next()){
	    	p = new Phone();
	    	p.setId(rs.getString("id"));
			p.setName(rs.getString("name"));
			p.setCcrq(rs.getString("ccrq"));
			p.setBrandId(rs.getInt("brandid"));
			p.setBrandPic(rs.getString("brandpic"));
	    }
	    this.closeAll();//�ر���Դ
		return p;
	}

}
