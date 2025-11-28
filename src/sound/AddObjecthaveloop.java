package sound;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;
import javax.sound.sampled.*;
import ui.SoundButton; // นำเข้า SoundButton เพื่อใช้ isMuted()

public class AddObjecthaveloop {
    public AddObjecthaveloop(String soundPath, float volume) { 
        if (SoundButton.getInstance(null).isMuted()) return; // อันนี้ไม่ต้องเปลี่ยน

        try {
            // ตรวจสอบว่าไฟล์เสียงอยู่ในตำแหน่งที่ถูกต้อง
            URL soundURL = getClass().getResource(soundPath);
            if (soundURL != null) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);

                // ตรวจสอบว่า clip รองรับการควบคุมระดับเสียงหรือไม่
                if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    // ปรับระดับเสียงระหว่าง -80 dB ถึง 6 dB
                    float dB = Math.min(Math.max(volume, -80.0f), 6.0f);
                    gainControl.setValue(dB);
                } else {
                    System.err.println("ไม่สามารถควบคุมระดับเสียงของคลิปนี้ได้");
                }

                clip.start();
                clip.loop(4);
                // เล่นเสียงซ้ำถ้าจำเป็น
                System.out.println("เล่นเสียงเรียบร้อย!");
            } else {
                System.err.println("ไม่พบไฟล์เสียง: " + soundPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
