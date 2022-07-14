package computerArchitecture;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Micro1Viewer extends JFrame  {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("R0");
	public JTextField textField = new JTextField();
	private final JLabel lblNewLabel_1 = new JLabel("R1");
	public JTextField textField_1 = new JTextField();
	private final JLabel lblNewLabel_2 = new JLabel("R2");
	public JTextField textField_2 = new JTextField();
	private final JLabel lblNewLabel_3 = new JLabel("R3");
	public JTextField textField_3 = new JTextField();
	private final JLabel lblNewLabel_4 = new JLabel("R4");
	public JTextField textField_4 = new JTextField();
	private final JLabel lblNewLabel_5 = new JLabel("R5");
	public JTextField textField_5 = new JTextField();
	private final JLabel lblNewLabel_6 = new JLabel("R6");
	public JTextField textField_6 = new JTextField();
	private final JLabel lblNewLabel_7 = new JLabel("R7");
	public JTextField textField_7 = new JTextField();
	private final JButton btnNewButton = new JButton("Execute");
	private final JButton btnNewButton_1 = new JButton("LOAD");
	private final JButton btnNewButton_2 = new JButton("MEMORY");
	private final JButton btnNewButton_3 = new JButton("REGISTERS");
	private final JLabel lblNewLabel_8 = new JLabel("Cell100");
	private final JLabel lblNewLabel_9 = new JLabel("Cell101");
	private final JLabel lblNewLabel_10 = new JLabel("Cell102");
	private final JLabel lblNewLabel_11 = new JLabel("Cell103");
	private final  JTextField textField_8 = new JTextField();
	public JTextField textField_9 = new JTextField();
	public JTextField textField_10 = new JTextField();
	public JTextField textField_11 = new JTextField();
	private Micro1Viewerstate state;
	private Memory m3=new Memory();
	private Processor p3=new Processor(m3);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Micro1Viewer frame = new Micro1Viewer();
					frame.start();
				}
				catch(Exception e) {
					System.out.println(e);
				}
				
				}
			
		});}
	

	/**
	 * Create the frame.
	 */
	public Micro1Viewer() {
		textField_11.setBounds(192, 101, 96, 26);
		textField_11.setColumns(10);
		textField_10.setBounds(192, 68, 96, 26);
		textField_10.setColumns(10);
		textField_9.setBounds(188, 40, 96, 26);
		textField_9.setColumns(10);
		textField_8.setBounds(188, 12, 96, 26);
		textField_8.setColumns(10);
		textField_7.setBounds(46, 227, 67, 26);
		textField_7.setColumns(10);
		textField_6.setBounds(46, 198, 67, 26);
		textField_6.setColumns(10);
		textField_5.setBounds(46, 168, 67, 26);
		textField_5.setColumns(10);
		textField_4.setBounds(46, 135, 67, 26);
		textField_4.setColumns(10);
		textField_3.setBounds(46, 106, 67, 26);
		textField_3.setColumns(10);
		textField_2.setBounds(46, 73, 67, 26);
		textField_2.setColumns(10);
		textField_1.setBounds(46, 40, 67, 26);
		textField_1.setColumns(10);
		textField.setBounds(46, 12, 67, 26);
		textField.setColumns(10);
		state=  new ClosedMicro1Viewerstate(this,this.m3,this.p3);
		initGUI();
		
		
		btnNewButton.addActionListener(new ActionListener() {
			

			
			public void actionPerformed(ActionEvent e) {
				
				state.execute();
			}
		});
		
btnNewButton_2.addActionListener(new ActionListener() {
			
;

			public void actionPerformed(ActionEvent e) {
			    
				
				state.memorydump();
				
			}
		});
		
btnNewButton_1.addActionListener(new ActionListener() {
	

		public void actionPerformed(ActionEvent e) {
		/*
			 File testFile = new File("");
			    String currentPath = testFile.getAbsolutePath();
			    System.out.println("current path is: " + currentPath);
			*/    
			//File file = new File("/src/Program1.txt");

			state.load();

			//	state.load();


		}
		
	});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			state.registerdump();
		}
		});
		
}
	  
	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(17, 17, 38, 16);
		
		contentPane.add(lblNewLabel);
		
		contentPane.add(textField);
		lblNewLabel_1.setBounds(17, 45, 32, 16);
		
		contentPane.add(lblNewLabel_1);
		
		contentPane.add(textField_1);
		lblNewLabel_2.setBounds(17, 73, 38, 16);
		
		contentPane.add(lblNewLabel_2);
		
		contentPane.add(textField_2);
		lblNewLabel_3.setBounds(17, 111, 43, 16);
		
		contentPane.add(lblNewLabel_3);
		
		contentPane.add(textField_3);
		lblNewLabel_4.setBounds(17, 140, 38, 16);
		
		contentPane.add(lblNewLabel_4);
		
		contentPane.add(textField_4);
		lblNewLabel_5.setBounds(17, 168, 32, 16);
		
		contentPane.add(lblNewLabel_5);
		
		contentPane.add(textField_5);
		lblNewLabel_6.setBounds(17, 203, 38, 16);
		
		contentPane.add(lblNewLabel_6);
		
		contentPane.add(textField_6);
		lblNewLabel_7.setBounds(17, 232, 38, 16);
		
		contentPane.add(lblNewLabel_7);
		
		contentPane.add(textField_7);
		/*
		btnNewButton.addActionListener(new ActionListener() {
			private Micro1Viewerstate state;

			
			public void actionPerformed(ActionEvent e) {
				
				this.state.step();
			}
		});
		*/
		btnNewButton.setBounds(217, 227, 117, 29);
		
		contentPane.add(btnNewButton);
	//	btnNewButton_1.addActionListener(new ActionListener() {
	//		private Micro1Viewerstate state;

	//		public void actionPerformed(ActionEvent e) {
				
	//			String f="src/Program1.txt";
	//			this.state.load(f);
	//		
	//		}
			
	//	});
		btnNewButton_1.setBounds(217, 198, 117, 29);
		
		contentPane.add(btnNewButton_1);
		/*
		btnNewButton_2.addActionListener(new ActionListener() {
			
			private Micro1Viewerstate state;
;

			public void actionPerformed(ActionEvent e) {
			    
				this.state=  new ClosedMicro1Viewerstate(this);
				this.state.memorydump();
				
			}
		});
		*/
		btnNewButton_2.setBounds(327, 198, 117, 29);
		
		contentPane.add(btnNewButton_2);

		btnNewButton_3.setBounds(327, 227, 117, 29);
		
		contentPane.add(btnNewButton_3);
		lblNewLabel_8.setBounds(125, 17, 61, 16);
		
		contentPane.add(lblNewLabel_8);
		lblNewLabel_9.setBounds(125, 45, 61, 16);
		
		contentPane.add(lblNewLabel_9);
		lblNewLabel_10.setBounds(125, 73, 61, 16);
		
		contentPane.add(lblNewLabel_10);
		lblNewLabel_11.setBounds(125, 106, 61, 16);
		
		contentPane.add(lblNewLabel_11);
		
		contentPane.add(textField_8);
		
		contentPane.add(textField_9);
		
		contentPane.add(textField_10);
		
		contentPane.add(textField_11);
	}
	public void start() {
		setVisible(true);
	}
	public void changeState(Micro1Viewerstate m)
	{
		this.state=m;
	}
	public void setvalue(String a)
	{
		textField_8.setText(a);
	}
}
