package view;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;

import controller.CustomerController;
import controller.EmployeeController;
import controller.LiveConcertController;

import controller.MovieController;
import controller.MusicLiveController;
import controller.TVBoxController;

import model.Employee;

import javax.swing.JMenuItem;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Rectangle;

/**
 * this class is the dashboard for the employee after logged in which implements ActionListener
 * @author jeancastro
 *
 */

public class Dashboard extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JFrame dashboard;

	/**
	 * Create the frame.
	 * @param username 
	 */
	public Dashboard(String username) {

		dashboard = new JFrame();

		dashboard.setTitle("Ulta Vision Midia");
		dashboard.setVisible(true);
		// dashboard.setLocationRelativeTo(contentPane);
		dashboard.setResizable(false);

		contentPane = new JPanel();
		dashboard.setContentPane(contentPane);
		contentPane.setBackground(Color.BLACK);
		dashboard.setSize(new Dimension(800, 600));
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Dashboard.class.getResource("/imagens/ULtrAVISION.png")));
		lblNewLabel_1.setBounds(149, 48, 565, 360);
		contentPane.add(lblNewLabel_1);

		contentPane = new JPanel();
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("ProgressBar.foreground"));
		panel.setBounds(64, 6, 629, 437);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/imagens/ULtrAVISION.png")));
		panel.add(lblNewLabel);
		// contentPane.add(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		dashboard.setJMenuBar(menuBar);
		// contentPane.add(menuBar);

		JMenu JMenuRent = new JMenu("Rent");
		JMenuRent.setBackground(Color.WHITE);
		JMenuRent.setIcon(new ImageIcon(Dashboard.class.getResource("/imagens/homepage2-removebg-preview.png")));
		menuBar.add(JMenuRent);
		// contentPane.add(JMenuRent);

		JMenuItem MenuItemMusicLive = new JMenuItem("Music Live");
		JMenuRent.add(MenuItemMusicLive);
		MenuItemMusicLive.addActionListener(this);
		MenuItemMusicLive.setActionCommand("Music Live");

		// contentPane.add(MenuItemMusicLive);

		JMenuItem MenuItemMovie = new JMenuItem("Movie");
		JMenuRent.add(MenuItemMovie);
		MenuItemMovie.addActionListener(this);
		MenuItemMovie.setActionCommand("Movie");

		// contentPane.add(MenuItemMovie);

		JMenuItem MenuItemTVBox = new JMenuItem("TVBox");
		JMenuRent.add(MenuItemTVBox);
		MenuItemTVBox.addActionListener(this);
		MenuItemTVBox.setActionCommand("TVBox");
		// contentPane.add(MenuItemTVBox);

		JMenuItem JMenuItemLiveConcert = new JMenuItem("Live Concert");
		JMenuRent.add(JMenuItemLiveConcert);
		JMenuItemLiveConcert.addActionListener(this);
		JMenuItemLiveConcert.setActionCommand("Live Concert");
		// contentPane.add(JMenuItemLiveConcert);

		JMenu JMenuRegister = new JMenu("Register");
		JMenuRegister.setBackground(Color.WHITE);
		menuBar.add(JMenuRegister);
		// contentPane.add(JMenuRegister);

		JMenuItem JMenuItemNewCustomer = new JMenuItem("New Customer");
		JMenuRegister.add(JMenuItemNewCustomer);
		JMenuItemNewCustomer.setActionCommand("New Customer");
		JMenuItemNewCustomer.addActionListener(this);

		JMenuItem JMenuItemNewMusicLive = new JMenuItem("New MusicLive");
		JMenuRegister.add(JMenuItemNewMusicLive);
		JMenuItemNewMusicLive.addActionListener(this);
		JMenuItemNewMusicLive.setActionCommand("New MusicLive");

		JMenuItem JMenuItemNewMovie = new JMenuItem("New Movie");
		JMenuRegister.add(JMenuItemNewMovie);
		JMenuItemNewMovie.addActionListener(this);
		JMenuItemNewMovie.setActionCommand("New Movie");
		// contentPane.add(JMenuItemNewMovie);

		JMenuItem JMenuItemLiveConcert1 = new JMenuItem("New LiveConcert");
		JMenuRegister.add(JMenuItemLiveConcert1);
		JMenuItemLiveConcert1.addActionListener(this);
		JMenuItemLiveConcert1.setActionCommand("New LiveConcert");

		JMenuItem JMenuItemTVBox = new JMenuItem("New TVBox");
		JMenuRegister.add(JMenuItemTVBox);
		JMenuItemTVBox.setActionCommand("New TVBox");
		JMenuItemTVBox.addActionListener(this);
		// contentPane.add(JMenuItemTVBox);

		JMenuItem JMenuItemNewEmployee = new JMenuItem("New Employee");
		JMenuRegister.add(JMenuItemNewEmployee);
		JMenuItemNewEmployee.setActionCommand("New Employee");
		JMenuItemNewEmployee.addActionListener(this);
		// contentPane.add(JMenuItemNewEmployee);

		JMenu JMenuLoyaltyCard = new JMenu("Loyalty Card");
		JMenuLoyaltyCard.setBackground(Color.WHITE);
		menuBar.add(JMenuLoyaltyCard);
		// contentPane.add(JMenuLoyaltyCard);

		JMenuItem mntmNewMenuItem = new JMenuItem("Loyalty Card Points");
		JMenuLoyaltyCard.add(mntmNewMenuItem);
		mntmNewMenuItem.setActionCommand("Loyalty Points");
		mntmNewMenuItem.addActionListener(this);
		// contentPane.add(mntmNewMenuItem);

		JMenu SearchTitles = new JMenu("Search Titles");
		SearchTitles.setBackground(Color.WHITE);
		menuBar.add(SearchTitles);

		JMenuItem JNewMenuItemSearchTitlesAvailable = new JMenuItem("Available");
		SearchTitles.add(JNewMenuItemSearchTitlesAvailable);
		JNewMenuItemSearchTitlesAvailable.setActionCommand("Available");
		JNewMenuItemSearchTitlesAvailable.addActionListener(this);

		JMenuItem JNewMenuItemSearchTitlesRented = new JMenuItem("Rented");
		SearchTitles.add(JNewMenuItemSearchTitlesRented);
		JNewMenuItemSearchTitlesRented.setActionCommand("Rented");
		JNewMenuItemSearchTitlesRented.addActionListener(this);
		
		
		JMenu UpdateCustomer = new JMenu("Update");
		UpdateCustomer.setBackground(Color.WHITE);
		menuBar.add(UpdateCustomer);
		
		
		JMenuItem JNewMenuItemUpdate = new JMenuItem("Update Customer");
		UpdateCustomer.add(JNewMenuItemUpdate);
		JNewMenuItemUpdate.setActionCommand("Update Customer");
		JNewMenuItemUpdate.addActionListener(this);
		
		JMenu Logout = new JMenu("Log Out");
		Logout.setBackground(Color.WHITE);
		menuBar.add(Logout);
		
		
		JMenuItem JNewMenuItemlogout = new JMenuItem("Log out");
		Logout.add(JNewMenuItemlogout);
		JNewMenuItemlogout.setActionCommand("Log out");
		JNewMenuItemlogout.addActionListener(this);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("");
		mntmNewMenuItem_1.setBackground(Color.WHITE);
		mntmNewMenuItem_1.setActionCommand("");
		menuBar.add(mntmNewMenuItem_1);
		
		JLabel label = new JLabel("Welcome: " + username);
		label.setIcon(null);
		label.setBounds(new Rectangle(14, 0, 0, 0));
		label.setPreferredSize(new Dimension(200, 6));
		label.setVerticalTextPosition(SwingConstants.TOP);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		label.setAlignmentX(Component.RIGHT_ALIGNMENT);
		menuBar.add(label);
		JNewMenuItemlogout.addActionListener(this);
		
		

		dashboard.validate();
		dashboard.repaint();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String ac = e.getActionCommand();
		if (ac.equals("New Customer")) {

			try {
				new CustomerController();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("New MusicLive")) {

			try {
				new MusicLiveController();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getActionCommand().equals("New Movie")) {
			try {
				new MovieController();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("New TVBox")) {
			try {
				new TVBoxController();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		else if (e.getActionCommand().equals("New Employee")) {
			try {
				new EmployeeController();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("Loyalty Points")) {
			new NewLoyaltyCard();
		} else if (e.getActionCommand().equals("Available")) {
			new TitlesAvailable();
		} else if (e.getActionCommand().equals("New LiveConcert")) {

			try {
				new LiveConcertController();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getActionCommand().equals("Music Live")) {
			try {
				new RentMusicLive();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("Movie")) {
			try {
				new RentMovie();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("TVBox")) {
			try {
				new RentTVBox();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("Live Concert")) {
			try {
				new RentLiveConcert();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("Rented")) {
			new TitlesRented();
		}
		else if (e.getActionCommand().equals("Log out")) {
			System.exit(0);
		}
		
		
	      else if (e.getActionCommand().equals("Update Customer")) {
		     try {
				new UpdateCustomer();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	}
}
