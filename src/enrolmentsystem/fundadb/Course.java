/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrolmentsystem.fundadb;

/**
 *
 * @author Marvin
 */
public class Course {

	private static DBConnect database = new DBConnect();

	public static void AddCourse(int id, String code, String description, int units, String schedule) {
		try {

			String query = String.format("CALL addCourse(%d, '%s', '%s', %d, '%s')", id, code, description, units, schedule);
			database.statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("\nERROR: Failed to add course!\n");
		}
	}

	public static void UpdateCourse(int id, String code, String description, int units, String schedule) {
		try {
			String query = String.format("CALL updateCourse(%d, '%s', '%s', %d, '%s')", id, code, description, units, schedule);
			database.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("\nERROR: Failed to update course entry!\n");
			System.out.println(e);
		}
	}

}
