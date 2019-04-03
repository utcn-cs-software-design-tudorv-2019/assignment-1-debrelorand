package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import business.entities.CourseBLL;
import business.entities.EnrolmentBLL;
import business.entities.StudentBLL;
import data.entities.Course;
import data.entities.Enrolment;
import data.entities.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;

public class StudentProfile extends JFrame {

	private JPanel contentPane;
	StudentBLL studentBLL = new StudentBLL();
	CourseBLL courseBLL = new CourseBLL();
	EnrolmentBLL enrolmentBLL = new EnrolmentBLL();
	
	/**
	 * Create the frame.
	 */
	public StudentProfile(Student student) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("StudentProfile");
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new MigLayout("", "[][][][][][]", "[][][][][][]"));
				
		
		JPanel panel_north = new JPanel();
		contentPane.add(panel_north, BorderLayout.NORTH);
		panel_north.setLayout(new MigLayout("", "[][][][][]", "[][]"));
		
		JLabel lblBineAiVenit = new JLabel("Bine ai venit, "+student.getNume()+" "+student.getPrenume());
		lblBineAiVenit.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_north.add(lblBineAiVenit, "flowx,cell 0 0");
		
		JButton viewProfile = new JButton("View profile");
		viewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_center.removeAll();
				panel_center.updateUI();
				
				JLabel lblUsername = new JLabel("Username: "+student.getUsername());
				panel_center.add(lblUsername, "cell 0 0");
				
				JLabel lblAdresa = new JLabel("Adresa: "+student.getAdresa());
				panel_center.add(lblAdresa, "cell 0 1");
				
				JLabel lblEmail = new JLabel("Email: "+student.getEmail());
				panel_center.add(lblEmail, "cell 0 2");
				
				JLabel lblGrupa = new JLabel("Grupa: "+student.getGrupa());
				panel_center.add(lblGrupa, "cell 0 3");
				
				JLabel lblCnp = new JLabel("CNP: "+student.getCnp());
				panel_center.add(lblCnp, "cell 0 4");
				
				JLabel lblId = new JLabel("Nr card: "+student.getNrIdentificare());
				panel_center.add(lblId, "cell 0 5");
			}
		});
		panel_north.add(viewProfile, "flowx,cell 0 1");
		
		JButton updateProfile = new JButton("Update");
		updateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_center.removeAll();
				panel_center.updateUI();
				
				JLabel lblUsername = new JLabel("Username: ");
				panel_center.add(lblUsername, "cell 0 0,alignx trailing");
				
				JTextField textField_Username = new JTextField(student.getUsername());
				panel_center.add(textField_Username, "cell 1 0,growx");
				textField_Username.setColumns(20);
				textField_Username.setEditable(false);
				
				JLabel lblAdresa = new JLabel("Adresa: ");
				panel_center.add(lblAdresa, "cell 0 1,alignx trailing");
				
				JTextField textField_Adresa = new JTextField(student.getAdresa());
				panel_center.add(textField_Adresa, "cell 1 1,growx");
				textField_Adresa.setColumns(20);
				
				JLabel lblEmail = new JLabel("Email: ");
				panel_center.add(lblEmail, "cell 0 2,alignx trailing");
				
				JTextField textField_Email = new JTextField(student.getEmail());
				panel_center.add(textField_Email, "cell 1 2,growx");
				textField_Email.setColumns(20);
				
				JLabel lblGrupa = new JLabel("Grupa: ");
				panel_center.add(lblGrupa, "cell 0 3,alignx trailing");
				
				JTextField textField_Grupa = new JTextField(student.getGrupa());
				panel_center.add(textField_Grupa, "cell 1 3,growx");
				textField_Grupa.setColumns(20);
				
				JLabel lblCnp = new JLabel("CNP: ");
				panel_center.add(lblCnp, "cell 0 4,alignx trailing");
				
				JTextField textField_CNP = new JTextField(student.getCnp());
				panel_center.add(textField_CNP, "cell 1 4,growx");
				textField_CNP.setColumns(20);
				
				JLabel lblNume = new JLabel("Nume: ");
				panel_center.add(lblNume,"cell 0 5,alignx trailing");
				
				JTextField textField_Nume = new JTextField(student.getNume());
				panel_center.add(textField_Nume,"cell 1 5,growx");
				textField_Nume.setColumns(20);
				
				JLabel lblPrenume = new JLabel("Prenume:");
				panel_center.add(lblPrenume,"cell 0 6,alignx trailing");
				
				JTextField textField_Prenume = new JTextField(student.getPrenume());
				panel_center.add(textField_Prenume,"cell 1 6,growx");
				textField_Prenume.setColumns(20);
				
				JLabel lblPassword = new JLabel("Password:");
				panel_center.add(lblPassword,"cell 0 7,alignx trailing");
				
				JTextField textField_parola = new JPasswordField();
				panel_center.add(textField_parola,"cell 1 7,growx");
				textField_parola.setColumns(20);
				
				JLabel lblId = new JLabel("Nr card: ");
				panel_center.add(lblId, "cell 0 8, alignx trailing");
				
				JTextField textField_Card = new JTextField(Integer.toString(student.getNrIdentificare()));
				panel_center.add(textField_Card, "cell 1 8,growx");
				textField_Card.setColumns(20);
				textField_Card.setEditable(false);
				
				JButton update = new JButton("Update");
				panel_center.add(update,"cell 0 9,growx");
				
				update.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						student.setAdresa(textField_Adresa.getText());
						student.setEmail(textField_Email.getText());
						student.setGrupa(textField_Grupa.getText());
						student.setCnp(textField_CNP.getText());
						student.setNume(textField_Nume.getText());
						student.setPrenume(textField_Prenume.getText());
						student.setPassword(textField_parola.getText());
						
						if(studentBLL.updateStudent(student))
						{
							JOptionPane.showMessageDialog(null, "Updateul s-a efectuat cu succes!");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "ERROR!");
						}
						
					}
				});
			}
		});
		panel_north.add(updateProfile, "cell 0 1");
		
		JButton deleteProfile = new JButton("Delete");
		deleteProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(studentBLL.deleteStudent(student.getNrIdentificare()))
				{
					JOptionPane.showMessageDialog(null, "Student sters cu succes!");
					Home home = new Home();
					setVisible(false);
					home.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "ERROR!");
				}
				
			}
		});
		panel_north.add(deleteProfile, "cell 0 1");
		
		JButton enrolments = new JButton("Enrolments");
		enrolments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_center.removeAll();
				panel_center.updateUI();
				
				JLabel info = new JLabel("Selecteaza un curs:");
				panel_center.add(info,"cell 0 0");
				
				List<Course> cursurile = courseBLL.getAll();
				
				String[] columnNames = {"ID","IdAdministrator","Nume disciplina","Nr de credite"};
				
				String[][] data = new String[cursurile.size()][4];
				
				for (int i=0;i<cursurile.size();i++)
				{
					data[i][0]=Integer.toString(cursurile.get(i).getId());
					data[i][1]=Integer.toString(cursurile.get(i).getidAdministrator());
					data[i][2]=cursurile.get(i).getNume();
					data[i][3]=Integer.toString(cursurile.get(i).getCredit());
				}
				
				JTable table = new JTable(data,columnNames);
				
				JScrollPane sp = new JScrollPane(table);
				table.setVisible(true);
				
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getColumnModel().getColumn(0).setPreferredWidth(30);
				table.getColumnModel().getColumn(2).setPreferredWidth(200);
				
				panel_center.add(sp,"cell 0 1");
				
				JLabel lbldatestart = new JLabel("Start date(dd-mm-yyyy): ");
				panel_center.add(lbldatestart, "cell 0 2,alignx trailing");
				
				JTextField textField_start = new JTextField();
				panel_center.add(textField_start, "cell 0 2,growx");
				textField_start.setColumns(20);
				
				JLabel lbldatefinish = new JLabel("Finish date(dd-mm-yyyy): ");
				panel_center.add(lbldatefinish, "cell 0 3,alignx trailing");
				
				JTextField textField_finish = new JTextField();
				panel_center.add(textField_finish, "cell 0 3,growx");
				textField_start.setColumns(20);
				
				JButton add = new JButton("Enrolment");
				panel_center.add(add,"cell 0 4");
				
				add.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int row = table.getSelectedRow();
						
						SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
						java.util.Date date;
						try {
							date = sdf1.parse(textField_start.getText());
							
							Date startDate=new java.sql.Date(date.getTime());
							date = sdf1.parse(textField_finish.getText());
							Date finishDate=new java.sql.Date(date.getTime());
		//int idStudent,int idCourse, Date startDate, Date finishDate, int nota
		//public Course(int id, String nume, int credit, int idAdministrator) {
		//public Enrolment(Course curs, Date startDate, Date finishDate, int nota, int studentID, int enrolmentID)
							Course curs = new Course(Integer.parseInt((String)table.getValueAt(row, 0)),"",0,0);
							
							Enrolment enrolment = new Enrolment(curs, startDate, finishDate, -1, student.getNrIdentificare(),-1);
							
							enrolmentBLL.enroll(enrolment);				
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
			}
		});
		panel_north.add(enrolments, "cell 0 1");
		
		JButton grades = new JButton("Grades");
		grades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_center.removeAll();
				panel_center.updateUI();
				
	//public Enrolment(Course curs, Date startDate, Date finishDate, int nota, int studentID, int enrolmentID)
				Enrolment enrolment = new Enrolment(null,null,null,-1,student.getNrIdentificare(),-1);
				
				List<Enrolment> enrolments = enrolmentBLL.getById(enrolment);
				
				String[] columnNames = {"Nume disciplina","Credit","Start Date","Finish Date","Nota"};
				
				String[][] data = new String[enrolments.size()][5];
				
				for (int i=0;i<enrolments.size();i++)
				{
					data[i][0]=(enrolments.get(i).getCurs().getNume());
					data[i][1]=Integer.toString(enrolments.get(i).getCurs().getCredit());
					data[i][2]=enrolments.get(i).getStartDate().toString();
					data[i][3]=enrolments.get(i).getFinishDate().toString();
					int nota = enrolments.get(i).getNota();
					if(nota==-1)
					{
						data[i][4]="neterminat";
					}
					else
					{
						data[i][4]=Integer.toString(nota);
					}
					
				}
				
				JTable table = new JTable(data,columnNames);
				
				JScrollPane sp = new JScrollPane(table);
				table.setVisible(true);
				
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getColumnModel().getColumn(0).setPreferredWidth(180);
				table.getColumnModel().getColumn(1).setPreferredWidth(40);
				
				panel_center.add(sp,"cell 0 1");
			}
			
		});
		panel_north.add(grades,"cell 0 1");
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		panel_north.add(logout, "cell 1 1");
		
		
	}

}
