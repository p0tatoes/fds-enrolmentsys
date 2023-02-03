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
public class StudentForm extends javax.swing.JFrame {

	/**
	 * Creates new form StudentForm
	 */
	public StudentForm() {
		initComponents();
	}

	/**
	 * My additions
	 */
	DBConnect database = new DBConnect();
	CourseForm courseForm = new CourseForm();

	private static String studentId;
	private static String courseId;

	public static void setStudentId(String id) {
		studentId = id;
	}

	public static void setCourseId(String id) {
		courseId = id;
	}

	private void showStudents() {
		try {

			DefaultTableModel tblStudentsModel = (DefaultTableModel) tblStudents.getModel();
			tblStudentsModel.setRowCount(0);

			String query = "CALL getStudents()";
			database.result = database.statement.executeQuery(query);

			while (database.result.next()) {
				String id = database.result.getString(1);
				String name = database.result.getString(2);
				String address = database.result.getString(3);
				String course = database.result.getString(4);
				String gender = database.result.getString(5);
				String yearLevel = database.result.getString(6);
				String totalUnits = database.result.getString(7);

				String[] student = {id, name, address, course, gender, yearLevel, totalUnits};
				tblStudentsModel.addRow(student);
			}

		} catch (Exception e) {
			System.out.println("\nERROR: Failed to show students\n");
		}
	}

	private void showEnroledSubjects() {
		try {

			DefaultTableModel tblCoursesModel = (DefaultTableModel) tblCourses.getModel();
			tblCoursesModel.setRowCount(0);

			String query = String.format("CALL getEnroledSubjects(%s)", studentId);
			database.result = database.statement.executeQuery(query);

			while (database.result.next()) {
				String id = database.result.getString(1);
				String code = database.result.getString(2);
				String description = database.result.getString(3);
				String units = database.result.getString(4);
				String schedule = database.result.getString(5);

				String[] course = {id, code, description, units, schedule};
				tblCoursesModel.addRow(course);
			}

		} catch (Exception e) {
			System.out.println("\nERROR: Failed to show enrolled subjects\n");
		}
	}

	private int messageBox(String message, String title) {
		// Message popup
		JOptionPane.showMessageDialog((Component) null, message, title, JOptionPane.INFORMATION_MESSAGE);
		return 0;
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
    jLabel6 = new javax.swing.JLabel();
    inputYear = new javax.swing.JTextField();
    inputGender = new javax.swing.JTextField();
    inputCourse = new javax.swing.JTextField();
    inputAddress = new javax.swing.JTextField();
    inputName = new javax.swing.JTextField();
    inputId = new javax.swing.JTextField();
    btnAdd = new javax.swing.JButton();
    btnUpdate = new javax.swing.JButton();
    btnDelete = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    btnDrop = new javax.swing.JButton();
    btnEnrol = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblStudents = new javax.swing.JTable();
    jScrollPane2 = new javax.swing.JScrollPane();
    tblCourses = new javax.swing.JTable();
    jPanel3 = new javax.swing.JPanel();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem4 = new javax.swing.JMenuItem();
    jMenuItem5 = new javax.swing.JMenuItem();

    jMenuItem1.setText("jMenuItem1");

    jMenuItem2.setText("jMenuItem2");

    jMenu2.setText("File");
    jMenuBar2.add(jMenu2);

    jMenu3.setText("Edit");
    jMenuBar2.add(jMenu3);

    jMenuItem3.setText("jMenuItem3");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("EnrolmentSys Student Form");
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setMaximumSize(new java.awt.Dimension(1300, 700));
    setSize(new java.awt.Dimension(1300, 700));
    addWindowFocusListener(new java.awt.event.WindowFocusListener() {
      public void windowGainedFocus(java.awt.event.WindowEvent evt) {
        formWindowGainedFocus(evt);
      }
      public void windowLostFocus(java.awt.event.WindowEvent evt) {
      }
    });
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowOpened(java.awt.event.WindowEvent evt) {
        formWindowOpened(evt);
      }
    });

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Student Form"));

    jLabel1.setText("ID");

    jLabel2.setText("NAME");

    jLabel3.setText("ADDRESS");

    jLabel4.setText("COURSE");

    jLabel5.setText("GENDER");

    jLabel6.setText("YEAR LEVEL");

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
              .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(inputAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(inputCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(inputGender, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(inputYear, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel6)
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
        .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(2, 2, 2)
        .addComponent(inputAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(2, 2, 2)
        .addComponent(inputCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(2, 2, 2)
        .addComponent(inputGender, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel6)
        .addGap(2, 2, 2)
        .addComponent(inputYear, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnDelete)
        .addContainerGap(73, Short.MAX_VALUE))
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Subject Enrolment"));

    btnDrop.setText("Drop");
    btnDrop.setPreferredSize(new java.awt.Dimension(15, 15));
    btnDrop.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnDropActionPerformed(evt);
      }
    });

    btnEnrol.setText("Enrol");
    btnEnrol.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEnrolActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(106, 106, 106)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(btnEnrol, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(110, 110, 110))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(24, 24, 24)
        .addComponent(btnEnrol, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(31, Short.MAX_VALUE))
    );

    tblStudents.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ID", "NAME", "ADDRESS", "COURSE", "GENDER", "YEAR LEVEL", "TOTAL UNITS"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    tblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tblStudentsMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(tblStudents);

    tblCourses.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null}
      },
      new String [] {
        "ID", "CODE", "DESCRIPTION", "UNITS", "SCHEDULE"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
    jScrollPane2.setViewportView(tblCourses);

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

    jMenu1.setText("Window");

    jMenuItem4.setText("Courses");
    jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem4ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem4);

    jMenuItem5.setText("Teachers");
    jMenu1.add(jMenuItem5);

    jMenuBar1.add(jMenu1);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(26, 26, 26)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(24, 24, 24)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
          .addComponent(jScrollPane2))
        .addGap(24, 24, 24)
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(29, Short.MAX_VALUE))
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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        .addContainerGap(12, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnEnrolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnrolActionPerformed
		/**
		 * Enrol course to student enrolment
		 */
		int option = confirmation(String.format("Enrol Course #%s to Student #%s?", courseId, studentId));
		if (option == 0) {
			Enrol.EnrolCourse(studentId, courseId);
		}
		showStudents();
		showEnroledSubjects();
  }//GEN-LAST:event_btnEnrolActionPerformed

  private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
		/**
		 * On window open
		 */
		showStudents();
  }//GEN-LAST:event_formWindowOpened

  private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
		/**
		 * Open CourseForm
		 */
		courseForm.setVisible(true);
  }//GEN-LAST:event_jMenuItem4ActionPerformed

  private void tblStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsMouseClicked
		/**
		 * On student table clicked
		 */
		int selectedRow = tblStudents.getSelectedRow();

		studentId = (String) tblStudents.getValueAt(selectedRow, 0);
		inputId.setText(studentId);

		String name = (String) tblStudents.getValueAt(selectedRow, 1);
		inputName.setText(name);

		String address = (String) tblStudents.getValueAt(selectedRow, 2);
		inputAddress.setText(address);

		String course = (String) tblStudents.getValueAt(selectedRow, 3);
		inputCourse.setText(course);

		String gender = (String) tblStudents.getValueAt(selectedRow, 4);
		inputGender.setText(gender);

		String yearLevel = (String) tblStudents.getValueAt(selectedRow, 5);
		inputYear.setText(yearLevel);

		showEnroledSubjects();

  }//GEN-LAST:event_tblStudentsMouseClicked

  private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
		/**
		 * Add student on click
		 */
		int id = Integer.parseInt(inputId.getText());
		String name = inputName.getText();
		String address = inputAddress.getText();
		String course = inputCourse.getText();
		String gender = inputGender.getText();
		String yearLevel = inputYear.getText();

		Student.AddStudent(id, name, address, course, gender, yearLevel);
		showStudents();
  }//GEN-LAST:event_btnAddActionPerformed

  private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
		/**
		 * Update student on click
		 */
		int id = Integer.parseInt(inputId.getText());
		String name = inputName.getText();
		String address = inputAddress.getText();
		String course = inputCourse.getText();
		String gender = inputGender.getText();
		String yearLevel = inputYear.getText();

		Student.UpdateStudent(id, name, address, course, gender, yearLevel);
		showStudents();
  }//GEN-LAST:event_btnUpdateActionPerformed

  private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
		/**
		 * Delete student on click
		 */
		Student.DeleteStudent(studentId);
		showStudents();
  }//GEN-LAST:event_btnDeleteActionPerformed

  private void btnDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDropActionPerformed
		/**
		 * Drop course from student enrolment
		 */
		int option = confirmation(String.format("Drop Course #%s for Student #%s?", courseId, studentId));
		if (option == 0) {
			Enrol.DropCourse(studentId, courseId);
			messageBox("Course had been dropped!", "Drop Successful");
		}
		showStudents();
		showEnroledSubjects();
  }//GEN-LAST:event_btnDropActionPerformed

  private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
		courseForm.setVisible(false);
  }//GEN-LAST:event_formWindowGainedFocus

  private void tblCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCoursesMouseClicked
		// TODO add your handling code here:
		int selectedRow = tblCourses.getSelectedRow();
		courseId = (String) tblCourses.getValueAt(selectedRow, 0);
  }//GEN-LAST:event_tblCoursesMouseClicked

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
			java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new StudentForm().setVisible(true);
			}
		});
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAdd;
  private javax.swing.JButton btnDelete;
  private javax.swing.JButton btnDrop;
  private javax.swing.JButton btnEnrol;
  private javax.swing.JButton btnUpdate;
  private javax.swing.JTextField inputAddress;
  private javax.swing.JTextField inputCourse;
  private javax.swing.JTextField inputGender;
  private javax.swing.JTextField inputId;
  private javax.swing.JTextField inputName;
  private javax.swing.JTextField inputYear;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuBar jMenuBar2;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem3;
  private javax.swing.JMenuItem jMenuItem4;
  private javax.swing.JMenuItem jMenuItem5;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTable tblCourses;
  private javax.swing.JTable tblStudents;
  // End of variables declaration//GEN-END:variables
}
