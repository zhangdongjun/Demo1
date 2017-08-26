package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.PhoneDao;
import com.entity.Phone;
import com.util.BaseDao;

public class PhoneDaoImpl extends BaseDao implements PhoneDao{
    //添加手机信息功能
	public int addPhone(Phone p) throws Exception {
        this.conn = this.getConn(); //1、创建数据库连接对象
        String sql="insert into phone(id,name,ccrq,brandid,brandpic)";
        sql+="values(?,?,?,?,?)";
        this.ps = conn.prepareStatement(sql);//2、创建sql语句对象
        ps.setString(1, p.getId()); //3、动态绑定参数，对？占位符位置赋值
        ps.setString(2, p.getName());
        ps.setString(3, p.getCcrq());
        ps.setInt(4, p.getBrandId());
        ps.setString(5, p.getBrandPic());
        int ret = ps.executeUpdate(); //4、执行sql语句
        this.closeAll();//5、关闭资源
		return ret;
	}
	//删除手机信息功能
	public int delPhone(String id) throws Exception {
		this.conn = this.getConn(); //1、创建数据库连接对象
        String sql="delete from phone where id="+id;
        this.ps = conn.prepareStatement(sql);//2、创建sql语句对象
        int ret = ps.executeUpdate(); //4、执行sql语句
        this.closeAll();//5、关闭资源
		return ret;
	}
	//修改手机信息功能
	public int editPhone(Phone p) throws Exception {
		this.conn = this.getConn(); //1、创建数据库连接对象
        StringBuilder sb = new StringBuilder("update phone set");
        sb.append(" name     =?,");
        sb.append(" ccrq     =?,");
        sb.append(" brandid  =?,");
        sb.append(" brandpic =? ");
        sb.append(" where id =? ");
        System.out.println(sb.toString());
        this.ps = conn.prepareStatement(sb.toString());//2、创建sql语句对象
        //3、动态绑定参数，对？占位符位置赋值
        ps.setString(1, p.getName());
        ps.setString(2, p.getCcrq());
        ps.setInt(3, p.getBrandId());
        ps.setString(4, p.getBrandPic());
        ps.setString(5, p.getId());
        int ret = ps.executeUpdate(); //4、执行sql语句
        this.closeAll();//5、关闭资源
		return ret;
	}
	//查询所有手机信息
	public List<Phone> queryPhone() throws Exception {
		List<Phone> list = new ArrayList<Phone>();
		this.conn = this.getConn(); //1、创建数据库连接对象
		String sql="select * from phone order by id desc";
		this.ps = conn.prepareStatement(sql); //2、创建预编译sql语句对象
		this.rs = ps.executeQuery();//3、执行查询，返回结果集
		while(rs.next()){
			Phone p = new Phone();
			p.setId(rs.getString("id"));
			p.setName(rs.getString("name"));
			p.setCcrq(rs.getString("ccrq"));
			p.setBrandId(rs.getInt("brandid"));
			p.setBrandPic(rs.getString("brandpic"));
			list.add(p);
		}
		this.closeAll();//关闭资源
		return list;
	}

	public List<Phone> queryPhone(int pa, int pagesize) throws Exception {
		List<Phone> list = new ArrayList<Phone>();
		this.conn = this.getConn(); //1、创建数据库连接对象
		String sql="select * from phone  order by id desc  limit ?,?";
		this.ps = conn.prepareStatement(sql); //2、创建预编译sql语句对象
		ps.setInt(1, (pa-1)*pagesize);
		ps.setInt(2, pagesize); //每页记录数
		this.rs = ps.executeQuery();//3、执行查询，返回结果集
		while(rs.next()){
			Phone p = new Phone();
			p.setId(rs.getString("id"));
			p.setName(rs.getString("name"));
			p.setCcrq(rs.getString("ccrq"));
			p.setBrandId(rs.getInt("brandid"));
			p.setBrandPic(rs.getString("brandpic"));
			list.add(p);
		}
		this.closeAll();//关闭资源
		return list;
	}
	//查询1条手机信息
	public Phone queryPhone(String id) throws Exception {
		Phone p = null;
	    this.conn = this.getConn();//1创建数据库连接对象
	    this.ps = conn.prepareStatement("select * from phone where id="+id);
	    this.rs = ps.executeQuery(); //执行sql语句
	    if(rs.next()){
	    	p = new Phone();
	    	p.setId(rs.getString("id"));
			p.setName(rs.getString("name"));
			p.setCcrq(rs.getString("ccrq"));
			p.setBrandId(rs.getInt("brandid"));
			p.setBrandPic(rs.getString("brandpic"));
	    }
	    this.closeAll();//关闭资源
		return p;
	}

}
