package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class gui {

	private JFrame frame;
	private JTextField txtMsg;
	private JTextField txtSuche;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public gui() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JPanel kontakt_suche_panel = new JPanel();
		kontakt_suche_panel.setBackground(Color.DARK_GRAY);
		kontakt_suche_panel.setBounds(0, 0, 158, 502);
		frame.getContentPane().add(kontakt_suche_panel);
		kontakt_suche_panel.setLayout(null);
		
		txtSuche = new JTextField();
		txtSuche.setBounds(14, 22, 127, 25);
		txtSuche.setHorizontalAlignment(SwingConstants.CENTER);
		txtSuche.setText("Suche");
		kontakt_suche_panel.add(txtSuche);
		txtSuche.setColumns(10);
		
		JScrollPane showsearchkontakt = new JScrollPane();
		showsearchkontakt.setBounds(10, 61, 131, 419);
		kontakt_suche_panel.add(showsearchkontakt);
		
		JPanel panel_msgbereich = new JPanel();
		panel_msgbereich.setBackground(Color.GRAY);
		panel_msgbereich.setBounds(156, 0, 521, 502);
		frame.getContentPane().add(panel_msgbereich);
		panel_msgbereich.setLayout(null);
		
		txtMsg = new JTextField();
		txtMsg.setBounds(20, 443, 380, 35);
		panel_msgbereich.add(txtMsg);
		txtMsg.setText("   Nachricht schreiben...");
		txtMsg.setToolTipText("");
		txtMsg.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 423, 501, 2);
		panel_msgbereich.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		separator_1.setBounds(10, 61, 501, 2);
		panel_msgbereich.add(separator_1);
		
		JButton btnSenden = new JButton("Senden");
		btnSenden.setBounds(410, 443, 89, 35);
		panel_msgbereich.add(btnSenden);
		
		JScrollPane showMsg = new JScrollPane();
		showMsg.setBounds(509, 61, -502, 364);
		panel_msgbereich.add(showMsg);
		
		JPanel panel_aktiv = new JPanel();
		panel_aktiv.setBackground(Color.LIGHT_GRAY);
		panel_aktiv.setBounds(676, 0, 158, 502);
		frame.getContentPane().add(panel_aktiv);
		panel_aktiv.setLayout(null);
		
		JLabel lblChats = new JLabel("Aktive Chats");
		lblChats.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChats.setBounds(38, 25, 100, 14);
		panel_aktiv.add(lblChats);
		frame.setBounds(100, 100, 850, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
