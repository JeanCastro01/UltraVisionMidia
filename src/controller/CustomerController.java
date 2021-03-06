package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;
import model.Customer;
import model.Database;
import view.Dashboard;
import view.NewCustomer;

/**
 * this is the controller for the Customer which also implements ActionListemner 
 * @author jeancastro
 *
 */
public class CustomerController implements ActionListener {

	Customer model;
	NewCustomer view;
	String firstname;
	String lastname;
	String email;
	String tel;
	String membership;
	String cardnumber;
	Database db = new Database();
	boolean newcustomerRegistered;
	boolean valid = false;

	/**
	 * this constructor for the customer controller
	 * 
	 * @throws ParseException
	 */
	// When the controller starts, we need a new model and a new view
	public CustomerController() throws ParseException {

		view = new NewCustomer(this);

	}

	/**
	 * this methos is to get data from the newcustomer frame and passing newcustomerRegistered as parameter to the DB unless the action is performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		firstname = view.getTextFieldFirstName();
		lastname = view.getTextFieldLastName();
		email = view.getTextFieldEmail();
		tel = view.getFormattedTextFieldTelephone();
		membership = view.getComboBoxMembership();
		cardnumber = view.getFormattedTextFieldCardNumber();

		model = new Customer(firstname, lastname, email, membership, tel, cardnumber);

		if (e.getActionCommand().equals("Register")) {

			newcustomerRegistered = db.newcustomer(model); // passing the data to the method in the database class if true, return the data

			if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || tel.isEmpty() || cardnumber.isEmpty()
					|| membership.isEmpty()) {

				JOptionPane.showMessageDialog(null, "Make Sure Fields are not Empty");

			}

			else {

				db.newcustomerCard(model);
				JOptionPane.showMessageDialog(null, "Submited");
				view.dispose();

			}
		}
	}
}
