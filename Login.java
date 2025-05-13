package Java_project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Login extends JFrame implements ActionListener {
	JButton submit,reset,close;
	JTextField tfusername;
	JPasswordField tfpassword;
	
	public Login() {
		getContentPane().setBackground(Color.GREEN);
		setLayout(null);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(20,20,100,20);
		add(lblusername);
		
		tfusername = new JTextField();
		tfusername.setBounds(130,20,200,20);
		add(tfusername);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(20,60,100,20);
		add(lblpassword);
		
		tfpassword = new JPasswordField();
		tfpassword.setBounds(130,60,200,20);
		add(tfpassword);
		
		reset = new JButton("Reset");
		reset.setBounds(40,120,120,20);
		reset.addActionListener(this);
		add(reset);
		
		submit = new JButton("Submit");
		submit.setBounds(190,120,120,20);
		submit.addActionListener(this);
		add(submit);
		
		close = new JButton("Close");
		close.setBounds(120,160,120,20);
		close.addActionListener(this);
		add(close);
		
		setSize(400,250);
		setLocation(600,250);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == submit) {
			String username = tfusername.getText();
			String password = tfpassword.getText();

			try {
				Conn c = new Conn();
				
				String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
				
				ResultSet rs = c.s.executeQuery(query);
				
				if (rs.next()) {
					new HomePage();
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null,"Invalid Username or Password");
					setVisible(false);
				}
				
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}else if(ae.getSource() == close) {
			setVisible(false);
		}else if(ae.getSource() == reset) {
			tfusername.setText("");
			tfpassword.setText("");
		}
	
	}
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","Mukti@2003");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		new Login();
	}

}