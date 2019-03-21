package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

import business.entities.AdministratorBLL;
import business.entities.StudentBLL;
import data.entities.Administrator;
import data.entities.Student;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame{

	private JFrame frame;
	private JTextField textField_Username;
	private JTextField textField_Password;

	
	StudentBLL studentBLL=new StudentBLL();
	AdministratorBLL administratorBLL = new AdministratorBLL();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelNorth = new JPanel();
		frame.getContentPane().add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Student management system");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelNorth.add(lblNewLabel);
		
		JPanel panelCenter = new JPanel();
		frame.getContentPane().add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new MigLayout("", "[][grow][][][][]", "[][][][][][][][][][][][][][][]"));
		
		JLabel lblUsername = new JLabel("Username:");
		panelCenter.add(lblUsername, "cell 0 4,alignx trailing");
		
		textField_Username = new JTextField();
		panelCenter.add(textField_Username, "cell 1 4,growx");
		textField_Username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		panelCenter.add(lblPassword, "cell 0 5,alignx trailing");
		
		textField_Password = new JPasswordField();
		panelCenter.add(textField_Password, "cell 1 5,growx");
		textField_Password.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField_Username.getText();
				String password = textField_Password.getText();
				
				Student student = studentBLL.getByName(username);
				if(student!=null)
				{
					if(student.getPassword().equals(textField_Password.getText()))
					{
						JOptionPane.showMessageDialog(null, "Bine ai venit,"+student.getNume()+" "+student.getPrenume()+" - student");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Incorect password!");
					}
				}
				else
				{
					Administrator administrator = administratorBLL.getByName(username);
					if(administrator!=null)
					{
						if(administrator.getPassword().equals(textField_Password.getText()))
						{
							JOptionPane.showMessageDialog(null, "Bine ai venit,"+administrator.getNume()+" "+administrator.getPrenume()+" - administrator");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Incorect password!");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "User inexistent!!!");
					}
				}
			}
		});
		panelCenter.add(btnLogin, "cell 1 6");
		
		JButton btnNewAccount = new JButton("I don't have an account");
		btnNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewAccount frame2 = new NewAccount();
				frame2.setVisible(true);
			}
		});
		panelCenter.add(btnNewAccount, "cell 1 14");
	}

}
