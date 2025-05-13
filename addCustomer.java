package Java_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addCustomer extends JFrame implements ActionListener{
	
	JTextField tfname, tfphone, tfaadhar, tfnationality, tfaddress;
	JRadioButton rbmale, rbfemale;
	
	public addCustomer() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("ADD NEW CUSTOMER");
		heading.setBounds(300, 20, 500, 35);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
		heading.setForeground(Color.BLUE);
		add(heading);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(70, 80, 100, 25);
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200, 80, 150, 30);
		add(tfname);
		
		JLabel lblnationality = new JLabel("Nationality");
		lblnationality.setBounds(70, 120, 100, 25);
		lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblnationality);
		
		tfnationality = new JTextField();
		tfnationality.setBounds(200, 120, 150, 30);
		add(tfnationality);
		
		JLabel lblaadhar = new JLabel("Aadhar no.");
		lblaadhar.setBounds(70, 160, 100, 25);
		lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblaadhar);
		
		tfaadhar = new JTextField();
		tfaadhar.setBounds(200, 160, 150, 30);
		add(tfaadhar);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(70, 200, 100, 25);
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblgender);
		
		ButtonGroup gendergroup = new ButtonGroup();
		
		rbmale = new JRadioButton("Male");
		rbmale.setBounds(210, 200, 60, 20);
		rbmale.setBackground(Color.WHITE);
		add(rbmale);
		
		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(300, 200, 100, 20);
		rbfemale.setBackground(Color.WHITE);
		add(rbfemale);
		
		gendergroup.add(rbmale);
		gendergroup.add(rbfemale);
		
		JLabel lblphone = new JLabel("Phone no.");
		lblphone.setBounds(70, 240, 100, 25);
		lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(200, 240, 150, 30);
		add(tfphone);
		
		
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(70, 280, 100, 25);
		lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lbladdress);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(200, 280, 150, 30);
		add(tfaddress);
		
		JButton save = new JButton("SAVE");
		save.setBackground(Color.BLACK);
		save.setForeground(Color.WHITE); 
		save.setBounds(350, 380, 150, 30);
		save.addActionListener(this);
		add(save);

		setSize(900, 600);
		setLocation(300, 150);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent ae) {
		 String name = tfname.getText();
		 String nationality = tfnationality.getText();
		 String phone= tfphone.getText();
		 String address = tfaddress.getText();
		 String aadhar = tfaadhar.getText();
		 String gender = null;
		 if(rbmale.isSelected()) {
			 gender = "Male";
		 }else {
			 gender = "Female";
		 }
		 
		try {
			Conn conn = new Conn();
			
			String query = "Insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhar+"', '"+gender+"')";
			
			conn.s.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Custormer Details Updated Successfully" );
			setVisible(false);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	public static void main(String[] args) {
		new addCustomer();
	}
	

}
