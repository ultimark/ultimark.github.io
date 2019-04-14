package jp.co.ultimark.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Database {
	
	/**
	 * データベースオブジェクトとの接続を確立する。
	 * @return
	 * @throws SQLException
	 * @throws NamingException
	 */
	public Connection connect() throws SQLException, NamingException {
		Connection conn = null;
		try {
			// JNDIよりConnection取得
			DataSource dataSource = InitialContext.doLookup("java:comp/env/jdbc/oracle");
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
		} catch (NamingException e) {
			// DriverManageよりConnection取得
			String url = "jdbc:oracle:thin:@ulti-serv2:1521:ultidb1";
			String user = "DWH_SZ";
			String password = "DWH_SZ";
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
		}
		return conn;
	}
}