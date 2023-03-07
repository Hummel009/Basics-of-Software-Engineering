package hummel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BSOD {
	public static void main(String[] args) {
		try {
			InputStream imageStream = BSOD.class.getResourceAsStream("/resources/BSOD.jpg");
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			frame.setResizable(false);
			frame.setUndecorated(true);
			frame.setAlwaysOnTop(true);
			frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());

			assert imageStream != null;

			BufferedImage originalImage = ImageIO.read(imageStream);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Image scaledImage = originalImage.getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);

			ImageIcon imageIcon = new ImageIcon(scaledImage);
			JLabel imageLabel = new JLabel(imageIcon);
			imageLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
			frame.add(imageLabel);

			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}