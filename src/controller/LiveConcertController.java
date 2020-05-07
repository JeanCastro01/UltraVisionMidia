package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;

import model.Database;
import model.LiveConcert;
import view.NewLiveConcert;

public class LiveConcertController implements ActionListener {

	NewLiveConcert view;
	boolean allTrue=false;
	boolean allFalse=false;

	// When the controller starts, we need a new model and a new view
	public LiveConcertController() throws ParseException {

		view = new NewLiveConcert(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String yearOfRelease = view.getFormattedTextFieldYearOfRelease();
		String title = view.getTextFieldTitle();
		String genre = view.getComboBoxGenre();
		double Price = view.getComboBoxLiveConcertPrice();
		String Type = view.getComboBoxTypeLiveConcert();
		String Band = view.getTextFieldBand();

		LiveConcert liveconcert = new LiveConcert(yearOfRelease, title, genre, Price, Type, Band);

		if (e.getActionCommand().equals("Register")) {

			Database db = new Database();

			boolean liveconcertRegistered = db.newliveconcert(liveconcert);

			if (liveconcertRegistered !=false) {

				JOptionPane.showMessageDialog(null, "Submited");
				view.dispose();
		
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "Make sure Fields are not empty");
				
			}

		}

	}
}
