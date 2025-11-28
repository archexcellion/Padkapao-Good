package ui;

import java.awt.Color;
import java.net.URL;
import javax.swing.*;

public class PauseScene {
    private JLabel pauseScene;
    private JButton continueButton;
    private boolean isSoundOn = true;  // กำหนดให้เสียงเปิดเป็นเริ่มต้น

    public PauseScene(JFrame window) {
        // สร้าง JLabel สำหรับแสดงภาพพื้นหลัง
        pauseScene = new JLabel();
        
        // โหลดภาพพื้นหลังเกม
        URL pauseSceneLocation = getClass().getResource("/resources/picture/gamePause.png");
        if (pauseSceneLocation != null) {
            ImageIcon pauseSceneIcon = new ImageIcon(pauseSceneLocation);
            pauseScene.setIcon(pauseSceneIcon);
            System.out.println("แสดง scene หน้าหยุดเกม");
        } else {
            System.err.println("ไม่พบไฟล์: gamePause.png");
            pauseScene.setText("gamePause");
        }

        // กำหนดขนาดและตำแหน่งของ JLabel (เต็มหน้าจอ)
        pauseScene.setBounds(0, 0, window.getWidth(), window.getHeight());

        // สร้างปุ่ม Continue
        continueButton = new JButton("Continue");
        continueButton.setBounds(150, 200, 150, 50);
        continueButton.setBackground(Color.GREEN);
        continueButton.setForeground(Color.WHITE);
        continueButton.setBorderPainted(false);
        continueButton.setFocusPainted(false);
        continueButton.addActionListener(e -> {
            // เมื่อกด Continue ให้ลบ PauseScene และกลับไปเล่นต่อ
            System.out.println("กลับไปเล่นต่อ");

            // ลบ PauseScene ออกจาก LayeredPane
            JLayeredPane layeredPane = window.getLayeredPane();
            for (java.awt.Component comp : layeredPane.getComponents()) {
                if (comp instanceof JLabel || comp instanceof JButton) {
                    layeredPane.remove(comp);
                }
            }
            window.revalidate();
            window.repaint();

            // ทำให้เกมดำเนินต่อไปตามเวลาหรือกิจกรรมต่าง ๆ
            // ที่นี่สามารถเริ่มหรือคืนค่าการเล่นเกมที่ต้องการ
            // เช่น ทำให้เกมเริ่มเล่นต่อจากที่หยุด
        });

        // เพิ่มปุ่ม Continue ลงใน pauseScene
        pauseScene.add(continueButton);
    }

    // เมธอดนี้ใช้เพื่อคืนค่า JLabel ที่เป็นภาพพื้นหลัง
    public JLabel getPauseScene() {
        return pauseScene;
    }
}
