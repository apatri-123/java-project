package Java_project;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class CancelTicket extends JFrame implements ActionListener {

    JTextField tfpnr;
    JLabel tfname, cancellation, lbldate;
    JButton  fetchButton, flight;
   
   

    public CancelTicket() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random random = new Random();

        JLabel heading = new JLabel("Cancellation");
        heading.setBounds(180, 20, 250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);

        JLabel lblaadhar = new JLabel("PNR Number ");
        lblaadhar.setBounds(70, 60, 100, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);

        tfpnr = new JTextField();
        tfpnr.setBounds(200, 60, 150, 30);
        add(tfpnr);

        fetchButton = new JButton("Show Details");
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

        JLabel lblnationality = new JLabel("Cancellation Number");
        lblnationality.setBounds(70, 170, 150, 35);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);

        cancellation = new JLabel(""+random.nextInt(1000000));
        cancellation.setBounds(250, 173, 180, 30);
        add(cancellation);

        JLabel lblgender = new JLabel("Date ");
        lblgender.setBounds(70, 270, 100, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        lbldate = new JLabel();
        lbldate.setBounds(200, 270, 100, 25);
        add(lbldate);

      

        
        flight = new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220, 330, 110, 20);
        flight.addActionListener(this);
        add(flight);

       

        setSize(700, 500);
        setLocation(350, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String pnr = tfpnr.getText();
            try {
                Conn conn = new Conn();
                String query = "select * from reservation where PNR_NO = '" + pnr + "'";
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                 lbldate.setText(rs.getString("ddate"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter Correct PNR no");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == flight) {
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno = cancellation.getText();
            String date = lbldate.getText();
            

            try {
                Conn conn = new Conn();
                String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancelno+"', '"+date+"')";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate("delete from reservation where PNR_NO = '"+pnr+"'");

                
                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        } 
    }

    public static void main(String[] args) {
        new CancelTicket();
    }
}
