package cn.leo.gjp.tools;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	
	private static BasicDataSource datasource = new BasicDataSource();
	
	static{
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("JDBC:mysql://localhost:3306/gip");
		datasource.setUsername("root");
		datasource.setPassword("root");
	}
	
	
	public static BasicDataSource getDataSource(){
		return datasource;
	}

}
