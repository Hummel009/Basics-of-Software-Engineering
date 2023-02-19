package main.java.hummel;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FileEncryptionGUI extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldFilePath;
	private JTextField textFieldKeyword;
	private JTextField textFieldOutputPath;
	private JPasswordField passwordFieldKey;
	private JRadioButton rdbtnColumnMethod;
	private JRadioButton rdbtnVigenere;
	private JButton btnSelectFile;
	private JButton btnEncrypt;
	private JButton btnDecrypt;
	private JButton btnOutputPath;
	private File inputFile;
	private File outputFile;
	private String algorithm;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					FileEncryptionGUI frame = new FileEncryptionGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FileEncryptionGUI() {
        setTitle("File Encryption");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panelFile = new JPanel();
        contentPane.add(panelFile, BorderLayout.NORTH);

        JLabel lblFilePath = new JLabel("File path:");
        panelFile.add(lblFilePath);

        textFieldFilePath = new JTextField();
        panelFile.add(textFieldFilePath);
        textFieldFilePath.setColumns(20);

        btnSelectFile = new JButton("Select file");
        btnSelectFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectFile();
            }
        });
        panelFile.add(btnSelectFile);

        JPanel panelKey = new JPanel();
        contentPane.add(panelKey, BorderLayout.CENTER);
        panelKey.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblKeyword = new JLabel("Keyword:");
        panelKey.add(lblKeyword);

        textFieldKeyword = new JTextField();
        panelKey.add(textFieldKeyword);
        textFieldKeyword.setColumns(20);

        JLabel lblKey = new JLabel("Key:");
        panelKey.add(lblKey);

        passwordFieldKey = new JPasswordField();
        panelKey.add(passwordFieldKey);

        JLabel lblAlgorithm = new JLabel("Algorithm:");
        panelKey.add(lblAlgorithm);

        rdbtnColumnMethod = new JRadioButton("Column Method");
        rdbtnColumnMethod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                algorithm = "Column Method";
            }
        });
        panelKey.add(rdbtnColumnMethod);

        rdbtnVigenere = new JRadioButton("Vigenere");
        rdbtnVigenere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                algorithm = "Vigenere";
            }
        });
        panelKey.add(rdbtnVigenere);

        JPanel panelOutput = new JPanel();
        contentPane.add(panelOutput, BorderLayout.SOUTH);

        JLabel lblOutputPath = new JLabel("Output path:");
        panelOutput.add(lblOutputPath);

        textFieldOutputPath = new JTextField();
        panelOutput.add(textFieldOutputPath);
        textFieldOutputPath.setColumns(20);

        btnOutputPath = new JButton("Select path");
        btnOutputPath.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectOutputPath();
            }
        });
        panelOutput.add(btnOutputPath);

        JPanel panelButtons = new JPanel();
        contentPane.add(panelButtons, BorderLayout.EAST);
        panelButtons.setLayout(new GridLayout(0, 1, 0, 0));

        btnEncrypt = new JButton("Encrypt");
        btnEncrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                encryptFile();
            }
        });
        panelButtons.add(btnEncrypt);

        btnDecrypt = new JButton("Decrypt");
        btnDecrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decryptFile();
            }
        });
        panelButtons.add(btnDecrypt);
		setLocationRelativeTo(null);
    }

	private void selectFile() {
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			inputFile = fileChooser.getSelectedFile();
			textFieldFilePath.setText(inputFile.getAbsolutePath());
		}
	}

	private void selectOutputPath() {
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			outputFile = fileChooser.getSelectedFile();
			textFieldOutputPath.setText(outputFile.getAbsolutePath());
		}
	}

	private void encryptFile() {
		String keyword = textFieldKeyword.getText();
		String key = new String(passwordFieldKey.getPassword());
		String outputPath = textFieldOutputPath.getText();

		if (inputFile == null) {
			JOptionPane.showMessageDialog(this, "Please select a file to encrypt", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (keyword.isEmpty() || key.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please enter a keyword and key", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (outputPath.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please select an output path", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String inputText = readFile(inputFile);
		String outputText = "";

		if (algorithm.equals("Column Method")) {
			outputText = encryptColumnMethod(inputText, keyword);
		} else if (algorithm.equals("Vigenere")) {
			outputText = encryptVigenere(inputText, key);
		}

		writeFile(outputFile, outputText);

		JOptionPane.showMessageDialog(this, "Encryption complete", "Message", JOptionPane.INFORMATION_MESSAGE);
	}

	private void decryptFile() {
		String keyword = textFieldKeyword.getText();
		String key = new String(passwordFieldKey.getPassword());
		String outputPath = textFieldOutputPath.getText();

		if (inputFile == null) {
			JOptionPane.showMessageDialog(this, "Please select a file to decrypt", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (keyword.isEmpty() || key.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please enter a keyword and key", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (outputPath.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please select an output path", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String inputText = readFile(inputFile);
		String outputText = "";

		if (algorithm.equals("Column Method")) {
			outputText = decryptColumnMethod(inputText, keyword);
		} else if (algorithm.equals("Vigenere")) {
			outputText = decryptVigenere(inputText, key);
		}

		writeFile(outputFile, outputText);

		JOptionPane.showMessageDialog(this, "Decryption complete", "Message", JOptionPane.INFORMATION_MESSAGE);
	}

	private static String readFile(File file) {
		StringBuilder sb = new StringBuilder();

		try {
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				line = line.replaceAll("[^à-ÿÀ-ß]", "");
				sb.append(line);
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

	private static void writeFile(File file, String text) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(text);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String encryptColumnMethod(String text, String keyword) {
		StringBuilder sb = new StringBuilder();
		int[] key = new int[keyword.length()];
		int[] sortedKey = new int[keyword.length()];
		for (int i = 0; i < keyword.length(); i++) {
			key[i] = keyword.charAt(i) - 'à' + 1;
			sortedKey[i] = key[i];
		}
		Arrays.sort(sortedKey);
		for (int i = 0; i < text.length(); i += keyword.length()) {
			StringBuilder block = new StringBuilder();
			for (int j = 0; j < keyword.length() && i + j < text.length(); j++) {
				block.append(text.charAt(i + j));
			}
			for (int j = 0; j < keyword.length(); j++) {
				int index = -1;
				for (int k = 0; k < keyword.length(); k++) {
					if (key[k] == sortedKey[j]) {
						index = k;
						break;
					}
				}
				if (index >= block.length()) {
					sb.append(" ");
				} else {
					sb.append(block.charAt(index));
				}
			}
		}
		return sb.toString();
	}

	private static String decryptColumnMethod(String text, String keyword) {
		StringBuilder sb = new StringBuilder();
		int[] key = new int[keyword.length()];
		int[] sortedKey = new int[keyword.length()];
		for (int i = 0; i < keyword.length(); i++) {
			key[i] = keyword.charAt(i) - 'à' + 1;
			sortedKey[i] = key[i];
		}
		Arrays.sort(sortedKey);
		int blockLength = (int) Math.ceil((double) text.length() / keyword.length());
		for (int i = 0; i < blockLength; i++) {
			StringBuilder block = new StringBuilder();
			for (int j = 0; j < keyword.length(); j++) {
				int index = -1;
				for (int k = 0; k < keyword.length(); k++) {
					if (key[k] == sortedKey[j]) {
						index = k;
						break;
					}
				}
				if (i * keyword.length() + index < text.length()) {
					block.append(text.charAt(i * keyword.length() + index));
				}
			}
			sb.append(block.toString());
		}
		return sb.toString();
	}

	private static String decryptVigenere(String text, String key) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, j = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c >= 'à' && c <= 'ÿ') {
				int shift = key.charAt(j) - 'à';
				c = (char) ((c - 'à' + 33 - shift) % 33 + 'à');
				sb.append(c);
				j = (j + 1) % key.length();
			}
		}
		return sb.toString();
	}

	private static String encryptVigenere(String text, String key) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, j = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c >= 'à' && c <= 'ÿ') {
				int shift = key.charAt(j) - 'à';
				c = (char) ((c - 'à' + shift) % 33 + 'à');
				sb.append(c);
				j = (j + 1) % key.length();
			}
		}
		return sb.toString();
	}
}