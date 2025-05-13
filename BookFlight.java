package Java_project;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class BookFlight extends JFrame implements ActionListener {

    JTextField tfaadhar;
    JLabel tfname, tfnationality, tfaddress, labelgender, labelfname, labelfcode;
    JButton bookFlight, fetchButton, flight;
    Choice source, destination;
    JDateChooser dcdate;

    public BookFlight() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("BOOK FLIGHT");
        heading.setBounds(400, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblaadhar = new JLabel("Aadhar ");
        lblaadhar.setBounds(70, 60, 100, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 60, 150, 30);
        add(tfaadhar);

        fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(400, 65, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(70, 120, 100, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfname = new JLabel();
        tfname.setBounds(200, 120, 150, 30);
        add(tfname);

        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(70, 170, 100, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);

        tfnationality = new JLabel();
        tfnationality.setBounds(200, 170, 150, 30);
        add(tfnationality);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(70, 220, 100, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        labelgender = new JLabel();
        labelgender.setBounds(200, 220, 100, 25);
        add(labelgender);

        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(70, 270, 100, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);

        source = new Choice();
        source.setBounds(200, 270, 150, 25);
        add(source);

        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(70, 330, 100, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);

        destination = new Choice();
        destination.setBounds(200, 330, 150, 25);
        add(destination);

        try {
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(370, 330, 110, 20);
        flight.addActionListener(this);
        add(flight);

        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(70, 380, 100, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(200, 380, 150, 30);
        add(labelfname);

        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(70, 430, 100, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);

        labelfcode = new JLabel();
        labelfcode.setBounds(200, 430, 150, 30);
        add(labelfcode);

        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(70, 480, 120, 35);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(200, 480, 150, 30);
        add(dcdate);

        bookFlight = new JButton("Book Flights");
        bookFlight.setBackground(Color.BLACK);
        bookFlight.setForeground(Color.WHITE);
        bookFlight.setBounds(220, 560, 150, 20);
        bookFlight.addActionListener(this);
        add(bookFlight);

        setSize(1000, 800);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String aadhar = tfaadhar.getText();
            try {
                Conn conn = new Conn();
                String query = "select * from passenger where aadhar = '" + aadhar + "'";
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    labelgender.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter Correct Aadhar Number");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == flight) {
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();

            try {
                Conn conn = new Conn();
                String query = "select * from flight where source = '" + src + "' and destination = '" + dest + "'";
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    labelfname.setText(rs.getString("f_name"));
                    labelfcode.setText(rs.getString("f_code"));
                } else {
                    JOptionPane.showMessageDialog(null, "No Flight Found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            Random random = new Random();
            String aadhar = tfaadhar.getText();
            String name = tfname.getText();
            String nationality = tfnationality.getText();
            String flightname = labelfname.getText();
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem();
            String des = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();

            try {
                Conn conn = new Conn();
                String query = "insert into reservation values('PNR-" + random.nextInt(1000000) + "', 'TIC-" + random.nextInt(10000) + "', '" + aadhar + "', '" + name + "', '" + nationality + "', '" + flightname + "', '" + src + "', '" + des + "', '" + ddate + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
          
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BookFlight();
    }
}
