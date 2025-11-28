package animation;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import entity.animeCast;

public class exitthescene extends JPanel {
    private int x = 60; // ตำแหน่งเริ่มต้นที่เข้าไปในฉากแล้ว
    private animeCast anime;  // ใช้แค่ animeCast

    public exitthescene(animeCast anime) {
        this.anime = anime;
        setPreferredSize(new Dimension(500, 300)); // กำหนดขนาดของพื้นที่ที่ตัวละครจะวาดอยู่
    }
    
    public void startMoving() {
        Timer moveTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (x < getWidth()) {  // ใช้ getWidth เพื่อให้ตัวละครเดินออกจากขอบขวาของพื้นที่
                    x += 3.5; // อัปเดตตำแหน่งตัวละคร
                    anime.updatePosition(x, 100); // อัปเดตตำแหน่งตัวละคร
                    repaint(); // วาดใหม่ทุกครั้ง
                } else {
                    moveTimer.cancel(); // หยุดเมื่อถึงจุดสุดท้าย
                }
            }
        };
        moveTimer.scheduleAtFixedRate(task, 0, 10); // อัปเดตทุก 10 ms
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // วาด anime
        if (anime != null) {
            anime.paint(g); // วาดตัวละคร
        }
    }
}
