package entity;

import java.awt.*;
import java.net.URL;
import java.util.Random;
import javax.swing.*;


public class animeCast extends JPanel {
    private Image character;
    private int x = -2000; // ตำแหน่งเริ่มต้น
    private int y = 100; // ตำแหน่ง y
    private boolean isVisible = false; // ตัวละครปรากฏอยู่หรือไม่
    private Font orderFont = new Font("Serif", Font.PLAIN, 12); // กำหนดฟอนต์สำหรับการสั่งซื้อ
    private CustomDialog dialog = new CustomDialog(); // เพิ่มตัวแปร dialog
    private OrderMessage message;

    private final String[] characterList = { // Array รูปภาพตัวละคร
        "/resources/picture/ลูกค้า01.png",
        "/resources/picture/ลูกค้า02.png",
        "/resources/picture/ลูกค้า03.png",
        "/resources/picture/ลูกค้า04.png",
        "/resources/picture/ลูกค้า05.png",
        "/resources/picture/ลูกค้า06.png",
        "/resources/picture/ลูกค้า07.png",
        "/resources/picture/ลูกค้า08.png",
        "/resources/picture/ลูกค้า09.png",
        "/resources/picture/ลูกค้า10.png",
        "/resources/picture/ลูกค้า11.png",
        "/resources/picture/ลูกค้า12.png",
        "/resources/picture/ลูกค้า13.png",
        "/resources/picture/ลูกค้า14.png",
        "/resources/picture/ลูกค้า15.png",
        "/resources/picture/ลูกค้า16.png",
        "/resources/picture/ลูกค้า17.png",
        "/resources/picture/ลูกค้า18.png",
        "/resources/picture/ลูกค้า19.png",
        "/resources/picture/ลูกค้า20.png",
    };

    public animeCast() {
        setPreferredSize(new Dimension(500, 200)); // กำหนดขนาดของพื้นที่ที่ตัวละครจะวาดอยู่
        loadRandomCharacter();
        //OrderMessage orderMessage = OrderMessage.getInstance();
    }

    public void loadRandomCharacter() {
        Random random = new Random();
        int index = random.nextInt(characterList.length);
        URL characterLocation = getClass().getResource(characterList[index]);

        if (characterLocation != null) {
            character = new ImageIcon(characterLocation).getImage();
           // System.out.println("ตัวละครปรากฏอยู่ : "+ index);
        } else {
            System.err.println("ไม่พบไฟล์: " + characterList[index]);
        }
    }

    public void setVisible(boolean visible) {
        this.isVisible = visible; // ตั้งค่าตัวละครให้ปรากฏหรือไม่
        repaint(); // วาดใหม่เมื่อเปลี่ยนสถานะ
    }

    public void updatePosition(int newX, int newY) {
        this.x = newX; // อัปเดตตำแหน่ง x ของตัวละคร
        this.y = newY; // อัปเดตตำแหน่ง y ของตัวละคร
        repaint(); // วาดใหม่เพื่อให้เห็นการเปลี่ยนแปลง
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isVisible && character != null) {
            g.drawImage(character, x, y, this); // ใช้ตำแหน่ง x และ y ของตัวละคร
            dialog.setVisible(true);
            //dialog.setMessage(message.getMessage());
            //dialog.drawOrderBubble(g);
        } else {
            System.out.println("ตัวละครไม่สามารถแสดงได้");
            System.out.println("index : " + isVisible);
        }
    }
}