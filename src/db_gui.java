import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class db_gui extends JFrame {

	private JPanel contentPane;
	private JLabel lblConnect;
	private JLabel lblCustomerCount;
	private JLabel lblCustomerNames;
	private JLabel lblOrderCount;
	private JLabel lblOrderShipNames;
	private JLabel lblEmployeeCount;
	private JLabel lblEmployeeNames;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JLabel lblServer;
	private JLabel lblDatabase;
	private JButton btnConnectToDB;
	private JButton btnCustomerCount;
	private JButton btnGetCompanyNames;
	private JButton btnOrderCount;
	private JButton btnGetOrderShipNames;
	private JButton btnEmployeeCount;
	private JButton btnGetEmployeeNames;
	private JSeparator separator_1;
	private JTextField textFieldUser;
	private JTextField textFieldPassword;
	private JTextField textFieldServer;
	private JTextField textFieldDatabase;
	private JButton btnLogin;
	
	private DB controller;
	private String user;
	private String password;
	private String server;
	private String database;
	private Boolean isValid = true;
	private JSeparator separator;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					db_gui frame = new db_gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public db_gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblConnect = new JLabel("Connect");
		lblConnect.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConnect.setBounds(266, 485, 82, 31);
		contentPane.add(lblConnect);
		
		lblCustomerCount = new JLabel("Customer Count");
		lblCustomerCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomerCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerCount.setBounds(63, 33, 141, 14);
		contentPane.add(lblCustomerCount);
		
		lblCustomerNames = new JLabel("Customer Names");
		lblCustomerNames.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomerNames.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerNames.setBounds(63, 70, 141, 14);
		contentPane.add(lblCustomerNames);
		
		lblOrderCount = new JLabel("Order Count");
		lblOrderCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrderCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrderCount.setBounds(105, 125, 99, 14);
		contentPane.add(lblOrderCount);
		
		lblOrderShipNames = new JLabel("Order Ship Names");
		lblOrderShipNames.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrderShipNames.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrderShipNames.setBounds(73, 163, 131, 14);
		contentPane.add(lblOrderShipNames);
		
		lblEmployeeCount = new JLabel("Employee Count");
		lblEmployeeCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployeeCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeCount.setBounds(80, 226, 124, 24);
		contentPane.add(lblEmployeeCount);
		
		lblEmployeeNames = new JLabel("Employee Names");
		lblEmployeeNames.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployeeNames.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeNames.setBounds(80, 266, 124, 22);
		contentPane.add(lblEmployeeNames);
		
		lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUser.setBounds(158, 338, 46, 14);
		contentPane.add(lblUser);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(122, 363, 82, 14);
		contentPane.add(lblPassword);
		
		lblServer = new JLabel("Server");
		lblServer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblServer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblServer.setBounds(136, 388, 68, 14);
		contentPane.add(lblServer);
		
		lblDatabase = new JLabel("Database");
		lblDatabase.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDatabase.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatabase.setBounds(122, 413, 82, 17);
		contentPane.add(lblDatabase);
		
		btnConnectToDB = new JButton("Connect to Database");
		btnConnectToDB.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConnectToDB.setBounds(112, 520, 373, 30);
		btnConnectToDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(isValid) {
						String dbURL = 
								"jdbc:sqlserver://" + server + "\\SQLEXPRESS01;"
								+ "database=" + database + ";"
								+ "user=" + user + ";"
								+ "password=" + password + ";"
								+ "encrypt=false;"
								+ "trustServerCertificate=true;"
								+ "loginTimeout=30;";
						
						controller = new DB(dbURL);
						System.out.println(controller);
						System.out.println(dbURL);
						JOptionPane.showMessageDialog(null, "Connected");
								
					} else {
						JOptionPane.showMessageDialog(null, "Unable to connect");
					}
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				}
			});
		contentPane.add(btnConnectToDB);
		
		btnCustomerCount = new JButton("CustomerCount");
		btnCustomerCount.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCustomerCount.setBounds(235, 25, 250, 30);
		btnCustomerCount .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String returnedValue = controller.getCustomerCount();
					JOptionPane.showMessageDialog(null, "The customer count is: " + returnedValue);
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		contentPane.add(btnCustomerCount);
		
		btnGetCompanyNames = new JButton("Get Company Names");
		btnGetCompanyNames.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGetCompanyNames.setBounds(235, 62, 250, 30);
		btnGetCompanyNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String returnedValue = controller.getCompanyName();
					JOptionPane.showMessageDialog(null, "Customer names: "+returnedValue);
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		contentPane.add(btnGetCompanyNames);
		
		btnOrderCount = new JButton("Order Count");
		btnOrderCount.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOrderCount.setBounds(235, 117, 250, 30);
		btnOrderCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String returnedValue = controller.getOrderCount();
					JOptionPane.showMessageDialog(null, "The order count is: " + returnedValue);
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		contentPane.add(btnOrderCount);
		
		btnGetOrderShipNames = new JButton("Get Order Ship Names");
		btnGetOrderShipNames.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGetOrderShipNames.setBounds(235, 155, 250, 30);
		btnGetOrderShipNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String returnedValue = controller.getShipNames();
					JOptionPane.showMessageDialog(null, "Order Ship Names: "+returnedValue);
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		contentPane.add(btnGetOrderShipNames);
		
		btnEmployeeCount = new JButton("Employee Count");
		btnEmployeeCount.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEmployeeCount.setBounds(235, 223, 250, 30);
		btnEmployeeCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String returnedValue = controller.getEmployeeCount();
					JOptionPane.showMessageDialog(null, "The employee count is: " + returnedValue);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		contentPane.add(btnEmployeeCount);
		
		btnGetEmployeeNames = new JButton("Get Employee Names");
		btnGetEmployeeNames.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGetEmployeeNames.setBounds(235, 262, 250, 30);
		btnGetEmployeeNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String returnedValue = controller.getEmployeeNames();
					JOptionPane.showMessageDialog(null, returnedValue);
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		contentPane.add(btnGetEmployeeNames);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(74, 308, 474, 9);
		contentPane.add(separator_1);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(235, 337, 250, 20);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(235, 362, 250, 20);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		textFieldServer = new JTextField();
		textFieldServer.setBounds(235, 387, 250, 20);
		contentPane.add(textFieldServer);
		textFieldServer.setColumns(10);
		
		textFieldDatabase = new JTextField();
		textFieldDatabase.setBounds(235, 413, 250, 20);
		contentPane.add(textFieldDatabase);
		textFieldDatabase.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(112, 444, 373, 30);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				server = new String(textFieldServer.getText());
				database = new String(textFieldDatabase.getText());
				user = new String(textFieldUser.getText());
				password = new String(textFieldPassword.getText());
				
				//Test for null values
				if(user.isEmpty() || password.isEmpty() || database.isEmpty() || server.isEmpty()) {
					isValid = false;
					JOptionPane.showMessageDialog(null, "You must enter a user name, password, server, and database");
					
				} else {
					isValid = true;
					JOptionPane.showMessageDialog(null, "Values Accepted");
				}
			}
		});
		contentPane.add(btnLogin);
		
		separator = new JSeparator();
		separator.setBounds(74, 485, 474, 9);
		contentPane.add(separator);
	}
}
