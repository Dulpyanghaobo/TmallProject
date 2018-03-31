package xyz.dulpyhb.tmall_ssm.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class tmallTest {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	try(
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/tmall_ssm?useUnicode=true&characterEncoding=utf8","root","19971104yhb");
			Statement stat = conn.createStatement();
			){
		for(int i =0 ;i<=10;i++) {
			String sqlFormat ="insert into category values(null,'测试分类%d')";
			String sql = String.format(sqlFormat, i);
			stat.execute(sql);
		}
		System.out.println("已经成功创建了10条分类测试数据");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
