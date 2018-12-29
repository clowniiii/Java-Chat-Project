package client;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class GUI {

	private JFrame frame;
	private CardLayout cl;
	private JScrollPane sp;
	private JTextArea ta;
	private JButton btnSend;
	private JTextField typeField;
	private JTextField nickField;
	private JLabel lblNickname;
	Client model;
	
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JTextField getNickField() {
		return nickField;
	}
	public void setNickField(JTextField nickField) {
		this.nickField = nickField;
	}
	public JTextField getText() {
		return typeField;
	}
	public void setText(JTextField typeField) {
		this.typeField = typeField;
	}
	
	public JButton getButton() {
		return btnSend;
	}
	public void setButton(JButton btnSend) {
		this.btnSend = btnSend;
	}

	public JTextArea getTa() {
		return ta;
	}
	public void setTa(JTextArea ta) {
		this.ta = ta;
	}
	public JScrollPane getSp() {
		return sp;
	}
	public void setSp(JScrollPane sp) {
		this.sp = sp;
	}
	
	/**
	 * Create the application.
	 */
	public GUI(Client model) {
		super();
		initialize(model);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Client model) {
		
		cl = new CardLayout();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(cl);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_19554600569754");
		panel.setLayout(null);
		
		sp = new JScrollPane();
		sp.setBounds(135, 42, 289, 174);
		panel.add(sp);
		
		ta = new JTextArea();
		sp.setViewportView(ta);
		
		btnSend = new JButton("Senden");
		btnSend.setBounds(335, 227, 89, 23);
		panel.add(btnSend);
		btnSend.addActionListener(new SendMessageButton());
	
		typeField = new JTextField();
		typeField.setBounds(135, 227, 190, 23);
		panel.add(typeField);
		typeField.setColumns(10);
		
		nickField = new JTextField();
		nickField.setLocation(135, 11);
		nickField.setSize(100, 20);
		panel.add(nickField);
		
		lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(245, 14, 62, 14);
		panel.add(lblNickname);
	}
	
	//ActionListener für Sende-Button
		public class SendButtonMessage implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.sendMessageToServer();
				
			}
			
		}
}
