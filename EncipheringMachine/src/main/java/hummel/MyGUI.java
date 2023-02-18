package main.java.hummel;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class MyGUI implements ActionListener {
	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JRadioButton radioButton;
	private String text = "";

	public MyGUI() {
		frame = new JFrame("My GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 0;
		JLabel label = new JLabel("Enter Text:");
		panel.add(label, constraints);

		constraints.gridx = 1;
		constraints.gridwidth = 2;
		textField = new JTextField(20);
		panel.add(textField, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		JLabel label2 = new JLabel("Load from File:");
		panel.add(label2, constraints);

		constraints.gridx = 1;
		radioButton = new JRadioButton();
		panel.add(radioButton, constraints);

		constraints.gridx = 2;
		JButton loadButton = new JButton("Load File");
		loadButton.addActionListener(this);
		panel.add(loadButton, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		JLabel label3 = new JLabel("Save to File:");
		panel.add(label3, constraints);

		constraints.gridx = 1;
		JButton saveButton = new JButton("Save File");
		saveButton.addActionListener(this);
		panel.add(saveButton, constraints);

		constraints.gridx = 2;
		JButton saveTextButton = new JButton("Save Text");
		saveTextButton.addActionListener(this);
		panel.add(saveTextButton, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		JLabel label4 = new JLabel("Output:");
		panel.add(label4, constraints);

		constraints.gridx = 1;
		constraints.gridwidth = 2;
		textArea = new JTextArea(10, 20);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane, constraints);

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Load File".equals(e.getActionCommand())) {
			JFileChooser fileChooser = new JFileChooser();
			int returnValue = fileChooser.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				try {
					BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
					String line = reader.readLine();
					while (line != null) {
						text += line + "\n";
						line = reader.readLine();
					}
					reader.close();
					textArea.setText(text);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		} else if ("Save File".equals(e.getActionCommand())) {
			JFileChooser fileChooser = new JFileChooser();
			int returnValue = fileChooser.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));
					writer.write(textArea.getText());
					writer.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		} else if ("Save Text".equals(e.getActionCommand())) {
			text = textField.getText();
			textArea.setText(text);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MyGUI();
			}
		});
	}
}