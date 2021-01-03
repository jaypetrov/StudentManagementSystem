package StudentManagement;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.MessageFormat;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentGUI {

	private JFrame frame;
	private JTextField textStudentid;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textAddress;
	private JTextField textCityTown;
	private JTextField textTotalScore;
	private JTextField textAverage;
	private JTextField textZipCode;
	private JTextField textIntroProg;
	private JTextField textCompOrg;
	private JTextField textProgPrinc;
	private JTextField textAssembler;
	private JTextField textDataStr;
	private JTextField textProgLang;
	private JTextField textOpSys;
	private JTextField textSoftEng;
	private JComboBox comboState;
	private JLabel lblStudentId;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblAddress;
	private JLabel lblCityTown;
	private JLabel lblTotalScore;
	private JLabel lblAverage;
	private JLabel lblStateZip;
	private JLabel lblProgLang;
	private JLabel lblCompOrg;
	private JLabel lblProgPrinc;
	private JLabel lblAssProg;
	private JLabel lblDataStruct;
	private JLabel lblIntro;
	private JLabel lblOpSys;
	private JLabel lblSOftEng;
	private JButton btnStudResult;
	private JButton btnTrnascript;
	private JButton btnUpdateTable;
	private JButton btnDelete;
	private JButton btnReset;
	private JButton btnExit;
	private JTable table;

	protected Connection connect = null;
	protected PreparedStatement pst = null;


	/**
	 * Create the application.
	 */
	public StudentGUI() {
		initialize();
		getDataDatabase();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBorder(new LineBorder(new Color(30, 144, 255), 12));
		panel.setBounds(27, 24, 850, 347);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		lblStudentId = new JLabel("Student ID:");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentId.setBounds(39, 32, 109, 28);
		panel.add(lblStudentId);

		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFirstName.setBounds(39, 71, 109, 28);
		panel.add(lblFirstName);

		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastName.setBounds(39, 110, 109, 28);
		panel.add(lblLastName);

		lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddress.setBounds(39, 149, 109, 28);
		panel.add(lblAddress);

		lblCityTown = new JLabel("City/Town");
		lblCityTown.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCityTown.setBounds(39, 188, 109, 28);
		panel.add(lblCityTown);

		lblTotalScore = new JLabel("Total Score:");
		lblTotalScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotalScore.setBounds(39, 266, 109, 28);
		panel.add(lblTotalScore);

		lblAverage = new JLabel("Average:");
		lblAverage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAverage.setBounds(39, 301, 109, 28);
		panel.add(lblAverage);

		lblStateZip = new JLabel("Zip Code/State");
		lblStateZip.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStateZip.setBounds(39, 227, 143, 28);
		panel.add(lblStateZip);

		lblIntro = new JLabel("Introduction To Programming");
		lblIntro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIntro.setBounds(378, 32, 238, 28);
		panel.add(lblIntro);

		lblCompOrg = new JLabel("Computer Organization");
		lblCompOrg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCompOrg.setBounds(378, 71, 238, 28);
		panel.add(lblCompOrg);

		lblProgPrinc = new JLabel("Programming Principles");
		lblProgPrinc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProgPrinc.setBounds(378, 110, 204, 28);
		panel.add(lblProgPrinc);

		lblAssProg = new JLabel("Assembler Programming");
		lblAssProg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAssProg.setBounds(378, 149, 204, 28);
		panel.add(lblAssProg);

		lblDataStruct = new JLabel("Data Structures & Algorithms");
		lblDataStruct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataStruct.setBounds(378, 188, 238, 28);
		panel.add(lblDataStruct);

		lblProgLang = new JLabel("Programming Languages");
		lblProgLang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProgLang.setBounds(378, 227, 204, 28);
		panel.add(lblProgLang);

		lblOpSys = new JLabel("Operating Systems");
		lblOpSys.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOpSys.setBounds(378, 266, 204, 28);
		panel.add(lblOpSys);

		lblSOftEng = new JLabel("Software Engineering");
		lblSOftEng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSOftEng.setBounds(378, 305, 204, 28);
		panel.add(lblSOftEng);

		textStudentid = new JTextField();
		textStudentid.setBounds(192, 33, 159, 27);
		textStudentid.setColumns(10);
		panel.add(textStudentid);

		textFirstName = new JTextField();
		textFirstName.setColumns(10);
		textFirstName.setBounds(192, 71, 159, 27);
		panel.add(textFirstName);

		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(192, 112, 159, 27);
		panel.add(textLastName);

		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(192, 150, 159, 27);
		panel.add(textAddress);

		textCityTown = new JTextField();
		textCityTown.setColumns(10);
		textCityTown.setBounds(192, 188, 159, 27);
		panel.add(textCityTown);

		textTotalScore = new JTextField();
		textTotalScore.setEditable(false);
		textTotalScore.setColumns(10);
		textTotalScore.setBounds(192, 266, 159, 27);
		panel.add(textTotalScore);

		textAverage = new JTextField();
		textAverage.setEditable(false);
		textAverage.setColumns(10);
		textAverage.setBounds(192, 305, 159, 27);
		panel.add(textAverage);

		textZipCode = new JTextField();
		textZipCode.setColumns(10);
		textZipCode.setBounds(192, 227, 104, 27);
		panel.add(textZipCode);

		textIntroProg = new JTextField();
		textIntroProg.setColumns(10);
		textIntroProg.setBounds(626, 33, 159, 27);
		panel.add(textIntroProg);

		textCompOrg = new JTextField();
		textCompOrg.setColumns(10);
		textCompOrg.setBounds(626, 71, 159, 27);
		panel.add(textCompOrg);

		textProgPrinc = new JTextField();
		textProgPrinc.setColumns(10);
		textProgPrinc.setBounds(626, 112, 159, 27);
		panel.add(textProgPrinc);

		textAssembler = new JTextField();
		textAssembler.setColumns(10);
		textAssembler.setBounds(626, 150, 159, 27);
		panel.add(textAssembler);

		textDataStr = new JTextField();
		textDataStr.setColumns(10);
		textDataStr.setBounds(626, 188, 159, 27);
		panel.add(textDataStr);

		textProgLang = new JTextField();
		textProgLang.setColumns(10);
		textProgLang.setBounds(626, 226, 159, 27);
		panel.add(textProgLang);

		textOpSys = new JTextField();
		textOpSys.setColumns(10);
		textOpSys.setBounds(626, 266, 159, 27);
		panel.add(textOpSys);

		textSoftEng = new JTextField();
		textSoftEng.setColumns(10);
		textSoftEng.setBounds(626, 304, 159, 27);
		panel.add(textSoftEng);

		comboState = new JComboBox();
		comboState.setModel(new DefaultComboBoxModel(new String[] { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE",
				"FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO",
				"MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN",
				"TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));
		comboState.setBounds(306, 227, 43, 28);
		panel.add(comboState);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(30, 144, 255), 12));
		panel_1.setBackground(new Color(135, 206, 250));
		panel_1.setBounds(903, 24, 460, 347);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 440, 325);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		panel_1.add(textArea);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(30, 144, 255), 12));
		panel_2.setBackground(new Color(135, 206, 250));
		panel_2.setBounds(27, 393, 1336, 229);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1316, 207);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "StudentID", "Intro to Programming", "Computer Organization", "Programming Principles",
						"Assembler Programming", "Data Structures & Algorithms", "Programming Languages",
						"Operating Systems", "Software Engineering", "Average Score", "Total Score" }) {

			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class,
					Object.class, Object.class, Object.class, Object.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false,
					false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++)
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(40);
		table.getColumnModel().getColumn(8).setPreferredWidth(60);
		table.getColumnModel().getColumn(9).setPreferredWidth(18);
		table.getColumnModel().getColumn(10).setPreferredWidth(10);
		scrollPane.setViewportView(table);

		// ============BUTTON STUDENT RESULT===============
		btnStudResult = new JButton("Student Results");
		btnStudResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double R[] = new double[11];
				R[1] = Double.parseDouble(textIntroProg.getText());
				R[2] = Double.parseDouble(textCompOrg.getText());
				R[3] = Double.parseDouble(textProgPrinc.getText()); //////
				R[4] = Double.parseDouble(textAssembler.getText());
				R[5] = Double.parseDouble(textDataStr.getText());
				R[6] = Double.parseDouble(textProgLang.getText());
				R[7] = Double.parseDouble(textOpSys.getText());
				R[8] = Double.parseDouble(textSoftEng.getText());

				double total = 0;
				for (int i = 0; i < R.length; i++) {
					total += R[i];
				}
				System.out.println("Total: " + R[9]);
				R[9] = total;
				R[10] = total = total / 8;

				String totalScore = String.format("%.0f", R[9]);
				textTotalScore.setText(totalScore);

				System.out.println("totalScore: " + totalScore);

				String averageScore = String.format("%.0f", R[10]);
				textAverage.setText(averageScore);

				System.out.println("averageScore: " + averageScore);

				// ==================INSERT DATABASE STUDENTGRADE=============
				String sqlInsertStudentGrades = "INSERT INTO StudentGrades(StudentID  ,IntroductionToProgramming ,ComputerOrganization ,"
						+ "ProgrammingPrinciples ,AssemblerProgramming ,DataStructures ,ProgrammingLanguages ,OperatingSystems ,"
						+ "SoftwareEngineering ,AverageScore ,TotalScore) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

				connect = SQLiteDatabase.ConnectDB();
				try {
					pst = connect.prepareStatement(sqlInsertStudentGrades);
					pst.setString(1, textStudentid.getText());
					pst.setString(2, textIntroProg.getText());
					pst.setString(3, textCompOrg.getText());
					pst.setString(4, textProgPrinc.getText());
					pst.setString(5, textAssembler.getText());
					pst.setString(6, textDataStr.getText());
					pst.setString(7, textProgLang.getText());
					pst.setString(8, textOpSys.getText());
					pst.setString(9, textSoftEng.getText());
					pst.setString(10, textAverage.getText());
					pst.setString(11, textTotalScore.getText());
					pst.execute();

				} catch (Exception ex) {

					System.out.println("Failed to update StudentGrades");
					System.out.println(ex);
				}

				try {
					// ====================INSERT DATABASE STUDENTInfo==================
					String sqlInsertStudentInfo = "INSERT INTO StudentInfo(FIRSTNAME,LASTNAME,ADDRESS,CITY,STATE,ZIPCODE,StudentGrades_ID) VALUES(?,?,?,?,?,?,?)";
					pst = connect.prepareStatement(sqlInsertStudentInfo);
					pst.setString(1, textFirstName.getText());
					pst.setString(2, textLastName.getText());
					pst.setString(3, textAddress.getText());
					pst.setString(4, textCityTown.getText());
					pst.setString(5, (String) comboState.getSelectedItem());
					pst.setString(6, textZipCode.getText());
					pst.setString(7, textStudentid.getText());
					pst.execute();
					
					pst.close();
					connect.close();;

				} catch (Exception e2) {
					System.out.println("Failed to update StudentInfo");
					System.out.println(e2);
				}

				getDataDatabase();

			}
		});

		btnStudResult.setForeground(Color.WHITE);
		btnStudResult.setBackground(new Color(0, 0, 255));
		btnStudResult.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnStudResult.setBounds(27, 633, 208, 48);
		frame.getContentPane().add(btnStudResult);

		// ===================BUTTON TRANSCRIPT==================

		btnTrnascript = new JButton("Trnascript");
		btnTrnascript.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.append("Student Results Transcript\n");
				textArea.append("================================");
				textArea.append(String.format("\n %-40s %-20s", "Student ID", textStudentid.getText()));
				textArea.append(String.format("\n %-40s %-20s", "First Name", textFirstName.getText()));
				textArea.append(String.format("\n %-40s %-20s", "Last Name", textLastName.getText()));

				textArea.append(
						String.format("\n %-40s %-20s", "Introduction To Programming", textIntroProg.getText()));
				textArea.append(String.format("\n %-40s %-20s", "Computer Organization", textCompOrg.getText()));
				textArea.append(String.format("\n %-40s %-20s", "Programming Principles", textProgPrinc.getText()));
				textArea.append(String.format("\n %-40s %-20s", "Assembler Programming", textAssembler.getText()));
				textArea.append(String.format("\n %-40s %-20s", "Data Structures & Algorithms", textDataStr.getText()));
				textArea.append(String.format("\n %-40s %-20s", "Programming Languages", textProgLang.getText()));
				textArea.append(String.format("\n %-40s %-20s", "Operating Systems", textOpSys.getText()));
				textArea.append(String.format("\n %-40s %-20s", "Software Engineering", textSoftEng.getText()));
				textArea.append("\n---------------------------------");
				textArea.append(String.format("\n %-40s %-20s", "Total Score", textTotalScore.getText()));
				textArea.append(String.format("\n %-40s %-20s", "Average", textAverage.getText()));

			}
		});

		btnTrnascript.setForeground(Color.WHITE);
		btnTrnascript.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTrnascript.setBackground(Color.BLUE);
		btnTrnascript.setBounds(245, 633, 218, 48);
		frame.getContentPane().add(btnTrnascript);

		// ==================UPDATE DELETE==================
		btnUpdateTable = new JButton("Update Table");
		btnUpdateTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDataDatabase();
			}
		});

		btnUpdateTable.setForeground(Color.WHITE);
		btnUpdateTable.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdateTable.setBackground(Color.BLUE);
		btnUpdateTable.setBounds(473, 633, 208, 48);
		frame.getContentPane().add(btnUpdateTable);

		// ==================BUTTON DELETE==================
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if (table.getSelectedRow() == -1) {
					if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "No data to delete", "Student result System",
								JOptionPane.OK_OPTION);
					} else {
						JOptionPane.showMessageDialog(null, "Select a row to delete", "Student result System",
								JOptionPane.OK_OPTION);
					}
				} else {
					
					
					String deleteStudentInfoQuery = "delete from StudentInfo where StudentGrades_ID == (?)";
					String deleteStudentGradesQuery = "delete from StudentGrades where StudentID == (?)";
					String ideDelete = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
					System.out.println(ideDelete);

					try {
						connect = SQLiteDatabase.ConnectDB();
						pst = connect.prepareStatement(deleteStudentInfoQuery);
						pst.setString(1, ideDelete);
						pst.execute();

						pst = connect.prepareStatement(deleteStudentGradesQuery);
						pst.setString(1, ideDelete);
						pst.execute();
						
						pst.close();
						connect.close();

					} catch (SQLException e1) {
						System.out.println("Error Delate: " + e1);
						e1.printStackTrace();
					}

					model.removeRow(table.getSelectedRow());
				}
			}
		});

		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBackground(Color.BLUE);
		btnDelete.setBounds(691, 633, 222, 48);
		frame.getContentPane().add(btnDelete);

		// ========================BUTTON RESET==================
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JTextField temp = null;
				for (Component c : panel.getComponents()) {
					if (c.getClass().toString().contains("javax.swing.JTextField")) {
						temp = (JTextField) c;
						temp.setText(null);
					}
				}
				textArea.setText(null);

			}
		});

		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBackground(Color.BLUE);
		btnReset.setBounds(923, 633, 222, 48);
		frame.getContentPane().add(btnReset);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Do you want to CLOSE the application",
						"Student Grade System Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBackground(Color.BLUE);
		btnExit.setBounds(1155, 633, 208, 48);
		frame.getContentPane().add(btnExit);
		frame.setBounds(0, 0, 1400, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	} // end initialize

	public void getDataDatabase() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int rowCown = model.getRowCount();
		for (int i = rowCown - 1; i >= 0; i--) {
			model.removeRow(i);
		}

		connect = SQLiteDatabase.ConnectDB(); // DDD
		if (connect != null) {
			String sql = "SELECT StudentID,  IntroductionToProgramming, ComputerOrganization, ProgrammingPrinciples, "
					+ "AssemblerProgramming, DataStructures,"
					+ " ProgrammingLanguages, OperatingSystems, SoftwareEngineering, AverageScore, TotalScore from StudentGrades";
			try {

				pst = connect.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				Object[] columnData = new Object[11];

				while (rs.next()) {
					columnData[0] = rs.getString("StudentID");
					columnData[1] = rs.getString("IntroductionToProgramming");
					columnData[2] = rs.getString("ComputerOrganization");
					columnData[3] = rs.getString("ProgrammingPrinciples");
					columnData[4] = rs.getString("AssemblerProgramming");
					columnData[5] = rs.getString("DataStructures");
					columnData[6] = rs.getString("ProgrammingLanguages");
					columnData[7] = rs.getString("OperatingSystems");
					columnData[8] = rs.getString("SoftwareEngineering");
					columnData[9] = rs.getString("AverageScore");
					columnData[10] = rs.getString("TotalScore");
					model.addRow(columnData);
				}
				
				pst.close();
				connect.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
				System.out.println("Error update table: " + e);
			}
		}
	}

	/**
	 * Launch the application/ MAIN.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentGUI window = new StudentGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
