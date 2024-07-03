package EdgarItzak.PasswordGenerator;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


public class MainFrame extends JFrame {

	//constructor
	public MainFrame() {
		getContentPane().setLayout(null);
		//Title
		JLabel label1_Title= new JLabel("Select options for your password then click the Generate button!");
		label1_Title.setBounds(50, 11, 434, 30);
		getContentPane().add(label1_Title);
		//TextField Password length
		JLabel label2_PassLen = new JLabel("Select password length");
		label2_PassLen.setBounds(50, 62, 169, 20);
		getContentPane().add(label2_PassLen);
		
		JSpinner spinnerPassLen = new JSpinner();
		spinnerPassLen.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		spinnerPassLen.setBounds(60,93,40,23);
		getContentPane().add(spinnerPassLen);		
		//Check box
		JLabel label3_CheckboxOptions = new JLabel("Select at least 1 option:");
		label3_CheckboxOptions.setBounds(50,129,150,20);
		getContentPane().add(label3_CheckboxOptions);
		
		JCheckBox chckbxLowercase = new JCheckBox("Include lowercase");
		chckbxLowercase.setBounds(60, 154, 197, 23);
		getContentPane().add(chckbxLowercase);
		
		JCheckBox chckbxUppercase = new JCheckBox("Include uppercase");
		chckbxUppercase.setBounds(60, 180, 197, 23);
		getContentPane().add(chckbxUppercase);
		
		JCheckBox chckbxDigits = new JCheckBox("Include Digits");
		chckbxDigits.setBounds(60, 206, 197, 23);
		getContentPane().add(chckbxDigits);
		
		JCheckBox chckbxSpecialChars = new JCheckBox("Include Special Characters");
		chckbxSpecialChars.setBounds(60, 231, 197, 23);
		getContentPane().add(chckbxSpecialChars);
		
		
		JLabel label4_CustomSpecial= new JLabel("Custom Special Characters");
		label4_CustomSpecial.setBounds(90, 255, 197, 23);
		label4_CustomSpecial.setVisible(false);
		getContentPane().add(label4_CustomSpecial);
		
		JTextField textfieldCustomSpecial = new JTextField();
		textfieldCustomSpecial.setBounds(255, 255, 90, 22);
		textfieldCustomSpecial.setVisible(false);
		getContentPane().add(textfieldCustomSpecial);
		
		JLabel label5_PasswordText = new JLabel("");
		label5_PasswordText.setBounds(60, 300, 250, 25);
		getContentPane().add(label5_PasswordText);
		
		JLabel label6_PasswordOutput = new JLabel("");
		label6_PasswordOutput.setBounds(165, 300, 300, 25);
		getContentPane().add(label6_PasswordOutput);
		
		//EVENT CHECKBOX
		chckbxSpecialChars.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				if (chckbxSpecialChars.isSelected()) {
					label4_CustomSpecial.setVisible(true);
					textfieldCustomSpecial.setVisible(true);
				}
				if (!chckbxSpecialChars.isSelected()) {
					label4_CustomSpecial.setVisible(false);
					textfieldCustomSpecial.setVisible(false);
				}
			}
		});
		
		//BUTTON
		JButton btnGenerateBtn = new JButton("Generate");
		btnGenerateBtn.setBounds(334, 300, 100, 23);
		btnGenerateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label6_PasswordOutput.setText("");
				if (chckbxLowercase.isSelected() || chckbxUppercase.isSelected() || chckbxDigits.isSelected() || chckbxSpecialChars.isSelected()) {
					String password;
					password = PasswordGenerator.generatePassword((int) spinnerPassLen.getValue(), chckbxLowercase.isSelected(), chckbxUppercase.isSelected(), chckbxDigits.isSelected(), chckbxSpecialChars.isSelected(), textfieldCustomSpecial.getText());
					label5_PasswordText.setForeground(Color.BLACK);
					label6_PasswordOutput.setForeground(Color.BLACK);
					label5_PasswordText.setText("Your password is: ");
					label6_PasswordOutput.setText(password);
				} else {
					label5_PasswordText.setForeground(Color.RED);
					label5_PasswordText.setText("Select at least 1 checkbox");
				}
			}
		});
		getContentPane().add(btnGenerateBtn);
		
		JLabel label7_ClipboadSave = new JLabel("");
		label7_ClipboadSave.setBounds(60, 400, 300, 23);
		getContentPane().add(label7_ClipboadSave);
		
		
		//CLIPBOARD BUTTON
		JButton btnCoppyToClipboard = new JButton("Copy to Clipboard");
		btnCoppyToClipboard.setBounds(20,350,140,23);
		btnCoppyToClipboard.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (label6_PasswordOutput.getText().length()>0) {
					JOptionPane.showMessageDialog(null, "Success");
					StringSelection selection = new StringSelection(label6_PasswordOutput.getText());
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(selection, selection);
					label7_ClipboadSave.setForeground(Color.GREEN);
					label7_ClipboadSave.setText("Successfully copied to clipboard");
				} else {
					label7_ClipboadSave.setForeground(Color.RED);
					label7_ClipboadSave.setText("Please Generate a Password");
				}
			}
		});
		getContentPane().add(btnCoppyToClipboard);
		

		//SaveToFileButton		
		JButton btnSaveToFile = new JButton("Save password in File");
		btnSaveToFile.setBounds(180,350,160,23);
		btnSaveToFile.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (label6_PasswordOutput.getText().length()>0) {
					JOptionPane.showMessageDialog(null, "Success");
					fileHandler.writeToFile(label6_PasswordOutput.getText());
					label7_ClipboadSave.setForeground(Color.GREEN);
					label7_ClipboadSave.setText("File saved");
				} else {
					label7_ClipboadSave.setForeground(Color.RED);
					label7_ClipboadSave.setText("Please Generate a Password");
				}
			}
		});
		getContentPane().add(btnSaveToFile);
	}
	
	
	public static void main(String[] ar) {
		MainFrame fr = new MainFrame();
		fr.setBounds(10, 10, 500, 500);
		fr.setResizable(false);
		fr.setAlwaysOnTop(false);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setTitle("Password Generator");
	}
}