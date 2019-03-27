package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.entities.EnrolmentBLL;
import business.entities.StudentBLL;
import data.DAO.EnrolmentDAO;
import data.DAO.StudentDAO;
import data.entities.Course;
import data.entities.Enrolment;
import data.entities.Student;
import net.miginfocom.swing.MigLayout;

public class CursInfo extends JFrame {

	private JPanel contentPane;
	EnrolmentBLL enrolmentBLL = new EnrolmentBLL();
	StudentBLL studentBLL = new StudentBLL();
	/**
	 * Create the frame.
	 */
	public CursInfo(Course curs) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CursInfo");
		setBounds(200, 100, 600, 510);
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
		
		JLabel lblBineAiVenit = new JLabel("Detalii "+curs.getNume()+", nr credite: "+curs.getCredit()+", ID professor:"+curs.getidAdministrator());
		lblBineAiVenit.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_north.add(lblBineAiVenit, "flowx,cell 0 0");
		
		List<Enrolment> enrollments = enrolmentBLL.getByIdCourse(curs.getId());
		
		String[] columnNames = {"ID","Student","Start date","Finish date","Nota"};
		
		String[][] data = new String[enrollments.size()][5];
		
		for (int i=0;i<enrollments.size();i++)
		{
			Student student = studentBLL.getByID(enrollments.get(i).getStudentID());

			data[i][1]=student.getNume()+" "+student.getPrenume();
			data[i][0]=Integer.toString(enrollments.get(i).getEnrolmentID());
			data[i][2]=enrollments.get(i).getStartDate().toString();
			data[i][3]=enrollments.get(i).getFinishDate().toString();
			
			int nota = enrollments.get(i).getNota();
			if(nota==-1)
			{
				data[i][4]="Neterminat";
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
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		
		panel_center.add(sp,"cell 0 1");
		
		JLabel nota = new JLabel("nota");
		panel_center.add(nota,"cell 0 2");
		
		JTextField textField_nota = new JTextField();
		panel_center.add(textField_nota, "cell 0 2,growx");
		textField_nota.setColumns(20);
		
		JButton button = new JButton("Adaugare nota");
		panel_center.add(button,"cell 0 3");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(),0));
				enrolmentBLL.update(id, Integer.parseInt(textField_nota.getText()));
				JOptionPane.showMessageDialog(null, "Succes!");
				setVisible(false);
			}
			
		});
		
		JButton button_inapoi = new JButton("Inapoi");
		panel_center.add(button_inapoi,"cell 0 3,growx");
		
		button_inapoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
			
		});
		
	}

}
