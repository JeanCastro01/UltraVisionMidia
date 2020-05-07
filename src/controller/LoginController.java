package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;

import model.Database;
import model.Employee;
import view.Dashboard;
import view.Login;

public class LoginController implements ActionListener {
	
	
    // This class has to have a reference to all elements of the program
    Employee model;
    Login view;
    Dashboard dash;
    String username;
    String password;
    
    // When the  controller starts, we need a new model and a new view
    public LoginController() throws ParseException{
        view = new Login(this);
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {

		username = view.getTextFieldUsernameEmployee();
		password = view.getTextFieldPasswordEmployee();


		model = new Employee(username, password);

		if (e.getActionCommand().equals("login")) {
		

			Database db = new Database();

			boolean EmployeeLogged = db.Login(model);
			 
			 
			if (EmployeeLogged ==true ) {
				
			    dash = new Dashboard(username);
			    
                 view.setVisible(false);
 
			}
				
			else {
				
				JOptionPane.showMessageDialog(null, "Please make sure textfield is not empty or username and password are correct!");
			}
			
			}
		}

	}

    




