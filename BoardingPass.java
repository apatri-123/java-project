package Java_project;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class BoardingPass extends JFrame implements ActionListener {

    JTextField tfpnr;
    JLabel tfname, tfnationality, lblsrc, lbldest, labelfname, labelfcode, labeldate;
    JButton bookFlight, fetchButton, flight;
    Choice source, destination;
  

    public BoardingPass() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380, 10, 450, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(360, 50, 300, 30);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        subheading.setForeground(Color.BLUE);
        add(subheading);

        JLabel lblaadhar = new JLabel("PNR DETAILS ");
        lblaadhar.setBounds( 60, 110, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);

        tfpnr = new JTextField();
        tfpnr.setBounds(200, 110, 150, 30);
        add(tfpnr);

        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(400, 110, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 160, 100, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfname = new JLabel();
        tfname.setBounds(200, 160, 150, 30);
        add(tfname);

        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 200, 100, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);

        tfnationality = new JLabel();
        tfnationality.setBounds(200, 200, 150, 30);
        add(tfnationality);
        
        JLabel lblsrcText = new JLabel("SRC");
        lblsrcText.setBounds(60, 250, 150, 25);
        lblsrcText.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsrcText);

        lblsrc = new JLabel(); 
        lblsrc.setBounds(200, 250, 150, 25);
        add(lblsrc);

        
        JLabel lbldestText = new JLabel("DESTINATION"); 
        lbldestText.setBounds(60, 300, 120, 25);
        lbldestText.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldestText);

        lbldest = new JLabel(); 
        lbldest.setBounds(200, 300, 120, 25);
        add(lbldest);


        

        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 350, 100, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(200, 350, 150, 30);
        add(labelfname);

        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(70, 480, 120, 35);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);

        labeldate = new JLabel();
        labeldate.setBounds(200, 480, 150, 30);
        add(labeldate);

       
        setSize(800, 500);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
      
            String pnr = tfpnr.getText();
            try {
                Conn conn = new Conn();
                String query = "select * from reservation where PNR_NO = '" + pnr + "'";
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    lblsrc.setText(rs.getString("src"));
                    lbldest.setText(rs.getString("des"));
                    labelfname.setText(rs.getString("flightname"));
                    labeldate.setText(rs.getString("ddate"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter Correct Aadhar Number");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

       
    }

    public static void main(String[] args) {
        new BoardingPass();
    }
}
