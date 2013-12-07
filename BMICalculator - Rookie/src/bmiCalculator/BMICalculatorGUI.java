package bmiCalculator;

import java.awt.BorderLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class BMICalculatorGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldHeight;
	private JLabel lblHeightmetres;
	private JLabel lblWeight;
	private JTextField textFieldWeight;
	private JLabel lblBmi;
	private JTextField textFieldBMI;
	private JLabel lblCategory;
	private JButton btnFindOut;
	private JLabel lblFonisrookie;
	private JTextField textFieldCategory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMICalculatorGUI frame = new BMICalculatorGUI();
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
	public BMICalculatorGUI() {
		setResizable(false);
		setBackground(new Color(153, 204, 204));
		setForeground(Color.WHITE);
		setFont(new Font("Harlow Solid Italic", Font.PLAIN, 14));
		setTitle("Body Mass Index Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTextFieldHeight());
		contentPane.add(getLblHeightmetres());
		contentPane.add(getLblWeight());
		contentPane.add(getTextFieldWeight());
		contentPane.add(getLblBmi());
		contentPane.add(getTextFieldBMI());
		contentPane.add(getLblCategory());
		contentPane.add(getBtnFindOut());
		contentPane.add(getLblFonisrookie());
		contentPane.add(getTextFieldCategory());
	}private JTextField getTextFieldHeight() {
		if (textFieldHeight == null) {
			textFieldHeight = new JTextField();
			textFieldHeight.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldHeight.setBounds(139, 36, 46, 20);
			textFieldHeight.setColumns(10);
		}
		return textFieldHeight;
	}
	private JLabel getLblHeightmetres() {
		if (lblHeightmetres == null) {
			lblHeightmetres = new JLabel("Height (metres)");
			lblHeightmetres.setHorizontalAlignment(SwingConstants.CENTER);
			lblHeightmetres.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
			lblHeightmetres.setBounds(32, 36, 119, 20);
		}
		return lblHeightmetres;
	}
	private JLabel getLblWeight() {
		if (lblWeight == null) {
			lblWeight = new JLabel("Weight (kg)");
			lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
			lblWeight.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
			lblWeight.setBounds(52, 63, 86, 24);
		}
		return lblWeight;
	}
	private JTextField getTextFieldWeight() {
		if (textFieldWeight == null) {
			textFieldWeight = new JTextField();
			textFieldWeight.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldWeight.setBounds(139, 67, 46, 20);
			textFieldWeight.setColumns(10);
		}
		return textFieldWeight;
	}
	private JLabel getLblBmi() {
		if (lblBmi == null) {
			lblBmi = new JLabel("BMI");
			lblBmi.setHorizontalAlignment(SwingConstants.CENTER);
			lblBmi.setFont(new Font("Goudy Old Style", Font.BOLD, 16));
			lblBmi.setBounds(155, 114, 58, 24);
		}
		return lblBmi;
	}
	private JTextField getTextFieldBMI() {
		if (textFieldBMI == null) {
			textFieldBMI = new JTextField();
			textFieldBMI.setFont(new Font("Arial", Font.BOLD, 14));
			textFieldBMI.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldBMI.setEditable(false);
			textFieldBMI.setBounds(223, 114, 52, 26);
			textFieldBMI.setColumns(10);
		}
		return textFieldBMI;
	}
	private JLabel getLblCategory() {
		if (lblCategory == null) {
			lblCategory = new JLabel("Category");
			lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
			lblCategory.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
			lblCategory.setBounds(32, 162, 86, 20);
		}
		return lblCategory;
	}
	private JTextField getTextFieldCategory() {
		if (textFieldCategory == null) {
			textFieldCategory = new JTextField();
			textFieldCategory.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldCategory.setFont(new Font("Goudy Old Style", Font.BOLD, 13));
			textFieldCategory.setEditable(false);
			textFieldCategory.setBounds(139, 163, 221, 20);
			textFieldCategory.setColumns(10);
		}
		return textFieldCategory;
	}
	private JButton getBtnFindOut() {
		if (btnFindOut == null) {
			btnFindOut = new JButton("FIND OUT");
			btnFindOut.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
			btnFindOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						
					textFieldBMI.setBackground(Color.WHITE);
					textFieldCategory.setBackground(Color.WHITE);
						
					BMICalculator k = new BMICalculator();
					
					double height = Double.parseDouble(textFieldHeight.getText());
					double weight = Double.parseDouble(textFieldWeight.getText());
					double bmi1 = k.calculateBMI(weight, height);
					double bmi = (double) Math.round(bmi1*100)/100;
					
					if ((height < 1.0 || height > 3.0) && (weight < 15.0 || weight > 500.0)) {
						textFieldCategory.setText("Height and Weight are not in correct limits.");
						textFieldBMI.setText("Error!");	
						return;
					} else if (height < 1.0 || height > 3.0) {
						textFieldCategory.setText("Height is not in correct limits.");
						textFieldBMI.setText("Error!");
						return;
					}	else if (weight < 15.0 || weight > 500.0) {
						textFieldCategory.setText("Weight is not in correct limits.");
						textFieldBMI.setText("Error!");
						return;
					} else textFieldBMI.setText("" + bmi);
					
						if (bmi <= 15) {
							textFieldCategory.setText("Very severely underweight");
							textFieldCategory.setBackground(Color.RED);
						}
						if ((bmi > 15)&&(bmi <= 16))
							textFieldCategory.setText("Severely underweight");
						if ((bmi > 16)&&(bmi <= 18.5))
							textFieldCategory.setText("Underweight");
						if ((bmi > 18.5)&&(bmi <= 25)) {
							textFieldCategory.setText("Normal (healthy weight)");
							textFieldCategory.setBackground(Color.GREEN);
						}							
						if ((bmi > 25)&&(bmi <= 30))
							textFieldCategory.setText("Overweight");
						if ((bmi > 30)&&(bmi <= 35))
							textFieldCategory.setText("Obese Class I (Moderately obese)");
						if ((bmi > 35)&&(bmi <= 40))
							textFieldCategory.setText("Obese Class II (Severely obese)");
						if (bmi > 40){
							textFieldCategory.setText("Obese Class III (Very severely obese)");
							textFieldCategory.setBackground(Color.RED);
						}
				} catch (Exception error) {
						textFieldCategory.setText("Insert all input parameters.");
						textFieldCategory.setBackground(Color.RED);
						textFieldBMI.setText("Error");
						textFieldBMI.setBackground(Color.RED);
				}
				}
			});
			btnFindOut.setBounds(208, 36, 96, 51);
		}
		return btnFindOut;
	}
	private JLabel getLblFonisrookie() {
		if (lblFonisrookie == null) {
			lblFonisrookie = new JLabel("FONISRookie.2013");
			lblFonisrookie.setFont(new Font("Goudy Old Style", Font.ITALIC, 11));
			lblFonisrookie.setBounds(298, 208, 96, 14);
		}
		return lblFonisrookie;
	}
	
}
