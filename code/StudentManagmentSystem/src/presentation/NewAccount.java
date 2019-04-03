package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import business.entities.AdministratorBLL;
import business.entities.StudentBLL;
import business.validators.RegisterValidator;
import data.entities.Administrator;
import data.entities.Student;
import net.miginfocom.swing.MigLayout;


public class NewAccount extends JFrame {
	private JTextField textField_Username;
	private JTextField textField_Password;
	private JTextField textField_Nume;
	private JTextField textField_Prenume;
	private JTextField textField_Adresa;
	private JTextField textField_CNP;
	private JTextField textField_Email;
	private JTextField textField_Grupa;

	StudentBLL studentBLL=new StudentBLL();
	AdministratorBLL administratorBLL = new AdministratorBLL();
	RegisterValidator register = new RegisterValidator();
	
	public NewAccount() {
		setBounds(150, 150, 550, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Select one:");
		getContentPane().add(lblNewLabel, "cell 0 0");
		
		
		
		JLabel lblUsername = new JLabel("Username:");
		getContentPane().add(lblUsername, "cell 0 1,alignx trailing");
		
		textField_Username = new JTextField();
		getContentPane().add(textField_Username, "cell 1 1,growx");
		textField_Username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		getContentPane().add(lblPassword, "cell 0 2,alignx trailing");
		
		textField_Password = new JPasswordField();
		getContentPane().add(textField_Password, "cell 1 2,growx");
		textField_Password.setColumns(10);
		
		JLabel lblNume = new JLabel("Nume:");
		getContentPane().add(lblNume, "cell 0 3,alignx trailing");
		
		textField_Nume = new JTextField();
		getContentPane().add(textField_Nume, "cell 1 3,growx");
		textField_Nume.setColumns(10);
		
		JLabel lblPrenume = new JLabel("Prenume:");
		getContentPane().add(lblPrenume, "cell 0 4,alignx trailing");
		
		textField_Prenume = new JTextField();
		getContentPane().add(textField_Prenume, "cell 1 4,growx");
		textField_Prenume.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		getContentPane().add(lblAdresa, "cell 0 5,alignx trailing");
		
		textField_Adresa = new JTextField();
		getContentPane().add(textField_Adresa, "cell 1 5,growx");
		textField_Adresa.setColumns(10);
		
		JLabel lblCnp = new JLabel("CNP:");
		getContentPane().add(lblCnp, "cell 0 6,alignx trailing");
		
		textField_CNP = new JTextField();
		getContentPane().add(textField_CNP, "cell 1 6,growx");
		textField_CNP.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		getContentPane().add(lblEmail, "cell 0 7,alignx trailing");
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		getContentPane().add(rdbtnStudent, "flowx,cell 1 0");
		
		JRadioButton rdbtnAdministrator = new JRadioButton("Administrator");
		getContentPane().add(rdbtnAdministrator, "cell 1 0");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnStudent);
		group.add(rdbtnAdministrator);
		
		textField_Email = new JTextField();
		getContentPane().add(textField_Email, "cell 1 7,growx");
		textField_Email.setColumns(10);
		
		JLabel lblGrupa = new JLabel("Grupa/Catedra:");
		getContentPane().add(lblGrupa, "cell 0 8,alignx trailing");
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnStudent.isSelected())
				{
					String username = textField_Username.getText();
					String password = textField_Password.getText();
					String nume = textField_Nume.getText();
					String prenume = textField_Prenume.getText();
					String cnp = textField_CNP.getText();
					String adresa = textField_Adresa.getText();
					String email = textField_Email.getText();
					String grupa = textField_Grupa.getText();
				
					Student student = new Student(nume,prenume,username,password,cnp,adresa,email,grupa);
					try {
						register.validate(student);
						int newId = studentBLL.registerStudent(student);
						JOptionPane.showMessageDialog(null, "Studentul a fost adaugat cu succes, numar de card:"+newId);
						setVisible(false);
					}
					catch(IllegalArgumentException e1)
					{
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				}
				else
				{
					if(rdbtnAdministrator.isSelected())
					{
						String username = textField_Username.getText();
						String password = textField_Password.getText();
						String nume = textField_Nume.getText();
						String prenume = textField_Prenume.getText();
						String cnp = textField_CNP.getText();
						String adresa = textField_Adresa.getText();
						String email = textField_Email.getText();
						String catedra = textField_Grupa.getText();
						
						try {
							Administrator admin = new Administrator(nume,prenume,username,password,cnp,adresa,email,catedra);
							int newId = administratorBLL.registAdministrator(admin);
							JOptionPane.showMessageDialog(null, "Administratorul a fost adaugat cu succes, numar de card:"+newId);
							setVisible(false);
						}
						catch(IllegalArgumentException e1)
						{
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Trebuie sa selectezi ceva!");
					}
				}
			}
		});
		
		textField_Grupa = new JTextField();
		getContentPane().add(textField_Grupa, "cell 1 8,growx");
		textField_Grupa.setColumns(10);
		getContentPane().add(btnRegister, "flowx,cell 1 9");
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		getContentPane().add(btnClose, "cell 1 9");
	}

}
