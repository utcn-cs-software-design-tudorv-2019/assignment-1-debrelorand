package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import business.entities.AdministratorBLL;
import business.entities.CourseBLL;
import business.entities.EnrolmentBLL;
import business.entities.StudentBLL;
import data.entities.Administrator;
import data.entities.Course;
import data.entities.Enrolment;
import data.entities.Student;
import net.miginfocom.swing.MigLayout;

public class AdministratorProfile extends JFrame {

	private JPanel contentPane;

	AdministratorBLL administratorBLL = new AdministratorBLL();
	CourseBLL courseBLL = new CourseBLL();
	StudentBLL studentBLL = new StudentBLL();
	EnrolmentBLL enrolmentBLL = new EnrolmentBLL();
	/**
	 * Create the frame.
	 */
	public AdministratorProfile(Administrator administrator) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("AdministratorProfile");
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
		panel_north.setLayout(new MigLayout("", "[][][][][]", "[][][][]"));
		
		JLabel lblBineAiVenit = new JLabel("Bine ai venit, "+administrator.getNume()+" "+administrator.getPrenume());
		lblBineAiVenit.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_north.add(lblBineAiVenit, "flowx,cell 0 0");
		
		JButton viewProfile = new JButton("View profile");
		viewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_center.removeAll();
				panel_center.updateUI();
				
				JLabel lblUsername = new JLabel("Username: "+administrator.getUsername());
				panel_center.add(lblUsername, "cell 0 0");
				
				JLabel lblAdresa = new JLabel("Adresa: "+administrator.getAdresa());
				panel_center.add(lblAdresa, "cell 0 1");
				
				JLabel lblEmail = new JLabel("Email: "+administrator.getEmail());
				panel_center.add(lblEmail, "cell 0 2");
				
				JLabel lblGrupa = new JLabel("Catedra: "+administrator.getCatedra());
				panel_center.add(lblGrupa, "cell 0 3");
				
				JLabel lblCnp = new JLabel("CNP: "+administrator.getCnp());
				panel_center.add(lblCnp, "cell 0 4");
				
				JLabel lblId = new JLabel("ID: "+administrator.getNrIdentificare());
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
				
				JTextField textField_Username = new JTextField(administrator.getUsername());
				panel_center.add(textField_Username, "cell 1 0,growx");
				textField_Username.setColumns(20);
				textField_Username.setEditable(false);
				
				JLabel lblAdresa = new JLabel("Adresa: ");
				panel_center.add(lblAdresa, "cell 0 1,alignx trailing");
				
				JTextField textField_Adresa = new JTextField(administrator.getAdresa());
				panel_center.add(textField_Adresa, "cell 1 1,growx");
				textField_Adresa.setColumns(20);
				
				JLabel lblEmail = new JLabel("Email: ");
				panel_center.add(lblEmail, "cell 0 2,alignx trailing");
				
				JTextField textField_Email = new JTextField(administrator.getEmail());
				panel_center.add(textField_Email, "cell 1 2,growx");
				textField_Email.setColumns(20);
				
				JLabel lblGrupa = new JLabel("Catedra: ");
				panel_center.add(lblGrupa, "cell 0 3,alignx trailing");
				
				JTextField textField_Grupa = new JTextField(administrator.getCatedra());
				panel_center.add(textField_Grupa, "cell 1 3,growx");
				textField_Grupa.setColumns(20);
				
				JLabel lblCnp = new JLabel("CNP: ");
				panel_center.add(lblCnp, "cell 0 4,alignx trailing");
				
				JTextField textField_CNP = new JTextField(administrator.getCnp());
				panel_center.add(textField_CNP, "cell 1 4,growx");
				textField_CNP.setColumns(20);
				
				JLabel lblNume = new JLabel("Nume: ");
				panel_center.add(lblNume,"cell 0 5,alignx trailing");
				
				JTextField textField_Nume = new JTextField(administrator.getNume());
				panel_center.add(textField_Nume,"cell 1 5,growx");
				textField_Nume.setColumns(20);
				
				JLabel lblPrenume = new JLabel("Prenume:");
				panel_center.add(lblPrenume,"cell 0 6,alignx trailing");
				
				JTextField textField_Prenume = new JTextField(administrator.getPrenume());
				panel_center.add(textField_Prenume,"cell 1 6,growx");
				textField_Prenume.setColumns(20);
				
				JLabel lblPassword = new JLabel("Password:");
				panel_center.add(lblPassword,"cell 0 7,alignx trailing");
				
				JTextField textField_parola = new JPasswordField();
				panel_center.add(textField_parola,"cell 1 7,growx");
				textField_parola.setColumns(20);
				
				JLabel lblId = new JLabel("Nr card: ");
				panel_center.add(lblId, "cell 0 8, alignx trailing");
				
				JTextField textField_Card = new JTextField(Integer.toString(administrator.getNrIdentificare()));
				panel_center.add(textField_Card, "cell 1 8,growx");
				textField_Card.setColumns(20);
				textField_Card.setEditable(false);
				
				JButton update = new JButton("Update");
				panel_center.add(update,"cell 0 9,growx");
				
				update.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						administrator.setAdresa(textField_Adresa.getText());
						administrator.setEmail(textField_Email.getText());
						administrator.setCatedra(textField_Grupa.getText());
						administrator.setCnp(textField_CNP.getText());
						administrator.setNume(textField_Nume.getText());
						administrator.setPrenume(textField_Prenume.getText());
						administrator.setPassword(textField_parola.getText());
						
						if(administratorBLL.updateAdministrator(administrator))
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
				if(administratorBLL.deleteAdministrator(administrator))
				{
					JOptionPane.showMessageDialog(null, "Administrator sters cu succes!");
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
		
		JButton courses = new JButton("Courses");
		courses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_center.removeAll();
				panel_center.updateUI();
				
				Course curs = new Course(1,"",0,administrator.getNrIdentificare());
				
				List<Course> courses = courseBLL.getByidAdmin(curs);
			
				String[] columnNames = {"ID","Nume disciplina","Credit"};
				
				String[][] data = new String[courses.size()][3];
				
				for (int i=0;i<courses.size();i++)
				{
					data[i][0]=Integer.toString(courses.get(i).getId());
					data[i][1]=courses.get(i).getNume();
					data[i][2]=Integer.toString(courses.get(i).getCredit());
				}
				
				JTable table = new JTable(data,columnNames);
				
				JScrollPane sp = new JScrollPane(table);
				table.setVisible(true);
				
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getColumnModel().getColumn(0).setPreferredWidth(30);
				table.getColumnModel().getColumn(1).setPreferredWidth(330);
				
				panel_center.add(sp,"cell 0 1");
				
				JButton coursInfo = new JButton("Curs info");
				panel_center.add(coursInfo,"cell 0 2");
				
				coursInfo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int row=table.getSelectedRow();
						Course curs = new Course(Integer.parseInt((String)table.getValueAt(row, 0)),(String)table.getValueAt(row, 1),Integer.parseInt((String)table.getValueAt(row, 2)),administrator.getNrIdentificare());
						CursInfo cursInfo = new CursInfo(curs);
						cursInfo.setVisible(true);
					}
				});
				
				JLabel text = new JLabel("Adaugare curs:");
				panel_center.add(text,"cell 0 3");
				
				JLabel lblNume = new JLabel("Nume: ");
				panel_center.add(lblNume, "cell 0 4,alignx trailing");
				
				JTextField textField_Nume = new JTextField();
				panel_center.add(textField_Nume, "cell 0 4,growx");
				textField_Nume.setColumns(20);
				
				JLabel lblCredit = new JLabel("Credit: ");
				panel_center.add(lblCredit, "cell 0 5,alignx trailing");
				
				JTextField textField_Credit = new JTextField();
				panel_center.add(textField_Credit, "cell 0 5,growx");
				textField_Credit.setColumns(20);
				
				JButton button = new JButton("Adaugare");
				panel_center.add(button,"cell 0 6,growx");
				
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Course curs = new Course(textField_Nume.getText(),Integer.parseInt(textField_Credit.getText()),administrator.getNrIdentificare());
						int id = courseBLL.newCourse(curs);
						
						if(id==-1)
						{
							JOptionPane.showMessageDialog(null, "ERROR!");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Succes, id:"+id);
						}
					}
					
				});
			}
		
		});
		panel_north.add(courses, "cell 0 1");
		
		JButton reports = new JButton("Reports");
		reports.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_center.removeAll();
				panel_center.updateUI();
				
				
				List<Student> lista = studentBLL.getAll();
				
				String[] columnNames = {"ID","Nume","Email","Grupa"};
				
				String[][] data = new String[lista.size()][4];
				
				for (int i=0;i<lista.size();i++)
				{
					data[i][0]=Integer.toString(lista.get(i).getNrIdentificare());
					data[i][1]=lista.get(i).getNume()+" "+lista.get(i).getPrenume();
					data[i][2]=lista.get(i).getEmail();
					data[i][3]=lista.get(i).getGrupa();
					
				}
				
				JTable table = new JTable(data,columnNames);
				
				JScrollPane sp = new JScrollPane(table);
				table.setVisible(true);
				
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getColumnModel().getColumn(1).setPreferredWidth(150);
				table.getColumnModel().getColumn(0).setPreferredWidth(40);
				table.getColumnModel().getColumn(2).setPreferredWidth(180);
				
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
				
				JButton generate = new JButton("Generare");
				panel_center.add(generate,"cell 0 4,growx");
				
				JTextPane text = new JTextPane();
				text.setMinimumSize(new Dimension(100,80));
				text.setEditable(false);
				panel_center.add(text,"cell 0 5,growx");
				
				generate.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						text.setText("ALFA OMEGA ALFA");
						
						
						try {
							SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
							java.util.Date date;
							
							date = sdf1.parse(textField_start.getText());
							
							Date startDate=new java.sql.Date(date.getTime());
							date = sdf1.parse(textField_finish.getText());
							Date finishDate=new java.sql.Date(date.getTime());
							
							float nota = 0;
							int nr_nota=0;
							
							String rezultat="";
							
							Enrolment enrolment = new Enrolment(null,null,null,-1,Integer.parseInt((String)table.getValueAt(table.getSelectedRow(),0)),-1);
							
							List<Enrolment> enrolments = enrolmentBLL.getById(enrolment);
							for(int i=0;i<enrolments.size();i++)
							{
								if(enrolments.get(i).getStartDate().getTime()>=startDate.getTime() && enrolments.get(i).getFinishDate().getTime()<=finishDate.getTime())
								{
									rezultat+=(enrolments.get(i).getCurs().getNume()+", nota: "+enrolments.get(i).getNota()+"\n");
									nota+=enrolments.get(i).getNota()*enrolments.get(i).getCurs().getCredit();
									nr_nota+=enrolments.get(i).getCurs().getCredit();
								}
							}
							
							rezultat+=("Media pe perioada respectiva: "+nota/(float)nr_nota);
							text.setText(rezultat);
							
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			}
		});
		
		panel_north.add(reports,"cell 0 1");
		
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
