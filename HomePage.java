package Java_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




public class HomePage extends JFrame implements ActionListener {
	
	public HomePage() {
		setLayout(null);
		
//		ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\mukti\\Downloads\\front.jpg"));
//		JLabel image = new JLabel(il);
//		image.setBounds(0, 0, 600, 800);
//		add(image);

		JLabel heading = new JLabel("Air India Welcomes You");
		heading.setBounds(600, 40, 400, 40 );
		heading.setForeground(Color.BLUE);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
		add(heading);
		
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu details = new JMenu("Details");
		menubar.add(details);
		
		
		JMenuItem flightDetails = new JMenuItem("Flight Details");
		flightDetails.addActionListener(this);
		details.add(flightDetails);
		
		JMenuItem customerDetails = new JMenuItem("Add Customer Details");
		customerDetails.addActionListener(this);
		details.add(customerDetails);
		
		JMenuItem FlightBook = new JMenuItem("Book Flight");
		FlightBook.addActionListener(this);
		details.add(FlightBook);
		
		JMenuItem journeyDetails = new JMenuItem("journeyDetails");
		journeyDetails.addActionListener(this);
		details.add(journeyDetails);
		
		JMenuItem ticketCancellation = new JMenuItem("Cancel ticket");
		ticketCancellation.addActionListener(this);
		details.add(ticketCancellation);
				
		JMenu ticket = new JMenu("Ticket");
		menubar.add(ticket);
		
		JMenuItem boardingPass = new JMenuItem("Boarding Pass");
		ticket.add(boardingPass);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String text = ae.getActionCommand();
		
		if(text.equals("Add Customer Details")) {
			new addCustomer();
		}else if(text.equals("Flight Details")) {
			new flightInfo();
		}else if(text.equals("Book Flight")){
		    new BookFlight();
		}else if(text.equals("journeyDetails")) {
			new journeyDetails();
		} else if (text.equals("Cancel ticket")) {
		    new CancelTicket();
		}
		
	}
	public static void main(String[] args) {
		
		new HomePage();
	}

}