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
public class Enrol {

	private static DBConnect database = new DBConnect();

	public static void EnrolCourse(String studentId, String courseId) {
		try {
			int studid = Integer.parseInt(studentId);
			int cid = Integer.parseInt(courseId);
			String query = String.format("CALL EnrolCourse(%d, %d, @conflict)", studid, cid);
			database.statement.executeUpdate(query);

			database.result = database.statement.executeQuery("SELECT @conflict");
			if (database.result.next()) {
				String conflict = database.result.getString(1);
				if (database.result.wasNull()) {
					JOptionPane.showMessageDialog((Component) null, "Course has been enroled", "Enrolment Successful", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog((Component) null, String.format("Schedule conflicting with: %s", conflict), "Enrolment Failed", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			System.out.println("\nERROR: Failed to enrol a course!\n");
			JOptionPane.showMessageDialog((Component) null, "Failed to enrol course", "Enrol failed", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void DropCourse(String studentId, String courseId) {
		try {
			int studid = Integer.parseInt(studentId);
			int cid = Integer.parseInt(courseId);
			String query = String.format("CALL DropCourse(%d, %d)", studid, cid);
			database.statement.executeUpdate(query);

			String title = "Drop Successful";
			String message = String.format("Course #%d has been dropped for student #%d", cid, studid);
			JOptionPane.showMessageDialog((Component) null, message, title, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			System.out.println("\nERROR: Failed to drop a course!\n");
			System.err.println(e);
			JOptionPane.showMessageDialog((Component) null, "Failed to drop course", "Drop Failed", JOptionPane.ERROR_MESSAGE);
		}
	}
}
