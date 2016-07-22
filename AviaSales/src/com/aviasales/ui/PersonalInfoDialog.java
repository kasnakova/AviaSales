/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviasales.ui;

import com.aviasales.data.StorageAdapter;
import com.aviasales.models.Person;
import com.aviasales.models.Route;
import com.aviasales.utilities.UserInputValidator;
import com.aviasales.utilities.Utils;
import java.awt.Window;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Liza
 */
public class PersonalInfoDialog extends javax.swing.JPanel {
	private Person personalInfo;
	private boolean isInfoSaved = false;

	/**
	 * Creates new form PersonalInfoFrame
	 */
	public PersonalInfoDialog(Route route) {
		initComponents();
		lblRoute.setText(route.toString());
	}

	public Person getPesonalInfo() {
		return personalInfo;
	}

	public boolean isInfoSaved() {
		return isInfoSaved;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		txtEmail = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		txtFirstName = new javax.swing.JTextField();
		btnDone = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		txtLastName = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txtPassportNumber = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		txtBirthday = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		txtPhoneNumber = new javax.swing.JTextField();
		lblRoute = new javax.swing.JLabel();

		txtEmail.setText("maria@abv.bg");
		txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent evt) {
				txtEmailFocusLost(evt);
			}
		});

		jLabel2.setText("First name:");

		btnDone.setText("Done");
		btnDone.setToolTipText("");
		btnDone.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDoneActionPerformed(evt);
			}
		});

		jLabel3.setText("Last name:");

		jLabel4.setText("Passport number:");

		jLabel5.setText("Birthday:");

		txtBirthday.setToolTipText("Format: day/month/year");

		jLabel6.setText("Phone number:");

		jLabel1.setText("E-mail:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3).addComponent(jLabel2))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lblRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 286,
												javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70,
														Short.MAX_VALUE)
												.addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 175,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel5).addComponent(jLabel6))
																.addGap(21, 21, 21))
												.addGroup(layout.createSequentialGroup().addComponent(jLabel4)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(txtPhoneNumber,
																javax.swing.GroupLayout.DEFAULT_SIZE, 175,
																Short.MAX_VALUE)
														.addComponent(txtPassportNumber,
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(txtLastName,
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(txtFirstName).addComponent(txtBirthday)))
										.addComponent(btnDone)))
								.addGap(0, 18, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap()
						.addComponent(lblRoute, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(txtFirstName,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4).addComponent(txtPassportNumber,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel5).addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6).addComponent(txtPhoneNumber,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18).addComponent(btnDone).addGap(41, 41, 41)));
	}// </editor-fold>//GEN-END:initComponents

	private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDoneActionPerformed
		String email = txtEmail.getText();
		String firstName = txtFirstName.getText();
		String lastName = txtLastName.getText();
		String passportNumber = txtPassportNumber.getText();
		String birthday = txtBirthday.getText();
		String phoneNumber = txtPhoneNumber.getText();

		if (!UserInputValidator.isEmailValid(email)) {
			MessageBoxes.showInvalidInputMessageBox(this, "Please enter a valid email address.");
		} else if (UserInputValidator.isNullOrEmpty(firstName)) {
			MessageBoxes.showInvalidInputMessageBox(this, "Please enter your  first name.");
		} else if (UserInputValidator.isNullOrEmpty(lastName)) {
			MessageBoxes.showInvalidInputMessageBox(this, "Please enter your last name.");
		} else if (UserInputValidator.isNullOrEmpty(passportNumber)) {
			MessageBoxes.showInvalidInputMessageBox(this, "Please enter a valid passport number.");
		} else if (!UserInputValidator.isBirthdayValid(birthday)) {
			MessageBoxes.showInvalidInputMessageBox(this,
					"Please enter a valid birthday in the described format and one that is not in the future.");
		} else if (!UserInputValidator.isPhoneNumberValid(phoneNumber)) {
			MessageBoxes.showInvalidInputMessageBox(this, "Please enter a valid phone number.");
		} else {
			int choice = JOptionPane.showConfirmDialog(this,
					"Please double check your information. You won't be able to change it afterwards.",
					"Do you want to continue?", JOptionPane.YES_NO_OPTION);
			if (choice == 0) {
				personalInfo = new Person(firstName, lastName, passportNumber, Utils.parseToLocalDate(birthday), email,
						phoneNumber);
				Window win = SwingUtilities.getWindowAncestor(this);
				if (win != null) {
					win.dispose();
				}
			}
		}
	}// GEN-LAST:event_btnDoneActionPerformed

	private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtEmailFocusLost
		if (UserInputValidator.isEmailValid(txtEmail.getText())) {
			Person person = StorageAdapter.getPersonByEmail(txtEmail.getText());
			if (person != null) {
				txtBirthday.setText(Utils.parseDateToString(person.getBirthDay()));
				txtFirstName.setText(person.getFirstName());
				txtLastName.setText(person.getSerName());
				txtPassportNumber.setText(person.getPassportNumber());
				txtPhoneNumber.setText(person.getPhoneNumber());
				isInfoSaved = true;
			} else {
				isInfoSaved = false;
			}
		}
	}// GEN-LAST:event_txtEmailFocusLost

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnDone;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel lblRoute;
	private javax.swing.JTextField txtBirthday;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtFirstName;
	private javax.swing.JTextField txtLastName;
	private javax.swing.JTextField txtPassportNumber;
	private javax.swing.JTextField txtPhoneNumber;
	// End of variables declaration//GEN-END:variables
}