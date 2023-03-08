package hummel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class BSOD extends JFrame {
    public static void main(String[] arg) {
        EventQueue.invokeLater(() -> {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    try {
                        UIManager.setLookAndFeel(info.getClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                             UnsupportedLookAndFeelException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
            }
            JFrame frame = new BSOD();
            frame.setVisible(true);
        });
    }

    public BSOD() {
        try {
            InputStream imageStream = BSOD.class.getResourceAsStream("/resources/BSOD.jpg");
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            setResizable(false);
            setUndecorated(true);
            setAlwaysOnTop(true);
            setSize(Toolkit.getDefaultToolkit().getScreenSize());

            assert imageStream != null;

            BufferedImage originalImage = ImageIO.read(imageStream);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Image scaledImage = originalImage.getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);

            ImageIcon imageIcon = new ImageIcon(scaledImage);
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(0, 0, getWidth(), getHeight());
            add(imageLabel);

            setLocationRelativeTo(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}