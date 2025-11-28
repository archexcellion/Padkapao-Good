package sound;

import java.net.URL;
import javax.sound.sampled.*;
import ui.SoundButton; // นำเข้า SoundButton เพื่อใช้ isMuted()

public class PlayButSound {
    
    private Clip clip;  // เก็บอ้างอิงไปที่ Clip

    public PlayButSound(String soundPath, float volume) { 
        if (SoundButton.getInstance(null).isMuted()) return; // อันนี้ไม่ต้องเปลี่ยน

        try {
            // ตรวจสอบว่าไฟล์เสียงอยู่ในตำแหน่งที่ถูกต้อง
            URL soundURL = getClass().getResource(soundPath);
            if (soundURL != null) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
                clip = AudioSystem.getClip(); // ใช้ clip ที่เก็บเสียง
                clip.open(audioStream);

                // ตรวจสอบว่า clip รองรับการควบคุมระดับเสียงหรือไม่
                if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    // ปรับระดับเสียงระหว่าง -80 dB ถึง 6 dB
                    float dB = Math.min(Math.max(volume, -80.0f), 6.0f);
                    gainControl.setValue(dB);
                } else {
                   // System.err.println("ไม่สามารถควบคุมระดับเสียงของคลิปนี้ได้");
                }

                clip.start();
                // เล่นเสียงซ้ำถ้าจำเป็น
                //System.out.println("เล่นเสียงเรียบร้อย!");
                clip.loop(0); // 0 หมายถึงเล่นเสียงแค่ครั้งเดียว
            } else {
                System.err.println("ไม่พบไฟล์เสียง: " + soundPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ฟังก์ชันเพื่อหยุดเสียง
    public void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();  // หยุดเสียง
            System.out.println("เสียงถูกหยุดแล้ว!");
        }
    }
}
