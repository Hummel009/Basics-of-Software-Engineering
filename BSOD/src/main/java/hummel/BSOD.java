package main.java.hummel;

import java.awt.Container;
import java.awt.Frame;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class BSOD extends JFrame {
	public static void main(String[] args) {
		new BSOD();
	}

	public BSOD() {
		setUndecorated(true);
		JComponent img = new JLabel(new ImageIcon(getClass().getResource("BSOD.jpg")));
		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);
		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(img));
		gl.setVerticalGroup(gl.createParallelGroup().addComponent(img));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		setVisible(true);
	}
}