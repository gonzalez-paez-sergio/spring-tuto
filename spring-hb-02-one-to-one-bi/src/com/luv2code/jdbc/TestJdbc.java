/**
 * 
 */
package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author sergiogp
 *
 */
public class TestJdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection connection = null;

		try {
			String jdbcURL = "jdbc:mysql://172.17.0.2:3306/hb-01-one-to-one-uni?useSSL=false";

			String user = "hbstudent";
			String pasword = "hbstudent";

			connection = DriverManager.getConnection(jdbcURL, user, pasword);

			System.out.println("ok");
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				  
				e.printStackTrace();
			}
		}
	}
}
