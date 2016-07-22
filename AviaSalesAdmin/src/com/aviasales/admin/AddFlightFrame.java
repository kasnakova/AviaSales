package com.aviasales.admin;

import com.aviasales.data.StorageAdapter;
import com.aviasales.models.Flight;
import com.aviasales.ui.MessageBoxes;
import com.aviasales.utilities.UserInputValidator;
import com.aviasales.utilities.Utils;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Admin panel for adding flights
 * 
 * @author Liza
 */
public class AddFlightFrame extends javax.swing.JFrame {

	/**
	 * Creates new form AddFlightsForm
	 */
	public AddFlightFrame() {
		initComponents();
		txtArrivalTime.setText(Utils.parseDateTimeToString(LocalDateTime.now()));
		txtDepartureTime.setText(Utils.parseDateTimeToString(LocalDateTime.now()));
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

		jLabel2 = new javax.swing.JLabel();
		txtCost = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		txtFreePlaces = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txtDepartureAirPort = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		txtArrivalAirport = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		txtDepartureTime = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		txtArrivalTime = new javax.swing.JTextField();
		btnAdd = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Add flight");
		setBounds(new java.awt.Rectangle(0, 0, 350, 350));
		setResizable(false);

		jLabel2.setText("Cost");

		txtCost.setText("123");

		jLabel3.setText("Free places");

		txtFreePlaces.setText("120");

		jLabel4.setText("Departure airport");

		txtDepartureAirPort.setText("Kazan");

		jLabel5.setText("Arrival airport");

		txtArrivalAirport.setText("Moscow");

		jLabel6.setText("Departure Time");

		txtDepartureTime.setToolTipText("Format: day/month/year HH:mm");

		jLabel7.setText("Arrival Time");

		txtArrivalTime.setToolTipText("Format: day/month/year HH:mm");

		btnAdd.setText("Add");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3).addComponent(jLabel2))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(btnAdd)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel5).addComponent(jLabel6))
																.addGap(21, 21, 21))
												.addGroup(layout.createSequentialGroup().addComponent(jLabel7)
														.addGap(41, 41, 41))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup().addComponent(jLabel4)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(txtDepartureTime, javax.swing.GroupLayout.DEFAULT_SIZE,
														175, Short.MAX_VALUE)
												.addComponent(txtDepartureAirPort,
														javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txtFreePlaces, javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txtCost).addComponent(txtArrivalAirport)
												.addComponent(txtArrivalTime))))
								.addGap(0, 46, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3)
						.addComponent(txtFreePlaces, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4)
						.addComponent(txtDepartureAirPort, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel5)
						.addComponent(txtArrivalAirport, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6)
						.addComponent(txtDepartureTime, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7)
						.addComponent(txtArrivalTime, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(btnAdd)
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}// </editor-fold>//GEN-END:initComponents

	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
		long number = System.currentTimeMillis();
		String costStr = txtCost.getText();
		String freePlacesStr = txtFreePlaces.getText();
		String depAirportStr = txtDepartureAirPort.getText();
		String arrAirportStr = txtArrivalAirport.getText();
		String departureTimeStr = txtDepartureTime.getText();
		String arrivalTimeStr = txtArrivalTime.getText();
		if (!UserInputValidator.isCostValid(costStr)) {
			MessageBoxes.showInvalidInputMessageBox(this, "Please enter a valid cost for the flight.");
		} else if (!UserInputValidator.isPersonCountValid(freePlacesStr)) {
			MessageBoxes.showInvalidInputMessageBox(this, "Please enter a valid count for free places on the lfight.");
		} else if (UserInputValidator.isNullOrEmpty(depAirportStr)) {
			MessageBoxes.showInvalidInputMessageBox(this, "Please enter a valid departure airport.");
		} else if (UserInputValidator.isNullOrEmpty(arrAirportStr)) {
			MessageBoxes.showInvalidInputMessageBox(this, "Please enter a valid arrival airport.");
		} else if (!UserInputValidator.isDateTimeValid(departureTimeStr)) {
			MessageBoxes.showInvalidInputMessageBox(this,
					"Please enter a valid departure date and time in the described format and one that hadn't passed already.");
		} else if (!UserInputValidator.isDateTimeValid(arrivalTimeStr)) {
			MessageBoxes.showInvalidInputMessageBox(this,
					"Please enter a valid arrival date and time in the described format and one that hadn't passed already.");
		} else {
			LocalDateTime depDateTime = Utils.parseToLocalDateTime(departureTimeStr);
			LocalDateTime arrDateTime = Utils.parseToLocalDateTime(arrivalTimeStr);
			if (depDateTime.compareTo(arrDateTime) >= 0) {
				MessageBoxes.showInvalidInputMessageBox(this, "Departure time must be before arrival time.");
				return;
			}

			double cost = Double.parseDouble(costStr);
			int numberOfFreePlaces = Integer.parseInt(freePlacesStr);
			Flight flight = new Flight(String.valueOf(number), depAirportStr, arrAirportStr, depDateTime, arrDateTime,
					cost, numberOfFreePlaces);
			if (StorageAdapter.addFlight(flight)) {
				MessageBoxes.showSuccessMessageBox(this, "Your flight was successfully added");
			} else {
				MessageBoxes.showErrorMessageBox(this, "Sorry, something went wrong and your flight was not saved.");
			}
		}
	}// GEN-LAST:event_btnAddActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnAdd;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JTextField txtArrivalAirport;
	private javax.swing.JTextField txtArrivalTime;
	private javax.swing.JTextField txtCost;
	private javax.swing.JTextField txtDepartureAirPort;
	private javax.swing.JTextField txtDepartureTime;
	private javax.swing.JTextField txtFreePlaces;
	// End of variables declaration//GEN-END:variables
}
