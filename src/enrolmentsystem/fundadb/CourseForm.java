/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package enrolmentsystem.fundadb;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marvin
 */
public class CourseForm extends javax.swing.JFrame {

	/**
	 * Creates new form StudentForm
	 */
	public CourseForm() {
		initComponents();
	}

	/**
	 * My additions
	 */
	DBConnect database = new DBConnect();

	private String courseId;

	void showCourses() {
		try {

			DefaultTableModel tblCoursesModel = (DefaultTableModel) tblCourses.getModel();
			tblCoursesModel.setRowCount(0);

			String query = "CALL getCourses()";
			database.result = database.statement.executeQuery(query);

			while (database.result.next()) {
				String id = database.result.getString(1);
				String code = database.result.getString(2);
				String description = database.result.getString(3);
				String units = database.result.getString(4);
				String schedule = database.result.getString(5);
				String totalEnroled = database.result.getString(6);

				String[] course = {id, code, description, units, schedule, totalEnroled};
				tblCoursesModel.addRow(course);
			}

		} catch (Exception e) {
			System.out.println("\nERROR: Failed to show courses\n");
		}
	}

	void showEnroledStudents() {
		try {

			DefaultTableModel tblStudentsModel = (DefaultTableModel) tblStudents.getModel();
			tblStudentsModel.setRowCount(0);

			String query = String.format("CALL getClassList(%s)", courseId);
			database.result = database.statement.executeQuery(query);

			while (database.result.next()) {
				String id = database.result.getString(1);
				String name = database.result.getString(2);
				String address = database.result.getString(3);
				String course = database.result.getString(4);
				String gender = database.result.getString(5);
				String yearLevel = database.result.getString(6);

				String[] student = {id, name, address, course, gender, yearLevel};
				tblStudentsModel.addRow(student);
			}

		} catch (Exception e) {
			System.out.println("\nERROR: Failed to show enrolled subjects\n");
		}
	}

	private int confirmation(String message) {
		// Confirm popup; asks if you would like to confirm dropping or adding a subject
		int result = JOptionPane.showConfirmDialog((Component) null, message, "alert", JOptionPane.OK_CANCEL_OPTION);
		return result; // returns 0 if you press "OK"; returns 1 if you press "CANCEL"
	}

	/**
	 * End of my additions
	 */
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jMenuItem1 = new javax.swing.JMenuItem();
    jMenuItem2 = new javax.swing.JMenuItem();
    jMenuBar2 = new javax.swing.JMenuBar();
    jMenu2 = new javax.swing.JMenu();
    jMenu3 = new javax.swing.JMenu();
    jMenuItem3 = new javax.swing.JMenuItem();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    inputSchedule = new javax.swing.JTextField();
    inputUnits = new javax.swing.JTextField();
    inputDescription = new javax.swing.JTextField();
    inputCode = new javax.swing.JTextField();
    inputId = new javax.swing.JTextField();
    btnAdd = new javax.swing.JButton();
    btnUpdate = new javax.swing.JButton();
    btnDelete = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblCourses = new javax.swing.JTable();
    jScrollPane2 = new javax.swing.JScrollPane();
    tblStudents = new javax.swing.JTable();
    jPanel3 = new javax.swing.JPanel();

    jMenuItem1.setText("jMenuItem1");

    jMenuItem2.setText("jMenuItem2");

    jMenu2.setText("File");
    jMenuBar2.add(jMenu2);

    jMenu3.setText("Edit");
    jMenuBar2.add(jMenu3);

    jMenuItem3.setText("jMenuItem3");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("EnrolmentSys Course Form");
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setSize(new java.awt.Dimension(1300, 700));
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowOpened(java.awt.event.WindowEvent evt) {
        formWindowOpened(evt);
      }
    });

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Course Form"));

    jLabel1.setText("ID");

    jLabel2.setText("CODE");

    jLabel3.setText("DESCRIPTION");

    jLabel4.setText("UNITS");

    jLabel5.setText("SCHEDULE");

    btnAdd.setText("Add");
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAddActionPerformed(evt);
      }
    });

    btnUpdate.setText("Update");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnUpdateActionPerformed(evt);
      }
    });

    btnDelete.setText("Delete");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnDeleteActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(78, 78, 78)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel5)
              .addComponent(jLabel4)
              .addComponent(jLabel3)
              .addComponent(jLabel2)
              .addComponent(inputCode, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(inputDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(inputUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(inputSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel1)))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(118, 118, 118)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addGap(90, 90, 90))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(36, 36, 36)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(5, 5, 5)
        .addComponent(inputCode, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(2, 2, 2)
        .addComponent(inputDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(2, 2, 2)
        .addComponent(inputUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(2, 2, 2)
        .addComponent(inputSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(31, 31, 31)
        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnDelete)
        .addContainerGap(73, Short.MAX_VALUE))
    );

    tblCourses.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ID", "CODE", "DESCRIPTION", "UNITS", "SCHEDULE", "TOTAL ENROLED"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    tblCourses.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tblCoursesMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(tblCourses);

    tblStudents.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null}
      },
      new String [] {
        "ID", "NAME", "ADDRESS", "COURSE", "GENDER", "YEAR LEVEL"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    jScrollPane2.setViewportView(tblStudents);

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Filters"));

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 386, Short.MAX_VALUE)
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(26, 26, 26)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(24, 24, 24)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
          .addComponent(jScrollPane2))
        .addGap(24, 24, 24)
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(25, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jScrollPane1))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(47, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
		/**
		 * On window open
		 */
		showCourses();
  }//GEN-LAST:event_formWindowOpened

  private void tblCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCoursesMouseClicked
		/**
		 * On course table clicked
		 */
		int selectedRow = tblCourses.getSelectedRow();

		courseId = (String) tblCourses.getValueAt(selectedRow, 0);
		inputId.setText(courseId);
		StudentForm.setCourseId(courseId);

		String code = (String) tblCourses.getValueAt(selectedRow, 1);
		inputCode.setText(code);

		String description = (String) tblCourses.getValueAt(selectedRow, 2);
		inputDescription.setText(description);

		String units = (String) tblCourses.getValueAt(selectedRow, 3);
		inputUnits.setText(units);

		String schedule = (String) tblCourses.getValueAt(selectedRow, 4);
		inputSchedule.setText(schedule);

		showCourses();
		showEnroledStudents();
  }//GEN-LAST:event_tblCoursesMouseClicked

  private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
		/**
		 * Add course on click
		 */
		int id = Integer.parseInt(inputId.getText());
		String code = inputCode.getText();
		String description = inputDescription.getText();
		int units = Integer.parseInt(inputUnits.getText());
		String schedule = inputSchedule.getText();

		int option = confirmation(String.format("Insert course #%d into the database?", id));

		try {
			String query = String.format("CALL stageCourseInsert(%d, '%s', '%s', %d, '%s')", id, code, description, units, schedule);
			database.statement.executeUpdate(query);
		} catch (Exception e) {
			System.err.println(e);
		}

		if (option == 0) {
			Course.AddCourse(id, code, description, units, schedule);
		}
		showCourses();
  }//GEN-LAST:event_btnAddActionPerformed

  private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
		/**
		 * Update course on click
		 */
		int id = Integer.parseInt(inputId.getText());
		String code = inputCode.getText();
		String description = inputDescription.getText();
		int units = Integer.parseInt(inputUnits.getText());
		String schedule = inputSchedule.getText();

		int option = confirmation(String.format("Update entry for course #%d?", id));

		try {
			String query = String.format("CALL stageCourseUpdate(%d, '%s', '%s', %d, '%s')", id, code, description, units, schedule);
			database.statement.executeUpdate(query);
		} catch (Exception e) {
			System.err.println(e);
		}

		if (option == 0) {
			Course.UpdateCourse(id, code, description, units, schedule);
		}
		showCourses();
  }//GEN-LAST:event_btnUpdateActionPerformed

  private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
		/**
		 * Delete course on click
		 */
		int option = confirmation(String.format("Delete entry for Course #%s", courseId));

		try {
			String query = String.format("CALL stageCourseDelete(%s)", courseId);
			database.statement.executeUpdate(query);
		} catch (Exception e) {
			System.err.println(e);
		}

		if (option == 0) {
			Course.DeleteCourse(courseId);
		}
		showCourses();
  }//GEN-LAST:event_btnDeleteActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(CourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(CourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(CourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(CourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CourseForm().setVisible(true);
			}
		});
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAdd;
  private javax.swing.JButton btnDelete;
  private javax.swing.JButton btnUpdate;
  private javax.swing.JTextField inputCode;
  private javax.swing.JTextField inputDescription;
  private javax.swing.JTextField inputId;
  private javax.swing.JTextField inputSchedule;
  private javax.swing.JTextField inputUnits;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenuBar jMenuBar2;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTable tblCourses;
  private javax.swing.JTable tblStudents;
  // End of variables declaration//GEN-END:variables
}
