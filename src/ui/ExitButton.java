package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;


public class ExitButton {
    private JButton exitButton;

    public ExitButton(JFrame window) {
        exitButton = new JButton();

        URL exitLocation = getClass().getResource("/resources/picture/ExitButton.png");
        if (exitLocation != null) {
            ImageIcon exitIcon = new ImageIcon(exitLocation);
            exitButton.setIcon(exitIcon);
        } else {
            System.err.println("ไม่พบไฟล์: ExitButton.png");
            exitButton.setText("Exit");
        }

        // กำหนดขนาดและตำแหน่งของปุ่ม Exit
        exitButton.setBounds(1550, 5, 140, 120);
        exitButton.setBackground(null);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(new ActionListener() {
            // เมื่อกดปุ่ม Exit จะเรียกใช้งาน ActionEvent
            @Override
            public void actionPerformed(ActionEvent e) {
                //เรียกใช้งาน JOptionPane แสดงข้อความยืนยันการออกจากเกม
                int result = JOptionPane.showConfirmDialog(window, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION); // แสดงข้อความยืนยันการออกจากเกม
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public JButton getExitButton() {
        return exitButton;
    }
}