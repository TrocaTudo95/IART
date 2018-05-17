package weka;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import weka.classifiers.trees.J48;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;

public class App2 {

	private JFrame frame;
	private static JCheckBox chckbxPrunned;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App2 window = new App2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("IART-FEUP classificador de anuros");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		chckbxPrunned = new JCheckBox("Unpruned");
		chckbxPrunned.setBounds(33, 94, 129, 23);
		frame.getContentPane().add(chckbxPrunned);
		
		JLabel lblNewLabel = new JLabel("Anuran classifier trough Anuran Calls");
		lblNewLabel.setBounds(107, 6, 217, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Family", "Genus", "Species"}));
		comboBox.setBounds(33, 161, 129, 23);
		frame.getContentPane().add(comboBox);
		
		JLabel lblChooseTheClass = new JLabel("Choose the classifier:");
		lblChooseTheClass.setBounds(33, 118, 154, 50);
		frame.getContentPane().add(lblChooseTheClass);
		
		JLabel lblCAlgorithTo = new JLabel("C4.5 algorith to generate a decision tree");
		lblCAlgorithTo.setBounds(96, 38, 228, 44);
		frame.getContentPane().add(lblCAlgorithTo);
		
		JLabel lblChooseThePercentage = new JLabel("Choose the percentage of the data");
		lblChooseThePercentage.setBounds(238, 94, 200, 50);
		frame.getContentPane().add(lblChooseThePercentage);
		
		JLabel lblToUseTo = new JLabel("to use to train the tree:");
		lblToUseTo.setBounds(272, 118, 129, 50);
		frame.getContentPane().add(lblToUseTo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"50%", "60%", "70%", "80%", "90%"}));
		comboBox_1.setBounds(282, 161, 92, 23);
		frame.getContentPane().add(comboBox_1);
        
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					boolean prun=App2.chckbxPrunned.isSelected();
					Tree t = new Tree(prun);
					String result=t.getResults();
					JPanel middlePanel = new JPanel ();
				    middlePanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Results" ) );

				    // create the middle panel components

				    JTextArea display = new JTextArea ( 16, 58 );
				    display.setEditable ( false ); // set textArea non-editable
				    JScrollPane scroll = new JScrollPane ( display );
				    display.setText(result);
				    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

				    //Add Textarea in to middle panel
				    middlePanel.add ( scroll );

				    // My code
				    JFrame frame = new JFrame ();
				    frame.getContentPane().add ( middlePanel );
				    frame.pack ();
				    frame.setLocationRelativeTo ( null );
				    frame.setVisible ( true );
				    
				    JFrame jf = new javax.swing.JFrame("Tree view");
	                jf.setSize(1920,1080);
	                jf.getContentPane().setLayout(new BorderLayout());
	                TreeVisualizer tv = null;
	                J48 tree = t.getTree();

	                tv = new TreeVisualizer(null,tree.graph(), new PlaceNode2());
	                jf.getContentPane().add(tv, BorderLayout.CENTER);
	                jf.addWindowListener(new java.awt.event.WindowAdapter() {
	                    public void windowClosing(java.awt.event.WindowEvent e) {
	                        jf.dispose();
	                    }
	                });

	                jf.setVisible(true);
	                tv.fitToScreen();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnGenerate.setBounds(107, 196, 200, 50);
		frame.getContentPane().add(btnGenerate);
		

		

		
		
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
			  
			  javax.swing.JSlider slider = new javax.swing.JSlider();
			  __wbp_panel.add(slider);
		}
	}
}
