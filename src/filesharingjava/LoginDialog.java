package filesharingjava;

import filesharingjava.Dropper;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// Creates login window

public class LoginDialog {
	private final static String CrLf = "\r\n";
	private static JFrame frame = null;
	private static JLabel infoMessage = null;

	public static void main(String[] args) {
		frame = new JFrame("Enter Information");
		frame.setSize(301, 186);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);
		
		infoMessage = new JLabel("infoMessage");
		infoMessage.setBounds(100, 76, 80, 25);
		panel.add(infoMessage);
		infoMessage.setVisible(false);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 112, 80, 25);
		panel.add(loginButton);
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				URLConnection conn = null;
				OutputStream os = null;
				InputStream is = null;

				try {
                                            //Uncomment it when you will use it with server php file
					/*
					String postData = "";
					String username = new String(userText.getText());
					String password = new String(passwordText.getText());
					//add url of server php file
                                        URL url = new URL("http://URL_Path/fileName.php?username="+username+"&password="+password);

                                        conn = url.openConnection();
					conn.setDoOutput(true);
					
                                        is = conn.getInputStream();

					char buff = 5048;
					int len;
					byte[] data = new byte[buff];
					String response = "";
					do {
						len = is.read(data);
                                        	if (len > 0) {
							response = new String(data, 0, len);
						}
					} while (len > 0);
                                        */
                                    //comment String response when you are using server php It is only for demo
                                   String response = "SUCCESS";
                                        
					if(response.indexOf("SUCCESS") != -1){
						//Open new swing window
						System.out.println("Successfully Logged In");
						frame.dispose();
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Dropper frame = new Dropper("hello");
									frame.setSize(690, 600);
                                                                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                        frame.setVisible(true);	
                                                                                                                                                
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}else{
						//error message alert box
						infoMessage.setText("Wrong Credentials");
						infoMessage.setVisible(true);
                                                
                                            JOptionPane.showMessageDialog(null, "WRONG Credential... Try Again", "alert", JOptionPane.ERROR_MESSAGE);
                                            Object[] possibleValues = { "I want to try login", "Forgot password" };
                                            Object selectedValue = JOptionPane.showInputDialog(null,"Choose one", "Input",JOptionPane.INFORMATION_MESSAGE, null,
possibleValues, possibleValues[0]);
                                            if(selectedValue == "Forgot password")
                                            {
                                                java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://URL_Path/forgot-password.php"));
                                            }
					}
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					is.close();
				} catch (Exception exc) {
					exc.printStackTrace();
				}
				// TODO Auto-generated method stub
			}
		});

		JButton registerButton = new JButton("register");
		registerButton.setBounds(180, 112, 80, 25);
		panel.add(registerButton);
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://toshit-rane.com/"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}