package ui;
import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class clockDisplays {
    private JButton clock;


    public clockDisplays(JFrame parentFrame) {
        clock.setBounds(0, -120, parentFrame.getWidth(), parentFrame.getHeight());
        parentFrame.add(clock);
        clock.setVisible(false);


        // Create hintButton
        clock = new JButton();
        URL clockUrl = getClass().getResource("/resources/picture/clock.png");
        if (clockUrl != null) {
            ImageIcon hintIcon = new ImageIcon(clockUrl);
            int originalWidth = hintIcon.getIconWidth();
            int originalHeight = hintIcon.getIconHeight();
            double newWidth = originalWidth / 1.5;
            double newHeight = originalHeight / 1.5;
            Image scaledImage = hintIcon.getImage().getScaledInstance((int) newWidth, (int) newHeight, Image.SCALE_SMOOTH);
            clock.setIcon(new ImageIcon(scaledImage));
        } else {
            System.err.println("ไม่พบไฟล์: clockUrl.png");
            clock.setText("clockUrl");
        }
        
        clock.setBounds(840, 0, 220, 220);
        clock.setBackground(null);
        clock.setContentAreaFilled(false);
        clock.setFocusPainted(false);
        clock.setBorderPainted(false);
        parentFrame.add(clock);
    }
    public JButton getButton(){
        return clock;
    }
}