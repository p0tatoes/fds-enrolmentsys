/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrolmentsystem.fundadb;

/**
 *
 * @author Marvin
 */
public class Student {

	private static DBConnect database = new DBConnect();

	public static void AddStudent(int id, String name, String address, String course, String gender, String yearLevel) {
		try {

			String query = String.format("CALL addStudent(%d, '%s', '%s', '%s', '%s', '%s')", id, name, address, course, gender, yearLevel);
			database.statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("\nERROR: Failed to add student!\n");
		}
	}

	public static void UpdateStudent(int id, String name, String address, String course, String gender, String yearLevel) {
		try {
			String query = String.format("CALL updateStudent(%d, '%s', '%s', '%s', '%s', '%s')", id, name, address, course, gender, yearLevel);
			database.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("\nERROR: Failed to update student entry!\n");
		}
	}

	public static void DeleteStudent(String studentId) {
		try {
			int id = Integer.parseInt(studentId);
			String query = String.format("DELETE FROM students WHERE id=%d", id);
			database.statement.executeUpdate(query);
		} catch (Exception e) {
			System.err.println("\nERROR:Failed to delete student entry!\n");
		}
	}

}
