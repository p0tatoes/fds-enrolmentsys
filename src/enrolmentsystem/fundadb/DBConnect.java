/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrolmentsystem.fundadb;

import java.sql.*;

/**
 *
 * @author Marvin
 */
public class DBConnect {

	public Connection connection;
	public Statement statement;
	public ResultSet result;

	// Constructor
	public DBConnect() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://192.168.146.3:3306/enrolmentsystem?zeroDateTimeBehavior=CONVERT_TO_NULL";
			String user = "root";
			String password = "Fundadb_123";

			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

		} catch (Exception e) {
			System.out.println("\nError connecting to database!\n");

		}
	}
}
