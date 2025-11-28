package ui;

import Main.GameManager;
import entity.CustomDialog;
import entity.OrderMessage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;
import sound.PlayButSound;

public class HintButton {
    private JButton hintButton;
    private JButton yesButton;
    private CustomDialog dialog;
    private OrderMessage orderMessage;
    private String firstMessage;
    private String hintMessage;

    public HintButton(JFrame parentFrame, GameManager gm) {
        dialog = new CustomDialog();
        dialog.setBounds(0, -120, parentFrame.getWidth(), parentFrame.getHeight());
        parentFrame.add(dialog);
        dialog.setVisible(false);

        orderMessage = OrderMessage.getInstance();
        hintMessage = orderMessage.getHint();
        firstMessage = orderMessage.getMessage();

        // Create hintButton
        hintButton = new JButton();
        URL hintLocation = getClass().getResource("/resources/picture/hintButton.png");
        if (hintLocation != null) {
            ImageIcon hintIcon = new ImageIcon(hintLocation);
            int originalWidth = hintIcon.getIconWidth();
            int originalHeight = hintIcon.getIconHeight();
            double newWidth = originalWidth / 1.5;
            double newHeight = originalHeight / 1.5;
            Image scaledImage = hintIcon.getImage().getScaledInstance((int) newWidth, (int) newHeight, Image.SCALE_SMOOTH);
            hintButton.setIcon(new ImageIcon(scaledImage));
        } else {
            System.err.println("ไม่พบไฟล์: hintButton.png");
            hintButton.setText("Hint");
        }
        
        hintButton.setBounds(840, 450, 220, 220);
        hintButton.setBackground(null);
        hintButton.setContentAreaFilled(false);
        hintButton.setFocusPainted(false);
        hintButton.setBorderPainted(false);
        hintButton.setVisible(false); // Initially hidden
        parentFrame.add(hintButton);

        // Create yesButton
        yesButton = new JButton();
        URL yesLocation = getClass().getResource("/resources/picture/yesButton.png");
        if (yesLocation != null) {
            ImageIcon yesIcon = new ImageIcon(yesLocation);
            int originalWidth = yesIcon.getIconWidth();
            int originalHeight = yesIcon.getIconHeight();
            double newWidth = originalWidth / 1.5;
            double newHeight = originalHeight / 1.5;
            Image scaledImage = yesIcon.getImage().getScaledInstance((int) newWidth, (int) newHeight, Image.SCALE_SMOOTH);
            yesButton.setIcon(new ImageIcon(scaledImage));
        } else {
            System.err.println("ไม่พบไฟล์: yesButton.png");
            yesButton.setText("Yes");
        }

        yesButton.setBounds(1090, 450, 220, 119);
        yesButton.setBackground(null);
        yesButton.setContentAreaFilled(false);
        yesButton.setFocusPainted(false);
        yesButton.setBorderPainted(false);

        yesButton.setVisible(false);
        parentFrame.add(yesButton);

        // Setup action for hintButton
        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlayButSound("/resources/audio/startgame.wav",6.0f); 
                if (hintMessage == null || hintMessage.isEmpty()) {
                    System.out.println("ข้อความว่าง");
                } else {
                    dialog.setMessage(hintMessage);
                    dialog.startTypingEffect(hintMessage);
                    dialog.setVisible(true);
                    System.out.println("แสดงข้อความ: " + hintMessage);
                }
            }
        });

        yesButton.setActionCommand("goSelectIngScreen");

        yesButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlayButSound("/resources/audio/startgame.wav",6.0f); 
                // รีเซ็ตปุ่มและข้อความก่อนไปหน้าถัดไป
                // resetButtons();
                // resetDialog(parentFrame);

                // ซ่อน dialog และปุ่ม
                dialog.setVisible(false);
                hintButton.setVisible(false);
                yesButton.setVisible(false);
                
                //System.out.println("ปิดข้อความและปุ่ม");

                gm.aHandler.actionPerformed(e); // เรียก actionPerformed ของ GameManager เพื่อไปหน้าถัดไป
            }
        });
        
        

        // Show hintButton and yesButton after a delay
        Timer showButtonsTimer = new Timer(1900, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hintButton.setVisible(true);
                yesButton.setVisible(true);
                System.out.println("แสดงปุ่ม hintButton และ yesButton");
            }
        });
        showButtonsTimer.setRepeats(false);
        showButtonsTimer.start();

        // Show the first message in CustomDialog after a delay
        Timer messageTimer = new Timer(1800, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCustomDialog(firstMessage); // Show the first message
                dialog.startTypingEffect(firstMessage);
            }
        });
        messageTimer.setRepeats(false);
        messageTimer.start();
    }

    public void showCustomDialog(String message) {
        dialog.setMessage(message); // Set the message for the dialog
        dialog.setVisible(true); // Show dialog
        dialog.revalidate();
        dialog.repaint();
        System.out.println("แสดงข้อความเริ่มต้น: " + message);
    }
    public JButton getHintButton() {
        return hintButton;
    }

    public JButton getYesButton() {
        return yesButton;
    }

    // ฟังก์ชันรีเซ็ตปุ่ม
    public void resetButtons() {
        hintButton.setVisible(false);  // ซ่อน whatButton
        yesButton.setVisible(false);   // ซ่อน yesButton
    }

    // ฟังก์ชันรีเซ็ต CustomDialog
    public void resetDialog(JFrame parentFrame) {
        dialog.setVisible(false);  // ซ่อน dialog
        dialog.setMessage("");     // รีเซ็ตข้อความใน dialog
        dialog.revalidate();
        dialog.repaint();
    }
    public void visibleDialog(boolean visible) {
        if (visible) {
            if (dialog.getMessage() == null || dialog.getMessage().isEmpty()) {
                dialog.setMessage(firstMessage); // โหลดข้อความเริ่มต้นถ้าไม่มีข้อความก่อนหน้า
            }
            dialog.setVisible(true);
            hintButton.setVisible(true);
            yesButton.setVisible(true);
        } else {
            dialog.setVisible(false);
            hintButton.setVisible(false);
            yesButton.setVisible(false);
        }
    }
    public boolean isVisible() {
        return dialog.isVisible() || hintButton.isVisible() || yesButton.isVisible();
    }
    
}