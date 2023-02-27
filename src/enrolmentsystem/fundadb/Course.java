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
public class Course {

	private static DBConnect database = new DBConnect();

	public static void AddCourse(int id, String code, String description, int units, String schedule) {
		try {

			String query = String.format("CALL addCourse(%d, '%s', '%s', %d, '%s')", id, code, description, units, schedule);
			database.statement.executeUpdate(query);

			String title = "Insert Successful";
			String message = String.format("Course #%d has been inserted to the database", id);
			JOptionPane.showMessageDialog((Component) null, message, title, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			System.out.println("\nERROR: Failed to add course!\n");
			JOptionPane.showMessageDialog((Component) null, "Failed to insert course to the database", "Insert Failed", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void UpdateCourse(int id, String code, String description, int units, String schedule) {
		try {
			String query = String.format("CALL updateCourse(%d, '%s', '%s', %d, '%s')", id, code, description, units, schedule);
			database.statement.executeUpdate(query);

			String title = "Update Successful";
			String message = String.format("Entry for course #%d has been updated", id);
			JOptionPane.showMessageDialog((Component) null, message, title, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			System.out.println("\nERROR: Failed to update course entry!\n");
			JOptionPane.showMessageDialog((Component) null, "Failed to update entry", "Update Failed", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void DeleteCourse(String courseId) {
		try {
			int id = Integer.parseInt(courseId);
			String query = String.format("DELETE FROM courses WHERE id=%d", id);
			database.statement.executeUpdate(query);

			String title = "Delete Successful";
			String message = String.format("Course #%d has been deleted from the database", id);
			JOptionPane.showMessageDialog((Component) null, message, title, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			System.out.println("\nERROR: Failed to delete course entry!\n");
			JOptionPane.showMessageDialog((Component) null, "Failed to delete course from the database", "Delete Failed", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
