package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.Database;
import model.MembershipCard;

import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

/**
 * this class is to rent Movie wich the employee will be able to select
 * the customer and the titles that will be rented which also implements Actions
 * listener
 * 
 * @author jeancastro
 *
 */

public class RentMovie extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tableCustomerMovie;
	private JTextField textFieldSearchMovie;
	private JTextField textFieldSearchCustomerMovie;
	private JButton ButtonSelectMovie;
	private JButton NewLabelSearchIcon;
	private JButton NewButtonSelecCustomerMovie;
	private JButton lblNewLabel;
	private MaskFormatter mascara;
	private JFormattedTextField formattedTextFieldReturnDateMovie;
	private MaskFormatter mascara2;
	private JFormattedTextField formattedTextFieldRentedDate;
	private JButton NewButtonRentMovie;
	private JFormattedTextField formattedTextFieldTotalValueMovie;
	private JCheckBox NewCheckBoxCardMovie;
	private JTable tableCustomerMovietable;
	private JTable CustomerMovietable;
	private int selectedMovieID;
	private String selectedID;
	List<String> list = new ArrayList<String>();
	private int selectedPriceMovie;
	private int current;
	boolean allSelected1 = false;
	boolean allSelected2 = false;
	private int selectedCustomerID;
	private String customerChoosed;
	private Database jbdc = new Database();
	private String selectedPrice;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public RentMovie() throws ParseException {

		JFrame rentmovie = new JFrame();

		rentmovie.setTitle("Ultra Vision Midia");
		rentmovie.setVisible(true);
		rentmovie.setSize(new Dimension(800, 700));
		rentmovie.setLocationRelativeTo(null);
		rentmovie.setResizable(false);

		contentPane = new JPanel();
		contentPane.setSize(new Dimension(800, 800));
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		rentmovie.setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 6, 788, 94);
		contentPane.add(panel);

		JLabel NewLabelRentMovie = new JLabel("Rent Movie");
		NewLabelRentMovie.setIcon(new ImageIcon(NewMovie.class.getResource("/imagens/movie2.png")));
		panel.add(NewLabelRentMovie);

		ButtonSelectMovie = new JButton("Select");
		ButtonSelectMovie.setBounds(576, 312, 117, 29);
		contentPane.add(ButtonSelectMovie);
		ButtonSelectMovie.setActionCommand("Select1");
		ButtonSelectMovie.addActionListener(this);

		textFieldSearchMovie = new JTextField();
		textFieldSearchMovie.setBounds(470, 118, 179, 26);
		contentPane.add(textFieldSearchMovie);
		textFieldSearchMovie.setColumns(10);

		NewLabelSearchIcon = new JButton("");
		NewLabelSearchIcon.setIcon(new ImageIcon(NewLoyaltyCard.class.getResource("/imagens/search2.png")));
		NewLabelSearchIcon.setBounds(646, 118, 39, 26);
		contentPane.add(NewLabelSearchIcon);
		NewLabelSearchIcon.setActionCommand("Search1");
		NewLabelSearchIcon.addActionListener(this);

		JLabel NewLabelSearchMovie = new JLabel("Search Movie");
		NewLabelSearchMovie.setBounds(352, 123, 91, 16);
		contentPane.add(NewLabelSearchMovie);

		textFieldSearchCustomerMovie = new JTextField();
		textFieldSearchCustomerMovie.setBounds(470, 348, 179, 26);
		contentPane.add(textFieldSearchCustomerMovie);
		textFieldSearchCustomerMovie.setColumns(10);

		JLabel NewLabelSearchCustomerMovie = new JLabel("Search Customer");
		NewLabelSearchCustomerMovie.setBounds(332, 353, 117, 16);
		contentPane.add(NewLabelSearchCustomerMovie);

		lblNewLabel = new JButton("");
		lblNewLabel.setIcon(new ImageIcon(RentMovie.class.getResource("/imagens/search2.png")));
		lblNewLabel.setBounds(646, 353, 61, 20);
		contentPane.add(lblNewLabel);
		lblNewLabel.setActionCommand("Search2");
		lblNewLabel.addActionListener(this);

		NewButtonSelecCustomerMovie = new JButton("Select");
		NewButtonSelecCustomerMovie.setBounds(576, 532, 117, 29);
		contentPane.add(NewButtonSelecCustomerMovie);
		NewButtonSelecCustomerMovie.setActionCommand("Select2");
		NewButtonSelecCustomerMovie.addActionListener(this);

		mascara = new MaskFormatter("##/##/####");
		formattedTextFieldReturnDateMovie = new JFormattedTextField(mascara);
		formattedTextFieldReturnDateMovie.setBounds(127, 606, 130, 26);
		contentPane.add(formattedTextFieldReturnDateMovie);

		mascara2 = new MaskFormatter("##/##/####");
		formattedTextFieldRentedDate = new JFormattedTextField(mascara2);
		formattedTextFieldRentedDate.setBounds(127, 568, 130, 26);
		contentPane.add(formattedTextFieldRentedDate);

		JLabel NewLabelRentedDate = new JLabel(" Rented Date");
		NewLabelRentedDate.setBounds(277, 573, 85, 16);
		contentPane.add(NewLabelRentedDate);

		JLabel NewLabelReturnDateMovie = new JLabel("Return Date");
		NewLabelReturnDateMovie.setBounds(279, 611, 83, 16);
		contentPane.add(NewLabelReturnDateMovie);

		JLabel NewLabelTotalValueMovie = new JLabel("Total =");
		NewLabelTotalValueMovie.setBounds(384, 649, 46, 21);
		contentPane.add(NewLabelTotalValueMovie);

		formattedTextFieldTotalValueMovie = new JFormattedTextField();
		formattedTextFieldTotalValueMovie.setBounds(442, 646, 120, 26);
		contentPane.add(formattedTextFieldTotalValueMovie);

		NewButtonRentMovie = new JButton("Rent");
		NewButtonRentMovie.setBackground(Color.BLACK);
		NewButtonRentMovie.setForeground(Color.RED);
		NewButtonRentMovie.setBounds(578, 646, 117, 29);
		contentPane.add(NewButtonRentMovie);
		NewButtonRentMovie.setActionCommand("Rent");
		NewButtonRentMovie.addActionListener(this);

		JLabel NewLabelCustomerIcon = new JLabel("");
		NewLabelCustomerIcon
				.setIcon(new ImageIcon(RentMovie.class.getResource("/imagens/employee-removebg-preview.png")));
		NewLabelCustomerIcon.setBounds(21, 415, 84, 72);
		contentPane.add(NewLabelCustomerIcon);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(RentMovie.class.getResource("/imagens/homepage2-removebg-preview.png")));
		lblNewLabel_1.setBounds(21, 178, 94, 75);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(RentMovie.class.getResource("/imagens/main logo removed background.png")));
		lblNewLabel_2.setBounds(6, 603, 109, 67);
		contentPane.add(lblNewLabel_2);

	}

	/**
	 * this method is to creat the table passing the data collected from the
	 * database Movie table using outsidedata as parameter
	 * 
	 * @param outsideData
	 */

	public void tabalemovieSelected(String[][] outsideData) {

		// ________LIVE CONCERT AVAILABLE TABlE___________

		String[] columnNames = { "ID", "Title", "Director", "Type", "Price" };

		// Using a scroll pane
		JScrollPane myPane = new JScrollPane();
		myPane.setBounds(127, 143, 550, 161);
		contentPane.add(myPane);

		tableCustomerMovietable = new JTable(outsideData, columnNames);
		contentPane.add(tableCustomerMovietable);
		myPane.setViewportView(tableCustomerMovietable);

	}
	/**
	 * this method is to creat the table passing the data collected from the
	 * database customer table using outsidedata as parameter
	 * 
	 * @param outsideData
	 */


	public void tablecustomermovie(String[][] outsideData2) {

		// ________ CUSTOMER LIVE CONCERT TABLE ___________

		String[] columnNames2 = { "ID", "FirstName", "LastName", "Email", "Tel", "Membership" };

		// Using a scroll pane
		JScrollPane myPane2 = new JScrollPane();
		myPane2.setBounds(127, 372, 549, 161);
		contentPane.add(myPane2);

		CustomerMovietable = new JTable(outsideData2, columnNames2);
		contentPane.add(CustomerMovietable);
		myPane2.setViewportView(CustomerMovietable);

	}

	public String getFormattedTextFieldReturnDateMovie() {
		return formattedTextFieldReturnDateMovie.getText();
	}

	public String getFormattedTextFieldRentedDate() {
		return formattedTextFieldRentedDate.getText();
	}

	int initial = 0;

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Select1")) {

			if (list.size() > 4) {

				return;
			}

			selectedMovieID = tableCustomerMovietable.getSelectedRow();
			selectedID = tableCustomerMovietable.getValueAt(selectedMovieID, 0).toString();

			selectedPriceMovie = tableCustomerMovietable.getSelectedRow();
			selectedPrice = tableCustomerMovietable.getValueAt(selectedPriceMovie, 4).toString();

			current = Integer.parseInt((String) tableCustomerMovietable.getValueAt(selectedPriceMovie, 4));
			initial += current;

			allSelected1 = true;
			list.add(selectedID);

			formattedTextFieldTotalValueMovie.setText(String.valueOf(initial));

		}

		if (e.getActionCommand().equals("Select2")) {

			selectedCustomerID = CustomerMovietable.getSelectedRow();
			customerChoosed = CustomerMovietable.getValueAt(selectedCustomerID, 0).toString();

			allSelected2 = true;

		}

		if (e.getActionCommand().equals("Rent") && (allSelected1 == true && allSelected2 == true)) {

			jbdc.updatetableMovie(selectedID);
			MembershipCard mCard = (jbdc.getMembershipPoints(customerChoosed));
			int newPoints = Integer.parseInt(JOptionPane.showInputDialog("Please insert the amount of points"));
			jbdc.updatePoints(customerChoosed, mCard, newPoints);

			JOptionPane.showMessageDialog(null, "Rented");

			for (int i = 0; i < list.size(); i++) {

				jbdc.selectedMovieCustomer(list.get(i), customerChoosed, this.getFormattedTextFieldRentedDate(),
						this.getFormattedTextFieldReturnDateMovie());
				list.remove(i);
			}

			allSelected1 = false;
			allSelected2 = false;

		}

		if (e.getActionCommand().equals("Search1")) {

			String st = textFieldSearchMovie.getText();

			System.out.println(st);

			Database jdbc = new Database();
			String[][] data = jdbc.searchMovie(st);
			tabalemovieSelected(data);

		}
		if (e.getActionCommand().equals("Search2")) {

			String st2 = textFieldSearchCustomerMovie.getText();

			System.out.println(st2);

			Database jdbc = new Database();
			String[][] data = jdbc.searchMovieCustomer(st2);
			tablecustomermovie(data);

		}

	}
}
