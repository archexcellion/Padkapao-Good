package ui;
import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class ContinousButton {
    private JButton continou;
    private JFrame window;

    public ContinousButton(JFrame parentFrame, JFrame window) {
        this.window = window;
        
        // สร้างปุ่ม Continue ก่อน
        continou = new JButton();
        
        // โหลดภาพ
        URL continouUrl = getClass().getResource("/resources/picture/continueButton.png");
        if (continouUrl != null) {
            ImageIcon hintIcon = new ImageIcon(continouUrl);
            int originalWidth = hintIcon.getIconWidth();
            int originalHeight = hintIcon.getIconHeight();
            double newWidth = originalWidth / 1.5;
            double newHeight = originalHeight / 1.5;
            Image scaledImage = hintIcon.getImage().getScaledInstance((int) newWidth, (int) newHeight, Image.SCALE_SMOOTH);
            continou.setIcon(new ImageIcon(scaledImage));
        } else {
            System.err.println("ไม่พบไฟล์: continueButton.png");
            continou.setText("continueButton");
        }

        // กำหนดขนาดและตำแหน่งของปุ่ม
        continou.setBounds(840, 0, 220, 220);
        continou.setBackground(null);
        continou.setContentAreaFilled(false);
        continou.setFocusPainted(false);
        continou.setBorderPainted(false);

        // เพิ่ม ActionListener ที่ปุ่ม Continue
        continou.addActionListener(e -> {
            System.out.println("กลับไปเล่นต่อ");

            // เมื่อคลิกปุ่ม Continue จะลบ PauseScene ออก
            JLayeredPane innerLayeredPane = window.getLayeredPane();
            for (java.awt.Component comp : innerLayeredPane.getComponents()) {
                if (comp instanceof JLabel || comp instanceof JButton) {
                    innerLayeredPane.remove(comp);
                }
            }
            // เริ่มต้นการเล่นเกม
            window.revalidate();
            window.repaint();
        });
        
        // เพิ่มปุ่ม continue ลงใน parentFrame
        parentFrame.add(continou);
        continou.setVisible(false);  // ตั้งค่าไม่ให้แสดงตอนเริ่มต้น
    }

    public JButton getButton() {
        return continou;
    }
}