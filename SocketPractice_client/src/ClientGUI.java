import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ClientGUI extends JFrame implements ActionListener {
	String userInput;
	
	JTextField textField;
	JButton submitButton;
	
    JTextPane textPane;
    JScrollPane scrollPane;
    
    String logMessage = "";
	
    //construct and visualization ClientGUI
	public ClientGUI() {
		setLayout(new FlowLayout());
		
		textPane = new JTextPane();
	    textPane.setEditable(false);
	    textPane.setPreferredSize(new Dimension(350, 400));
	    
		scrollPane = new JScrollPane(textPane);
		
		textField = new JTextField(25);
		submitButton = new JButton("Submit");
		submitButton.setPreferredSize(new Dimension(90, 19));
		submitButton.addActionListener(this);
		
		this.add(scrollPane);
		this.add(textField);
		this.add(submitButton);
		
		this.setSize(400, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//append log to gui textpane
	public void appendLogger(String log) {
		logMessage += log + "\n";
		textPane.setText(logMessage);
	}
	
	//define button event
	@Override
	public void actionPerformed(ActionEvent e) {
		// Get the text from the text field
        userInput = textField.getText();
        textField.setText("");
        TCPClient1 client = new TCPClient1(userInput, this);
	}
}
