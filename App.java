package weka;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
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

public class App {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("IART-FEUP classificador de anuros");
		frame.setBounds(400, 400, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JCheckBox chckbxPrunned = new JCheckBox("Unprunned");
		chckbxPrunned.setBounds(53, 102, 129, 23);
		frame.getContentPane().add(chckbxPrunned);
		
		JLabel lblNewLabel = new JLabel("Anuran classifier trough Anuran Calls");
		lblNewLabel.setBounds(242, 12, 276, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Family", "Genus", "Species"}));
		comboBox.setBounds(45, 195, 161, 37);
		frame.getContentPane().add(comboBox);
		
		JLabel lblChooseTheClass = new JLabel("Choose the classifier");
		lblChooseTheClass.setBounds(21, 133, 315, 50);
		frame.getContentPane().add(lblChooseTheClass);
		
		JLabel lblCAlgorithTo = new JLabel("C4.5 algorith to generate a decision tree");
		lblCAlgorithTo.setBounds(227, 33, 361, 44);
		frame.getContentPane().add(lblCAlgorithTo);
		
		JLabel lblChooseThePercentage = new JLabel("Choose the percentage of the data");
		lblChooseThePercentage.setBounds(21, 254, 258, 50);
		frame.getContentPane().add(lblChooseThePercentage);
		
		JLabel lblToUseTo = new JLabel("to use to train the tree:");
		lblToUseTo.setBounds(21, 282, 258, 50);
		frame.getContentPane().add(lblToUseTo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"50%", "60%", "70%", "80%", "90%"}));
		comboBox_1.setBounds(53, 343, 92, 23);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblToGenerateThe = new JLabel("to generate the tree:");
		lblToGenerateThe.setBounds(21, 159, 315, 50);
		frame.getContentPane().add(lblToGenerateThe);
        
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Tree t = new Tree();
					String result=t.getResults();
					//results.setListData(listData);
					//results.append(result);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnGenerate.setBounds(41, 486, 200, 50);
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
