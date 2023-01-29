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
		// TODO: add enrol functionality; add `EnrolCourse` procedure
		try {
			int studid = Integer.parseInt(studentId);
			int cid = Integer.parseInt(courseId);
			String query = String.format("CALL EnrolCourse(%d, %d, @conflict)", studid, cid);
			database.statement.executeUpdate(query);

			// TODO: add pop up message when there is conflicting schedule
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
		}
	}

	public static void DropCourse(String studentId, String courseId) {
		// TODO: add drop functionality; add `DropCourse` procedure
		try {
			int studid = Integer.parseInt(studentId);
			int cid = Integer.parseInt(courseId);
			String query = String.format("CALL DropCourse(%d, %d)", studid, cid);
			database.statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("\nERROR: Failed to drop a course!\n");
		}
	}
}
