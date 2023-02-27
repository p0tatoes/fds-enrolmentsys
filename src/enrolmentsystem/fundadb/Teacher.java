/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrolmentsystem.fundadb;

/**
 *
 * @author Marvin
 */
public class Teacher {

	DBConnect database = new DBConnect();

	// TODO: make add, update, and delete teacher procedures. Also, reformat the code since I pasted this from Students.java
	public void AddTeacher(int id, String name, String address, String course, String gender, String yearLevel) {
		try {

			String query = String.format("CALL addStudent(%d, '%s', '%s', '%s', '%s', '%s')", id, name, address, course, gender, yearLevel);
			database.statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("\nERROR: Failed to add teacher!\n");
		}
	}

	// TODO: make add, update, and delete teacher procedures. Also, reformat the code since I pasted this from Students.java
	public void UpdateTeacher(int id, String name, String address, String course, String gender, String yearLevel) {
		try {
			String query = String.format("CALL updateStudent(%d, '%s', '%s', '%s', '%s', '%s')", id, name, address, course, gender, yearLevel);
			database.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("\nERROR:Failed to update teacher entry!\n");
		}
	}

}
