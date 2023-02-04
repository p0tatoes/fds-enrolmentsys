/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrolmentsystem.fundadb;

import java.awt.Component;
import javax.swing.JOptionPane;

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

			String title = "Insert Successful";
			String message = String.format("Student #%d has been inserted to the database", id);
			JOptionPane.showMessageDialog((Component) null, message, title, JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			System.out.println("\nERROR: Failed to add student!\n");
			JOptionPane.showMessageDialog((Component) null, "Student was not inserted to the database", "Insert failed", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void UpdateStudent(int id, String name, String address, String course, String gender, String yearLevel) {
		try {
			String query = String.format("CALL updateStudent(%d, '%s', '%s', '%s', '%s', '%s')", id, name, address, course, gender, yearLevel);
			database.statement.executeUpdate(query);

			String title = "Update Successful";
			String message = String.format("Entry for student #%d has been updated", id);
			JOptionPane.showMessageDialog((Component) null, message, title, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			System.out.println("\nERROR: Failed to update student entry!\n");
			JOptionPane.showMessageDialog((Component) null, "Student entry has not been updated", "Update failed", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * TODO: Change into a procedure that deletes entries from students AND enrol
	 * tables
	 */
	public static void DeleteStudent(String studentId) {
		try {
			int id = Integer.parseInt(studentId);
			String query = String.format("DELETE FROM students WHERE id=%d", id);
			database.statement.executeUpdate(query);

			String title = "Delete Successful";
			String message = String.format("Student #%d has been deleted from the database", id);
			JOptionPane.showMessageDialog((Component) null, message, title, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			System.out.println("\nERROR:Failed to delete student entry!\n");
			JOptionPane.showMessageDialog((Component) null, "Student entry has not been delelted from the database", "Delete failed", JOptionPane.ERROR_MESSAGE);
		}
	}

}
